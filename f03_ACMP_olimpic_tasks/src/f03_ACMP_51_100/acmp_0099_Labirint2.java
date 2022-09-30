package f03_ACMP_51_100;
	/*		Лабиринт		(Время: 1 сек. Память: 16 Мб Сложность: 47%)
	Открыв глаза, Принц Персии обнаружил, что находится на верхнем уровне подземного лабиринта Джаффара. Лабиринт состоит из h 
уровней, расположенных строго друг под другом. Каждый уровень представляет собой прямоугольную площадку, разбитую на m х n участков.
На некоторых участках стоят колонны, поддерживающие потолок, на такие участки Принц заходить не может.
	Принц может перемещаться с одного участка на другой соседний свободный участок того же уровня, так же он может проломить пол под
собой и оказаться уровнем ниже (на самом нижнем уровне пол проломить нельзя). Любое перемещение занимает у Принца 5 секунд.
	На одном из участков нижнего уровня Принца ждет Принцесса. Помогите Принцу найти Принцессу, потратив на это как можно меньше времени.
	Входные данные
В первой строке входного файла INPUT.TXT содержатся натуральные числа h, m и n — высота и горизонтальные размеры лабиринта 
(2 ≤ h, m, n ≤ 50). Далее во входном файле приведены h блоков, описывающих уровни лабиринта в порядке от верхнего к нижнему. 
Каждый блок содержит m строк, по n символов в каждой: «.» обозначает свободный участок, «о» обозначает участок с колонной, «1» 
обозначает свободный участок, в котором оказался Принц в начале своего путешествия, «2» обозначает свободный участок, на котором
томится Принцесса. Символы «1» и «2» встречаются во входном файле ровно по одному разу: символ «1» — в описании самого верхнего
уровня, а символ «2» — в описании самого нижнего. Соседние блоки разделены одной пустой строкой.
	Выходные данные
В выходной файл OUTPUT.TXT выведите минимальное время в секундах, необходимое Принцу, чтобы найти Принцессу. Поскольку добро всегда
побеждает Зло, гарантируется, что Принц может это сделать.
Пример
№	INPUT.TXT	OUTPUT.TXT
1	3 3 3			60
	1..
	oo.
	...

	ooo
	..o
	.oo

	ooo
	o..
	o.2
*/	

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0099_Labirint2  {
public static void main(String[] args) throws IOException {
	BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\JavaTXT\\ACMP_0001\\input.txt"), Charset.forName("UTF-8")));
	String [] a = reader.readLine().split(" ");
	int h = Integer.parseInt(a[0]); 		// Высота лабиринта (количество этажей)
	int m = Integer.parseInt(a[1]); 		// Ширина этажа лабиринта
	int n = Integer.parseInt(a[2]); 		// Длина этажа лабиринта 
	System.out.println("h = " + h + " , m = " + m + " , n = " + n);
	String array[][][] = new String [h][m][n]; 		// m - строка в этаже, n - столбцы в этаже
	int h_start = 0;	 int n_start = 0; 		int m_start = 0;
	int h_end = 0; 		 int n_end = 0; 		int m_end = 0;
	
	for (int k = 0; k<h; k++) {
		for (int i = 0; i<m; i++) {
				String temp[] = reader.readLine().split("");
				for (int l = 0; l<n; l++) {
					if (temp[l].equals("1")) {
						h_start = k;
						m_start = i;
						n_start = l; 
						temp[l] = "s";}
					else if (temp[l].equals("2")) {
						h_end = k;
						m_end = i;
						n_end = l;	
						temp[l] = ".";}
					array[k][i][l] = temp[l];
				}
		}
		if (k != (h - 1)) reader.readLine();
	}
	reader.close();
		
	for (int i = 0; i<h; i++) {
		for (int j = 0; j<m; j++)  System.out.println(Arrays.toString(array[i][j]));
	System.out.println();}
	
//	System.out.println("Координаты принца (старт):   h_start = " + h_start + " ,   n_start = " + n_start + " , m_start = " + m_start);
//	System.out.println("Координаты королевы (финиш): h_end = " + h_end + " ,   n_end = " + n_end + " , m_end = " + m_end);
	
	int step = 0;
	int a_h = h_start;
	int a_m = m_start;
	int a_n = n_start;
	ArrayList<int[]> arl = new ArrayList<int[]>();			// Массив для сохранения координат ячеек, куда был сделан шаг
	ArrayList<int[]> arl2 = new ArrayList<int[]>();
	arl.add(new int[] {a_h, a_m, a_n});
	for (int i = 0; i<arl.size(); i++) System.out.println(Arrays.toString(arl.get(i)));
	
 	while (arl.size()>0) {
			step++;
			String stepString = Integer.toString(step);			
			for (int i = 0; i<arl.size(); i++) {					
				a_h = arl.get(i)[0]; 						// m - строка в этаже, n - столбцы в этаже
				a_m = arl.get(i)[1];
				a_n = arl.get(i)[2];
				if (((a_m-1) >=0) && (array[a_h][a_m-1][a_n].equals("."))) {
					array[a_h][a_m-1][a_n] = stepString;
					arl2.add(new int [] {a_h, a_m-1, a_n });}
				if (((a_m+1) <m) && (array[a_h][a_m+1][a_n].equals("."))) {
					array[a_h][a_m+1][a_n] = stepString;
					arl2.add(new int [] {a_h, a_m+1, a_n });}
				if (((a_n-1) >=0) && (array[a_h][a_m][a_n-1].equals("."))) {
					array[a_h][a_m][a_n-1] = stepString;
					arl2.add(new int [] {a_h, a_m, a_n-1 });}
				if (((a_n+1) <n) && (array[a_h][a_m][a_n+1].equals("."))) {
					array[a_h][a_m][a_n+1] = stepString;
					arl2.add(new int [] {a_h, a_m, a_n+1 });}
				if (((a_h+1) <h) && (array[a_h+1][a_m][a_n].equals("."))) {
					array[a_h+1][a_m][a_n] = stepString;
					arl2.add(new int [] {a_h+1, a_m, a_n});}
				}
			arl.clear();
			arl.addAll(arl2);
			arl2.clear();
			for (int i = 0; i<h; i++) {
				for (int j = 0; j<m; j++)  System.out.println(Arrays.toString(array[i][j]));
			System.out.println();}
 	}
 	int result = Integer.parseInt(array[h_end][m_end][n_end])*5;
 	System.out.println("result = " + result);
	
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
    out.println(result);
    out.flush();
    out.close();
}
}
