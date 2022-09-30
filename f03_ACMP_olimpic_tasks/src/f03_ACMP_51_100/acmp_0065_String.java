package f03_ACMP_51_100;
/*	Расстояние Хэмминга			(Время: 1 сек. Память: 16 Мб Сложность: 27%)
В связи с особенностями линии связи, используемой для передачи сообщений из пункта A в пункт B, каждый бит принятого сообщения с
вероятностью 0.001 содержит ошибку.
	Из пункта A в пункт B было послано одно из n сообщений m1, m2, ..., mn. В пункте B было принято сообщение s.
	Ваша задача заключается в определении наиболее вероятного исходного сообщения. Очевидно, что оно будет одним из тех сообщений,
расстояние Хэмминга между которым и строкой s минимально.
	Расстоянием Хэмминга двух строк a и b одинаковой длины называется количество позиций, в которых эти строки различаются (количество
элементов в множестве {i | 1 ≤ i ≤ |a|, ai ≠ bi }).
	Входные данные
Первая строка входного файла INPUT.TXT содержит s — принятое сообщение. Вторая строка содержит целое число n — количество сообщений,
которые могли быть отправлены. Следующие n строк содержат mi — эти сообщения. Длины всех сообщений равны (|s| = |m1| = |m2| = ... = |mn|).
Сообщения непустые, состоят только из символов 0 и 1. Размер входного файла не превосходит 60 Кб.
	Выходные данные
В первую строку выходного файла OUTPUT.TXT выведите k — количество сообщений, на которых достигается минимум расстояния Хэмминга.
Во вторую строку выведите в порядке возрастания k чисел — номера этих сообщений.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1	010101				2
	3					2 3
	110011				
	011001
	000111	 */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0065_String {
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	String str_final = sc.nextLine();
	int N = sc.nextInt();
	if (N!=0) sc.nextLine();
	String Initial_strs[] = new String[N];
	for (int i =0; i<N; i++) Initial_strs[i] = sc.nextLine();
	System.out.println("N = " + N);
	System.out.println(" str_final = " + str_final);
	System.out.println(Arrays.toString(Initial_strs));
	
	ArrayList<String> result_arl = new ArrayList<String>();
	int min = str_final.length();
	for (int j = 0; j<Initial_strs.length; j++) {
		int count = 0;
		for (int i = 0; i<str_final.length(); i++) {
			if (str_final.substring(i, i+1).equals(Initial_strs[j].substring(i, i+1))) {
//				System.out.println("str_final.substring(i, i+1) = " + str_final.substring(i, i+1) + ",   Initial_strs[j].substring(i, i+1)) = " + Initial_strs[j].substring(i, i+1));
				count ++;
			}
		}
	System.out.println("Исходное = " + Initial_strs[j] + " содержит   " + (str_final.length() - count) + "    ошибок");
	if ((str_final.length() - count) < min) min = str_final.length() - count;
	}
	System.out.println("min = " + min);
	
	int count2 = 0;
	StringBuffer sbf = new StringBuffer();
	for (int j = 0; j<Initial_strs.length; j++) {
		int count = 0;
		for (int i = 0; i<str_final.length(); i++) {
			if (str_final.substring(i, i+1).equals(Initial_strs[j].substring(i, i+1))) {
//				System.out.println("str_final.substring(i, i+1) = " + str_final.substring(i, i+1) + ",   Initial_strs[j].substring(i, i+1)) = " + Initial_strs[j].substring(i, i+1));
				count ++;
			}
		}
	if ((str_final.length() - count) == min) {
		count2++;
		sbf.append((j+1) + " ");
	}
	}
	System.out.println(count2);
	System.out.println(sbf.toString());
	

	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(count2 + "\n" + sbf.toString());
	pw.close();
}
}
