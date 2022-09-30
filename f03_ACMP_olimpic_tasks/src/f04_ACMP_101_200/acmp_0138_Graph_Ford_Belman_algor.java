package f04_ACMP_101_200;

import java.io.*;
import java.util.*;

public class acmp_0138_Graph_Ford_Belman_algor	{
	
	public static class edge {
	        int startVert;
	        int finshVert;
	        public edge(int startVert, int finshVert) {
	            this.startVert = startVert;
	            this.finshVert = finshVert; }
	 
	        public String toString() {
	            return this.startVert + " " + this.finshVert;}
	 }
	 
	 public static class VertixT {
	        int name;				// Имя вершины (порядковый номер, например, А,В,С ... или 1,2,3...)
	        int dist;				// Значение миним.дистанции от стартовой вершины до этой вершины
	        String path;			// Минимальный маршрут от стартовой вершины до этой вершины
	 
	        public VertixT(int name, int dist, String path) {
	            this.name = name;
	            this.dist = dist;
	            this.path = path;}
	 
	  public String toString() {
	  	   return  "      "+ this.name + " \t\t" + this.dist + "  \t\t   " +  this.path + ""; 
	   }
	 }
	 		// Метод создает матрицу ребер, которые существуют в графе 
	 public static edge[] getEdges(int N_edges_wt_povtor, int[][] graph) {
		    edge[] rv = new edge[N_edges_wt_povtor];
		    int i = 0;
		    for (int u = 1; u < graph.length; u++) {
		    	for (int v = 1; v < graph[u].length; v++) {
		            rv[i] = new edge(u, v);
		            if (graph[u][v] != 101)  {
		            	i++;
//		            	System.out.println(" graph[" + u + "][" + v + "]  = "  + graph[u][v]);
		            }
		             if (i == N_edges_wt_povtor) break;
		         }
		    	if (i == N_edges_wt_povtor) break;
		    }
//		    for (int i1 = 0; i1 < rv.length; i1++) {
//		    	System.out.println("[" + rv[i1].startVert + "][ " + rv[i1].finshVert + "]") ;  }
		    return rv;
		}

		public static int[] bellmanford(int startVert, int N_vertix, int N_edges, int[][] graph, int N_edges_wt_povtor) {
			int result1[] = new int[N_vertix];
		    /* Map — это структура данных, которая содержит набор пар “ключ-значение”.
		    We use hashmap to store every vertex:  key - name of vertix, value - object VertixT  */
		    
			HashMap<Integer, VertixT> vertixMap = new HashMap<>();
		    
			/* Инициализируем все вершины кроме стартовой с бесконечным минимальным расстоянием dist и пустым минимальным путем path, 
		       т.к. путь до них пока не ясен
		       Стартовую вершину инициализируем с dist = 0 и path = номер/имя стартовой вершины   */
			for (int i = 1; i < graph.length; i++) {	
				if (i == startVert) vertixMap.put(i, new VertixT(i, 0, Integer.toString(i)));
				else vertixMap.put(i, new VertixT(i, 100000, ""));
			}

					// Внешний цикл с количеством иттераций = N_Vertix -1 
		    for (int var = 1; var <= N_vertix - 1; var++) {
		        	/* Внутренний цикл - это перебор всех ребер графа, их список возвращается из метода getEdges() 
		        	   Порядок ребер рандомный, чаще делают по алфавиту, как и здесь*/
//		    	System.out.println("Иттерация " + var);
		    	
		        for (edge e : getEdges(N_edges_wt_povtor, graph)) {
		            VertixT u = vertixMap.get(e.startVert);
		            VertixT v = vertixMap.get(e.finshVert);

//		            System.out.print("Ребро[" + u.name + "][" + v.name + "]=" + graph[u.name][v.name] + 
//		            		        ",  vert(" + u.name + ")= " + u.dist + ",  vert(" + v.name + ")= " + v.dist);
		            
		            if (v.dist > u.dist + graph[u.name][v.name]) {
		                v.dist = u.dist + graph[u.name][v.name];
		                v.path = u.path + "->" + Integer.toString(v.name);
//		                System.out.println("   v[" + v.name + "]>u[" + u.name + "]+ребро[" + u.name + "][" + v.name + "] " + 
//		                "  Теперь вершина " + v.name + " равна "  + v.dist + " и путь до нее  "  + v.path);
		            }
//		            else System.out.println("   v[" + v.name + "]<u[" + u.name + "]+ребро[" + u.name + "][" + v.name + "] " + 
//		            		"  Вершина " + v.name + " не меняется и равна "  + v.dist + " и путь до нее  "  + v.path);
		        }
//		        System.out.println();
		    }
		    
//		    for (int i : vertixMap.keySet())    System.out.println(vertixMap.get(i));
		    for (int i : vertixMap.keySet())    result1[i-1] = vertixMap.get(i).dist;
		    return result1;
		}
	 
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N_Vertix = sc.nextInt();
	int N_Edges = sc.nextInt();
//	System.out.println("N_Vertix = " + N_Vertix + "   , N_Edges = " + N_Edges);
	
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	if (N_Edges != 0) {
	    int startVertix = 1;
	    int[][] graph = new int[N_Vertix + 1][N_Vertix + 1];
	    
	    for (int i = 0; i<=N_Vertix; i++) {
	    	for (int j = 0; j<=N_Vertix; j++) {
	    		graph[i][j] = 101;
	    	}
	    }
	    int N_edges_wt_povtor = 0;
		for (int i = 0; i<N_Edges; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int weight = sc.nextInt();
			if (start == end) graph[start][end] = 101;
			else {
				if (graph[start][end] == 101) N_edges_wt_povtor++;
				if (graph[start][end]>weight) graph[start][end] = weight;}
		}
//		System.out.println("N_edges_wt_povtor = "  + N_edges_wt_povtor );
		
//		System.out.println("Граф на входе");
//	  for (int i = 1; i < graph.length; i++) {
//	 	   for (int j = 1; j < graph.length; j++)  	System.out.print(graph[i][j] + " \t");
//	 	   System.out.println();}
	
	    int result[] = new int[N_Vertix]; 
	    result = bellmanford(startVertix, N_Vertix, N_Edges, graph, N_edges_wt_povtor);
	    System.out.println(Arrays.toString(result));
	   
	    	// Проверка на достижимость вершин
		for (int i =0; i<result.length; i++) {
			if (result[i] >10100) result[i] = 30000;
			out.print(result[i] + " ");}
	}
	else {
		out.print(0 + " ");
		for (int i = 1; i<N_Vertix; i++) out.print(30000 + " ");
	}
	out.flush();
	out.close();
}
}
	