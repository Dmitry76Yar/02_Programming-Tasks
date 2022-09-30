package f05_ACMP_150_199;

import java.util.*;
import java.io.*;

public class acmp_0162{
	
	public static int recurcion (int N, int result) {
		int a = 0;
		if (result > 8) return 100;
		if (N==0) {
			System.out.println("N = " + N +  "  result = " + result);
			return result;
		}
		else {
			int i_min = 1;
			if (result == 0) i_min = 2; 
			for (int i = 2; (a = i*i*i)<=N; i++) {
				System.out.print("a = " + a + " -> " );
//				System.out.println("feb" + recurcion(N-a, result+1));
				recurcion(N-a, result+1);
			}
			
			return 0;
		}
	}
	
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	N = 1000;
	recurcion(N, 0);
	
	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
//	o.print(res[h] +" ");
	o.flush();
	o.close();
}
}




