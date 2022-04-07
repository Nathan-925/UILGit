package state2018;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Milo {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("milo.dat"));
		ArrayList<Character> list = new ArrayList<>(Arrays.asList('I', 'V', 'X', 'L', 'C', 'D', 'M'));
		ArrayList<Integer> vals = new ArrayList<>(Arrays.asList(1, 5, 10, 50, 100, 500, 1000));
		
		while(scan.hasNext()) {
			String s = scan.next();
			int total = 0;
			for(int i = 0; i < s.length(); i++) {
				if(i == s.length()-1 || list.indexOf(s.charAt(i)) >= list.indexOf(s.charAt(i+1)))
					total += vals.get(list.indexOf(s.charAt(i)));
				else
					total -= vals.get(list.indexOf(s.charAt(i)));
			}
			System.out.println(total);
		}
	}
}
