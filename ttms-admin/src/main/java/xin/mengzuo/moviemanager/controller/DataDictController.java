package xin.mengzuo.moviemanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import xin.mengzuo.config.TtmsResult;


@RestController
@RequestMapping("/dataDict")
public class DataDictController {
    @Autowired
	private DataDictService dds;
    //添加条目数据字典
	@RequestMapping("/add")
    public TtmsResult addDataDict(@RequestBody DataDict data) {
    	dds.addDataDict(data);
    	return TtmsResult.ok();
    }
	//根据父类id得到子条目
	@RequestMapping("/findList/{parentId}")
    public TtmsResult findList(@PathVariable Integer parentId){
    	return TtmsResult.ok(dds.findList(parentId));
    }
	//删除根据id
	
	@RequestMapping("/delete/{dictId}")
  public TtmsResult deleteByDictId(@PathVariable Integer dictId) {
    	dds.deleteByDictId(dictId);
    	return TtmsResult.ok();
    }
	//查找所有父类
	@RequestMapping("/findparent")
	public TtmsResult findParent() {
	    return dds.findParent();
	}
}
