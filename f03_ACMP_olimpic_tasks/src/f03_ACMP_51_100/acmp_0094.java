package f03_ACMP_51_100;
	/*	Принц и дракон		(Время: 1 сек. Память: 16 Мб Сложность: 22%)
Волшебник Мерлин продает волшебные мечи принцам, желающим убить дракона. Основная характеристика меча – число драконьих голов, которые он
срубает за удар. Основная характеристика дракона – число голов, которые он может отрастить за сеанс регенерации. Бои принцев с драконами
всегда протекают одинаково – принц атакует, и прячется за щитом; дракон атакует огненным дыханием и регенерирует; так продолжается до тех пор,
пока после очередного удара у дракона не кончатся головы. Ясно, впрочем, что не каждым мечом можно победить каждого дракона. Заказ,
поступающий Мерлину, всегда содержит число голов дракона и скорость его регенерации. Подсчитайте по известной атакующей силе меча, сможет
ли принц убить такого дракона таким мечом и, если да, то сколько ударов потребуется.
	Входные данные
Единственная строка входного файла INPUT.TXT содержит число N – число голов, которые меч срубает одним ударом. Далее идет число M – 
число голов дракона. За ним идет K – число голов, которые дракон регенерирует за раз (1 ≤ N, M, K ≤ 105). Все числа разделены пробелом.
	Выходные данные
В выходной файл OUTPUT.TXT выведите число ударов, которые необходимо нанести принцу, чтобы убить дракона, если это возможно. Если таким мечом
убить дракона нельзя, то следует вывести «NO».

Примеры
№	INPUT.TXT	OUTPUT.TXT
1	3 6 2			4
2	4 4 5			1
3	5 10 6			NO*/	

import java.io.*;
import java.util.Scanner;

public class acmp_0094  {
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();		// N – число голов, которые меч срубает одним ударом		3	5	15
	int M = sc.nextInt();		// M – число голов дракона									6	10	30
	int K = sc.nextInt();		// K – число голов, которые дракон регенерирует за раз		2	6	6		
	int count = 0;
	
	// 30-15-21  21-6-12 0
	
	System.out.println("N = " + N);
	System.out.println(M);
	System.out.println(K);
	
	String result = null;
	
	if (M<=N) result = "1";
	else {
		if (N > K)  {
			for (int i = 1; i<=(M-N); i = i + (N-K)) count++;
			result = Integer.toString(count + 1); }
		else result = "NO";
	}
	
	System.out.println(result);
	
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
    out.println(result);
    out.flush();
    out.close();
}
}