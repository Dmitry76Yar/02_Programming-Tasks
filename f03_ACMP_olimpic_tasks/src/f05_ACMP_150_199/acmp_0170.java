	package f05_ACMP_150_199;

/*  Разложение числа	(Время: 1 сек. Память: 16 Мб Сложность: 35%)
Любое натуральное число можно представить в виде суммы нескольких последовательных натуральных чисел. Например, число 25 можно
представить в виде суммы из одного (25), двух (12+13) или пяти (3+4+5+6+7) чисел.
	Требуется написать программу, которая определит максимальное количество чисел в таком разложении.
	Входные данные
Входной файл INPUT.TXT содержит одно натуральное число N (1 ≤ N ≤ 109).
	Выходные данные
Выходной файл OUTPUT.TXT должен содержать одно натуральное число – максимальное количество чисел в разложении числа N на сумму последовательных натуральных чисел.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	2			1
2	5			2
3	25			5		 */

import java.util.*;
import java.io.*;

public class acmp_0170{
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
//	N = 1000000000;
	N = 31;	
//	N  = 19;
	
	int store_sum[] = new int [N/2 +2];			// Хранилище для сумм
	for (int i=1; i<=(N/2+1); i++) {
		store_sum[i] = store_sum[i-1] + i;
	}
//	System.out.println(Arrays.toString(store_sum));
	
	int result = store_sum[store_sum.length-1] + 1;
	int a = 0;
	int b = 0;
	for (int i=1; i<=(N/2+1); i++) {
		if ((store_sum[i] == N) && (i<result)) {
			a= 1; b = i;
			result = i; 
		}
		else if (store_sum[i] > N) {
			for (int j=i-1; j>=1; j--) {
				if ((store_sum[i] - store_sum[j]) > N) break; 
				if (((store_sum[i] - store_sum[j]) == N) && (i<result)) {
					a = j; b = i;
					result = i-j; 
				}
			}
		}
	}
	for (int i=a+1; i<=b; i++) System.out.print(i + " ->");
	System.out.println("result = " + result);
	
	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
//	o.print(array[K-1][N-1]);
	o.flush();
	o.close();
}
}




