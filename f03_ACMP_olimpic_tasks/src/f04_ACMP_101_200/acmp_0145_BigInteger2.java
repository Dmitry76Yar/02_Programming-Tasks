package f04_ACMP_101_200;

/* 	A div B		(Время: 1 сек. Память: 16 Мб Сложность: 40%)
Даны два целых числа A и B. Требуется найти их целую часть от их частного.
	Входные данные
Во входном файле INPUT.TXT записаны целые числа A и B по одному в строке (0 ≤ A ≤ 10100, 0 < B ≤ 10000).
	Выходные данные
В выходной файл OUTPUT.TXT выведите единственное число без лидирующих нулей: A div B.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1		7
		3			2	*/

import java.util.*;
import java.io.*;
import java.math.*;

public class acmp_0145_BigInteger2	{
public static void main(String[] args) throws IOException {
	Scanner s = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));

	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	o.print(new BigInteger(s.nextLine()).divide(new BigInteger(s.nextLine())));
	o.close();
}
}

