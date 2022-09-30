package f04_ACMP_101_200;

	/*		Снова A+B		(Время: 1 сек. Память: 16 Мб Сложность: 35%)
Требуется сложить два целых числа А и В.
	Входные данные
Во входном файле INPUT.TXT записано два неотрицательных целых числа, не превышающих 10100, по одному в каждой строке.
	Выходные данные
В единственную строку выходного файла OUTPUT.TXT нужно вывести одно целое число — сумму чисел А и В, без лидирующих нулей.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1		2
		3			5		*/	

import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

public class acmp_0103  {
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	String a_str = sc.nextLine();
	String b_str = sc.nextLine();
//	BigInteger a = new BigInteger(sc.nextLine());
//	BigInteger b = new BigInteger(sc.nextLine());
	BigInteger a = new BigInteger(a_str);
	BigInteger b = new BigInteger(b_str);
	
	System.out.println(a.add(b));
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	out.println(a.add(b));
    out.flush();
    out.close();
}
}