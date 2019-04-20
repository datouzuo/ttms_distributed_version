package xin.mengzuo.buyTicketsAndStatistic.serviceImp;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import xin.mengzuo.buyTicketsAndStatistic.config.TicketStatus;
import xin.mengzuo.buyTicketsAndStatistic.config.TtmsResult;
import xin.mengzuo.buyTicketsAndStatistic.dao.BuyTicketReposity;
import xin.mengzuo.buyTicketsAndStatistic.pojo.Bill;
import xin.mengzuo.buyTicketsAndStatistic.pojo.Ticket;
import xin.mengzuo.buyTicketsAndStatistic.pojo.User;
import xin.mengzuo.buyTicketsAndStatistic.service.BuyTicketService;
/**
 * 购票后处理
 * @author 左利伟
 *
 */
public class BuyTicketsServiceImp implements BuyTicketService{
@Autowired
	private BuyTicketReposity bTicR;
	/**
 * 查出所购票并处理
 */
	@Override
	public TtmsResult payMoney(Bill bill,User user) {
     
		List<Integer>  ids = new LinkedList<>(); 
		for(Ticket tic : bill.getList()) {
			ids.add(tic.getTicketId());
		}
		List<Ticket> byTicketIn = bTicR.findByTicketIn(ids);
		for(Ticket tic : byTicketIn) {
			if(tic.getTicketStatus()!=TicketStatus.lock) {
				
				return TtmsResult.build(400, "购买失败");
			}else {
				
				tic.setTicketStatus(TicketStatus.sell);
				insertBill(bill);
				return TtmsResult.ok();
			}
		}
		
		
		
		return null;
	}
/**
 * 完成购票后插入订单
 */
	@Override
	public void insertBill(Bill bill) {
		
		
		bTicR.save(bill); 
		
	}
	
}
