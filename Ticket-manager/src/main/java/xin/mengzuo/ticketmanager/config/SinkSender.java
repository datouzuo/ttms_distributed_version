package xin.mengzuo.ticketmanager.config;
/**
 * 向rabbitMQ发送消息
 * @author 左利伟
 *
 */


import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageChannel;

public interface SinkSender {
	@Output(Sink.INPUT)
	MessageChannel send();
	
}
