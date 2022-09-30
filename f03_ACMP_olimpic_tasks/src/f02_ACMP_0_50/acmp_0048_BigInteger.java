package f02_ACMP_0_50;

/*	Наихудший делитель 	(Время: 1 сек. Память: 16 Мб Сложность: 23%)
Будем говорить, что число a лучше числа b, если сумма цифр a больше суммы цифр числа b, а в случае равенства сумм их цифр, 
если число a меньше числа b. Например, число 124 лучше числа 123, так как у первого из них сумма цифр равна семи, а у второго 
— шести. Также, число 3 лучше числа 111, так как у них равны суммы цифр, но первое из них меньше.
	Дано число n. Найдите такой его делитель d (само число n и единица считаются делителями числа n), что любой другой 
делитель c числа n лучше, чем d.
	Входные данные
Первая строка входного файла INPUT.TXT содержит целое число n (1 ≤ n ≤ 105000).
	Выходные данные
В выходной файл OUTPUT.TXT выведите ответ на задачу.
	Примеры
№		INPUT.TXT	OUTPUT.TXT
1			10			10
2			239			1	 */

import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

public class acmp_0048_BigInteger {
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	String str = sc.nextLine();
	BigInteger n = new BigInteger(str);
	System.out.println(n);
	
	/* 	BigInteger divide(BigInteger other): возвращает частное двух чисел
		BigInteger mod(BigInteger other): возвращает остаток от целочисленного деления двух чисел  	
		int compareTo(BigInteger other): сравнивает два числа. Возвращает -1, если текущий объект меньше числа other, 
		1 - если текущий объект больше и 0 - если числа равны */
	
	BigInteger ten = new BigInteger("10");
	BigInteger zero = new BigInteger("0");
	System.out.println(n.mod(ten));
	
	int count = 0;
	while (true) {
		if (n.mod(ten).compareTo(zero) == 0) {			
			count++;
			n = n.divide(ten);
		}
		else break;
	}
	System.out.println("count = " + count);		
	
	BigInteger result = new BigInteger("1");
	if (count == 0) result = new BigInteger("1");
	else {
		for (int i = 0; i<count; i++) 
			result = result.multiply(ten);
	}
	System.out.println(result);
	
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(result);
	pw.close();
	}
}
