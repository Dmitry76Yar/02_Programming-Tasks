package f03_ACMP_51_100;
/*	 * Проверка на симпатичность	(Время: 1 сек. Память: 16 Мб Сложность: 28%)
Рассмотрим таблицу, содержащую n строк и m столбцов, в каждой клетке которой расположен ноль или единица. Назовем такую таблицу симпатичной, 
если в ней нет ни одного квадрата 2 на 2, заполненного целиком нулями или целиком единицами.
Задано несколько таблиц. Необходимо для каждой из них выяснить, является ли она симпатичной.
	Входные данные
Первая строка входного файла INPUT.TXT содержит количество t (1 ≤ t ≤ 10) наборов входных данных. Далее следуют описания этих наборов.
Описание каждого набора состоит из строки, содержащей числа n и m (1 ≤ n,m ≤ 100), и n строк, каждая из которых содержит по m чисел,
разделенных пробелами. j-ое число в i+1-ой строке описания набора входных данных - элемент aij соответствующей таблицы. Гарантируется,
что все aij равны либо нулю, либо единице.
	Выходные данные
Для каждого набора входных данных выведите в файл OUTPUT.TXT единственную строку, содержащую слово «YES», если соответствующая таблица
является симпатичной, и слово «NO» - в противном случае.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1	3
1 1
0
4 4
1 0 1 0
1 1 1 0
0 1 0 1
0 0 0 0
3 3
0 0 1
0 0 1
1 1 1			YES
				YES
				N	 */

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0058 {
	
	public static String check(int Array[][]) {
		String answer = "YES";
		for (int i = 0; i<Array.length-1; i++) {
			for (int j = 0; j<Array[i].length-1; j++) {
//				System.out.println("i = " + i + ",   j = " + j);
				if ((Array[i][j] == 0) && (Array[i+1][j] == 0) && (Array[i][j+1] == 0) && (Array[i+1][j+1] == 0)) {
					answer = "NO";
					break; 	}
				if ((Array[i][j] == 1) && (Array[i+1][j] == 1) && (Array[i][j+1] == 1) && (Array[i+1][j+1] == 1)) {
					answer = "NO";
					break; 	}
			}
		}
	return answer;
	}
	
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int t = sc.nextInt();		sc.nextLine();
	StringBuffer sbf = new StringBuffer();
	for (int i = 0; i<t; i++) {
		int N = sc.nextInt(); 
		int M = sc.nextInt();
		sc.nextLine();
		int Array[][] = new int [N][M];
		for (int j = 0; j<N; j++) {
			String str1[] = sc.nextLine().split(" ");
			for (int k = 0; k<M; k++)	Array[j][k] = Integer.parseInt(str1[k]);
		}
		for (int l = 0; l<N; l++) System.out.println(Arrays.toString(Array[l]));
		String result = check(Array);
		System.out.println(result);
		sbf.append(result +"\n");
	}
	String answer = sbf.toString();
	System.out.println(answer);
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(answer);
	pw.close();
}
}
