package f02_ACMP_0_50;

/*	Наилучший делитель		(Время: 1 сек. Память: 16 Мб Сложность: 26%)
Будем говорить, что число a лучше числа b, если сумма цифр a больше суммы цифр числа b, а в случае равенства сумм их цифр,
если число a меньше числа b. Например, число 124 лучше числа 123, так как у первого из них сумма цифр равна семи, а у второго
 – шести. Также, число 3 лучше числа 111, так как у них равны суммы цифр, но первое из них меньше.
	Дано число n. Найдите такой его делитель (само число n и единица считаются делителями числа n), который лучше любого
другого делителя числа n.
	Входные данные
Первая строка входного файла содержит целое число n (1 ≤ n ≤ 105).
	Выходные данные
В выходной файл выведите ответ на задачу.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1		10			5
2		239			239	 */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class acmp_0047 {
	
	static int sum (int n) {
		int sum = 0;
		while (n>=1) {
			sum = sum + n%10;
			n = n/10;
		}
		return sum;
	}
	
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int n = sc.nextInt();
	System.out.println("n = " + n);		
//	n = 13;
	ArrayList<Integer> arl = new ArrayList<Integer>();
	for (int i = 1; i<=n; i++) {
		if (n%i == 0) arl.add(i);
	}
	
	System.out.println(arl);
	int sum_best = 0;
	int k = 0;
	for (int i = 0; i<arl.size(); i++) {
//		System.out.print(arl.get(i) + ", ");
//		System.out.println(sum (arl.get(i)) + ", ");
		if ((k =sum (arl.get(i))) > sum_best) {
//			System.out.println(" i = " + i);
			sum_best = k;
		}
	}
	
	ArrayList<Integer> arl_in = new ArrayList<Integer>();
	for (int i = 0; i<arl.size(); i++) {
		if (sum (arl.get(i)) == sum_best) arl_in.add(arl.get(i));
		}
//	System.out.println(arl_in);
	Collections.sort(arl_in);
	System.out.println(arl_in.get(0));
	
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(arl_in.get(0));
	pw.close();
	}
}
