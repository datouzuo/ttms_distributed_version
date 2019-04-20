package xin.mengzuo.buyTicketsAndStatistic.service;

import xin.mengzuo.buyTicketsAndStatistic.config.TtmsResult;
import xin.mengzuo.buyTicketsAndStatistic.pojo.Bill;
import xin.mengzuo.buyTicketsAndStatistic.pojo.User;

public interface BuyTicketService {
	TtmsResult payMoney(Bill bill,User user);
	void insertBill(Bill bill);
}
