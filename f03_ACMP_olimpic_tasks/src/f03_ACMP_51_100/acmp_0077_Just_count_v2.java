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
import java.util.Scanner;

// Работает правильно, но долго - на 10 тесте валится по времени

public class acmp_0077_Just_count_v2 {
	
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
		
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();		
	int K = sc.nextInt();	
//	N = 42; K = 1;
	N = 20000; K = 7;
	System.out.println(" N = " + N + "  в двоичной системе - " + convert(N) + " ,  число разрядов = " + count_bites(N));
	
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
			// Обычным перебором подсчитываем число чисел с К нулями для разряд = N
		int temp = 0;
		int stepen_dvoiki = 1;
		for (int i = 1; i<=chislo_bites; i++) stepen_dvoiki = stepen_dvoiki*2;
		for (int i = stepen_dvoiki; i<=N; i++) {
			temp = counts_zero(i, K);
			if (temp == K ) count2++;
//			System.out.println(" i = " + i + " ,  в двоичном коде " + convert(i) + "   содержит " + temp + "  нулей");
		}
	}
	result = count + count2;
	System.out.println("RESULT = " + result);
  
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("output.txt"));
	pw.print(result);
	pw.close();
}
}