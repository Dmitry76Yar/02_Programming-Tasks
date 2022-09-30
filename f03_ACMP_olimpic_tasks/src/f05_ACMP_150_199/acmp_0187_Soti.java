	package f05_ACMP_150_199;

import java.util.*;
import java.io.*;

//  СПИСАЛ РЕШЕНИЕ С ИНТЕРНЕТА
public class acmp_0187_Soti{
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	long array[][] = new long[2*N-1][2*N-1];
	array[0][0] = 1;
	
//	for (int i = 0; i<2*N-1; i++) System.out.println(Arrays.toString(array[i]));
//	System.out.println();
	
	for (int x=0; x<(2*N-1); x++ ) {
		for (int y=0; y<(2*N-1); y++ ) {
			if (((y-x+N)>0) && ((y-x+N)<=(2*N-1))) {
				if (x>0) array[y][x] = array[y][x] + array[y][x-1];
				if (y>0) array[y][x] = array[y][x] + array[y-1][x];
				if ((x>0)&&(y>0)) array[y][x] = array[y][x] + array[y-1][x-1];
			}
		}
//		for (int i = 0; i<2*N-1; i++) System.out.println(Arrays.toString(array[i]));
//		System.out.println();
	}
	
	System.out.println(array[2*N-2][2*N-2]);
	
	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
    o.print(array[2*N-2][2*N-2]);
    o.flush();
    o.close();
    }
}