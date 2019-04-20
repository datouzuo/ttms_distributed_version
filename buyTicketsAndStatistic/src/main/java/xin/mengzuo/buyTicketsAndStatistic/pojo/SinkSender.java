package xin.mengzuo.buyTicketsAndStatistic.pojo;
/**
 * 向rabbitMQ发送消息
 * @author 左利伟
 *
 */


import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageChannel;

public interface SinkSender {
	@Output( CancelSink.INPUT)
	MessageChannel send();
	
}
