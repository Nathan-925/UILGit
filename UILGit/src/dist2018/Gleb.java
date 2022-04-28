package dist2018;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Gleb {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("gleb.dat"));
		while(scan.hasNext()) {
			String s = scan.next();
			int note = s.charAt(0)-67, octave = Integer.parseInt(s.substring(1));
			if(note < 0)
				note += 7;
			System.out.print((char)((note+2)%7+'A')+(octave+" "));
			while(scan.hasNextInt()) {
				int n = scan.nextInt();
				note += n-Math.signum(n);
				if(note < 0) {
					octave--;
					note += 7;
				}
				else if(note > 6) {
					octave++;
					note %= 7;
				}
				System.out.print((char)((note+2)%7+'A')+(octave+" "));
			}
			System.out.println();
		}
	}
}
