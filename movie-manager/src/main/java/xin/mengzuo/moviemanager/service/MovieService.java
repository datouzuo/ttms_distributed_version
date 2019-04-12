package xin.mengzuo.moviemanager.service;



import xin.mengzuo.moviemanager.pojo.Movie;
import xin.mengzuo.moviemanager.pojo.PageMovie;

public interface MovieService {
 
   Movie findByMovieId(String movieId);
   PageMovie findByPage(Integer currentPage,Integer size);
   void deleteMovie(String movieId);
   void addMovie(Movie movie);
   void updataMovie(Movie movie);
}
