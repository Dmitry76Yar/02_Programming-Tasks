package f02_ACMP_0_50;

/*	Гадание		(Время: 1 сек. Память: 16 Мб Сложность: 13%)
	Как и многие другие девочки, Маша любит разные гадания. Некоторое время назад Маша узнала новый способ гадать на числах – 
для какого-нибудь интересующего ее натурального числа n надо посчитать сумму всех чисел, на которые n делится без остатка. 
аша не очень любит арифметику, и попросила вас написать программу, которая автоматизирует процесс гадания.
	Входные данные
В единственной строке входного файла INPUT.TXT записано натуральное число n (n ≤ 1000), которое Маша была вынуждена сообщить.
Выходные данные
В выходной файл OUTPUT.TXT выведите сумму всех натуральных делителей числа n.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	6			12
2	10			18		 */
import java.io.*;
import java.util.Scanner;

public class acmp_0023_VE {
public static void main(String[] args) throws IOException {
	int a = 0;
	int sum = 0;
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	while (sc.hasNext()) 
		if (sc.hasNextInt()) a = sc.nextInt();
	
	if ((a>0) & (a<=1000)) {
		for (int i = 1; i<=a; i++) 
			if (a%i == 0) sum = sum + i;
	
		System.out.println(sum);
		PrintWriter pw;
		pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
		pw.print(sum);
		pw.close();
	}
	}
}
