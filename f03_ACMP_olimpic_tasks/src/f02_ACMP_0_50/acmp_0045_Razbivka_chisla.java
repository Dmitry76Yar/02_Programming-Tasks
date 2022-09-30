package f02_ACMP_0_50;
/*	Произведение цифр			(Время: 1 сек. Память: 16 Мб Сложность: 42%)
Требуется найти наименьшее натуральное число Q такое, что произведение его цифр равно заданному числу N.
	Входные данные
В единственной строке входного файла INPUT.TXT записано одно целое число N (0 ≤ N ≤ 109).
	Выходные данные
В выходной файл OUTPUT.TXT нужно вывести искомое число Q. В том случае, если такого числа не существует, следует вывести -1.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1		10			25
2		13			-1
3		8			8
4		90			259		 */

import java.io.*;
import java.util.Scanner;

public class acmp_0045_Razbivka_chisla {
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	long n = sc.nextLong();
	StringBuffer sb = new StringBuffer();
	
//	n = 118098;
	String str_opp  = null;
	
	if (n == 0) str_opp = "10";
	else if (n == 1) str_opp = "1";
	else {
			for (int i = 9; i>1; i--) {
				System.out.println("i = " + i);
				if (n%i == 0) {
					sb.append(i);
					n = n/i;
					System.out.println("i = " + i + ",  n = " + n);
					i = 10;
				}
				if (n==1) {
					String str_res = sb.toString();
					System.out.println("str_res = " + str_res);
					StringBuffer sb1 = new StringBuffer();
					for (int j = str_res.length()-1; j>=0; j--)	sb1.append(str_res.charAt(j));
					str_opp = sb1.toString();
					i=1;
				}
				if (i==2) {
					System.out.println("ddd");
					str_opp = "-1"; 	
				}
		}
	}
		
	System.out.println(str_opp);
	
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(str_opp);
	pw.close();
	}
}
