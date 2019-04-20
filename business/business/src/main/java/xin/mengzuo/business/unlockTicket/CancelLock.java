package xin.mengzuo.business.unlockTicket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

//取消锁
@EnableBinding(CancelSink.class)
public class CancelLock {

	private Logger log = LoggerFactory.getLogger(getClass());
    
	@StreamListener(CancelSink.INPUT)
	public void CancelReciver(String msg) {
		log.info(msg);
		CancelMap.remove(msg);
		
	}
	
}
