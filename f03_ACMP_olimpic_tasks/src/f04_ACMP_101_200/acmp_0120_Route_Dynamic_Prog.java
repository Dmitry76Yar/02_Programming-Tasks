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

public class acmp_0120_Route_Dynamic_Prog {
	
	public static int step (int Array[][], int N, int M){
		int result[][] = new int[N][M];
		result[0][0] = Array[0][0];
		for (int i = 1; i<M; i++) result[0][i] = result[0][i-1] + Array[0][i];
		for (int i = 1; i<N; i++) result[i][0] = result[i-1][0] + Array[i][0];
		
		for (int i = 1; i<N; i++) {
			for (int j = 1; j<M; j++) {
				result[i][j] = result[i-1][j] + Array[i][j];
				int temp = result[i][j-1] + Array[i][j];
				if (temp < result[i][j]) result[i][j] = temp;
//				for (int K = 0; K<N; K++) System.out.println(Arrays.toString(result[K]));
//				System.out.println();
			}
		}
//		for (int i = 0; i<N; i++) System.out.println(Arrays.toString(result[i]));
//		System.out.println();
		return result[N-1][M-1];
	}
	
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

	int result = step(inputArray,N,M);
	System.out.println("result = " + result);
	
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	out.print(result);
    out.flush();
    out.close();
	}
}
