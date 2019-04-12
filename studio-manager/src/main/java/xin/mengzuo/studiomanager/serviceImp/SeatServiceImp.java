package xin.mengzuo.studiomanager.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xin.mengzuo.studiomanager.dao.SeatRepository;
import xin.mengzuo.studiomanager.dao.StudioRepository;
import xin.mengzuo.studiomanager.pojo.Seat;
import xin.mengzuo.studiomanager.pojo.Studio;
import xin.mengzuo.studiomanager.service.SeatServie;
/**
 * 
 * @author 左利伟
 *
 */
@Service
@Transactional
public class SeatServiceImp implements SeatServie{


	@Autowired
	private SeatRepository sr;
	/**
	 * 改变座位状态
	 */
	@Override
	public void updataByStatus(String seatIds) {
	String[] s = seatIds.split("\\,");
		for(String ss : s) {
			Seat seat = sr.getOne(Integer.valueOf(ss));
			if(seat.getSeatStatus()==0) {
				seat.setSeatStatus(1);
			}else {
				seat.setSeatStatus(0);
			}
		}
	}
//1 为好的 0 为坏了
	//根据演出厅增加座位
	@Override
	public void addSeat(Studio studio) {
		List<Seat>  seats = new ArrayList<>();
		int studioId = studio.getStudioId();
		int row = studio.getStudioRowCount();
		int col = studio.getStudioColCount();
		int status=1;
		for(int i=1;i<=row;i++) {
			for(int j=1;j<=col;j++) {
				seats.add(new Seat(studioId, i, j, status));
			}
		}
		sr.saveAll(seats);
	}
	//根据演出厅删除所有座位
	@Override
	public void deleteByStudioId(Integer studioId) {
	
		sr.deleteByStudioId(studioId);
	}

	

}
