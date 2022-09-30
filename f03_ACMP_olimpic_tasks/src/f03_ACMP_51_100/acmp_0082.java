package f03_ACMP_51_100;
	/*	Выпуклая оболочка	(Время: 1 сек. Память: 16 Мб Сложность: 27%)
Рассмотрим бесконечный лист клетчатой бумаги. Закрасим некоторое множество клеток в черный цвет. Теперь мы хотим закрасить минимальное
количество клеток, так, чтобы множество черных клеток стало выпуклым.

Напомним, что геометрическая фигура Φ называется выпуклой, если для любых точек A из Φ и В из Φ с вещественными координатами отрезок [AB]
принадлежит Φ.
	Входные данные
В первой строке входного файла INPUT.TXT содержатся два числа N и M (1 ≤ N, M ≤ 100) — размеры куска бумаги, куда попали все черные клетки.
В каждой из следующих N строк содержится М символов «*» или «.». Символ «*» обозначает черную клетку, а «.» белую.
	Выходные данные
В выходной файл OUTPUT.TXT выведите выпуклое множество, содержащее минимальное количество дополнительно покрашенных черных клеток, в ровно
N строках по M символов «*» или «.» в каждой.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	2 4
	..*.			.**.
	.**.			.**.
					
2	4 3
	.*.				.*.
	.*.				.*.
	.*.				.*.
	.*.				.*.		 */	

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

// Заваливает 12 тест 1,087  память 28 мб

public class acmp_0082  {
public static void main(String[] args) throws IOException {
	int Count[] = new int [201];
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	int M = sc.nextInt();
	System.out.println("N = " + N);
	System.out.println("M = " + M);
	sc.nextLine();
//	System.out.println(sc.next());
	String Arr[][] = new String[N][M];
	String temp = null;
	for (int i = 0; i<N; i++) {
		temp = sc.next();
		for (int j = 0; j<M; j++) 	{
			Arr[i][j] = temp.substring(j, j+1); 	}
	}
	for (int i = 0; i<N; i++) 	System.out.println(Arrays.toString(Arr[i]));
	
	HashSet<Integer> arl = new HashSet<Integer>();			// Хранение номера столбцов, которые сожержат * в какой-либо строке
	ArrayList<Integer> arl2 = new ArrayList<Integer>();		// Хранение номеров строк, которые не содержат *
	
	for (int i = 0; i<N; i++) {
		boolean areThereStarts = false;
		for (int j = 0; j<M; j++) {
			if (Arr[i][j].equals("*") == true) {
				arl.add(i);
				areThereStarts = true;	}
		}
		if (areThereStarts == false)  arl2.add(i);
	}
	ArrayList<Integer> arl3 = new ArrayList<Integer>();
	Collections.sort(arl3);
	arl3.addAll(arl);
	System.out.println(arl3);
	int min = 0;
	int max = 0;
	if (arl3.size() !=0) {
		min = arl3.get(0);
		max = arl3.get(arl3.size()-1);}
	System.out.println("min = " + min);
	System.out.println("max = " + max);
	System.out.println(arl2);

	for (int i = min; i<max; i++) {
		for (int j = 0; j<M; j++) {
			Arr[i][j] = "*"; 		}
	}
	
//	for (int i = 0; i<N; i++) {
//		for (int j = 0; j<M; j++) {
//			if ((j>=min) && (j<=max)) Arr[i][j] = "*"; 		}
//	}
//	
//	for (int i = 0; i<N; i++) 	System.out.println(Arrays.toString(Arr[i]));
//	System.out.println();
//	
//	for (int i = 0; i<arl2.size(); i++) {
//		for (int j = 0; j<M; j++) {
//			Arr[arl2.get(i)][j] = "."; 		}
//	}
	
	for (int i = 0; i<N; i++) 	System.out.println(Arrays.toString(Arr[i]));
	
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	for (int i = 0; i<N; i++) {
		for (int j = 0; j<M; j++) pw.print(Arr[i][j]);
		pw.print("\n");}
	pw.close();
}
}