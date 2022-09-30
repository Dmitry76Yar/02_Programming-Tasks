package f02_ACMP_0_50;

/*	 Быки и коровы		(Время: 1 сек. Память: 16 Мб Сложность: 26%)
Петя и Вася часто играют в различные логические игры. Недавно Петя поведал Васе о новой игре «Быки и коровы» и теперь они играют в 
эту игру сутками. Суть игры очень проста: Петя загадывает четырехзначное число, состоящее из различных цифр. Вася отгадывает 
задуманное Петей число, перебирая возможные варианты. Каждый раз Вася предлагает вариант своего числа, а Петя делает Васе подсказку:
сообщает количество быков и коров, после чего Вася с учетом подсказки продолжает отгадывание числа до тех пор, пока не отгадает.
Быки – это количество цифр в предложенном Васей числе, совпадающих по значению и стоящих в правильной позиции в задуманном Петей 
числе. Коровы – количество цифр, совпадающих по значению, но находящихся в неверной позиции. Например, если Петя задумал число 5671,
а Вася предложил вариант 7251, то число быков равно 1 (только цифра 1 на своем месте), а число коров равно 2 (только цифры 7 и 5 не 
на своих местах). Петя силен в математике, но даже он может ошибаться. Помогите Пете написать программу, которая бы по загаданному 
Петей и предложенному Васей числам сообщала количество быков и коров.
	Входные данные
В единственной строке входного файла INPUT.TXT записано два четырехзначных натуральных числа A и B через пробел, где А – загаданное 
Петей число, а В – предложенный Васей вариант.
	Выходные данные
В выходной файл OUTPUT.TXT нужно вывести два целых числа через пробел — количество быков и коров.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	5671 7251		1 2
2	1234 1234		4 0
3	2034 6234		2 1		 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class acmp_0013 {
public static void main(String[] args) throws IOException {
	Scanner sc; 
	int a = 0;
	ArrayList<Integer> ar_list = new ArrayList<Integer>();
	
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	while (sc.hasNext()) {
		if (sc.hasNextInt())	{
			a = sc.nextInt();
			// Добавляет только четырехзначные числа
			if (Integer.toString(a).length() == 4) 	ar_list.add(a);}
		}
	
		// Проверяет, что введено 2 числа
	boolean correct_fig = true;
	if (ar_list.size() == 2) {
			// Проверка что, нет повторяющихся цифр в числе
		for(int i=0; i<ar_list.size(); i++) {			// Перебор чисел в input
			String str = ar_list.get(i).toString();
			// System.out.println(str);
			for(int j=0; j<str.length()-1; j++) 			// Перебор символов в числе, преобразованном до строки
				for(int k=j+1; k<str.length(); k++) {
					if (str.charAt(j) == str.charAt(k)) correct_fig = false;
					// 	System.out.println("j = " +str.charAt(j) + "  k= " + str.charAt(k)  + " corr = " + correct_fig);
					}
			}
	}
	else System.out.println("Неправильный ввод");
	
	if (correct_fig != false) {
		// Преобразование в ArrayList<String>
		ArrayList<String> ar_list_string = new ArrayList<String>();
		for (int i =0; i<ar_list.size(); i++) {
			ar_list_string.add(ar_list.get(i).toString());
		}
//		System.out.println(ar_list.toString());
		
			// Счетчик одинаковых цифр в одинаковом положении для двух чисел
		int count_first = 0; 				
		for (int i=0; i<4; i++) {
			if (ar_list_string.get(0).charAt(i) == ar_list_string.get(1).charAt(i)) count_first++;}
			
			// Счетчик одинаковых цифр в разных положениях для двух чисел
		int b = 0;			
		for (int l=0; l<4; l++) {
			String str1 = Character.toString(ar_list_string.get(0).charAt(l));
//			System.out.println(str1);
			if (ar_list_string.get(1).contains(str1) == true) b++;
		}
		int count_second = b - count_first;	
//		System.out.println("count_first = " + count_first + " b= " + b + " count_second = " + count_second);
		
		PrintWriter pw;
		pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
		pw.print(count_first);
		pw.print(" ");
		pw.print(count_second);
		pw.close();
	}
	else System.out.println("Неправильный ввод");
//	System.out.println(correct_fig);
	
			
	
	}

}
