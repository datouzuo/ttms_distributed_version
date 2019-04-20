package xin.mengzuo.buyTicketsAndStatistic.pojo;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.SubscribableChannel;

public interface StaticSink {


		String INPUT = "static";

		@Input(StaticSink.INPUT)
		SubscribableChannel input();

	
}
