	package f05_ACMP_150_199;

/* Последовательность	(Время: 1 сек. Память: 16 Мб Сложность: 47%)
Рассмотрим числовую последовательность, первоначально состоящую из двух единиц: 1, 1. Далее на каждом последующем шаге будем
вставлять между соседними элементами их сумму. В примере добавляемые элементы выделены:
	Номер шага	Последовательность
	0				1, 1
	1				1, 2, 1
	2			1, 3, 2, 3, 1
	3			1, 4, 3, 5, 2, 5, 3, 4, 1
Требуется написать программу, которая подсчитает сумму членов последовательности, построенной за K шагов.
	Входные данные
Входной файл INPUT.TXT содержит одно натуральное число K (0 ≤ K ≤ 100) – номер последнего шага.
	Выходные данные
Выходной файл OUTPUT.TXT должен содержать одно натуральное число – сумму элементов последовательности, построенной за K шагов.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	3				28
2	10				59050		*/

	import java.util.*;
	import java.io.*;
	import java.math.*;
	 
	public class acmp_0179{
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
		int K = sc.nextInt();

		BigInteger sum = new BigInteger("4");
		BigInteger increaseOnThisStep = new BigInteger("2");
		for (int i = 2; i<=K; i++) {
			increaseOnThisStep =  increaseOnThisStep.multiply(new BigInteger("3"));
			sum = sum.add(increaseOnThisStep);
		}
		if (K==0) sum = new BigInteger("2");
		else if (K==1) sum = new BigInteger("4");
		
		System.out.println(sum);

		PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
		o.print(sum);
		o.flush();
		o.close();
	}
	}