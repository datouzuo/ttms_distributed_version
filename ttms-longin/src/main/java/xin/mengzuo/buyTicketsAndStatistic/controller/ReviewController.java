package xin.mengzuo.buyTicketsAndStatistic.controller;
/**
 * 评论接口
 * @author 左利伟
 *
 */

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xin.mengzuo.config.TtmsResult;

@RestController
public class ReviewController {
   @Autowired
	private ReviewService re;
	/**
     * 添加评论
     * @author 左利伟
     */
	@RequestMapping("/review/add")
	public TtmsResult addReview(Review review) {
		return re.addReview(review);
	}
	/**
	 * 按照电影Id查找评论
	 * @author 左利伟
	 */
	@RequestMapping("/review/find/{movieId}")
	public TtmsResult findReview(String movieId) {		
		return re.findReview(movieId);
		
	}
	
}
