package state2017;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Christina {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("christina.dat"));
		int cases = scan.nextInt();
		ArrayList<String> list = new ArrayList<>();
		for(int i = 0; i < cases; i++)
			list.add(scan.next());
		
		while(scan.hasNext()) {
			String s = scan.next();
			String out = "";
			while(s.length() > 0) {
				String name = list.get(Integer.parseInt(s.substring(0, 2))-1);
				char c = s.charAt(2);
				if(Character.isLowerCase(c)) {
					String temp = "";
					for(int i = name.length()-1; i >= 0; i--)
						temp += name.charAt(i);
					name = temp;
					c -= 32;
				}
				
				if(c == 'U')
					name = name.toUpperCase();
				else if(c == 'L')
					name = name.toLowerCase();
				
				out += name;
				s = s.substring(3);
			}
			System.out.println(out);
		}
	}
}
