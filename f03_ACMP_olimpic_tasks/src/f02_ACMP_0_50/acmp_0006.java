package f02_ACMP_0_50;
/*	 Шахматы		(Время: 1 сек. Память: 16 Мб Сложность: 23%)
 Совсем недавно Вася занялся программированием и решил реализовать собственную программу для игры в шахматы. Но у него возникла 
 проблема определения правильности хода конем, который делает пользователь. Т.е. если пользователь вводит значение «C7-D5», то
 программа должна определить это как правильный ход, если же введено «E2-E4», то ход неверный. Так же нужно проверить корректность
 записи ввода: если например, введено «D9-N5», то программа должна определить данную запись как ошибочную. Помогите ему осуществить
 эту проверку!   
		Входные данные
В единственной строке входного файла INPUT.TXT записан текст хода (непустая строка), который указал пользователь. Пользователь не 
может ввести строку, длиннее 5 символов.
		Выходные данные
В выходной файл OUTPUT.TXT нужно вывести «YES», если указанный ход конем верный, если же запись корректна (в смысле правильности 
записи координат), но ход невозможен, то нужно вывести «NO». Если же координаты не определены или заданы некорректно, то вывести 
сообщение «ERROR».
		Примеры
№		INPUT.TXT		OUTPUT.TXT
1		C7-D5				YES
2		E2-E4				NO
3		BSN			       ERROR		*/

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0006 {
	
	static String correct_move (int Array[]) {
		int a =0, b=0;
		String result = "NO";
		a = Array[0] -1;	b = Array[1] - 2; if ((Array[2] == a) && (Array[3] == b))  result = "YES"; System.out.println("a= " + a + "  b = " + b + "  Array[2] = " + Array[2] + "  Array[3 = " + Array[3] + " result = " + result);
		a = Array[0] -2;	b = Array[1] - 1; if ((Array[2] == a) && (Array[3] == b))  result = "YES"; System.out.println("a= " + a + "  b = " + b + "  Array[2] = " + Array[2] + "  Array[3 = " + Array[3] + " result = " + result);
		a = Array[0] -2;	b = Array[1] + 1; if ((Array[2] == a) && (Array[3] == b))  result = "YES"; System.out.println("a= " + a + "  b = " + b + "  Array[2] = " + Array[2] + "  Array[3 = " + Array[3] + " result = " + result);
		a = Array[0] -1;	b = Array[1] + 2; if ((Array[2] == a) && (Array[3] == b))  result = "YES"; System.out.println("a= " + a + "  b = " + b + "  Array[2] = " + Array[2] + "  Array[3 = " + Array[3] + " result = " + result);
		a = Array[0] +1;	b = Array[1] + 2; if ((Array[2] == a) && (Array[3] == b))  result = "YES"; System.out.println("a= " + a + "  b = " + b + "  Array[2] = " + Array[2] + "  Array[3 = " + Array[3] + " result = " + result);
		a = Array[0] +2;	b = Array[1] + 1; if ((Array[2] == a) && (Array[3] == b))  result = "YES"; System.out.println("a= " + a + "  b = " + b + "  Array[2] = " + Array[2] + "  Array[3 = " + Array[3] + " result = " + result);
		a = Array[0] +2;	b = Array[1] - 1; if ((Array[2] == a) && (Array[3] == b))  result = "YES"; System.out.println("a= " + a + "  b = " + b + "  Array[2] = " + Array[2] + "  Array[3 = " + Array[3] + " result = " + result);
		a = Array[0] +1;	b = Array[1] - 2; if ((Array[2] == a) && (Array[3] == b))  result = "YES"; System.out.println("a= " + a + "  b = " + b + "  Array[2] = " + Array[2] + "  Array[3 = " + Array[3] + " result = " + result);
	return result;
	}
	
public static void main(String[] args) throws IOException {
	Scanner sc; 
	String str;
	String result = null;
	int Array[] = new int[5];
		// C7-D5
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt")); 
	if (sc.hasNextLine() == true)	str = sc.nextLine();
	else str = " ";
	System.out.println(str);
			// Проверка условия правильности ввода шахматного хода
	if ((str.length() == 5) && (str.charAt(2) == '-') && ((str.charAt(0))>='A') && ((str.charAt(0))<='H') && ((str.charAt(1))>='1')
			&& ((str.charAt(1))<='8') && ((str.charAt(3))>='A') && ((str.charAt(3))<='H') && ((str.charAt(4))>='1') 
			&& ((str.charAt(4))<='8')) {
		
		for (int i = 0; i<5; i++)	 {				// Преобразование массива символов в Int
			Array[i] = (int)str.charAt(i);}
		System.out.println(Arrays.toString(Array));
	
				// Показать кодировку символов
		for (int i= (int)('A'); i<=(int)('H'); i++)  {
			System.out.print(i); System.out.print((char)(i));	System.out.print("  ");} System.out.println();
	
		int Array1[] = new int[4];			// Массив из 4-х чисел
		Array1[0] = Array[0] - 64;			// Из кода символа вычитает 65 чтобы привести к нулю,  символ А = 0
		Array1[1] = Array[1] - 48;			// Из кода символа вычитает 48 чтобы привести к нулю,  символ 7 = 7
		Array1[2] = Array[3] - 64;			// A1-B2 -> 1122	C3-D4 -> 3344	E5-F6 -> 5566	G7-H8 -> 7788
		Array1[3] = Array[4] - 48;
		System.out.println(Arrays.toString(Array1));
	
			result = correct_move(Array1);	
	}
	else result = "ERROR";
	
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(result);
	pw.close();
		}
}
