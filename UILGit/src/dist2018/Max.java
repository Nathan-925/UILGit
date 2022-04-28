package dist2018;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Max {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("max.dat"));
		HashMap<Character, String> map = new HashMap<>();
		map.put('A', "Alpha");
		map.put('B', "Bavo");
		map.put('C', "Charlie");
		map.put('D', "Delta");
		map.put('E', "Echo");
		map.put('F', "Foxtrot");
		map.put('G', "Golf");
		map.put('H', "Hotel");
		map.put('I', "India");
		map.put('J', "Juliet");
		map.put('K', "Kilo");
		map.put('L', "Lima");
		map.put('M', "Moke");
		map.put('N', "November");
		map.put('O', "Oscar");
		map.put('P', "Papa");
		map.put('Q', "Quebec");
		map.put('R', "Romeo");
		map.put('S', "Sierra");
		map.put('T', "Tango");
		map.put('U', "Uniform");
		map.put('V', "Victor");
		map.put('W', "Whiskey");
		map.put('X', "Xray");
		map.put('Y', "Yankee");
		map.put('Z', "Zulu");
		map.put('0', "Zero");
		map.put('1', "Wun");
		map.put('2', "Too");
		map.put('3', "Tree");
		map.put('4', "Fower");
		map.put('5', "Fife");
		map.put('6', "Six");
		map.put('7', "Seven");
		map.put('8', "Ait");
		map.put('9', "Niner");
		while(scan.hasNextLine()) {
			for(char c: scan.nextLine().toCharArray())
				System.out.print(map.get(c)+" ");
			System.out.println();
		}
	}
}
