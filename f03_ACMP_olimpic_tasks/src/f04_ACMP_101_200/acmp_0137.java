package f04_ACMP_101_200;
/* Существование пути	(Время: 1 сек. Память: 16 Мб Сложность: 65%)
Дан ориентированный взвешенный граф. По его матрице смежности нужно для каждой пары вершин определить: существует кратчайший путь между
ними или нет.
	Кратчайший путь может не существовать по двум причинам: либо нет ни одного пути, либо есть путь сколь угодно маленького веса.
	Входные данные
В первой строке входного файла INPUT.TXT записано единственное число N (1 ≤ N ≤ 100) - количество вершин графа. В следующих N строках
по N целых чисел - матрица смежности графа (j-ое число в i-ой строке соответствует весу ребра из вершины i в вершину j), в которой число
0 обозначает отсутствие ребра, а любое другое число - наличие ребра соответствующего веса. Все числа по модулю не превышают 100.
	Выходные данные
В выходной файл OUTPUT.TXT выведите N строк по N чисел: j-ое число в i-ой строке должно быть равно 0, если путь из i в j не существует,
1 - если существует кратчайший путь, и 2 - если существует путь сколь угодно маленького веса.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1	5
0 1 2 0 0
1 0 3 0 0
2 3 0 0 0
0 0 0 0 -1
0 0 0 -1 0		1 1 1 0 0
				1 1 1 0 0
				1 1 1 0 0
				0 0 0 2 2
				0 0 0 2 2*/

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0137	{
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	double m[][] = new double[N][N];
	for (int i = 0; i<N; i++) 
		for (int j = 0; j<N; j++) 	{
			int temp = sc.nextInt();
				if (temp == 0) m[i][j] = 100000001;
				else m[i][j] = temp;
			if (i==j) m[i][j] = 0;
		}
	for (int i =0; i<N; i++) System.out.println(Arrays.toString(m[i]));
	System.out.println();
	
	for (int k =0; k<N; k++) {
		for (int i =0; i<N; i++) { 
			for (int j =0; j<N; j++) {
				if ((m[i][j] > (m[i][k] + m[k][j]))) { 
					m[i][j] = (m[i][k] + m[k][j]);
				}
			}
		}
	System.out.println("k = " + k);
	for (int i =0; i<N; i++) System.out.println(Arrays.toString(m[i]));
	}
	for (int i =0; i<N; i++) System.out.println(Arrays.toString(m[i]));
	System.out.println();
	
	for (int i =0; i<N; i++) { 
		for (int j =0; j<N; j++) {
			if (m[i][j] > 10000) m[i][j] = 10001;
		}
	}
	for (int i =0; i<N; i++) System.out.println(Arrays.toString(m[i]));
	System.out.println();
	
	for (int k =0; k<N; k++) {
		for (int i =0; i<N; i++) { 
			for (int j =0; j<N; j++) {
				if ((m[i][k] != 10001) && (m[k][j] !=10001) && (m[i][j] > (m[i][k] + m[k][j]))) { 
					m[i][j] = Double.NEGATIVE_INFINITY;
				}
			}
		}
	}
		for (int i =0; i<N; i++) System.out.println(Arrays.toString(m[i]));
		System.out.println();	
		
		for (int i =0; i<N; i++) { 
			for (int j =0; j<N; j++) {
				if (m[i][j] == 10001) m[i][j] = 0;
				else if (m[i][j] == Double.NEGATIVE_INFINITY) m[i][j] = 2;
				else m[i][j] = 1;
			}
		}
		for (int i =0; i<N; i++) System.out.println(Arrays.toString(m[i]));
		System.out.println();

	
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	for (int i =0; i<N; i++) { 
		for (int j =0; j<N; j++) {
			out.print((int)m[i][j] + " ");
		}
		out.println();
	}
	
    out.flush();
    out.close();
	}
}
