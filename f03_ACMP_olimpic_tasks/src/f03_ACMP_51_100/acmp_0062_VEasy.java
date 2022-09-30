package f03_ACMP_51_100;
/*	Клетки		(Время: 1 сек. Память: 16 Мб Сложность: 15%)
 Известно, что шахматная доска имеет размерность 8х8 и состоит из клеток 2х цветов, например, черного и белого (см. рисунок). Каждая клетка
имеет координату, состоящую из буквы и цифры. Горизонтальное расположение клетки определяется буквой от A до H, а вертикальное – цифрой от 1
до 8. Заметим, что клетка с координатой А1 имеет черный цвет. Требуется по заданной координате определить цвет клетки.
	Входные данные
В единственной строке входного файла INPUT.TXT записана координата клетки на шахматной доске: всего два символа – буква и цифра (без
пробелов).
	
Выходные данные
В выходной файл OUTPUT.TXT нужно вывести «WHITE», если указанная клетка имеет белый цвет и «BLACK», если она черная.
	
Примеры
№	INPUT.TXT	OUTPUT.TXT
1	C3				BLACK
2	G8				WHITE */

import java.io.*;
import java.util.Scanner;

public class acmp_0062_VEasy {
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	String str = sc.nextLine();
	sc.close();
	String a_str = str.substring(0,1);
		int a = 0; 
		if (a_str.equals("A")) a = 1;
		if (a_str.equals("B")) a = 2;
		if (a_str.equals("C")) a = 3;
		if (a_str.equals("D")) a = 4;
		if (a_str.equals("E")) a = 5;
		if (a_str.equals("F")) a = 6;
		if (a_str.equals("G")) a = 7;
		if (a_str.equals("H")) a = 8;
	int b = Integer.parseInt(str.substring(1, 2));
	System.out.println(str);
	System.out.println("a = " + a + ",   b = " + b);
	
	String result = null;
	if ((a+b)%2 == 0) result = "BLACK";
	else result = "WHITE";
	System.out.println(result);

	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(result);
	pw.close();
}
}
