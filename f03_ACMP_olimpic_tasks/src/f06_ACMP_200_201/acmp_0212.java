package f06_ACMP_200_201;

/* Деревни	 (Время: 1 сек. Память: 16 Мб Сложность: 79%)
В тридесятом государстве есть N деревень. Некоторые пары деревень соединены дорогами. В целях экономии, «лишних» дорог нет, т.е.
из любой деревни в любую можно добраться по дорогам единственным образом.
	Новейшие исследования показали, что тридесятое государство находится в сейсмически опасной зоне. Поэтому глава государства
захотел узнать, какой именно ущерб может принести его державе землетрясение. А именно, он хочет узнать, какое минимальное
число дорог должно быть разрушено, чтобы образовалась изолированная от остальных группа ровно из P деревень такая, что из любой
деревни из этой группы до любой другой деревни из этой группы по-прежнему можно будет добраться по неразрушенным дорогам (группа
изолирована от остальных, если никакая неразрушенная дорога не соединяет деревню из этой группы с деревней не из этой группы).
	Вы должны написать программу, помогающую ему в этом.
	Входные данные
Первая строка входного файла INPUT.TXT содержит два числа: N и P (1 ≤ P ≤ N ≤ 150). Все остальные строки содержат описания дорог,
по одному на строке: описание дороги состоит из двух номеров деревень (от 1 до N), которые эта дорога соединяет. Все числа во
входном файле разделены пробелами и/или переводами строки.
	Выходные данные
В выходной файл OUTPUT.TXT выведите единственное число – искомое количество дорог.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	3 2
	1 2
	3 2			1
2	11 6
	1 2
	1 3
	1 4
	1 5
	2 6
	2 7
	2 8
	4 9
	4 10
	4 11		  2  	   */

import java.util.*;
import java.io.*;

public class acmp_0212{
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
