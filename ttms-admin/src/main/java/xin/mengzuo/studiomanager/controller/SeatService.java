package xin.mengzuo.studiomanager.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xin.mengzuo.config.TtmsResult;
import xin.mengzuo.moviemanager.controller.DataDictServiceImp;

@FeignClient(value="seat-studio",fallback=SeatServiceImp.class)
public interface SeatService {
	   @RequestMapping(value= "/seat/updataDel/{seatIds}",method = RequestMethod.GET)
	    public TtmsResult updataStatus(@PathVariable("seatIds") String seatIds);
	    /**
	     *根据id得到所有座位
	     * @author 左利伟
	     */
	    @RequestMapping(value="/seat/findstudio/{studioId}")
		public TtmsResult findByStudioId(@PathVariable("studioId") Integer studioId);
}
