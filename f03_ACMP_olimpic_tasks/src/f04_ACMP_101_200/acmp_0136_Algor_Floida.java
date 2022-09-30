package f04_ACMP_101_200;
/* Алгоритм Флойда - 2		(Время: 1 сек. Память: 16 Мб Сложность: 39%)
Дан ориентированный взвешенный граф. Вам необходимо найти пару вершин, кратчайшее расстояние от одной из которых до другой максимально
среди всех пар вершин.
	Входные данные
В первой строке входного файла INPUT.TXT записано единственное число N (1 ≤ N ≤ 100) - количество вершин графа. В следующих N строках по
N чисел - матрица смежности графа, где -1 означает отсутствие ребра между вершинами, а любое неотрицательное число - присутствие ребра
данного веса. Элементы матрицы - целые числа от -1 до 100. На главной диагонали матрицы - всегда нули. Гарантируется, что в графе есть
хотя бы одно ребро.
	Выходные данные
В выходной файл OUTPUT.TXT требуется вывести искомое максимальное кратчайшее расстояние.

Пример
№	INPUT.TXT		OUTPUT.TXT
1	4
	0 5 9 -1
	-1 0 2 8
	-1 -1 0 7
	4 -1 -1 0			16*/

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0136_Algor_Floida	{
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	int m[][] = new int[N][N];
	for (int i = 0; i<N; i++) 
		for (int j = 0; j<N; j++) 	{
			int temp = sc.nextInt();
			if (temp == -1) m[i][j] = 100001;
			else m[i][j] = temp;
		}
//	for (int i =0; i<N; i++) System.out.println(Arrays.toString(m[i]));
//	System.out.println();
	
	int max = 0;	
	for (int k =0; k<N; k++) {
		for (int i =0; i<N; i++) { 
			for (int j =0; j<N; j++) {
				if ((i != j) && (m[i][j] > (m[i][k] + m[k][j])))  m[i][j] = (m[i][k] + m[k][j]);
//				System.out.println(" k = " + k + " , i = " + i + " , j = " + j + " , m[i][j] = " + m[i][j] + " , m[i][k] = " + m[i][k] +  " m[k][j] = " + m[k][j]);
				if ((k==N-1) && (m[i][j] >max) && (m[i][j] != 100001)) max = m[i][j];  
			}
		}
//	System.out.println("k = " + k);
//	for (int i =0; i<N; i++) System.out.println(Arrays.toString(m[i]));
//	System.out.println();
	}
	
//	for (int i =0; i<N; i++) System.out.println(Arrays.toString(m[i]));
	System.out.println("max = " + max);
	
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	out.print(max);
    out.flush();
    out.close();
	}
}
