package f05_ACMP_150_199;

/*  Сообщество роботов	(Время: 0,5 сек. Память: 16 Мб Сложность: 31%)
	Сообщество роботов живет по следующим законам:
один раз в начале года они объединяются в группы по три или пять роботов;
за год группа из трех роботов собирает 5 новых, а группа из 5 роботов – 9 новых;
роботы объединяются так, чтобы собрать за год наибольшее количество новых роботов;
каждый робот живет ровно три года после сборки.
В начале первого года было K роботов и все они были только что собраны.
	Требуется написать программу, которая найдет количество роботов в начале N-го года.
	Входные данные
Входной файл INPUT.TXT содержит записанные через пробел числа K (1 ≤ K ≤ 500) и N (1 ≤ N ≤ 100).
	Выходные данные
Выходной файл OUTPUT.TXT должен содержать одно число - количество роботов в начале N-го года. Количество роботов меньше, чем 231.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	3 2				8
2	8 2				22	 */

import java.util.*;
import java.io.*;

public class acmp_0166_Modelling{
	
	static int[] disperse (int a) {
		int[] res = new int[2];
		if (a==4) res[0] = 1;
		else if (a==7) res[0] = 2; 
		else {
			while (a>=3) {
				if (a%5 == 0) {
					res[1] = res[1] + a/5;
					break;
				}
				else {
					res[0]++;
					a = a-3;
				}
			}
		}
		return res;
	}
	
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int K = sc.nextInt();    // Стартовое кол-во роботов
	int N = sc.nextInt();	// Требуется написать программу, которая найдет количество роботов в начале N-го года.
	
//	K = 11; N = 7; 
	
	int liveCyvle[] = new int[N+1];	// Массив для хранения количества роботов, построенных в каждый i-тый год
	liveCyvle[1] = K;				// Кол-во роботов в 1-ый год
	int allRobots = K;
	
	System.out.println("Year " +  1 + "   newRobots = " + allRobots + "    allRobots " + allRobots + "   ");
		
	for (int i= 2; i<=N; i++) {
		int robots[] = disperse(allRobots);
//		System.out.print(Arrays.toString(robots));
		int newRobots = robots[0]*5 + robots[1]*9;
		liveCyvle[i] = newRobots; 
		if (i<=3) allRobots = allRobots + newRobots;
		else {
			allRobots = allRobots + newRobots - liveCyvle[i-3];
//			System.out.println("уменьшено до  allRobots " + allRobots + "   ");
		}
//		System.out.println("    Year " +  i + "   newRobots = " + newRobots + "    allRobots " + allRobots + "   ");
	}
	
	System.out.println("result = " + allRobots);
	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	o.print(allRobots);
	o.flush();
	o.close();
}
}




