package f02_ACMP_0_50;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0012_NO {
	
	boolean check (int Array[]) {
		
		
		
		if ( (Array[0] >	
	}
	
	
public static void main(String[] args) throws IOException {
	Scanner sc;
	String str = null;
	int n = 0;

	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	if (sc.hasNextLine() == true) str = sc.nextLine();
	n = Integer.parseInt(str);
	System.out.println("n= " + n);
	
	boolean correct_coord  = true;
	int k = 0;
	if ( (n>=1) & (n<=1000)) {
		while (sc.hasNextLine() == true) {
			str = sc.nextLine();
			String Array[] =  str.split(" ");
			int Array_int[] = new int[Array.length];
			for (int i = 0; i<Array.length; i++) {
				Array_int[i] = Integer.parseInt(Array[i]);
				if ( (Array_int[i] < -5000) & (Array_int[i] > 5000) ) correct_coord = false; 
				if (correct_coord == true) {
					
					k++;
				}
			}
			System.out.println(Arrays.toString(Array));
			}
					
			
			
		}
	}
	else System.out.println("Неправильный ввод N");
		
		
		
			
	
	}

}
