	package f05_ACMP_150_199;
/* Змейка  (Время: 1 сек. Память: 16 Мб Сложность: 40%)
 Требуется заполнить змейкой квадратную матрицу так, как показано на рисунке справа: заполнение происходит с единицы из левого верхнего угла и заканчивается в правом нижнем числом N2, где N – порядок матрицы.
	Входные данные
Во входном файле INPUT.TXT задано натуральное число N – размер квадратной матрицы (N ≤ 100).
	Выходные данные
В выходной файл OUTPUT.TXT выведите матрицу, заполненную числами от 1 до N2 змейкой, при этом между числами может быть любое количество пробелов.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	4			1  3  4 10
				2  5  9 11
				6  8 12 15
				7 13 14 16*/
import java.util.*;
import java.io.*;

public class acmp_0197{
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	N= 4;
	int array2[][]= new int[N][2*N];
	int count = 1;
	
	for (int i = 1; i<2*N; i++) {
		if (i%2 == 0) { 
			if (i<=N)  
				for (int k = i-1; k>=0; k--) 		array2[k][i-1-k] = count++;
			else 
				for (int k = N-1; k>i-N-1; k--) 	array2[k][N-k+(i-N-1)] = count++;
		}
		else {
			if (i<=N)  
				for (int k = 0; k<=i-1; k++) 	array2[k][i-1-k] = count++;
			else 
				for (int k = i-N; k<=N-1; k++) 	array2[k][N-k+(i-N-1)] = count++;
		}
	}
	
	for (int h = 0; h<N; h++)  System.out.println(Arrays.toString(array2[h]));
	System.out.println();
	
	for (int i = 0; i<N; i++) {
		for (int j = 0; j<N; j++) 	System.out.print(array2[i][j] + " ");
		System.out.println();
	}
	
//	for (int i = 0; i<2*N; i++)  System.out.println(Arrays.toString(array2));

	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	for (int i = 0; i<N; i++) {	
		for (int j = 0; j<N; j++) 	o.print(array2[i][j] + " ");
		o.print("\n");
	}
    o.flush();
    o.close();
    }
}