package xin.mengzuo.business.unlockTicket;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class TaskPool {

   private final static ScheduledExecutorService ex =Executors.newScheduledThreadPool(5);
   private TaskPool() {
	   
   }
    
      public static ScheduledExecutorService geScheduledExecutorService () {
  
   return ex;
} 
   
/*   public static ScheduledExecutorService geScheduledExecutorService () {
	   if(ex==null) {
		   synchronized (ex.getClass()) {
			if(ex==null) {
				ex = Executors.newScheduledThreadPool(5);
			}		
		}
	   }
	   return ex;
   }*/
}
