package xin.mengzuo.studiomanager.controller;

import java.io.Serializable;




public class Studio implements Serializable {

	
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
