	package f05_ACMP_150_199;
/* Скачки	(Время: 1 сек. Память: 16 Мб Сложность: 32%)
Иван Иванович любит ходить на скачки, надеясь на них заработать кругленькую сумму. Ему приглянулась лошадь с номером K, и он решил
проверить, сможет ли она выиграть у всех остальных лошадей. Иван Иванович раздобыл информацию, в которой для некоторых пар лошадей
сообщается, какая из этих лошадей быстрее. Также он узнал, что у всех лошадей разные скорости.
	Требуется написать программу, которая поможет Ивану Ивановичу точно определить может ли выиграть выбранная им лошадь.
	Входные данные
Входной файл INPUT.TXT содержит в первой строке два целых числа N (1 ≤ N ≤ 100) и K (1 ≤ K ≤ N), где N – количество лошадей,
принимающих участие в скачках, K – номер лошади, на которую хочет сделать ставку Иван Иванович. Следующие строки содержат по два
числа X и Y (1 ≤ X, Y ≤ N), обозначающие, что лошадь с номером X быстрее лошади с номером Y. Пары X и Y не повторяются. Набор
данных завершается строкой, содержащей единственный ноль. Эту строку обрабатывать не надо.
	Гарантируется, что информация, раздобытая Иваном Ивановичем, корректна.
	Выходные данные
Выходной файл OUTPUT.TXT должен содержать слово «Yes», если Иван Иванович уверен в своем выигрыше и «No» в противном случае.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	3 1
	1 2
	1 3
	0			Yes
2	3 2
	2 3
	0			No
3	4 2
	3 1
	2 3
	0	No*/

import java.util.*;
import java.io.*;

class Vertixr {
	boolean visited; 
	int label;
	Vertixr(boolean visited, int label) {
		this.visited = visited;
		this.label = label;
	}
	@Override
		public String toString() {
			return "Vertix " + label + "  = " + visited;  
		}
}

class Graph {
	ArrayList<Vertixr> vertList;
	int N;
	int vertVisited = 0;
	Graph(int N) {
		this.N = N;
		vertList = new ArrayList<Vertixr>();
		for (int i =0; i<N; i++) vertList.add(new Vertixr(false, i));
	}
}

public class acmp_0185{
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
    int K = sc.nextInt();
    int matrixSmegn[][] = new int[N][N];
    
    String res = "";
    if (N==1) res = "Yes";
    else {
	    while (true) {
	    	int a = sc.nextInt();
	    	if (a==0) break;
	    	int b =sc.nextInt();
	    	matrixSmegn[a-1][b-1] = 1;
	    }
//	    for (int i = 0; i<N; i++) System.out.println(Arrays.toString(matrixSmegn[i]));
	    
	    boolean isFasterThanK = false;
	    for (int i = 0; i<N; i++) {
	//    	System.out.println(matrixSmegn[i][K-1]);
	    	if (matrixSmegn[i][K-1] == 1) isFasterThanK = true;}
	    System.out.println("isFasterThanK = " + isFasterThanK);
	    
	    if (isFasterThanK == true) res = "No";
	    else {
		    Graph graph = new Graph(N);
//		    for (int i = 0; i<N; i++) System.out.println(graph.vertList.get(i));
		        
		    ArrayList<Vertixr> queue = new ArrayList<Vertixr>();
		    queue.add(graph.vertList.get(K-1));
		    graph.vertList.get(K-1).visited = true;
		    
		    while (!queue.isEmpty()) {
		    	Vertixr curVert = queue.get(0);
		    	graph.vertVisited++;
		    	System.out.println("\nИзъята вершина " + (curVert.label+1));
		    	queue.remove(0);
		    	for (int i = 0; i<N; i++ ) {
		    		System.out.println("Анализ вершины " + (graph.vertList.get(i).label+1));
		    		if ((graph.vertList.get(i).visited == false ) && ( matrixSmegn[curVert.label][graph.vertList.get(i).label] == 1)) {
		    			queue.add(graph.vertList.get(i));
		    			graph.vertList.get(i).visited = true;
		    			System.out.println("Добавлена вершина " + (graph.vertList.get(i).label+1));
		    		}
		    	}
		    }
		    System.out.println("graph.vertVisited = " + graph.vertVisited);
		    if (graph.vertVisited == N) res = "Yes";
		    else res = "No";
	    }
    }
    System.out.println("res = " + res);
	    
    PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
    o.print(res);
    o.flush();
    o.close();
    }
}