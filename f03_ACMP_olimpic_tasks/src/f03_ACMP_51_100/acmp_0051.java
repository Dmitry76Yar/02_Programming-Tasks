package f03_ACMP_51_100;

/*	Факториалы!!!		(Время: 1 сек. Память: 16 Мб Сложность: 26%)
Определение 1:
n!!...!=n(n-k)(n-2k)...(n mod k), если n не делится на k,
n!!...!=n(n-k)(n-2k)...k, если n делится на k (знаков ! в обоих случаях k штук).
Определение 2:
X mod Y — остаток от деления X на Y.
Например, 10 mod 3 = 1; 3! = 3•2•1; 10!!! = 10•7•4•1;
Мы по заданным n и k смогли вычислить значение выражения из определения 1. А вам слабо?
	Входные данные
Во входном файле INPUT.TXT содержится ровно одна строка. Сначала – целое число n, (1 ≤ n ≤ 10) , затем ровно один пробел,
затем k восклицательных знаков (1 ≤ k ≤ 20).
	Выходные данные
В выходной файл OUTPUT.TXT выведите одно число – значение n!!..! .
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	10 !!!			280
2	9 !!			945
3	3 !				6			 */

import java.io.*;
import java.util.Scanner;

public class acmp_0051 {
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	String str = sc.nextLine();
	String Ar[] = str.split(" ");
	int n = Integer.parseInt(Ar[0]);
	int k = Ar[1].length();
	System.out.println(" n = " + n + ",  k = " + k);
	
	int ostatok = n%k; 
	System.out.println(ostatok);
	int result = 1;
	int i = n	;
	while (i >0) {
		result = result*i;
		i= i-k;}
	if (k<n) {
		if (ostatok ==0)  result = result;
		else result = result*ostatok;
	}
	else result = n;
	System.out.println(result);
	
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(result);
	pw.close();
}
}
