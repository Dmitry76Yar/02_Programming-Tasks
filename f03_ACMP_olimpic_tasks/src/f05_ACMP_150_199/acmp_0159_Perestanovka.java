package f05_ACMP_150_199;

/* 	Обратная перестановка		(Время: 1 сек. Память: 16 Мб Сложность: 25%)
	По заданной перестановке требуется определить обратную.
	Перестановкой из N элементов называется упорядоченный набор из N различных чисел от 1 до N. Количество различных перестановок
порядка N равно PN = N!
	Пусть у нас есть упорядоченное множество из N элементов. Перестановка задает преобразование этого множества. А именно, она
говорит, что на i место нужно поставить ai элемент множества, где ai - i-тый элемент перестановки.
	Обратной перестановкой к перестановке π называется такая перестановка π-1, что ππ-1 = π-1π = ε, где ε – тождественная
перестановка. То есть если применить сначала перестановку π, а потом обратную к ней π-1, то в итоге получится такой результат,
как если бы мы эти перестановки не применяли вообще. Такой же результат получится, если сначала применить обратную перестановку
π-1, а потом прямую π.
	Входные данные
В первой строке входного файла INPUT.TXT записано число 0 < N ≤ 20000 - порядок перестановки. Во второй строке записана сама
перестановка.
	Выходные данные
В выходной файл OUTPUT.TXT выведите обратную перестановку.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1	3
	2 3 1		3 1 2		*/

import java.util.*;
import java.io.*;

public class acmp_0159_Perestanovka	{
	
	/* Здесь перестановку проще рассматирвать как некоторое действо, которое в массиве переставляет элементы с места на место. 
	 * Например, перестановка (2 3 1) превращает массив (14 11 18) в массив (18 14 11), а перестановка (3 1 2) вернет полученный массив
	 * в исходный, поэтому она и является обратной, ну на пи пи-1 - это последовательность перестановок, которая должна приводить к
	 *  исходному массиву. 	 */
	
	
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	
	int a[] = new int[N+1];
	for (int i = 1; i<=N;i++) a[i] = sc.nextInt();
	
	int b[] = new int[N+1];
	for (int i = 1; i<=N;i++) b[a[i]] = i; 
	
	for (int i = 1; i<=N;i++) System.out.print(b[i] + "   ");
		
	
	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	for (int i = 1; i<=N;i++) o.print(b[i] + " ");
	o.flush();
	o.close();
}
}




