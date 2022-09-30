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

public class acmp_0115_Dinamyc_Array {
	
	public static int maxAll; 
	
	public static int[][] sumarray (int arr[][], int SumInRaws[][], int SumInCoulmns[][], int N, int M) {
		int result[][] = new int[N][M];
		result[0][0] = arr[0][0];
				
		for (int i = 1; i<N; i++) {
			result[i][0] = result[i-1][0] + arr[i][0];
		}
		for (int j = 1; j<M; j++) {
			result[0][j] = result[0][j-1] + arr[0][j];
		}
		
//		for (int i= 0; i <N; i++) System.out.println(Arrays.toString(result[i]));
//		System.out.println();
		
		for (int i = 1; i<N; i++) {
			for (int j = 1; j<M; j++) {
				result[i][j] = result[i-1][j-1] + SumInRaws[i][j] + SumInCoulmns[i][j] - arr[i][j]; 
			}
		}
//		System.out.println();
//		for (int i= 0; i <N; i++) System.out.println(Arrays.toString(result[i]));
//		System.out.println();
		return result;
	}
		
public static void main(String[] args) throws IOException {
	BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\JavaTXT\\ACMP_0001\\input.txt"), Charset.forName("UTF-8")));
	String arr[] = reader.readLine().split(" ");
	int N = Integer.parseInt(arr[0]);					// Кол-во строк
	int M = Integer.parseInt(arr[1]);					// Кол-во столбцов
//	System.out.println("N = " + N + "   , M = " + M);
	int Array[][] = new int[N][M];
	
	int k1;
	char c;
	int a;
	int i1 = 0;
	int j1 = 0;
	StringBuilder numberString = new StringBuilder();
	while(true) {
		k1 = reader.read();
		if (k1 != 13 &&  k1 != 32 && k1!=-1) {
			c = (char)k1;
			numberString.append(Character.toString(c));
		}
		else  {
			if ((numberString.length() !=0)&&(k1!= 45)) {		// Если строка не пустая (защита от двойного пробела) 
				a = Integer.parseInt(numberString.toString());
				Array[i1][j1++] = a;
				if (j1%M == 0) {
					reader.readLine();
					i1++; 
					j1 = 0;
				}
				numberString.delete(0, numberString.length());
			}
		}
		if (i1 == N) break;
	}
	reader.close();
//	for (int i= 0; i <N; i++) System.out.println(Arrays.toString(Array[i]));
	
	int SumInRaws[][] = new int[N][M];
	for (int k = 0; k < N; k++) {
		for (int l = 0; l < M; l++) {
			if (l == 0) SumInRaws[k][l] = Array[k][l];
			else SumInRaws[k][l] = Array[k][l] + SumInRaws[k][l-1];
		}
	}
//	System.out.println("\t\t\t SumInRaws");
//	for (int m= 0; m <N; m++) System.out.println(Arrays.toString(SumInRaws[m]));
	 
	int SumInCoulmns[][] = new int[N][M];
	for (int k = 0; k < N; k++) {
		for (int l = 0; l < M; l++) {
			if (k == 0) SumInCoulmns[k][l] = Array[k][l];
			else SumInCoulmns[k][l] = Array[k][l] + SumInCoulmns[k-1][l];
		}
	}
//	System.out.println("\t\t\t SumInCoulmns");
//	for (int m= 0; m <N; m++) System.out.println(Arrays.toString(SumInCoulmns[m]));
	
	int ResultArray[][] = sumarray(Array, SumInRaws, SumInCoulmns, N, M);
//	for (int m= 0; m <N; m++) System.out.println(Arrays.toString(ResultArray[m]));
//	System.out.println();
	
	maxAll = -101;
	
	for (int i = 0; i<N; i++) {
		int ResultArray2[][] = new int[N][M];
		for (int k = 0; k<N; k++) {
			for (int l = 0; l<M; l++) {
				ResultArray2[k][l] = ResultArray[k][l];
				if (ResultArray2[k][l] > maxAll) maxAll = ResultArray2[k][l];
			}
		}
		if (i>=1) {
				for (int l = 0; l<M; l++) {
					SumInRaws[i][l] = SumInRaws[i][l] + SumInRaws[i-1][l]; 
				}
			
			for (int k = 0; k<N; k++) {
				for (int l = 0; l<M; l++) {
					ResultArray2[k][l] = ResultArray2[k][l] - SumInRaws[i-1][l];
				}
			}
//			System.out.println("vfd ");
//			for (int m= 0; m <N; m++) System.out.println(Arrays.toString(ResultArray2[m]));
		}
		for (int j = 1; j<M; j++) {
			int temp4 = 0;
			for (int m = i-1; m>=0; m--) temp4 = temp4 + Array[m][j-1];
			
			for (int k = i; k<N; k++) {
				for (int l = j; l<M; l++) {
					if ((i>=1) && (j>=1)) {
						ResultArray2[k][l] = ResultArray2[k][l] - SumInCoulmns[k][j-1]  + temp4;
						if (ResultArray2[k][l] > maxAll) maxAll = ResultArray2[k][l]; 
					}
					else {
						ResultArray2[k][l] = ResultArray2[k][l] - SumInCoulmns[k][j-1];
						if (ResultArray2[k][l] > maxAll) maxAll = ResultArray2[k][l];
					}
				}
			}
//		System.out.println();
//		System.out.println(" i =  " + i + "  , j = " + j);
//		for (int m= 0; m <N; m++) System.out.println(Arrays.toString(ResultArray2[m]));
//		System.out.println();
		}
	}
						
	System.out.println("MaxAll = " + maxAll);
	
//	
//	for (int i= 0; i <N; i++) System.out.println(Arrays.toString(Sumarray[i]));
	      
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
			out.println(maxAll);
		    out.flush();
		    out.close();

     }
 }
