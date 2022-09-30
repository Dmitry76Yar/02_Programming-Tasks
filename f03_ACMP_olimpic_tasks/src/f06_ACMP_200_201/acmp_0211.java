package f06_ACMP_200_201;

/* Игра с фишками  (Время: 1 сек. Память: 16 Мб Сложность: 45%)
  Вы являетесь одним из разработчиков новой компьютерной игры. Игра происходит на прямоугольной доске, состоящей из W×H клеток.\
Каждая клетка может либо содержать, либо не содержать фишку. Важной частью игры является проверка того, соединены ли две фишки
путем, удовлетворяющим следующим свойствам:
	Путь должен состоять из отрезков вертикальных и горизонтальных прямых.
	Путь не должен пересекать других фишек. При этом часть пути может оказаться вне доски. Например:
	Фишки с координатами (1,3) и (4,4) могут быть соединены. Фишки с координатами (2,3) и (5,3) тоже могут быть соединены. А вот
фишки с координатами (2,3) и (3,4) соединить нельзя – любой соединяющий их путь пересекает другие фишки.
	Вам необходимо написать программу, проверяющую, можно ли соединить две фишки путем, обладающим вышеуказанными свойствами, и,
в случае положительного ответа, определяющую минимальную длину такого пути (считается, что путь имеет изломы, начало и конец
только в центрах клеток (или «мнимых клеток», расположенных вне доски), а отрезок, соединяющий центры двух соседних клеток
имеет длину 1).
	Входные данные
Первая строка входного файла INPUT.TXT содержит два натуральных числа: W – ширина доски, H – высота доски (1≤W,H≤75). Следующие
H строк содержат описание доски: каждая строка состоит ровно из W символов: символ «X» (заглавная английская буква «экс»)
обозначает фишку, символ «.» (точка) обозначает пустое место. Все остальные строки содержат описания запросов: каждый запрос
состоит из четырёх натуральных чисел, разделённых пробелами – X1, Y1, X2, Y2, причём 1≤X1,X2≤W, 1≤Y1,Y2≤H. Здесь (X1, Y1)
и (X2, Y2) – координаты фишек, которые требуется соединить (левая верхняя клетка имеет координаты (1,1)). Гарантируется, что эти
координаты не будут совпадать (кроме последнего запроса; см. далее). Последняя строка содержит запрос, состоящий из четырёх
чисел 0; этот запрос обрабатывать не надо. Количество запросов не превосходит 20.
	Выходные данные
Для каждого запроса в выходной файл OUTPUT.TXT необходимо вывести одно целое число на отдельной строке – длину кратчайшего пути,
или 0, если такого пути не существует.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1	5 4
	XXXXX
	X...X
	XXX.X
.XXX.
	2 3 5 3
	1 3 4 4
	2 3 3 4
	0 0 0 0			5
					6
					0   */

import java.util.*;
import java.io.*;

public class acmp_0211{
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int H = sc.nextInt();			// W - ширина доски
	int W = sc.nextInt();			// H - высота доски
	sc.nextLine();
	int table[][] = new int [W+2][H+2];
	
	for (int i = 0; i<W; i++) {
		String str = sc.nextLine();
		for (int j = 0; j<H; j++) {
			if (str.charAt(j) == 'X') table[i+1][j+1] = -1;
			else table[i+1][j+1] = 0;
		}
	}
//	for (int i = 0; i<W+2; i++) System.out.println(Arrays.toString(table[i]));
//	System.out.println();
	
	StringBuilder sb = new StringBuilder();
	while (true) {
		int step = 1;
			// Сохранение заданий (координаты стартовой и финишной точек)
		String str = sc.nextLine();
		int task[] = new int[4];
		String[] str_ar = str.split(" ");
		for (int i = 0; i<4; i++) task[i] = Integer.parseInt(str_ar[i]);
		if ((task[0] == 0) && (task[1] == 0) && (task[2] == 0) && (task[3] == 0)) break;
		
			// Создание копии массива для данного расчетва, затем откат этого массива к исходному
		int tableCur[][] = new int [W+2][H+2];
		for (int i = 0; i<W+2; i++) 
			for (int j = 0; j<H+2; j++) 
				tableCur[i][j] = table[i][j];
//		System.out.println("ТАБЛИЦА ПОСЛЕ ОБНУЛЕНИЯ");
//		for (int i = 0; i<W+2; i++) System.out.println(Arrays.toString(tableCur[i]));
		
		ArrayList<Integer[]> queue = new ArrayList<Integer[]>();
		ArrayList<Integer[]> queue1 = new ArrayList<Integer[]>();
		
//		for (int i = 0; i<W+2; i++) Arrays.fill(tableCur[i], 0);
//		for (int i = 0; i<W+2; i++) System.out.println(Arrays.toString(tableCur[i]));
//		System.out.println();
		
		queue.add(new Integer[] {task[1], task[0]});
		tableCur[task[1]][task[0]] = 1;
		tableCur[task[3]][task[2]] = 0;
		System.out.println("task[0 = " + task[0] + "   task[1 = "  + task[1]);
		
		while (true) {
//			System.out.print("в основной очереди на этом шагу     ");
//			for (int i = 0; i<queue.size(); i++) System.out.print(Arrays.toString(queue.get(i)) + "   "); 
//			System.out.println();
			step++;
			while(!queue.isEmpty()) {
				int x = queue.get(0)[0];
				int y = queue.get(0)[1];
//				System.out.println(" x = " + x + "    y = "  + y);
				queue.remove(0);
				if (((x-1)>=0) && (tableCur[x-1][y] != -1)) {
					if ((tableCur[x-1][y] > step) || (tableCur[x-1][y] == 0)) {
						tableCur[x-1][y] = step;
						queue1.add(new Integer[] {x-1, y});
					}
				}
				if (((x+1)<(W+2)) && (tableCur[x+1][y] != -1)) {
					if ((tableCur[x+1][y] > step) || (tableCur[x+1][y] == 0)) {
						tableCur[x+1][y] = step;
						queue1.add(new Integer[] {x+1, y});
					}
				}
				if (((y+1)<(H+2)) && (tableCur[x][y+1] != -1)) {
					if ((tableCur[x][y+1] > step) || (tableCur[x][y+1] == 0)) {
						tableCur[x][y+1] = step;
						queue1.add(new Integer[] {x, y+1});
					}
				}
				if ((((y-1)>=0)) && (tableCur[x][y-1] != -1)) {
					if ((tableCur[x][y-1] > step) || (tableCur[x][y-1] == 0)) {
						tableCur[x][y-1] = step;
						queue1.add(new Integer[] {x, y-1});
					}
				}
				if ((x == task[3]) && (y == task[2])) {
					queue.clear();
					queue1.clear();
					break;
				}
			}
			queue.addAll(queue1);
			queue1.clear();
//			for (int i = 0; i<W+2; i++) System.out.println(Arrays.toString(tableCur[i]));
//			System.out.println();
			if (queue.isEmpty()) break;
		}
		System.out.println("RESULT = " + (tableCur[task[3]][task[2]] - 1));
		if ((tableCur[task[3]][task[2]] - 1) == -1) sb.append(0 + "\n");
		else sb.append(tableCur[task[3]][task[2]] - 1 + "\n");
	}	
	
	System.out.println("RESULT = " + sb);

	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	o.print(sb);
	o.flush();
	o.close();
}
}
