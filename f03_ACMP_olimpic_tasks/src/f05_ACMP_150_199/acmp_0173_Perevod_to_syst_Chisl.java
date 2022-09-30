	package f05_ACMP_150_199;

/* Число - палиндром	(Время: 1 сек. Память: 16 Мб Сложность: 29%)
Напомним, что палиндромом называется строка, одинаково читающаяся с обеих сторон. Например, строка «ABBA» является палиндромом,
а строка «ABC» - нет.
	Необходимо определить, в каких системах счисления с основанием от 2 до 36 представление заданного числа N является палиндромом.
	В системах счисления с основанием большим 10 в качестве цифр используются буквы английского алфавита: A, B, ... , Z. Например,
A11 = 1010, Z36 = 3510.
	Входные данные
Входной файл INPUT.TXT содержит заданное число N в десятичной системе счисления (1 ≤ N ≤ 109).
	Выходные данные
Если соответствующее основание системы счисления определяется единственным образом, то выведите в первой строке выходного файла
OUTPUT.TXT слово «unique», если оно не единственно — выведите в первой строке выходного файла слово «multiple». Если же такого
основания системы счисления не существует — выведите в первой строке выходного файла слово «none».
	В случае существования хотя бы одного требуемого основания системы счисления выведите через пробел в возрастающем порядке во
второй строке выходного файла все основания системы счисления, удовлетворяющие требованиям.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	123			unique
				6
2	111			multiple
				6 10 36
3	102892748	none	 */

import java.util.*;
import java.io.*;

public class acmp_0173_Perevod_to_syst_Chisl{
	
	static String toOtherSystStchisl(int N, int systSthisl) {
		StringBuilder sb = new StringBuilder();
		if (systSthisl<10) {
			while (N!=0) {
				int a = N%systSthisl;
				sb.append(a);
				N = N/systSthisl;
			}
		}
		else {
			while (N!=0) {
				int a = N%systSthisl;
				if (a<10) sb.append(a);
				else {
					// i = 65,  ch = A     i = 90,  ch = Z
					sb.append((char)(65+a-10));
				}
				N = N/systSthisl;
			}
		}
		return sb.reverse().toString();
	}
	
	
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	ArrayList<Integer> result = new ArrayList<Integer>();
	
	for (int i=2; i<=36; i++) {
		String chislo = toOtherSystStchisl(N, i);
		System.out.println("chislo = " + chislo);
		int len = chislo.length();
		int l = len/2;
		System.out.print("len = " + len + "   l = " + l + "   ");
		if (len%2 == 1) {
			String a = chislo.substring(0,l);
			String c = chislo.substring(l+1, len);
			String b = new StringBuilder(chislo.substring(l+1, len)).reverse().toString();
			System.out.println("a1 = " + a + "   b = " + b + "    c = " + c);
			if (a.equals(b)) result.add(i);
		}
		else {		// 0 1 2 3 4 5 6
			String a = chislo.substring(0,l);
			String c = chislo.substring(l,len);
			String b = new StringBuilder(chislo.substring(l,len)).reverse().toString();
			System.out.println("a = " + a + "   b = " + b + "    c = " + c);
			if (a.equals(b)) result.add(i);
			
		}
	}
//	System.out.println(result);
	
	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	int r = result.size();
	if (r==1) {
		o.println("unique");
		o.print(result.get(0));
	}
	else if (r==0) o.print("none");
	else {
		o.println("multiple");
		for (int i=0;i<result.size();i++) o.print(result.get(i) + " ");
	}
	o.flush();
	o.close();
}
}