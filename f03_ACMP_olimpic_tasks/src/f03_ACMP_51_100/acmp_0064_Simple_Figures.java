package f03_ACMP_51_100;
/*	Простой ряд		(Время: 1 сек. Память: 16 Мб Сложность: 27%)
Простым числом называется натуральное число (большее 1), которое делится нацело только на 1 и на само себя. Например, числа 2, 3, 5, 7, 11
и 23 - простые . Назовем простым рядом последовательность цифр, полученную следующим образом: подряд идущие по возрастанию простые числа
(начиная с 2) записываются друг за другом. Начало данного ряда выглядит так: 23571113171923… Необходимо найти цифру, стоящую в простом ряду
на указанном месте. Нумерация позиций начинается с единицы.
	Входные данные
В первой строке входного файла INPUT.TXT записано натуральное число M – количество тестов. Во второй строке записано M чисел через пробел,
каждое число – номер позиции в простом ряду (1 ≤ M ≤ 1000, 1 ≤ номер позиции ≤ 10000).
	Выходные данные
В выходной файл OUTPUT.TXT для каждой позиции выведите цифру из простого ряда, стоящую на этой позиции. Вывести следует M цифр в одной
строке, не разделяя цифры пробелами.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	3
	1 4 11			271
2	5
	2 5 6 8 12		31139 */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0064_Simple_Figures {
	
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
	static String prostie_chisla_stroka () {
		boolean Array[] = new boolean [21000];	
		Arrays.fill(Array, true);
		System.out.println(Arrays.toString(Array));	
			// Алгоритм для выделения (через true) простых чисел в массива 
		int j = 0;
		for (int i = 2; i<Array.length; i++) {
			if (Array[i] == true)  {
				for (j = i+i; j<Array.length; j = j + i) {
					Array[j] = false; }
			}
		}
		System.out.println(Arrays.toString(Array));
		
		StringBuffer sbf = new StringBuffer();		// StringBuffer для хранения простых чисел 
		for (int i = 1; i<Array.length; i++) {
			if (Array[i] == true)  {
				sbf.append(i);
			}
		}
		String prostie_chisla = sbf.toString();
		System.out.println(prostie_chisla);
		System.out.println(prostie_chisla.length());
		return prostie_chisla;
	}
	
public static void main(String[] args) throws IOException {
	String result = null;
	StringBuffer result_sbf = new StringBuffer();
	String stroka_prostih_chisel = prostie_chisla_stroka();
	
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int M = sc.nextInt();
	System.out.println("M = " + M);
	
	for (int i = 0; i<M; i++) {
		int a = sc.nextInt();
		result_sbf.append(stroka_prostih_chisel.subSequence(a, a+1));
	}
	sc.close();
	result = result_sbf.toString();
	System.out.println(result);

	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(result);
	pw.close();
}
}
