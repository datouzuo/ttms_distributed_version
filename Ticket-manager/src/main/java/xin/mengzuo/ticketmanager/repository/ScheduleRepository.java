package xin.mengzuo.ticketmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xin.mengzuo.ticketmanager.pojo.Schedule;
/**
 * 
 * @author 左利伟
 *
 */
@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer>{
	
	
	
}
