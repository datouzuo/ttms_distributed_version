package xin.mengzuo.ticketmanager.service;

import java.util.List;
import java.util.Map;

import xin.mengzuo.ticketmanager.pojo.Schedule;
import xin.mengzuo.ticketmanager.pojo.Studio;
import xin.mengzuo.ticketmanager.pojo.Ticket;


/**
 * 
 * @author 左利伟
 *
 */
public interface ScheduleService {
	/**
	 * 添加电影场次
	 * @author 左利伟
	 */
	void addScheduleList(List<Schedule> list, 
			Map<Integer,Studio> studioMap);
	//查询指定时间的所有电影场次
	List<Schedule> findThisSchedule(Long startTime,Long endTime);
 //查询指定时间指定，指定电影场次
	List<Schedule> findScheduleByIdAndTime(Long startTime,Long endTime,String movieId);
//查询顾客买的票
	List<Ticket> findInTicketIds(List ticketId);
	
}
