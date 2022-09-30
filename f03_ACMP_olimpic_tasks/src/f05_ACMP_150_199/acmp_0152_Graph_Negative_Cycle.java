package f05_ACMP_150_199;

/* 	Банкет	(Время: 1 сек. Память: 16 Мб Сложность: 44%)
На банкет были приглашены N Очень Важных Персон (ОВП). Были поставлены 2 стола. Столы достаточно большие, чтобы все посетители банкета
могли сесть за любой из них. Проблема заключается в том, что некоторые ОВП не ладят друг с другом и не могут сидеть за одним столом.
Вас попросили определить, возможно ли всех ОВП рассадить за двумя столами.
	Входные данные
В первой строке входного файла INPUT.TXT дано два целых числа: N и M (0 ≤ N,M ≤ 100), где N - количество ОВП, а M - количество пар ОВП,
которые не могут сидеть за одним столом. В следующих M строках записано по 2 числа - пары ОВП, которые не могут сидеть за одним столом.
	Выходные данные
Если способ рассадить ОВП существует, то в выходной файл OUTPUT.TXT выведите YES и NO в противном случае.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1	3 2
	1 2
	1 3			YES		*/

import java.util.*;
import java.io.*;

class V {
	int label;
	int name;
	boolean isVisited;
	public V(int label, int name, boolean isVisited) {
		this.label = label;
		this.name = name;
		this.isVisited = isVisited;
	}
}
public class acmp_0152_Graph_Negative_Cycle	{
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N_Vertix = sc.nextInt();
	int M_Edges = sc.nextInt();
	System.out.println("N = " + N_Vertix + "  M = " + M_Edges);
	
	 int[][] graph = new int[N_Vertix + 1][N_Vertix + 1];
	    
	String result = "Yes";
		    
		// Набор ребер по алгоритму вроде Форда-Белмана (отработка всех ребер)
	ArrayList<Integer[]> setOfEdges = new ArrayList<Integer[]>();
	for (int i = 0; i<M_Edges; i++) {
		int a = sc.nextInt();
		int b = sc.nextInt();
		if (a!=b) {
				/* Матрица будет иметь нули, если вершины не связаны (по умолчанию)
				 и	вес ребра = -1, если вершины связаны, чтобы при наличии бесконечного цикла 
				 растояние до вершины можно было сократить бесконечно	 */ 
			graph[a][b] = -1;
			graph[b][a] = -1;
			setOfEdges.add(new Integer[] {a,b});
		}
	}
	// Добавляем нулевую вершину, связанную со всеми вершинами
	// Это нужно, чтобы найти любой отрицательный цикл (а не только достижтиый из начальной вершины)
	// Делаем нулевую вершину стартовой  и количество циклов увеличиваем на 1 (вместо N_Vertix -1 делаем N_Vertix)
		    
		// В графе задаем -1 для нулевой строки, чтобы обознчить связь 0-вой вершины со всеми остальными (-1, чтобы увидеть отр.цикл)
		// и вносим в набор ребер все ребра от нулевой до всех остальных вершин
	for (int i = 1; i<=N_Vertix; i++) {
	   	graph[0][i] = -1;
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
	
		// Алгоритм находит кратчайшие растояния от выбранной вершины (в нашем случае от нулевой до всех вершин)
		// outcome - каждый элемент массива- это крайтчайшее растояние до вершины с этим индексом в массиве
		// Например, [0, 2, 3]  одначает, что от 0-вой до 1-ой вершины кратчайшее растояние = 2
    double outcome[] = new double[N_Vertix+1];
	for (int k = 0; k < N_Vertix+1; k++) outcome[k] = Double.POSITIVE_INFINITY;
	outcome[0] = 0;
    	// Собственно сам алгоритм
	for (int var = 0; var <= N_Vertix - 1; var++) {
		for (int y=0; y<setOfEdges.size(); y++) {
			int start = setOfEdges.get(y)[0];
			int finish = setOfEdges.get(y)[1];
			int weight_temp = graph[start][finish];
			if ((weight_temp != 0) && (outcome[finish] > outcome[start] + weight_temp)) {
			outcome[finish] = outcome[start] + weight_temp;
			}
		}
	}
	System.out.println(Arrays.toString(outcome));
	
		// Проверка еще раз - если кратчайшие растояния в outcome[] изменятся, значит есть отрицательный текст
	for (int y=0; y<setOfEdges.size(); y++) {
		System.out.println("fdfb");
		int start = setOfEdges.get(y)[0];
		int finish = setOfEdges.get(y)[1];
		int weight_temp = graph[start][finish];
		if ((weight_temp != 0) && (outcome[finish] > outcome[start] + weight_temp)) {
			outcome[finish] = outcome[start] + weight_temp;
			System.out.println("Negative cycle was found");
			result = "No"; 
			break;}
	}
	System.out.println(Arrays.toString(outcome));

	if  (result.equals("Yes")) System.out.println("NO negative cycles");
	else System.out.println("Negative cycles");

					
	System.out.println("	RESULT = "    + result);
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	out.print(result);
	out.flush();
	out.close();
}
}





