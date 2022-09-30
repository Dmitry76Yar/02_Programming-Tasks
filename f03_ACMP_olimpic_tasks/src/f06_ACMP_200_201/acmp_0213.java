package f06_ACMP_200_201;

/* Подсчет баллов	(Время: 1 сек. Память: 16 Мб Сложность: 27%)
Решение каждой задачи заочного тура проверяется на наборе заранее заготовленных тестов. По результатам работы программы на
каждом тесте участнику либо начисляются баллы за этот тест (когда программа выдала правильный ответ), либо не начисляются
(когда во время работы программы произошли ошибки или выданный ответ не верен). Тесты могут иметь разную стоимость.
	Дополнительные баллы начисляются участнику, если его программа прошла все тесты.
	Участник может исправлять свое решение, и посылать его на проверку повторно (при этом решение проверяется на том же наборе
тестов). При этом за каждую попытку из количества набранных по задаче баллов вычитается штраф, который равен 0 при 1-й попытке,
а при каждой следующей возрастает на 2 (то есть 2 при второй, 4 — при третьей, 6 — при четвертой и т.д.).
	Из баллов, полученных участником за каждую из попыток (с учетом начисленных штрафов), выбирается максимальный результат,
который и засчитывается как результат данного участника по этой задаче. Это нужно, в частности, для того, чтобы последующие
попытки не ухудшали уже полученный участником результат по задаче.
	Например, если участник делает первую попытку и набирает 10 баллов, его результат по задаче равен 10 баллов. Пусть на второй
попытке участник посылает решение, которое набирает 8 баллов. С учетом штрафа за эту попытку участник имеет 6 баллов, однако
результат команды по задаче остается равным 10. Пусть с 3-й попытки решение набрало 20 баллов, тогда (с учетом штрафа) результат
участника по задаче становится равен 16 баллам. Наконец, пусть с 4-й попытки решение проходит все тесты, тогда участник получает
сумму баллов за все тесты, плюс призовые баллы за прохождение всех тестов, минус 6 баллов штрафа (если, конечно, эта величина
не меньше 16 баллов, которые уже были у данного участника).
	Напишите программу, которая определяет результат данного участника по этой задаче.
	Входные данные
Во входном файле INPUT.TXT записано сначала число N — количество тестов, на которых проверяются решения данной задачи (1≤N≤100).
Далее идет N натуральных чисел, не превышающих 100, — баллы, которые начисляются за прохождение каждого из тестов. Далее идет
целое число из диапазона от 0 до 100 — количество баллов, которое дополнительно начисляется за прохождение всех тестов.
	Далее идет натуральное число M — количество попыток сдачи задачи (1≤M≤100). После чего идет M наборов по N чисел в каждом,
задающих результаты проверки каждой из M попыток сдачи задачи на тестах. 0 обозначает, что соответствующий тест не пройден,
1 — пройден.
	Выходные данные
В выходной файл OUTPUT.TXT выведите M чисел. i-ое число должно соответствовать результату участника после совершения им первых i
попыток.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1	4
1 2 3 4
5
3
0 0 0 0
1 1 1 1
0 1 0 1			0
				13
				13  	   */

import java.util.*;
import java.io.*;

public class acmp_0213{
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
