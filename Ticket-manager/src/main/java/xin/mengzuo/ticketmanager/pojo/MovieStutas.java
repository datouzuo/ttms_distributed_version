package xin.mengzuo.ticketmanager.pojo;
/**
 * 生成演出计划的条
 * @author 左利伟
 *
 */

import javax.persistence.criteria.CriteriaBuilder.In;

public class MovieStutas {
//比重
	private Integer point;
	//价钱
	private Integer price;
	//大概场数
	private Integer count;
	//电影时长
	private Integer duration; 
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
}
