package xin.mengzuo.moviemanager.pojo;

import java.io.Serializable;
import java.util.List;

public class PageMovie implements Serializable{
  
	private Integer currentPage;
	private Integer totalpage;
	private List<Movie> movieList;
	public PageMovie() {
		
	}
	public PageMovie(Integer currentPage,Integer totalpage,
			List<Movie> movieList) {
		this.currentPage = currentPage;
		this.totalpage = totalpage;
		this.movieList = movieList;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(Integer totalpage) {
		this.totalpage = totalpage;
	}
	public List<Movie> getMovieList() {
		return movieList;
	}
	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}
	
	
}
