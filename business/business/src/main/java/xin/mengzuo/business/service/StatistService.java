package xin.mengzuo.business.service;

import java.awt.print.Pageable;
import java.util.List;

import xin.mengzuo.business.pojo.DayStatist;
import xin.mengzuo.business.pojo.MouthStatist;

/**
 * 统计接口类
 * @author 左利伟
 *
 */
public interface StatistService {
	/**
	 * 保存统计
	 * @author 左利伟
	 */
	void saveStatis(DayStatist dayS,MouthStatist mouS);
	/**
	 * 按日查找
	 * @author 左利伟
	 */
	List<DayStatist> findByDateDayOrderMouthMoneyDesc(String dateDay);
/**
 * 查电影
 */
	List<DayStatist> findByMovieIdOrderDateDesc(String movieId);
	/**
	 * 获得所有日子
	 * @author 左利伟
	 */
	List<String> findDateDay();
	
	/**
	 * 按月分获取所有天数
	 * @author 左利伟
	 */
	List<MouthStatist> findByDateMouthOrderMouthMoneyDesc(String dateMouth);

/**
 * 按获得所有月份
 * @author 左利伟
 */
	List<String> findDateMouth();
}
