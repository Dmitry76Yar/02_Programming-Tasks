package f02_ACMP_0_50;
/* 			Статистика			(Время: 1 сек. Память: 16 Мб Сложность: 15%)
Вася не любит английский язык, но каждый раз старается получить хотя бы четверку за четверть, чтобы оставаться ударником. В текущей 
четверти Вася заметил следующую закономерность: по нечетным дням месяца он получал тройки, а по четным – четверки. Так же он помнит,
 в какие дни он получал эти оценки. Поэтому он выписал на бумажке все эти дни для того, чтобы оценить, сколько у него троек и 
 сколько четверок. Помогите Васе это сделать, расположив четные и нечетные числа в разных строчках. Вася может рассчитывать на
 оценку 4, если четверок не меньше, чем троек.
		Входные данные
В первой строке входного файла INPUT.TXT записано единственное число N – количество элементов целочисленного массива (1 ≤ N ≤ 100). 
Вторая строка содержит N чисел, представляющих заданный массив. Каждый элемент массива – натуральное число от 1 до 31. Все элементы 
массива разделены пробелом.
		Выходные данные
В первую строку выходного файла OUTPUT.TXT нужно вывести числа, которые соответствуют дням месяцев, в которые Вася получил тройки,
а во второй строке соответственно расположить числа месяца, в которые Вася получил четверки. В третьей строке нужно вывести «YES», если Вася может рассчитывать на четверку и «NO» в противном случае. В каждой строчке числа следует выводить в том же порядке, в котором они идут во входных данных. При выводе, числа отделяются пробелом.
	Примеры
№	INPUT.TXT				OUTPUT.TXT
1		5					19 31
	4 16 19 31 2			4 16 2
							YES
2		8					29 7 15 17 1
29 4 7 12 15 17 24 1		4 12 24	
							NO			 */
//  ПРИНЯТО САЙТОМ

import java.io.*;
import java.util.Scanner;


public class acmp_0005 {
public static void main(String[] args) throws IOException {
	Scanner sc;
	int Array [];
	int a = 0;
	int n = 0;
	boolean check = true;
	
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	if (sc.hasNextInt() == true) {
		a = sc.nextInt();
		if ((a >=1) & (a<=100)) n= a;}

	if (n!=0) {
		Array = new int[n];
		int j = 0;
		int c = 0;
		while(sc.hasNext()) {
			if (sc.hasNextInt() == true) {
				c = sc.nextInt();
				Array[j] = c;
				j++;	}
			else sc.next();
		}
	
		for (int i = 0; i<Array.length; i++)   	
			if ((Array[i] <1)|(Array[i]>31)) check = false; 
	
		if ((Array.length !=0) & (check != false)) {
			StringBuffer sb_even = new StringBuffer();
			StringBuffer sb_not_even = new StringBuffer();
			for (int number : Array) {
				if (number%2 == 0) sb_even.append(number).append(" ");
				else sb_not_even.append(number).append(" ");}
	System.out.println(sb_even.toString());
	System.out.println(sb_not_even.toString());
	
	PrintWriter pw = null;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.write(sb_not_even.toString() + "\n");
	pw.write(sb_even.toString() + "\n");
	if (sb_even.length() >= sb_not_even.length()) pw.write("YES\n");
	else pw.write("NO\n");
	pw.close();
	}
	else System.out.println("Массив задан неверно");
	}
	else System.out.println("Не правильный ввод числа n");	
			
}
}
