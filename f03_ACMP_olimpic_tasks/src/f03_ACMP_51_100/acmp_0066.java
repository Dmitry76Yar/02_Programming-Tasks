package f03_ACMP_51_100;
/*	Клавиатура		(Время: 1 сек. Память: 16 Мб Сложность: 11%)
Для данной буквы английского алфавита нужно вывести справа стоящую букву на стандартной клавиатуре. При этом клавиатура замкнута, т.е.
справа от буквы «p» стоит буква «a», от буквы «l» стоит буква «z», а от буквы «m» — буква «q».
	Входные данные
Первая строка входного файла INPUT.TXT содержит один символ — маленькую букву английского алфавита.
	Выходные данные
В выходной файл OUTPUT.TXT следует вывести букву стоящую справа от заданной буквы, с учетом замкнутости клавиатуры.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	q			w
2	t			y
3	p			a
4	l			z
5	m			q */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0066 {
public static void main(String[] args) throws IOException {
	String klaviat = "qwertyuiopasdfghjklzxcvbnm";
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	String str = sc.nextLine();
	str = "m";
	
	int index = klaviat.indexOf(str);
	System.out.println(index);
	String result;
	if (str.equals("m")) result = "q"; 
	else result = klaviat.substring(index + 1, index + 2);
	System.out.println(result);
	
	
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(result);
	pw.close();
}
}
