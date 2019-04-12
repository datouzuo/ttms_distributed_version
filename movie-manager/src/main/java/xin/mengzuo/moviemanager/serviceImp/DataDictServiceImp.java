package xin.mengzuo.moviemanager.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xin.mengzuo.moviemanager.config.TtmsResult;
import xin.mengzuo.moviemanager.dao.DataDictRepository;
import xin.mengzuo.moviemanager.pojo.DataDict;
import xin.mengzuo.moviemanager.service.DataDictService;

@Service
@Transactional
public class DataDictServiceImp implements DataDictService{

	@Autowired
	private DataDictRepository ddr;
	
	@Override
	public void addDataDict(DataDict data) {
		ddr.save(data);
		
	}

	@Override
	public List<DataDict> findList(Integer parentId) {
		
		return ddr.findAllByDictParentId(parentId);
	}

	@Override
	public void deleteByDictId(Integer dictId) {
		ddr.deleteById(dictId);
		
	}

	@Override
	public TtmsResult findParent() {
		ddr.findAllByIsParent(1);
		
		return TtmsResult.ok(ddr.findAllByIsParent(1));
	}

	
	
}
