package xin.mengzuo.business.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xin.mengzuo.business.config.TtmsResult;
import xin.mengzuo.business.pojo.DayStatist;
import xin.mengzuo.business.pojo.MouthStatist;
import xin.mengzuo.business.service.StatistService;

@RestController
public class StaticController {
@Autowired
	private StatistService ss;
/**
 * 按日得到所有票房	
 * @author 左利伟
 */
@RequestMapping(value ="/statist/findByDateDay/{dateDay}")
public TtmsResult findByDateDay(@PathVariable String dateDay)
	{
		return TtmsResult.ok(ss.findByDateDayOrderMouthMoneyDesc(dateDay));
		
	}
/**
 * 查找电影所有日子票房
 * @author 左利伟
 */
@RequestMapping(value ="/static/findByMovie/{movieId}")
public TtmsResult findByMovieId(String movieId) {
	return TtmsResult.ok(ss.findByMovieIdOrderDateDesc(movieId));
}
/**
 * 得到所有日子
 * @author 左利伟
 */
@RequestMapping(value="/static/findDateDay")
public TtmsResult findDateDay(){
	return TtmsResult.ok(ss.findDateDay());
}
/**
 * 按月统计票房
 * @author 左利伟
 */
@RequestMapping(value = "/statist/findByDateMouth/{dateMouth}")
public TtmsResult findByDateMouth(@PathVariable String dateMouth) {
	return TtmsResult.ok(ss.findByDateMouthOrderMouthMoneyDesc(dateMouth));
	
	
}
/**
 * 查找所有的月分
 * @author 左利伟
 */
@RequestMapping("/static/findDateMouth")
public TtmsResult findDateMouth(){
	return TtmsResult.ok(ss.findDateMouth());
}
}
