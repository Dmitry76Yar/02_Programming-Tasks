package f05_ACMP_150_199;

/*  Только вправо или вниз		(Время: 1 сек. Память: 16 Мб Сложность: 32%)
Игровое поле N×M заполняется целыми числами, одно неотрицательное целое число в каждой клетке. Цель игры состоит в том, чтобы
пройти по любому разрешенному пути от верхнего левого угла до правого нижнего. Целое число в каждой клетке указывает, какой длины
шаг должен быть из текущей клетки. Все шаги могут быть или направо или вниз. Если в результате какого-либо шага игрок покидает
пределы поля, такой шаг запрещается.
	На рис. 1 приведен пример игрового поля 3×4, где сплошная окружность показывает положение начала, а пунктирная окружность
– цель. Рис. 2 показывает три возможных пути от начала до цели для рассматриваемого примера игрового поля, с удаленными
промежуточными числами.
	Только вправо или вниз
Требуется написать программу, которая определит число различных вариантов путей от верхнего левого угла до правого нижнего.
	Входные данные
Входной файл INPUT.TXT содержит в первой строке размеры поля N (1 ≤ N ≤ 70) и M (1 ≤ M ≤ 70). В последующих N строках входного
файла, каждая из которых описывает отдельную строку игрового поля, записаны через пробел по M целых чисел от 0 до 100 – длины шагов
из клеток данной строки.
	Выходные данные
Выходной файл OUTPUT.TXT должен содержать одно число - число различных вариантов путей от верхнего левого угла до правого нижнего.
Для каждого поля будет менее чем 231 различных путей.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1	3 4
	2 1 1 2
	3 2 1 44
	3 1 1 0				3

Отправить решение	 */

import java.util.*;
import java.io.*;

public class acmp_0165_Sposob_routes_Dinamica{
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	int M = sc.nextInt();
	int [][] table = new int[N][M];
	for (int i =0; i<N; i++) 
		for (int j=0; j<M;j++) table[i][j] = sc.nextInt(); 
	table[N-1][M-1] = 1;
	
	int [][] numberAction = new int[N][M];
	int result = 0;
	
	if ((N==1) && (M==1)) result = 1;
	else {
		ArrayList<Integer[]> queue = new ArrayList<Integer[]>();
		ArrayList<Integer[]> queue2 = new ArrayList<Integer[]>();
		queue.add(new Integer[] {0,0});
		numberAction[0][0] = 1;
		
		while (queue.isEmpty() == false) {
			int [][] isVisited = new int[N][M]; 

			while (queue.isEmpty() == false) {
				int x = queue.get(0)[0];
				int y = queue.get(0)[1];
				if (table[x][y] != 0) {
//					System.out.println("Ход из клетки  [" + x + "]["+ y + "]" );
					queue.remove(0);
					if ((x+table[x][y]) <N) {
						if (isVisited[x+table[x][y]][y] == 0) queue2.add(new Integer[] {x+table[x][y], y});
						isVisited[x+table[x][y]][y] = isVisited[x+table[x][y]][y] + numberAction[x][y];
					}
					if ((y+table[x][y]) <M) {
						if (isVisited[x][y+table[x][y]] == 0) queue2.add(new Integer[] {x, y+table[x][y]});
						isVisited[x][y+table[x][y]] = isVisited[x][y+table[x][y]] + numberAction[x][y];
					}
				}
				else queue.remove(0);
			}
			queue.addAll(queue2);
			queue2.clear();
			for (int i =0; i<N; i++) 
				for (int j=0; j<M; j++) numberAction[i][j] = isVisited[i][j];
			result = result + numberAction[N-1][M-1];
//			for (int a =0; a<N; a++) System.out.println(Arrays.toString(isVisited[a]));
		}
	}
			
	System.out.println("result = " + result);
	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	o.print(result);
	o.flush();
	o.close();
}
}