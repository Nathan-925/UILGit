package region2018;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class Joe {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("joe.dat"));
		while(scan.hasNextLine()) {
			String arr[] = scan.nextLine().split("\\W+");
			TreeSet<String> set = new TreeSet<>((n, m) -> n.length()==m.length() ? n.compareTo(m) : Integer.compare(n.length(), m.length()));
			for(String s: arr)
				if(!s.isEmpty())
					set.add(s.toUpperCase());
			for(String s: set)
				System.out.print(s+" ");
			System.out.println();
		}
	}
}
