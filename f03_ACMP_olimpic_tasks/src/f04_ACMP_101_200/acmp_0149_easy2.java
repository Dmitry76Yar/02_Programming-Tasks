package f04_ACMP_101_200;

/* 	Разворот	(Время: 1 сек. Память: 16 Мб Сложность: 9%)
Дано натуральное число N и последовательность из N элементов. Требуется вывести эту последовательность в обратном порядке.
	Входные данные
В первой строке входного файла INPUT.TXT записано натуральное число N (N ≤ 103). Во второй строке через пробел идут N целых чисел, по модулю не превосходящих 103 - элементы последовательности.
	Выходные данные
В выходной файл OUTPUT.TXT выведите заданную последовательность в обратном порядке.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1	3
	1 2 3		3 2 1	*/

import java.util.*;
import java.io.*;

public class acmp_0149_easy2	{
public static void main(String[] args) throws IOException {
	Scanner s = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int n = s.nextInt();
	int a[] = new int[n];
	for (int i=0; i<n; i++) a[i] = s.nextInt();
	
	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	for (int i=n-1; i>=0; i--) o.print(a[i] + " ");
	o.close();
	}
}

