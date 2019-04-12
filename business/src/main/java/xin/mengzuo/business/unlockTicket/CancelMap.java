package xin.mengzuo.business.unlockTicket;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
/**
 * 
 * @author 左利伟
 *
 */
public class CancelMap {

	 private final static Map<String,ScheduledFuture > fumap = new ConcurrentHashMap<>();


	 private CancelMap() {
	 }
	 public static void addFuture(String ids,ScheduledFuture future) {
		 fumap.put(ids, future);
	 }
	 public static void remove(String ids) {
		 ScheduledFuture future = fumap.get(ids);
		 future.cancel(true);
		 fumap.remove(ids);
	 }
	 
}
