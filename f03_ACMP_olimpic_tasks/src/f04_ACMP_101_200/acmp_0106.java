package f04_ACMP_101_200;

	/*		Шаблон	(Время: 1 сек. Память: 16 Мб Сложность: 65%)
Будем рассматривать слова из больших английских букв и шаблоны, состоящие из больших английских букв и символов «?» и «*». 
Говорят, что слово подходит под шаблон, если в шаблоне можно заменить каждый символ «?» на большую английскую букву, а каждый
символ «*» - на последовательность (возможно, пустую) больших английских букв, так, чтобы получилось требуемое слово. Требуется
написать программу, определяющую, подходит ли слово под шаблон.
	Входные данные
В первых двух строках входного файла INPUT.TXT записаны шаблон и слово: в одной строке записан шаблон - последовательность больших
английских букв, «?» и «*», в другой - слово, состоящее только из больших английских букв. Обе строки входного файла содержат от 1
до 255 символов.
	Выходные данные
В выходной файл OUTPUT.TXT необходимо вывести слово «YES», если слово подходит под шаблон и «NO» в противном случае.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1	ABBCDA
	A*CDA			YES	*/	

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0106  {
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	int [] Arr = new int [N];
	int count_zero = 0;
	for (int i = 0; i<N; i++)	{
		Arr[i] = sc.nextInt();
		if (Arr[i] == 0) count_zero++;
	}
	int result = 0;
	int count_ones = N - count_zero;
	if (count_zero<= count_ones) result = count_zero;
	else result = count_ones;
	System.out.println(result);
	
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	out.println(result);
    out.flush();
    out.close();
}
}