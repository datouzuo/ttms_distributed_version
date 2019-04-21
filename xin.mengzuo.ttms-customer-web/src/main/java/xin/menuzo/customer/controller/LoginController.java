package xin.menuzo.customer.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import xin.menuzo.customer.feign.LoginFeign;
import xin.menuzo.customer.until.TtmsResult;

/**
 * 
 * @author 左利伟
 *
 */
@RestController
public class LoginController {
	@Autowired
	private LoginFeign login;
		
	@RequestMapping(value ="/user/login",method=RequestMethod.POST)
		
		public TtmsResult register( String email, HttpServletResponse response ,String password) {
			
			 TtmsResult result = login.register(email, password);
				Cookie cookie = new Cookie("tokenId", result.getData().toString());
				cookie.setDomain("");
				cookie.setPath("/");
				response.addCookie(cookie);
				return TtmsResult.ok("登录成功");
		}
	
	}


