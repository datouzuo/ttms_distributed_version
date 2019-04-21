package xin.menuzo.customer.feign;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xin.menuzo.customer.until.TtmsResult;

public class LoginFeignImp implements LoginFeign{

	public TtmsResult register(String email, String password ) {
		// TODO Auto-generated method stub
		return TtmsResult.build(400, "超时");
	}
	/**
	 * @author 左利伟
	 */
}
