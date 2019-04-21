package xin.mengzuo.business.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xin.mengzuo.config.TtmsResult;

@FeignClient(value="statist",fallback=StatistServiceImp.class)
public interface StatistService {
	@RequestMapping(value ="/statist/findByDateDay/{dateDay}",method=RequestMethod.GET)
	public TtmsResult findByDateDay(@PathVariable("dateDay") String dateDay);
	/**
	 * 查找电影所有日子票房
	 * @author 左利伟
	 */
	@RequestMapping(value ="/static/findByMovie/{movieId}",method=RequestMethod.GET)
	public TtmsResult findByMovieId(@PathVariable("movieId") String movieId);
	/**
	 * 得到所有日子
	 * @author 左利伟
	 */
	@RequestMapping(value="/static/findDateDay",method=RequestMethod.GET)
	public TtmsResult findDateDay();
	/**
	 * 按月统计票房
	 * @author 左利伟
	 */
	@RequestMapping(value = "/statist/findByDateMouth/{dateMouth}",method=RequestMethod.GET)
	public TtmsResult findByDateMouth(@PathVariable("dateMouth") String dateMouth);
	/**
	 * 查找所有的月分
	 * @author 左利伟
	 */
	@RequestMapping(value = "/static/findDateMouth",method = RequestMethod.GET)
	public TtmsResult findDateMouth();
}
