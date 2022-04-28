package region2018;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Prashant {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("prashant.dat"));
		while(scan.hasNextLine()) {
			String arr[] = scan.nextLine().split("\\s+");
			HashMap<String, Integer> map = new HashMap<>();
			for(String s: arr) {
				if(!map.containsKey(s))
					map.put(s, 0);
				map.put(s, map.get(s)+1);
			}
			
			long num = fac(arr.length);
			for(String s: map.keySet())
				num /= fac(map.get(s));
			System.out.println(num);
		}
	}
	
	public static long fac(long n) {
		if(n <= 1)
			return 1;
		return n*fac(n-1);
	}
}
