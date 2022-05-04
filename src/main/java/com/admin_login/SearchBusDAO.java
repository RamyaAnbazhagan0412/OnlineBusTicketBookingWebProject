package com.admin_login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;




public class SearchBusDAO {

		//This method is used to display all bus available
		public static List<Bus> selectAll()throws Exception
		{
			//1.Create list to display all buses
			List<Bus> busList=new ArrayList<Bus>();
			
			//2.get connection
			Connection connection=null;
			PreparedStatement statement=null;
			connection=ConnectionUtil.getConnection();
			
			//3.Pass Query
			String query="SELECT bus_id,bus_name,bus_from ,bus_to , bus_timing, bus_tickets,bus_ticket_price FROM bus_ticket_booking_app_display";
			statement=connection.prepareStatement(query);
			
			ResultSet rs=statement.executeQuery();
			System.out.println("\nBus Id \t\t\t Bus Name  \t\t\t Bus From \t\t\t Bus To \t\t\t Bus Date\t\t\t Bus Timing ");
			while(rs.next())
			{
				
				// 4.Storing all data from database in variables
				Integer id=rs.getInt("bus_id");
				String busName=rs.getString("bus_name");
				String busFrom=rs.getString("bus_from");
				String busTo=rs.getString("bus_to");
				String busTiming=rs.getString("bus_timing");
				Integer busTickets=rs.getInt("bus_tickets");
				Integer busTicketPrice=rs.getInt("bus_ticket_Price");
				
				//5.Creating object for Bus class and setting stored  variables in bus class
				Bus bus= new Bus();
				bus.setBusId(id);
				bus.setBusName(busName);
				bus.setBusFrom(busFrom);
				bus.setBusTo(busTo);
				bus.setBusTicketsAvailable(busTickets);
				bus.setBusTiming(busTiming);
				bus.setBusTicketPrice(busTicketPrice);
				
				//6.adding bus object into list
				busList.add(bus);
			}

			
			connection.close();
			return busList;
			
		}
		
		//This is method is used to search bus by bus name
		public static  List<Bus> BusListByName(Bus busObj)throws Exception
		{
		
			//1.Create list to display all buses
					List<Bus> busList=new ArrayList<Bus>();
					
					//2.get connection
					Connection connection=null;
					PreparedStatement statement=null;
					connection=ConnectionUtil.getConnection();
					
					//3.Pass Query
					String query="SELECT bus_id,bus_name,bus_from ,bus_to , bus_timing, bus_tickets,bus_ticket_price FROM bus_ticket_booking_app_display WHERE bus_name  LIKE ?";
					statement=connection.prepareStatement(query);
					statement.setString(1,busObj.getBusName()+"%");
					ResultSet rs=statement.executeQuery();
					Bus bus=null;
					System.out.println("\nBus Id \t\t\t Bus Name  \t\t\t Bus From \t\t\t Bus To \t\t\t Bus Date\t\t\t Bus Timing ");
					while(rs.next())
					{
						
						// 4.Storing all data from database in variables
						Integer id=rs.getInt("bus_id");
						String busName=rs.getString("bus_name");
						String busFrom=rs.getString("bus_from");
						String busTo=rs.getString("bus_to");
						String busTiming=rs.getString("bus_timing");
						Integer busTickets=rs.getInt("bus_tickets");
						Integer busTicketPrice=rs.getInt("bus_ticket_Price");
						bus=new Bus();
						//5.setting stored  variables in bus class
						bus.setBusId(id);
						bus.setBusName(busName);
						bus.setBusFrom(busFrom);
						bus.setBusTo(busTo);
						bus.setBusTicketsAvailable(busTickets);
						bus.setBusTiming(busTiming);
						bus.setBusTicketPrice(busTicketPrice);
						
						//6.adding bus object into list
						busList.add(bus);
					}

					
					connection.close();
					return busList;
		
			}
		
		//This is method is used to search bus by from location
		public static List<Bus> BusListByBusFrom(Bus busObj)throws Exception
		{
			
				//1.Create list to display all buses
					List<Bus> busList=new ArrayList<Bus>();
					
					//2.get connection
					Connection connection=null;
					PreparedStatement statement=null;
					connection=ConnectionUtil.getConnection();
					
					//3.Pass Query
					String query="SELECT bus_id,bus_name,bus_from ,bus_to , bus_timing, bus_tickets,bus_ticket_price FROM bus_ticket_booking_app_display WHERE bus_from  LIKE ?";
					statement=connection.prepareStatement(query);
					statement.setString(1,busObj.getBusFrom()+'%');
					ResultSet rs=statement.executeQuery();
					Bus bus=null;
					System.out.println("\nBus Id \t\t\t Bus Name  \t\t\t Bus From \t\t\t Bus To \t\t\t Bus Date\t\t\t Bus Timing ");
					while(rs.next())
					{
						
						// 4.Storing all data from database in variables
						bus=new Bus();
						Integer id=rs.getInt("bus_id");
						String busName=rs.getString("bus_name");
						String busFrom=rs.getString("bus_from");
						String busTo=rs.getString("bus_to");
						String busTiming=rs.getString("bus_timing");
						Integer busTickets=rs.getInt("bus_tickets");
						Integer busTicketPrice=rs.getInt("bus_ticket_Price");
						
						//5.setting stored  variables in bus class
						bus.setBusId(id);
						bus.setBusName(busName);
						bus.setBusFrom(busFrom);
						bus.setBusTo(busTo);
						bus.setBusTicketsAvailable(busTickets);
						bus.setBusTiming(busTiming);
						bus.setBusTicketPrice(busTicketPrice);
						
						//6.adding bus object into list
						busList.add(bus);
					}

					
					connection.close();
					return busList;
	}
		
		//This is method is used to search bus by to location
			public static List<Bus> BusListByBusTo(Bus busObj)throws Exception
			{
				
					//1.Create list to display all buses
						List<Bus> busList=new ArrayList<Bus>();
						
						//2.get connection
						Connection connection=null;
						PreparedStatement statement=null;
						connection=ConnectionUtil.getConnection();
						
						//3.Pass Query
						String query="SELECT bus_id,bus_name,bus_from ,bus_to , bus_timing, bus_tickets,bus_ticket_price FROM bus_ticket_booking_app_display WHERE bus_to  LIKE ?";
						statement=connection.prepareStatement(query);
						statement.setString(1,busObj.getBusTo()+"%" );
						ResultSet rs=statement.executeQuery();
						Bus bus=null;
						System.out.println("\nBus Id \t\t\t Bus Name  \t\t\t Bus From \t\t\t Bus To \t\t\t Bus Date\t\t\t Bus Timing ");
						while(rs.next())
						{
							
							// 4.Storing all data from database in variables
							Integer id=rs.getInt("bus_id");
							String busName=rs.getString("bus_name");
							String busFrom=rs.getString("bus_from");
							String busTo=rs.getString("bus_to");
							String busTiming=rs.getString("bus_timing");
							Integer busTickets=rs.getInt("bus_tickets");
							Integer busTicketPrice=rs.getInt("bus_ticket_Price");
							
							bus=new Bus();
							//5.setting stored  variables in bus class
							bus.setBusId(id);
							bus.setBusName(busName);
							bus.setBusFrom(busFrom);
							bus.setBusTo(busTo);
							bus.setBusTicketsAvailable(busTickets);
							bus.setBusTiming(busTiming);
							bus.setBusTicketPrice(busTicketPrice);
							
							//6.adding bus object into list
							busList.add(bus);
						}

						
						connection.close();
						return busList;
		}



		//This is method is used to search bus by bus timing
				public static List<Bus> BusListByBusTiming(Bus busObj)throws Exception
				{
					
						//1.Create list to display all buses
							List<Bus> busList=new ArrayList<Bus>();
							
							//2.get connection
							Connection connection=null;
							PreparedStatement statement=null;
							connection=ConnectionUtil.getConnection();
							
							//3.Pass Query
							String query="SELECT bus_id,bus_name,bus_from ,bus_to , bus_timing, bus_tickets,bus_ticket_price FROM bus_ticket_booking_app_display WHERE bus_timing  LIKE ?";
							statement=connection.prepareStatement(query);
							statement.setString(1,busObj.getBusTiming()+"%" );
							ResultSet rs=statement.executeQuery();
							Bus bus=null;
							System.out.println("\nBus Id \t\t\t Bus Name  \t\t\t Bus From \t\t\t Bus To \t\t\t Bus Date\t\t\t Bus Timing ");
							while(rs.next())
							{
								
								// 4.Storing all data from database in variables
								Integer id=rs.getInt("bus_id");
								String busName=rs.getString("bus_name");
								String busFrom=rs.getString("bus_from");
								String busTo=rs.getString("bus_to");
								String busTiming=rs.getString("bus_timing");
								Integer busTickets=rs.getInt("bus_tickets");
								Integer busTicketPrice=rs.getInt("bus_ticket_Price");
								
								bus=new Bus();
								//5.setting stored  variables in bus class
								bus.setBusId(id);
								bus.setBusName(busName);
								bus.setBusFrom(busFrom);
								bus.setBusTo(busTo);
								bus.setBusTicketsAvailable(busTickets);
								bus.setBusTiming(busTiming);
								bus.setBusTicketPrice(busTicketPrice);
								
								//6.adding bus object into list
								busList.add(bus);
							}

							
							connection.close();
							return busList;
			}
				
		//This is method is used to search bus by bus tickets available
		public static List<Bus> BusListByBusTicketsAvailable(Bus busObj)throws Exception
		{
			
				//1.Create list to display all buses
					List<Bus> busList=new ArrayList<Bus>();
					
					//2.get connection
					Connection connection=null;
					PreparedStatement statement=null;
					connection=ConnectionUtil.getConnection();
					
					//3.Pass Query
					String query="SELECT bus_id,bus_name,bus_from ,bus_to , bus_timing, bus_tickets,bus_ticket_price FROM bus_ticket_booking_app_display WHERE bus_tickets  LIKE ?";
					statement=connection.prepareStatement(query);
					statement.setInt(1,busObj.getBusTicketsAvailable());
					ResultSet rs=statement.executeQuery();
					Bus bus=null;
					System.out.println("\nBus Id \t\t\t Bus Name  \t\t\t Bus From \t\t\t Bus To \t\t\t Bus Date\t\t\t Bus Timing ");
					while(rs.next())
					{
						
						// 4.Storing all data from database in variables
						Integer id=rs.getInt("bus_id");
						String busName=rs.getString("bus_name");
						String busFrom=rs.getString("bus_from");
						String busTo=rs.getString("bus_to");
						String busTiming=rs.getString("bus_timing");
						Integer busTickets=rs.getInt("bus_tickets");
						Integer busTicketPrice=rs.getInt("bus_ticket_Price");
						
						bus=new Bus();
						//5.setting stored  variables in bus class
						bus.setBusId(id);
						bus.setBusName(busName);
						bus.setBusFrom(busFrom);
						bus.setBusTo(busTo);
						bus.setBusTicketsAvailable(busTickets);
						bus.setBusTiming(busTiming);
						bus.setBusTicketPrice(busTicketPrice);
						
						//6.adding bus object into list
						busList.add(bus);
					}

					
					connection.close();
					return busList;
	}

		//This is method is used to search bus by bus tickets available
		public static List<Bus> BusListByBusTicketPrice(Bus busObj)throws Exception
		{
			
				//1.Create list to display all buses
					List<Bus> busList=new ArrayList<Bus>();
					
					//2.get connection
					Connection connection=null;
					PreparedStatement statement=null;
					connection=ConnectionUtil.getConnection();
					
					//3.Pass Query
					String query="SELECT bus_id,bus_name,bus_from ,bus_to , bus_timing, bus_tickets,bus_ticket_price FROM bus_ticket_booking_app_display WHERE bus_ticket_price  LIKE ?";
					statement=connection.prepareStatement(query);
					statement.setInt(1,busObj.getBusTicketPrice());
					ResultSet rs=statement.executeQuery();
					Bus bus=null;
					System.out.println("\nBus Id \t\t\t Bus Name  \t\t\t Bus From \t\t\t Bus To \t\t\t Bus Date\t\t\t Bus Timing ");
					while(rs.next())
					{
						
						// 4.Storing all data from database in variables
						Integer id=rs.getInt("bus_id");
						String busName=rs.getString("bus_name");
						String busFrom=rs.getString("bus_from");
						String busTo=rs.getString("bus_to");
						String busTiming=rs.getString("bus_timing");
						Integer busTickets=rs.getInt("bus_tickets");
						Integer busTicketPrice=rs.getInt("bus_ticket_Price");
						
						bus=new Bus();
						//5.setting stored  variables in bus class
						bus.setBusId(id);
						bus.setBusName(busName);
						bus.setBusFrom(busFrom);
						bus.setBusTo(busTo);
						bus.setBusTicketsAvailable(busTickets);
						bus.setBusTiming(busTiming);
						bus.setBusTicketPrice(busTicketPrice);
						
						//6.adding bus object into list
						busList.add(bus);
					}

					
					connection.close();
					return busList;
	}



	}