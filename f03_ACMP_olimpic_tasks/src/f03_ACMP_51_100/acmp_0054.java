package f03_ACMP_51_100;

/*		Теория игр		(Время: 1 сек. Память: 16 Мб Сложность: 28%)
Одним из интересных объектов, изучаемых в теории игр, являются так называемые антагонистические игры двух лиц. Такие игры
характеризуются множеством X стратегий первого игрока, множеством Y стратегий второго игрока и функцией выигрыша K(x, y) (x
из X, y из Y). Если множества стратегий X и Y конечны, то такую игру принято называть матричной, так как функцию выигрыша K
в этом случае удобно задавать матрицей.
	Рассмотрим матричную игру, в которой X = {1,…,n}, Y = {1,…,m}. Матрицу выигрышей обозначим символом K. Нижним значением
игры назовем число maxi=1..nminj=1..m Kij . Верхним значением игры назовем число minj=1..mmaxi=1..n Kij. Отметим также, что
игры, у которых нижнее и верхнее значение совпадают, называются играми с седловой точкой.
	Задана матрица выигрышей K для некоторой матричной игры. Найдите ее верхнее и нижнее значение.
	Входные данные
Первая строка входного файла INPUT.TXT содержит целые числа n и m (1 ≤ n,m ≤ 100). Далее следуют n строк по m чисел в каждой
j-ое число i-ой строки равно Kij . Все Kij по модулю не превосходят 1000.
	Выходные данные
В выходной файл OUTPUT.TXT выведите нижнее и верхнее значение игры через пробел.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	3 3
	4 -1 -3
	-2 1 3
	0 2 -3			-2 2
2	3 4
	-1 0 2 1
	-2 0 1 0
	2 1 -1 -2		-1 1	 */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class acmp_0054 {
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int n = sc.nextInt(); 
	int m = sc.nextInt();
//	System.out.println(" n = " + n + ",  m = " + m);
	sc.nextLine();
	
	int Array[][] = new int [n][m];
	int i = 0; 
	while (sc.hasNextLine()) {
		String str = sc.nextLine();
		String str_ar[] = str.split(" ");
		for (int j = 0; j<str_ar.length; j++)  	Array[i][j] = Integer.parseInt(str_ar[j]);
		i++;
	}
			
	for (int j = 0; j<n; j++)  System.out.println(Arrays.toString(Array[j]));
	
	ArrayList<Integer> min = new ArrayList<Integer>();
	ArrayList<Integer> max = new ArrayList<Integer>();
	for (i = 0; i<n; i++) {
		int min_i = 9999;
		for (int j = 0; j<m; j++) {
			if (Array[i][j] < min_i) min_i = Array[i][j];
		}
	min.add(min_i);
	}
	for (int j = 0; j<m; j++) {
		int max_j = -9999;
		for (i = 0; i<n; i++) {
			if (Array[i][j] > max_j) max_j = Array[i][j];
		}
	max.add(max_j);
	}
	Collections.sort(min);
	Collections.sort(max);
	System.out.println();
	System.out.println(min);
	System.out.println(max);
	String result = min.get(n-1) + " " + max.get(0);
	System.out.println(result);

	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(result);
	pw.close();
}
}
