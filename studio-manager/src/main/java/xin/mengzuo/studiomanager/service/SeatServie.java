package xin.mengzuo.studiomanager.service;

import java.util.List;

import xin.mengzuo.studiomanager.pojo.Seat;
import xin.mengzuo.studiomanager.pojo.Studio;

public interface SeatServie {

	void updataByStatus(String seatIds);

	void addSeat(Studio Studio);
	void deleteByStudioId(Integer studioId);
	
	List<Seat> findByStudioId(Integer studioId);
}
