package f04_ACMP_101_200;

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0107  {
	
	public static int calc (String string) {
		int total = 0;
		String part_arr[] = string.split("-");
		for (int i =0; i<part_arr.length; i++) {
			String part = part_arr[i];
			int result = 0;
			if (part.length() == 2) {
				if (part.charAt(0) == part.charAt(1)) result = 2;	}
			if (part.length() == 3) {
				if (part.charAt(0) == part.charAt(2)) result = 2;
				if (part.charAt(0) == part.charAt(1)) result = 2;
				if (part.charAt(1) == part.charAt(2)) result = 2;
				if ((part.charAt(1) == part.charAt(2)) && (part.charAt(0) == part.charAt(1))) result = 3;}
			if (part.length() == 4) {
				if (part.charAt(0) == part.charAt(2)) result = 2;
				if (part.charAt(1) == part.charAt(3)) result = 2;
				if ((part.charAt(0) == part.charAt(2)) && ((part.charAt(1) == part.charAt(3)))) result = 3;
				if ((part.charAt(0) == part.charAt(1)) && ((part.charAt(2) == part.charAt(3)))) result = 3;
				if ((part.charAt(0) == part.charAt(3)) && ((part.charAt(1) == part.charAt(2)))) result = 4;
				if ((part.charAt(1) == part.charAt(2)) && ((part.charAt(2) == part.charAt(3)))) result = 3;
				if ((part.charAt(0) == part.charAt(2)) && ((part.charAt(2) == part.charAt(3)))) result = 3;
				if ((part.charAt(0) == part.charAt(1)) && ((part.charAt(1) == part.charAt(3)))) result = 3;
				if ((part.charAt(0) == part.charAt(1)) && ((part.charAt(1) == part.charAt(2)))) result = 3;
				if ((part.charAt(0) == part.charAt(1)) && ((part.charAt(1) == part.charAt(2))) && ((part.charAt(2) == part.charAt(3)))) result = 5;
			}
			total = total + result;
		}
		return total;
	}
	
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	String a = sc.nextLine();
	String arr[][] = new String[5][2];
	
	String a1 = a.substring(0, 2) + "-" + a.substring(2, 4) + "-" + a.substring(4, 7);
	System.out.println(a1);
	arr[0][0] = a1;		
	arr[0][1] = Integer.toString(calc(a1));
	
	String a2 = a.substring(0, 2) + "-" + a.substring(2, 5) + "-" + a.substring(5, 7);
	System.out.println(a2);
	arr[1][0] = a2;		
	arr[1][1] = Integer.toString(calc(a2));
	
	
	String a3 = a.substring(0, 3) + "-" + a.substring(3, 5) + "-" + a.substring(5, 7);
	System.out.println(a3);
	arr[2][0] = a3;		
	arr[2][1] = Integer.toString(calc(a3));
	
	String a4 = a.substring(0, 4) + "-" + a.substring(4, 7);
	System.out.println(a4);
	arr[3][0] = a4;		
	arr[3][1] = Integer.toString(calc(a4));
	
	String a5 = a.substring(0, 3) + "-" + a.substring(3, 7);
	System.out.println(a5);
	arr[4][0] = a5;		
	arr[4][1] = Integer.toString(calc(a5));
	
	for (int i=0; i <5; i++) System.out.println(Arrays.toString(arr[i]));
	
	int max = 0;
	int index = 0;
	for (int i =0 ; i<5; i++) {
		int chislo = Integer.parseInt(arr[i][1]);
		if (chislo >=max) {
			max = chislo;
			index = i;
		}
	}
			
	System.out.println(arr[index][1]);
	System.out.println(arr[index][0]);
	
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	out.println(arr[index][0]);
	out.println(arr[index][1]);
    out.flush();
    out.close();
}
}