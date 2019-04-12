package xin.mengzuo.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xin.mengzuo.business.repository.TicketRepository;

@Service
@Transactional
public class TaskServiceImp implements TaskService{

  	@Autowired
	private TicketRepository tr;

  	
  	
	@Override
	public void changeStatus(List<Integer> ids) {
		tr.updataByIds(ids);
	}



	@Override
	public Integer selectStatus(Integer id) {
	
		return tr.findByTicketId(id);
	}

}
