	package f05_ACMP_150_199;
/*Перестановка по номеру	(Время: 1 сек. Память: 16 Мб Сложность: 47%)
Перестановкой из N элементов называется упорядоченный набор из N различных чисел от 1 до N. Количество всех перестановок порядка
N равно PN = N!
	Требуется найти перестановку по ее номеру в лексикографическом порядке (по алфавиту). Например, для N=3 лексикографический
порядок перестановок выглядит следующим образом:
(1,2,3), (1,3,2), (2,1,3), (2,3,1), (3,1,2), (3,2,1).
	Таким образом, перестановка (2,3,1) имеет номер 4 в этой последовательности.
	Входные данные
В первой строке входного файла INPUT.TXT записано число N (1 ≤ N ≤ 12) - количество элементов в перестановке, во второй - число
K (1 ≤ K ≤ N!) - номер перестановки.
	Выходные данные
В выходной файл OUTPUT.TXT выведите через пробел N чисел - искомую перестановку.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1				1
	1	
	1
2	3
	2			1 3 2*/

import java.util.*;
import java.io.*;

public class acmp_0189_Perest{
	static ArrayList<Integer> setOfNumbers = new ArrayList<Integer>();	//  Массив для хранения оставшихся цифр
	static ArrayList<Integer> result  = new ArrayList<Integer>();			//  Массив для записи результа (последовательности цифр)
	
	public static int factor (int N) {
		int res = N;
		for (int i = N-1; i>0; i--) res = res*i;
		return res;
	}
	
	public static int dev(int K, int N) {
//		System.out.println("На входе N = " + N + "  K = " + K);
//		System.out.println("result = " + result);
//		System.out.println("setOfNumbers  = " + setOfNumbers);
		int t = K/factor(N-1);
		int ost = K%factor(N-1);
		int res = setOfNumbers.get(t);
//		System.out.println("K/factor(N-1) =  " + t + " ,  ost = " + ost + " ,  res = " + res);
		result.add(res);
		setOfNumbers.remove((Integer)res);
//		System.out.println("result = " + result);
//		System.out.println("setOfNumbers  = " + setOfNumbers);
		return ost;
	}
	
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	int K = sc.nextInt()-1;
//	N= 4; K = 17;	
	// 1234 1243 1324 1342 1423 1432 
	// 2134 2143 2314 2341 2413 2431
	// 3124 3142 3214 3241 3412 3421      K=17 - 3412    НО НУЖНО ВВОДИТЬ К = 16
	// 4123 4132 4213 4231 4312 4321
	// С каждой цифрой 6 вариантов (6 = (N-1)!)  
	// 17/6 + 1 = 3   - первая цифра это 3-ий символ в 1234 = 3      Остаток от деления 17%6  = 5
	//   Остались цифры 1,2,4
	// 124 142    214 241    412 421
	// 5/2 + 1 = 3   - следующая цифра  - это 3-ий символ в 124 (тройка уже была использована) = 4    Остаток от деления 5%2  = 1
	//   Остались цифры 12
	// 12 21
	// 1/2 = 0  - следующая цифра  - это 1-ий символ в 12 (тройка уже была использована) = 1    Остаток от деления 2%2  = 0
	
	System.out.println("N = " + N + " ,  K = " + K);
	for (int i =1; i<=N; i++)  setOfNumbers.add(i);   //  Массив для хранения оставшихся цифр 
	
	int x = K;
	while (N>=2) {
		x = dev(x, N);
//		System.out.println("dev(K, N) = " + x);
//		System.out.println();
		N--;
	}
	result.add(setOfNumbers.get(0));
	System.out.println("RESULT = " + result);
	
	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	StringBuilder sb = new StringBuilder();
	for (int i = 0; i<result.size(); i++) sb.append(result.get(i) + " ");
	System.out.println(sb.toString());
    o.print(sb.toString());
    o.flush();
    o.close();
    }
}