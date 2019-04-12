package xin.mengzuo.studiomanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xin.mengzuo.studiomanager.pojo.Studio;

@Repository
public interface StudioRepository extends JpaRepository<Studio, Integer>{

}
