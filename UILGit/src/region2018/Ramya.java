package region2018;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Ramya {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("ramya.dat"));
		while(scan.hasNext()) {
			Set<String> set = permute(scan.next(), 0, new LinkedHashSet<>());
			set.forEach(System.out::println);
			System.out.println("=====");
		}
	}
	
	public static Set<String> permute(String s, int start, Set<String> set){
		if(start == s.length() || set.size() >= 30)
			return set;
		set.add(s);
		for(int i = start; i < s.length(); i++) {
			char arr[] = s.toCharArray();
			char temp = arr[i];
			arr[i] = arr[start];
			arr[start] = temp;
			permute(String.valueOf(arr), start+1, set);
		}
		return set;
	}
}
