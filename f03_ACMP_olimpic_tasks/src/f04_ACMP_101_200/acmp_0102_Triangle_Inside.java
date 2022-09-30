package f04_ACMP_101_200;
	/*		Треугольник и точка		(Время: 1 сек. Память: 16 Мб Сложность: 32%)
В декартовой системе координат на плоскости заданы координаты вершин треугольника и еще одной точки. Требуется написать программу,
определяющую, принадлежит ли эта точка треугольнику.
	Входные данные
В четырех строках входного файла INPUT.TXT находятся пары целых чисел - координаты точек. Числа в первых трех строках - это
координаты вершин треугольника (x1,y1), (x2,y2), (х3,у3), в четвертой строке - координаты тестируемой точки (x4,у4). Все координаты
не превышают 10000 по абсолютной величине.
	Выходные данные
В выходной файл OUTPUT.TXT необходимо вывести слово «In», если точка находится внутри треугольника и «Out» в противном случае.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	0 0
	100 0
	0 100
	100 100			Out
2	0 0
	100 0
	0 100
	10 10			In
3	0 0
	100 0
	0 100
	50 50			In
4	0 0
	100 0
	0 100
	0 0				In
*/	

import java.io.*;
import java.util.Scanner;

public class acmp_0102_Triangle_Inside  {
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int xa = sc.nextInt();		int ya = sc.nextInt();
	int xb = sc.nextInt();		int yb = sc.nextInt();
	int xc = sc.nextInt();		int yc = sc.nextInt();
	int x0 = sc.nextInt();		int y0 = sc.nextInt();		// Тестируемая точка
	
			/* Расчет значения 
		Если все три значения одинакового знака, то точка внутри треугольника, если значение равно нулю, значит точка лежит на стороне треугольника
		В ином случае (если значения различные по знаку) , точка вне треугольник  */
		
		int a = (x0 - xa)*(yb- ya) - (y0 - ya)*(xb-xa);
		int b = (x0 - xb)*(yc- yb) - (y0 - yb)*(xc-xb);
		int c = (x0 - xc)*(ya- yc) - (y0 - yc)*(xa-xc);
		System.out.println("a = " + a + ", b = " + b + ", c = " + c);	
		
		String result = null;
		
		if ((a<=0)&&(b<=0)&&(c<=0)) result = "In";
		else if ((a>=0)&&(b>=0)&&(c>=0)) result = "In";
		else result = "Out";
		System.out.println(result);
			
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
    out.println(result);
    out.flush();
    out.close();
}
}