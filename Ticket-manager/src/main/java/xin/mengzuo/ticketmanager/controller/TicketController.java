package xin.mengzuo.ticketmanager.controller;

import java.util.LinkedList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xin.mengzuo.ticketmanager.config.SinkSender;
import xin.mengzuo.ticketmanager.config.TtmsResult;
import xin.mengzuo.ticketmanager.pojo.Schedule;
import xin.mengzuo.ticketmanager.pojo.Ticket;
import xin.mengzuo.ticketmanager.service.ScheduleService;
import xin.mengzuo.ticketmanager.service.TicketsService;
/**
 * Ticket基础服务
 * @author 左利伟
 *负责顾客买票
 */
@RestController
public class TicketController {
	@Autowired
	private TicketsService tiSer;
	
	@Autowired
	private SinkSender sinksen;
	
	/**
	 * 传入schdeId得到所有电影票
	 * @author 左利伟
	 */
	@RequestMapping("/cuslogin/findTicketByScheduleId/{schdeId}")
	public TtmsResult findByScheduleId(@PathVariable int schdeId) {
		
		return TtmsResult.ok(tiSer.findByScheduleId(schdeId));
	}
	/**
	 * 传入tickets  格式id,di,id
	 * 并将锁住的票传入锁票服务
	 * @author 左利伟
	 */
	@RequestMapping("/cuslogin/buyTickets/{tickets}")
	public TtmsResult buyTicket(@PathVariable String tickets) {
		String[] tis = tickets.split(tickets);
		List<Integer> list = new LinkedList<>();
		for(String s:tis) {
			list.add(Integer.parseInt(s));
		}
		
	    List<Ticket> ticketIn = tiSer.findByTicketIn(list);
	   
	    if(ticketIn.size()>0) {
	    	 String stickeids  = "";
	 	    for(Ticket t : ticketIn) {
	 	         stickeids = stickeids+t.getTicketId();
	 	    }
	 	    //将ids传到加锁服务
	 	    sinksen.send().send(
	 	    		MessageBuilder.withPayload(stickeids).build());
	 	    
	    	return TtmsResult.ok(ticketIn);
	    	
	    }
		return TtmsResult.build(500,"你的票已空");
}
	

	
}