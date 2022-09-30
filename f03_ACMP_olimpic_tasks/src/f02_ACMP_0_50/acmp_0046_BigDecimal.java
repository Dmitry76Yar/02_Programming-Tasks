package f02_ACMP_0_50;

/*	НЧисло E
(Время: 1 сек. Память: 16 Мб Сложность: 20%)
Выведите в выходной файл округленное до n знаков после десятичной точки число E. В данной задаче будем считать, что число Е в точности равно 2.7182818284590452353602875.

Входные данные
Входной файл INPUT.TXT содержит целое число n (0 ≤ n ≤ 25).

Выходные данные
В выходной файл OUTPUT.TXT выведите ответ на задачу.

Пример
№	INPUT.TXT	OUTPUT.TXT
1	0	3
2	25	2.7182818284590452353602875
3	13	2.7182818284590		 */

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class acmp_0046_BigDecimal {
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int n = sc.nextInt();
	System.out.println("n = " + n);		
//	n = 13;
	
	BigDecimal e = new BigDecimal("2.7182818284590452353602875");
	System.out.println(e);
	
	BigDecimal e_scaled = e.setScale(n, RoundingMode.HALF_UP);

	System.out.println(e_scaled);
	
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(e_scaled);
	pw.close();
	}
}
