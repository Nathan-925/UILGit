package dist2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Facundo {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("facundo.dat"));
		int cases = scan.nextInt();
		for(int i = 0; i < cases; i++) {
			String deck = scan.next();
			int shuffles = scan.nextInt();
			String lead = "";
			if(deck.length()%2 != 0) {
				lead += deck.charAt(0);
				deck = deck.substring(1);
			}
			for(int j = 0; j < shuffles; j++) {
				String upper = deck.substring(0, deck.length()/2),
					   lower = deck.substring(deck.length()/2);
				deck = "";
				for(int l = lower.length()-1; l >= 0; l--)
					deck = ""+lower.charAt(l)+upper.charAt(l)+deck;
				if(upper.length() > lower.length())
					deck = upper.charAt(0)+deck;
			}
			System.out.println(lead+deck);
		}
	}
}
