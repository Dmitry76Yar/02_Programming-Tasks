package f02_ACMP_0_50;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class acmp_0020_Time_err {
	
	static int check (ArrayList<Integer> arr, int i, String sign) {
		int count = 0;
			// ≈сли второе число больше первого
		while (true) {
			if (i< arr.size())  {
			if ((sign.equals(">")) & (arr.get(i) > arr.get(i-1))) {
					sign = "<";
					count++;
					System.out.println("arr.get(" + i + ")= " + arr.get(i) + " > arr.get(" + (i-1) + ") = " + arr.get(i-1) + "  count1 = " + count);
					i++;}
			else if ((sign.equals("<")) & (arr.get(i) < arr.get(i-1))) {
				sign = ">";
				count++;
				System.out.println("arr.get(" + i + ")= " + arr.get(i) + " > arr.get(" + (i-1) + ") = " + arr.get(i-1) + "  count1 = " + count);
				i++; }
			else if (arr.get(i) == arr.get(i-1) ) { i++; break; }
			else { i++; break;}
			}
		else break;	}
		return count;}
			
public static void main(String[] args) throws IOException {
	boolean correct_input = true;
	int n = 0;
	
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	n = Integer.parseInt(sc.nextLine());
	if ((n>=1) & (n<1000000)) correct_input = true;
	else correct_input = false;
//	System.out.println("correct N - " + correct_input);
	
	ArrayList<Integer> arr_l = new ArrayList<Integer>();
	while (sc.hasNext()) 
		arr_l.add(sc.nextInt());		// 1 -2 3 -4 5 5 5 5 4 5 2 3 2 3 2 3 2 3 2 3 3 3 3 3
	System.out.println(arr_l);
	System.out.println("arr_l.size() = " + arr_l.size());
		
	if (arr_l.size() == n) correct_input = true;
	else correct_input = false;
	System.out.println("correct quantaty of numbers   " + correct_input);
	
	if (correct_input == true) {
		for (int i = 0; i<n; i++) 
			if (Math.abs(arr_l.get(i)) < 32000) correct_input = true; 
			else { 
				correct_input = false; 	
				break;}}
		System.out.println("correct numbers   " + correct_input);
	
	if (correct_input == true) {	
		String sign = null;
		int count = 0;
		int result = 0;
		for (int i =1; i<n; i++) {
				if (arr_l.get(i)>arr_l.get(i-1)) {	// 2-ое число больше первого - все числа с четным индексом д.б. больше числе с нечетным индексом
					sign = ">";
					count = check(arr_l, i, sign);
					i = i + count -1;
					System.out.println(count);} 
				else if (arr_l.get(i) == arr_l.get(i-1)) i = i;
				else {
					sign = "<";
					count = check(arr_l, i, sign);
					i = i+ count - 1;
					System.out.println(count);}
				if (count > result) result = count;
		
		}
		System.out.println("result" + (result + 1));
		
		BufferedWriter br;
		br = new BufferedWriter(new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt")));
		String result2 = Integer.toString(result +1);
		br.write(result2);
//		(result+1);
		br.close();	
		}
	else System.out.println("Ќеправильный ввод");
	}
}
