package xin.mengzuo.studiomanager.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xin.mengzuo.config.TtmsResult;


/**
 * 演出厅管理
 * @author 左利伟
 *
 */

@RestController
public class StudioController {


	@Autowired
	private StudioService studios;
	//添加演出厅
	@RequestMapping("/studio/add")
	public TtmsResult addStudio(@RequestBody Studio studio) {
		studios.addStudio(studio);
		return TtmsResult.ok();
	}
	//查找所有演出厅
	@RequestMapping("/studio/findAll")
	public TtmsResult findAll(){
		return TtmsResult.ok(studios.findAll());
	}
	//根据演出id删除
	@RequestMapping("/studio/delete/{studioId}")
	public TtmsResult delete(@PathVariable Integer studioId) {
		studios.delete(studioId);
		return TtmsResult.ok();
	}
	//根据id得到演出厅
	@RequestMapping(value="/studio/findstudio/{studioId}")
	public TtmsResult findByStudioId(Integer studioId) {
		return TtmsResult.ok(studios.findByStudioId(studioId));
	}
}
