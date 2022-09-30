package f04_ACMP_101_200;
/*	Максимальная подпоследовательность		(Время: 1 сек. Память: 16 Мб Сложность: 38%)
Дана числовая последовательность, требуется найти длину наибольшей возрастающей подпоследовательности.
	Входные данные
В первой строке входного файла INPUT.TXT записано число N - длина последовательности (1 ≤ N ≤ 1000). Во второй строке записана сама
последовательность (через пробел). Числа последовательности - целые числа, не превосходящие 10000 по модулю.
	Выходные данные
В выходной файл OUTPUT.TXT требуется вывести наибольшую длину возрастающей подпоследовательности.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1	6
3 29 5 5 28 6	3		

 Можете пожалуйста объяснить, что такое подпоследовательность? И почему у последовательности на входе 4 8 2 6 2 10 6 29 58 9 ответ 5 ?
Подпоследовательность - это то, что получается, если некоторые числа исходной последовательности исключить. Например из данной
последовательности можно получить возрастающую подпоследовательность 4 8 10 29 58 длины 5 (это не единственная такая последовательность
и ее длина максимальна), поэтому ответ 5. Не нужно путать ее с непрерывной подпоследовательностью.*/

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0122_Dynamic_Prog2 {
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	System.out.println(" N = " + N);
	int inputArray[] = new int[N];
	
	for (int i = 0; i<N; i++) inputArray[i] = sc.nextInt();
	
	int result[] = new int[N];
	
		/* 3 29 5 28 6 
		 * Для каждого числа в массиве inputArray находим число, предшествующее ему и меньшее его.
		 * Для каждого найденного такого числа в массиве result[] уже записано сколько чисел до него составляют растущую последова
		 * Число = 3  -> result[0] = 1, т.к. одно число - последовательность из одного возрастающего элемента
		 * Число = 29  -> result[1] = 1 + result[0] = 1+ 1 = 2, т.к. число 29 > числа 3
		 * Число = 5  -> число 29 > 5, проходим его
		 * 			  -> число 3 < 5, значит result[2] = result[0] +1 = 1 + 1 = 2
		 * Число = 28  -> число 5 < 28, значит временная переменная сount  = result[2] + 1 = 2 + 1 = 3  и max = count, т.к. max был равен 0
		 * 			   -> число 29 > 28, проходим его
		 *             -> число 3 < 28, значит временная переменная сount  = result[0] + 1 = 2  и max так и остается = 2
		 */
	
	result[0] = 1;
	for (int i = 1; i<N; i++) {
		int max_i = 1;
		int count = 0;
		for (int j = i-1; j>=0; j--) {
			if (inputArray[j] < inputArray[i]) count = result[j] + 1;
			if (count > max_i) max_i = count;
			System.out.println(" i = " + i + "   j = " + j +   " count  " + count +  "   max = " + max_i);
		}
		result[i] = max_i;
	}
	System.out.println(Arrays.toString(result));
	
	int outcome = 0;
	for (int i = 0; i<N; i++) {
		if (result[i] > outcome) outcome = result[i];
	}
	System.out.println("RESULT = " + outcome);

	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	out.print(outcome);
    out.flush();
    out.close();
	}
}
