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

public class acmp_0077_2_zeroes_dvoich_kod {
	
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
//	N = 500000000    ; K = 10;
	
	int res = 0;
	String N_dvoichn = convert(N);
	int leng = N_dvoichn.length();
	
//	System.out.println("N_dvoichn = " + N_dvoichn + " ,  leng = " + leng);
	if (K>leng) res = 0;
	else {
			
			// Массив результатов     К - строка, N - столбец
		int results[][] = new int[leng+1][leng+1];
		int results2[][] = new int[leng+1][leng+1];
		
			// Находим позицию первого и второго нуля в числе двоичном 
		int firstNull = 0;
		int secondNull = 0;
		for (int i = 0; i <leng; i++) { 
			if ((N_dvoichn.charAt(i) == '0') && (firstNull == 0)) firstNull = i;
			if ((N_dvoichn.charAt(i) == '0') && (i != firstNull)) {
				secondNull = i;
				break;}
		}
//		System.out.println("firstNull = " + firstNull + "   secondNull = " + secondNull);
		
			// Заполняем для K = 0 для всех N до firstNull единицами и дальше нулями
		for (int i = 1; i <=leng; i++) {
			if (i<=firstNull) results2[0][i] = 1;
			else results[0][i] = 0;
		}
		
		/* Итоговая формула
		 * R(K, N) = R (K, N-1) + R(K-1, N-1)
		 * Также важно, что если число в разряде N заканчивается  на ноль, то необходимо уменьшить на единицу 
		 * в К = числу нулей в K-1
		   Например, для N=4  - 1100 последняя цифра равна нулю, поэтому в ячейке [K=1, N=4] нужно вычесть единицу. 
		   К=1, т.к. в предыдущем числе был 1 нуль  */
		
			// Пробегаем от N в котором в числе появляется второй нуль и до N = кол-во разрядов (leng)
			// Если в этом разряде Ni число заканчивается на нуль, то уменьшаем на единицу [K][Ni],
			// где К = число нулей в данном разряде
		if (secondNull !=0) {
			int numbersOfZero = 2;
			for (int n = secondNull; n <leng; n++) {
				if (N_dvoichn.charAt(n) == '0') {
					results[numbersOfZero-1][n+1] = results[numbersOfZero-1][n+1] -1;
					numbersOfZero++;
				}
			}
		}
//		for (int i = 0; i <leng; i++) System.out.println(Arrays.toString(results[i])); System.out.println();
		
			// Заполняем таблицу через  R(K, N) = R (K, N-1) + R(K-1, N-1)
			// без учета верхнего ограничения
		for (int k = 1; k <=leng; k++) {
			for (int n = 1; n <=leng; n++) {
				results2[k][n] = results2[k][n-1] + results2[k-1][n-1]  + results[k][n];
			}
		}
//		System.out.println("Результаты для последнего разряда");
//		for (int i = 0; i <=leng; i++) System.out.println(Arrays.toString(results2[i])); System.out.println();
		
		int results4[][] = new int[leng+1][leng+1];
		for (int i = 1; i <=leng; i++)  results4[0][i] = 1;
		
		for (int k = 1; k <leng; k++) {
			for (int n = 1; n <leng; n++) {
				results4[k][n] = results4[k][n-1] + results4[k-1][n-1];
			}
		}
//		System.out.println("Результаты для всех предыдущих разрядов");
//		for (int i = 0; i <=leng; i++) System.out.println(Arrays.toString(results4[i])); System.out.println();
		
		
		for (int i = 0; i <leng; i++) res = res + results4[K][i];
		res = res + results2[K][leng];
	}
	
	System.out.println("RESULT = " + res);
//	
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(res);
	pw.close();
}
}