package f02_ACMP_0_50;

/*	Нули		(Время: 1 сек. Память: 16 Мб Сложность: 16%)
Требуется найти самую длинную непрерывную цепочку нулей в последовательности нулей и единиц.
	Входные данные
В единственной строке входного файла INPUT.TXT записана последовательность нулей и единиц (без пробелов). Суммарное 
количество цифр от 1 до 100.
	Выходные данные
В единственную строку выходного файла OUTPUT.TXT нужно вывести искомую длину цепочки нулей.
	Пример
№	INPUT.TXT			OUTPUT.TXT
1	00101110000110			4			 */

import java.io.*;
import java.util.Scanner;

public class acmp_0043_VEasy {
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	String str = sc.nextLine();
	System.out.println("str = " + str);		//00101110000110
	
	int count = 0;
	int sum = 0;
	
	for (int i = 0; i<str.length(); i++)
		if (str.charAt(i) == '0') {
			sum++;
			System.out.println("i = " + i + ",  sum= " + sum);
		}
		else {
			if (count <sum) count = sum;
			sum = 0;
		}
	if (count <sum) count = sum;
	
	System.out.println(count);
	
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(count);
	pw.close();
	
	}
}
