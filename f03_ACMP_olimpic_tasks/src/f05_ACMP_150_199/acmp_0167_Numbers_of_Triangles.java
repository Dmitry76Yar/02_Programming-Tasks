package f05_ACMP_150_199;

/*  Количество треугольников	(Время: 1 сек. Память: 16 Мб Сложность: 51%)
Рассмотрим фигуру, аналогичную показанной на рисунке (большой равносторонний треугольник, составленный из маленьких
равносторонних треугольников). На рисунке приведена фигура, состоящая из 4-х уровней треугольников.
	Требуется написать программу, которая будет определять, сколько всего в ней треугольников (необходимо учитывать не
только "маленькие" треугольники, а вообще все треугольники — в частности, треугольник, выделенный жирным, а также вся
фигура, являются интересующими нас треугольниками).
	Входные данные
Входной файл INPUT.TXT содержит одно число N — количество уровней в фигуре (1 ≤ N ≤ 105).
	Выходные данные
Выходной файл OUTPUT.TXT должен содержать одно число - количество треугольников в такой фигуре.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	1			1
2	2			5
3	4			27 		 */

import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class acmp_0167_Numbers_of_Triangles{
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
//	N=100000;
	// 1000 - 500.500	1000 - 50.005.000    30000 - 450.015.000	40000 - 800.020.000
	// 50000 - 1.250.025.000	60000 - 1.800.030.000	70000 - -1844932296
	
	BigInteger storeSums[] = new BigInteger[N+1];		// Массив для хранения сумм всех чисел до i-го числа
	storeSums[1] = new BigInteger("1");
	for (int i = 2; i<=N; i++) storeSums[i] = storeSums[i-1].add(new BigInteger(Integer.toString(i)));
	System.out.println(storeSums[N]);
	
	BigInteger result = new BigInteger("0");
		// Считаем правильностоящие треугольники
	for (int i = 1; i<=N; i++) result = result.add(storeSums[i]);
//	System.out.println("result для правильностоящих треугольников = " + result);
	
	BigInteger result2 = new BigInteger("0");
		// Считаем перевернутые треугольники
	for (int i =N-1; i>=1; i=i-2) result2 = result2.add(storeSums[i]);
//	System.out.println("result2 для перевернутых треугольников = " + result2);
	
	System.out.println("RESULT = " + (result.add(result2)));
	// Для N=100.000  result = 250006250025000;

	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	o.print(result.add(result2));
	o.flush();
	o.close();
}
}




