package xin.mengzuo.studiomanager.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xin.mengzuo.studiomanager.config.TtmsResult;
import xin.mengzuo.studiomanager.pojo.Studio;
import xin.mengzuo.studiomanager.service.SeatServie;
import xin.mengzuo.studiomanager.service.StudioService;
/**
 * 演出厅管理
 * @author 左利伟
 *
 */
@RequestMapping("/studio")
@RestController
public class StudioController {


	@Autowired
	private StudioService studios;
	//添加演出厅
	@RequestMapping("/add")
	public TtmsResult addStudio(@RequestBody Studio studio) {
		studios.addStudio(studio);
		return TtmsResult.ok();
	}
	//查找所有演出厅
	@RequestMapping("/findAll")
	public TtmsResult findAll(){
		return TtmsResult.ok(studios.findAll());
	}
	//根据演出id删除
	@RequestMapping("/delete/{studioId}")
	public TtmsResult delete(@PathVariable Integer studioId) {
		studios.deleteStudio(studioId);
		return TtmsResult.ok();
	}
	
}
