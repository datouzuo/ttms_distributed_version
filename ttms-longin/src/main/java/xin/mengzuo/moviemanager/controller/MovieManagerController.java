package xin.mengzuo.moviemanager.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import xin.mengzuo.config.TtmsResult;

/**
 * Movie的增删改查
 * @author 左利伟
 *
 */
//基础服务电影服务
//数据验证让前台服务进行
@RestController
public class MovieManagerController {
    @Autowired
	private MovieMangerService ms;
    
    //根据id找电影
    @RequestMapping("admin/movie/find/{movieId}")
	 public  TtmsResult findByMovieId(@PathVariable String movieId) {
		 return TtmsResult.ok(ms.findByMovieId(movieId));
	 }
    //用户查找电影，不需要登录的接口
    @RequestMapping("/noLogin/findAllMovie")
    public TtmsResult cusFindAllMovie() {
    	
    	
    	return ms.cusFindAllMovie();
    }
    
    
}