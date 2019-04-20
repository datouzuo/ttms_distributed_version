package xin.mengzuo.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import xin.mengzuo.business.pojo.MouthStatist;

public interface MouthStatistRepository extends JpaRepository<MouthStatist, Integer>{
	/**
	 *根据电影id 和月份查找月统计
	 * @author 左利伟
	 */
	MouthStatist findByMovieIdAndDateMouth(String movieId,String dateMouth);
	/**
	 * 按月分查找统计
	 * @author 左利伟
	 */
	List<MouthStatist> findByDateMouthOrderMouthMoneyDesc(String dateMouth);
/**
 * 查找所有存在的月份
 * @author 左利伟
 */
	@Query(value="SELECT DISTINCT date_mouth FROM mouth_statist;",nativeQuery=true)
	   List<String> findDateMouth();
}
