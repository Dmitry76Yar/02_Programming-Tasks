package f02_ACMP_0_50;

/*	Лесенка		(Время: 1 сек. Память: 16 Мб Сложность: 55%)
 * Лесенкой называется набор кубиков, в котором каждый более верхний слой содержит кубиков меньше, чем предыдущий. Требуется 
 написать программу, вычисляющую число лесенок, которое можно построить из N кубиков.
	Входные данные
Во входном файле INPUT.TXT записано натуральное число N (1 ≤ N ≤ 100) – количество кубиков в лесенке.
	Выходные данные
В выходной файл OUTPUT.TXT необходимо вывести число лесенок, которые можно построить из N кубиков.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	3				2
2	6				4		 */

import java.io.*;
import java.util.Scanner;

/*  РЕШЕНИЕ через динамическое программирование
 * Кол-во квадратов = 0 -> решение  = 1;		(не возможно)
 * Кол-во квадратов = 1 -> решение  = 1;		(1+0)
 * Кол-во квадратов = 2 -> решение  = 1;		(2+0)	
 * Кол-во квадратов = 3 -> решение  = 2;		(3+0, 2+1)
 * Кол-во квадратов = 4 -> решение  = 2;		(4+0, 3+1)
 * Кол-во квадратов = 5 -> решение  = 3;		(5+0, 4+1, 3+2)
 * Кол-во квадратов = 6 -> решение  = 4;		(6+0, 5+1, 4+2, 3+2+1)
 * Кол-во квадратов = 7 -> решение  = 5;		(7+0, 6+1, 5+2, 4+3, 4+2+1)
 * Кол-во квадратов = 8 -> решение  = 6;		(8+0, 7+1, 6+2, 5+3, 5+2+1, 4+3+1)
 * Кол-во квадратов = 9 -> решение  = 8;		(9+0, 8+1, 7+2, 6+3, 6+2+1, 5+4, 5+3+1, 4+3+2 )
 * 	ДЛЯ 7 КВАДРАТА Кол-во решений = f(3) + f(2) + f(1) + f(0) = 2 + 1 +1 + 1 = 5
 *  ИТОГО для N квадрата  f(N) = f(N-A) + f(N-A+1) + f(N-A+2)...f(N-A), где А число равное ` */
public class acmp_0016 {
	
	static void calc (int n) {
		System.out.println("Вход с n = " + n);
		for (int i= 1; i<n; i++) {
			if (i<(n-i))  {
				System.out.println(" i = " + i + "< (n-i) = " + (n-i));
				calc(i); }
			else System.out.println("Выход с n = " + n);
		
				
				i++;
				break;}
		}
	}
	
	
public static void main(String[] args) throws IOException {
	Scanner sc; 
	int n = 9;
	calc(n);
	
//	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
//	if (sc.hasNextInt()) n = sc.nextInt();
//	if ((n>=1) & (n<=100)) {
//		
	}
}
