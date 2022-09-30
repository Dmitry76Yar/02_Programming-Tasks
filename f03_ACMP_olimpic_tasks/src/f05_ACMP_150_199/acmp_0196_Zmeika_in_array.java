	package f05_ACMP_150_199;
/*Спираль		(Время: 1 сек. Память: 16 Мб Сложность: 38%)
Требуется вывести квадрат, состоящий из N×N клеток, заполненных числами от 1 до N2 по спирали (см. примеры).
	Входные данные
Во входном файле INPUT.TXT задано целое число N – размер квадратной матрицы (2 ≤ N ≤ 100).
	Выходные данные
В выходной файл OUTPUT.TXT выведите матрицу, заполненную числами от 1 до N2 по спирали, при этом между числами может быть любое количество пробелов. Не допускается начинать спираль в ином, кроме верхнего левого, углу, закручивать спираль против часовой стрелки или изнутри наружу.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1	3	1 2 3
		8 9 4
		7 6 5
2	4	 1  2  3  4
		12 13 14  5
		11 16 15  6
		10  9  8  7
3	5	 1  2  3  4  5
		16 17 18 19  6
		15 24 25 20  7
		14 23 22 21  8
		13 12 11 10  9	*/

import java.util.*;
import java.io.*;

public class acmp_0196_Zmeika_in_array{
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	N= 3;
	int array[][]= new int[N][N];
		
	int count = 1;
	int circleNumber = 0;
	
	while(count<N*N+1) {
		for (int i = circleNumber; i<N-circleNumber; i++) {
			array[circleNumber][i] = count;
			count++;
		}
		
		for (int i = 1+circleNumber; i<N-circleNumber; i++) {
			array[i][N-1-circleNumber] = count;
			count++;
		}
		
		for (int i = N-1-circleNumber-1; i>=0+circleNumber; i--) {
			array[N-1-circleNumber][i] = count;
			count++;
		}
		
		for (int i = N-circleNumber-2; i>=1+circleNumber; i--) {
			array[i][circleNumber] = count;
			count++;
		}
		circleNumber++;
	}
	for (int i = 0; i<N; i++)	System.out.println(Arrays.toString(array[i]));

	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	for (int i = 0; i<N; i++) {	
		for (int j = 0; j<N; j++) 	o.print(array[i][j] + " ");
		o.print("\n");
	}
    o.flush();
    o.close();
    }
}