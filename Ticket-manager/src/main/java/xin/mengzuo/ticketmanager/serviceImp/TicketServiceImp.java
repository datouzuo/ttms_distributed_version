package xin.mengzuo.ticketmanager.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xin.mengzuo.ticketmanager.pojo.Ticket;
import xin.mengzuo.ticketmanager.repository.TicketRepository;
import xin.mengzuo.ticketmanager.service.TicketsService;

@Service
@Transactional
public class TicketServiceImp implements TicketsService {
@Autowired
	private TicketRepository ticRe;
	
	@Override
	public void addTicketList(List<Ticket> ticketList) {
	
		ticRe.saveAll(ticketList);
	}

}
