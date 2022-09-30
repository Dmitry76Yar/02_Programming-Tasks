package f04_ACMP_101_200;

/* 	Лабиринт знаний		(Время: 1 сек. Память: 16 Мб Сложность: 63%)
В стране Умландии построили аттракцион "Лабиринт знаний". Лабиринт представляет собой N комнат, занумерованных от 1 до N, между
некоторыми из которых есть двери. Когда человек проходит через дверь, показатель его знаний изменяется на определенную величину,
фиксированную для данной двери. Вход в лабиринт находится в комнате 1, выход - в комнате N. Каждый ученик проходит лабиринт ровно
один раз и попадает в ту или иную учебную группу в зависимости от количества набранных знаний (при входе в лабиринт этот показатель
равен нулю). Ваша задача показать наилучший результат.
	Входные данные
Первая строка входного файла INPUT.TXT содержит целые числа N (1 ≤ N ≤ 2000) - количество комнат и M (0 ≤ M ≤ 10000) - количество дверей.
В каждой из следующих M строк содержится описание двери - номера комнат, из которой она ведет и в которую она ведет (через дверь можно
ходить только в одном направлении), а также целое число, которое прибавляется к количеству знаний при прохождении через дверь (это число
по модулю не превышает 10000). Двери могут вести из комнаты в нее саму, между двумя комнатами может быть более одной двери.
	Выходные данные
В выходной файл OUTPUT.TXT выведите ":)" - если можно получить неограниченно большой запас знаний, ":(" - если лабиринт пройти нельзя,
и максимальное количество набранных знаний в противном случае.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1	2 2
	1 2 5
	1 2 -5			5	
 */

import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;

// Не проходит 13-ый тест
public class acmp_0139_Ford_Belman2	{
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	short N_Vertix = sc.nextShort();
	short N_Edges = sc.nextShort();
//	System.out.println("N_Vertix = " + N_Vertix + "   , N_Edges = " + N_Edges);
	
	String result = null;
	
    short[][] graph = new short[N_Vertix + 1][N_Vertix + 1];
	    
    for (int i = 0; i<=N_Vertix; i++) {
    	for (int j = 0; j<=N_Vertix; j++) {
    		graph[i][j] = -10001;
    	}	
    }
    
    double outcome[] = new double[N_Vertix+1];
	for (int k = 0; k < N_Vertix+1; k++) outcome[k] = Double.NEGATIVE_INFINITY;
	outcome[1] = 0;
    
    if ((N_Vertix == 1) && (N_Edges == 0)) 
    	result = "0";
    else if ((N_Vertix == 1) && (N_Edges > 0) ) {
    	graph[N_Vertix][N_Vertix] = 0;
    	for (int i = 0; i<N_Edges; i++) {
    		short start = sc.nextShort();
    		short end = sc.nextShort();
			short weight = sc.nextShort();
			if (graph[start][end] < weight) graph[start][end] = weight;
		}
    	if (graph[N_Vertix][N_Vertix] > 0) {
    		System.out.println("Positive Cycle Detected");
    		result = ":)";	}
    	else result = Integer.toString(graph[N_Vertix][N_Vertix]);
    }
	else {
	    HashSet<Short[]> hashset = new HashSet<Short[]>();
		
		for (int i = 0; i<N_Edges; i++) {
			short start = sc.nextShort();
			short end = sc.nextShort();
			short weight = sc.nextShort();
			if (graph[start][end] < weight) {
				graph[start][end] = weight;
				hashset.add(new Short[] {start,end});
			}
		}
		ArrayList<Short[]> arl = new ArrayList<Short[]>();
		arl.addAll(hashset);
//		for (int y = 0; y<arl.size(); y++) System.out.println(Arrays.toString(arl.get(y)));
//		System.out.println();
			
//				System.out.println("Граф на входе");
//				for (int i = 1; i < graph.length; i++) {
//				   for (int j = 1; j < graph.length; j++)  	System.out.print(graph[i][j] + " \t");
//				   System.out.println();}
				
//				System.out.println(" outcome" + Arrays.toString(outcome));
				
				for (int var = 1; var <= N_Vertix - 1; var++) {
					for (int y=0; y<arl.size(); y++) {
						short start = arl.get(y)[0];
						short finish = arl.get(y)[1];
						short weight_temp = graph[start][finish];
						if ((outcome[start] != Double.NEGATIVE_INFINITY) && (outcome[finish] < outcome[start] + weight_temp)) {
								outcome[finish] = outcome[start] + weight_temp;
//								System.out.print("Ребро " + start + " - " + finish + "  = " + weight_temp);
//								System.out.println("    Вершина " + finish + " обновила значение до " + outcome[finish]);
						}
					}
//					System.out.println(Arrays.toString(outcome));
				}
//					System.out.println();
			double result_1 = outcome[N_Vertix];
			
				for (int y=0; y<arl.size(); y++) {
					short start = arl.get(y)[0];
					short finish = arl.get(y)[1];
					short weight_temp = graph[start][finish];
					if ((outcome[start] != Double.NEGATIVE_INFINITY) && (outcome[finish] < outcome[start] + weight_temp)) {
							outcome[finish] = outcome[start] + weight_temp;
					}
				}
			int result_2 = 0;
			if (result_1 != outcome[N_Vertix]) result_2 = 1;

			if (result_1 == Double.NEGATIVE_INFINITY) {
					System.out.println("N вершина не достижима");
					result = ":(";	 }
			else result = Integer.toString((int)result_1);
			
			if (result_2 == 1 ) {
					System.out.println("Positive Cycle Detected");
		    		result = ":)";	}
			}
//			else result = ":(";	
		    
	System.out.println("	RESULT = "    + result);
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	out.print(result);
	out.flush();
	out.close();
}
}
