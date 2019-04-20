package xin.mengzuo.ticketmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xin.mengzuo.ticketmanager.pojo.Ticket;
/**
 * 
 * @author 左利伟
 *
 */
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer>{
   
	List<Ticket> findBySchedId(Integer schedId);
	//查找票
	List<Ticket> findByTicketIn(List<Integer> TicketIds);
}
