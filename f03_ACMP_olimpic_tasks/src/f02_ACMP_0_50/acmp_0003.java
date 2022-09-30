/*	Пятью пять - двадцать пять!				(Время: 1 сек. Память: 16 Мб Сложность: 8%)
Вася и Петя учатся в школе в одном классе. Недавно Петя поведал Васе о хитром способе возведения в квадрат натуральных чисел,
оканчивающихся на цифру 5. Теперь Вася может с легкостью возводить в квадрат двузначные (и даже некоторые трехзначные) числа, 
оканчивающиеся на 5. Способ заключается в следующем: для возведения в квадрат числа, оканчивающегося на 5 достаточно умножить число, 
полученное из исходного вычеркиванием последней пятерки на следующее по порядку число, затем остается лишь приписать «25» к 
получившемуся результату справа. Например, для того, чтобы возвести число 125 в квадрат достаточно 12 умножить на 13 и приписать 25,
 т.е. приписывая к числу 12*13=156 число 25, получаем результат 15625, т.е. 1252=15625. Напишите программу, возводящую число, 
 оканчивающееся на 5, в квадрат для того, чтобы Вася смог проверить свои навыки.
	Входные данные
В единственной строке входного файла INPUT.TXT записано одно натуральное число А, оканчивающееся на цифру 5, не превышающее 4*10^5.
	Выходные данные
В выходной файл OUTPUT.TXT выведите одно натуральное число - A2 без лидирующих нулей.

Примеры
№	INPUT.TXT	OUTPUT.TXT
1		5			25
2		75			5625
3		4255	18105025	 */

// ПРИНЯТО САЙТОМ 

package f02_ACMP_0_50;

	import java.io.*;
	import java.util.Scanner;
	
	public class acmp_0003 {
	// public class MAIN {
	
		static int calculate (int n) {
			int a = (int)n/10;
			System.out.println(a);
			int result = a*(a+1);
			System.out.println(result);
			return result;
		}
		
		
	public static void main(String[] args) {
		Scanner sc; 
		int a = 0;
		int n = 0;
		String str;
		
		try { 
			sc = new Scanner (new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt")); 
			// sc = new Scanner (new FileReader("input.txt"));							Для ввода на сайте
			if (sc.hasNextInt() == true)	{
				a = sc.nextInt();
//				str = String.valueOf(a);					// Перевод числа в строку
//				boolean endWith = str.endsWith("5");		// Определяет оканчивается ли на "5"
				if ((a >0) & (a<=400000) & (a%10 == 5)) n = a;}
		}				
		catch (FileNotFoundException e) {e.printStackTrace(); 	}
		
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt")); 
			// pw = new PrintWriter(new FileWriter("output.txt"));							Для ввода на сайте
			int result = calculate(n);
			if (result==0)  
				pw.write("25");
			else pw.write(Integer.toString(calculate(n)) + "25");}
		catch (IOException e) { e.printStackTrace();	}
		finally  { pw.close(); }
		
		}
	
	}
