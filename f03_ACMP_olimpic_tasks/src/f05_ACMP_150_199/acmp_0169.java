	package f05_ACMP_150_199;

/*  Магазин	(Время: 1 сек. Память: 16 Мб Сложность: 34%)
На расстоянии N шагов от магазина стоит человек. Каждую минуту он выбирает, куда сделать шаг: к магазину или в противоположном
направлении.
	Требуется написать программу, которая определит, сколькими способами он может попасть в магазин, пройдя ровно K шагов и оказавшись
в магазине только после выполнения последнего шага.
	Входные данные
Входной файл INPUT.TXT содержит два числа N и K, записанные через пробел. Известно, что 1 ≤ N ≤ K ≤ 37.
	Выходные данные
Выходной файл OUTPUT.TXT должен содержать одно число – количество способов попадания в магазин.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	2 4				2
2	5 5				1		 */

import java.util.*;
import java.io.*;

public class acmp_0169{
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	int K = sc.nextInt();
	N = 19; K = 20;
	
	int [][] array = new int[K][K];
	array[0][0] = 1;
	if (K>1) {
		array[1][0] = 0; 	array[1][1] = 1;
		
		for (int i=2; i<K; i++) {
			for (int j=0; j<K; j++) {
				if (j==0) array[i][j] = array[i-1][j+1];
				else if (j==(K-1)) array[i][j] = array[i-1][j-1];
				else array[i][j] = array[i-1][j-1] + array[i-1][j+1];
			}
		}
	//	for (int i=0; i<K; i++) System.out.println(Arrays.toString(array[i]));
	}
	System.out.println("result = " + array[K-1][N-1]);
	
	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	o.print(array[K-1][N-1]);
	o.flush();
	o.close();
}
}




