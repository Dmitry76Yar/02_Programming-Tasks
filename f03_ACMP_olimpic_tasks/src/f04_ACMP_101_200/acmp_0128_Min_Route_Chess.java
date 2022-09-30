package f04_ACMP_101_200;
/* Один конь	(Время: 1 сек. Память: 16 Мб Сложность: 41%)
На шахматной доске N×N в клетке (x1,y1) стоит голодный шахматный конь. Он хочет попасть в клетку (x2,y2), где растет вкусная шахматная
трава. Какое наименьшее количество ходов он должен для этого сделать?
	Входные данные
Входной файл INPUT.TXT содержит пять чисел: N, x1, y1, x2, y2 (5 ≤ N ≤ 20, 1 ≤ x1, y1, x2, y2 ≤ N). Левая верхняя клетка доски имеет
координаты (1,1), правая нижняя - (N,N).
	Выходные данные
В выходной файл OUTPUT.TXT необходимо вывести наименьшее число ходов коня.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1	5
	1 1
	3 1				2						*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.text.StyledEditorKit.BoldAction;

public class acmp_0128_Min_Route_Chess {
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	int x1 = sc.nextInt()-1;
	int y1 = sc.nextInt()-1;
	int x2 = sc.nextInt()-1;
	int y2 = sc.nextInt()-1;
	System.out.println(" N = " + N + "  x1 = " + x1 + " y1 = " + y1 + "  x2 = " + x2 + "  y2 = " + y2);

	boolean ChessDeskIsVisitedCell[][] = new boolean[N][N];
	
	ArrayList<int[]> queue = new ArrayList<int[]>();
	ArrayList<int[]> queueThisStep = new ArrayList<int[]>();
	int[] a = {x1, y1};
	queue.add(a);
	int step = 0;
	boolean exitWhile = false;
	while (true) {
		step++;
		for (int i = 0; i<queue.size(); i++) {
			int b[] = queue.get(i);
			int xst = b[0];
			int yst = b[1];
			
			if (((xst-2) >=0) && ((yst+1) <N) && (ChessDeskIsVisitedCell[xst-2][yst+1] == false)) {
				int b_mas[] = {xst-2, yst+1};
				ChessDeskIsVisitedCell[xst-2][yst+1] = true;
				if (((xst-2) == x2) && ((yst+1) == y2)) { exitWhile = true; break; }
				queueThisStep.add(b_mas);	}
			
			if (((xst-1) >=0) && ((yst+2) <N)  && (ChessDeskIsVisitedCell[xst-1][yst+2] == false)) {
				int b_mas[] = {xst-1, yst+2};
				ChessDeskIsVisitedCell[xst-1][yst+2] = true;
				if (((xst-1) == x2) && ((yst+2) == y2)) { exitWhile = true; break; }
				queueThisStep.add(b_mas);	}
			
			if (((xst+1) <N) && ((yst+2) <N)  && (ChessDeskIsVisitedCell[xst+1][yst+2] == false)){
				int b_mas[] = {xst+1, yst+2};
				ChessDeskIsVisitedCell[xst+1][yst+2] = true;
				if (((xst+1) == x2) && ((yst+2) == y2)) { exitWhile = true; break; }
				queueThisStep.add(b_mas);	}
			
			if (((xst+2) <N) && ((yst+1) <N) && (ChessDeskIsVisitedCell[xst+2][yst+1] == false)) {
				int b_mas[] = {xst+2, yst+1};
				ChessDeskIsVisitedCell[xst+2][yst+1] = true;
				if (((xst+2) == x2) && ((yst+1) == y2)) { exitWhile = true; break; }
				queueThisStep.add(b_mas);	}
			
			if (((xst+2) <N) && ((yst-1)>=0) && (ChessDeskIsVisitedCell[xst+2][yst-1] == false)) {
				int b_mas[] = {xst+2, yst-1};
				ChessDeskIsVisitedCell[xst+2][yst-1] = true;
				if (((xst+2) == x2) && ((yst-1) == y2)) { exitWhile = true; break; }
				queueThisStep.add(b_mas);	}
			
			if (((xst+1) <N) && ((yst-2) >=0) && (ChessDeskIsVisitedCell[xst+1][yst-2] == false)) {
				int b_mas[] = {xst+1, yst-2};
				ChessDeskIsVisitedCell[xst+1][yst-2] = true;
				if (((xst+1) == x2) && ((yst-2) == y2)) { exitWhile = true; break; }
				queueThisStep.add(b_mas);	}
			
			if (((xst-1) >=0) && ((yst-2) >=0) && (ChessDeskIsVisitedCell[xst-1][yst-2] == false)) {
				int b_mas[] = {xst-1, yst-2};
				ChessDeskIsVisitedCell[xst-1][yst-2] = true;
				if (((xst-1) == x2) && ((yst-2) == y2)) { exitWhile = true; break; }
				queueThisStep.add(b_mas);	}
			
			if (((xst-2) >=0) && ((yst-1) >=0) && (ChessDeskIsVisitedCell[xst-2][yst-1] == false)){
				int b_mas[] = {xst-2, yst-1};
				ChessDeskIsVisitedCell[xst-2][yst-1] = true;
				if (((xst-2) == x2) && ((yst-1) == y2)) { exitWhile = true; break; }
				queueThisStep.add(b_mas);	}
		}
		if (exitWhile == true) break;
		queue.clear();
		queue.addAll(queueThisStep);
		queueThisStep.clear();
	}
	
	System.out.println("step = " + step);

	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	out.print(step);
    out.flush();
    out.close();
	}
}
