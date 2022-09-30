package f05_ACMP_150_199;

/* 	Шахматы - 2	(Время: 1 сек. Память: 16 Мб Сложность: 46%)
Требуется найти число способов расставить на шахматной доске N×N K ладей так, чтобы они не били друг друга. Все ладьи считаются
одинаковыми.
	Входные данные
Во входном файле INPUT.TXT записаны натуральные числа N и K (N, K ≤ 8).
	Выходные данные
В выходной файл OUTPUT.TXT выведите одно целое число – ответ на задачу.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1	8 8			40320		*/

import java.util.*;
import java.io.*;

public class acmp_0156_Combinat_Ladiy	{
	
	static int factorial (int N) {
		int result = 1;
		for (int i=1; i<=N; i++) result = result*i;
		return result;
	}
	
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	int K = sc.nextInt();
	System.out.println("N = " + N + "  K = " + K);
	
	/* Решение
	 Для поля 8*8 и 8 ладьях следующая логика:
	 Каждая ладья должна быть на своей вертикали, чтобы не бить друг друга.
	 У 1-ой ладьи 8 вариантов размещения по горизонталя.
	 У 2-ой ладьи уже остается 7 вариантов горизонтали
	 ответ = 8*7*6*5*4*3*2
	 
	 Для поля 8*8 и 6 ладей
	  Каждая ладья должна быть на своей вертикали, чтобы не бить друг друга.
	 У 1-ой ладьи 8 вариантов размещения по горизонталя.
	 У 2-ой ладьи уже остается 7 вариантов горизонтали
	 ..
	 У 6-ладьи уже  3 варианта горизонтали.
	 Итого 6 горизонталей заняты.
	 Эти 6 горизонталей можно выбрать Р способами = сочетания 6 из 8
	 Сочетания 5 из 8 = 8!/(6!*2!) 
	 Итого ответ = 8*7*6*5*4*3*8!/(6!*2!) 	 *
	 */
	
	int result = 1;
	for (int i=N; i>(N-K); i--) result = result*i;
	
	if (N!=K) result = result*factorial(N)/(factorial(N-K)*factorial(K));
	
	System.out.println("	RESULT = "    + result);
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	out.print(result);
	out.flush();
	out.close();
}
}




