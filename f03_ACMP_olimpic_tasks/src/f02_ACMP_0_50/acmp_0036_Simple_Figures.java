package f02_ACMP_0_50;

/* Постулат Бертрана		(Время: 1 сек. Память: 16 Мб Сложность: 30%)
Постулат Бертрана (теорема Бертрана-Чебышева, теорема Чебышева) гласит, что для любого n > 1 найдется простое число p в 
интервале n < p < 2n. Такая гипотеза была выдвинута в 1845 году французским математиком Джозефем Бертраном (проверившим ее
до n=3000000) и доказана в 1850 году Пафнутием Чебышевым. Раманужан в 1920 году нашел более простое доказательство, а Эрдеш 
в 1932 – еще более простое.
	Ваша задача состоит в том, чтобы решить несколько более общую задачу – а именно по числу n найти количество простых чисел 
p из интервала n < p < 2n.
	Напомним, что число называется простым, если оно делится только само на себя и на единицу.
	Входные данные
Входной файл INPUT.TXT содержит целое число n (2 ≤ n ≤ 50000).
	Выходные данные
В выходной файл OUTPUT.TXT выведите одно число – ответ на задачу.
		Примеры
№	INPUT.TXT	OUTPUT.TXT
1		2			1
2		239			39
3		3000		353   */

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0036_Simple_Figures {
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int n = sc.nextInt();
	sc.close();
	n = 100;
//	System.out.println("n = " + n);
	
	/* Решение   Решето Эратосфена
	 * Пример для n = 30
	Запишем натуральные числа, начиная от 2, до 30 в ряд:
	2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30
	Первое число в списке, 2 — простое. Пройдём по ряду чисел, зачёркивая все числа, кратные 2 (то есть, каждое второе, начиная с 22 = 4):

	2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30
	Следующее незачеркнутое число, 3 — простое. Пройдём по ряду чисел, зачёркивая все числа, кратные 3 (то есть, каждое третье, начиная с 32 = 9):

	2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30
	Следующее незачеркнутое число, 5 — простое. Пройдём по ряду чисел, зачёркивая все числа, кратные 5 (то есть, каждое пятое, начиная с 52 = 25):

	2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30
	Следующее незачеркнутое число — 7. Его квадрат, 49 — больше 30, поэтому на этом работа завершена. Все составные числа уже зачеркнуты:

	2  3     5     7           11    13          17    19          23                29
	 */
	
	int m = 2*n;
	boolean Array[] = new boolean [m];	
	Arrays.fill(Array, true);
//	System.out.println(Arrays.toString(Array));	

	int k = 0;
	for (int i = 2; i<m; i++) {
		if (Array[i] == true)  {
			for (k = i+i; k<m; k = k + i) {
				Array[k] = false; }
		}
	}
	int count = 0;
	for (int i = n+1; i<m; i++) {
		if (Array[i] == true)  count++;}
	System.out.println(count);
//	
//	for (int i = 0; i<Array.length; i++)
//		if (Array[i] == true) System.out.print(i + " ");
	
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(count);
	pw.close();
	}
}