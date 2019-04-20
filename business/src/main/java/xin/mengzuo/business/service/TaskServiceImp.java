package xin.mengzuo.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xin.mengzuo.business.repository.TicketRepository;
/**
 * 
 * @author 左利伟
 *票的管理
 */
@Service
@Transactional
public class TaskServiceImp implements TaskService{

  	@Autowired
	private TicketRepository tr;

  	/**
  	 * 改变票的状态
  	 */
  	
	@Override
	public void changeStatus(List<Integer> ids) {
		tr.updataByIds(ids);
	}


/**
 * 查找票的状态
 */
	@Override
	public Integer selectStatus(Integer id) {
	
		return tr.findByTicketId(id);
	}

}
