package f03_ACMP_51_100;
/*	ЗАДАЧА №77  	Нолики		(Время: 1 сек. Память: 16 Мб Сложность: 63%)
Для заданных натуральных чисел N и K требуется вычислить количество чисел от 1 до N, имеющих в двоичной записи ровно K нулей.
Например, если N=8 и K=1, то мы можем записать все числа от 1 до 8 в двоичной системе счисления:
1, 10, 11, 100, 101, 110, 111 и 1000.
Откуда видно, что только числа 10, 101 и 110 имеют ровно один ноль в записи, т.е. правильный ответ – 3.
	Входные данные
В единственной строке входного файла INPUT.TXT записано два натуральных числа через пробел N и K, не превышающих 109.
	Выходные данные
В единственную строку выходного файла OUTPUT.TXT нужно вывести одно целое число — количество чисел от 1 до N с K нулями в двоичном представлении.
Примеры
№	INPUT.TXT	OUTPUT.TXT
1		8 1			3
2		13 2		4
3		1000 5		210	 */

import java.io.*;
import java.util.Scanner;

public class acmp_0077_2_zeroes_dvoich_kod2 {
	
			// Метод перевода в двоичный код
	public static String convert (int n) {
		StringBuffer sbf = new StringBuffer();
		while (n>=1) {
			sbf.append(n%2);
			n = (int)n/2;}
		sbf.reverse();
		return sbf.toString(); 	}
	
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();		
	int K = sc.nextInt();	
	
	int res = 0;
	String a = convert(N);
	int l = a.length();
	
	if (K>l) res = 0;
	else {
			
		int r[][] = new int[l+1][l+1];
		int r2[][] = new int[l+1][l+1];
		
		int f = 0;
		int s = 0;
		for (int i = 0; i <l; i++) { 
			if ((a.charAt(i) == '0') && (f == 0)) f = i;
			if ((a.charAt(i) == '0') && (i != f)) {
				s = i;
				break;}
		}

		for (int i = 1; i <=l; i++) {
			if (i<=f) r2[0][i] = 1;
			else r[0][i] = 0;
		}
		
		if (s !=0) {
			int mb = 2;
			for (int n = s; n <l; n++) {
				if (a.charAt(n) == '0') {
					r[mb-1][n+1] = r[mb-1][n+1] -1;
					mb++;
				}
			}
		}
		for (int k = 1; k <=l; k++) {
			for (int n = 1; n <=l; n++) {
				r2[k][n] = r2[k][n-1] + r2[k-1][n-1]  + r[k][n];
			}
		}
		int r4[][] = new int[l+1][l+1];
		for (int i = 1; i <=l; i++)  r4[0][i] = 1;
		
		for (int k = 1; k <l; k++) {
			for (int n = 1; n <l; n++) {
				r4[k][n] = r4[k][n-1] + r4[k-1][n-1];
			}
		}
		for (int i = 0; i <l; i++) res = res + r4[K][i];
		res = res + r2[K][l];
	}

	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(res);
	pw.close();
}
}