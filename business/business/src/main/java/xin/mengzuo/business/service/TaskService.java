package xin.mengzuo.business.service;

import java.util.List;

public interface TaskService {
/**
 * 查找票的状态
 * @author 左利伟
 */
	Integer selectStatus(Integer id);
	/**
	 * 改变票的状态
	 * @author 左利伟
	 */
	void changeStatus(List<Integer> ids);
}
