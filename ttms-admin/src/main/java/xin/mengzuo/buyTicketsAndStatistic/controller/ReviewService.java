package xin.mengzuo.buyTicketsAndStatistic.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xin.mengzuo.config.TtmsResult;
@FeignClient(value="buyTicekt",fallback=ReviewServiceImp.class)
public interface ReviewService {
	  /**
     * 添加评论
     * @author 左利伟
     */
	@RequestMapping(value = "/review/add",method = RequestMethod.GET)
	public TtmsResult addReview(@RequestBody Review review);
	/**
	 * 按照电影Id查找评论
	 * @author 左利伟
	 */
	@RequestMapping(value = "/review/find/{movieId}",method = RequestMethod.GET)
	public TtmsResult findReview(@PathVariable("movieId") String movieId);
	
}
