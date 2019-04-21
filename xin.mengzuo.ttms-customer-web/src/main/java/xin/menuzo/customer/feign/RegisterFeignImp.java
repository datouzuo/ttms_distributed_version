package xin.menuzo.customer.feign;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import xin.menuzo.customer.pojo.User;
import xin.menuzo.customer.until.TtmsResult;
@Component
public class RegisterFeignImp implements RegisterFeign {


/*	@Override
	public String hello() {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public TtmsResult registerSave(User user) {
		// TODO Auto-generated method stub
		return TtmsResult.build(400, "超时");
	}

	@Override
	public TtmsResult registerCheck(String msg, int type) {
		// TODO Auto-generated method stub
		return TtmsResult.build(400, "超时");
	}

	@Override
	public TtmsResult mailPhone(String activecode) {
		// TODO Auto-generated method stub
		return TtmsResult.build(400, "超时");
	}



}
