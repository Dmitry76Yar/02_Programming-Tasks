package f03_ACMP_51_100;
/*	 Несложное вычисление		(Время: 1 сек. Память: 16 Мб Сложность: 25%)
Задано натуральное число n. Необходимо перевести его в k-ичную систему счисления и найти разность между произведением и суммой его цифр
в этой системе счисления.
	Например, пусть n = 239, k = 8. Тогда представление числа n в восьмеричной системе счисления — 357, а ответ на задачу равен 3 × 5 × 7
− (3 + 5 + 7) = 90.
	Входные данные
Входной файл INPUT.TXT содержит два натуральных числа: n и k (1 ≤ n ≤ 109, 2 ≤ k ≤ 10). Оба этих числа заданы в десятичной системе счисления.
	Выходные данные
В выходной файл OUTPUT.TXT выведите ответ на задачу (в десятичной системе счисления).
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	239 8			90
2	1000000000 7	-34*/

import java.io.*;
import java.util.Scanner;

public class acmp_0059_Syst_Schislen {
	
	public static String transfer(int N, int K) {
		StringBuffer result_str = new StringBuffer();
		int temp = N;
		while (temp >=1) {
//			System.out.println(temp%K);
			result_str.append(temp%K);
//			System.out.println(result_str.toString());
			temp = temp/K;
//			System.out.println("temp = " + temp);
		}
		return result_str.reverse().toString();}
		
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();		
	int K = sc.nextInt();
	System.out.println("N = " + N + ",   K = " + K);
	String result = transfer(N,K);
	System.out.println(result);
	int sum = 0;
	int multy = 1;
	for (int i = 0; i<result.length(); i++) {
		sum = sum + Integer.parseInt(result.substring(i, i+1));
		multy = multy*Integer.parseInt(result.substring(i, i+1));
	}
	System.out.println("sum = " + sum + ",  multy = " + multy);
	int answer = multy - sum;
	System.out.println(answer);
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(answer);
	pw.close();
}
}
