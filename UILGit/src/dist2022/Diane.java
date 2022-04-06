package dist2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Diane {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("diane.dat"));
		int cases = scan.nextInt();
		scan.nextLine();
		for(int i = 0; i < cases; i++) {
			Pattern pat = Pattern.compile("-?(\\d+)?\\s*((\\d+)/(\\d+))?");
			Fraction frac = new Fraction();
			for(String s: scan.nextLine().split(" and ")) {
				Matcher mat = pat.matcher(s);
				mat.matches();
				int whole = 0, num = 0, den = 1;
				if(mat.group(1) != null)
					whole = Integer.parseInt(mat.group(1));
				if(mat.group(2) != null) {
					num = Integer.parseInt(mat.group(3));
					den = Integer.parseInt(mat.group(4));					
				}
				if(s.charAt(0) == '-') {
					num *= -1;
					whole *= -1;
				}
				frac.add(whole*den+num, den);
			}
			frac.reduce();
			System.out.println(frac);
		}
	}
}

class Fraction{
	int num, den;
	
	public Fraction(int num, int den){
		this.num = num;
		this.den = den;
	}
	
	public Fraction() {
		this(0, 1);
	}
	
	public void add(int num, int den) {
		this.num = this.num*den + num*this.den;
		this.den *= den;
	}
	
	public void reduce() {
		int arr[] = {Math.abs(num), den};
		while(arr[1] != 0) {
			int temp = arr[1];
			arr[1] = arr[0]%arr[1];
			arr[0] = temp;
		}
		num /= arr[0];
		den /= arr[0];
	}
	
	@Override
	public String toString() {
		if(den == 1)
			return num+"";
		if(Math.abs(num) > den)
			return (num/den)+" "+Math.abs(num%den)+"/"+den;
		return num+"/"+den;
	}
	
}