package xin.mengzuo.studiomanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xin.mengzuo.config.TtmsResult;

/**
 * 根据座位id将座位状态改变
 * @author 左利伟
*1为好的 0为坏的
 *
 */
@RestController
@RequestMapping
public class SeatController {
    @Autowired 
	private SeatService ss;
    @RequestMapping("/seat/updataDel/{seatId}")
    public TtmsResult updataStatus(@PathVariable String seatIds) {
    	return ss.updataStatus(seatIds);
    }
    /**
     *根据id得到所有座位
     * @author 左利伟
     */
    @RequestMapping(value="/seat/findstudio/{studioId}")
	public TtmsResult findByStudioId(Integer studioId) {
		return TtmsResult.ok(ss.findByStudioId(studioId));
	}
}
