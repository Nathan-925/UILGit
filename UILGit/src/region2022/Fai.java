package region2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Fai {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("fai.dat"));
		int cases = scan.nextInt();
		for(int i = 0; i < cases; i++) {
			scan.nextLine();
			
			HashMap<String, Integer> map = new HashMap<>();
			for(String s: scan.nextLine().split(","))
				map.put(s, 0);
			scan.nextLine();
			
			for(String s: scan.nextLine().split(",")) {
				String arr[] = s.split("<->");
				map.put(arr[0], map.get(arr[0])+1);
				map.put(arr[1], map.get(arr[1])+1);
			}
			
			System.out.print("Test case "+(i+1)+": ");
			for(String s: map.keySet())
				if(map.get(s)%2 != 0) {
					System.out.print("im");
					break;
				}
			System.out.println("possible");
		}
	}
}
