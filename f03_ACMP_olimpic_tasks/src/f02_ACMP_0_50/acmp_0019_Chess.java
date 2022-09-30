package f02_ACMP_0_50;
/*	Ферзь, ладья и конь		(Время: 1 сек. Память: 16 Мб Сложность: 29%)
 На шахматной доске 8х8 расположены три фигуры: ферзь, ладья и конь. Требуется определить количество пустых полей доски, которые н
 аходятся под боем. Для простоты будем полагать, что фигуры могут «бить» через другие фигуры. Например, в рассмотренной справа 
 ситуации будем считать, что ферзь бьет D5 через ладью
 	Входные данные
В единственной строке входного файла INPUT.TXT записаны через пробел координаты расположения трех фигур: ферзя, ладьи и коня
соответственно. Каждая координата состоит из одного английского символа (от A до H) и одной цифры (от 1 до 8).
	Выходные данные
В выходной файл OUTPUT.TXT нужно вывести количество пустых полей, которые бьют указанные во входных данных фигуры.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1	D1 D3 E5	29			 */

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0019_Chess {
	
	static boolean check (String str) {
		if ((str.charAt(0) >= 'A') & (str.charAt(0) <= 'H') & (str.charAt(1) >= '1') & (str.charAt(1) <= '8')) {
			return true;}
		else return false; 	
		}
	
	static String trans (String str) {
		if (str.charAt(0) == 'A') str = str.replace('A', '1');
		if (str.charAt(0) == 'B') str = str.replace('B', '2');
		if (str.charAt(0) == 'C') str = str.replace('C', '3');
		if (str.charAt(0) == 'D') str = str.replace('D', '4'); 
		if (str.charAt(0) == 'E') str = str.replace('E', '5');
		if (str.charAt(0) == 'F') str = str.replace('F', '6');
		if (str.charAt(0) == 'G') str = str.replace('G', '7');
		if (str.charAt(0) == 'H') str = str.replace('H', '8');
		return str;}
	
	static String[][] diagonal (String Array[][], int a1, int b1) {
		int a = a1; int b = b1;
		while (true) { 	
			Array[b][a] = "+";
//			System.out.print("1 cycle Array[" + a  + "][" + b + "] \t");
			if (((a-1)>=0) & ((b-1)>=0)) {a--; b--; }
			else break; }
				// Диагональ в правую верхнюю четверть
		a = a1; 	b = b1;
		while (true) { 	
			Array[b][a] = "+";
//			System.out.print("2 cycle Array[" + a  + "][" + b + "] \t");
			if (((a+1)<8) & ((b+1)<8)) {a++; b++; } 
			else break; 	}
				// Диагональ в правую нижнюю четверть
		a = a1; 	b = b1;
		while (true) { 	
			Array[b][a] = "+";
//			System.out.print("3 cycle Array[" + a  + "][" + b + "] \t");
			if (((a+1)<8) & ((b-1)>=0)) {a++; b--; } 
			else break; } 
				// Диагональ в левую верхнюю четверть
		a = a1; 	b = b1;
		while (true) { 	
			Array[b][a] = "+";
//			System.out.print("4 cycle Array[" + a  + "][" + b + "] \t");
			if (((a-1)>=0) & ((b+1)<8)) 	{a--; b++; }
			else break;}
		return Array;
	}
	
	static String[][] lines (String Array[][], int a, int b) {
	for (int j =0; j<8; j++)   Array[b][j] = "+";			// Вертикаль			[i][j]   i - строки  j = столбец
	for (int i =0; i<8; i++)   Array[i][a] = "+";			// Горизонталь
	return Array;
	}
	
	static String[][] kon_action (String Array[][], int a, int b) {
		System.out.println("a = " + a + ",  b = " + b);
		if (((a+2)<8) & ((b+1)<8)) Array[a+2][b+1] = "+";
		if (((a+1)<8) & ((b+2)<8)) Array[a+1][b+2] = "+";
		if (((a-1)>=0) & ((b+2)<8)) Array[a-1][b+2] = "+";
		if (((a-2)>=0) & ((b+1)<8)) Array[a-2][b+1] = "+";
		if (((a-2)>=0) & ((b-1)>=0)) Array[a-2][b-1] = "+";
		if (((a-1)>=0) & ((b-2)>=0)) Array[a-1][b-2] = "+";
		if (((a+1)<8) & ((b-2)>=0)) Array[a+1][b-2] = "+";
		if (((a+2)<8) & ((b-1)>=0)) Array[a+2][b-1] = "+";
	return Array;}
	
public static void main(String[] args) throws IOException {
	Scanner sc; 
	boolean correct_input = true;
	String str = null;
	String str_fers = null;
	String str_lad = null;
	String str_kon = null;
	String Array[][] = new String[8][8];
	
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	if (sc.hasNextLine()) str = sc.nextLine();
	if ((str.length() != 8) | (str.substring(2, 3).equals(" ") == false) | (str.substring(5, 6).equals(" ") == false) ) correct_input = false;
	if (correct_input == true) {
		str_fers = str.substring(0, 2);
		str_lad = str.substring(3, 5);
		str_kon = str.substring(6, 8); 
		System.out.print(str_fers + "   ");
		System.out.print(str_lad + "   ");
		System.out.print(str_kon + "   "); System.out.println();
		if ((check(str_fers) == true) & (check(str_lad) == true) & (check(str_kon) == true)) correct_input = true;
		else correct_input = false;
		if ((str_fers.equals(str_kon) == true ) | (str_fers.equals(str_lad) == true) | (str_kon.equals(str_lad) == true)) correct_input = false;
	}
	else System.out.println("Неправильный ввод");
//	System.out.println(correct_input);
	
	if (correct_input == true) {
		str_fers = trans(str_fers);   
		str_lad = trans(str_lad); 
		str_kon = trans(str_kon);
		System.out.print(str_fers + "   ");
		System.out.print(str_lad + "   ");
		System.out.print(str_kon + "   "); System.out.println();
		
			// Заполнить массив
		for (int i =0; i<8; i++)  Arrays.fill(Array[i], " ");
		
			// Обработка ферзя			[i][j]   i - строки  j = столбец
		int a = Integer.parseInt(str_fers.substring(0, 1)) -1;			//a= 4-1 = 3
		int c  = Integer.parseInt(str_fers.substring(1, 2)) -1;			//b = 4
		int b  = Math.abs(c-7);									//c = 4 - 7 = 3
		System.out.println("a = " + a + ",   b = " +  b + ",  c = " + c);
		Array = lines(Array, a, b);
		Array = diagonal(Array, a, b);
		
			// Обработка ладьи
		int a1 = Integer.parseInt(str_lad.substring(0, 1)) -1;			//a= 4-1 = 3
		c  = Integer.parseInt(str_lad.substring(1, 2)) -1;			//b = 4
		int b1  = Math.abs(c-7);									//c = 4 - 7 = 3
		Array = lines(Array, a1, b1);
		
			// Обработка коня
		int a2 = Integer.parseInt(str_kon.substring(0, 1)) -1;			//a= 4-1 = 3
		c  = Integer.parseInt(str_kon.substring(1, 2)) -1;			//b = 4
		int b2  = Math.abs(c-7);	
		Array = kon_action(Array, b2, a2);
		
		for(int i =0; i<8; i++) 	System.out.println(Arrays.toString(Array[i]));
		System.out.println();
		
		for(int i =0; i<8; i++)
			for(int j =0; j<8; j++) {
				if ((Array[i][j] == "+") & ( i == b) & (j == a)) Array[b][a] = "F";		
				if ((Array[i][j] == "+") & ( i == b1) & (j == a1)) Array[b1][a1] = "L";	
				if ((Array[i][j] == "+") & ( i == b2) & (j == a2))	Array[b2][a2] = "K";}
		
		for(int i =0; i<8; i++) 	System.out.println(Arrays.toString(Array[i]));
		
		int count = 0;
		for(int i =0; i<8; i++)
			for(int j =0; j<8; j++)
				if ((Array[i][j] == "+")) count++;
		
		System.out.println("RESULT = " + count);
		PrintWriter pw;
		pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
		pw.print(count);
		pw.close();	
			}
	else System.out.println("Неправильный ввод");
	
	}

}
