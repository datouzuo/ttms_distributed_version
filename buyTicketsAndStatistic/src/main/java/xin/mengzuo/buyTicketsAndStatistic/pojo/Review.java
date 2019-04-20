package xin.mengzuo.buyTicketsAndStatistic.pojo;

import java.io.Serializable;

/**
 * 评论类
 * @author 左利伟
 *
 */
public class Review implements Serializable {
private String movieId;
private String username;
private String date;
public String getMovieId() {
	return movieId;
}
public void setMovieId(String movieId) {
	this.movieId = movieId;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
	

}
