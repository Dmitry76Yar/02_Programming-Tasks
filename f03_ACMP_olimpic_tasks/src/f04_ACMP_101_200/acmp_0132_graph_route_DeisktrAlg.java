package f04_ACMP_101_200;
/* Алгоритм Дейкстры		(Время: 1 сек. Память: 16 Мб Сложность: 47%)
Дан ориентированный взвешенный граф. Для него вам необходимо найти кратчайшее расстояние от вершины S до вершины F.
	Входные данные
В первой строке входного файла INPUT.TXT записаны три числа: N, S и F (1 ≤ N ≤ 100; 1 ≤ S, F ≤ N), где N - количество вершин графа.
В следующих N строках записаны по N чисел - матрица смежности графа, где число в i-ой строке j-ом столбце соответствует ребру из i в 
j: -1 означает отсутствие ребра между вершинами, а любое неотрицательное целое число (от 0 до 100) - наличие ребра данного веса. 
На главной диагонали матрицы всегда записаны нули.
	Выходные данные
В выходной файл OUTPUT.TXT необходимо вывести искомое расстояние или -1, если пути между указанными вершинами не существует.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1	3 2 1
	0 1 1
	4 0 1
	2 1 0			3		*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


class VertixP {
	int nameOfVertix;   						// Имя вершины		
	int label; 								// Значение метки - для сохранения минимальной дистанции до этой метки
	VertixP parentrVert;					// Для сохранения метки, из которой делается шаг в эту вершину, по минимальному маршруту
	boolean isVisited;

	public VertixP(int nameOfVertix) {
		this.nameOfVertix = nameOfVertix;
		this.label = Integer.MAX_VALUE;
		this.isVisited = false;
	}
}

class Graph {
	ArrayList<VertixP> vertixList;
	int countOfVertix;
	int countOfUnvisitedVertix;
	int matrizaSmegnosti[][];
	
	public Graph(int countOfVertix) {
		this.countOfVertix = countOfVertix;
		this.vertixList = new ArrayList<VertixP>();
		this.countOfUnvisitedVertix = 0;
		this.matrizaSmegnosti = new int[countOfVertix][countOfVertix];		// Если в матрице после внесения всех связей останутся нули, 
	}																				// нет связи
	void addVertix (VertixP vert) {
		vertixList.add(vert);
	}
	void addEdge (int nameVertA, int nameVertB, int distance) {
		matrizaSmegnosti[nameVertA][nameVertB] = distance;
		matrizaSmegnosti[nameVertB][nameVertA] = distance;
	}
			// Метод отметки вершины посещенной
	void visited (VertixP vert) {
		vertixList.get(vert.nameOfVertix).isVisited = true;
		countOfUnvisitedVertix++;
//		System.out.println("Вершина " + vertixList.get(vert.nameOfVertix).nameOfVertix + "   отмечена как посещенная");
//		System.out.println("Число непосещенных вершин стало " + countOfUnvisitedVertix + "   из общего число  " + countOfVertix);
	}
			
			// Метод определения ближайшей соседней вершины
	VertixP closestNeiboorVert (VertixP vert) { 
		int min = Integer.MAX_VALUE;
		VertixP result = null;
		for (int i=0; i<countOfVertix; i++) {
			int temp = matrizaSmegnosti[vert.nameOfVertix][i]; 
			if ((temp !=0) && (vertixList.get(i).isVisited == false) && (temp < min)) {
				min = temp;
				result = vertixList.get(i);
			}
		}
//		System.out.println("Для вершины " + vert.nameOfVertix + "  найдена ближайшая вершина " + result.nameOfVertix);
		return result;
	}
			// Метод определения наличия непосещенных соседних вершин
	boolean isUnvisitedNeiboorVertix (VertixP vert) {
		boolean result = false;
		for (int i=0; i<countOfVertix; i++) {
			if ((matrizaSmegnosti[vert.nameOfVertix][i] !=0) && (vertixList.get(i).isVisited == false)) {
				result = true;
				break;
			}
		}
//		if (result == true) System.out.println("Вершина " + vert.nameOfVertix + "  имеет непосещенного соседа");
//		else System.out.println("Вершина " + vert.nameOfVertix + "  не имеет непосещенных соседей");
		return result;
	}
	
			// Метод нахождения вершины с минимальной меткой 
	VertixP toSearchMinVertix () {
		int min = Integer.MAX_VALUE;
		int result = 0;
		for (int i = 0; i<countOfVertix; i++) {
			if ((vertixList.get(i).isVisited == false) && (vertixList.get(i).label < min)) {
				min = vertixList.get(i).label;
				result = i;
			}
		}
//		System.out.println("Найдена вершина с минимальной меткой  = " + vertixList.get(result).nameOfVertix);
		return vertixList.get(result);
	}
	
	void algoritmDeikstri (int nameOfStartVertix) {
		vertixList.get(nameOfStartVertix).label = 0;			// стартовой вершину присваимвем метку = 0, остальные Integer.MAX
		visited(vertixList.get(0));                           	// ершина с нулем сразу обнуляется, т.к. ее нет в анализируемом графе
		while (countOfUnvisitedVertix < countOfVertix) {		// пока еще есть непосещенные вершины
//		for (int i =0 ; i<=2; i++) {
			VertixP vertMinLabel = toSearchMinVertix();									// находим вершину с минимальной меткой
			while (isUnvisitedNeiboorVertix(vertMinLabel) == true) {					// если данная вершина имеет соседний непосещ вершины
				VertixP closestVertix = closestNeiboorVert(vertMinLabel);				// находим ближайшую вершину
				int distance = matrizaSmegnosti[vertMinLabel.nameOfVertix][closestVertix.nameOfVertix];		// растояние между ними
				matrizaSmegnosti[vertMinLabel.nameOfVertix][closestVertix.nameOfVertix] = 0;		// помечаем в матрице эту вершину как нуль, чтобы снова ее не проверять
				int newLabel = vertMinLabel.label + distance;
				int currentLabel = closestVertix.label;
				if (newLabel < currentLabel) {
					closestVertix.label = newLabel;
					closestVertix.parentrVert = vertMinLabel;
//					System.out.println("Ближайшей вершине " + closestVertix.nameOfVertix + "  к вершине " + vertMinLabel.nameOfVertix + " присвоена новая метка " + closestVertix.label);
					}
//				else System.out.println("Метка ближайшей вершины " + closestVertix.nameOfVertix + "  к вершине " + vertMinLabel.nameOfVertix + " не изменилась ");
//				System.out.println();
			}
			visited(vertMinLabel);					// когда все соседние вершины обработаны отмечаем стартовую вершину посещенной
			}
		}
	
	void printRoute (int startVertix, int finishVertix) {
		int temp = finishVertix;
		while (true) {
			int parentVert = vertixList.get(temp).parentrVert.nameOfVertix;
//			System.out.print(" <---   " + parentVert);
			if (parentVert == startVertix) break;
			else temp = parentVert;
		}
	}
}

public class acmp_0132_graph_route_DeisktrAlg	{
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int countOfVert = sc.nextInt();
	int startVert = sc.nextInt();
	int finishVert = sc.nextInt();
//	System.out.println("startVert = " + startVert + "  finishVert=  " + finishVert);
	Graph graph = new Graph(countOfVert+1);
	for (int i =1; i<=countOfVert; i++) {
		for (int j =1; j<=countOfVert; j++) {
			int temp = sc.nextInt();
			if (temp == -1) graph.matrizaSmegnosti[i][j] = 0;
			else graph.matrizaSmegnosti[i][j] = temp;
		}
	}
	for (int i=1; i<=countOfVert; i++) System.out.println(Arrays.toString(graph.matrizaSmegnosti[i]));
	for (int i = 0; i<countOfVert+1; i++ ) graph.addVertix(new VertixP(i));
	graph.algoritmDeikstri(startVert);
	int result = graph.vertixList.get(finishVert).label;
	if (result == Integer.MAX_VALUE) {
		result = -1;
		System.out.println("RESULT = " + result);
	}
	else System.out.println("Самое короткое растояние из вершины  " + startVert + "  в вершину  " + finishVert + " равно     " + graph.vertixList.get(finishVert).label);
	
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	out.print(result);
    out.flush();
    out.close();
	}
}
