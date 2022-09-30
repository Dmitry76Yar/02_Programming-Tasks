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

class Vertix {
	int label;
	int name;
	boolean isVisited;
	public Vertix(int label, int name, boolean isVisited) {
		this.label = label;
		this.name = name;
		this.isVisited = isVisited;
	}
}
public class acmp_0151_Graph_DvuhDolnii_Graph	{
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	int M = sc.nextInt();
	System.out.println("N = " + N + "  M = " + M);
	String result = "YES";
	
	if (N>2) {
		int graph[][] = new int[N+1][N+1];
		for (int i = 0; i<M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if (a!=b) {
				graph[a][b] = 1;
				graph[b][a] = 1;
			}
		}
		for (int i =0; i<N+1; i++) System.out.println(Arrays.toString(graph[i]));
		
		ArrayList<Vertix> listOfVertix = new ArrayList<Vertix>();
		for (int i =0; i<N+1; i++) listOfVertix.add(new Vertix(0, i, false));
		listOfVertix.get(0).isVisited = true;
		
		int exit = 0;
			// Проверяем каждую непосещенную вершину
		for (int i = 1; i<=N; i++) {
			if (listOfVertix.get(i).isVisited == true) System.out.println("Извлеченная вершина " + listOfVertix.get(i).name + " уже посещена");
			else {
					// Для непосещенной вершины совершаем поиск в ширину конфликтующих гостей
				System.out.println("Извлечена вершина" + listOfVertix.get(i).name);
				listOfVertix.get(i).isVisited = true;
				listOfVertix.get(i).label = 1;
				ArrayList<Vertix> queue = new ArrayList<Vertix>();
				queue.add(listOfVertix.get(i));
				while (queue.isEmpty() == false) {
					System.out.print("В очереди    ");
					for (int u =0; u<queue.size(); u++) System.out.print(queue.get(u).name + "  -->  ");
					System.out.println();
//				for (int g = 1; g<=4; g++) {
					Vertix vert = queue.get(0);
					for (int j = 1; j<=N; j++) {
						if ((graph[vert.name][j] == 1) && (listOfVertix.get(j).isVisited == false)) {
							listOfVertix.get(j).isVisited = true;
							if(vert.label == 1) listOfVertix.get(j).label = -1;
							else listOfVertix.get(j).label = 1;
							queue.add(listOfVertix.get(j));
						}
						if ((graph[vert.name][j] == 1) && (listOfVertix.get(j).isVisited == true) && 
							(vert.label == listOfVertix.get(j).label)) {
								exit = 1;
								break;
						}
					}
					queue.remove(0);
					for (int h =1; h<=N; h++) System.out.print(listOfVertix.get(h).name + " = " + listOfVertix.get(h).label + "  -->  ");
					System.out.println();
					if (exit == 1) {
						System.out.println("найдено несоответствие");
						break;
					}
				}
			}
			if (exit == 1) 	break;
		}
		if (exit == 1) result = "NO";
	}
					
	System.out.println("	RESULT = "    + result);
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	out.print(result);
	out.flush();
	out.close();
}
}





