package xin.mengzuo.business.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import xin.mengzuo.business.pojo.DayStatist;
import xin.mengzuo.business.pojo.MouthStatist;
/**
 * 
 * @author 左利伟
 *
 */
public interface DayStatistRepository extends JpaRepository<DayStatist
, Integer>{
	/**
	 *根据电影id 和月份查找月统计
	 * @author 左利伟
	 */
	DayStatist findByMovieIdAndDateDay(String movieId,String dateDay);
	/**
	 * 按日统计按照单日票房排序
	 * @author 左利伟
	 */
	List<DayStatist> findByDateDayOrderMouthMoneyDesc(String dateDay);
	/**
	 * 查找电影,按日排序
	 * @author 左利伟
	 */
	List<DayStatist> findByMovieIdOrderDateDesc(String movieId);
/**
 * 查找所有日子
 * @author 左利伟
 */
	@Query(value="SELECT DISTINCT date_day FROM day_statist;",nativeQuery=true)
   List<String> findDateDay();
 	
	
}
