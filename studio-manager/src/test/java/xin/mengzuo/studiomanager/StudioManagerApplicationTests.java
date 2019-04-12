package xin.mengzuo.studiomanager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import xin.mengzuo.studiomanager.dao.StudioRepository;
import xin.mengzuo.studiomanager.pojo.Studio;
import xin.mengzuo.studiomanager.service.StudioService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudioManagerApplicationTests {
   
	@Test
	public void contextLoads() {
		String s= "1.2.3.4.5";
		String[] seatIds = s.split("\\.");
		for(String ss : seatIds) {
			System.out.println(ss);
		}
	}

}

