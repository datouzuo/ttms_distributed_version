package xin.mengzuo.ticketmanager.controller;





public class Ticket {

	private Integer ticketId;
	private Integer ticketStatus;
	private Integer seatRow;
	private Integer seatColumn;
    private Integer schedId;

	public Integer getSchedId() {
		return schedId;
	}

	public void setSchedId(Integer schedId) {
		this.schedId = schedId;
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	

	public Integer getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(Integer ticketStatus) {
		this.ticketStatus = ticketStatus;
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




}
