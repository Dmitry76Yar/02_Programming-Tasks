package f04_ACMP_101_200;
/*		Прямоугольник		(Время: 1 сек. Память: 16 Мб Сложность: 42%)
Задан целочисленный прямоугольный массив M×N. Необходимо определить прямоугольную область данного массива, сумма элементов
которого максимальна.
	Входные данные
В первой строке входного файла INPUT.TXT записаны два натуральных числа N и M (1 ≤ N, M ≤ 100) – количество строк и столбцов
прямоугольной матрицы. Далее идут N строк по M чисел, записанных через пробел – элементы массива, целые числа, не превосходящие
100 по абсолютной величине.
	Выходные данные
В выходной файл OUTPUT.TXT необходимо вывести целое число – сумму элементов найденного прямоугольного подмассива. Подмассив
должен содержать хотя бы один элемент.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	2 3
	5 0 9
	1 2 7			24
2	4 5
	-7 8 -1 0 -2	20
	2 -9 2 4 -6
	-7 0 6 8 1
	4 -8 -1 0 -6
 */

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;

public class acmp_0116_test12_time_exceed  {
public static void main(String[] args) throws IOException {
	BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\JavaTXT\\ACMP_0001\\input.txt"), Charset.forName("UTF-8")));
	String arr[] = reader.readLine().split(" ");
	int N = Integer.parseInt(arr[0]);					// Кол-во строк
	int M = Integer.parseInt(arr[1]);					// Кол-во столбцов
	
	String str;
	int Field2[][] = new int[N][M];
	for (int i= 0; i <N; i++) {
		str = reader.readLine();
		for (int j= 0; j <M; j++) {
			if (j==0) {
				if (str.charAt(j) == '1') Field2[i][0] = 1;
			}
			else {
				if (str.charAt(j) == '1') Field2[i][j] = Field2[i][j-1] +1;
			}
		}
	}
	reader.close();
	for (int i= 0; i <N; i++) System.out.println(Arrays.toString(Field2[i]));
	System.out.println();
	
	int Field3[][] = new int[N][M];
	int count;
	int min;
	int max = 0;
	int result = 0;
	for (int i= 0; i <N; i++) {
//		if (((N-i)*M) <result) break; 
		for (int j= 0; j <M; j++) {
			count = 0;
			min = Integer.MAX_VALUE;
			max = 0;
			for (int k=i; k <N; k++) {
				if (Field2[k][j] == 0) break;
				else {
					if (Field2[k][j] <min) min = Field2[k][j]; 
					count++;
					int temp = min*count;
					if (max<=temp) max = temp;
//					System.out.println("Field2[k][j] = " + Field2[k][j] + "  , min = " + min + "   ,temp = " + temp + " ,  max = " + max);
				}
			}
			Field3[i][j] = max;
			if (result<max) result = max;
//			System.out.println("\t Field3[" + i + "][" + j + "] = " + Field3[i][j]);
		}
	}
	for (int i= 0; i <N; i++) System.out.println(Arrays.toString(Field3[i]));
	
	System.out.println("result = " + result);
	
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	out.println(result);
    out.flush();
    out.close();
	}
}
