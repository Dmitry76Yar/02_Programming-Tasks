package f03_ACMP_51_100;

/*		Фонарики		(Время: 1 сек. Память: 16 Мб Сложность: 31%)
«Одна голова хорошо, а две лучше. Одна лампочка хорошо, а две лучше!» - подумал Миша, и решил собрать фонарик с двумя
лампочками. Теперь он хочет узнать, насколько фонарик с двумя лампочками лучше, чем фонарик с одной. Заметим, что лампочки в
фонаре с двумя лампочками отличаются от лампочки в фонаре с одной лампочкой. Для этого Миша посветил фонариком на стену, и
каждая из лампочек осветила на ней круг.
	Эффективность фонарика Миша хочет оценить через площадь освещенной части стены. Миша догадался измерить координаты
центров освещенных кругов и их радиусы (которые оказались одинаковыми). Причем, площадь, освещаемая фонариком с одной
лампочкой известна, т.к. описана в документации, прилагаемой к фонарику. Но что делать дальше он не знает. Напишите программу,
которая поможет Мише.
	Входные данные
В первых двух строчках входного файла INPUT.TXT содержатся координаты (x1,y1) и (x2,y2) - центры кругов от лампочек
собранного Мишей фонарика. В третьей строке задан радиус r описанных выше кругов, а четвертая строка содержит площадь
освещения s фонариком из одной лампочки. Все числа целые и удовлетворяют следующим ограничениям: 1 ≤ x1,y1,x2,y2,r ≤ 100,
1 ≤ s ≤ 105. Так же заметим, что площади, освещаемые разными фонариками, отличаются друг от друга более чем на 10-3.
	Выходные данные
В выходной файл OUTPUT.TXT выведите «YES», если Мишин фонарик лучше старого (т.е. освещает большую площадь) и «NO» в
противном случае.
Примеры
№	INPUT.TXT	OUTPUT.TXT
1	1 2
	3 4
	2
	22				YES
2	1 1
	100 100
	1
	7				NO	 */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class acmp_0055_geom_Cycles_peres {
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int x1 = sc.nextInt(); 		int y1 = sc.nextInt();
	int x2 = sc.nextInt(); 		int y2 = sc.nextInt();
	int r = sc.nextInt(); 		int S = sc.nextInt();
	sc.close();
	System.out.println(" x1 = " + x1 + ",  y1 = " + y1 + " x2 = " + x2 + ",  y2 = " + y2);
	System.out.println(" r = " + r + ",  S = " + S);
	
	/* AB = √(xb - xa)2 + (yb - ya)2 + (zb - za)2 		Расстояние между точками  */
	double rast =  Math.sqrt(Math.pow((x1 - x2), 2.0) + Math.pow((y1 -y2), 2.0));
	System.out.println(rast);
	
	double Area = 0.0; 
	
		// Circles do not overlap
	if (rast > 2*r ) {
		Area = 2*Math.PI*r*r; }
	
		//Circle1 is completely inside circle0
	else if (rast == 0) {
		Area = Math.PI*r*r;	}
	
		// Circles partially overlap
	else {
		// https://abakbot.ru/online-2/73  - Площадь пересечения окружностей S2
		// https://askdev.ru/q/ploschad-peresecheniya-dvuh-okruzhnostey-261893/
		double F = 2*Math.acos(rast/(2*r));
		double S2 = r*r*(F-Math.sin(F));
		System.out.println("F = " + F);
		System.out.println("S2 = " + S2);
		
		// Площадь круга
		double Total_Area = Math.PI*r*r; 
		System.out.println("Площадь одного круга (от одной лампочки)  = " + Total_Area);
		Area = 2*Total_Area - S2;
		System.out.println("Площадь двух кругоа (от двух лампочек) за вычетом пересечения =   " + Area);}
	
	String result;
	if (Area > S) result = "YES";
	else result = "NO";
	System.out.println(result);

	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(result);
	pw.close();
}
}
