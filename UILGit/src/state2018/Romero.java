package state2018;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Romero {
	
	static String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	
	public static void main(String args[]) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("romero.dat"));
		System.out.printf("%-19s%-11s%-11s%-6s%-6s%-7s%-9s|%n", "Date", "Attendance", "Gross", "ATP", "STP", "Adults", "Stu/Child");
		int cases = scan.nextInt();
		for(int i = 0; i < cases; i++) {
			String date[] = scan.next().split("/");
			String longDate = months[Integer.parseInt(date[0])-1]+" "+date[1]+", "+date[2];
			
			int people = scan.nextInt();
			double gross = scan.nextDouble();
			double atp = scan.nextDouble(), stp = scan.nextDouble();
			int students = (int)(((people*atp)-gross)/(atp-stp));
			int adults = people-students;
			
			String grossString = String.format("%.2f", gross);
			int start = grossString.indexOf(".");
			for(int j = start-1; j >= 0; j--) {
				if((j-start)%3 == 0) {
					grossString = grossString.substring(0, j)+","+grossString.substring(j);
					j--;
				}
			}
			
			System.out.printf("%-19s%-11d$%-10s$%-5.2f$%-5.2f%-7d%-9d|%n", longDate, people, grossString, atp, stp, adults, students);
		}
	}
}
