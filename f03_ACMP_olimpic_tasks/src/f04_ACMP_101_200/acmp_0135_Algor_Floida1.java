package f04_ACMP_101_200;
/* Алгоритм Флойда		(Время: 1 сек. Память: 16 Мб Сложность: 36%)
Полный ориентированный взвешенный граф задан матрицей смежности. Постройте матрицу кратчайших путей между его вершинами. Гарантируется, 
что в графе нет циклов отрицательного веса.
	Входные данные
В первой строке входного файла INPUT.TXT записано единственное число N (1 ≤ N ≤ 100) - количество вершин графа. В следующих N строках по
N чисел - матрица смежности графа (j-ое число в i-ой строке соответствует весу ребра из вершины i в вершину j). Все числа по модулю не
превышают 100. На главной диагонали матрицы - всегда нули.
	Выходные данные
В выходной файл OUTPUT.TXT выведите N строк по N чисел - матрицу кратчайших расстояний между парами вершин. j-ое число в i-ой строке
должно быть равно весу кратчайшего пути из вершины i в вершину j.
	Пример
№	INPUT.TXT			OUTPUT.TXT
1	4
	0 5 9 100
	100 0 2 8
	100 100 0 7
	4 100 100 0			0 5 7 13
						12 0 2 8
						11 16 0 7
						4 9 11 0		*/

import java.io.*;
import java.util.Scanner;

public class acmp_0135_Algor_Floida1	{
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	int m[][] = new int[N][N];
	for (int i = 0; i<N; i++) 
		for (int j = 0; j<N; j++) 	m[i][j] = sc.nextInt();
	
	for (int k =0; k<N; k++) 
		for (int i =0; i<N; i++) 
			for (int j =0; j<N; j++) 
				if ((i != j) && (m[i][j] > (m[i][k] + m[k][j])))  m[i][j] = (m[i][k] + m[k][j]);
	
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	for (int i =0; i<N; i++) {
		for (int j =0; j<N; j++) out.print(m[i][j] + " ");
		out.println();
	}
    out.flush();
    out.close();
	}
}
