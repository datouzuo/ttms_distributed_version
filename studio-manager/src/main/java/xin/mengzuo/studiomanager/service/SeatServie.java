package xin.mengzuo.studiomanager.service;

import xin.mengzuo.studiomanager.pojo.Seat;
import xin.mengzuo.studiomanager.pojo.Studio;

public interface SeatServie {

	void updataByStatus(String seatIds);

	void addSeat(Studio Studio);
	void deleteByStudioId(Integer studioId);
}
