package xin.mengzuo.buyTicketsAndStatistic.controller;

import java.io.Serializable;
import java.util.List;



import xin.mengzuo.ticketmanager.controller.Ticket;

/**
 * 订单
 * @author 左利伟
 *
 */

public class Bill implements Serializable{

	private String billId;
	
	private String movieimage;
	
	private List<Ticket> list;
	
	private String ticketIds;
	
	private String movieId;
	private double totalMoney;
	
	
	private String movieName;
	
	private String date;

	




	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

	public String getMovieimage() {
		return movieimage;
	}

	public void setMovieimage(String movieimage) {
		this.movieimage = movieimage;
	}

	public List<Ticket> getList() {
		return list;
	}

	public void setList(List<Ticket> list) {
		this.list = list;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTicketIds() {
		return ticketIds;
	}

	public void setTicketIds(String ticketIds) {
		this.ticketIds = ticketIds;
	}
	
	
	
}
