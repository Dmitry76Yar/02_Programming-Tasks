package f05_ACMP_150_199;

/*  Натуральный ряд чисел	(Время: 1 сек. Память: 16 Мб Сложность: 28%)
Натуральные числа записаны в строку без каких-либо разделителей. Начало этой строки имеет вид 123456789101112131415161718192021… .
Требуется написать программу, которая определит первое вхождение десятичной записи заданного числа N в этой строке.
	Входные данные
Входной файл INPUT.TXT содержит заданное число N (1 ≤ N ≤ 104).
	Выходные данные
Выходной файл OUTPUT.TXT должен содержать одно число – позицию, начиная с которой в строке записано первое вхождение заданного числа.
Нумерация позиций начинается с единицы.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	45			4
2	101			10
3	142			73		 */

import java.util.*;
import java.io.*;

public class acmp_0168{
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	String N = sc.nextLine();
	N= "142";

	StringBuilder sb = new StringBuilder();
	for (int i = 1; i<=10001; i++) sb.append(Integer.toString(i));
	
	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	o.print(sb.toString().indexOf(N)+1);
	o.close();
}
}



