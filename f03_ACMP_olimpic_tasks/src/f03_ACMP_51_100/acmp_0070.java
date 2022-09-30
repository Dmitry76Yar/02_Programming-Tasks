package f03_ACMP_51_100;
/*	Степень строки		(Время: 1 сек. Память: 16 Мб Сложность: 30%)
Пусть задана строка s = s1s2...sn. Назовем ее k-ой (k > 0) степенью sk строку sk = s1s2 . . .sns1s2 . . .sn......s1s2...sn (k раз). 
Например, третьей степенью строки abc является строка abcabcabc.
	Корнем k степени из строки s называется такая строка t (если она существует), что tk = s.
	Ваша задача состоит в том, чтобы написать программу, находящую степень строки или корень из нее.
	Входные данные
Первая строка входного файла INPUT.TXT содержит строку s, она содержит только маленькие буквы английского алфавита и имеет ненулевую длину,
не превосходящую 1000.
	Вторая строка входного файла содержит целое число k ≠ 0, |k| < 100001. Если k > 0, то необходимо найти k-ую степень строки s, если k < 0,
то необходимо найти корень степени |k| из s.
	Выходные данные
В выходной файл OUTPUT.TXT выведите строку, являющуюся ответом на задачу. Если длина ответа превосходит 1023 символа, выведите только
первые 1023 символа. Если искомой строки не существует — выведите NO SOLUTION.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	abc
	3			abcabcabc
2	abcdabcd
	-2			abcd
3	abcd
	-4			NO SOLUTION		 */

import java.io.*;
import java.util.Scanner;

public class acmp_0070 {
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	String str = sc.nextLine();
	int k = sc.nextInt();

	String result = null;
	StringBuffer sbf = new StringBuffer();
		// Нахождение k-ой степени
	if (k>0) {
		for (int i = 1; i<=k; i++) {
			sbf.append(str);	
			if (sbf.length() > 1023) break;		}
		result = sbf.toString();
		}
	else {
		if (str.length()%Math.abs(k) != 0) result = "NO SOLUTION";
		else {
			int div = str.length()/Math.abs(k);
			String sub_str = str.substring(0, div);
			System.out.println("sub_str = " + sub_str);
			boolean isAllSustringIsEqual = true;
			for (int i = 0; i<str.length(); i = i + div) {
				System.out.println("str.substring(i, i + div) = " +  str.substring(i, i + div));
				if (str.substring(i, i + div).equals(sub_str)) isAllSustringIsEqual = true;	
				else {
					isAllSustringIsEqual = false; 
					break;
				}
			}
			if (isAllSustringIsEqual == false) result = "NO SOLUTION";
			else result = sub_str;
			}
		}
	String result1 = null;
	if (result.length() > 1023) result1 = result.substring(0, 1023);
	else result1 = result;
	System.out.println(result1);
	
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(result1);
	pw.close();
}
}
