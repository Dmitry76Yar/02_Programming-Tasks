package f04_ACMP_101_200;
/* Заправки		(Время: 1 сек. Память: 16 Мб Сложность: 49%)
В стране N городов, некоторые из которых соединены между собой дорогами. Для того, чтобы проехать по одной дороге требуется один бак
бензина. В каждом городе бак бензина имеет разную стоимость. Вам требуется добраться из первого города в N-ый, потратив как можно
меньшее количество денег.
	Входные данные
Во входном файле INPUT.TXT записано сначала число N (1 ≤ N ≤ 100), затем идет N чисел, i-ое из которых задает стоимость бензина в
i-ом городе (все числа целые из диапазона от 0 до 100). Далее идет число M - количество дорог в стране, далее идет описание самих дорог.
Каждая дорога задается двумя числами - номерами городов, которые она соединяет. Все дороги двухсторонние (то есть по ним можно ездить
как в одну, так и в другую сторону); между двумя городами всегда существует не более одной дороги; не существует дорог, ведущих из
города в себя.
	Выходные данные
В выходной файл OUTPUT.TXT выведите одно число - суммарную стоимость маршрута или -1, если добраться невозможно.
	Пример	
№	INPUT.TXT		OUTPUT.TXT
1	4
	1 10 2 15
	4
	1 2
	1 3
	4 2
	4 3				3		*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


class VertixP1 {
	int nameOfVertix;   						// Имя вершины		
	int label; 								// Значение метки - для сохранения минимальной дистанции до этой метки
	VertixP1 parentrVert;					// Для сохранения метки, из которой делается шаг в эту вершину, по минимальному маршруту
	boolean isVisited;

	public VertixP1(int nameOfVertix) {
		this.nameOfVertix = nameOfVertix;
		this.label = Integer.MAX_VALUE;
		this.isVisited = false;
	}
}

class Graph1 {
	ArrayList<VertixP1> vertixList;
	int countOfVertix;
	int countOfUnvisitedVertix;
	int matrizaSmegnosti[][];
	
	public Graph1(int countOfVertix) {
		this.countOfVertix = countOfVertix;
		this.vertixList = new ArrayList<VertixP1>();
		this.countOfUnvisitedVertix = 0;
		this.matrizaSmegnosti = new int[countOfVertix][countOfVertix];		// Если в матрице после внесения всех связей останутся нули, 
	}																				// нет связи
	void addVertix (VertixP1 vert) {
		vertixList.add(vert);
	}
	void addEdge (int nameVertA, int nameVertB, int distance) {
		matrizaSmegnosti[nameVertA][nameVertB] = distance;
		matrizaSmegnosti[nameVertB][nameVertA] = distance;
	}
			// Метод отметки вершины посещенной
	void visited (VertixP1 vert) {
		vertixList.get(vert.nameOfVertix).isVisited = true;
		countOfUnvisitedVertix++;
//		System.out.println("Вершина " + vertixList.get(vert.nameOfVertix).nameOfVertix + "   отмечена как посещенная");
//		System.out.println("Число непосещенных вершин стало " + countOfUnvisitedVertix + "   из общего число  " + countOfVertix);
	}
			
			// Метод определения ближайшей соседней вершины
	VertixP1 closestNeiboorVert (VertixP1 vert) { 
		int min = Integer.MAX_VALUE;
		VertixP1 result = null;
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
	boolean isUnvisitedNeiboorVertix (VertixP1 vert) {
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
	VertixP1 toSearchMinVertix () {
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
			VertixP1 vertMinLabel = toSearchMinVertix();									// находим вершину с минимальной меткой
			while (isUnvisitedNeiboorVertix(vertMinLabel) == true) {					// если данная вершина имеет соседний непосещ вершины
				VertixP1 closestVertix = closestNeiboorVert(vertMinLabel);				// находим ближайшую вершину
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

public class acmp_0133_graph_route_DeisktrAlg	{
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int Ncities = sc.nextInt();
	int petroleumCost[] = new int [Ncities+1];
	for (int i=1; i<=	Ncities; i++) petroleumCost[i] = sc.nextInt();
		System.out.println(Arrays.toString(petroleumCost));
	int Mroads = sc.nextInt();
		System.out.println(" Ncities = " + Ncities  + "   Mroads = " + Mroads);
	Graph1 graph = new Graph1(Ncities + 1);
	for (int i=0; i<Mroads; i++) {
		int roadDescription[] = new int[2];
		for (int j=0; j<2; j++) roadDescription[j] = sc.nextInt();
		graph.matrizaSmegnosti[roadDescription[0]][roadDescription[1]] = petroleumCost[roadDescription[0]];
		graph.matrizaSmegnosti[roadDescription[1]][roadDescription[0]] = petroleumCost[roadDescription[1]];
	}
	for (int i=1; i<=Ncities; i++) System.out.println(Arrays.toString(graph.matrizaSmegnosti[i]));

	for (int i = 0; i<Ncities + 1; i++ ) graph.addVertix(new VertixP1(i));
	graph.algoritmDeikstri(1);
	int result = graph.vertixList.get(Ncities).label;
	if (result == Integer.MAX_VALUE) {
		result = -1;
		System.out.println("RESULT = " + result);
	}
	else System.out.println("RESULT = " + result);
	
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	out.print(result);
    out.flush();
    out.close();
	}
}
