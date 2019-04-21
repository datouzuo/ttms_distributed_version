package xin.menuzo.customer.feign;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import xin.menuzo.customer.until.TtmsResult;

/**
 * 
 * @author 左利伟
 *
 */
@FeignClient(value="loginsso",fallback=LoginFeignImp.class)
public interface LoginFeign {
	@RequestMapping(value = "/user/login",method=RequestMethod.POST)
	public TtmsResult register( @RequestParam("email") String email,@RequestParam("password")  String password);

}
