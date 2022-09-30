package f02_ACMP_0_50;
/*	Строки		(Время: 1 сек. Память: 16 Мб Сложность: 29%)
Циклическим сдвигом строки s называется строка sksk+1sk+2…s|s|s1s2…sk-1 для некоторого k, здесь |s| - длина строки s.
Подстрокой строки s называется строка sisi+1…sj-1sj для некоторых i и j. Вам даны две строки a и b. Выведите количество 
подстрок строки a, являющихся циклическими сдвигами строки b.
	Входные данные
Первая строка входного файла INPUT.TXT содержит строку a (1 ≤ |a| ≤ 1000). Во второй строке входного файла записана строка b 
(1 ≤ |b| ≤ min(100,|a|)). Обе строки состоят только из символов английского алфавита и цифр.
	Выходные данные
В выходной файл OUTPUT.TXT выведите целое число – ответ на задачу.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	abcabc
	abc				4
2	abcabc
	acb				0
3	aaaaaaa
	aa				6
4	aAaa8aaAa
	aAa				4*/

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class acmp_0050 {
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	String str1 = sc.nextLine();
	String str2 = sc.nextLine();
	sc.close();
	
	HashSet<String> str2_Set = new HashSet<String>(); 
	String before = null;
	String after = null;
	String current = null;
	for (int i =0; i<str2.length(); i++) {
		current = str2.substring(i, i+1);
		before = str2.substring(0, i);
		after = str2.substring(i+1,str2.length());
		str2_Set.add(current + after + before);
//		System.out.println("current = " + current + ",  before = " + before + ",  after = " + after + ",  str2_array[i] = " + str2_array[i]);
	}
	
	String str2_array[] = new String [str2_Set.size()];
	str2_array = str2_Set.toArray(str2_array);
	System.out.println(Arrays.toString(str2_array));
	
	int count = 0;
	for (int i =0; i<str2_array.length; i++) {
		for (int j =0; j<str1.length() - str2_array[i].length()+1 ; j++) {
//			System.out.println("На входе  i = " + i + ",    на входе j = " + j);
//			System.out.print("str2_array[i] = " + str2_array[i] + "\t");
//			System.out.println(" str1.substring(j, j+ str2_array[i].length()) = " + str1.substring(j, j+ str2_array[i].length()));
			if (str2_array[i].equals(str1.substring(j, j+ str2_array[i].length()))) {
				count ++;
			}
		}
	}
	System.out.println(count);
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(count);
	pw.close();
	
	
	}
}
