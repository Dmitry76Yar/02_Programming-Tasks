package f05_ACMP_150_199;

/*  Счастливый билет - 2	(Время: 1 сек. Память: 16 Мб Сложность: 26%)
Билет называется счастливым, если его можно разрезать прямой линией между цифр на две части таким образом, что оказавшиеся на них
числа имеют одинаковые цифровые корни. Чтобы вычислить цифровой корень числа, его цифры складывают, если в результате получится
число большее или равное 10, то цифры складывают снова и так далее, пока не получится число от 0 до 9 – это и есть цифровой корень.
Например, билет с номером 0015420 является счастливым, так как разрезав его на части с числами 0015 и 420 имеем у этих чисел
одинаковые цифровые корни.
	Требуется написать программу, которая определит, является ли счастливым билет с заданным номером.
	Входные данные
Входной файл INPUT.TXT содержит номер счастливого билета. Номер может начитаться с нулей и содержит от 1 до 100 цифр.
	Выходные данные
В выходной текстовый файл OUTPUT.TXT выведите «YES», если билет счастливый и «NO» иначе.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	0015420			YES
2	00100			NO	 */

import java.util.*;
import java.io.*;

public class acmp_0164{
	
	static int calc (String str) {
		int sum = 0;
		for (int i = 0; i<str.length(); i++) sum = sum + Integer.parseInt(str.substring(i, i+1));
		return sum;
	}
	
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	String str = sc.nextLine();
	String result = "NO";
	
	for (int i=0; i<str.length()-1;i++) {
		String str1 = str.substring(0,i+1);
		String str2 = str.substring(i+1, str.length());
//		System.out.print("str1 = " + str1 + "   str2 = " + str2);
		int a = calc(str1);
		int b = calc(str2);
		
		while (a>9)  a = calc(Integer.toString(a));
//		System.out.print("   sum1  = " + a);
		
		while (b>9) b = calc(Integer.toString(b));
//		System.out.print("   sum2  = " + b);
		
		if (a == b) result = "YES";
//		System.out.println();
	}
	
	System.out.println("result = " + result);
	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	o.print(result);
	o.flush();
	o.close();
}
}




