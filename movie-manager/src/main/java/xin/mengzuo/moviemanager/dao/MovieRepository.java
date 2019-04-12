package xin.mengzuo.moviemanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.ResponseBody;

import xin.mengzuo.moviemanager.pojo.Movie;
@ResponseBody
public interface MovieRepository extends JpaRepository<Movie, String> {
	@Modifying
	@Query(value="update movie set movie_status = '-1' where movie_id =?1",nativeQuery=true)
	void updateMovieId(String MovieId);
   
    Movie findByMovieId(String movieId);
	
}
