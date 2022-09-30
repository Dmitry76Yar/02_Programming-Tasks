package f03_ACMP_51_100;
/*	N-угольное колесо		(Время: 1 сек. Память: 16 Мб Сложность: 28%)
На одном известном автозаводе страны N-мерики главный инженер-рационализатор внес предложение вместо круглых колес использовать колеса в
форме правильных N-угольников. "При этом", — сказал он, "важным показателем качества такого колеса будет разность между радиусом описанной
окружности и радиусом вписанной окружности." Причем колесо считается качественным, если его показатель качества меньше единицы.
	Задано число N и длина A стороны N-угольного колеса. Необходимо определить: является ли такое колесо качественным.
	Входные данные
Входной файл INPUT.TXT содержит два натуральных числа: N и A (3 ≤ N ≤ 1000, 1 ≤ A ≤ 1000).
	Выходные данные
В выходной файл OUTPUT.TXT выведите «YES», если это качественное колесо и «NO» в противном случае.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1		3 1			YES
2		239 566		NO */

import java.io.*;
import java.util.Scanner;

public class acmp_0069_Geom_N_Ugoln {
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	int A = sc.nextInt();
	
	String result = "ddd";
/*		Центром правильного многоугольника называется точка, равноудаленная от всех его вершин и всех его сторон.
 * 	Растояние от этой точки R  = a(сторона многогольника) / (2*sin(180/n)) = a/(2*sin(Pi/n))   - радиус описанной окужности
 * 	Тогда радиус вписанной окружности равен r=R*cos(Pi/n) */

	double r_opis_okr = A/(2*Math.sin(Math.PI/N));
	double r_vpis_okr = r_opis_okr*Math.cos(Math.PI/N);
	System.out.println(r_opis_okr);
	System.out.println(r_vpis_okr);
	
	if ((r_opis_okr - r_vpis_okr) < 1) result = "YES";
	else result = "NO";
	
	System.out.println(result);
	
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(result);
	pw.close();
}
}
