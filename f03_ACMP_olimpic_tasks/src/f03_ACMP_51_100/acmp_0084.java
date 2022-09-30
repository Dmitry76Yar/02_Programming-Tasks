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
import java.util.Arrays;
import java.util.Scanner;

// Заваливает 12 тест 1,087  память 28 мб

public class acmp_0084  {
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
	
	
	int i_min = N-1;
	int i_max = 0;
	int j_min = M-1;
	int j_max = 0;
	
	for (int i = 0; i<N; i++) {
		for (int j = 0; j<M; j++) {
			if (Arr[i][j].equals("*") == true) {
				if (i<=i_min) i_min = i;
				if (i>=i_max) i_max = i;
				if (j<=j_min) j_min = j;
				if (j>=j_max) j_max = j;}
		}
	}
	System.out.println("i_min = " + i_min);
	System.out.println("i_max = " + i_max);
	System.out.println("j_min = " + j_min);
	System.out.println("j_max = " + j_max);
	
	if ((i_max != 0) || (i_min != 0) || (j_max != 0) || (j_min !=0)) {
		for (int i = i_min; i<=i_max; i++) 
			for (int j = j_min; j<=j_max; j++)
				Arr[i][j] = "*";}
	
	for (int i = 0; i<N; i++) System.out.println(Arrays.toString(Arr[i]));
		
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	for (int i = 0; i<N; i++) {
		for (int j = 0; j<M; j++) pw.print(Arr[i][j]);
		pw.print("\n");}
	pw.close();
}
}