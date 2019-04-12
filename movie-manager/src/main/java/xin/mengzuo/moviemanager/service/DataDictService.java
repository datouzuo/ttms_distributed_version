package xin.mengzuo.moviemanager.service;

import java.util.List;

import xin.mengzuo.moviemanager.config.TtmsResult;
import xin.mengzuo.moviemanager.pojo.DataDict;

public interface DataDictService {
    
	void addDataDict(DataDict data);
	
   List<DataDict> findList(Integer parentId);
	
   void deleteByDictId(Integer dictId);
   TtmsResult findParent();
}
