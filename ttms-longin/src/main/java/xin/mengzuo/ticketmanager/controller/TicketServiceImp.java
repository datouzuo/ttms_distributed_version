package xin.mengzuo.ticketmanager.controller;

import xin.mengzuo.config.TtmsResult;

public class TicketServiceImp implements TicketService{

	@Override
	public TtmsResult findByScheduleId(int schdeId) {
		return TtmsResult.build(400, "超时");
	}

	@Override
	public TtmsResult buyTicket(String tickets) {
		return TtmsResult.build(400, "超时");
	}
	
	
}
