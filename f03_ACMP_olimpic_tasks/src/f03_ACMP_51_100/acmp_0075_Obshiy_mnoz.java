package f03_ACMP_51_100;
/*	Сумма произведений		(Время: 1 сек. Память: 16 Мб Сложность: 48%)
Требуется вычислить сумму произведений цифр каждого N-значного числа. При этом следует учесть, что если в числе встречается цифра 0, то
произведение его цифр равно нулю. Для N=3 искомая сумма представлена следующим рядом:
	S = 1*0*0 + 1*0*1 + 1*0*2 + … + 9*9*8 + 9*9*9 = 91125
	Входные данные
В единственной строке входного файла INPUT.TXT записано натуральное число N (N < 1000).
	Выходные данные
В единственную строку выходного файла OUTPUT.TXT нужно вывести одно целое число — сумму произведений цифр всех N-значных чисел.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	1				45
2	3				91125
3	5				184528125	 */

import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

public class acmp_0075_Obshiy_mnoz {
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	
	// 9*8*1+ 9*8*2 + 9*8*3+ 9*8*4 + 9*8*5 + 9*8*6 + 9*8*7 + 9*8*8 + 9*8*9   = 9*8*(45)
	// 9*8*1+ 9*8*2 + 9*8*3+ 9*8*4 + 9*8*5 + 9*8*6 + 9*8*7 + 9*8*8 + 9*8*9 = 9*9*(45)
	// 45*45*45
	
	BigInteger result = new BigInteger("1");
	BigInteger j = new BigInteger("45");
	for (int i = 1; i<=N; i++) {
		result = result.multiply(j);
	}
	
	System.out.println(result.toString());
	
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
//	pw.print(result);
	pw.close();
}
}
