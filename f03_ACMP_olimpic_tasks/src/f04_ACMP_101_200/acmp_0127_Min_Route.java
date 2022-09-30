package f04_ACMP_101_200;
/* Путь	(Время: 1 сек. Память: 16 Мб Сложность: 40%)
В неориентированном графе требуется найти длину кратчайшего пути между двумя вершинами.
	Входные данные
Во входном файле INPUT.TXT записано сначала число N - количество вершин в графе (1 ≤ N ≤ 100). Затем записана матрица смежности
(0 обозначает отсутствие ребра, 1 - наличие ребра). Затем записаны номера двух вершин - начальной и конечной.
	Выходные данные
В выходной файл OUTPUT.TXT выведите длину кратчайшего пути. Если пути не существует, выведите одно число -1.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1	5
	0 1 0 0 1
	1 0 1 0 0
	0 1 0 0 0
	0 0 0 0 0
	1 0 0 0 0
	3 5				3		*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.text.StyledEditorKit.BoldAction;

class Vertix {
	int number;
	boolean isVisited;
	
	public Vertix(boolean isVisited) {
		this.isVisited = isVisited;
	}
}

public class acmp_0127_Min_Route {
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	System.out.println(" N = " + N);
	sc.nextLine();
	
	int matriza_smegn[][] = new int[N][N];
	
	for (int i = 0; i<N; i++) {
		for (int j = 0; j<N; j++) {
			matriza_smegn[i][j] = sc.nextInt();
		}
	}
//	for (int i = 0; i<N; i++)  System.out.println(Arrays.toString(matriza_smegn[i]));
	
	int startVert = sc.nextInt() - 1;
	int endVert = sc.nextInt() - 1;
	System.out.println("startVert = " + startVert + "  endVert = " + endVert);
	
		// Список вершин - для того, чтобы можно было отмечать вершины, котоые уже были посещены
	ArrayList<Vertix> vertList = new ArrayList<Vertix>();
	for (int i = 0; i<N; i++) vertList.add(new Vertix(false));
	
	int step = 0;
	boolean exitWhile = false;
	ArrayList<Integer> arl = new ArrayList<Integer>();
	ArrayList<Integer> arlStep = new ArrayList<Integer>();
	arl.add(startVert);
	vertList.get(startVert).isVisited = true;
	boolean isFoundSolution = true;
	
	while (true) {
		System.out.println(" Enter   " + arl);
		step++;
		for (int k = 0; k<arl.size(); k++) {
			int a = arl.get(k);
			for (int i = 0; i<N; i++) {
				if ((vertList.get(i).isVisited == false) && (matriza_smegn[a][i] == 1)) {
					if (i == endVert) {
						exitWhile = true;
						break; }
					else {
						arlStep.add(i);
						vertList.get(i).isVisited = true;
					}
				}
			}
		}
		if (exitWhile == true)  break;
		arl.clear();
		arl.addAll(arlStep);
		if (arl.isEmpty() == true)  {
			isFoundSolution = false;
			break;
		}
		arlStep.clear();
	}
	if (isFoundSolution == false) step = -1;
	if ((startVert == endVert) || (N==1)) step = 0;
	System.out.println("step =  " + step);
	
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	out.print(step);
    out.flush();
    out.close();
	}
}
