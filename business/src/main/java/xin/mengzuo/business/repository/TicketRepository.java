package xin.mengzuo.business.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import xin.mengzuo.business.pojo.Ticket;
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer>{
    @Modifying
	@Query(value="update Ticket t set t.ticketStatus = '1' where t.ticketId " + 
			"in ?1")
	void updataByIds(List<Integer> ids);
    @Query(value="select ticket_status from ticket where ticket_id "
    		+ "= ?1",nativeQuery=true)
    Integer findByTicketId(Integer ticketId);
    
}
