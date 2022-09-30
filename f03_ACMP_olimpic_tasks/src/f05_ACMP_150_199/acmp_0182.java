	package f05_ACMP_150_199;
/* Прямоугольник - 2	(Время: 1 сек. Память: 16 Мб Сложность: 27%)
Заданы координаты трех вершин прямоугольника. Необходимо определить координаты четвертой вершины.
	Входные данные
Во входном файле INPUT.TXT записаны через пробел координаты трех вершин прямоугольника в произвольном порядке в формате
x1 y1 x2 y2 x3 y3. Все числа целые, не превосходящие 1000 по абсолютной величине.
	Выходные данные
В выходной файл OUTPUT.TXT нужно вывести через пробел координаты четвертой вершины прямоугольника.
		Примеры
№	INPUT.TXT	OUTPUT.TXT
1	0 3 0 0 5 0	5 3
2	1 4 8 3 7 6	2 1*/

import java.util.*;
import java.io.*;
	 
public class acmp_0182{
	
	static int r (Scanner sc) {
		return sc.nextInt();
	}
	
public static void main(String[] args) throws IOException {
	Scanner s = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int x1,y1,x2,y2,x3,y3,xn,yn;
	double a, b, c;
	x1=r(s); 	y1=r(s);
	x2=r(s); 	y2=r(s);
	x3=r(s); 	y3=r(s);
//	System.out.println("x1 = " + x1 + "  y1 = " + y1 + "  x2= " + x2 + "  y2= " + y2 + "   x3 = " + x3 + "  y3 = " + y3);
	
	a = (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
	b = (x1-x3)*(x1-x3) + (y1-y3)*(y1-y3);
	c = (x2-x3)*(x2-x3) + (y2-y3)*(y2-y3);
//	System.out.println("a = " + a + "  b = " + b + "  c= " + c);
	
	xn= yn =0;
	double xC, yC, x4, y4, dx, dy; // Точка центра прямоугольнкика
	x4 = y4 = dx = dy = 0;
	if ((a+b) == c) { 
		xn = x1;
		yn = y1;
		xC = (x2+x3)/2.0;
		yC = (y2+y3)/2.0;
		dx = Math.abs(x1 - xC);
		dy = Math.abs(y1 - yC);
//		System.out.println("xC1 = " + xC + "   yC = " + yC);
		if (xC>x1) x4 = xC + dx;
		else x4 = xC - dx;
		if (yC>y1) y4 = yC + dy;
		else y4 = yC - dy;
	}
	if ((a+c) == b) { 
		xn = x2; 
		yn = y2;
		xC = (x1+x3)/2.0;
		yC = (y1+y3)/2.0;
		dx = Math.abs(x2 - xC);
		dy = Math.abs(y2 - yC);
//		System.out.println("xn = " + xn + "   yn = " + yn);
//		System.out.println("xC2 = " + xC + "   yC = " + yC);
//		System.out.println("dx = " + dx + "   dy = " + dy);
		if (xC>x2) x4 = xC + dx;
		else x4 = xC - dx;
		if (yC>y2) y4 = yC + dy;
		else y4 = yC - dy;
	}
	if ((b+c) == a) { 
		xn = x3; 
		yn = y3;
		xC = (x1+x2)/2.0;
		yC = (y1+y2)/2.0;
		dx = Math.abs(x3 - xC);
		dy = Math.abs(y3 - yC);
//		System.out.println("xC3 = " + xC + "   yC = " + yC);
//		System.out.println("x3 = " + x3 + "   y3 = " + y3);
//		System.out.println("dx = " + dx + "   dy = " + dy);
		if (xC>x3) x4 = xC + dx;
		else x4 = xC - dx;
		if (yC>y3) y4 = yC + dy;
		else y4 = yC - dy;
		}
//	System.out.println("x4 = " + x4 + "   y4 = " + y4);
	System.out.println("x4 = " + (int)x4 + "   y4 = " + (int)y4);
	
	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	o.print((int)x4 + " " + (int)y4);
	o.flush();
	o.close();
	}
}