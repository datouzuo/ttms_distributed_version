package xin.mengzuo.moviemanager.service;



import java.util.List;

import xin.mengzuo.moviemanager.pojo.Movie;
import xin.mengzuo.moviemanager.pojo.PageMovie;
/**
 * 
 * @author 左利伟
 *
 */
public interface MovieService {
 /**
  * 根据电影Id查找电影
  * @author 左利伟
  */
   Movie findByMovieId(String movieId);
   /**
    * 分页查找
    * @author 左利伟
    */
   PageMovie findByPage(Integer currentPage,Integer size);
   /**
    * 根据Id进行逻辑删除
    * @author 左利伟
    */
   void deleteMovie(String movieId);
   /**
    * 添加电影
    * @author 左利伟
    */
   void addMovie(Movie movie);
   /**
    * 更新电影
    * @author 左利伟
    */
   void updataMovie(Movie movie);
   
   /**
    * 顾客查看电影场次
    * @author 左利伟
    */
   List<Movie> cusFindAllMovie(); 
}
