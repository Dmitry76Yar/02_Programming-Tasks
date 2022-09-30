package f04_ACMP_101_200;

/* 	Минимальный каркас		(Время: 1 сек. Память: 16 Мб Сложность: 53%)
От вас требуется определить вес минимального остовного дерева для неориентированного взвешенного связного графа.
	Входные данные
В первой строке входного файла INPUT.TXT находятся числа N и M (1 ≤ N ≤ 100; 1 ≤ M ≤ 6000), где N - количество вершин в графе, а M
 - количество рёбер. В каждой из последующих M строк записано по тройке чисел A, B, C, где A и B - номера вершин, соединённых ребром, а
C - вес ребра (натуральное число, не превышающее 30000).
	Выходные данные
В выходной файл OUTPUT.TXT выведите одно число - искомый вес.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1		3 3
		1 2 1
		2 3 2
		3 1 3		3				*/

import java.util.*;
import java.io.*;

class VertixL1 {
	boolean isVisited;
	int number;
	int name;
	public VertixL1(boolean isVisited, int number, int name) {
		this.isVisited = isVisited;
		this.number = number;
		this.name = name;
	}
}

public class acmp_0142_Graph_StvolTree	{
public static void main(String[] args) throws IOException {
	/* https://ru.wikipedia.org/wiki/%D0%9C%D0%B8%D0%BD%D0%B8%D0%BC%D0%B0%D0%BB%D1%8C%D0%BD%D0%BE%D0%B5_%D0%BE%D1%81%D1%82%D0%BE%D0%B2%D0%BD%D0%BE%D0%B5_%D0%B4%D0%B5%D1%80%D0%B5%D0%B2%D0%BE
	*/
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N_Vertix = sc.nextInt();
	int M_Edges = sc.nextInt();
	System.out.println("N_Vertix = " + N_Vertix );
	System.out.println("M_Edges = " + M_Edges);
	
//	  N_Vertix = 10; 
//    M_Edges = 39;
    
    ArrayList<VertixL1> listOfVertix = new ArrayList<VertixL1>();
	for (int i = 0; i<N_Vertix; i++) 
		listOfVertix.add(new VertixL1(false, (int)Double.POSITIVE_INFINITY, i+1));
	
	int resultDistance = 0;
	if (N_Vertix ==	 1) resultDistance = 0;
	else {
			// Формирование матрицы с защитой от петель
	    int[][] graph = new int[N_Vertix + 1][N_Vertix + 1];
	    for (int i = 0; i<M_Edges; i++) {
	    		int x = sc.nextInt();
	    		int y = sc.nextInt();
	    		int currentEdge = sc.nextInt();
	    		if (graph[x][y]==0) { graph[x][y] = currentEdge;	graph[y][x] = currentEdge;}
	    		if ((graph[x][y]!=0) && (graph[x][y] > currentEdge)) {graph[x][y] = currentEdge; graph[y][x] = currentEdge;}
	    		if (x==y) {graph[x][y] = 0; graph[y][x] = currentEdge;}
	    }    
	    
	//    graph[1][2] = 6;		graph[1][3] = 3;		graph[1][4] = 9;
	//    graph[2][1] = 6;		graph[2][3] = 4;		graph[2][5] = 2;		graph[2][7] = 9;		
	//    graph[3][1] = 3;		graph[3][2] = 4;		graph[3][4] = 9;		graph[3][5] = 2;
	//    graph[4][1] = 9;		graph[4][3] = 9;		graph[4][6] = 8;		graph[4][10] = 18;
	//    graph[5][2] = 2;		graph[5][6] = 8;		graph[5][3] = 2;
	//    graph[6][5] = 8;		graph[6][7] = 7;		graph[6][8] = 9;		graph[6][10] = 10;		graph[6][4] = 8;
	//    graph[7][2] = 9;		graph[7][9] = 4;		graph[7][8] = 5;		graph[7][6] = 7;		graph[7][5] = 9;
	//    graph[8][7] = 5;		graph[8][9] = 1;		graph[8][10] = 3;		graph[8][6] = 9;
	//    graph[9][7] = 4;		graph[9][8] = 1;		graph[9][10] = 4;
	//    graph[10][9] = 4;		graph[10][8] = 3;		graph[10][6] = 10;		graph[10][4] = 18;
	    for (int i = 1; i < graph.length; i++) System.out.println(Arrays.toString(graph[i]));
	    
	    int N_visitedVertix = 0;
	    ArrayList<VertixL1> queue = new ArrayList<VertixL1>();
	    queue.add(listOfVertix.get(0));
	    listOfVertix.get(0).isVisited = true;
	    N_visitedVertix++;
	    
	    while(N_visitedVertix!=N_Vertix) {	
	//    for (int b = 0; b < 9; b++) {
	    	System.out.println();
		    System.out.print("In queue following vertixes : ");
		    for (int i = 0; i < queue.size(); i++) { 
		    	System.out.print(queue.get(i).name);
		    	System.out.print("  -  ");
		    }
		    System.out.println();
	    		// Search the shortest way from this vertix
	    	int min = Integer.MAX_VALUE;
	    	int nextVertixNumber = 0;
	    	int countUnvisitedVertix = 0;
	    	int c = 0;
	    	for (int i = 0; i<queue.size(); i++)  {
	    		VertixL1 currentVertix = queue.get(i);
	        	System.out.println("Current analized vertix = " + currentVertix.name);
		    	for (int j = 1; j<N_Vertix+1; j++)  {
		    		int a = currentVertix.name; 
		    		if ((min>graph[a][j]) && (a!=j) && (graph[a][j]!=0) && (listOfVertix.get(j-1).isVisited == false))	{
		    			min = graph[a][j];
		    			nextVertixNumber = j;
		    			countUnvisitedVertix++;
		    			c = a;}
		    	}
	    	}
	    	if (c==0) break;
	    	if (countUnvisitedVertix == 0) queue.remove(queue.size()-1);
	    	System.out.println("Found the shortest way = " + min + "  from Vertix # " + c + " to Vertix # " + nextVertixNumber);
	    	resultDistance = resultDistance + min;
	    	listOfVertix.get(nextVertixNumber-1).isVisited = true;
	    	N_visitedVertix++;
	    	queue.add(listOfVertix.get(nextVertixNumber-1));
	    } // End of while
	} // End of else 
	   System.out.println("resultDistance = " + resultDistance);
    	
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	out.print(resultDistance);
	out.flush();
	out.close();
}
}

