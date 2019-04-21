package xin.mengzuo.studiomanager.controller;

import xin.mengzuo.config.TtmsResult;

public class SeatServiceImp implements SeatService {

	@Override
	public TtmsResult updataStatus(String seatIds) {
		return TtmsResult.build(400, "超时");
		
	}

	@Override
	public TtmsResult findByStudioId(Integer studioId) {
		// TODO Auto-generated method stub
		return TtmsResult.build(400, "超时");
	}
	/**
	 * @author 左利伟
	 */
}
