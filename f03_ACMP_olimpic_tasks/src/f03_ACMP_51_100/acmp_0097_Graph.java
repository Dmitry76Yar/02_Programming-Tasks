package f03_ACMP_51_100;
	/*		Заповедники		(Время: 1 сек. Память: 16 Мб Сложность: 50%)
В райской долине расположены N заповедников, имеющих форму прямоугольников. Однажды на собрании директоров было принято решение об увеличении
площадей заповедников. Для этого директор каждого заповедника выбрал Ri - количество метров, на которое он хочет увеличить зону своего 
заповедника, смотрите рисунок. Однако после подписания соглашения выяснилось, что некоторые заповедники имеют общие земли. Такие заповедники 
было решено объединить в один, если объединенный заповедник пересекался с еще каким-нибудь заповедником их опять объединяли и так до тех пор 
пока не остались заповедник(и) не имеющие общих земель.
	Ваша задача посчитать, сколько заповедников стало в долине после объединения.
	Входные данные
Первая строка входного файла INPUT.TXT содержит число N (1 ≤ N ≤ 100) – количество заповедников. Далее идет N строк содержащих по пять целых
чисел x1, y1, x2, y2, R. (x1, y1) и (x2, y2) – координаты противоположных вершин заповедника в метрах (-104 ≤ x1, y1, x2, y2 ≤ 104 ). Стороны
заповедников параллельны осям координат. Заповедники, имеющие общую границу, считаются пересекающимися. R (0 ≤ R ≤ 104) – расстояние на
которое отодвигается граница заповедника.
	Выходные данные
В выходной файл OUTPUT.TXT выведите одно натуральное число – количество оставшихся заповедников после объединения.
	Пример
№	INPUT.TXT			OUTPUT.TXT
1	3
	3 1 6 4 1
	1 -2 2 -3 1
	-2 -2 -1 -3 2			2
*/	

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

	class MyQueue {
		private int head;			private int tail;
		private int size;			private int [] array;		private int count;		
		public MyQueue(int size) {
			this.size = size;		array  = new int [size];
			head = 0;				tail = -1;			count = 0;	}
		public void insert (int v) {			
			if (tail == size - 1) tail = -1;	
			array[++tail] = v;		count++;}
		public int remove () {					
			if (head == size) head = 0;			count--;							
			return array[head++];}
		public boolean isEmpty() {	 	
			return count == 0;	}
	}
	
	class Vertex1 {
		public String name;
		public boolean isVisited;
		public Vertex1(String name) {
		    this.name = name;
		    isVisited = false;
//		    System.out.println("Добавлен вершина графа (прямоугольник) c именем    " + name);
		}
	}
	
	class Graph1 { 
		private Vertex1[] vertexList;		private int[][] matrix;		
		private int count;					private MyQueue queue;	
		public Graph1(int n)	 {
			vertexList = new Vertex1[n];	matrix = new int[n][n];
		 	queue = new MyQueue(n);	        count = 0;
		}
			
			// Mетод для добавления новой вершины в граф:
		public void insertVertex(String key)	 {
		   vertexList[count++] = new Vertex1(key);
		}
		
				// Mетод для добавления нового ребра (связи между вершинами):
		public void insertEdge(int begin, int end, int val)	    {		// val - если 1, то есть обратная связь из 2-ой вершины в 1-ую
			  matrix[begin][end] = 1;
			  matrix[end][begin] = val;	
			  System.out.println("Добавлено ребро между  " + begin + "  вершиной (прямоугольником) и  " + end + "  вершиной (прямоугольником)");}
			
			//Метод получения смежной непосещенной вершины
		private int getUnvisitedVertex(int vertex)    {
		  for(int i = 0; i < count; i++)
		      if(matrix[vertex][i] == 1 && vertexList[i].isVisited == false)
		          return i;
		  return -1;
		}
		
			//Метод реализации обхода в ширину
		public ArrayList<Integer> passInWidth(int index)	  {				// На входе индекс начальной вершины
			ArrayList<Integer> arl_result = new ArrayList<Integer>();
			System.out.println(vertexList[index].name);		// Печать названия вершины
			arl_result.add(Integer.parseInt(vertexList[index].name));
			vertexList[index].isVisited = true;				// Отмечаем, что вершина уже посещена
			queue.insert(index);							// Заносит вершину в очередь
			int vertex;
			while(!queue.isEmpty()) {						
				int temp = queue.remove();		
				while ((vertex = getUnvisitedVertex(temp)) != -1) {
					System.out.println(vertexList[vertex].name);		// Печать названия вершины
					arl_result.add(Integer.parseInt(vertexList[vertex].name));
					vertexList[vertex].isVisited = true;				// Отмечаем, что вершина уже посещена
					queue.insert(vertex);
				}
			}
				// Для сброса все к исходному состоянию, чтобы воспользоваться стэком повторно
			for (int i = 0; i<count; i++) {
				vertexList[i].isVisited = false;
			}
			return arl_result;
		}
	}

public class acmp_0097_Graph  {
	
	public static boolean chechBoundaries (int arr[][], int a_line, int b_line) {
		int x1_first = arr[a_line][0];		int x2_first = arr[a_line][2];		
		int y1_first = arr[a_line][1];		int y2_first = arr[a_line][3];
		int x1_second = arr[b_line][0];		int x2_second = arr[b_line][2];
		int y1_second = arr[b_line][1];		int y2_second = arr[b_line][3];
		int R1 = arr[a_line][4];			int R2 = arr[b_line][4];
		
		if (x1_first > x2_first)  {
			int temp = x1_first;
			x1_first = x2_first;
			x2_first = temp;	}
		if (y1_first > y2_first)  {
			int temp = y1_first;
			y1_first = y2_first;
			y2_first = temp;	}
		if (x1_second > x2_second)  {
			int temp = x1_second;
			x1_second = x2_second;
			x2_second = temp;	}
		if (y1_second > y2_second)  {
			int temp = y1_second;
			y1_second = y2_second;
			y2_second = temp;	}
		x1_first = x1_first - R1;		x2_first = x2_first + R1;
		y1_first = y1_first - R1;		y2_first = y2_first + R1;
		x1_second = x1_second - R2;		x2_second = x2_second + R2;
		y1_second = y1_second - R2;		y2_second = y2_second + R2;
		
		System.out.println("Координаты после изменения");
		System.out.print(x1_first);				System.out.print("  " + x2_first);
		System.out.print("  " + y1_first);		System.out.print("  " + y2_first); System.out.println();
		System.out.print(x1_second);			System.out.print("  " +  x2_second);
		System.out.print("  " + y1_second);		System.out.print("  " + y2_second);
		System.out.println();
		boolean result = false;
		if (((x1_second >=x1_first) & (x1_second <=x2_first)) && ((y2_second >=y1_first) & (y2_second <=y2_first))) {
			result = true; 
			System.out.println("slldlv 1");
			}
		if (((x1_second >=x1_first) & (x1_second <=x2_first)) && ((y1_second >=y1_first) & (y1_second <=y2_first))) {
			result = true;
			System.out.println("svaaa 2");
			}
		if (((x2_second >=x1_first) & (x2_second <=x2_first)) && ((y1_second >=y1_first) & (y1_second <=y2_first))) {
			result = true;
			System.out.println("ppdvmsd 3");
			}
		if (((x2_second >=x1_first) & (x2_second <=x2_first)) && ((y2_second >=y1_first) & (y2_second <=y2_first))) {
			result = true;
			System.out.println("sdsdm 4");
			}
		if (((x1_first >=x1_second) & (x1_first <=x2_second)) && ((y2_first >=y1_second) & (y2_first <=y2_second))) {
			result = true; 
			System.out.println("slldlv 5");
			}
		if (((x1_first >=x1_second) & (x1_first <=x2_second)) && ((y1_first >=y1_second) & (y1_first <=y2_second))) {
			result = true;
			System.out.println("svaaa 6");
			}
		if (((x2_first >=x1_second) & (x2_first <=x2_second)) && ((y1_first >=y1_second) & (y1_first <=y2_second))) {
			result = true;
			System.out.println("ppdvmsd 7");
			}
		if (((x2_first >=x1_second) & (x2_first <=x2_second)) && ((y2_first >=y1_second) & (y2_first <=y2_second))) {
			result = true;
			System.out.println("sdsdm 8");
		}
		if (((x1_second >=x1_first) & (x1_second <=x2_first))  && ((y1_second < y1_first) & (y2_second > y2_first))) {
				result = true;
				System.out.println("sdsdm 9");
			}
		if (((x1_first >=x1_second) & (x1_first <=x2_second))  && ((y1_first < y1_second) & (y2_first > y2_second))) {
			result = true;
			System.out.println("sdsdm 10");
		}
		if (((x2_second >=x1_first) & (x2_second <=x2_first)) && ((y1_second < y1_first) & (y2_second > y2_first))) {
			result = true;
			System.out.println("ppdvmsd 11");
			}
		if (((x2_first >=x1_second) & (x2_first <=x2_second)) && ((y1_first < y1_second) & (y2_first > y2_second))) {
			result = true;
			System.out.println("12");
			}
		if (((y1_second >=y1_first) & (y1_second <=y2_first))  && ((x1_second < x1_first) & (x2_second > x2_first))) {
			result = true;
			System.out.println("sdsdm 13");
		}
		if (((y1_first >=y1_second) & (y1_first <=y2_second))  && ((x1_first < x1_second) & (x2_first > x2_second))) {
			result = true;
			System.out.println("sdsdm 14");
		}
		if (((y2_second >=y1_first) & (y2_second <=y2_first)) && ((x1_second < x1_first) & (x2_second > x2_first))) {
			result = true;
			System.out.println("ppdvmsd 15");
			}
		if (((y2_first >=y1_second) & (y2_first <=y2_second)) && ((x1_first < x1_second) & (x2_first > x2_second))) {
			result = true;
			System.out.println("16");
			}
		return result;
	}
	
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	int arr[][] = new int[N][5];
	for (int i = 0; i<N; i++) {
		for (int j = 0; j<5; j++) {
			arr[i][j] = sc.nextInt();}
	}
	for (int i = 0; i<N; i++) System.out.println(Arrays.toString(arr[i]));
	
//	int matriza_peresech[][] = new int [N][N];
//	
//	for (int i = 0; i<N; i++) {
//		System.out.println();
//		for (int j = i+1; j<N; j++) {
//			if (chechBoundaries(arr, i, j)) {
//				matriza_peresech[i][j] = 1;
//				matriza_peresech[j][i] = 1;	}
////			System.out.println("Пересечение " + (i+1) + "  прямоугольника с     " + (j+1) + "  прямоугольником   " + chechBoundaries(arr, i, j));
//			}
//	}
	ArrayList<Integer> numbers_arr = new ArrayList<Integer>();
	Graph1 graph = new Graph1(N);
	for (int i = 0; i<N; i++) {
		graph.insertVertex(Integer.toString(i));	
		numbers_arr.add(i);}
	System.out.println(numbers_arr);
	
	for (int i = 0; i<N; i++) 
		for (int j = i+1; j<N; j++) 	if (chechBoundaries(arr, i, j)) graph.insertEdge(i, j, 1);
	
	int count  = 0;
	for (int i = 0; i<N; i++)  {
		int count2 = 0;
		ArrayList<Integer> arl = graph.passInWidth(i);
		System.out.println("Пересекаются" + arl);
		for (int j = 0; j<arl.size(); j++) {
			if (numbers_arr.remove(arl.get(j))) count2++;
			System.out.println(numbers_arr);
		}
		if (count2 >=1) count++;
		System.out.println("count = " + count);
	}
		
	System.out.println("count = "  + count);	
	
		
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
    out.println(count);
    out.flush();
    out.close();
}
}

/*
 * 9
4 3 1 1
4 1 7 3
7 2 10 5
9 3 13 4
1 4 3 7
3 9 7 13
4 10 6 12
7 9 12 11
4 15 7 17
*/
