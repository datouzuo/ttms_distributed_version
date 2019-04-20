package xin.mengzuo.ticketmanager;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mysql.fabric.xmlrpc.base.Data;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TicketManagerApplicationTests {

	@Test
	public void contextLoads() {
		long millis = System.currentTimeMillis();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		
		
		String dateStr = dateformat.format(millis);
		System.out.println(dateStr);
		long mi = 5*60000+millis;
		dateformat.format(mi);
		System.out.println(dateformat.format(mi));
		
		
	}

}

