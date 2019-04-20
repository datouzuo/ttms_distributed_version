package xin.mengzuo.moviemanager.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xin.mengzuo.moviemanager.pojo.DataDict;
/**
 * 
 * @author 左利伟
 *
 */
@Repository
public interface DataDictRepository extends JpaRepository<DataDict, Integer> {

	
	List<DataDict> findAllByDictParentId(Integer dictParentId);
	List<DataDict> findAllByIsParent(Integer isPrarent);
}
