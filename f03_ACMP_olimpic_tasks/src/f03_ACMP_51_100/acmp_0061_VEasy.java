package f03_ACMP_51_100;
/*	Баскетбол  (Время: 1 сек. Память: 16 Мб Сложность: 5%)
Известны результаты каждой из 4х четвертей баскетбольной встречи. Нужно определить победителя матча. Побеждает команда, набравшая больше
очков в течение всего матча.
	Входные данные
Входной файл INPUT.TXT содержит 4 строки, в каждой строке находится два целых числа a и b – итоговый счет в соответствующей четверти. а
– количество набранных очков за четверть первой командой, b – количество очков, набранных за четверть второй командой. (0 ≤ a,b ≤ 100).
	Выходные данные
В выходной файл OUTPUT.TXT выведите номер выигравшей команды, в случае ничьей следует вывести «DRAW».
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	26 17
	13 15
	19 11
	14 16			1
2	14 15
	17 18
	20 20
	15 17			2
3	15 16
	18 17
	10 12
	14 12			DRAW
 */

import java.io.*;
import java.util.Scanner;

public class acmp_0061_VEasy {
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int a1 = sc.nextInt();		int b1 = sc.nextInt();
	int a2 = sc.nextInt();		int b2 = sc.nextInt();
	int a3 = sc.nextInt();		int b3 = sc.nextInt();
	int a4 = sc.nextInt();		int b4 = sc.nextInt();
	
	String result;
	if ((a1+a2+a3+a4) > (b1+b2+b3+b4)) result = "1";
	else if ((a1+a2+a3+a4) < (b1+b2+b3+b4)) result = "2";
	else result = "DRAW";
	
	System.out.println(result);
	
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(result);
	pw.close();
}
}
