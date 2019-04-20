package xin.mengzuo.buyTicketsAndStatistic.pojo;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.SubscribableChannel;

public interface CancelSink {


		String INPUT = "cancelinput";

		@Input(CancelSink.INPUT)
		SubscribableChannel input();

	
}
