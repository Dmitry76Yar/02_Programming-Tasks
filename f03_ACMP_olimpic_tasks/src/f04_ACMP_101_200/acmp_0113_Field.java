package f04_ACMP_101_200;
/*		Фермер		(Время: 2 сек. Память: 16 Мб Сложность: 46%)
Фермер решил на своем квадратном участке земли вспахать пашню квадратной формы максимальной площади, т.к. он посчитал, что 
именно квадратная форма пашни наиболее удобна для обработки. Но на его участке присутствуют деревья и хозяйственные постройки,
которые он никуда не хочет переносить, а так же иные места, не пригодные для пашни. Для удобства он составил квадратную карту
местности N×N в форме матрицы и пометил нулями непригодные для пашни зоны, в остальные зоны он поставил единицу.
	Необходимо помочь фермеру определить максимальную площадь пашни.
	Входные данные
В первой строке входного файла INPUT.TXT записано единственное натуральное число N (1 ≤ N ≤ 1000) – длина стороны квадратного
участка фермы. Далее, следует N строк, в каждой из которых находится последовательность (без пробелов) нулей и единиц,
описывающих ферму.
	Выходные данные
В выходной файл OUTPUT.TXT необходимо вывести максимально возможную площадь пашни.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1	7
1101101
1111110
1011100
0011100
1000010
1100111
1001110		9	 */

import java.io.*;

import java.nio.charset.Charset;
import java.util.Arrays;

public class acmp_0113_Field {
public static void main(String[] args) throws IOException {
	BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\JavaTXT\\ACMP_0001\\input.txt"), Charset.forName("UTF-8")));
	String arr[] = reader.readLine().split(" ");
	int N = Integer.parseInt(arr[0]);
	char Field[][] = new char[N][N];
	
	int k1;
	char c;
	for (int i= 0; i <N; i++) {
		for (int j= 0; j <N; j++) {
			k1 = reader.read();
			if ((k1 == 48) ||  (k1 == 49)) {
//				System.out.print("k1 = " + k1);	System.out.println("   c = " + (char)k1);
				c = (char)k1;
				Field[i][j] = c;
			}
			else j--;
			}
//		System.out.println();
		}
	reader.close();
//	for (int i= 0; i <N; i++) System.out.println(Arrays.toString(Field[i]));
//	System.out.println();
	
	int Array[][] = new int [N][N];
	for (int i= 0; i <N; i++) {
		for (int j = 0; j <N; j++) {
			int temp = 0;
			for (int k= j; k <N; k++) {
				if (Field[i][k] == '1') temp++;
				else  break;
			}
//			System.out.println("i = " + i + "   , j = " + j + "   , temp =  " + temp);
			Array[i][j] = temp;
		}
	}
//	for (int i= 0; i <N; i++)  System.out.println(Arrays.toString(Array[i]));
	
	int countRaws = 0;
		int outcome = 0;
		for (int i= 0; i <N; i++) {
			if ((i + outcome) >N) break;
			for (int j = 0; j <N; j++) {
				if ((j + outcome) >N) break;
			
				countRaws = 0;
				int min = N;
				int temp = 0;
				for (int k= i; k <N; k++) {	
					temp = Array[k][j];
					if (min > temp) min = temp;
					if (outcome >= min) break;
					if (k>= (i + min)) break;
					else {
						countRaws++;
//						System.out.println(" k= " + k + " , j  =  " + j + " , Array[k][j] = " + Array[k][j] + "   ,  temp = " + temp + "  , min = " + min);
					} 
				}
//			System.out.println(" i= " + i + "  , j= " + j + "   ,  countRaws = " + countRaws + "    min = " + min);
			if (countRaws > outcome) outcome = countRaws;
//			System.out.println("outcomt = " + outcome);
//			System.out.println();
		}
//		System.out.println();
		
	}
		System.out.println(outcome*outcome);
		
		PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
		out.println(outcome*outcome);
	    out.flush();
	    out.close();
	}
}