package xin.mengzuo.business.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 按日统计
 * @author 左利伟
 *
 */
@Entity
public class DayStatist {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer dayId;
	private String movieId;
	private Integer date;
	private double dayMoney;
	private String dateDay;
	
	public String getDateDay() {
		return dateDay;
	}
	public void setDateDay(String dateDay) {
		this.dateDay = dateDay;
	}
	public Integer getDayId() {
		return dayId;
	}
	public void setDayId(Integer dayId) {
		this.dayId = dayId;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public Integer getDate() {
		return date;
	}
	public void setDate(Integer date) {
		this.date = date;
	}
	public double getDayMoney() {
		return dayMoney;
	}
	public void setDayMoney(double dayMoney) {
		this.dayMoney = dayMoney;
	}
	
	
}
