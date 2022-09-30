package f04_ACMP_101_200;
/*Сортировка времени	(Время: 1 сек. Память: 16 Мб Сложность: 23%)
Требуется выполнить сортировку временных моментов, заданных в часах, минутах и секундах.
	Входные данные
Во входном файле INPUT.TXT в первой строке записано число N (1 ≤ N ≤ 100), а в последующих N строках N моментов времени. Каждый момент
времени задается 3 целыми числами - часы (от 0 до 23), минуты (от 0 до 59) и секунды (от 0 до 59).
	Выходные данные
В выходной файл OUTPUT.TXT выведите моменты времени, упорядоченные в порядке неубывания без ведущих нулей.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1	4
10 20 30
7 30 00
23 59 59
13 30 30	7 30 0
			10 20 30
			13 30 30
			23 59 59
 */

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0119 {
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	System.out.println(" N = " + N);
	int inputArray[][] = new int[N][3];
	
	for (int i = 0; i<N; i++) {
		for (int j = 0; j<3; j++) {
			inputArray[i][j] = sc.nextInt();
		}
		
	}
	System.out.println("Исходный массив");
	for (int i = 0; i<N; i++) System.out.println(Arrays.toString(inputArray[i]));
	System.out.println();
	
	int toSecondsArrau[] = new int[N];
	for (int i = 0; i<N; i++) {
		for (int j = 0; j<3; j++) {
			toSecondsArrau[i] = inputArray[i][0]*3600 + inputArray[i][1]*60 + inputArray[i][2];
		}
	}
	Arrays.sort(toSecondsArrau);
	System.out.println(Arrays.toString(toSecondsArrau));
	System.out.println();
	
	int resultArray[][] = new int[N][3];
	for (int i = 0; i<N; i++) {
			resultArray[i][0] = (int)toSecondsArrau[i]/3600;
			resultArray[i][1] = (int)(toSecondsArrau[i] - resultArray[i][0]*3600)/60;
			resultArray[i][2] = (toSecondsArrau[i] - resultArray[i][0]*3600 - resultArray[i][1]*60);
	}
	System.out.println("Финальный массив");
	for (int i = 0; i<N; i++) System.out.println(Arrays.toString(resultArray[i]));
	System.out.println();
	
		
	
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	for (int i = 0; i<N; i++) {
		for (int j = 0; j<3; j++) {
			out.print(resultArray[i][j] + " ");
		}
		out.print("\n");
	}
    out.flush();
    out.close();
	}
}
