package f02_ACMP_0_50;
/*  Художник		(Время: 1 сек. Память: 16 Мб Сложность: 26%)
Известный художник решил написать новый шедевр. После многих дней усердной работы он захотел исследовать свое творение. Художник
вспомнил, что картина писалась следующим образом: сначала был взят белый холст, имеющий форму прямоугольника шириной w и высотой h.
Затем художник нарисовал на этом холсте n прямоугольников со сторонами, параллельными сторонам холста и вершинами, расположенными в
целочисленных координатах. Помогите художнику определить площадь незакрашенной части холста.
	Входные данные
Первая строка входного файла INPUT.TXT содержит два натуральных числа w и h (1 ≤ w, h ≤ 100). Во второй строке записано целое число 
n (0 ≤ n ≤ 5000) – количество прямоугольников. Следующие n строк содержат информацию о всех прямоугольниках. Каждая строка описывает
один прямоугольник в виде четырех чисел x1, y1, x2, y2 , где (x1, y1) и (x2, y2) – координаты левого верхнего и правого нижнего угла
прямоугольника соответственно.
	Выходные данные
Выведите в выходной файл OUTPUT.TXT одно целое число – площадь незакрашенной части холста.
	Примеры
№	INPUT.TXT		OUTPUT.TXT
1		5 5
		2
		1 1 3 3
		2 2 4 4			18
2		6 7
		3
		0 0 5 5
		1 1 4 4
		2 2 3 3			17 */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0027_error3 {
	
	static void print (String Array[][], int w, int h) {
		for (int i = 0; i <h; i++) System.out.print("\t" + i + "j"); System.out.println();
		for (int i = 0; i <w; i++) {
			System.out.print(i+"i");
			for (int j = 0; j <h; j++) 
				 System.out.print("\t" + Array[i][j]); 
			System.out.println();}
	}
	
public static void main(String[] args) throws IOException {
	String Temp[];
	String Array[][];
	boolean correct_input = true;
	int w = 0;
	int h = 0;
	int n = 0;
	String str = null;
	
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	
	if (sc.hasNextLine()) str = sc.nextLine();
	Temp = str.split(" ");
	if (Temp.length == 2) {
		w = Integer.parseInt(Temp[0]);
		h = Integer.parseInt(Temp[1]); 	}
	else correct_input = false;
	
	if (correct_input) {
		if ((w<1)| (w>100) | (h<1) |(h>100)) correct_input = false; }
		
	if (correct_input) {
		if (sc.hasNextLine()) str = sc.nextLine();
		n = Integer.parseInt(str);
		System.out.println(("n = " + n));
		if ((n<0)| (n>5000)) correct_input = false; }
	System.out.println(correct_input);
	
	if (correct_input) {
		Array = new String[w][h];
		for (int i = 0; i <w; i++) 	Arrays.fill(Array[i], "-");
		
		print(Array, w, h);
		int count = 0;
		while (sc.hasNextLine()) {
			ArrayList<Integer> arrl = new ArrayList<Integer>();
			if (sc.hasNextLine()) str = sc.nextLine();
			Temp = str.split(" ");
			for (int i =0 ; i<Temp.length; i++) 
				arrl.add(Integer.parseInt(Temp[i]));
			if (arrl.size() !=4) correct_input = false;
			if (correct_input == false) break; 
			System.out.println(arrl); 
				// Заполнение ячеек этого квадрата
			int a = arrl.get(0);	
			if (a < 0) a = 0;
			else if (a>w) a = w;
			
			int b = arrl.get(1);	
			if (b < 0) b = 0;
			else if (b>h) b = h;
			
			int c = arrl.get(2);	
			if (c < 0) c = 0;
			else if (c>w) c = w;
			
			int d = arrl.get(3);	
			if (d < 0) d = 0;
			else if (d>h) d = h;
			System.out.println("a = " + a + ", b= " + b + " c= " + c + " d = " +d);
				// Заполнение ячеек этого квадрата
			int i_min = Integer.min(a, c);
			System.out.println("a = "+ a+ "c = " + c + "i_min = " + i_min);
			int i_max = Integer.max(a, c);
			int j_min = Integer.min(b, d);
			int j_max = Integer.max(b, d);
			
			
			for (int i = i_min; i <i_max; i++) 
				for (int j = j_min; j <j_max; j++) 
					Array[i][j] = "X";
			print(Array, w, h);
			System.out.println();
			count++;
			if (count > n) {System.out.println("Кол-во квадратов больше числа n");break; }
			
				// Считаем площадь
			int result = 0;
			for (int i = 0; i <w; i++) 
				for (int j = 0; j <h; j++) 
					if (Array[i][j].equals("-") == true) result++;
			System.out.println(result);
			PrintWriter pw;
			pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
			pw.print(result);
			pw.close();
						
		}
		if (count != n) System.out.println("Кол-во квадратов не совпадает с числом n");
	}
	
}
}
