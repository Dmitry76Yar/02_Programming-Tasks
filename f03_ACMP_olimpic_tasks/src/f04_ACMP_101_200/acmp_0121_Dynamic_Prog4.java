package f04_ACMP_101_200;
/*	Гвоздики	(Время: 1 сек. Память: 16 Мб Сложность: 34%)
На прямой дощечке вбиты гвоздики. Любые два гвоздика можно соединить ниточкой. Требуется соединить некоторые пары гвоздиков ниточками
так, чтобы к каждому гвоздику была привязана хотя бы одна ниточка, а суммарная длина всех ниточек была минимальна.
	Входные данные
В первой строке входного файла INPUT.TXT записано число N - количество гвоздиков (2 ≤ N ≤ 100). В следующей строке записано N чисел
- координаты всех гвоздиков (неотрицательные целые числа, не превосходящие 10000).
	Выходные данные
В выходной файл OUTPUT.TXT нужно вывести единственное число - минимальную суммарную длину всех ниточек.
	Пример
№	INPUT.TXT			OUTPUT.TXT
1	6
	3 4 12 6 14 13			5*/

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0121_Dynamic_Prog4 {
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	int inputArray[] = new int[N];
	
	for (int i = 0; i<N; i++) inputArray[i] = sc.nextInt();
		
	Arrays.sort(inputArray);
	System.out.println(Arrays.toString(inputArray));
	
	int sum = 0;
	int result[] = new int [N];		// result[i] - это минимальное расстояние от 0-го до i-го гвоздя
	
	if ((N==2) || (N==3)) sum = inputArray[N-1] - inputArray[0];
	else {
		result[0] = 0;
		result[1] = inputArray[1] - inputArray[0];		// Если 2 гвоздя, то они связаны нитью и result[1] = растояние между ними
		result[2] = inputArray[2] - inputArray[0];		// Если 3 гвоздя, то 1-ый и 3-ий связаны нитью и result[2] = растояние между 1-ым и 3-им
		for (int i = 3; i<N; i++) {
			/* На примере 5-го гвоздя (4-го при нумерации с нуля, как у нас в матрице)
			 
			ПЕРВЫЙ ВАРИАНТ - 1-ый и 4-ий гвозди связаны между собой одной или несколькими нитями с минимальной суммарной длиной, а 
			5-ый гвоздь связан с 4-им гвоздем   - по сути  5-ый гвоздь связан нитью с 4-ым и 3-им гвоздями, как минимум
			Тогда миним.длина нити для первых 5 гвоздей будет равно миним.длине для первых 4-х гвоздей + раст. между 5-ым и 4-ым гвоздями
			То есть result[5] = result[4] + inputArray[5] - inputArray[4];  
			 */
		int a = result[i-1] + inputArray[i] - inputArray[i-1];
		
			/*
			ВТОРОЙ ВАРИАНТ - 1-ый и 3-ий гвозди связаны между собой одной или несколькими нитями с минимальной суммарной длиной, а
			5-ый гвоздь связан с 4-им гвоздем   - по сути  5-ый гвоздь связан нитью только с 4-ым
			Тогда миним.длина нити для первых 5 гвоздей будет равно миним.длине для первых 3-х гвоздей + раст. между 5-ым и 4-ым гвоздями
			То есть result[5] = result[3] + inputArray[5] - inputArray[4];  
			 */
		int b = result[i-2] + inputArray[i] - inputArray[i-1];
			// Нам нужен минимальный из этих двух вариантов
		result[i] = Math.min(a, b);
		}
		sum = result[N-1];
	}
	System.out.println(Arrays.toString(result));
	System.out.println("   RESULT = " + sum);
	
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	out.print(sum);
    out.flush();
    out.close();
	}
}
