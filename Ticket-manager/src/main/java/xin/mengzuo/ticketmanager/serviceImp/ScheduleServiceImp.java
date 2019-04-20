package xin.mengzuo.ticketmanager.serviceImp;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xin.mengzuo.ticketmanager.config.TicketStatus;
import xin.mengzuo.ticketmanager.pojo.Schedule;
import xin.mengzuo.ticketmanager.pojo.Studio;
import xin.mengzuo.ticketmanager.pojo.Ticket;
import xin.mengzuo.ticketmanager.repository.ScheduleRepository;
import xin.mengzuo.ticketmanager.service.ScheduleService;
import xin.mengzuo.ticketmanager.service.TicketsService;

/**
 * 演出计划业务类
 * @author 左利伟
 *
 */
@Service
@Transactional
public class ScheduleServiceImp implements ScheduleService{
    @Autowired
	private ScheduleRepository scheRe;
    @Autowired
	private TicketsService TicketServiceImp;
	@Override
	public void addScheduleList(List<Schedule> list
			,Map<Integer,Studio> studioMap) {
		//插入所有的演出计划
		scheRe.saveAll(list);
		for(Schedule sche : list) {
			List<Ticket> ticketList = new LinkedList<>();
			Studio studio = studioMap.get(sche.getStudioId());
			int row = studio.getStudioRowCount();
			int col = studio.getStudioColCount();
			for(int i=1;i<=row;i++) {
				for(int j=1;j<=col;j++) {
					Ticket ticket = new Ticket();
					ticket.setSeatRow(i);
					ticket.setSeatColumn(j);
					ticket.setTicketStatus(TicketStatus.noSell);
					ticketList.add(ticket);
				}
			}
			//插入一场演出计划的所有票
			TicketServiceImp.addTicketList(ticketList);
		}
		
	}
	//查找指定的时间的场次
	@Override
	public List<Schedule> findThisSchedule(Long startTime, Long endTime) {
		List<Schedule> schedule = scheRe.findByStartTime(startTime, endTime);
		
		return schedule;
	}
	@Override
	public List<Schedule> findScheduleByIdAndTime(Long startTime, 
			Long endTime,String movieId) {
		
		return scheRe.findByMovieIdAndTime(startTime, endTime,
				movieId);
	}
	@Override
	public List<Ticket> findInTicketIds(List ticketId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
