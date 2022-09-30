package f03_ACMP_51_100;
	/*	Журавлики		(Время: 1 сек. Память: 16 Мб Сложность: 7%)
Петя, Катя и Сережа делают из бумаги журавликов. Вместе они сделали S журавликов. Сколько журавликов сделал каждый ребенок, если известно,
что Петя и Сережа сделали одинаковое количество журавликов, а Катя сделала в два раза больше журавликов, чем Петя и Сережа вместе?
	Входные данные
В единственной строке входного файла INPUT.TXT записано одно натуральное число S – общее количество сделанных журавликов (S < 106).
	Выходные данные
В единственную строку выходного файла OUTPUT.TXT нужно вывести три числа, разделенных пробелами – количество журавликов, которые сделал
каждый ребенок (Петя, Катя и Сережа).
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1		6		1 4 1
2		24		4 16 4
3		60		10 40 10	*/	

import java.io.*;
import java.util.Scanner;

public class acmp_0092_VEasy  {
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	int x = N/6;
	System.out.println(x + " " + 4*x + " " + x);
				
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
    out.println(x + " " + 4*x + " " + x);
    out.flush();
    out.close();
}
}
