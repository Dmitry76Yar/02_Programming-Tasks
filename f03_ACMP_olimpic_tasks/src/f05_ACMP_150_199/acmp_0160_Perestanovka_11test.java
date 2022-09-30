package f05_ACMP_150_199;

/* 	Степень перестановки	(Время: 1 сек. Память: 16 Мб Сложность: 46%)
	Требуется вычислить степень заданной перестановки.
	Перестановкой из N элементов называется упорядоченный набор из N различных чисел от 1 до N. Количество различных перестановок
порядка N равно PN = N!
	Пусть у нас есть упорядоченное множество из N элементов. Перестановка задает преобразование этого множества. А именно, она
говорит, что на i место нужно поставить ai элемент множества, где ai - i-тый элемент перестановки.
	Тождественной перестановкой ε называется такая перестановка, которая не меняет порядок элементов множества.
	Степенью перестановки π называется минимальное натуральное число k такое, что πk = ε, то есть перестановка π, применённая k
раз, эквивалентна тождественной перестановке.
	Входные данные
В первой строке входного файла INPUT.TXT записано число 0 < N ≤ 100 - порядок перестановки. Во второй строке записана сама
перестановка.
	Выходные данные
В выходной файл OUTPUT.TXT выведите степень данной перестановки. Гарантируется, что ответ не превышает 109.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1	3
	2 3 1			3		*/

import java.util.*;
import java.io.*;

public class acmp_0160_Perestanovka_11test	{
	
	/* Здесь перестановку проще рассматирвать как некоторое действо, которое в массиве переставляет элементы с места на место. 
	 * Например, перестановка (2 3 1) превращает массив (14 11 18) в массив (18 14 11), а перестановка (3 1 2) вернет полученный массив
	 * в исходный, поэтому она и является обратной, ну на пи пи-1 - это последовательность перестановок, которая должна приводить к
	 *  исходному массиву. 	 */
	
	
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	
	int arr[] = new int[N+1];
	int arr_copy[] = new int[N+1];
	for (int i = 1; i<=N;i++) {
		arr[i] = i;
		arr_copy[i] = i;
	}
	
	System.out.println(Arrays.toString(arr));
	
	int perest[] = new int[N+1];
	for (int i = 1; i<=N;i++) perest[i] = sc.nextInt();
	
	int count = 0;
	while (true) {
		count++;
		int b[] =  new int[N+1];
		for (int i = 1; i<=N;i++) b[perest[i]] = arr[i];
		int breaks = 0;
		for (int i = 1; i<=N;i++) {
			boolean t = false;
			arr[i] = b[i];
			if ((t==false) && (arr[i] == arr_copy[i])) breaks++;
			else t = true;;
		}
		if (breaks == N ) break; 
		System.out.println(Arrays.toString(arr));
		
	}
	System.out.println("count= " + count);
	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	o.print(count);
	o.flush();
	o.close();
}
}




