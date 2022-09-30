/* 	Требуется посчитать сумму целых чисел, расположенных между числами 1 и N включительно.
	Входные данные
В единственной строке входного файла INPUT.TXT записано единственное целое число N, не превышающее по абсолютной величине 10^4.
	Выходные данные
В единственную строку выходного файла OUTPUT.TXT нужно вывести одно целое число — сумму чисел, расположенных между 1 и N включительно.
Пример
№	INPUT.TXT		OUTPUT.TXT
1		5				15			 */


package f02_ACMP_0_50;

import java.io.*;
import java.util.Scanner;

public class acmp_0002 {
//public class MAIN {																ЗАМЕНА ДЛЯ САЙТА
	
	static int sum( int n) {
		int result = 0;
	if (n>0) 	for (int i=1; i<=n; i++ ) result = result + i;
	else 		for (int i = n; i<=1; i++)  result = result + i;
	System.out.println(result);
		return result;
	}
	
	// -5 -4 -3 -2 -1 0 1
	
public static void main(String[] args) {
	Scanner sc;
	PrintWriter pw = null; 
	int n = 0; 
	int a = 0;
	
	try { 
		sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt")); 	
		if (sc.hasNextInt() == true) 
			if (((a = sc.nextInt()) <= 10000) && (a>=-10000) ) n = a;  }
	catch (IOException e) {
		e.printStackTrace(); 	}
	System.out.println(n);
	
	try {
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(sum(n));}
	catch (IOException e) {
		e.printStackTrace(); 	}
	finally { pw.close(); 	}
	
	System.out.println("Done");
}
}
