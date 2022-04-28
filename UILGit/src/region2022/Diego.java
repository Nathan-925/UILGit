package region2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Diego {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("diego.dat"));
		int cases = scan.nextInt();
		for(int i = 0; i < cases; i++) {
			int length = scan.nextInt(), guesses = scan.nextInt();
			LinkedList<String> list = gen(length, "", new LinkedList<>());
			for(int j = 0; j < guesses; j++) {
				String s = scan.next();
				int contains = scan.nextInt(), aligned = scan.nextInt();
				list.removeIf(n -> !(contains(n, s, contains) && aligned(n, s, aligned)));
			}
			System.out.println(list.size());
		}
	}
	
	public static boolean contains(String test, String guess, int n) {
		int cnt = 0;
		for(char c: guess.toCharArray())
			if(test.contains(c+"")) {
				test = test.substring(0, test.indexOf(c))+test.substring(test.indexOf(c)+1);
				cnt++;
			}
		return cnt == n;
	}
	
	public static boolean aligned(String test, String guess, int n) {
		int cnt = 0;
		for(int i = 0; i < test.length(); i++)
			if(test.charAt(i) == guess.charAt(i))
				cnt++;
		return cnt == n;
	}
	
	public static LinkedList<String> gen(int len, String s, LinkedList<String> list){
		if(s.length() >= len)
			list.add(s);
		else
			for(int i = 0; i <= 9; i++)
				gen(len, s+i, list);
		return list;
	}
}
