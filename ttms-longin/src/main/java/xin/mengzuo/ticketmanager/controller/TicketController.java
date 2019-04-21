package xin.mengzuo.ticketmanager.controller;

import java.util.LinkedList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xin.mengzuo.config.TtmsResult;

/**
 * Ticket基础服务
 * @author 左利伟
 *负责顾客买票
 */
@RestController
public class TicketController {
@Autowired
private TicketService tiSer;
	
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
	
	public TtmsResult buyTicket(String tickets) {
		return tiSer.buyTicket(tickets);
}}