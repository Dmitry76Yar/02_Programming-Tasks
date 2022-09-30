package f04_ACMP_101_200;

/* 	Дерево	(Время: 1 сек. Память: 16 Мб Сложность: 42%)
Неориентированный граф без петель и кратных ребер задан матрицей смежности. Требуется определить, является ли этот граф деревом.
	Входные данные
Во входном файле INPUT.TXT записано сначала число N - количество вершин графа (от 1 до 100). Далее записана матрица смежности размером
N×N, в которой 1 обозначает наличие ребра, 0 - его отсутствие. Матрица симметрична относительно главной диагонали.
	Выходные данные
В выходной файл OUTPUT.TXT выведите сообщение YES, если граф является деревом, и NO в противном случае.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1	3
0 1 0
1 0 1
0 1 0			YES			*/

import java.util.*;
import java.io.*;

public class acmp_0141_2_solution	{
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	short N_Vertix = sc.nextShort();
	System.out.println("N_Vertix = " + N_Vertix );
	String result = "YES";
	
	/* Граф является деревом, если граф - связный и в графе отсутствуют циклы. 
	 Идея такая:
		 1) Проверяем граф на связность ДФС'ом и находим кол-во ребер.
		 2) Если граф связный и кол-во ребер равно n - 1, то выводим YES, иначе NO
		 */
	
	ArrayList<Integer[]> setOfEdges = new ArrayList<Integer[]>();
    int[][] graph = new int[N_Vertix + 1][N_Vertix + 1];
    
    for (int i = 1; i<=N_Vertix; i++) 
    	for (int j = 1; j<=N_Vertix; j++) {
    		graph[i][j] = sc.nextInt();
    		if (graph[i][j] != 0) setOfEdges.add(new Integer[] {i,j});
    	}
    
    if (setOfEdges.size()/2 == N_Vertix -1) {
    	System.out.println("Граф не имеет циклов");
    	
	    System.out.println("Граф на входе");
		for (int i = 1; i < graph.length; i++) {
		   for (int j = 1; j < graph.length; j++)  	{
			   System.out.print(graph[i][j] + " \t");}
		   System.out.println();}
		
		double outcome[] = new double[N_Vertix+1];
		for (int k = 1; k < N_Vertix+1; k++) outcome[k] = Double.NEGATIVE_INFINITY;
		outcome[1] = 0;
		
		for (int var = 1; var <= N_Vertix - 1; var++) {
			for (int y=0; y<setOfEdges.size(); y++) {
				int start = setOfEdges.get(y)[0];
				int finish = setOfEdges.get(y)[1];
				int weight_temp = graph[start][finish];
				if ((outcome[start] != Double.NEGATIVE_INFINITY) && (outcome[finish] < outcome[start] + weight_temp)) {
						outcome[finish] = outcome[start] + weight_temp;
				}
			}
		}
		for (int k = 1; k < N_Vertix+1; k++) {
			if (outcome[k] == Double.NEGATIVE_INFINITY) {
				result = "NO";
				System.out.println("Не все вершины найдены");
				break;
			}
		}
    }
    else {
    	System.out.println("Граф имеет циклы или является не связанным (есть не связанные вершины");
    	result = "NO";
    }
	
	System.out.println("	RESULT = "    + result);
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	out.print(result);
	out.flush();
	out.close();
}
}


/*
Не все вершины найдены
7
0 1 1 0 0 1 0
1 0 0 0 0 0 0
1 0 0 0 1 0 0
0 0 0 0 0 0 1
0 0 1 0 0 0 0
1 0 0 0 0 0 0
0 0 0 1 0 0 0

Вск вершины найдены
7
0 1 1 0 0 1 0
1 0 0 1 0 0 0
1 0 0 0 1 0 0
0 1 0 0 0 0 1
0 0 1 0 0 0 0
1 0 0 0 0 0 0
0 0 0 1 0 0 0

*/




