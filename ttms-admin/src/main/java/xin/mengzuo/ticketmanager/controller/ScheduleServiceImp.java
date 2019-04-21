package xin.mengzuo.ticketmanager.controller;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;

import xin.mengzuo.config.TtmsResult;
import xin.mengzuo.studiomanager.controller.SeatService;
import xin.mengzuo.studiomanager.controller.Studio;
@FeignClient(value="seat-studio",fallback=SeatService.class)
public class ScheduleServiceImp implements ScheduleService{

	@Override
	public TtmsResult creatSchedule(List<String> scheduleList, Map<Integer, Studio> studio, int day) {
		return TtmsResult.build(400, "超时");
	}

	@Override
	public TtmsResult getThisSchedule(String movieId) {
		return TtmsResult.build(400, "超时");
	}

	@Override
	public TtmsResult getOtherDaySchedule(int day, String movieId) {
		return TtmsResult.build(400, "超时");
	}
	
}
