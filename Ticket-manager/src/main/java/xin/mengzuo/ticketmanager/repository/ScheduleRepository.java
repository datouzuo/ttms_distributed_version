package xin.mengzuo.ticketmanager.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import xin.mengzuo.ticketmanager.pojo.Schedule;
/**
 * 
 * @author 左利伟
 *
 */
@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer>{
	//查找在指定时间的场次
	@Modifying
	@Qualifier(value="SELECT * FROM `schedule` WHERE "
			+ "sched_start_time>=?1 And s"
			+ "ched_start_time<=?2 ;")
	List<Schedule> findByStartTime(Long startTime,Long endTime);
	
	@Modifying
	@Qualifier(value="SELECT * FROM `schedule` WHERE "
			+ "movie_id=?3 AND sched_start_time>=?1 And s"
			+ "ched_start_time<=?2 ;")
	List<Schedule> findByMovieIdAndTime(Long startTime,
			Long endTime,String movieId);
}
