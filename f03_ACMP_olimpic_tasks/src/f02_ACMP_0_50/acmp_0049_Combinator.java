package f02_ACMP_0_50;
/*Ўаблоны
(¬рем€: 1 сек. ѕам€ть: 16 ћб —ложность: 35%)
Ўаблоном размера n назовем строку длины n, каждый из символов которой входит в множество {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, a, b,
c, d, e, f, g, ?}. Ўаблоны преобразуютс€ в строки из цифр по следующим правилам:
	Х символы от 0 до 9 могут быть преобразованы только сами в себ€;
	Х символ a может преобразован в любой из символов 0,1, 2, 3;
	Х символ b может преобразован в любой из символов 1,2,3,4;
	Х символ c может преобразован в любой из символов 2,3,4,5;
	Х символ d может преобразован в любой из символов 3,4,5,6;
	Х символ e может преобразован в любой из символов 4,5,6,7;
	Х символ f может преобразован в любой из символов 5,6,7,8;
	Х символ g может преобразован в любой из символов 6,7,8,9;
	Х символ ? может преобразован в любой из символов от 0 до 9;
ƒаны два шаблона: p1 и p2. –ассмотрим множество S1 строк, которые могут быть получены из p1 по описанным правилам, и
множество S2 строк, которые могут быть получены из p2. Ќеобходимо найти количество строк, вход€щих в оба этих множества.
	¬ходные данные
ѕерва€ строка входного файла INPUT.TXT содержит шаблон p1, втора€ Ч шаблон p2. Ўаблоны имеют одинаковый положительный размер,
не больше 9.
	¬ыходные данные
¬ выходной файл OUTPUT.TXT выведите ответ на задачу.
	ѕримеры
є	INPUT.TXT	OUTPUT.TXT
1		???
		abc			64
2		???
		000			1
3		abc
		999			0		*/

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0049_Combinator {
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	String str1 = sc.nextLine();
	String str2 = sc.nextLine();
	sc.close();
	String str1_array[] = str1.split("");
	String str2_array[] = str2.split("");
	System.out.println(Arrays.toString(str1_array));
	System.out.println(Arrays.toString(str2_array));
	
	for (int i = 0; i<str1.length(); i++) {
		if (str1_array[i].equals("a")) str1_array[i] = "0123";	if (str2_array[i].equals("a")) str2_array[i] = "0123";
		if (str1_array[i].equals("b")) str1_array[i] = "1234";	if (str2_array[i].equals("b")) str2_array[i] = "1234";
		if (str1_array[i].equals("c")) str1_array[i] = "2345";	if (str2_array[i].equals("c")) str2_array[i] = "2345";
		if (str1_array[i].equals("d")) str1_array[i] = "3456";	if (str2_array[i].equals("d")) str2_array[i] = "3456";
		if (str1_array[i].equals("e")) str1_array[i] = "4567";	if (str2_array[i].equals("e")) str2_array[i] = "4567";
		if (str1_array[i].equals("f")) str1_array[i] = "5678";	if (str2_array[i].equals("f")) str2_array[i] = "5678";
		if (str1_array[i].equals("g")) str1_array[i] = "6789";	if (str2_array[i].equals("g")) str2_array[i] = "6789";
		if (str1_array[i].equals("?")) str1_array[i] = "0123456789";
		if (str2_array[i].equals("?")) str2_array[i] = "0123456789";
	}
	
	System.out.println(Arrays.toString(str1_array));
	System.out.println(Arrays.toString(str2_array));
	
	long result = 1;
	int count = 0;
	for (int i = 0; i<str1.length(); i++) {
		if (str1_array[i].length() >= str2_array[i].length()) {
//			System.out.println("1 больше");
			for (int j = 0; j<str2_array[i].length(); j++) {
				if (str1_array[i].contains(str2_array[i].substring(j, j+1))) count++;
				}
		}
		else 	{
//			System.out.println("2 больше");
			for (int j = 0; j<str1_array[i].length(); j++) {
				if (str2_array[i].contains(str1_array[i].substring(j, j+1))) count++; 
				}
		}
//		System.out.println(count);
		result = result*count;
		count = 0;
	}
	System.out.println(result);
	
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(result);
	pw.close();
	
	
	}
}
