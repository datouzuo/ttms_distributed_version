package xin.mengzuo.studiomanager.service;

import java.util.List;

import xin.mengzuo.studiomanager.pojo.Studio;

public interface StudioService {
  
  void addStudio(Studio studio);
   void deleteStudio(Integer studioId);
   List<Studio> findAll();
   Studio findStudio(Integer studioId);

}
