package f03_ACMP_51_100;
	/*		Винни-пух		(Время: 1 сек. Память: 16 Мб Сложность: 41%)
Винни-Пух стоит на прямоугольном поле размером N×M клеток. В каждой клетке растет по одной ягоде. В начальный момент времени он стоит на левой
верхней клетке. Он начинает собирать ягоды по верхнему краю поля. Если он доходит до края поля или до пустой клетки, он поворачивается на 90
градусов вправо и продолжает собирать ягоды. Но дойдя до очередной клетки Винни вспоминает, что его ждет Пятачок, и он уходит с поля.
	Входные данные
В первой строке входного файла INPUT.TXT стоят размеры поляны N и M (0 < N, M ≤ 100) – высота и ширина, во второй числа Y и X 
(0 < Y ≤ N, 0 < X ≤ M) –номера строки и столбца клетки, дойдя до которой Винни-Пух прекращает собирать ягоды.
	Выходные данные
В выходной файл OUTPUT.TXT выведите число ягод, которые соберет Пух.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	1 1
	1 1				1
2	3 3
	2 3				4
3	5 5
	2 3				18
*/	

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0096_spiral  {
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt(); 		// Количество строк
	int M = sc.nextInt(); 		// Количество столбцов
	int Y = sc.nextInt(); 		// Номер строки, где точка 
	int X = sc.nextInt(); 		// Номер столбца, где точка
	
	int[][] Array = new int[N][M];
	for (int i = 0; i<N; i++) System.out.println(Arrays.toString(Array[i]));
	System.out.println();
	
	int i_min = 0;		int i_max = N-1;		int j_min = 0;		int j_max = M-1;
	System.out.println("j_max = " + j_max);
	
	int count = 0;
	boolean exit = true;
	while (true) {
		for (int j = j_min; j<=j_max; j++) {
			count++;
			if ((i_min == Y-1) && (j == X-1)) {
				exit = false;
				break;	}
			Array[i_min][j] = count;  }
		if (exit == false) break;
//		for (int i = 0; i<N; i++) System.out.println(Arrays.toString(Array[i])); System.out.println();
		
		for (int i = i_min+1; i<=i_max; i++) {
			count++;
			if ((i == Y-1) && (j_max == X-1)) {
				exit = false;
				break;	}
			Array[i][j_max] = count;  }
		if (exit == false) break;
//		for (int i = 0; i<N; i++) System.out.println(Arrays.toString(Array[i])); System.out.println();
		
		for (int j = j_max-1; j>=j_min; j--) {
			count++;
			if ((i_max == Y-1) && (j == X-1)) {
				exit = false;
				break;	}
			Array[i_max][j] = count;  }
		if (exit == false) break;
//		for (int i = 0; i<N; i++) System.out.println(Arrays.toString(Array[i])); System.out.println();
		
		for (int i = i_max-1; i>=i_min+1; i--) {
			count++;
			if ((i == Y-1) && (j_min == X-1)) {
				exit = false;
				break;	}
			Array[i][j_min] = count;  }
		if (exit == false) break;
//		for (int i = 0; i<N; i++) System.out.println(Arrays.toString(Array[i])); System.out.println();
//		System.out.println("count = " + count);
		
		i_min++;
		i_max--;
		j_min++;
		j_max--;
	}
	
	for (int i = 0; i<N; i++) System.out.println(Arrays.toString(Array[i])); System.out.println();
	System.out.println("count = " + count);
	
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
    out.println(count);
    out.flush();
    out.close();
}
}
