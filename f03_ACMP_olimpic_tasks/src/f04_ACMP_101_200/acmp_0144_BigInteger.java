package f04_ACMP_101_200;

/* 	A*B	(Время: 1 сек. Память: 16 Мб Сложность: 37%)
Даны два целых неотрицательных числа A и B. Требуется найти их произведение.
	Входные данные
Во входном файле INPUT.TXT записаны целые неотрицательные числа A и B по одному в строке (A < 10100, B ≤ 10000).
	Выходные данные
В выходной файл OUTPUT.TXT выведите единственное число без лидирующих нулей: A*B.
Пример
№	INPUT.TXT	OUTPUT.TXT
1		5
		7		35			*/

import java.util.*;
import java.io.*;
import java.math.*;

public class acmp_0144_BigInteger	{
public static void main(String[] args) throws IOException {
	Scanner s = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));

	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	o.print(new BigInteger(s.nextLine()).multiply(new BigInteger(s.nextLine())));
	o.close();
}
}

