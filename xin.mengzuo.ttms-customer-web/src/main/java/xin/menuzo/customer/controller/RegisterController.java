package xin.menuzo.customer.controller;

import java.awt.image.BufferedImage;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;import org.hibernate.validator.internal.util.privilegedactions.GetClassLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import xin.menuzo.customer.feign.RegisterFeign;
import xin.menuzo.customer.pojo.User;
import xin.menuzo.customer.until.TtmsResult;
import xin.menuzo.customer.until.VerifyUtil;

@RestController
public class RegisterController {
	@Autowired
	private RegisterFeign refe;

/*	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
	
		return refe.hello();

	}*/
	
	
	@RequestMapping(value="/user/registerservice",method=RequestMethod.POST)
	public TtmsResult registerSave( User user,HttpServletRequest request, String revix) {
		System.out.println(request.getSession().getAttribute("revix").toString().toLowerCase());
		if (revix.toLowerCase().equals(request.getSession().getAttribute("revix").toString().toLowerCase())) {
		return refe.registerSave(user);
		}
		return TtmsResult.build(400, "验证码错误");
	}
	@RequestMapping(value="/user/registercheck",method=RequestMethod.GET)
	public TtmsResult registerCheck(String msg ,int type) {
		return refe.registerCheck(msg, type);
	}
	@RequestMapping(value="/user/mail/{activecode}")
	public TtmsResult mailPhone(@PathVariable String activecode) {
		return refe.mailPhone(activecode);
	}
	//生成验证码
	
    @GetMapping("/getcode")
    public void getCode(HttpServletResponse response, HttpServletRequest request) throws Exception{
        HttpSession session=request.getSession();
        //利用图片工具生成图片
        //第一个参数是生成的验证码，第二个参数是生成的图片
        Object[] objs = VerifyUtil.createImage();
        //将验证码存入Session
        session.setAttribute("revix",objs[0]);
        
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies) {
        	cookie.setDomain("");
        	cookie.setPath("/");
        }
        //将图片输出给浏览器
        BufferedImage image = (BufferedImage) objs[1];
        response.setContentType("image/png");
        OutputStream os = response.getOutputStream();
        ImageIO.write(image, "png", os);
    }
	
}
