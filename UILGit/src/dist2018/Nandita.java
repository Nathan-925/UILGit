package dist2018;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Nandita {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("nandita.dat"));
		Pattern p = Pattern.compile("(\\w+) (\\d+), (\\d+)");
		ArrayList<String> list = new ArrayList<>();
		list.add("JANUARY");
		list.add("FEBRUARY");
		list.add("MARCH");
		list.add("APRIL");
		list.add("MAY");
		list.add("JUNE");
		list.add("JULY");
		list.add("AUGUST");
		list.add("SEPTEMBER");
		list.add("OCTOBER");
		list.add("NOVEMBER");
		list.add("DECEMBER");
		while(scan.hasNextLine()) {
			Matcher m = p.matcher(scan.nextLine());
			m.matches();
			int month = list.indexOf(m.group(1))+1, day = Integer.parseInt(m.group(2)), year = Integer.parseInt(m.group(3));
			System.out.printf("%02d/%02d/%d%n", month, day, year%100);
			System.out.printf("%02d.%02d.%d%n", day, month, year);
			System.out.printf("%d-%02d-%02d%n", year, month, day);
			System.out.println("=====");
		}
	}
}
