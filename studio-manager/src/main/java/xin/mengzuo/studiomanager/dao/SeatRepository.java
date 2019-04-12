package xin.mengzuo.studiomanager.dao;
//
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import xin.mengzuo.studiomanager.pojo.Seat;
@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer>{
//将seatStatus状态改变
	//遗弃
	@Modifying
	@Query(value="update seat set seat_status = '0' where "
			+ "seat_id = ?1",nativeQuery=true)
	void updataStatusDel(Integer seatId);
	//将seatStatus状态改变
		//遗弃	
	@Modifying
	@Query(value="update seat set seat_status = '1' where "
			+ "seat_id = ?1",nativeQuery=true)
	void updataStatusAdd(Integer seatId);
	//插入,
	//遗弃
	@Modifying
	@Query(value="insert into seat (studio_id,seat_row,seat_column,seat_status) values"
			+ " (?1,?2,?3,?4)",nativeQuery=true)
	void insertSeat(int studioId,int i,int j,int status);
	//根据studioId删除
	@Modifying
	@Query(value="delete from seat where studio_id = ?1",nativeQuery=true)
	void deleteByStudioId(Integer studioId);
	
}
