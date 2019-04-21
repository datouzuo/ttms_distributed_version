package xin.mengzuo.moviemanager.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import xin.mengzuo.config.TtmsResult;
@FeignClient(value="moviemanager",fallback=MangerServiceImp.class)
public interface MovieMangerService {
	 
    //根据id找电影
    @RequestMapping(value="admin/movie/find/{movieId}",method = RequestMethod.GET)
	 public  TtmsResult findByMovieId(@PathVariable("movieId") String movieId);
  
    
            
    
    
  
    
    //用户查找电影，不需要登录的接口
    @RequestMapping(value = "/noLogin/findAllMovie",method=RequestMethod.GET)
    public TtmsResult cusFindAllMovie();
    
}
