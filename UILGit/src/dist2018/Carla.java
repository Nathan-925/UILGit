package dist2018;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Carla {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("carla.dat"));
		String rights = "xwr";
		while(scan.hasNext()) {
			String s = scan.next();
			int num = Integer.parseInt(s.substring(1), 8);
			String out = (s.charAt(0)=='F' ? "-" : ""+Character.toLowerCase(s.charAt(0)));
			for(int i = 1<<8; i > 0; i>>=1)
				out += (num & i) == i ? rights.charAt(Integer.numberOfTrailingZeros(i)%3) : '-';
			System.out.println(out);
		}
	}
}
