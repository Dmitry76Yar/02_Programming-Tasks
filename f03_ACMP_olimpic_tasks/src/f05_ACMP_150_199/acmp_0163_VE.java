package f05_ACMP_150_199;

/*  Уравнение для 5 класса!		(Время: 1 сек. Память: 16 Мб Сложность: 25%)
Уравнение для пятиклассников представляет собой строку длиной 5 символов. Второй символ строки является либо знаком '+' (плюс)
либо '-' (минус), четвёртый символ — знак '=' (равно). Из первого, третьего и пятого символов ровно два являются цифрами из
диапазона от 0 до 9, и один — буквой x, обозначающей неизвестное.
	Требуется написать программу, которая позволит решить данное уравнение относительно x.
	Входные данные
Входной файл INPUT.TXT состоит из одной строки, в которой записано уравнение.
	Выходные данные
В выходной файл OUTPUT.TXT выведите целое число — значение x.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	x+5=7		2
2	3-x=9		-6		 */

import java.util.*;
import java.io.*;

public class acmp_0163_VE{
	
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	String str = sc.nextLine();
	int a = 100;
	int b = 100;
	int sum = 100;
	char operand = '1';
	int x = 0;
	for (int i=0; i<str.length(); i++) {
		char t = str.charAt(i);
		if ((i==0) && (t!='x')) a = Integer.parseInt(str.substring(i,i+1));
		if ((i==2) && (t!='x')) b = Integer.parseInt(str.substring(i,i+1));
		if ((i==4) && (t!='x')) sum = Integer.parseInt(str.substring(i,i+1));
		if (i==1) operand =  t;
	}
	if (a==100) {
		if (operand == '+') x = sum - b;
		else x = sum + b;
	}
	if (b==100) {
		if (operand == '+') x = sum - a;
		else x = a-sum;
	}
	if (sum==100) {
		if (operand == '+') x = a+b;
		else x = a-b;
	}
	System.out.println("a = " + a + "  b= " + b + "  sum = " + sum + " operand = " + operand);
	System.out.println("x= " + x);
	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	o.print(x);
	o.flush();
	o.close();
}
}




