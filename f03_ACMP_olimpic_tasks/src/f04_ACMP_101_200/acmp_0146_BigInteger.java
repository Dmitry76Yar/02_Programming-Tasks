package f04_ACMP_101_200;

/* 	Длинный корень		(Время: 1 сек. Память: 16 Мб Сложность: 67%)
По заданному натуральному числу А требуется найти наибольшее число В такое, что B2 ≤ A.
	Входные данные
Во входном файле INPUT.TXT записано натуральное число A (A ≤ 103000).
	Выходные данные
В выходной файл OUTPUT.TXT выведите максимальное натуральное число B, квадрат которого не превосходит A. Число B следует выводить без лидирующих нулей.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1		17			4	*/

import java.util.*;
import java.io.*;
import java.math.*;

public class acmp_0146_BigInteger	{
public static void main(String[] args) throws IOException {
	Scanner s = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
//	BigInteger a = new BigInteger(s.nextLine());
//	BigInteger c = a.sqrt();
//	System.out.println(c);

	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	o.print(new BigInteger(s.nextLine()).sqrt());
	o.close();
}
}

