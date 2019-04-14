package xin.mengzuo.ticketmanager.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author 左利伟
 */
@Entity
public class Schedule {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer schedId;
	private Integer studioId;
	private String movieId;
	private Long schedStartTime;
	private Long schedEndTime;
	private Integer tickerPrice;
	public Integer getSchedId() {
		return schedId;
	}
	public void setSchedId(Integer schedId) {
		this.schedId = schedId;
	}
	public Integer getStudioId() {
		return studioId;
	}
	public void setStudioId(Integer studioId) {
		this.studioId = studioId;
	}


	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public Long getSchedStartTime() {
		return schedStartTime;
	}
	public void setSchedStartTime(Long schedStartTime) {
		this.schedStartTime = schedStartTime;
	}
	public Long getSchedEndTime() {
		return schedEndTime;
	}
	public void setSchedEndTime(Long schedEndTime) {
		this.schedEndTime = schedEndTime;
	}
	public Integer getTickerPrice() {
		return tickerPrice;
	}
	public void setTickerPrice(Integer tickerPrice) {
		this.tickerPrice = tickerPrice;
	}
	
	
}
