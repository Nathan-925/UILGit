package region2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Krithika {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("krithika.dat"));
		int cases = scan.nextInt();
		for(int i = 0; i < cases; i++) {
			long arr[] = new long[scan.nextInt()];
			int k = scan.nextInt();
			for(int j = 0; j < arr.length; j++)
				arr[j] = scan.nextLong();
			
			long out = 0;
			for(long l = 1L<<62; l > 0; l>>=1) {
				out |= l;
				int cnt = 0;
				for(long n: arr)
					if((out&n) == out)
						cnt++;
				if(cnt < k)
					out ^= l;
			}
			System.out.println("Case #"+(i+1)+": "+out);
		}
	}
}
