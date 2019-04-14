package xin.mengzuo.ticketmanager.service;

import java.util.List;
import java.util.Map;

import xin.mengzuo.ticketmanager.pojo.Schedule;
import xin.mengzuo.ticketmanager.pojo.Studio;


/**
 * 
 * @author 左利伟
 *
 */
public interface ScheduleService {
	
	void addScheduleList(List<Schedule> list, 
			Map<Integer,Studio> studioMap);
}
