	package f05_ACMP_150_199;
/*Гладкие числа 	(Время: 1 сек. Память: 16 Мб Сложность: 60%)
Назовем число гладким, если его цифры, начиная со старшего разряда, образуют неубывающую последовательность. Упорядочим все
такие числа в возрастающем порядке и присвоим каждому номер.
	Вам требуется по номеру N вывести N-ое гладкое число.
	Входные данные
Во входном файле INPUT.TXT содержится номер N (1 ≤ N ≤ 2147483647).
	Выходные данные
Выходной файл OUTPUT.TXT должен содержать искомое N-е гладкое число.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1		1			1
2		11			12
3		239			1135
*/

import java.util.*;
import java.io.*;

public class acmp_0191_Posled{
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	N = 2147483647   ;
	int K = 41;
	
	// 1 2 3 4 5 6 7 8 9
	// 11 12 13 14 15 16 17 18 19  - 18-ое число
	// 17-ое число - 18, в программе - 18
	// 18-ое число - 19, в программе - 21
	
	StringBuilder sb = new StringBuilder();
if (N<10) sb.append(N);
else {
	int array[][] = new int[K][10];
	int array2[][] = new int[K][10];
	
	for (int i=0; i<9; i++) {
		array[0][i] = 1;
		array2[0][i] = i+1;
	}
	array[0][9] = 9;
	array[1][9] = 45;
	for (int i=0; i<9; i++) {
		array[1][i] = 9-i;
		if (i==0) array2[1][i] = array2[0][8] + array[1][i];
		else array2[1][i] = array2[1][i-1] + array[1][i];
	}
	
	for (int i=2; i<K; i++) {
		int sum = array[i-1][9];
		array[i][0] = array[i-1][9];
		array2[i][0] = array2[i-1][8] + array[i][0];
		for (int j=1; j<9; j++) {
			array[i][j] = array[i][j-1] - array[i-1][j-1];
			array2[i][j] = array2[i][j-1] + array[i][j];
			sum = sum + array[i][j];
		}
		array[i][9] = sum;
//		if (array[i][0].compareTo(new BigInteger("2147483647")) == 1) System.out.println("i = " + i + "    MORE");
	}
	
	for (int f=0; f<K; f++) System.out.println(Arrays.toString(array[f]));
	System.out.println();
	for (int f=0; f<K; f++) System.out.println(Arrays.toString(array2[f]));
	
		// 1111 1112 1113 1114 1115 1116 1117 1118 1119 - 9 
		//  1122 1123 1124 1125 1126 1127 1128 1129 - 17
		//  1133 1134 1135 - 20
		
		// Находим в массиве array2 1-ое число, которое больше заданного N 
		// Позиция такого числа в строке массива - это 1-ая цифра в результирующей последовательности
		// Номер строки такого числа - это кол-во цифр в результирующей последовательности
		// Например, для N = 239, 1-ое число большее его = 384, значит 1-ая цифра = 1, число цифр в последовательности = 4
		/* Далее вычитаем из N
		     - если найденная цифра  k = от 2 до 9, то сумму всех чисел в это же строке array от 1 до k, 
		     - если найденная цифра  k = 1, то сумму всех чисел в предыдущей строке array от 1 до 9, т.е. array[i][10]
		     таким образом убираем все варианты в этом же разряде
		     Число, полученное после вычитания - это новое N
		     Повторяем алгоритм сначала
		 239 -> число между 219 и 384, значит 1-ая цифра = 1 (следующая за 9 с переходом в следующий разряд)
		 239 - 165 = 74    -> число между 54 и 99, значит 2-ая цифра = 1 (следующая за 9 с переходом в следующий разряд)
		 74 - 45 = 29  -> число между 26 и 33, значит 3-ая цифра = 3  (число 26 означает, что до числа 29 макс.26 вариантов, а 29 идет уже в числе 3Х)
		 29- (9+8+7) =  5   -> число 5
		 ИТОГО 1 1 3 5		*/
	int razryad = 0;
	int foundNumber = 0;
	while (true) {
		razryad = 0;
//		System.out.println();
		if (N>2054455633) {
			razryad = 40;
			foundNumber = 0;
		}
		else {
			for (int i=0; i<K; i++) {
				for (int j=0; j<9; j++) {
	//				System.out.println("array2[i][j] =" + array2[i][j]);
					if (array2[i][j]>=N) {
						razryad = i;
						foundNumber = j;
	//					System.out.println("array2[i][j] = " + array2[i][j]);
						break;
					}
				}
				if (razryad !=0) break;
			}
		}
		sb.append(foundNumber+1);
		if (foundNumber == 0) N = N - array[razryad-1][9];
		else {
			int sum = 0;
			for (int i=0; i<=foundNumber; i++) sum = sum + array[razryad][i];
			N = N - sum;
		}
//		System.out.println("razryad = " +  razryad + "    foundNumber = " + foundNumber + "  N = " + N);
		if (razryad == 1) break;
	}
	sb.append(N);
	}

	System.out.println("RESULT = " + sb);
	
	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
    o.print(sb);
    o.flush();
    o.close();
    }
}