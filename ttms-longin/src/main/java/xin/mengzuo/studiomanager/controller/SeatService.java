package xin.mengzuo.studiomanager.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xin.mengzuo.config.TtmsResult;

@FeignClient(value="seat-studio",fallback=SeatServiceImp.class)
public interface SeatService {
	   
	    /**
	     *根据id得到所有座位
	     * @author 左利伟
	     */
	    @RequestMapping(value="/seat/findstudio/{studioId}")
		public TtmsResult findByStudioId(@PathVariable("studioId") Integer studioId);
}
