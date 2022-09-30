package f04_ACMP_101_200;

/* 	Друзья	(Время: 1 сек. Память: 16 Мб Сложность: 41%)
В клубе N человек. Многие из них - друзья. Так же известно, что друзья друзей так же являются друзьями. Требуется выяснить, сколько
всего друзей у конкретного человека в клубе.
	Входные данные
В первой строке входного файла INPUT.TXT заданы два числа: N и S (1 ≤ N ≤ 100; 1 ≤ S ≤ N), где N - количество человек в клубе, а S – 
номер конкретного человека. В следующих N строках записано по N чисел - матрица смежности, состоящая из единиц и нулей. Причем единица,
стоящая в i-й строке и j-м столбце гарантирует, что люди с номерами i и j – друзья, а 0 – выражает неопределенность.
	Выходные данные
В выходной файл OUTPUT.TXT выведите количество гарантированных друзей у человека с номером S, помня о транзитивности дружбы.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1	3 1
	0 1 0
	1 0 1
	0 1 0		2		*/

import java.util.*;
import java.io.*;

class VertixL2 {
	boolean isVisited;
	int name;
	public VertixL2(boolean isVisited, int name) {
		this.isVisited = isVisited;
		this.name = name;
	}
}
public class acmp_0150_Graph	{
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	int S = sc.nextInt();
	System.out.println("N = " + N + "  S = " + S);
	
	int result = 0;
	if (N == 1) result = 0; 
	else {
		ArrayList<VertixL2> listOfVertix = new ArrayList<VertixL2>();
		for (int i = 0; i<N+1; i++) listOfVertix.add(new VertixL2(false, i));
		
	    int[][] graph = new int[N + 1][N + 1];
	    for (int i = 1; i<=N; i++) {
	    	for (int j = 1; j<=N; j++) 	graph[i][j] = sc.nextInt();
	    }
	    for (int i = 0; i<=N; i++) System.out.println(Arrays.toString(graph[i]));
	
	    ArrayList<VertixL2> queue = new ArrayList<VertixL2>();
	    queue.add(listOfVertix.get(S));
	    
	    while (queue.size() !=0) {
	    	System.out.print("In Queue are "); for (int i = 0; i<queue.size(); i++) System.out.print(queue.get(i).name + " -> ");
	    	
	    	VertixL2 vert = queue.get(0);
	    	for (int i = 1; i<=N; i++) {
	    		if ((listOfVertix.get(i).isVisited == false) && (graph[vert.name][i] == 1)) {
	    			queue.add(listOfVertix.get(i));
	    			listOfVertix.get(i).isVisited = true;
	    			result++;
	    		}
	    	}
	    	vert.isVisited = true;
	    	queue.remove(0);
	    }
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




