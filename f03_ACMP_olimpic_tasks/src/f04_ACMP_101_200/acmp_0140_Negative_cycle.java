package f04_ACMP_101_200;
/*Цикл отрицательного веса		(Время: 1 сек. Память: 16 Мб Сложность: 46%)
Дан взвешенный граф. Определить, есть ли в нем цикл отрицательного веса.
	Входные данные
Во входном файле INPUT.TXT в первой строке записано число N (1 ≤ N ≤ 100) - количество вершин графа. В следующих N строках находится
по N чисел - матрица смежности графа. Веса ребер не превышают по модулю 10000. Если ребра нет, соответствующее значение равно 100000.
	Выходные данные
В выходной файл OUTPUT.TXT выведите "YES", если цикл существует, или "NO" в противном случае.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1	2
	0 -1
	-1 0			YES

*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0140_Negative_cycle	{
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	short N_Vertix = sc.nextShort();
	System.out.println("N_Vertix = " + N_Vertix );
	
    int[][] graph = new int[N_Vertix + 1][N_Vertix + 1];
    
    String result = "NO";
    if (N_Vertix == 1) {
    	if (sc.nextInt() <0) result = "YES";
    }
    else {   
	    for (int i = 0; i<=N_Vertix; i++) {
	    	for (int j = 0; j<=N_Vertix; j++) {
	    		graph[i][j] = 100000; 	}
	    }
	    
	    ArrayList<Integer[]> setOfEdges = new ArrayList<Integer[]>();
	    for (int i = 1; i<=N_Vertix; i++) {
	    	for (int j = 1; j<=N_Vertix; j++) {
	    		graph[i][j] = sc.nextInt();	
	    		if (graph[i][j] != 100000) setOfEdges.add(new Integer[] {i,j});
	    		}
	    }
	    
		// Добавляем нулевую вершину, связанную со всеми вершинами
		// Это нужно, чтобы найти любой отрицательный цикл (а не только достижтиый из начальной вершины)
		// Делаем нулевую вершину стартовой  и количество циклов увеличиваем на 1 (вместо N_Vertix -1 делаем N_Vertix)
	    
	    for (int i = 1; i<=N_Vertix; i++) {
	    	graph[0][i] = 0;
	    	setOfEdges.add(new Integer[] {0,i});
	    }
	    
	    System.out.println("Граф на входе");
		for (int i = 0; i < graph.length; i++) {
		   for (int j = 0; j < graph.length; j++)  	{
			   System.out.print(graph[i][j] + " \t");}
		   System.out.println();}
		
		System.out.println("Набор ребер");
		for (int i = 0; i < setOfEdges.size(); i++) System.out.println(Arrays.toString(setOfEdges.get(i)));
		System.out.println();
		
	    double outcome[] = new double[N_Vertix+1];
		for (int k = 0; k < N_Vertix+1; k++) outcome[k] = Double.POSITIVE_INFINITY;
		outcome[0] = 0;
	    
		for (int var = 0; var <= N_Vertix - 1; var++) {
			for (int y=0; y<setOfEdges.size(); y++) {
				int start = setOfEdges.get(y)[0];
				int finish = setOfEdges.get(y)[1];
				int weight_temp = graph[start][finish];
				if ((weight_temp != 100000) && (outcome[finish] > outcome[start] + weight_temp)) {
				outcome[finish] = outcome[start] + weight_temp;
				}
			}
		}
		System.out.println(Arrays.toString(outcome));
		
		for (int y=0; y<setOfEdges.size(); y++) {
			int start = setOfEdges.get(y)[0];
			int finish = setOfEdges.get(y)[1];
			int weight_temp = graph[start][finish];
			if ((weight_temp != 100000) && (outcome[finish] > outcome[start] + weight_temp)) {
				outcome[finish] = outcome[start] + weight_temp;
				System.out.println("Negative cycle was found");
				result = "YES"; 
				break;}
			}
		System.out.println(Arrays.toString(outcome));
    }
		if  (result.equals("NO")) System.out.println("NO negative cycles");
		else System.out.println("Negative cycles");
	
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	out.print(result);
	out.flush();
	out.close();
}
}
