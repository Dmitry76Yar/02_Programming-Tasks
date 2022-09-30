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

// Работает правильно, но долго.  Валится на 9 тесте по времени

public class acmp_0077_Just_count {
	
			// Метод перевода в двоичный код
	public static String convert (int n) {
		StringBuffer sbf = new StringBuffer();
		while (n>=1) {
			sbf.append(n%2);
			n = (int)n/2;}
		sbf.reverse();
		return sbf.toString(); 	}
	
			// Метод подсчета нулей
	public static int counts_zero (int n, int k) {
		int count = 0;
		int i = 1;
		while (n>=i) {
//			System.out.print("i = " + i + ", n = " + n + " , n&i = " + (n&i));
			if ((n&i) == 0) 	count++;
//			System.out.println(" count = " + count); 	
			i = i*2;
			if (count >k) break;
		}
		return count;}
	
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();		
	int K = sc.nextInt();	
//	N = 16384; K = 7;
	N = 97; K = 1;
	System.out.println(" N = " + N + "  в двоичной системе - " + convert(N));
	
	int count2 = 0;
	int temp = 0;
	for (int i = 1; i<=N; i++) {
		temp = counts_zero(i, K);
		if (temp == K ) count2++;
		System.out.println(" i = " + i + " ,  в двоичном коде " + convert(i) + "   содержит " + temp + "  нулей");
	}
	
	System.out.println("RESULT = " + count2);
  
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(count2);
	pw.close();
}
}