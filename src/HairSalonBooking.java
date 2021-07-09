//"Hair Salon Booking System"

//-----Menu------5 options
//A:Book
//B:Change booking
//C:Cancel booking
//D:View booking
//E:Exit the system

//A:Book
//Step1:select services ==>cut[1section] or color[2sec] or perm[2sec]
//Step2:select time
//Step3:Enter name

//B:Change booking
//Step1:Enter name
//Step2:Check booking
//Step3:Book again

//C:Cancel booking
//Step1:Enter name
//Step2:Check booking
//Step3:Cancel booking

//D:View booking
//Step1:Enter name
//Step2:Check booking


import java.util.Scanner;

public class HairSalonBooking {
//	private static boolean Menu= true;
	
	public static void main(String[] args) {
		boolean Menu = true;
		Scanner scan = new Scanner(System.in);
		Section[] section = new Section[8];
		for(int i=0;i<8;i++) {
			section[i]=new Section();
			section[i].setTimeSchedule("1"+i+":00-");
		}
		//This Hair Salon is open between 10 and 18
//		section[0] = new Section();
//		section[0].setTimeSchedule("10:00-");
//		section[1] = new Section();
//		section[1].setTimeSchedule("11:00-");
//		section[2] = new Section();
//		section[2].setTimeSchedule("12:00-");
//		section[3] = new Section();
//		section[3].setTimeSchedule("13:00-");
//		section[4] = new Section();
//		section[4].setTimeSchedule("14:00-");
//		section[5] = new Section();
//		section[5].setTimeSchedule("15:00-");
//		section[6] = new Section();
//		section[6].setTimeSchedule("16:00-");
//		section[7] = new Section();
//		section[7].setTimeSchedule("17:00-");
		int sectionNum = 0;
		initialise(section);
		char option;
		while(Menu) {
				  System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
	              System.out.println("Welcome to Java hair salon!!");
	              System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	              System.out.println("MENU");
	              System.out.println("---------------------------------------------------------------------------------------");
	              System.out.println("A: Book.");
	              System.out.println("---------------------------------------------------------------------------------------");
	              System.out.println("B: Change your booking.");
	              System.out.println("---------------------------------------------------------------------------------------");
	              System.out.println("C: Cancel your booking.");
	              System.out.println("---------------------------------------------------------------------------------------");
	              System.out.println("D: View your booking");
	              System.out.println("---------------------------------------------------------------------------------------");
	              System.out.println("E: Exit the system");
	              System.out.println("---------------------------------------------------------------------------------------");
	              System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	              System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
	              option = scan.next().charAt(0);
	              System.out.println("\n");

	              switch (Character.toLowerCase(option)) {
	              		case 'a':
	              			Book(section, sectionNum);
	              			break;
	              		case 'b':
	              			Change(section, sectionNum);
	              			break;
	              		case 'c':
	              			Cancel(section, sectionNum);
	              			break;
	              		case 'd':
	              			View(section);
	              			break;
	              		case 'e':
	              			System.out.println("=========================================================================================================");
	              			System.out.println("Thank you!! See you soon!!");
	              			System.exit(0);
	              			break;
	              		default:
	              			System.out.println("Invalid Option!! Please Enter Correct Option...");
	              			break;
	              }
	              System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
	              System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	              System.out.println("Would You Like To Continue With The System(y/n)?");
	              System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
	              System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	              if (scan.next().charAt(0)=='y') {
	                  Menu = true;
	              } else {
	            	  System.out.println("Thank you!! See you soon!!");
	                  System.exit(0);
	              }
			}
		scan.close();
		
	}
	
	//set "available" to all sections
	public static void initialise(Section[] section) {
		for(int i=0;i<section.length;i++) {
			section[i].setCustomerName("available");
		}
	}
	
	//For "Cut(1hour)"
	public static void checkAvailable(Section[] section) {
		for(int i=0; i<section.length;i++) {
			if(section[i].getCustomerName().equals("available")) {
				System.out.print((i+1)+". ");
				System.out.println(section[i].getTimeSchedule());
			}
		}
	}
	
	//For "Color&Perm(2hours)"
	public static void checkAvailable2(Section[] section) {
		for(int i=0; i<section.length-1;i++) {
			if(section[i].getCustomerName().equals("available")&&section[i+1].getCustomerName().equals("available")) {
				System.out.print((i+1)+". ");
				System.out.println(section[i].getTimeSchedule());
				
			}
		}
	}
	
	//Book
	//1.scan serviceNumber
	//2.checkAvailable
	//3.scan sectionNumber
	//4.scan customerName
	//5.setCustomerName
	//6.setServiceName
	public static void Book(Section[] section, int sectionNum) {
		String customerName;
		int serviceNum;
		String service;
		Scanner scan = new Scanner(System.in);
		System.out.println("Select services:");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("1: Cut");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("2: Color");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("3: Perm");
        System.out.println("---------------------------------------------------------------------------------------");
		serviceNum=scan.nextInt();
		System.out.println("Select time:");
		if(serviceNum==1) {
			checkAvailable(section);
			service="Cut";
		}else if(serviceNum==2) {
			checkAvailable2(section);
			service="Color";
		}else {
			checkAvailable2(section);
			service="Perm";
		}
		sectionNum = scan.nextInt()-1;
		System.out.println("Enter name:");
		customerName = scan.next();
		section[sectionNum].setCustomerName(customerName);
		section[sectionNum].setService(service);
		System.out.println("Your booking was confirmed.");
	}
	
	//Change
	//1.scan customerName
	//2.find booking from customerName
	//3.Book again
	//4.set "available" to previous booking
	public static void Change(Section[] section, int sectionNum) {
		Scanner scan = new Scanner(System.in);
		String customerName;
		System.out.println("Enter name:");
		customerName=scan.next();
		boolean booked=false; 
		String service;
		for(int i=0;i<section.length;i++) {
			if(customerName.equals(section[i].getCustomerName())){
				System.out.println("Your booking...");
				System.out.println(section[i].getService()+"("+section[i].getTimeSchedule()+")");
				booked=true;
				System.out.println("Do you want to change your booking(y/n)??");
				if(scan.next().charAt(0)=='y') {
					System.out.println("Select services:");
			        System.out.println("---------------------------------------------------------------------------------------");
			        System.out.println("1: Cut");
			        System.out.println("---------------------------------------------------------------------------------------");
			        System.out.println("2: Color");
			        System.out.println("---------------------------------------------------------------------------------------");
			        System.out.println("3: Perm");
			        System.out.println("---------------------------------------------------------------------------------------");
					int serviceNum;
					serviceNum=scan.nextInt();
					System.out.println("Select time:");
					if(serviceNum==1) {
						checkAvailable(section);
						service="Cut";
					}else if(serviceNum==2) {
						checkAvailable2(section);
						service="Color";
					}else {
						checkAvailable2(section);
						service="Perm";
					}
					sectionNum = scan.nextInt()-1;
					section[sectionNum].setCustomerName(customerName);
					section[sectionNum].setService(service);
					section[i].setCustomerName("available");
					System.out.println("Your booking was changed.");
					break;
				}
			}
		}
		if(booked ==false) {
			System.out.println("You don't have any booking.");
		}
	}
	
	//Cancel
	//1.scan customerName
	//2.find booking from customerName (verify all section[] with customerName)
	//3.set "available" to previous booking
	public static void Cancel(Section[] section, int sectionNum) {
		Scanner scan = new Scanner(System.in);
		String customerName;
		System.out.println("Enter name:");
		customerName=scan.next();
		boolean booked=false; 
		for(int i=0;i<section.length;i++) {
			if(customerName.equals(section[i].getCustomerName())){
				System.out.println("Do you want to cancel your booking(y/n)??");
				System.out.println(section[i].getService()+"("+section[i].getTimeSchedule()+")");
				booked=true;
				if(scan.next().charAt(0)=='y') {
					section[i].setCustomerName("available");
					System.out.println("Your booking was canceled.");
				}
			}
		}
		if(booked ==false) {
			System.out.println("You don't have any booking.");
		}		
	}
	
	//View
	//1.scan customerName
	//2.find booking from customerName
	public static void View(Section[] section) {
		Scanner scan = new Scanner(System.in);
		String customerName;
		System.out.println("Enter name:");
		customerName = scan.next();
		boolean booked=false; 
		for(int i=0;i<section.length;i++) {
			if(customerName.equals(section[i].getCustomerName())){
				System.out.print("Your booking:");
				System.out.println(section[i].getService()+"("+section[i].getTimeSchedule()+")");
				booked=true;
			}
		}
		if(booked == false) {
			System.out.println("You don't have any booking.");
		}
	}
	
	public static class Section{
		private String customerName;
		private String timeSchedule;
		private String service;
		
		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}
		public String getTimeSchedule() {
			return timeSchedule;
		}
		
		public void setTimeSchedule(String timeSchedule) {
			this.timeSchedule = timeSchedule;
		}
		public String getService() {
			return service;
		}
		
		public void setService(String service) {
			this.service = service;
		}
	}

}
