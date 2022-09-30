package f05_ACMP_150_199;

/* Сумма кубов	(Время: 1 сек. Память: 16 Мб Сложность: 52%)
Известно, что любое натуральное число можно представить в виде суммы не более чем четырех квадратов натуральных чисел. Вася решил
придумать аналогичное утверждение для кубов - он хочет узнать, сколько кубов достаточно для представления любого числа. Его первая
рабочая гипотеза - восемь.
	Выяснилось, что почти все числа, которые Вася смог придумать, представляются в виде суммы не более чем восьми кубов. Однако
число 239, например, не допускает такого представления. Теперь Вася хочет найти какие-либо другие такие числа, а также, возможно,
какую-либо закономерность в представлениях всех остальных чисел, чтобы выдвинуть гипотезу относительно вида всех чисел, которые не
представляются в виде суммы восьми кубов.
	Помогите Васе написать программу, которая проверяла бы, возможно ли представить данное натуральное число в виде суммы не более
чем восьми кубов натуральных чисел, и если это возможно, то находила бы какое-либо такое представление.
	Входные данные
Во входном файле INPUT.TXT записано натуральное число N (1 ≤ N ≤ 2×109).
	Выходные данные
В выходной файл OUTPUT.TXT выведите не более восьми натуральных чисел в порядке невозрастания, кубы которых в сумме дают N. Если вариантов несколько, то выведите любой. Если искомого представления не существует, то в выходной файл необходимо вывести слово IMPOSSIBLE.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	17			2 2 1
2	239			IMPOSSIBLE
 * 
 */

import java.util.*;
import java.io.*;

// Разложить число на не более 8 кубов. Или выдать, что это невозможно

public class acmp_0154_Rekurs{
		// Массив для сохранения результата разложения, удовлет. условиям
	static ArrayList<Integer> result	 = new ArrayList<Integer>();
		// Прерыватель рекурсии при нахождении разложения 
	static boolean breaks = false;
	
	public static int recurcion (int N, int depth, int arr[]) {
		if (breaks) return 100;
		if (depth>8) return 100;
		if (N == 0) {
			System.out.print("dep" + depth + "   ");
			for (int i =0; i<depth; i++) System.out.print(arr[i] + "->");		System.out.println();
				// Сохраняет найденный вариант в результирующий Arraylist 
			if (depth<=8) for (int i =0; i<depth; i++) result.add(arr[i]); 
			return depth;
		}
		else {	
				// 1260, т.к. ее куб первый куб больший макс.числа 2х109
			for (int i = 1260; i>=1; i-- ) {
				int a = i*i*i;
				if ((a<=N) && (8*a >N)) {
					arr[depth] = i;
					if ((recurcion(N-a, depth+1, arr)) <=8) {
						breaks = true;
						break;
					}
				}
				if (breaks == true) break;
			}
		}
		return 199;
	}
	
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	N = 241;
	
	int arr[] = new int[10];
	recurcion(N, 0, arr);
	System.out.print("N = " + N);
	System.out.println("   result" + result);
	
	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	if (result.size()!=0) for (int i=0; i<result.size(); i++) o.print(result.get(i) +" ");
	else o.print("IMPOSSIBLE");
	o.flush();
	o.close();
}
}




