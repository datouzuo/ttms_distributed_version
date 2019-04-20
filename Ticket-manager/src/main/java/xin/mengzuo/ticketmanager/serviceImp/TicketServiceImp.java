package xin.mengzuo.ticketmanager.serviceImp;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xin.mengzuo.ticketmanager.config.TicketStatus;
import xin.mengzuo.ticketmanager.pojo.Ticket;
import xin.mengzuo.ticketmanager.repository.TicketRepository;
import xin.mengzuo.ticketmanager.service.TicketsService;

@Service
@Transactional
public class TicketServiceImp implements TicketsService {
@Autowired
	private TicketRepository ticRe;
	/**
	 * 存储电影场次
	 */
	@Override
	public void addTicketList(List<Ticket> ticketList) {
	
		ticRe.saveAll(ticketList);
	}
	@Override
	public List<Ticket> findByScheduleId(Integer schedId) {
		
		return ticRe.findBySchedId(schedId);
	}
	@Override
	public List<Ticket> findByTicketIn(List<Integer> TicketIds) {
		//存储票的状态为未售的
	  List<Ticket> list = new LinkedList<>();
		List<Ticket> allById = ticRe.findAllById(TicketIds);
		for(Ticket ticket : allById ) {
		    if(ticket.getTicketStatus()==TicketStatus.noSell) {
		    	list.add(ticket);
		    	//改变票的状态为锁定
		    	ticket.setTicketStatus(TicketStatus.lock);
		    }
		}
		
		return list;
	}

}
