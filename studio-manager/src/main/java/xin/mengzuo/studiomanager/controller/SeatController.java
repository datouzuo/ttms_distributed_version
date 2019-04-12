package xin.mengzuo.studiomanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xin.mengzuo.studiomanager.service.SeatServie;
/**
 * 根据座位id将座位状态改变
 * @author 左利伟
*1为好的 0为坏的
 *
 */
@RestController
@RequestMapping("/seat")
public class SeatController {
    @Autowired 
	private SeatServie ss;
    @RequestMapping("/updataDel/{seatId}")
    public void updataStatus(@PathVariable String seatIds) {
    	ss.updataByStatus(seatIds);
    }
    
}
