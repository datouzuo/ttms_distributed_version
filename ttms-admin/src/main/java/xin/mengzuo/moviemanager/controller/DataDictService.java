package xin.mengzuo.moviemanager.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xin.mengzuo.buyTicketsAndStatistic.controller.ReviewServiceImp;
import xin.mengzuo.config.TtmsResult;
@FeignClient(value="moviemanager",fallback=DataDictServiceImp.class)
public interface DataDictService {
	@RequestMapping(value="/add",method=RequestMethod.GET)
    public TtmsResult addDataDict(@RequestBody DataDict data);
	//根据父类id得到子条目
	@RequestMapping("/findList/{parentId}")
    public TtmsResult findList(@PathVariable("parenId") Integer parentId);
	//删除根据id
	
	@RequestMapping("/delete/{dictId}")
  public TtmsResult deleteByDictId(@PathVariable("dictId") Integer dictId);
	//查找所有父类
	@RequestMapping("/findparent")
	public TtmsResult findParent();
}
