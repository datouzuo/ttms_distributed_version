package xin.mengzuo.studiomanager.serviceImp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xin.mengzuo.studiomanager.dao.StudioRepository;
import xin.mengzuo.studiomanager.pojo.Studio;
import xin.mengzuo.studiomanager.service.SeatServie;
import xin.mengzuo.studiomanager.service.StudioService;
@Service
@Transactional
public class StudioServiceImp implements StudioService{
     @Autowired
	private StudioRepository sr;
     
     @Autowired
 	private SeatServie seats;
     /**
      * 增加演出厅，并且增加座位
      */
	@Override
	public void addStudio(Studio studio) {
		Studio st = sr.save(studio);
		seats.addSeat(st);
	}
	/**
     * 删除演出厅，并且删除对应的座位
     */
	@Override
	public void deleteStudio(Integer studioId) {
		sr.deleteById(studioId);
		seats.deleteByStudioId(studioId);
	}

	@Override
	public List<Studio> findAll() {
	
		return sr.findAll();
	}

	



}
