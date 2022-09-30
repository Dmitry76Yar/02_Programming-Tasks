package f03_ACMP_51_100;

/*	Раскраска таблицы умножения		(Время: 1 сек. Память: 16 Мб Сложность: 22%)
Таблицей умножения назовем таблицу размера n строк на m столбцов, в которой на пересечении i-ой строки и j-ого столбца стоит 
число i∙j (строки и столбцы нумеруются с единицы).
	В одной из математических школ было решено провести педагогический эксперимент. Для того, чтобы ученикам было проще
запоминать таблицу умножения, некоторые числа в ней будут покрашены в красный, некоторые - в синий, а некоторые - в зеленый
цвет (оставшиеся числа будут черными).
	Процесс покраски чисел можно условно разбить на четыре этапа. На первом этапе все числа красятся в черный цвет. На втором
- все четные числа красятся в красный цвет, на третьем – все числа, делящиеся на 3, красятся в зеленый цвет, на четвертом -
все числа, делящиеся на 5, красятся в синий цвет.
	Директор школы хочет знать, какое количество картриджей для принтеров необходимо закупить для печати таблиц. Поэтому ему
необходима информация о том, сколько чисел какого цвета будет в одной раскрашенной таблице умножения n на m. Напишите
программу, решающую задачу подсчета соответствующих количеств.
	Входные данные
Входной файл INPUT.TXT содержит два натуральных числа n и m (1 ≤ n,m ≤ 1000).
	Выходные данные
В первой строке выходного файла OUTPUT.TXT выведите количество чисел, покрашенных в красный цвет, во второй - в зеленый, в третьей - в синий, в четвертой - в черный. Следуйте формату, приведенному в примерах.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1	10 10		RED : 21
				GREEN : 39
				BLUE : 36
				BLACK : 4
2	5 2			RED : 5
				GREEN : 2
				BLUE : 2
				BLACK : 1		 */

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0053 {
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int n = sc.nextInt(); 
	int k = sc.nextInt();
	System.out.println(" n = " + n + ",  k = " + k);

	int Array[][] = new int [n+1][k+1];
	int red = 0;
	int green = 0;
	int blue = 0;
//	for (int i = 1; i<=n; i++)
//		for (int j = 1; j<=k; j++) {
//			Array[i][j] = i*j; 
//			if (Array[i][j]%2 ==0) Array[i][j] = -1;
//		}
	
	for (int i = 1; i<=n; i++)
		for (int j = 1; j<=k; j++) {
			Array[i][j] = i*j; 
			if (Array[i][j]%5 ==0) {
				Array[i][j] = -3;
				blue++;	}
			else if (Array[i][j]%3 ==0) {
				Array[i][j] = -2;
				green++;}
			else if (Array[i][j]%2 ==0) { 
				Array[i][j] = -1;
				red++;}
	}
			
	for (int i = 1; i<=n; i++)  System.out.println(Arrays.toString(Array[i]));
		
	String result;
	result = "RED : " + red + "\nGREEN : " + green + "\nBLUE : " + blue + "\nBLACK : " + (n*k - red - green - blue);
	System.out.println(result);
	
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(result);
	pw.close();
}
}
