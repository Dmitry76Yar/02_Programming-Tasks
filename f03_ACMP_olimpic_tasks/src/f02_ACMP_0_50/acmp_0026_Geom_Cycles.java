package f02_ACMP_0_50;
/*  Две окружности		(Время: 1 сек. Память: 16 Мб Сложность: 17%)
На плоскости даны две окружности. Требуется проверить, имеют ли они хотя бы одну общую точку.
	Входные данные
Входной файл INPUT.TXT состоит из двух строк. На каждой строке записана информация об одной окружности – координаты ее центра x и y 
(целые числа, по модулю не превосходящие 5000) и радиус (целое число 1 ≤ r ≤ 1000).
	Выходные данные
В выходной файл OUTPUT.TXT выведите «YES», если окружности имеют хотя бы одну общую точку, и «NO» в противном случае.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	0 0 2
	0 3 2			YES
2	1 1 1
	4 4 1			NO	 */

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0026_Geom_Cycles {
public static void main(String[] args) throws IOException {
	String Temp[];
	boolean correct_input = true;
	int a = 0;
	String str = null;
	
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	
	if (sc.hasNextLine()) str = sc.nextLine();
	Temp = str.split(" ");
	int Cycle1[] = new int[Temp.length];
	for (int i = 0; i <Temp.length; i++)	Cycle1[i] = Integer.parseInt(Temp[i]);
	
	if (sc.hasNextLine()) str = sc.nextLine();
	Temp = str.split(" ");
	int Cycle2[] = new int[Temp.length];
	for (int i = 0; i <Temp.length; i++)	Cycle2[i] = Integer.parseInt(Temp[i]);
	
	System.out.println(Arrays.toString(Cycle1));
	System.out.println(Arrays.toString(Cycle2));
	
	if ((Cycle1.length != 3) | (Cycle1.length != 3) ) correct_input = false;
	if (correct_input) {
		if ((Math.abs(Cycle1[0]) >5000) | (Math.abs(Cycle2[0]) >5000)) correct_input = false;
		if ((Math.abs(Cycle1[1]) >5000) | (Math.abs(Cycle2[1]) >5000)) correct_input = false;
		if ((Math.abs(Cycle1[2]) <1) | (Math.abs(Cycle1[2]) >1000)) correct_input = false;
		if ((Math.abs(Cycle2[2]) <1) | (Math.abs(Cycle2[2]) >1000)) correct_input = false;
	}			
		System.out.println(correct_input);
	
	/* AB = √(xb - xa)2 + (yb - ya)2 + (zb - za)2 		Расстояние между точками
	Окружности пересекаются, если
	 	 - сумма радиусов превосходит растояние между центами
		 - если одна из них не лежит внутри другой	*/
		
	if (correct_input) {
		double distance_between_centres = 0;
		distance_between_centres = Math.sqrt(Math.pow((Cycle1[0] - Cycle2[0]), 2.0) + Math.pow((Cycle1[1] - Cycle2[1]), 2.0))	;
		System.out.println(distance_between_centres);
		
		String result = null;
		
	// Проверка, чтобы одна не лежала внутри другой
		if ((distance_between_centres + Cycle1[2]) < Cycle2[2]) {
			result = "NO"; 	
			System.out.println("2-ая окружность внутри первой"); 	}
		
		else if ((distance_between_centres + Cycle2[2]) < Cycle1[2]) {
			result = "NO"; 	 
			System.out.println("1-ая окружность внутри второй");		}
		
		else {
		double sum_rad = Cycle1[2] + Cycle2[2];
		if (distance_between_centres > (sum_rad) ) result = "NO";
		else result = "YES";}
		
		System.out.println(result);
		PrintWriter pw;
		pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
		pw.print(result);
		pw.close();
	}
		else System.out.println("Неправильный ввод");
}
}
