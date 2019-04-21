package xin.mengzuo.moviemanager.controller;

import xin.mengzuo.config.TtmsResult;

public class MangerServiceImp implements MovieMangerService{

	@Override
	public TtmsResult findByMovieId(String movieId) {
		// TODO Auto-generated method stub
		return TtmsResult.build(400, "超时");
	}

	
	@Override
	public TtmsResult cusFindAllMovie() {
		// TODO Auto-generated method stub
		return TtmsResult.build(400, "超时");
	}
	/**
	 * @author 左利伟
	 */
}
