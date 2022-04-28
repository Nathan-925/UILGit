package region2018;

public class Ariana {
	public static void main(String[] args) {
		String arr[] = {"i", "must", "not", "tell", "lies."};
		int ind = 0, step = -1;
		for(int i = 0; i < 40; i++) {
			System.out.printf("%-3d", i+1);
			for(int j = 0; j < arr.length; j++)
				if(j == ind)
					System.out.print(arr[j].toUpperCase()+" ");
				else
					System.out.print(arr[j]+" ");
			if(ind == 0 || ind == arr.length-1)
				step *= -1;
			ind += step;
			System.out.println();
		}
	}
}
