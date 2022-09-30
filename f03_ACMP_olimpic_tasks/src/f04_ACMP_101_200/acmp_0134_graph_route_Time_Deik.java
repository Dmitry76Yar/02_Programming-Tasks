package f04_ACMP_101_200;
/* Автобусы	(Время: 1 сек. Память: 16 Мб Сложность: 50%)
Между некоторыми деревнями края Власюки ходят автобусы. Поскольку пассажиропотоки здесь не очень большие, то автобусы ходят всего
несколько раз в день.
	Марии Ивановне требуется добраться из деревни d в деревню v как можно быстрее (считается, что в момент времени 0 она находится
в деревне d).
	Входные данные
Во входном файле INPUT.TXT записано число N - общее число деревень (1 ≤ N ≤ 100), номера деревень d и v, затем количество автобусных
рейсов R (0 ≤ R ≤ 10000). Затем идут описания автобусных рейсов. Каждый рейс задается номером деревни отправления, временем отправления,
деревней назначения и временем прибытия (все времена - целые от 0 до 10000). Если в момент t пассажир приезжает в деревню, то уехать из
нее он может в любой момент времени, начиная с t.
	Выходные данные
В выходной файл OUTPUT.TXT вывести минимальное время, когда Мария Ивановна может оказаться в деревне v. Если она не сможет с помощью
указанных автобусных рейсов добраться из d в v, вывести -1.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1	3
	1 3
	4
	1 0 2 5
	1 1 2 3
	2 3 3 5
	1 1 3 10		5		*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


class VertixP2 {
	int nameOfVertix;   						// Имя вершины		
	int label; 								// Значение метки - для сохранения минимальной дистанции до этой метки
	VertixP2 parentrVert;					// Для сохранения метки, из которой делается шаг в эту вершину, по минимальному маршруту
	boolean isVisited;
//	ArrayList<Integer[]> variatsOfWeightEdge; 

	public VertixP2(int nameOfVertix) {
		this.nameOfVertix = nameOfVertix;
		this.label = Integer.MAX_VALUE;
		this.isVisited = false;
//		this.variatsOfWeightEdge = new ArrayList<Integer[]>();
	}
}

class Edge {
	ArrayList<int[]> listOfWeigtsOfEdge;
	boolean doesThisEdgeExist = false;
	int numberOfWeightOption;
	
	public Edge() {
		this.doesThisEdgeExist = true;
		this.listOfWeigtsOfEdge = new ArrayList<int[]>();
		this.numberOfWeightOption = 0;
	}
	
	void addEdge (int timeDeparture, int timeArrival) {
		listOfWeigtsOfEdge.add(new int[] {timeDeparture, timeArrival});
		numberOfWeightOption++;
	}
	void print () {
		for (int i =0; i<listOfWeigtsOfEdge.size(); i++) System.out.print(Arrays.toString(listOfWeigtsOfEdge.get(i))); 
		System.out.println();
	}
}

class Graph2 {
	ArrayList<VertixP2> vertixList;
	int countOfVertix;
	int countOfUnvisitedVertix;
	int matrizaSmegnosti[][];
	Edge matrizaEdgeOptions[][];
	
	public Graph2(int countOfVertix) {
		this.countOfVertix = countOfVertix;
		this.vertixList = new ArrayList<VertixP2>();
		this.countOfUnvisitedVertix = 0;
		this.matrizaSmegnosti = new int[countOfVertix][countOfVertix];		// Если в матрице после внесения всех связей останутся нули, 
																			// нет связи
		this.matrizaEdgeOptions = new Edge[countOfVertix][countOfVertix];
	}																				
	void addVertix (VertixP2 vert) {
		vertixList.add(vert);
	}
	void addEdge (int nameVertA, int nameVertB, int distance) {
		matrizaSmegnosti[nameVertA][nameVertB] = distance;
		matrizaSmegnosti[nameVertB][nameVertA] = distance;
	}
			// Метод отметки вершины посещенной
	void visited (VertixP2 vert) {
		vertixList.get(vert.nameOfVertix).isVisited = true;
		countOfUnvisitedVertix++;
//		System.out.println("Вершина " + vertixList.get(vert.nameOfVertix).nameOfVertix + "   отмечена как посещенная");
//		System.out.println("Число непосещенных вершин стало " + countOfUnvisitedVertix + "   из общего число  " + countOfVertix);
	}
			// Метод определения ближайшей соседней вершины
	VertixP2 closestNeiboorVert (VertixP2 vert) { 
		int min = Integer.MAX_VALUE;
		VertixP2 result = null;
		for (int i=0; i<countOfVertix; i++) {
			int temp = matrizaSmegnosti[vert.nameOfVertix][i]; 
			if ((temp !=0) && (vertixList.get(i).isVisited == false) && (temp < min)) {
				min = temp;
				result = vertixList.get(i);
			}
		}
		System.out.println("Для вершины " + vert.nameOfVertix + "  найдена ближайшая вершина " + result.nameOfVertix);
		return result;
	}
			// Метод определения наличия непосещенных соседних вершин
	boolean isUnvisitedNeiboorVertix (VertixP2 vert) {
		boolean result = false;
		for (int i=0; i<countOfVertix; i++) {
			if ((matrizaSmegnosti[vert.nameOfVertix][i] !=0) && (vertixList.get(i).isVisited == false)) {
				result = true;
				break;
			}
		}
		if (result == true) System.out.println("Вершина " + vert.nameOfVertix + "  имеет непосещенного соседа");
		else System.out.println("Вершина " + vert.nameOfVertix + "  не имеет непосещенных соседей");
		return result;
	}
	
			// Метод нахождения вершины с минимальной меткой 
	VertixP2 toSearchMinVertix () {
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
		visited(vertixList.get(0));                           	// вершина с нулем сразу обнуляется, т.к. ее нет в анализируемом графе
		while (countOfUnvisitedVertix < countOfVertix) {		// пока еще есть непосещенные вершины
			VertixP2 vertMinLabel = toSearchMinVertix();								// находим вершину с минимальной меткой
			while (isUnvisitedNeiboorVertix(vertMinLabel) == true) {					// если данная вершина имеет соседний непосещ вершины
				VertixP2 closestVertix = closestNeiboorVert(vertMinLabel);				// находим ближайшую вершину
				ArrayList<int[]> varWeightEdge = matrizaEdgeOptions[vertMinLabel.nameOfVertix][closestVertix.nameOfVertix].listOfWeigtsOfEdge;
				int min = Integer.MAX_VALUE;
				for (int i = 0; i<varWeightEdge.size(); i++) {
					System.out.println("От вершины " + vertMinLabel.nameOfVertix + " с меткой " + vertMinLabel.label + "  прорабатывается вершина " + closestVertix.nameOfVertix + "  с ребром с отбытием  " + varWeightEdge.get(i)[0] + "  и прибытием " + varWeightEdge.get(i)[1]);
					if ((varWeightEdge.get(i)[0] >= vertMinLabel.label) && (min > varWeightEdge.get(i)[1]))  min = varWeightEdge.get(i)[1];
				}
				matrizaSmegnosti[vertMinLabel.nameOfVertix][closestVertix.nameOfVertix] = 0;		// помечаем в матрице эту вершину как нуль, чтобы снова ее не проверять
				int newLabel = min;
				int currentLabel = closestVertix.label;
				if (newLabel < currentLabel) {
					closestVertix.label = newLabel;
					closestVertix.parentrVert = vertMinLabel;
					System.out.println("Ближайшей вершине " + closestVertix.nameOfVertix + "  к вершине " + vertMinLabel.nameOfVertix + " присвоена новая метка " + closestVertix.label);
					}
				else System.out.println("Метка ближайшей вершины " + closestVertix.nameOfVertix + "  к вершине " + vertMinLabel.nameOfVertix + " не изменилась ");
				System.out.println();
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

public class acmp_0134_graph_route_Time_Deik	{
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int Ncountries = sc.nextInt();
	int d_start = sc.nextInt();
	int v_finish = sc.nextInt();
	int R_numbersOfRoutes =sc.nextInt();
	System.out.println(" Ncountries = " + Ncountries +  " d_start = " + d_start + "  v_finish " + v_finish + "  R_numbersOfRoutes = " + R_numbersOfRoutes );
	Graph2 graph = new Graph2(Ncountries + 1);
	
	for (int i = 1; i<=	R_numbersOfRoutes; i++) {
		int startCountry = sc.nextInt();
		int departureTime = sc.nextInt();
		int finishCountry = sc.nextInt();
		int arrivalTime = sc.nextInt();
		if (graph.matrizaEdgeOptions[startCountry][finishCountry] == null) {
			graph.matrizaEdgeOptions[startCountry][finishCountry] = new Edge();
			graph.matrizaEdgeOptions[startCountry][finishCountry].addEdge(departureTime, arrivalTime);
		}
		else {
			graph.matrizaEdgeOptions[startCountry][finishCountry].addEdge(departureTime, arrivalTime);
		}
		graph.matrizaSmegnosti[startCountry][finishCountry] =  1;
	}
	for (int i=1; i<=Ncountries; i++) System.out.println(Arrays.toString(graph.matrizaSmegnosti[i]));
	for (int i=1; i<=Ncountries; i++)  {
		for (int j=1; j<=Ncountries; j++) {
			if (graph.matrizaEdgeOptions[i][j] != null) {
				System.out.print("Варианты ребра из города " + i + "  в город " + j + "   ");
				graph.matrizaEdgeOptions[i][j].print();
			}
		}
	}
		
	for (int i = 0; i<Ncountries + 1; i++ ) graph.addVertix(new VertixP2(i));
	graph.algoritmDeikstri(d_start);
	int result = graph.vertixList.get(v_finish).label;
	if (result == Integer.MAX_VALUE) result = -1;
	System.out.println("RESULT = " + result);
	
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	out.print(result);
    out.flush();
    out.close();
	}
}
