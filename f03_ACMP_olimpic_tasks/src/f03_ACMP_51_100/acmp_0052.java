package f03_ACMP_51_100;

/*	Счастливый билет		(Время: 1 сек. Память: 16 Мб Сложность: 12%)
Вы пользуетесь общественным транспортом? Вероятно, вы расплачивались за проезд и получали билет с номером. Счастливым билетом 
называют такой билет с шестизначным номером, где сумма первых трех цифр равна сумме последних трех. Т.е. билет с номером 
385916 – счастливый, т.к. 3+8+5=9+1+6. Вам требуется написать программу, которая проверяет счастливость билета.
	Входные данные
В единственной строке входного файла INPUT.TXT записано одно целое число N (0 ≤ N < 106).
	Выходные данные
В выходной файл OUTPUT.TXT нужно вывести «YES», если билет с номером N счастливый и «NO» в противном случае.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	385916			YES
2	123456			NO		 */

import java.io.*;
import java.util.Scanner;

public class acmp_0052 {
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	String str = sc.nextLine();
	int n = Integer.parseInt(str.substring(0, 1)) + Integer.parseInt(str.substring(1, 2)) + Integer.parseInt(str.substring(2, 3)); 
	int k = Integer.parseInt(str.substring(3, 4)) + Integer.parseInt(str.substring(4, 5)) + Integer.parseInt(str.substring(5, 6));
	System.out.println(" n = " + n + ",  k = " + k);

	String result;
	if (n==k) result = "YES";
	else result = "NO";
	System.out.println(result);
	
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(result);
	pw.close();
}
}
