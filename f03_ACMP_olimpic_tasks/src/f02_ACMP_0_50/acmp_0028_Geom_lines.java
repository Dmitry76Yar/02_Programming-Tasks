package f02_ACMP_0_50;
/*  Симметрия		(Время: 1 сек. Память: 16 Мб Сложность: 19%)
Многие из вас, вероятно, знакомы с понятием симметрии относительно прямой. Пусть на плоскости расположена прямая L и точка A.
Tочка B называется симметричной точке A относительно прямой L, если отрезок АВ перпендикулярен прямой L и делится пополам точкой
пересечения с ней. В частности, если точка А лежит на прямой L, то точка B совпадает с точкой А.
	Задана прямая L, параллельная одной из осей координат, и точка А. Найдите точку В, симметричную А относительно L.
	Входные данные
Первая строка входного файла INPUT.TXT содержит 4 числа: x1, y1, x2, y2 – координаты двух различных точек, через которые проходит прямая L. Вторая строка входного файла содержит 2 числа xA и yA – координаты точки А. Все числа во входном файле целые и не превосходят 108 по модулю.
	Выходные данные
В выходной файл OUTPUT.TXT выведите числа xB и yB – координаты точки B.
Примеры
№	INPUT.TXT	OUTPUT.TXT
1	0 0 0 1
	10 10		-10 10
2	0 0 1 0
	10 10		10 -10				*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0028_Geom_lines {
public static void main(String[] args) throws IOException {
	String paral = null;
	String str = null;
	boolean correct_input = true;
	int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
	int xp = 0, yp = 0;
	
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	if (sc.hasNextLine()) {
		str = sc.nextLine();
		String Temp1[] = str.split(" ");
		if (Temp1.length == 4) {
			int Temp[] = new int[4];
			correct_input = true;
			for (int i = 0; i < 4; i++)	 Temp[i] = Integer.parseInt(Temp1[i]);
			x1 = Temp[0]; y1 = Temp[1]; x2 = Temp[2]; y2 = Temp[3];
		}
		else correct_input = false;
	System.out.println(x1 + " " + y1  + " " +  x2  + " " +  y2);}
	
	if (sc.hasNextLine()) {
		str = sc.nextLine();
		String Temp1[] = str.split(" ");
		if (Temp1.length == 2) {
			int Temp[] = new int[2];
			correct_input = true;
			for (int i = 0; i < 2; i++)	 Temp[i] = Integer.parseInt(Temp1[i]);
			xp = Temp[0]; yp = Temp[1]; 
		}
		else correct_input = false;
		System.out.println(xp + " " + yp);
		}
	
	if (correct_input == true) {
		if ((Math.abs(x1) > 100000000) | (Math.abs(x2) > 100000000) | (Math.abs(y1) > 100000000) |
			(Math.abs(y2) > 100000000)| (Math.abs(xp) > 100000000) | (Math.abs(yp) > 100000000)) correct_input = false;
		if ((x1 == x2) & (y1 == y2)) correct_input = false;
	System.out.println("ss" + correct_input);}
	
	if (correct_input == true) {
		if (x1 == x2) paral = "in paralel to axe Y";
		else if (y1 == y2) paral = "in paralel to axe X";
		else correct_input = false;
	}
	else System.out.println("Input error");
	
	if (correct_input == true) {
  		PrintWriter pw;
		pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
		int dist = 0;
	if (paral == "in paralel to axe X") {			// уравнение прямой y = a;  
     	 if (yp == y1) {pw.print(xp); 	pw.print(" "); 	pw.print(yp);}
     	 else {	
     		 dist = yp -y1; 
     		 pw.print(xp);	pw.print(" "); 	pw.print(y1-dist);}
     		 System.out.println((xp + " aa  " + (y1-dist)));
	}
     if (paral == "in paralel to axe Y") {			// уравнение прямой x= a;
    	 if (xp == x1) {pw.print(xp); 	pw.print(" "); 	pw.print(yp);}
     	 else {
     		 dist = xp - x1;
     		 pw.print(x1-dist);	pw.print(" "); 	pw.print(yp);}
     		 System.out.println((x1-dist) + "  dd " + yp);
     } 
		pw.close();
	}
	else System.out.println("Input error");
	
}
}
