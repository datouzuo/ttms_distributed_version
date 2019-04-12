package xin.mengzuo.business;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import xin.mengzuo.business.service.TaskService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessApplicationTests {

	@Autowired
	private TaskService ts;
	@Test
	public void contextLoads() {
		
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(473);
		ids.add(474);
		ids.add(475);
		ts.changeStatus(ids);
	}

}

