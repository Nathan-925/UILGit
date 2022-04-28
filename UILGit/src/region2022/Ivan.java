package region2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ivan {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("ivan.dat"));
		int cases = scan.nextInt();
		String key = scan.next();
		for(int i = 0; i < cases; i++) {
			String s = scan.next();
			int correct = 0, incorrect = 0;
			
			for(int j = 0; j < s.length(); j++)
				if(s.charAt(j) != '_')
					if(s.charAt(j) == key.charAt(j))
						correct++;
					else
						incorrect++;
			
			System.out.printf("Exam #%d: %d %.1f%n", i+1, correct*6 - incorrect*2, correct+incorrect==0 ? 0 : ((double)correct/(correct+incorrect))*100);
		}
	}
}
