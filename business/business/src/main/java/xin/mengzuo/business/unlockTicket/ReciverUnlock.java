package xin.mengzuo.business.unlockTicket;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import xin.mengzuo.business.config.TicketStatus;
import xin.mengzuo.business.service.TaskService;


/**
 * 时间到了解锁
 * @author 左利伟
 *
 */
@EnableBinding(Sink.class)
public class ReciverUnlock {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Value("${task.timeout}")
	private String timeout;
	@Autowired
	private TaskService ts;

	@StreamListener(Sink.INPUT)
	public void rec(String msg) {
		String[] split = msg.split("//,");
		List<Integer> ids = new ArrayList<Integer>();
		Integer id;
		for (int i = 0; i < split.length; i++) {
			id = Integer.valueOf(split[i]);
			ids.add(id);
		}
		log.info(msg);
		Integer id0 = ids.get(0);

		
		// 查询是否还处于锁定状态
		//只要一个处于锁定其他都是锁定状态

		ScheduledFuture<?> future = TaskPool.geScheduledExecutorService().schedule(new Runnable() {
			@Override
			public void run() {
				Integer status = ts.selectStatus(id0);
				if (status == TicketStatus.lock) {	
					ts.changeStatus(ids);
				}
			}
		}, Integer.parseInt(timeout), TimeUnit.MINUTES);
            CancelMap.addFuture(msg, future);
	}

}
