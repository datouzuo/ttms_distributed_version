package xin.mengzuo.ticketmanager.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xin.mengzuo.ticketmanager.config.DateToMillsByDayUtil;
import xin.mengzuo.ticketmanager.config.TtmsResult;
import xin.mengzuo.ticketmanager.pojo.MovieStutas;
import xin.mengzuo.ticketmanager.pojo.Schedule;
import xin.mengzuo.ticketmanager.pojo.Studio;
import xin.mengzuo.ticketmanager.service.ScheduleService;

/**
 * 演出计划
 * 根据比重自动生成演出计划
 * @author 左利伟
 *
 */
@RestController
public class ScheduleController {
	@Autowired
  private ScheduleService sdule;
	/**
	 * list格式，电影id，比重，票价,时长
	 * studio;key:studioId，value为演出厅
	 * @author 左利伟
	 */
@RequestMapping("/admin/schedule/creatSchedule")
public TtmsResult creatSchedule(List<String> scheduleList,Map<Integer,Studio> studio,int day) {
	long time = DateToMillsByDayUtil.getStartMillsByDay(day);
	Integer studioCount =studio.keySet().size();//演出厅个数
	Integer allCount = studio.keySet().size()*6;//一天大概能放电影的总数
	//存储电影Id和电影的一些数
	Map<String, MovieStutas> movieIdStatus = new HashMap<>();
	for(String s:scheduleList) {
		MovieStutas ms= new MovieStutas();
		String[] threeS = s.split(",");
          String movieId = threeS[0];
         ms.setPoint(Integer.valueOf(threeS[1]));
          ms.setPrice(Integer.valueOf(threeS[2]));
          ms.setDuration(Integer.valueOf(threeS[3]));
          ms.setCount((int) Math.round((Integer.valueOf(threeS[1])*allCount)/100.00));
         movieIdStatus.put(movieId, ms); 
	}
	//key为studioId，value一天影片放映时间早上9:00到23:00营业为840分钟
	Map<Integer,Integer> studioIndex = new HashMap<>();
  
	for(Integer StudioId:studio.keySet()) {
		studioIndex.put(StudioId,840 );
		
	}
	//得到stidoId
	Set<Integer> studioIdSet = studioIndex.keySet();
	//得到movieId
	Set<String> movieIdSet = movieIdStatus.keySet();
	//
	List<Schedule> scheduleSet = new LinkedList<>();
	Random rand = new Random();
	while(studioIdSet.size()>0||scheduleSet.size()>0) {
		//获得随机的电影Id
		int moindex = rand.nextInt(movieIdSet.size());
		int i=0;  
		 String moiveId=null;
		for (String e : movieIdSet) {
	            if(i==moindex){
	           moiveId  = e;
	            }
	            i++;
	        }
		//获得随机演出厅Id
		int stindex = rand.nextInt(studioIdSet.size());
		int j=0;   
		Integer stdioId=null;
		for (Integer e : studioIdSet) {
	            if(j==stindex){
	             stdioId = e;
	            }
	            j++;
	        }
		//新的演出计划
		Schedule sche = new Schedule();
		sche.setMovieId(moiveId);
		sche.setStudioId(stdioId);
		sche.setTickerPrice(movieIdStatus.get(moiveId).getPrice());
		//此时这个演出厅还有多少时间
		Integer thisCount = studioIndex.get(stdioId);
		//电影开始时间
	Long movieStart =(840-thisCount)*60000+time;
	//电影结束时间
	Long movieEnd = movieStart+movieIdStatus.get(moiveId).getDuration()*60000;
	sche.setSchedStartTime(movieStart);
	sche.setSchedEndTime(movieEnd);
	//影厅隔20分钟才能放下个电影
	Integer updataCount = thisCount - 20-movieIdStatus.get(moiveId).getDuration();
	
	if(updataCount<=0) {
		studioIdSet.remove(stdioId);
	}else {
		studioIndex.put(stdioId, updataCount);
	}
	//获得电影场数
	Integer thisMovieCount = movieIdStatus.get(moiveId).getCount();
	Integer updataMovieCount = thisMovieCount-1;
	
	if(updataMovieCount==0) {
		movieIdSet.remove(moiveId);
	}else {
		movieIdStatus.get(moiveId).setCount(updataMovieCount);
	}
	scheduleSet.add(sche);
	
	}
	
	sdule.addScheduleList(scheduleSet, studio);
	//查找刚生成的电影场次，从早9:00到23:00的时间
	List<Schedule> sclist = sdule.findThisSchedule(time, time+60000*14*60);
	return TtmsResult.ok(sclist);
	
}
/**
 * 顾客根据电影和当前时间查找电影场次(今天）
 */
@RequestMapping("/cusLongin/findThisSchedule/{movieId}")
   public TtmsResult getThisSchedule(@PathVariable String movieId){
	 Calendar calen = Calendar.getInstance(TimeZone.getTimeZone("GMT+:08:00"));
	 //当前时间加10分钟
	 long startMillis = calen.getTimeInMillis()+10*60000;  
	 long endMills = DateToMillsByDayUtil.getEndMillsByDay(0);
	 List<Schedule> idAndTime = sdule.findScheduleByIdAndTime(startMillis, endMills, movieId);
	 
	 
	   return TtmsResult.ok(idAndTime);
   }
	/**
	 * 相对于今天的第几天的场次
	 */
@RequestMapping("/cusLongin/findOtherDaySchedule/{day}/{movieId}")
public TtmsResult getOtherDaySchedule(@PathVariable int day,@PathVariable String movieId) {
	long startMillsByDay = DateToMillsByDayUtil.getStartMillsByDay(day);
	long endMillsByDay = DateToMillsByDayUtil.getEndMillsByDay(day);
	List<Schedule> idAndTime = sdule.findScheduleByIdAndTime(startMillsByDay,
			endMillsByDay, movieId);
	   return TtmsResult.ok(idAndTime);
}

}