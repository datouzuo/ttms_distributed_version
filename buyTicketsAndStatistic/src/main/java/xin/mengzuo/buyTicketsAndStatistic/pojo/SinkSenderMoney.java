package xin.mengzuo.buyTicketsAndStatistic.pojo;
/**
 * 向rabbitMQ发送消息
 * @author 左利伟
 *
 */


import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageChannel;
/**
 * 发送统计消息
 * @author 左利伟
 *
 */
public interface SinkSenderMoney {
	@Output( StaticSink.INPUT)
	MessageChannel send();
	
}
