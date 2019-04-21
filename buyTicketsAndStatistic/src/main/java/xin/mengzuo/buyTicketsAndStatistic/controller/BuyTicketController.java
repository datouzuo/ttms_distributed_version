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
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import redis.clients.jedis.JedisCluster;
import xin.mengzuo.buyTicketsAndStatistic.config.CookieUtils;
import xin.mengzuo.buyTicketsAndStatistic.config.TtmsResult;
import xin.mengzuo.buyTicketsAndStatistic.pojo.Bill;
import xin.mengzuo.buyTicketsAndStatistic.pojo.SinkSender;
import xin.mengzuo.buyTicketsAndStatistic.pojo.SinkSenderMoney;
import xin.mengzuo.buyTicketsAndStatistic.pojo.Ticket;
import xin.mengzuo.buyTicketsAndStatistic.pojo.User;
import xin.mengzuo.buyTicketsAndStatistic.service.BuyTicketService;

/**
 * 确认购票
 * @author 左利伟
 *
 */
@RestController
public class BuyTicketController {
	//reids操作
	@Autowired
	private JedisCluster cluster;
	@Autowired
	private BuyTicketService buyTic;
	//json操作
	@Autowired
	private ObjectMapper obJeson;
	//取消定时任务
	@Autowired
	private SinkSender sinkSen;
	//统计操作
	@Autowired
	private SinkSenderMoney sinkSenMon;
	//邮件操作
	 @Autowired
	 private JavaMailSender javaMailSender;	
	
	@RequestMapping("/affirm/buyTicket/{billId}")
	public TtmsResult affirmBuyTicket(@PathVariable String billId,
			HttpServletRequest request) throws JsonParseException, JsonMappingException, IOException {
		
		String value = CookieUtils.getCookieValue(request, "tokenId");
		String billString = cluster.get(value+":"+billId);
		Bill bill = obJeson.readValue(billString, Bill.class);
		
		if(bill!=null) {
			
		//TODO转给第三方收取钱
			//模拟付款成功
			return TtmsResult.ok();
		}
		return TtmsResult.build(400, "时间超时");
	}
	//模拟第三方返回时调用的接口
	//TODO
	@RequestMapping
	public TtmsResult payMoney(String billId,HttpServletRequest request) throws JsonParseException, JsonMappingException, IOException {
		String value = CookieUtils.getCookieValue(request, "tokenId");
		//从reids种获得订单
		String billString = cluster.get("tokenId:"+value+":"+billId);
		
		Bill bill = obJeson.readValue(billString, Bill.class);
		
		User user = obJeson.readValue(cluster.get("tokenId:"+value), User.class);
		if(bill!=null&&user!=null) {
	
			TtmsResult result = buyTic.payMoney(bill, user);
			if(result.getStatus()==200) {
				//发送消息给中间件取消定时任务
				sinkSen.send().send(
						MessageBuilder.
						withPayload(bill.getTicketIds()).build());
				//取消缓存中得订单
				cluster.del(value+":"+billId);
				//发送数据到统计服务，时间，电影Id，总钱，进行统计票数
				String total = bill.getDate()+","+bill.getMovieId()+","+bill.getTotalMoney();
				sinkSenMon.send().send(
						MessageBuilder.
						withPayload(total).build());
				//以邮件发送领票时码
				String uuid= UUID.randomUUID().toString();
				sendSimpleMail(user.getEmail(),uuid);
				//TODO处理领卷码
				
				return TtmsResult.ok();
			}else {
				//TODO退钱处理
				return TtmsResult.build(400, "购票未成功");
			}
			
			
		}
		return null;
		
		
	}
	/**
	 * 将订单存到redis缓冲
	 * 时间15分钟
	 * @author 左利伟
	 */
	@RequestMapping("/bill/creatBill")
	public TtmsResult creatBill(Bill bill,String cookie) throws JsonProcessingException {
		String biS = obJeson.writeValueAsString(bill);
		cluster.set("tokenId:"+cookie+bill.getBillId(), biS);
		cluster.expire("tokenId:"+cookie+bill.getBillId(), 900);
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
	public TtmsResult findAllBill(String cookie) throws JsonParseException, JsonMappingException, IOException {
		JavaType type = obJeson.getTypeFactory().constructParametricType(List.class,Bill.class);
		String strbill = cluster.get("tokenId:"+cookie+"*");
		List<Bill> billList = obJeson.readValue(strbill, type);
		return TtmsResult.ok(billList);
	}
	
	
	public void sendSimpleMail(String mail,String code){
        MimeMessage message = null;
        try {
            message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("1203224763@qq.com");
            helper.setTo(mail);
            helper.setSubject("点击连接激活账号");

            StringBuffer sb = new StringBuffer();
            sb.append("<h1>电影领票码</h1>")
                    .append("领票码:"+code);
               System.out.println(sb.toString());     
            helper.setText(sb.toString(), true);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
	
	
	
	
	
}
