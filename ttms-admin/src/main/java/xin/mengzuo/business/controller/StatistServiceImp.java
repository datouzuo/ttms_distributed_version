package xin.mengzuo.business.controller;

import xin.mengzuo.config.TtmsResult;

public class StatistServiceImp implements StatistService{

	@Override
	public TtmsResult findByDateDay(String dateDay) {
		// TODO Auto-generated method stub
		return TtmsResult.build(400, "超时");
	}

	@Override
	public TtmsResult findByMovieId(String movieId) {
		// TODO Auto-generated method stub
		return TtmsResult.build(400, "超时");
	}

	@Override
	public TtmsResult findDateDay() {
		// TODO Auto-generated method stub
		return TtmsResult.build(400, "超时");
	}

	@Override
	public TtmsResult findByDateMouth(String dateMouth) {
		// TODO Auto-generated method stub
		return TtmsResult.build(400, "超时");
	}

	@Override
	public TtmsResult findDateMouth() {
		// TODO Auto-generated method stub
		return TtmsResult.build(400, "超时");
	}
	/**
	 * @author 左利伟
	 */
}
