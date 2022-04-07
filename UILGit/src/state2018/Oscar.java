package state2018;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Oscar {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("oscar.dat"));
		
		while(scan.hasNextLine()) {
			ArrayList<String> words = new ArrayList<>(Arrays.asList(scan.nextLine().split("\\s+")));
			ArrayList<String> lines = new ArrayList<>();
			if(words.size() == 1)
				lines.add("");
			
			for(int i = 0; i < 3 && words.size() > 0; i++) {
				String s = "";
				do {
					if(s.length() + words.get(0).length() <= 10)
						s += words.remove(0)+" ";
					else
						break;
				}while(words.size() > 2-i);
				lines.add(s.trim());
			}
			while(lines.size() < 3)
				lines.add("");
			
			if(words.size() == 0) {
				System.out.println("************");
				for(String s: lines) {
					String out = "";
					for(int i = 0; i < (10-s.length())/2; i++)
						out += " ";
					out += s;
					for(int i = 0; i < (10-s.length()+1)/2; i++)
						out += " ";
					System.out.println("*"+out.replace(" ", ".")+"*");
				}
				System.out.println("************\n");
			}
			else
				System.out.println("SIGN CANNOT BE MADE\n");
			
		}
	}
}
