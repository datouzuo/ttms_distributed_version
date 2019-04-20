package xin.mengzuo.buyTicketsAndStatistic.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xin.mengzuo.buyTicketsAndStatistic.pojo.Bill;
import xin.mengzuo.buyTicketsAndStatistic.pojo.Ticket;

@Repository
public interface BuyTicketReposity extends JpaRepository<Bill, String> {
	List<Ticket> findByTicketIn(List<Integer> TicketIds);
}
