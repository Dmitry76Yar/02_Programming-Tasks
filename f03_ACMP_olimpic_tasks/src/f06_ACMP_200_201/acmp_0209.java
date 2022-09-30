package f06_ACMP_200_201;

/* Целые точки	(Время: 1 сек. Память: 16 Мб Сложность: 64%)
Многоугольник (не обязательно выпуклый) на плоскости задан координатами своих вершин. Требуется подсчитать количество точек
с целочисленными координатами, лежащих внутри него (но не на его границе).
	Входные данные
В первой строке входного файла INPUT.TXT содержится N (3≤N≤103) – число вершин многоугольника. В последующих N строках идут
координаты (Xi, Yi) вершин многоугольника в порядке обхода по часовой стрелке. Xi и Yi - целые числа, по модулю не превосходящие
106.
	Выходные данные
Ваша программа должна вывести в выходной файл OUTPUT.TXT одно целое число - ответ на задачу.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	4
	-1 -1
	-1 1
	1 1
	1 -1	1
2	3
	0 0
	0 2
	2 0		0
 */

import java.util.*;
import java.io.*;
import java.nio.charset.Charset;

public class acmp_0209{
public static void main(String[] args) throws IOException {
	BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\JavaTXT\\ACMP_0001\\input.txt"), Charset.forName("UTF-8")));
	String N_str = reader.readLine();
	int N = Integer.parseInt(N_str);
		
	int Array1[][] = new int[N][2];
		
	int k;
	char c;
	int a;
	int i = 0;
	int j = 0;
	StringBuilder numberString = new StringBuilder();
	while(true) {
		k = reader.read();
		if (k != 13 &&  k != 32 && k!=-1) {
			c = (char)k;
			numberString.append(Character.toString(c));
		}
		else  {
			if ((numberString.length() !=0)&&(k!= 45)) {		 
				a = Integer.parseInt(numberString.toString());
				Array1[i][j++] = a;
				if (j == 2) {
				reader.readLine();
				i++; 
				j = 0;
				}
				numberString.delete(0, numberString.length());
		}
		}
		if (i == N) break;
		}
		reader.close();
		
	for (i= 0; i<N; i++) System.out.println(Arrays.toString(Array1[i]));
	
		// находим площадь многоугольника, умноженную на 2 (чтобы не было double)      
		// https://ru.wikipedia.org/wiki/%D0%A4%D0%BE%D1%80%D0%BC%D1%83%D0%BB%D0%B0_%D0%BF%D0%BB%D0%BE%D1%89%D0%B0%D0%B4%D0%B8_%D0%93%D0%B0%D1%83%D1%81%D1%81%D0%B0
    long area = 0;
    for (i =0; i<N-1; i++) {
    	long a1 = (long)Array1[i][0]*Array1[i+1][1];
    	long a2 = (long)Array1[i+1][0]*Array1[i][1];
    	area = area + a1 - a2;
    }
    
    long a1 = (long)Array1[N-1][0]*Array1[0][1];
	long a2 = (long)Array1[0][0]*Array1[N-1][1];
	area = Math.abs(area + a1 - a2);
    System.out.println("Площадь*2 = " + area);
    
    long p = 0; 				// Точки лежащие на гранях многоугольника
    for (i=0; i<N; i++) {	
		// Координаты вершин соседних 
		int x1,x2,y1,y2;
		if (i==(N-1)) {
			x1 = Array1[i][0];
			y1 = Array1[i][1];
			x2 = Array1[0][0];
			y2 = Array1[0][1];
		}
		else {
			x1 = Array1[i][0];
			y1 = Array1[i][1];
			x2 = Array1[i+1][0];
			y2 = Array1[i+1][1];
		}
		x2 = Math.abs(x2-x1);
		y2 = Math.abs(y2-y1);
//		System.out.print("x2 = " + x2 + " \t y2 = " + y2 + "   ");
		
		int min = 0;
		if (x2 == 0) min = Math.abs(y2);
		if (y2 == 0) min = Math.abs(x2);
		if ((x2!=0) && (y2!=0)) {
			if (x2>y2) {
				for (int s=1;s<=y2;s++) 
					if ((x2%s == 0) && (y2%s == 0)) min = s;
			}
			else {
				for (int s=1;s<=x2;s++) 
					if ((x2%s == 0) && (y2%s == 0)) min = s;
			}
		}
		p = p + (long)min - 1;
		System.out.println("\ti = " + i + "\t min = " + min + "  \t p = " + p);
    }
    
    	// Добавляем вершины
    p = p + (long)N;
    System.out.println("p = " + p);
    System.out.println("Точек на сторонах " + p);
    
    long res = 0;
    if (area != 0) res = area - p + 2;
    System.out.println("res = " + res/2);
    

	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	o.print(res/2);
	o.flush();
	o.close();
}
}




