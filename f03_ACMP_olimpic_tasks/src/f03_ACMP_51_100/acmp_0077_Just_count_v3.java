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
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

// Работает правильно, но долго - на 10 тесте валится по времени

public class acmp_0077_Just_count_v3 {
	
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
	
			// Метод подсчета количества разрядов (за минусом первой единицы) входного числа
		public static int count_bites (int n) {
			int count = 0;
			while (n>=1) {
				n = n/2;
				if (n>=1) count++;
				else break;	}
			return count; }
		
			// Факториал
		public static BigInteger factorial (int n) {
		BigInteger result = new BigInteger("1");
		while (n>0) {
			BigInteger N = new BigInteger(Integer.toString(n));
			result = result.multiply(N);
			n--;	}
		return result;	}
		
			// Факториал
		public static int factorial_int (int n) {
			int result = 1;
			while (n>0) {
				result = result*n;
				n--;	}
		return result;	}
		
		static ArrayList<BigInteger> arl  = new ArrayList<BigInteger>(); 
//		static TreeSet <BigInteger> arl = new TreeSet <BigInteger>(); 
		static int count_in_N_razr = 0;
		
		static BigInteger TEN = new BigInteger("10");
		
		// Метод генерации чисел
		private static void generate (BigInteger temp3, BigInteger temp4, int chislo_bites, BigInteger N_converted) {
			BigInteger temp5 = new BigInteger("1");
			for (int i = 1; i<=chislo_bites; i++) {
				if (!temp5.equals(temp4)) {
					arl.add(temp3.add(temp5));
					temp5 = temp5.multiply(TEN);
					}
				
//				if (temp5.compareTo(N_converted) <=0) {
//					if (!temp5.equals(temp4)) {
//						arl.add(temp3.add(temp5));
//						temp5 = temp5.multiply(TEN);
//						}
//				}
//				else break;
		}
		}
		
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();		
	int K = sc.nextInt();	
	N = 59; K = 1;
//	N = 20000; K = 7;
	BigInteger N_converted = new BigInteger(convert(N));
	System.out.println(" N = " + N + "  в двоичной системе - " + N_converted + " ,  число разрядов = " + count_bites(N));
	
	/* N!/ (N-K+1)!   количество перемещений r чисел из n чисел			НЕ РАБОТАЕТ ДЛЯ  11100	- при K = 2   Кол-во перемещений = 3 (11100, 11001, 10011)		4*3*2*1/4*3*2*1		= 1
	   N!/ K!(N-K)! - эта формула для сочетаний без повторений РАБОТАЕТ 
	 1110   - при K = 1   Кол-во перемещений = 3 (1110, 1101 и 1011)				3*2*1/(1*(2*1))	 = 3
	 1100	- при K = 2   Кол-во перемещений = 2 (1100, 1001)						3*2*1/((2*1)*1)	 = 3
	 11110	- при K = 1   Кол-во перемещений = 4 (11110, 11101, 11011, 10111)		4*3*2*1/(1*(3*2*1))	=	4
	 11100	- при K = 2   Кол-во перемещений = 3 (11100, 11001, 10011, 10101, 10110, 11010)		4*3*2*1/((2*1)*(2*1))	 = 6
	 11000	- при K = 3   Кол-во перемещений = 2 (11000, 10001, 10010, 10100)		4*3*2*1/((3*2*1)*1)	=	4
	 Получается формула: N!/ K!(N-K)! 
	 Алгоритм:
			1) Считаем кол-во разрядов  (N без учета первого разряда)  (например, для 8 = 1000 - будет 3) 
	 		2) Считаем для всех разрядов от N-1 до 1 кол-во вариантов с K нулями через комбинаторную формулу (кол-во размещений нулей 
	 		в количестве K в числе N)  - N!/ K!(N-K)!
	 		3) Для разряда N  сначала генерим все возможные числа, содержащие К нулей через метод по генерации размещений:
	 		на входе массив чисел длиной равным кол-ву разрядов исходног числа (1-ая единица не учитывается), 
	 		в параметрах метода int n = сколько числе переставлять (у нас все), массив и разделитель между цифрами. 
	*/
	int chislo_bites = count_bites(N);
	int result = 0;
	int count = 0;
	int count2 = 0;
		// Проверка. Если число нулей К больше числа разрядов, то сразу выводим результат ноль
	if (K>chislo_bites) result = 0;
	else {
			// Подсчитываем число всех возможных растановок с К нулями для разрядов от 0 до N-1
		for (int i = chislo_bites-1; i>=0; i--) {
			if (i<12) {
				if((i - K) >= 0) 	count = count + ((factorial_int(i)) / (factorial_int(K)*factorial_int(i-K)));
				System.out.println("i = " + i + ",  count = " + ((factorial_int(i)) / (factorial_int(K)*factorial_int(i-K)))); }
			else {
				BigInteger temp = (factorial(i)).divide((factorial(K)).multiply(factorial(i-K)));
				int temp2 = Integer.parseInt(temp.toString());
				if((i - K) >= 0) 	count = count + temp2;
				System.out.println("i = " + i + ",  count = " + temp2); }
		}
		//
		StringBuffer sbf = new StringBuffer();
		sbf.append("1");
		for (int i = 0; i<chislo_bites; i++)  sbf.append("0");
		BigInteger start_N_razryad = new BigInteger(sbf.toString());
		System.out.println("start_N_razryad = " + start_N_razryad);
		arl.add(start_N_razryad);
		
		BigInteger temp3 = new BigInteger("1");
		BigInteger temp4 = new BigInteger("1");
		for (int i = 1; i<=chislo_bites; i++) {
			temp3 = start_N_razryad.add(temp4);
			
			arl.add(temp3);
			generate(temp3, temp4, chislo_bites, N_converted);
			temp4 = temp4.multiply(TEN);
			
//			if (temp3.compareTo(N_converted) <=0) {
//				arl.add(temp3);
//				generate(temp3, temp4, chislo_bites, N_converted);
//				temp4 = temp4.multiply(TEN);}
//			else break;
		}
System.out.println(arl);		
			
		/* 000		011		110
		 * 001		101
		 * 010
		 * 100                                                 11100 
		 * 
		 *
		 *0 	00		000			0000
		 *1		01 		001			0001
		 *		10 		010			0010
		 *		11		011			0011
		 *				100			0100
		 *				101			0101
		 *				110			0110
		 *				111			0111
		 *							1000
		 *							1001
		 *							1010
		 *						
		 *						
		 *
		 *1111
		 *1110
		 *1101
		 *1100
		 *
		 *
		 * 
		 * 10000  - 10001(+1) и 	10010 (+10) и	 10100 (+100)  и	 11000 (+1000) 
		 * 							10011 (+1)		 10101 (+1)			 11001 (+1)
		 * 			10011(+10)						 10110 (+10)		 11010 (+10)
		 * 			10101(+100_	    10110 (+100)     					 11100 (+100)
		 * 			11001(1000)     11010 (1000)	 11100 (+1000)
		 * 
		 * 
		 * 100000  - 100001(+1) и 	100010 (+10) и	 100100 (+100)  и	 101000 (+1000)   и   110000 (+10000) 
		 * 							100011 (+1)		 100101 (+1)		 101001 (+1)          110001 (+1) 
		 * 			100011(+10)						 100110 (+10)		 101010 (+10) 		  110010 (+10) 
		 * 			100101(+100_	100110 (+100)     					 101100 (+100)		  110100 (+100) 
		 * 			101001(+1000)   101010 (+1000)	 101100 (+1000)					          111000 (+1000) 
		 * 			110001(+10000)  110010 ( +10000) 110100 (+10000)	 111000 (+10000)      
		   
			*/
	}
	result = count + count_in_N_razr;
	System.out.println("RESULT = " + result);
  
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("output.txt"));
	pw.print(result);
	pw.close();
}
}