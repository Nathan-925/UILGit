package region2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Arya {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("arya.dat"));
		int cases = scan.nextInt();
		for(int i = 0; i < cases; i++) {
			int low = 1, high = scan.nextInt(), ans = scan.nextInt(), mid;
			do {
				mid = (low+high)/2;
				System.out.println(low+"-"+mid+"-"+high);
				if(ans < mid)
					high = mid-1;
				else
					low = mid+1;
			} while(mid != ans);
			System.out.println("GOT IT!!!");
		}
	}
}
