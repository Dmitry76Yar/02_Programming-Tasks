package f04_ACMP_101_200;
/*	Светофорчики 	(Время: 1 сек. Память: 16 Мб Сложность: 25%)
В подземелье M тоннелей и N перекрестков, каждый тоннель соединяет какие-то два перекрестка. Мышиный король решил поставить по светофору
в каждом тоннеле перед каждым перекрестком. Напишите программу, которая посчитает, сколько светофоров должно быть установлено на каждом
из перекрестков. Перекрестки пронумерованы числами от 1 до N.
	Входные данные
Во входном файле INPUT.TXT записано два числа N и M (0 < N ≤ 100, 0 ≤ M ≤ N*(N-1)/2). В следующих M строках записаны по два числа
i и j (1 ≤ i,j ≤ N), которые означают, что перекрестки i и j соединены тоннелем. Можно считать, что любые два перекрестка соединены
не более, чем одним тоннелем. Нет тоннелей от перекрестка i до него самого.
	Выходные данные
В выходной файл OUTPUT.TXT вывести N чисел: k-ое число означает количество светофоров на k-ом перекрестке.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1	7 10
	5 1
	3 2
	7 1
	5 2
	7 4
	6 5
	6 4
	7 5
	2 1
	5 3			3 3 2 2 5 2 3*/

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0124__matriza_smegn {
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int M = sc.nextInt();
	int N = sc.nextInt();
	System.out.println(" N = " + N + "    M = " + M);
	sc.nextLine();
	
	int matriza_smegn[][] = new int[M][M];
	
	for (int i = 0; i<N; i++) {
		String ar[] = sc.nextLine().split(" ");
		int a = Integer.parseInt(ar[0])-1;
		int b = Integer.parseInt(ar[1])-1;
		matriza_smegn[a][b] = 1;
		matriza_smegn[b][a] = 1;
	}
	for (int i = 0; i<M; i++)  System.out.println(Arrays.toString(matriza_smegn[i]));
		
	StringBuilder sb = new StringBuilder();
	for (int i = 0; i<M; i++) {
		int sum = 0;
		for (int j = 0; j<M; j++) {
			if (matriza_smegn[i][j] == 1) sum++;
		}
		sb.append(sum + " ");
	}
	System.out.println(sb.toString());

	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	out.print(sb.toString());
    out.flush();
    out.close();
	}
}
