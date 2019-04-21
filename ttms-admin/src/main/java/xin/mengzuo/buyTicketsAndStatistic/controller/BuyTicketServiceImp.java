package xin.mengzuo.buyTicketsAndStatistic.controller;

import xin.mengzuo.config.TtmsResult;

public class BuyTicketServiceImp implements BuyTicketService{

	@Override
	public TtmsResult affirmBuyTicket(String billId, String cookie) {
		// TODO Auto-generated method stub
		return TtmsResult.build(400, "超时");
	}

	@Override
	public TtmsResult payMoney(String billId, String cookie) {
		// TODO Auto-generated method stub
		return TtmsResult.build(400, "超时");
	}
	/**
	 * @author 左利伟
	 */

	@Override
	public TtmsResult creatBill(Bill bill, String cookie) {
		// TODO Auto-generated method stub
		return TtmsResult.build(400, "超时");
	}

	@Override
	public TtmsResult findAllBill(String cookie) {
		return TtmsResult.build(400, "超时");
	}
}
