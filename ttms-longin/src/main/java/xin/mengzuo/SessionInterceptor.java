package xin.mengzuo;

import java.net.URLDecoder;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.fasterxml.jackson.databind.ObjectMapper;

import redis.clients.jedis.JedisCluster;
import xin.mengzuo.config.CookieUtils;
import xin.mengzuo.config.User;


/**
 * 拦截器只有登录的人才能访问这些接口
 * @author 左利伟
 *
 */
public class SessionInterceptor implements HandlerInterceptor {

	@Autowired
	private JedisCluster cluster;
	//json操作
	@Autowired
	private ObjectMapper obJeson;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String value = CookieUtils.getCookieValue(request, "tokenId");
		if(value!=null) {
			
				cluster.expire("tokenId:"+value, 1800);
				return true;
			
		}
		return false;
	}
}
