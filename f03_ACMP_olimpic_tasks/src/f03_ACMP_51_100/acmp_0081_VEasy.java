package f03_ACMP_51_100;
	/*	Арбузы
(Время: 0,5 сек. Память: 16 Мб Сложность: 14%)
Иван Васильевич пришел на рынок и решил купить два арбуза: один для себя, а другой для тещи. Понятно, что для себя нужно выбрать арбуз 
потяжелей, а для тещи полегче. Но вот незадача: арбузов слишком много и он не знает как же выбрать самый легкий и самый тяжелый арбуз? 
Помогите ему!
	Входные данные
В первой строке входного файла INPUT.TXT задано одно число N – количество арбузов. Вторая строка содержит N чисел, записанных через пробел.
Здесь каждое число – это масса соответствующего арбуза. Все числа натуральные и не превышают 30000.
	Выходные данные
В выходной файл OUTPUT.TXT нужно вывести два числа через пробел: массу арбуза, который Иван Васильевич купит теще и массу арбуза, который он купит себе.
	Пример
№	INPUT.TXT			OUTPUT.TXT
1	5
	5 1 6 5 9			1 9 */

import java.io.*;
import java.util.Scanner;

public class acmp_0081_VEasy {
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	sc.nextLine();
	String a[] = sc.nextLine().split(" ");
	int input[] = new int[a.length]; 
	for (int i =0; i<a.length; i++) input[i] = Integer.parseInt(a[i]);
	int min = 300000;
	int max = 0;
	for (int i =0; i<a.length; i++) {
		if (input[i] > max) max = input[i];
		if (input[i] < min) min = input[i]; 
	}
	System.out.println(min);
	System.out.println(max);
	

	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(min + " " + max);
	pw.close();
}
}