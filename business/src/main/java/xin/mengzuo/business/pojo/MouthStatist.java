package xin.mengzuo.business.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author 左利伟
 *
 */
@Entity
public class MouthStatist {
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer mouthId;
	private String movieId;
	private Integer date;
	private double mouthMoney;
	
	private String dateMouth;
	
	public String getDateMouth() {
		return dateMouth;
	}
	public void setDateMouth(String dateMouth) {
		this.dateMouth = dateMouth;
	}
	public double getMouthMoney() {
		return mouthMoney;
	}
	public void setMouthMoney(double mouthMoney) {
		this.mouthMoney = mouthMoney;
	}
	public Integer getMouthId() {
		return mouthId;
	}
	public void setMouthId(Integer mouthId) {
		this.mouthId = mouthId;
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

	
}
