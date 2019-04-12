package xin.mengzuo.studiomanager.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Seat {
     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer seatId;
	private Integer studioId;
	private Integer seatRow;
	private Integer seatColumn;
	private Integer seatStatus;
	public Seat (Integer studioId,Integer seatRow,Integer seatColumn,Integer seatStatus) {
		this.studioId=studioId;
		this.seatRow=seatRow;
		this.seatColumn=seatColumn;
		this.seatStatus=seatStatus;
	}
	public Integer getSeatId() {
		return seatId;
	}
	public void setSeatId(Integer seatId) {
		this.seatId = seatId;
	}
	public Integer getStudioId() {
		return studioId;
	}
	public void setStudioId(Integer studioId) {
		this.studioId = studioId;
	}
	public Integer getSeatRow() {
		return seatRow;
	}
	public void setSeatRow(Integer seatRow) {
		this.seatRow = seatRow;
	}
	public Integer getSeatColumn() {
		return seatColumn;
	}
	public void setSeatColumn(Integer seatColumn) {
		this.seatColumn = seatColumn;
	}
	public Integer getSeatStatus() {
		return seatStatus;
	}
	public void setSeatStatus(Integer seatStatus) {
		this.seatStatus = seatStatus;
	}
	
}
