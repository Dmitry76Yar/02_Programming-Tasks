package f02_ACMP_0_50;
/*  Больше-меньше		(Время: 1 сек. Память: 16 Мб Сложность: 3%)
Одна из основных операций с числами – их сравнение. Мы подозреваем, что вы в совершенстве владеете этой операцией и можете
сравнивать любые числа, в том числе и целые. В данной задаче необходимо сравнить два целых числа.
	Входные данные
В двух строчках входного файла INPUT.TXT записаны числа A и B, не превосходящие по абсолютной величине 2×109.
	Выходные данные
Запишите в выходной файл OUTPUT.TXT один символ "<", если A < B, ">", если A > B и "=", если A=B.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	5
	7				<
2	-7
	-12				>
3	13
	13				=  		 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class acmp_0025_VEasy {
public static void main(String[] args) throws IOException {
	ArrayList<Integer> arrl = new ArrayList<Integer>();
	boolean correct_input = true;
	int a = 0;
	
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	while (sc.hasNext()) 
		if (sc.hasNextInt()) arrl.add(sc.nextInt());		
	
	if ((arrl.size() != 2)) correct_input = false;
	for (int i = 0; i<arrl.size(); i++) 
		if ((Math.abs(arrl.get(i)) > 2000000000))  correct_input = false;
	System.out.println(correct_input);
	System.out.println(arrl);
	
	String result = null;
	if (correct_input) {
		if (arrl.get(0) > arrl.get(1)) result = ">";
		else if (arrl.get(0) < arrl.get(1)) result = "<";
		else result = "=";}
	else System.out.println("Неправильный ввод");
	
	System.out.println(result);
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(result);
	pw.close();
}
}
