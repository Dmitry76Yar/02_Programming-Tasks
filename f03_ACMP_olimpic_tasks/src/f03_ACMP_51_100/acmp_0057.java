package f03_ACMP_51_100;
/*	Компьютерная сеть			(Время: 1 сек. Память: 16 Мб Сложность: 28%)
Компания «Маша и медведи» является самым крупным интернет-провайдером во всем лесу. Именно поэтому, с просьбой подключить их к интернету
обратились N поросят. Домики поросят расположены в различных точках (xi, yi). Ближайшая точка подключения расположена в точке (xnet, ynet).
	Для того чтобы подключиться к сети всем N поросятам необходимо:
1. провести провод от точки подключения до домика одного из поросят;
2. от подключенного поросенка провести провода ко всем остальным.
При этом провода могут при необходимости пересекаться.
Поросята платят деньги в зависимости от длины провода. Количество денег у них ограничено и составляет p тугриков. Они хотят определить:
хватит ли им денег на подключение? Так же известно, что единица длины провода стоит c тугриков. Помогите им сделать необходимые расчеты!
	Входные данные
В первой строке входного файла INPUT.TXT находится числа N, с и p – целые числа со следующими ограничениями: 1 ≤ N ≤ 103, 0 ≤ c ≤ 104,
0 ≤ p ≤ 1015 . В следующих N строках находятся координаты домов поросят (xi; yi). В последней строке записаны координаты точки соединения
(xnet, ynet). Все координаты целые и не превосходят 1000 по модулю. Гарантируется, что необходимая для подключения суммарная длина проводов
либо целая, либо отличается от целой более чем на 10-2.
	Выходные данные
В выходной файл OUTPUT.TXT следует вывести «YES», если у поросят достаточно денег для подключения и «NO» в противном случае.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	3 2 6
	0 0
	1 0
	0 1
	-1 0			YES
2	3 1 5
	1 1
	2 2
	3 3
	4 4				NO	 */

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0057 {
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	int c = sc.nextInt();
	long p = sc.nextLong();
	sc.nextLine();
	
	int Array[][] = new int [N][2];
	for (int i = 0; i<N; i++) {
		String str1[] = sc.nextLine().split(" ");
		Array[i][0] = Integer.parseInt(str1[0]);
		Array[i][1] = Integer.parseInt(str1[1]);
	}
	int Xnet = sc.nextInt();
	int Ynet = sc.nextInt();	System.out.println("N = " + N + "   , c = " + c + ",   p = " + p);
	for (int i = 0; i<N; i++) 	System.out.print(Arrays.toString(Array));
	System.out.println("\t Xnet = " + Xnet + "   , Ynet = " + Ynet);
	
		/* AB = √(xb - xa)2 + (yb - ya)2 + (zb - za)2 		Расстояние между точками  */
	double result = Double.MAX_VALUE;
	double temp = 0.0;
	for (int i = 0; i<N; i++) {
		System.out.println();
		temp =  Math.sqrt(Math.pow((Xnet - Array[i][0]), 2.0) + Math.pow((Ynet -Array[i][1]), 2.0));
		System.out.println("Oт точки подсоединения до = " + i + " -го дома=  " + temp);
		for (int j = 0; j<N; j++) {
			temp = temp + Math.sqrt(Math.pow((Array[i][0] - Array[j][0]), 2.0) + 
					Math.pow((Array[i][1] -Array[j][1]), 2.0));
			System.out.println("От " + i + " -го дома до " + j + " -го дома = " + temp);
			if (temp >= result) break;
		}
	if (temp<result) result = temp;
	System.out.println("result = " + result);
	}
	System.out.println(result);
	
	String answer;
	if (result*c >p) answer = "NO";
	else answer = "YES";
	System.out.println(answer);
	
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(answer);
	pw.close();
}
}
