package xin.mengzuo.buyTicketsAndStatistic.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import xin.mengzuo.config.CookieUtils;
import xin.mengzuo.config.TtmsResult;
import xin.mengzuo.ticketmanager.controller.Ticket;
import xin.mengzuo.ticketmanager.controller.TicketService;


/**
 * 确认购票
 * @author 左利伟
 *
 */
@RestController
public class BuyTicketController {
	
	@Autowired
	private BuyTicketService bk;
	@Autowired
	private TicketService ts;;
	
	
	@RequestMapping("/affirm/buyTicket/{billId}")
	public TtmsResult affirmBuyTicket(@PathVariable String billId,HttpServletRequest request) {
		String value = CookieUtils.getCookieValue(request, "tokenId");
		return bk.affirmBuyTicket(billId, value);
	}
	//模拟第三方返回时调用的接口
	//TODO
	@RequestMapping("/bill/buyTicket/{billId}")
	public TtmsResult payMoney(String billId,HttpServletRequest request) throws JsonParseException, JsonMappingException, IOException {
		String value = CookieUtils.getCookieValue(request, "tokenId");
       
		
		return bk.affirmBuyTicket(billId, value);
		
    }
	
	
	/**
	 * 将订单存到redis缓冲
	 * 时间15分钟
	 * @author 左利伟
	 */
	@RequestMapping("/bill/creatBill")
	public TtmsResult creatBill(Bill bill,String ticketids,HttpServletRequest request) throws JsonProcessingException {
		TtmsResult buyTicket = ts.buyTicket(ticketids);
		bill.setList((List<Ticket>) buyTicket.getData());
		String cookie = CookieUtils.getCookieValue(request, "tokenId");	
		bk.creatBill(bill, cookie);
		return TtmsResult.ok();
		
	}
	/**
	 * 将Redis中订单全部找chu
	 * @author 左利伟
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@RequestMapping(value="find/allBill")
	public TtmsResult findAllBill(HttpServletRequest request) throws JsonParseException, JsonMappingException, IOException {
		String cookie = CookieUtils.getCookieValue(request, "tokenId");	
		return TtmsResult.ok(bk.findAllBill(cookie));
	}

	
}
