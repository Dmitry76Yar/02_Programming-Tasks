package f04_ACMP_101_200;

/* 	Числа Фибоначчи		(Время: 1 сек. Память: 16 Мб Сложность: 16%)
Последовательностью Фибоначчи называется последовательность чисел a0, a1, ..., an, ..., где
a0 = 0, a1 = 1, ak = ak-1 + ak-2 (k > 1).
	Требуется найти N-е число Фибоначчи.
	Входные данные
Во входном файле INPUT.TXT записано целое число N (0 ≤ N ≤ 30).
	Выходные данные
В выходной файл OUTPUT.TXT выведите N-е число Фибоначчи.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1		7			13	*/

import java.util.*;
import java.io.*;

public class acmp_0147	{
public static void main(String[] args) throws IOException {
	Scanner s = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int n = s.nextInt();
	int A[] = new int[n+1];
	A[0] = 0;
	if (n>0) {
		A[1] = 1;
		for (int i=2; i<=n; i++) A[i] = A[i-2] + A[i-1];}
//		System.out.println("A[" + i + "] " + A[i]);}
	
	System.out.println("result = " + A[n]);
	
	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	o.print(A[n]);
	o.close();
}
}

