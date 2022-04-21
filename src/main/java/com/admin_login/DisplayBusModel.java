package com.admin_login;


	public class DisplayBusModel {
		private int   busId;
		private String busName;
		private String busFrom;
		private String busTo;
		private String busDate;
		private String busTiming;
		private int  busTicketsAvailable;
		private int  busTicketPrice;
		

	public int getBusId() {
			return busId;
		}
		public void setBusId(int busId) {
			this.busId = busId;
		}
		public String getBusName() {
			return busName;
		}
		public void setBusName(String busName) {
			this.busName = busName;
		}
		public String getBusFrom() {
			return busFrom;
		}
		public void setBusFrom(String busFrom) {
			this.busFrom = busFrom;
		}
		public String getBusTo() {
			return busTo;
		}
		public void setBusTo(String busTo) {
			this.busTo = busTo;
		}
		public String getBusDate() {
			return busDate;
		}
		public void setBusDate(String busDate) {
			this.busDate = busDate;
		}
		public String getBusTiming() {
			return busTiming;
		}
		public void setBusTiming(String busTiming) {
			this.busTiming = busTiming;
		}
		public int getBusTicketsAvailable() {
			return busTicketsAvailable;
		}
		public void setBusTicketsAvailable(int busTicketsAvailable) {
			this.busTicketsAvailable = busTicketsAvailable;
		}
		public int getBusTicketPrice() {
			return busTicketPrice;
		}
		public void setBusTicketPrice(int busTicketPrice) {
			this.busTicketPrice = busTicketPrice;
		}

		@Override
		public String toString() {
			return '\n'+ busId + "    " + busName + "    " + busFrom + "    " + busTo +"    "+ busDate+"     "+ busTicketsAvailable + "    " + busTicketPrice ;
		
		}
		
	
}
