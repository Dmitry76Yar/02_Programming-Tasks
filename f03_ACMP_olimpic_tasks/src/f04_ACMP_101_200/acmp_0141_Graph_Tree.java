package f04_ACMP_101_200;

/* 	Дерево	(Время: 1 сек. Память: 16 Мб Сложность: 42%)
Неориентированный граф без петель и кратных ребер задан матрицей смежности. Требуется определить, является ли этот граф деревом.
	Входные данные
Во входном файле INPUT.TXT записано сначала число N - количество вершин графа (от 1 до 100). Далее записана матрица смежности размером
N×N, в которой 1 обозначает наличие ребра, 0 - его отсутствие. Матрица симметрична относительно главной диагонали.
	Выходные данные
В выходной файл OUTPUT.TXT выведите сообщение YES, если граф является деревом, и NO в противном случае.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1	3
0 1 0
1 0 1
0 1 0			YES			*/

import java.util.*;
import java.io.*;

class VertixL {
	boolean isVisitedPreviousStep;
	int number;
	
	public VertixL(boolean isVisitedPreviousStep, boolean isVisitedCurrentStep, int number) {
		this.isVisitedPreviousStep = isVisitedPreviousStep;
		this.number = number;
	}
}

public class acmp_0141_Graph_Tree	{
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	short N_Vertix = sc.nextShort();
	System.out.println("N_Vertix = " + N_Vertix );
	String result = "YES";
	
	/* Граф является деревом, если граф - связный и в графе отсутствуют циклы. 
	 Идея такая:
		 1) Проверяем граф на связность ДФС'ом и находим кол-во ребер.
		 2) Если граф связный и кол-во ребер равно n - 1, то выводим YES, иначе NO
		 */
	
	ArrayList<VertixL> listOfVertix = new ArrayList<VertixL>();
	for (int i = 0; i<N_Vertix; i++) {
		listOfVertix.add(new VertixL(false, false, i));
	}
	
	int numberOfEdge = 0;
    int[][] graph = new int[N_Vertix + 1][N_Vertix + 1];
    for (int i = 1; i<=N_Vertix; i++) {
    	for (int j = 1; j<=N_Vertix; j++) {
    		graph[i][j] = sc.nextInt();
    		if (graph[i][j] != 0) numberOfEdge++;
    		}
    }
    System.out.println(" numberOfEdge = " + numberOfEdge);
    
    if (numberOfEdge/2 == N_Vertix -1) {
    	System.out.println("Граф не имеет циклов");
    	
	    System.out.println("Граф на входе");
		for (int i = 1; i < graph.length; i++) {
		   for (int j = 1; j < graph.length; j++)  	{
			   System.out.print(graph[i][j] + " \t");}
		   System.out.println();}
		
		ArrayList<Integer> listOfFoundVertix = new ArrayList<Integer>();
		
		ArrayList<VertixL> stack = new ArrayList<VertixL>();
		
		stack.add(listOfVertix.get(0));
		listOfVertix.get(0).isVisitedPreviousStep = true;
		
		while (stack.isEmpty() == false) {
			for (int i = 0; i<stack.size(); i++) System.out.print(stack.get(i).number + 1 + " - ");
			System.out.println();
			VertixL currentVertix = stack.get(stack.size()-1);
			
			boolean isNeighboorVertix = false;
			for (int j = 1; j < graph.length; j++) {
	//				System.out.println("данная вершина уже ранее находилась");
				if ((graph[currentVertix.number + 1][j] !=0) && (listOfVertix.get(j-1).isVisitedPreviousStep == false)) {
					isNeighboorVertix = true;
					break;
				}
			}
			
			if (isNeighboorVertix == true)  {
				for (int j = 1; j < graph.length; j++) {
					if ((graph[currentVertix.number + 1][j] !=0) && (listOfVertix.get(j-1).isVisitedPreviousStep == false)) {
						stack.add(listOfVertix.get(j-1));
						listOfVertix.get(j-1).isVisitedPreviousStep = true;
						break;
					}
				}
			}
			else {
				listOfFoundVertix.add(stack.get(stack.size()-1).number);
				stack.remove(stack.get(stack.size()-1));
			}
		}
		System.out.println("listOfFoundVertix");
		System.out.println(listOfFoundVertix);
		if (listOfFoundVertix.size() == N_Vertix) System.out.println("Все вершины найдены");
		else {
			System.out.println("Не все вершины найдены");
			result = "NO";
		}
    }
    else {
    	System.out.println("Граф имеет циклы или является не связанным (есть не связанные вершины");
    	result = "NO";
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




