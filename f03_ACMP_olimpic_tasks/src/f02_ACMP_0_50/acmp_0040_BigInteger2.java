package f02_ACMP_0_50;

/*  2^N		(Время: 1 сек. Память: 16 Мб Сложность: 30%)
Необходимо вычислить значение 2n.
	Входные данные
В единственной строке входного файла INPUT.TXT записано натуральное число n (0 < n < 1000).
	Выходные данные
В единственную строку выходного файла OUTPUT.TXT нужно вывести значение 2n.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1		3				8
2		10				1024
3		72			4722366482869645213696	 */

import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

public class acmp_0040_BigInteger2{
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int n = sc.nextInt();
	System.out.println(n);
	
	BigInteger result = new BigInteger("1");
	BigInteger dvoika = new BigInteger("2");
	for (int i = 1; i<=n; i++) {
		result = dvoika.multiply(result);
	}
		System.out.println(result);	
		PrintWriter pw;
		pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
		pw.print(result);
		pw.close();
	}
}	
