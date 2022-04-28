package dist2018;

public class Alice {
	public static void main(String[] args) {
		for(int i = 1; i <= 20; i++) {
			System.out.print("          ");
			for(int j = 0; j < i; j++)
				if(j < 2 || j==i-1)
					System.out.print('&');
				else if(j < 4 || j >= i-3)
					System.out.print('-');
				else
					System.out.print('.');
			System.out.println();
		}
		
		System.out.println("           ||                   \\o/");
		System.out.println("           ||                    |");
		System.out.println(" =====================================");
		System.out.println("   =================================");
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	}
}
