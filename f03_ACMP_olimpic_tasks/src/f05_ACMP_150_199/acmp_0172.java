	package f05_ACMP_150_199;

/* Деление с остатком		(Время: 1 сек. Память: 16 Мб Сложность: 39%)
Заданы два числа: N и K. Необходимо найти остаток от деления N на K.
	Входные данные
Входной файл INPUT.TXT содержит два целых числа: N и K (1 ≤ N ≤ 10100, 1 ≤ K ≤ 109).
	Выходные данные
В выходной файл OUTPUT.TXT выведите остаток от деления N на K.
	Примеры
№	INPUT.TXT								OUTPUT.TXT
1	239 16										15
2	4638746747645731289347483927 6784789	1001783		 */

import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class acmp_0172{
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	String [] arr = sc.nextLine().split(" ");
	BigInteger N = new BigInteger(arr[0]);
	BigInteger K = new BigInteger(arr[1]);
	
	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	o.print(N.mod(K));
	o.flush();
	o.close();
}
}