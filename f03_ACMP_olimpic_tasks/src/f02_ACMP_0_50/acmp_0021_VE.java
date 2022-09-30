package f02_ACMP_0_50;
/*  Зарплата		(Время: 1 сек. Память: 16 Мб Сложность: 4%)
В отделе работают 3 сотрудника, которые получают заработную плату в рублях. Требуется определить: на сколько зарплата самого 
высокооплачиваемого из них отличается от самого низкооплачиваемого.
	Входные данные
В единственной строке входного файла INPUT.TXT записаны размеры зарплат всех сотрудников через пробел. Каждая заработная плата – это
натуральное число, не превышающее 105.
	Выходные данные
В выходной файл OUTPUT.TXT необходимо вывести одно целое число — разницу между максимальной и минимальной зарплатой.
	Примеры
№	INPUT.TXT		OUTPUT.TXT
1	100 500 1000	  900
2	36 11 20		  25		 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class acmp_0021_VE {
public static void main(String[] args) throws IOException {
	ArrayList<Integer> arrl = new ArrayList<Integer>();
	boolean correct_input = true;
	int a = 0;
	
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	while (sc.hasNext()) 
		if (sc.hasNextInt()) arrl.add(sc.nextInt());		
	
	if ((arrl.size() != 3)) correct_input = false;
	for (int i = 0; i<arrl.size(); i++) 
		if ((arrl.get(i) >=1) & (arrl.get(i)<=100000))  a++;
		else correct_input = false;
	System.out.println(correct_input);
	System.out.println(arrl);
	
	if (correct_input) {
		int min = 100001, max = 0;
		for (int i = 0; i<arrl.size(); i++) {
			if (arrl.get(i)< min) min = arrl.get(i);
			if (arrl.get(i) > max) max = arrl.get(i);}
		System.out.println(min + "  " + max);
	int result = max - min;
	System.out.println(result);
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(result);
	pw.close();
	}
}
}
