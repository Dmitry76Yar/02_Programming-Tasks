package f04_ACMP_101_200;
/*Минимальный путь в таблице		(Время: 1 сек. Память: 16 Мб Сложность: 32%)
 * В прямоугольной таблице N×M (в каждой клетке которой записано некоторое число) в начале игрок находится в левой верхней клетке. 
За один ход ему разрешается перемещаться в соседнюю клетку либо вправо, либо вниз (влево и вверх перемещаться запрещено). При проходе
через клетку с игрока берут столько у.е., какое число записано в этой клетке (деньги берут также за первую и последнюю клетки его пути).
	Требуется найти минимальную сумму у.е., заплатив которую игрок может попасть в правый нижний угол.
	Входные данные
Во входном файле INPUT.TXT задано два числа N и M - размеры таблицы (1 ≤ N ≤ 20, 1 ≤ M ≤ 20). Затем идет N строк по M чисел в каждой -
размеры штрафов в у.е. за прохождение через соответствующие клетки (числа от 0 до 100).
	Выходные данные
В выходной файл OUTPUT.TXT выведите минимальную сумму, потратив которую можно попасть в правый нижний угол.
	Пример
№	INPUT.TXT			OUTPUT.TXT
1	3 4
1 1 1 1
5 2 2 100
9 4 2 1						8

2	5 5
1 1 1 1 1
3 100 100 100 100
1 1 1 1 1
2 2 2 2 1
1 1 1 1 1					11
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class queue {
	public int i;
	public int j;
	ArrayList<queue> arl;  
	boolean isVisted[][];
	public queue(int i, int j) {
		this.i = i;
		this.j = j;
	}
	public queue(int N, int M, String a) {
		boolean isVisted[][] = new boolean[N][M];
		this.isVisted = isVisted;
		ArrayList<queue> arl = new ArrayList<queue>();
		this.arl = arl;
	}
	public void add (int i, int j) {
		isVisted[i][j] = true;
		arl.add(new queue(i, j));
	}
	public queue pop ()  {
//		System.out.println("Возврат объекта с  i = " + arl.get(0).i + "   j = " +  arl.get(0).j);
		return arl.remove(0);
	}
	public boolean isEmpty () {
		return arl.isEmpty();
		
	}
}

public class acmp_0120_Route_Queue {
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	int M = sc.nextInt();
	System.out.println(" N = " + N + "   M = " + M);
	int inputArray[][] = new int[N][M];
	
	for (int i = 0; i<N; i++) {
		for (int j = 0; j<M; j++) {
			inputArray[i][j] = sc.nextInt();
		}
	}
//	System.out.println("Исходный массив");
//	for (int i = 0; i<N; i++) System.out.println(Arrays.toString(inputArray[i]));
//	System.out.println();
	
	queue Queue = new queue(N, M, "ddf");
	Queue.add(0, 0);
	System.out.println("mfbf");
	
	int result[][] = new int[N][M];
	result[0][0] = inputArray[0][0];
	
	while(!Queue.isEmpty()) {
		queue Instance = Queue.pop();
		int a = Instance.i;
		int b = Instance.j;
			if ((b+1)<M) {
				if (Queue.isVisted[a][b+1] == false) Queue.add(a, b + 1);
		//		System.out.println("mfbf");
				int temp1 = result[a][b] + inputArray[a][b+1];
				if (result[a][b+1] ==0)  result[a][b+1] = temp1;
				else if (temp1 < result[a][b+1]) result[a][b+1] = temp1;
		//		result[a][b+1] = result[a][b] + inputArray[a][b+1];
			}
			
			if ((a+1)<N) {
				if (Queue.isVisted[a+1][b] == false)  Queue.add(a+1, b);
				int temp2 = result[a][b] + inputArray[a+1][b];
				if (result[a+1][b] ==0) result[a+1][b]  = temp2;
				else if (temp2 < result[a+1][b]) result[a+1][b]  = temp2;
		//		result[a+1][b] = result[a][b] + inputArray[a+1][b];
			}
//			for (int i = 0; i<N; i++) System.out.println(Arrays.toString(result[i]));
//			System.out.println();
		}
//		for (int i = 0; i<N; i++) System.out.println(Arrays.toString(result[i]));
//		System.out.println();
	System.out.println("result = " + result[N-1][M-1]);
	
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	out.print(result[N-1][M-1]);
    out.flush();
    out.close();
	}
}
