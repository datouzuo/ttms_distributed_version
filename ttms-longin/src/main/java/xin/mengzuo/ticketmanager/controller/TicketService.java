package xin.mengzuo.ticketmanager.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xin.mengzuo.config.TtmsResult;
@FeignClient(value="schedule-ticket",fallback=ScheduleServiceImp.class)
public interface TicketService {
	@RequestMapping(value ="/cuslogin/findTicketByScheduleId/{schdeId}",method = RequestMethod.GET)
	public TtmsResult findByScheduleId(@PathVariable("scheId") int schdeId);
	/**
	 * 传入tickets  格式id,di,id
	 * 并将锁住的票传入锁票服务
	 * @author 左利伟
	 */
	@RequestMapping(value = "/cuslogin/buyTickets/{tickets}",method=RequestMethod.GET)
	public TtmsResult buyTicket(@PathVariable("tickets") String tickets);
}
