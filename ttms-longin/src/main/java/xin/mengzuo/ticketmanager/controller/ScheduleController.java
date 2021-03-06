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

import xin.mengzuo.config.TtmsResult;
import xin.mengzuo.studiomanager.controller.Studio;
import xin.mengzuo.studiomanager.controller.StudioService;



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
	@Autowired
	private StudioService ss;

	
/**
 * 顾客根据电影和当前时间查找电影场次(今天）
 */
@RequestMapping("/cusLongin/findThisSchedule/{movieId}")
   public TtmsResult getThisSchedule(@PathVariable String movieId){
	 
	 
	   return TtmsResult.ok(sdule.getThisSchedule(movieId));
   }
	/**
	 * 相对于今天的第几天的场次
	 */
@RequestMapping("/cusLongin/findOtherDaySchedule/{day}/{movieId}")
public TtmsResult getOtherDaySchedule(@PathVariable int day,@PathVariable String movieId) {

	   return TtmsResult.ok(sdule.getOtherDaySchedule(day, movieId));
}

}