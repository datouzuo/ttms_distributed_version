package xin.mengzuo.buyTicketsAndStatistic.controller;

import java.io.IOException;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import xin.mengzuo.business.controller.StatistServiceImp;
import xin.mengzuo.config.TtmsResult;
@FeignClient(value="buyTicekt",fallback=BuyTicketServiceImp.class)
public interface BuyTicketService {

	@RequestMapping(value="/affirm/buyTicket/{billId}",method=RequestMethod.GET)
	public TtmsResult affirmBuyTicket(@PathVariable("billId") String billId,@RequestParam("cookie") String cookie) ;
	//模拟第三方返回时调用的接口
	//TODO
	@RequestMapping(value ="/bill/buyTicket/{billId}",method=RequestMethod.GET)
	public TtmsResult payMoney(@PathVariable("billId") String billId,@RequestParam("cookie") String cookie);
	@RequestMapping(value ="/bill/creatBill",method = RequestMethod.GET)
	public TtmsResult creatBill(@ RequestBody Bill bill,@RequestParam("cookie") String cookie);
	@RequestMapping(value="find/allBill",method=RequestMethod.GET)
	public TtmsResult findAllBill(String cookie);

}
