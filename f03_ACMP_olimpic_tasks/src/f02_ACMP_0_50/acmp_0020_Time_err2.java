package f02_ACMP_0_50;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0020_Time_err2 {
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int n = sc.nextInt();
	sc.nextLine();
	String str = sc.nextLine();
	sc.close();
	String str_ar[] = str.split(" ");
	int fig_ar[] = new int [str_ar.length];
	for (int i = 0; i<str_ar.length;i ++) 
		fig_ar[i] = Integer.parseInt(str_ar[i]);
	System.out.println(Arrays.toString(fig_ar));
	
	int Signs[] = new int[fig_ar.length - 1];
	int a = 0;
	for (int i = 0; i<fig_ar.length - 1; i++) {
		a = fig_ar[i];
//		System.out.println(" a = " + a + ",  fig_ar[i+1] " + fig_ar[i+1]);
		if ((a - fig_ar[i+1]) >0) Signs[i] = 1;
		else if ((a == fig_ar[i+1])) Signs[i] = 0;
		else Signs[i] = -1;	
	}
	System.out.println(Arrays.toString(Signs));
	
	int temp = 0;
	int count = 0;
	int result = 0;
	temp = Signs[0];
	for (int i = 0; i<Signs.length-1; i++) {
//		System.out.print(temp + ",  ");
		if (temp != 0) {
			count++;
			if ((temp == Signs[i+1]) || (Signs[i+1] == 0)) {
				temp = Signs[i+1];
//				System.out.println(" temp = "   +  temp + ",  Signs[i+1]" + Signs[i+1] );
				count = 0;
			}
			else {
				count ++;
				System.out.println(" temp = "   +  temp + ",  Signs[i+1] = " + Signs[i+1] + ",   count = " + count );
				temp = temp*(-1);
				
			}
		if (result < count ) result = count;
		}
		else {
			temp = Signs[i+1];
			count = 0;
		}
	}
	int result_finish = 0;
	if (result == 0) result_finish = 0;		
	else result_finish = result +1;
	
	System.out.println(result_finish);
	
//	 5 < 7 > 6 > 3 < 4 > 2 < 7 > 1 < 8 < 9 > 4 < 5
//             1   2   3   4   5   6   
	
	}
}
