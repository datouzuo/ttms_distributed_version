package xin.mengzuo.customer.controller;
import java.awt.image.BufferedImage;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import xin.mengzuo.customer.config.CookieUtils;
import xin.mengzuo.customer.config.TtmsResult;

import xin.mengzuo.customer.pojo.User;
import xin.mengzuo.customer.service.RegisterService;
/**
 * 
 * @author 左利伟
 *
 */
@RestController
public class RegisterController {
	private  final Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    private RegisterService rese;
    //注册
	@RequestMapping(value="/user/registerservice",method=RequestMethod.POST)
	public TtmsResult registerSave( @RequestBody User user,HttpServletRequest request, String revix) {
		
		boolean b=false;
		System.out.println(user.getEmail());
		
		
				b = rese.register(user);
		
			if(b)
		   return TtmsResult.build(200, "成功");
			
			return TtmsResult.build(400, "数据重复或邮箱错误");
	}
	//动态验证是否信息是否重复
	@RequestMapping(value="/user/registercheck",method=RequestMethod.GET)
	public TtmsResult registerCheck(String msg,HttpServletRequest request ,int type) {
	
		boolean b = rese.checkSave(msg,type);
		if(!b) {
			return TtmsResult.build(200, "成功");
		}else {
			return TtmsResult.build(400, "数据重复");
		}
	}	
	//激活账号
	@RequestMapping(value="/user/mail/{activecode}")
	public TtmsResult mailPhone(@PathVariable String activecode) {
		rese.mailPhoneActive(activecode);
		return TtmsResult.ok();
	}
}
