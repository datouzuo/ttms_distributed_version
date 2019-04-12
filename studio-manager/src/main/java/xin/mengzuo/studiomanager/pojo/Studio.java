package xin.mengzuo.studiomanager.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Studio {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer studioId;
	private String studioName;
	private Integer studioRowCount;
	private Integer studioColCount;
	private String studioIntroduction;
	public Integer getStudioId() {
		return studioId;
	}
	public void setStudioId(Integer studioId) {
		this.studioId = studioId;
	}
	public String getStudioName() {
		return studioName;
	}
	public void setStudioName(String studioName) {
		this.studioName = studioName;
	}
	public Integer getStudioRowCount() {
		return studioRowCount;
	}
	public void setStudioRowCount(Integer studioRowCount) {
		this.studioRowCount = studioRowCount;
	}
	public Integer getStudioColCount() {
		return studioColCount;
	}
	public void setStudioColCount(Integer studioColCount) {
		this.studioColCount = studioColCount;
	}
	public String getStudioIntroduction() {
		return studioIntroduction;
	}
	public void setStudioIntroduction(String studioIntroduction) {
		this.studioIntroduction = studioIntroduction;
	}
	
	
}
