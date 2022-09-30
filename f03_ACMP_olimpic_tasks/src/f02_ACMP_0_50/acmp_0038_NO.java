package f02_ACMP_0_50;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0038_NO {
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int n = sc.nextInt();
	sc.nextLine();
	String str = sc.nextLine();
	String Arr_str[] = str.split(" ");
	int Arr_fig[] = new int[Arr_str.length];
	for (int i = 0; i<Arr_str.length; i++) {
		Arr_fig[i] = Integer.parseInt(Arr_str[i]);
	}
	
	System.out.println("n = " + n);
	System.out.println(Arrays.toString(Arr_fig));
	
	ArrayList<Integer> arl = new ArrayList<Integer>();
	for (int i = 0; i<Arr_fig.length; i++) 
		arl.add(Arr_fig[i]);
	System.out.println(arl);
	
	int end = 0; 
	int finish = 0;
		

}
}
