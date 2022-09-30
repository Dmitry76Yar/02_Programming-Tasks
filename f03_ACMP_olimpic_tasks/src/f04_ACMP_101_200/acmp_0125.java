package f04_ACMP_101_200;
/* Цветной дождь	(Время: 1 сек. Память: 16 Мб Сложность: 26%)
В Банановой республике очень много холмов, соединенных мостами. На химическом заводе произошла авария, в результате чего испарилось
экспериментальное удобрение "зован". На следующий день выпал цветной дождь, причем он прошел только над холмами. В некоторых местах
падали красные капли, в некоторых - синие, а в остальных - зеленые, в результате чего холмы стали соответствующего цвета.
Президенту Банановой республики это понравилось, но ему захотелось покрасить мосты между вершинами холмов так, чтобы мосты были
покрашены в цвет холмов, которые они соединяют. К сожалению, если холмы разного цвета, то покрасить мост таким образом не удастся.
Посчитайте количество таких "плохих" мостов.
	Входные данные
В файле INPUT.TXT в первой строке записано N (0 < N ≤ 100) - число холмов. Далее идет матрица смежности, описывающая наличие мостов между
холмами (1-мост есть, 0-нет). Предпоследняя строка пустая, а в последней строке записано N чисел, обозначающих цвет холмов: 1 - красный;
2 - синий; 3 - зеленый.
	Выходные данные
В файл OUTPUT.TXT вывести количество "плохих" мостов.

Пример
№	INPUT.TXT			OUTPUT.TXT
1	7
	0 1 0 0 0 1 1
	1 0 1 0 0 0 0
	0 1 0 0 1 1 0
	0 0 0 0 0 0 0
	0 0 1 0 0 1 0
	1 0 1 0 1 0 0
	1 0 0 0 0 0 0
	
	1 1 1 1 1 3 3		4
	

*/

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0125 {
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	System.out.println(" N = " + N);
	sc.nextLine();
	
	int matriza_smegn[][] = new int[N][N];
	
	for (int i = 0; i<N; i++) {
		for (int j = 0; j<N; j++) {
			matriza_smegn[i][j] = sc.nextInt();
		}
		sc.nextLine();
	}
	for (int i = 0; i<N; i++)  System.out.println(Arrays.toString(matriza_smegn[i]));
	
	int color[] = new int[N];
	sc.nextLine();
	for (int i = 0; i<N; i++) color[i] = sc.nextInt();
	System.out.println(Arrays.toString(color));
	
	int sum = 0;
	for (int i = 0; i<N; i++) {
		for (int j = 0; j<N; j++) {
			int currentColor = color[i];
			if ((matriza_smegn[i][j] == 1) && (color[j] != color[i])) {
				sum++;
//				System.out.println("i = " + i + "    j = " + j);
			}
		}
	}
	System.out.println("sum = " + sum/2);
	
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	out.print(sum/2);
    out.flush();
    out.close();
	}
}
