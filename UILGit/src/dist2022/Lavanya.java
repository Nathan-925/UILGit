package dist2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lavanya {
	
	static ArrayList<Integer> sieve;
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("lavanya.dat"));
		int cases = scan.nextInt();
		for(int i = 0; i < cases; i++) {
			int n = scan.nextInt();
			int n2 = n;
			ArrayList<Integer> factors = new ArrayList<>();
			if(sieve == null || sieve.get(sieve.size()-1) < n2)
				fillSieve(n2);
			
			while(n2 > 1) {
				int ind = 0;
				while(n2 % sieve.get(ind) != 0)
					ind++;
				factors.add(sieve.get(ind));
				n2 /= sieve.get(ind);
			}
			
			System.out.print(n+" = ");
			for(int j = 0; j < factors.size(); j++) {
				System.out.print(factors.get(j));
				if(j < factors.size()-1)
					System.out.print(" * ");
			}
			System.out.println();
		}
	}
	
	public static void fillSieve(int n) {
		sieve = new ArrayList<>();
		boolean crossed[] = new boolean[n+1];
		crossed[0] = crossed[1] = true;
		crossed[2] = false;
		int ind = 2;
		while(ind <= n) {
			if(!crossed[ind]) {
				sieve.add(ind);
				for(int i = ind; ind*i <= n; i++)
					crossed[i*ind] = true;
			}
			ind++;
		}
	}
}
