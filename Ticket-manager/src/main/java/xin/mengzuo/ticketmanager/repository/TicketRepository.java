package xin.mengzuo.ticketmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xin.mengzuo.ticketmanager.pojo.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer>{
   
	
	
}
