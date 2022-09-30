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
import java.math.BigInteger;

public class acmp_0170_Perebor_11test{
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	//N = 31;	N  = 19 - 9 + 10
	// 1 - 1 2 3 4 5 6 7   1 3 6 10 15 21 28     
	// 2 - 2 3 4 5 6 7     2 5 9 14 20 27
	// 3 - 4 5 6 7         3 7 12 18 25 
	// 5  5 6 7            5 11 18
	// 6  6 7              6 13
	
	// Математическое правило - сумма чисел от 1 до N равно N*(N+1)/2
	// Например, сумма чисел от 1 до 5 равна 1+2+3+4+5 = 15   или 5*6/2 = 15
	
	// Сумма чисел до числа x равна sum = x*(x+1)/2 = x^2/2 + x/2 или примерно x = sqrt(2*sum) 
	// Значит перебор чисел x начинаем с sqrt(2*N), и заканчиваем (N/2+1), т.к., например, для числа 31 решение 15+16 и
	// перебор нужно делать до 16, т.е. до половины N
	// Перебором, для x найдем сумму для всех чисел от 1 до x
	// т.к. ответом может быть также, например, набор чисел 2,3....x или 10,11....x нужно откинуть левую часть перебором числа y
	
	// На примере числа 31, для которого решение 15+16 :
	// Основной перебор от sqrt(2*N) = 3 до (N/2+1) = 16	  Дополнительный перебор по y от y_start до (x-1) = 15
	// В итоге перебираем х вплоть до 16, для которого sum = 136 (1,2,3...15,16)
	// и далее перебором y откидываем часть чисел в ряду (1,2,3...15,16)
	// Сначала при y=1 оставляем (2,3...15,16) и получаем sum(x) = 136, sum(y) = 1, (sum(x)-sum(y)) = 135
	// Затем при y=2 оставляем (3...15,16) и получаем sum(x) = 136, sum(y) = 3, (sum(x)-sum(y)) = 133
	// Дохододим до y=14 при котором оставляем только (15,16) и получаем sum(x) = 136, sum(y) = 105, (sum(x)-sum(y)) = 31
	// Это и есть решение - 15,16
	
	// Решение перебором не работает, не хватает времени

	N = 19;		
	int res = 0;
	BigInteger sum1 = new BigInteger("0");
	BigInteger sum2 = new BigInteger("0");
	int a = 0;
	int b = 0;
	int y_start = 1;
	for (int x = (int)Math.sqrt(2*N); x<=(N/2+1); x++) {	
		if (x%2 == 0) {
			BigInteger r = new BigInteger(Integer.toString(x/2));
			BigInteger r1 = new BigInteger(Integer.toString(x+1));
			sum1 = r.multiply(r1);
		}
		else {
			BigInteger r = new BigInteger(Integer.toString((x+1)/2));
			BigInteger r1 = new BigInteger(Integer.toString(x));
			sum1 = r.multiply(r1);
		}
		System.out.println("x = " + x + " sum1 = " + sum1);
		if ((sum1.compareTo(new BigInteger(Integer.toString(N))) == 0) && (x>res)) {
			res = x;
			a = x;
			b = 0;
			break;
		}
		for (int y= y_start; y<=(x-1); y++) {
			if (y%2 == 0) {
				BigInteger r = new BigInteger(Integer.toString(y/2));
				BigInteger r1 = new BigInteger(Integer.toString(y+1));
				sum2 = r.multiply(r1);
			}
			else {
				BigInteger r = new BigInteger(Integer.toString((y+1)/2));
				BigInteger r1 = new BigInteger(Integer.toString(y));
				sum2 = r.multiply(r1);
			}
			if (sum1.subtract(sum2).compareTo(new BigInteger(Integer.toString(N))) == -1) {
				y_start = y-1;
				break;
			}
			System.out.println("y = " + y + "  sum1 - sum2 =  " + (sum1.subtract(sum2)));
			if ((sum1.subtract(sum2).compareTo(new BigInteger(Integer.toString(N))) == 0) && ((x-y) >res)) {
				res = (x-y);
				a = x;
				b = y;
			}
			if (res!=0) break;
		}		
		if (res!=0) break;
	}
	
	for (int i=b+1; i<=a; i++) System.out.print(i + " ->");
	if (res == 0) res = 1;
	System.out.println("result = " + res);
	
	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	o.print(res);
	o.flush();
	o.close();
}
}




