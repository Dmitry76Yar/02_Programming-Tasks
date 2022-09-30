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

//N = 31;	N  = 19 - 9 + 10
	// 1 - 1 2 3 4 5 6 7   1 3 6 10 15 21 28     
	// 2 - 2 3 4 5 6 7     2 5 9 14 20 27
	// 3 - 4 5 6 7         3 7 12 18 25 
	// 5  5 6 7            5 11 18
	// 6  6 7              6 13
	
	// Решение перебором не работает, не хватает времени
	// Математическое правило - сумма чисел от 1 до N равно N*(N+1)/2
	// Например, сумма чисел от 1 до 5 равна 1+2+3+4+5 = 15   или 5*6/2 = 15
	// Сумма чисел до числа x равна sum = x*(x+1)/2 = x^2/2 + x/2 или x = sqrt(2*sum) примерно
	// Значит перебор чисел x делаем до sqrt(2*N);
	// Перебором, например, для числа = x найдем сумму для всех чисел от 1 до x
	// т.к. ответом может быть также, например, набор чисел 2,3....x или 10,11....x нужно откинуть левую часть перебором числа y
	// Например, для числа x = 5 для которого sum = 15 делаем перебор от 1 до 4, при этом отбрасывая сначала sum(1) = 2,
	// затем 1,2 (sum = 3), затем 1,2,3 (sum=6) и в конце 1,2,3,4(sum =10). 
	// Проверку делаем для разницы sum(x) - sum(y)
	
public class acmp_0170_Binar_Search{
	
	static int y_start;
	
	static int binarySearch(int left, int right, BigInteger goal, int e) {
//		if (e==10) return -1;
		if (goal.compareTo(new BigInteger("0")) == -1) return 0;
		int mid = (right + left)/2;
		System.out.print("left = " + left + "  right = " + right + "   mid = " + mid + "   goal = " + goal);
		if (left == right) return 0;
		BigInteger sum2 = new BigInteger("0");
		if (mid%2 == 0) {
			BigInteger r = new BigInteger(Integer.toString(mid/2));
			BigInteger r1 = new BigInteger(Integer.toString(mid+1));
			sum2 = r.multiply(r1);
		}
		else {
			BigInteger r = new BigInteger(Integer.toString((mid+1)/2));
			BigInteger r1 = new BigInteger(Integer.toString(mid));
			sum2 = r.multiply(r1);
		}
		System.out.println("    sum2 = " + sum2);
		if (sum2.compareTo(goal) == 0) return mid;
		else if (sum2.compareTo(goal) == -1) {
			y_start = mid;
			return binarySearch(mid+1, right, goal, ++e);
		}
		else return binarySearch(left, mid, goal, ++e);
	}
	
	
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();

	N = 31;		// 28
	
//	System.out.println(binarySearch(1, 9, new BigInteger("29"), 0));
	
	int res = 0;
	BigInteger sum1 = new BigInteger("0");
	int a = 0;
	int b = 0;
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
		if ((sum1.compareTo(new BigInteger(Integer.toString(N))) == 0) && (x>res)) {
			res = x;
			a = x;
			b = 0;
			break;
		}
		BigInteger goal = sum1.subtract(new BigInteger(Integer.toString(N)));
//		System.out.println("goal = " + goal);
		int found = binarySearch(y_start, x, goal,0);
		System.out.println("x= " + x+ "   found = " + found);
		if (found !=0) {
			res = (x-found);
			a = x;
			b = found;
			break;
		}
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




