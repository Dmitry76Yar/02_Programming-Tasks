package f02_ACMP_0_50;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// Проходит на сайте

public class acmp_0029_short3 {
	
	static int minim_step (int n, int City[]) {				
		ArrayList<Integer> prev_arr = new ArrayList<Integer>();				
		ArrayList<Integer> pred_prev_arr = new ArrayList<Integer>();	
		ArrayList<Integer> Temp = new ArrayList<Integer>();
		
		pred_prev_arr.add(0);			
		prev_arr.add(Math.abs(City[1] - City[0]));
		int ordin_step;						
		int super_step;						
		
		for (int i = 2; i< n; i++) {		
			ordin_step = Math.abs(City[i] - City[i-1]); 		
			super_step = Math.abs(3*(City[i] - City[i-2]));	
			
			for (int j = 0; j<pred_prev_arr.size(); j++) Temp.add(pred_prev_arr.get(j) + super_step);
			for (int j = 0; j<prev_arr.size(); j++) Temp.add(prev_arr.get(j) + ordin_step);
			
			pred_prev_arr.clear(); 	
			pred_prev_arr.addAll(prev_arr);
			int min_pred_pred = Integer.MAX_VALUE;
			for (int j = 0; j<pred_prev_arr.size(); j++) 
				 if (min_pred_pred > pred_prev_arr.get(j)) min_pred_pred = pred_prev_arr.get(j);
			pred_prev_arr.clear();
			pred_prev_arr.add(min_pred_pred);
			
					
			prev_arr.clear();		
			prev_arr.addAll(Temp);
			int min_pred = Integer.MAX_VALUE;
			for (int j = 0; j<prev_arr.size(); j++) 
				 if (min_pred > prev_arr.get(j)) min_pred = prev_arr.get(j);
			prev_arr.clear();
			prev_arr.add(min_pred);
			
			System.out.println(Temp);	
			Temp.clear();
			
		}
		Collections.sort(prev_arr);
		return prev_arr.get(0);
	}
			
public static void main(String[] args) throws IOException {
	int n;
	int result;
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	n = sc.nextInt();
	
	if (n==1) result = 0; 
	else {
		int Array[] = new int[n];
		int i =0;
		while (sc.hasNextInt()) {
			Array[i] = sc.nextInt();
			i++;}
		result = minim_step(n, Array);
	}
		System.out.println(result);
		PrintWriter pw;
		pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
		pw.print(result);
		pw.close();
}
}
