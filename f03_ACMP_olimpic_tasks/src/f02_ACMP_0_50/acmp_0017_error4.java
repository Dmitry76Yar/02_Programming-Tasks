package f02_ACMP_0_50;
/*		Поле чудес 		(Время: 0,5 сек. Память: 16 Мб Сложность: 31%)
Для игры в «Поле чудес» используется круглый барабан, разделенный на сектора, и стрелка. В каждом секторе записано некоторое число.
В различных секторах может быть записано одно и то же число. Однажды ведущий игры решил изменить правила. Он сам стал вращать 
барабан и называть игроку (который барабана не видел) все числа подряд в том порядке, в котором на них указывала стрелка в процессе 
вращения барабана. Получилось так, что барабан сделал целое число оборотов, то есть последний сектор совпал с первым. После этого, 
ведущий задал участнику вопрос: какое наименьшее число секторов может быть на барабане? Требуется написать программу, отвечающую на 
этот вопрос ведущего.
	Входные данные
В первой строке входного файла INPUT.TXT записано число N – количество чисел, которое назвал ведущий (2 ≤ N ≤ 30000). Во второй 
строке записано N чисел, на которые указывала стрелка в процессе вращения барабана. Первое число всегда совпадает с последним 
(в конце стрелка указывает на тот же сектор, что и в начале). Числа, записанные в секторах барабана – натуральные, не превышающие 
32000.
	Выходные данные
В выходной файл OUTPUT.TXT необходимо вывести одно число – минимальное число секторов, которое может быть на барабане.
	Примеры
№		INPUT.TXT				OUTPUT.TXT
1			13
	5 3 1 3 5 2 5 3 1 3 5 2 5		6
2		4
	1 1 1 1							1
3		4
	1 2 3 1							3

 */

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0017_error4{
public static void main(String[] args) throws IOException {
	Scanner sc; 
	int n = 0;
	String str = null;
	
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	n = Integer.parseInt(sc.nextLine());
//	System.out.println(n);
	
	if ( (n>=2) & (n<=30000)) {
		if (sc.hasNextLine() == true) str = sc.nextLine();
	//		System.out.println(str);
		String str2 = str.substring(0, str.length() -1);
	//		System.out.println(str2);
		StringBuffer sbf = new StringBuffer();
		for (int i= 0; i<str2.length(); i++ ) 
			if (str2.charAt(i) != ' ') sbf.append(str2.charAt(i));
		String str3 = sbf.toString();
			System.out.println(str3);
			System.out.println(str3.length());
			
			// Проверка правильности введения чисел
			String Array[] = str.split(" ");
			int Array_int[] = new int[Array.length];
			System.out.println(Arrays.toString(Array));
			boolean correct_input = true;
			for (int i = 0; i<Array.length; i++)  Array_int[i] = Integer.parseInt(Array[i]);
				System.out.println(Arrays.toString(Array_int));
			for (int i = 0; i<Array_int.length; i++)
				if ((Array_int[i]<=0) | (Array_int[i] >32000)) correct_input = false;
			if (Array_int[0] != Array_int[Array_int.length-1]) correct_input = false;
			System.out.println(correct_input);
			
			if (n != (Array_int.length)) correct_input = false;
					
		if (correct_input == true) {			
			// Проверка входимости подстрок
				String str4 = null;
				String str5 = null;
				int result = 0;
			StringBuffer sbf2 = new StringBuffer();	
			StringBuffer sbf3 = new StringBuffer();
			for (int i=0; i<str3.length(); i++) {
				sbf2.append(str3.charAt(i)); 
				str4 = sbf2.toString();
		//		System.out.println("str4= " + str4);
				for (int j=0; j<(str3.length()/(i+1)); j++)	sbf3.append(str4);
					str5 = sbf3.toString();
					sbf3.delete(0, sbf3.length());
				if (str5.equals(str3) == true) {
					System.out.println("str5 = " + str5);
					result = i+1;
					break; }
				}
			System.out.println(result);
			if (result !=0) {
				PrintWriter pw;
				pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
				pw.print(result);
				pw.close();}
		}
		else System.out.println("Неправильный ввод чисел");
	}
	else System.out.println("Неправильный ввод числа N");
	
	}
}
