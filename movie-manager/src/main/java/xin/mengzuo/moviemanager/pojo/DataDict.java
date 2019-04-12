package xin.mengzuo.moviemanager.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class DataDict {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
	private Integer dictId;
	private Integer dictParentId;
	private Integer dictIndex;
	private String dictName;
	
	
	private String dictValue;
	private Integer isParent;
	public Integer getisParent() {
		return isParent;
	}
	public void setIsParent(Integer isParent) {
		this.isParent = isParent;
	}
	public Integer getDictId() {
		return dictId;
	}
	public void setDictId(Integer dictId) {
		this.dictId = dictId;
	}
	public Integer getDictParentId() {
		return dictParentId;
	}
	public void setDictParentId(Integer dictParentId) {
		this.dictParentId = dictParentId;
	}
	public Integer getDictIndex() {
		return dictIndex;
	}
	public void setDictIndex(Integer dictIndex) {
		this.dictIndex = dictIndex;
	}
	public String getDictName() {
		return dictName;
	}
	public void setDictName(String dictName) {
		this.dictName = dictName;
	}
	public String getDictValue() {
		return dictValue;
	}
	public void setDictValue(String dictValue) {
		this.dictValue = dictValue;
	}
	
	
}
