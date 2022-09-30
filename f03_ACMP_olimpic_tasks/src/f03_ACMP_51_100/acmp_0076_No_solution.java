package f03_ACMP_51_100;
/*	Музей	(Время: 1 сек. Память: 16 Мб Сложность: 50%)
В музее регистрируется в течение суток время прихода и ухода каждого посетителя. Таким образом, за день получены N пар значений, где первое
значение в паре показывает время прихода посетителя и второе значение - время его ухода. Требуется найти максимальное число посетителей,
которые находились в музее одновременно.
	Входные данные
В первой строке входного файла INPUT.TXT записано натуральное число N (N < 105) – количество зафиксированных посетителей в музее в течениe
суток. Далее, идут N строк с информацией о времени визитов посетителей: в каждой строке располагается отрезок времени посещения в формате
«ЧЧ:ММ ЧЧ:ММ» (00:00 ≤ ЧЧ:ММ ≤ 23:59).
	Выходные данные
В единственную строку выходного файла OUTPUT.TXT нужно вывести одно целое число — максимальное количество посетителей, одновременно
находящихся в музее.
	Пример
№	INPUT.TXT		OUTPUT.TXT
1	6
	09:00 10:07
	10:20 11:35
	12:00 17:00
	11:00 11:30
	11:20 12:30
	11:30 18:15			4	 */

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0076_No_solution {
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();		System.out.println("N= " + N);
	sc.nextLine();
	int Massive[][] = new int[N][4];
	int index_of_first_points = 0;			int index_of_last_points = 0;
	
	for (int i = 0; i<N; i++) {
		String[] str  = sc.nextLine().replace(':', ' ').split(" ");
//		System.out.println(Arrays.toString(str));
		Massive[i][0] = Integer.parseInt(str[0]);  	  
		Massive[i][1] = Integer.parseInt(str[1]);	
		Massive[i][2] = Integer.parseInt(str[2]);	if (Massive[i][2] == 0) Massive[i][2] = 24;
		Massive[i][3] = Integer.parseInt(str[3]);	
	}
	for (int i = 0; i<N; i++) System.out.println(Arrays.toString(Massive[i]));
	
	for (int i = 1; i<N; i++) {
		if ((Massive[i][0]) < (Massive[0][0]) && ((Massive[i][2])>(Massive[0][2]))) 	System.out.println(" i = " + i + "  Не в пределах");
		else if ((Massive[i][0]) == (Massive[0][0]) && ((Massive[i][2])>(Massive[0][2])))
			
		}
		
		
		if ((Massive[i][0])>=(Massive[0][0]) && ((Massive[i][2])<=(Massive[0][2])) &&   // Проверка часов
				(Massive[i][1])>=(Massive[0][1]) && (Massive[i][3])=(Massive[0][3]))    // Проверка минут
				System.out.println(" i = " + i + "   B пределах");
		
//		if ((Massive[0][0] <= Massive[i][0]) & (Massive[0][2] <= Massive[i][0])) {
//			if (Massive[0][3] <= Massive[i][1]) System.out.println("Входит в рамки");
//			else System.out.println("Выходит за рамки");}
//		else System.out.println("Выходит за рамки");
	}
//	for (int i = 0; i<N;
		
		
//		index_of_first_points = str1.indexOf(':');
//		index_of_last_points = str1.lastIndexOf(':');
//		String str2  = str1.substring(0,index_of_first_points) + str1.substring(index_of_first_points+1, index_of_last_points) +
//		str1.substring(index_of_last_points+1,str1.length());
//		System.out.println(str2);
		
//		String str[] = sc.nextLine()..split(" ");
//		Massive[i][0] = Integer.parseInt(str[0]);
//		Massive[i][1] = Integer.parseInt(str[1]);
//	}
//	for (int i = 0; i<N; i++) System.out.println(Arrays.toString(Massive[i]));
	
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
//	pw.print(result);
	pw.close();
}
}
