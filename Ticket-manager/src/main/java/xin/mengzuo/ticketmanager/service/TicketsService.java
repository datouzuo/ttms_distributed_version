package xin.mengzuo.ticketmanager.service;

import java.util.List;

import xin.mengzuo.ticketmanager.pojo.Ticket;
/**
 * 票的业务类接口
 * @author 左利伟
 *
 */
public interface TicketsService {
/**
 * 添加电影票
 * @author 左利伟
 */
	void addTicketList(List<Ticket> ticketList);
	/**
	 * 传入演出演出计划Id得到对应票
	 * @author 左利伟
	 */
	List<Ticket> findByScheduleId(Integer schedId);
	
	List<Ticket> findByTicketIn(List<Integer> TicketIds);
}
