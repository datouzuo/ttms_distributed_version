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

import xin.mengzuo.buyTicketsAndStatistic.config.TtmsResult;
import xin.mengzuo.buyTicketsAndStatistic.pojo.Review;
@RestController
public class ReviewController {
    @Autowired
    private MongoTemplate mongoTemplate;
    /**
     * 添加评论
     * @author 左利伟
     */
	@RequestMapping("/review/add")
	public TtmsResult addReview(Review review) {
		Calendar calen = 
				Calendar.getInstance(TimeZone.getTimeZone("GMT+:08:00"));
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = dateformat.format(calen.getTimeInMillis());
	     review.setDate(dateStr);
	   mongoTemplate.insert(review);
	}
	/**
	 * 按照电影Id查找评论
	 * @author 左利伟
	 */
	@RequestMapping("/review/find/{movieId}")
	public TtmsResult findReview(String movieId) {		
		TtmsResult.ok(mongoTemplate.findByMovieId(movieId,Review.class));
		
	}
	
}
