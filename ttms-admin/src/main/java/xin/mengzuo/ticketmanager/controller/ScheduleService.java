package xin.mengzuo.ticketmanager.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import xin.mengzuo.config.TtmsResult;
import xin.mengzuo.studiomanager.controller.SeatService;
import xin.mengzuo.studiomanager.controller.Studio;
@FeignClient(value="schedule-ticket",fallback=ScheduleServiceImp.class)
public interface ScheduleService {
	@RequestMapping(value = "/admin/schedule/creatSchedule",method = RequestMethod.GET)
	public TtmsResult creatSchedule(@RequestParam("scheduleList") List<String> scheduleList,@RequestParam("studio") Map<Integer,Studio> studio,@RequestParam("day") int day);
	
		
	/**
	 * 顾客根据电影和当前时间查找电影场次(今天）
	 */
	@RequestMapping("/cusLongin/findThisSchedule/{movieId}")
	   public TtmsResult getThisSchedule(@PathVariable("movieId") String movieId);
		/**
		 * 相对于今天的第几天的场次
		 */
	@RequestMapping("/cusLongin/findOtherDaySchedule/{day}/{movieId}")
	public TtmsResult getOtherDaySchedule(@PathVariable("day") int day,@PathVariable("movieId") String movieId);

}
