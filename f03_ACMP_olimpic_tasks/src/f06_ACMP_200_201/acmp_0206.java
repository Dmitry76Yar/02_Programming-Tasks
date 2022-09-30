package f06_ACMP_200_201;

	/* Домой на электричках	(Время: 1 сек. Память: 16 Мб Сложность: 50%)
Одна из команд-участниц олимпиады решила вернуться домой на электричках. При этом ребята хотят попасть домой как можно раньше.
К сожалению, не все электрички идут от города, где проводится олимпиада, до станции, на которой живут ребята. И, что еще более
обидно, не все электрички, которые идут мимо их станции, останавливаются на ней (равно как вообще, электрички останавливаются
далеко не на всех станциях, мимо которых они идут).
	Все станции на линии пронумерованы числами от 1 до N. При этом станция номер 1 находится в городе, где проводится олимпиада,
и в момент времени 0 ребята приходят на станцию. Станция, на которую нужно попасть ребятам, имеет номер E.
	Напишите программу, которая по данному расписанию движения электричек вычисляет минимальное время, когда ребята могут
оказаться дома.
	Входные данные
Во входном файле INPUT.TXT записаны сначала числа N (2 ≤ N ≤ 100) и E (2 ≤ E ≤ N). Затем записано число M (0 ≤ M ≤ 100),
обозначающее число рейсов электричек. Далее идет описание M рейсов электричек. Описание каждого рейса электрички начинается с
числа Ki (2 ≤ Ki ≤ N) — количества станций, на которых она останавливается, а далее следует Ki пар чисел, первое число каждой
пары задает номер станции, второе — время, когда электричка останавливается на этой станции (время выражается целым числом из
диапазона от 0 до 109). Станции внутри одного рейса упорядочены в порядке возрастания времени. В течение одного рейса электричка
все время движется в одном направлении — либо от города, либо к городу.
	Выходные данные
В выходной файл OUTPUT.TXT выведите одно число — минимальное время, когда ребята смогут оказаться на своей станции. Если
существующими рейсами электричек они добраться не смогут, выведите –1.
	Пример
№	INPUT.TXT			OUTPUT.TXT
1	5 3
4
2 1 5 2 10
2 2 10 4 15
4 5 0 4 17 3 20 2 35
3 1 2 3 40 4 45				20 */

import java.util.*;
import java.io.*;


	class VertixP2 {
		int nameOfVertix;   						// Имя вершины		
		int label; 									// Значение метки - для сохранения минимальной дистанции до этой метки
		VertixP2 parentrVert;						// Для сохранения метки, из которой делается шаг в эту вершину, по минимальному маршруту
		boolean isVisited;

		public VertixP2(int nameOfVertix) {
			this.nameOfVertix = nameOfVertix;
			this.label = Integer.MAX_VALUE;
			this.isVisited = false;
		}
	}

	class Edge {
		ArrayList<int[]> listOfWeigtsOfEdge;		// Список всех ребер Для каждого ребра массив [timeDeparture, timeArrival]
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
		Edge matrizaEdgeOptions[][];		// Матрица для хранения всех ребер 
		
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
//			System.out.println("Вершина " + vertixList.get(vert.nameOfVertix).nameOfVertix + "   отмечена как посещенная");
//			System.out.println("Число непосещенных вершин стало " + countOfUnvisitedVertix + "   из общего число  " + countOfVertix);
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
//			System.out.println("Найдена вершина с минимальной меткой  = " + vertixList.get(result).nameOfVertix);
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
//				System.out.print(" <---   " + parentVert);
				if (parentVert == startVertix) break;
				else temp = parentVert;
			}
		}
	}

	
public class acmp_0206{
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int Nstation = sc.nextInt();
	int eArrivalStat = sc.nextInt();
	int mNumbTrains = sc.nextInt();
	System.out.println("Nstation = " + Nstation + "  eArrivalStat " + eArrivalStat + "  mNumbTrains =  " + mNumbTrains);
	Graph2 graph = new Graph2(Nstation+1);
	
	for (int i=0; i<mNumbTrains; i++) {
		int kNumbeStatWhereStops = sc.nextInt();
		int statWhereStops[] = new int[kNumbeStatWhereStops];
		int timeWhenStops[] = new int[kNumbeStatWhereStops];
		for (int j=0; j<kNumbeStatWhereStops; j++) {
			statWhereStops[j] = sc.nextInt();
			timeWhenStops[j] = sc.nextInt();
		}
		System.out.println("kNumbeStatWhereStops = " + kNumbeStatWhereStops +"    " + 
				Arrays.toString(statWhereStops) + "  " + Arrays.toString(timeWhenStops));
		
		for (int j=0; j<statWhereStops.length-1; j++) {
			int statDeparture = statWhereStops[j];
			int statArrival = statWhereStops[j+1];
			int timeDeparure = timeWhenStops[j];
			int timeArrival = timeWhenStops[j+1];
			if (graph.matrizaEdgeOptions[statDeparture][statArrival] == null) {
				graph.matrizaEdgeOptions[statDeparture][statArrival] = new Edge();
				graph.matrizaEdgeOptions[statDeparture][statArrival].addEdge(timeDeparure, timeArrival);
			}
			else {
				graph.matrizaEdgeOptions[statDeparture][statArrival].addEdge(timeDeparure, timeArrival);
			}
			graph.matrizaSmegnosti[statDeparture][statArrival] =  1;
		}
	}
	
	for (int i=1; i<=Nstation; i++) System.out.println(Arrays.toString(graph.matrizaSmegnosti[i]));
	for (int i=1; i<=Nstation; i++)  {
		for (int j=1; j<=Nstation; j++) {
			if (graph.matrizaEdgeOptions[i][j] != null) {
				System.out.print("Варианты ребра из станции " + i + "  в станцию " + j + "   ");
				graph.matrizaEdgeOptions[i][j].print();
			}
		}
	}
	
	for (int i = 0; i<Nstation + 1; i++ ) graph.addVertix(new VertixP2(i));
	graph.algoritmDeikstri(1);
	int result = graph.vertixList.get(eArrivalStat).label;
	if (result == Integer.MAX_VALUE) result = -1;
	System.out.println("RESULT = " + result);
		
	
	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	o.print(result);
	o.flush();
	o.close();
}
}




