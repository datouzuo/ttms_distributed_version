package xin.mengzuo.business.statistics;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import xin.mengzuo.business.config.DateUtil;
import xin.mengzuo.business.pojo.DayStatist;
import xin.mengzuo.business.pojo.MouthStatist;
import xin.mengzuo.business.service.StatistService;
import xin.mengzuo.business.service.StatistServiceImp;

@EnableBinding(StaticSink.class)
public class ReciverStatic {
	@Autowired
	private StatistService Statist;
	
	@StreamListener(StaticSink.INPUT)
	public void recver(String staticis) throws ParseException {
		String[] total = staticis.split(",");
		//时间，电影Id，总钱，||进行统计票数
		//时间格式:yyyy-MM-dd HH:mm:ss
		//封装成天
	    DayStatist dayS = new DayStatist();
	    dayS.setDate(DateUtil.getMouthDay(total[0]));
	    dayS.setMovieId(total[1]);
	    dayS.setDayMoney(Double.parseDouble(total[2]));
	    dayS.setDateDay(DateUtil.getDateMouthDay(total[0]));
	  
	  //封装成月统计  
	    MouthStatist mouS = new MouthStatist();
	   mouS.setDate(DateUtil.getMouth(total[0]));
	   mouS.setMovieId(total[1]);
	   mouS.setMouthMoney(Double.parseDouble(total[2]));
	    Statist.saveStatis(dayS, mouS); 
		
	}
	
	
}
