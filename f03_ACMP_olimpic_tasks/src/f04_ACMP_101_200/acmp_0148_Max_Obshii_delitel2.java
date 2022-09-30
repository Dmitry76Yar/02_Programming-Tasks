package f04_ACMP_101_200;

/* 	НОД	(Время: 1 сек. Память: 16 Мб Сложность: 15%)
Даны два натуральных числа A и B. Требуется найти их наибольший общий делитель (НОД).
	Входные данные
Во входном файле INPUT.TXT в единственной строке записаны натуральные числа A и B через пробел (A, B ≤ 109).
	Выходные данные
В выходной файл OUTPUT.TXT выведите НОД чисел А и В.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1		12 42		6	*/

import java.util.*;
import java.io.*;

// https://ru.wikipedia.org/wiki/%D0%90%D0%BB%D0%B3%D0%BE%D1%80%D0%B8%D1%82%D0%BC_%D0%95%D0%B2%D0%BA%D0%BB%D0%B8%D0%B4%D0%B0
// АЛГОРИТМ ЭВКЛИДА
public class acmp_0148_Max_Obshii_delitel2	{
public static void main(String[] args) throws IOException {
	Scanner s = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int a = s.nextInt();
	int b = s.nextInt();
	int c;
	if (a<b) {
		c = a;
		a = b;
		b = c;
	}
	while (b!=0) {
		c = (a%b);
		a = b;
		b = c;
		System.out.println("a = " + a + "  b = " + b);
	}
	
	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	o.print(a);
	o.close();
}
}

