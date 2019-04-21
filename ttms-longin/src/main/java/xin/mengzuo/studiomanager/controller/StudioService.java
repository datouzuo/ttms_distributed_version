	package xin.mengzuo.studiomanager.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xin.mengzuo.config.TtmsResult;
@FeignClient(value="seat-studio",fallback=StudioServiceImp.class)
public interface StudioService {
	
	//根据id得到演出厅
	@RequestMapping(value="/studio/findstudio/{studioId}")
	public TtmsResult findByStudioId(Integer studioId);
}
