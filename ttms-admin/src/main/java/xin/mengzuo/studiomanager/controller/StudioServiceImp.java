package xin.mengzuo.studiomanager.controller;

import xin.mengzuo.config.TtmsResult;

public class StudioServiceImp implements StudioService {

	@Override
	public TtmsResult addStudio(Studio studio) {
		return TtmsResult.build(400, "超时");
	}

	@Override
	public TtmsResult findAll() {
		return TtmsResult.build(400, "超时");
	}

	@Override
	public TtmsResult delete(Integer studioId) {
		return TtmsResult.build(400, "超时");
	}

	@Override
	public TtmsResult findByStudioId(Integer studioId) {
		return TtmsResult.build(400, "超时");
	}
	/**
	 * @author 左利伟
	 */
}
