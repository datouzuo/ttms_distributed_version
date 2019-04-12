package xin.mengzuo.moviemanager.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.sql.PagerUtils;

import xin.mengzuo.moviemanager.dao.MovieRepository;
import xin.mengzuo.moviemanager.pojo.Movie;
import xin.mengzuo.moviemanager.pojo.PageMovie;
import xin.mengzuo.moviemanager.service.MovieService;
/**
 * 
 * @author 左利伟
 *  对电影进行管理
 */
@Service
@Transactional
public class MovieServiceImp implements MovieService{
    @Autowired
	private MovieRepository repository;
	//根据id查找电影
	@Override
	public Movie findByMovieId(String movieId) {
	
		return repository.findByMovieId(movieId);
	}
    //根据当前页和列数分页查找当前页数
	@Override
	public PageMovie findByPage(Integer currentPage,Integer size) {
		PageRequest page = PageRequest.of(currentPage,size );
		Page<Movie> movie = repository.findAll(page);
        PageMovie pageMovie = new PageMovie(currentPage,
        		movie.getTotalPages(), movie.getContent());
		return pageMovie;
	}
    //根据movieId逻辑的删除电影
	//status 1 为  -1为删除
	@Override
	public void deleteMovie(String movieId) {
		
		repository.updateMovieId(movieId);;
	}
    //添加movie
	@Override
	public void addMovie(Movie movie) {
		repository.save(movie);
		
	}
   //更新电影
	@Override
	public void updataMovie(Movie movie) {
		repository.saveAndFlush(movie);
		
	}

}
