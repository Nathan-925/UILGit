package state2017;

public class Arun {
	public static void main(String[] args) {
		String s1 = "STATEUILCOMPUTERSCIENCEPROGRAMMINGCONTEST";
		String s2 = "";
		for(int i = s1.length()-1; i >= 0; i--)
			s2 += s1.charAt(i);
		String s3 = "STIOURICRRMGNS";
		for(int i = 0; i < s3.length(); i++) {
			for(int j = 0; j < 40; j++)
				System.out.print(s3.charAt(i));
			System.out.println();
			System.out.println(s1);
			if(i < s3.length()-1)
				System.out.println(s2);
		}
	}
}
