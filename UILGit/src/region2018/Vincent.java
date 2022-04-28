package region2018;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class Vincent {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("vincent.dat"));
		while(scan.hasNext()) {
			Calendar cal = new GregorianCalendar(scan.nextInt(), scan.nextInt()-1, scan.nextInt(), scan.nextInt(), scan.nextInt());
			System.out.println(getOutput(cal));
			System.out.println("-----");
			scan.nextLine();
			for(String s: scan.nextLine().split("\\s+")) {
				int n = Integer.parseInt(s);
				cal.add(Calendar.MINUTE, n);
				System.out.println(getOutput(cal));
				cal.add(Calendar.MINUTE, -n);
			}
			System.out.println("=====");
		}
	}
	
	public static String getOutput(Calendar cal) {
		return cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault())+" "+
			   cal.get(Calendar.DAY_OF_MONTH)+", "+
			   cal.get(Calendar.YEAR)+" - "+
			   String.format("%02d:%02d ", (cal.get(Calendar.HOUR)+11)%12+1, cal.get(Calendar.MINUTE))+
			   cal.getDisplayName(Calendar.AM_PM, Calendar.SHORT, Locale.getDefault());
	}
}
