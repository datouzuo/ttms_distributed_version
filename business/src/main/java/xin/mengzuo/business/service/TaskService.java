package xin.mengzuo.business.service;

import java.util.List;

public interface TaskService {

	Integer selectStatus(Integer id);
	void changeStatus(List<Integer> ids);
}
