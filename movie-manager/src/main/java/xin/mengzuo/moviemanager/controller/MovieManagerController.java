package xin.mengzuo.moviemanager.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import xin.mengzuo.moviemanager.config.TtmsResult;
import xin.mengzuo.moviemanager.pojo.Movie;
import xin.mengzuo.moviemanager.pojo.PageMovie;
import xin.mengzuo.moviemanager.service.MovieService;
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
	private MovieService ms;
    
    //根据id找电影
    @RequestMapping("admin/movie/find/{movieId}")
	 public  TtmsResult findByMovieId(@PathVariable String movieId) {
		 return TtmsResult.ok(ms.findByMovieId(movieId));
	 }
    //分页传入当前页和当前大小
    @RequestMapping("admin/movie/findList/{currentPage}/{size}")
	 public TtmsResult findByPage(@PathVariable Integer currentPage
			 ,@PathVariable Integer size){

		 return TtmsResult.ok(ms.findByPage(currentPage, size));
	 }
    //根据id逻辑删除
    @RequestMapping("admin/delete/{movieId}")
	 public TtmsResult deleteMovie(@PathVariable String movieId) {
		ms.deleteMovie(movieId);
		return TtmsResult.ok();
	 }
    //添加电影
   /* ,MultipartFile[] files*/
    @RequestMapping("admin/movie/add")
	 public TtmsResult addMovie( Movie movie,MultipartFile[] files,HttpServletRequest request) throws IllegalStateException, IOException {
		
    	StringBuilder sb = new StringBuilder();
    	for(MultipartFile file : files) {  
        
                String picName = UUID.randomUUID().toString();
                // 获取文件名
                String oriName = file.getOriginalFilename();
                   
                // 获取图片后缀
                String extName = oriName.substring(oriName.lastIndexOf("."));
                  
                    String pic=null;
                if(extName.equals(".jpg")||extName.equals(".png")){
                      pic=Thread.currentThread().getContextClassLoader().getResource("").getPath()+"static/img"+picName+extName;//拼接图片地
                    String iamages = request.getRemoteAddr()+":"+request.getRemotePort()+"/img/"+picName+extName;
                      file.transferTo(new File(pic));
                    // 设置图片名到商品中
                    sb.append(pic).append(",");
                    System.err.println("上传图片完成");
                }
                  
                }
    	movie.setMovieImages(sb.toString());
    	movie.setMovieStatus(1);
    	ms.addMovie(movie);
    	return TtmsResult.ok();
            
		
	 }
    
    /* ,MultipartFile[] files*/
    @RequestMapping("admin/movie")
	 public TtmsResult addMovie(MultipartFile[] files) throws IllegalStateException, IOException {
		StringBuilder sb = new StringBuilder();
		
    	for(MultipartFile file : files) {  
        
                String picName = UUID.randomUUID().toString();
                // 获取文件名
                String oriName = file.getOriginalFilename();
                    System.err.println(oriName+"图片名字");
                // 获取图片后缀
                String extName = oriName.substring(oriName.lastIndexOf("."));
                    System.err.println("后缀名字"+extName);
                    String pic=null;
                if(extName.equals(".jpg")||extName.equals(".png")){
                      pic=Thread.currentThread().getContextClassLoader().getResource("").getPath()+"static/img/"+picName+extName;//拼接图片地
                    file.transferTo(new File(pic));
                    // 设置图片名到商品中
                    sb.append(pic).append(",");
                    System.err.println("上传图片完成");
                }
                  
                }
    	
    	return TtmsResult.ok();
            
		
	 }
    
    
    //更新电影
    @RequestMapping("admin/movie/updata")
	  public TtmsResult updataByStatus(@RequestBody Movie movie) {
		   ms.updataMovie(movie);
		    return TtmsResult.ok();
	   }
    
   /* @RequestMapping("/update/{movieId}")
    public void update(@PathVariable Integer movieId) {
    	
    }*/
    //用户查找电影，不需要登录的接口
    @RequestMapping("/noLogin/findAllMovie")
    public TtmsResult cusFindAllMovie() {
    	
    	
    	
    	return null;
    }
    
    
}