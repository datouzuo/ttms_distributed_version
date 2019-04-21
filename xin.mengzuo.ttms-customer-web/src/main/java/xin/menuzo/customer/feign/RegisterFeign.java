package xin.menuzo.customer.feign;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import xin.menuzo.customer.pojo.User;
import xin.menuzo.customer.until.TtmsResult;


@FeignClient(value="loginsso",fallback=RegisterFeignImp.class)
public interface RegisterFeign {

	
	@RequestMapping(value="/user/registerservice",method=RequestMethod.POST)
	public TtmsResult registerSave( @RequestBody User user);
	
	@RequestMapping(value="/user/registercheck",method=RequestMethod.GET)
	public TtmsResult registerCheck(@RequestParam("msg") String msg ,@RequestParam("type") int type);
	
	@RequestMapping(value="/user/mail/{activecode}")
	public TtmsResult mailPhone(@PathVariable("activecode") String activecode);
    
}
