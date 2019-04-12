package xin.mengzuo.moviemanager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieManagerApplicationTests {

	@Test
	public void contextLoads() {
		
			String s= "1.2.3.4.5";
			String[] seatIds = s.split("\\.");
			for(String ss : seatIds) {
				System.out.println(ss);
			
		}

	}

}

