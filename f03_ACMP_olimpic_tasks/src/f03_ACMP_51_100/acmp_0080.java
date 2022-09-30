package f03_ACMP_51_100;
	/*	Тождество	(Время: 1 сек. Память: 16 Мб Сложность: 37%)
Вам необходимо проверить домашнюю работу Васи Пупкина, в которой он написал равенство. Например, запись вида «2+3=5» является правильной,
а «23*7=421» неверная, но корректная. Корректной записью выражения будем называть последовательность: число, операция («+», «-», «*», «/»),
число, знак равенства, число. Числом будем считать последовательность из одной или более десятичных цифр, перед которой может стоять один
знак минус. В корректной записи выражения нет пробелов.
	Если запись не соответствует описанному правилу, то она считается некорректной. Например, записи «2*=3», «173» и «2+2=a» некорректны.
	Входные данные
Входной файл INPUT.TXT состоит из единственной строки, содержащей запись арифметического выражения. Все числа в записи не превышают по
абсолютной величине 30000. Длина арифметического выражения может быть от 0 до 100 символов.
	Выходные данные
В выходной файл OUTPUT.TXT выведите «YES», если указанная запись правильна (т.е. равенство представляет собой тождество), «NO» - если
корректная, но неверная и «ERROR», если запись некорректная.
	Примеры
№	INPUT.TXT				OUTPUT.TXT
1	2+3=5						YES
2	3*7=20						NO
3	two plus three is five		ERROR */

import java.io.*;
import java.util.Scanner;

public class acmp_0080 {
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	boolean isInputCorrect = true;
	String input = null;
	if (sc.hasNextLine() == true) input = sc.nextLine();
	else isInputCorrect = false;
//	input = "-12+-129=-117";
	System.out.println(input);
	String result = null;
	
	if (isInputCorrect == true) {
	for (int i =0; i<input.length(); i++) 
		if ((input.charAt(i)=='+') || (input.charAt(i)=='*') || (input.charAt(i)=='/') || (input.charAt(i)=='-') ||
				(input.charAt(i)=='=') || ((input.charAt(i)>='0') && (input.charAt(i)<='9'))) System.out.print("П");
		else {System.out.print("Неправильный ввод");
			  isInputCorrect = false; }
//	System.out.println(isInputCorrect);
	System.out.println();}
	
	if (isInputCorrect == true) {
		int plus = 0;
		int equal = 0;
		int devis = 0; 
		int multy = 0;
		for (int i =0; i<input.length(); i++) {
			if (input.charAt(i)=='=')  equal++;
			if (input.charAt(i)=='*')  multy++;
			if (input.charAt(i)=='/')  devis++;
			if (input.charAt(i)=='+')  plus++; 		}
		if ((plus>1) || (equal>1) || (devis >1) || (multy>1)) isInputCorrect = false;}
	
	String left_side  = null;		
	String right_side  = null;	
	if (isInputCorrect == true) {
		String a[] = input.split("=");
		if (a.length!=2) isInputCorrect = false;
		if (isInputCorrect == true) {
			left_side  = a[0];		
			right_side  = a[1]; 
		}
	}
	
	
	
	int int_right_side = 0;
	if (isInputCorrect == true) {
		if (right_side.length() == 0)  isInputCorrect = false;
		else {
			if ((right_side.contains("+")) || (right_side.contains("*")) || (right_side.contains("/")))  isInputCorrect = false;
			if (right_side.substring(1, right_side.length()).contains("-")) isInputCorrect = false;
			if ((right_side.substring(0, 1).contains("-")) && (right_side.length() == 1))  isInputCorrect = false;
			if (isInputCorrect == true) int_right_side = Integer.parseInt(right_side);}
	    System.out.println("int_right_side = " + int_right_side);
	}
	
	String operand = null;		
	StringBuffer temp_sbf = new StringBuffer(); 
	String first_operator_str = null;
	int first_operator = 0;
	int m = 0;
	int i = 0;
	if (isInputCorrect == true) {
		for (i =0; i<left_side.length(); i++)	{
			if (i==0) {
				if (left_side.charAt(i)=='-') 		temp_sbf.append(left_side.charAt(i)); 	 
				else if ((left_side.charAt(i)>='0') && (left_side.charAt(i)<='9'))  {
					temp_sbf.append(left_side.charAt(i));
					m++;
				}
				else break; 	
//			System.out.println("Первый символ " +  temp_sbf.toString());			
			}
			else {   // i > 0
				if ((left_side.charAt(i)=='-') || (left_side.charAt(i)=='*') || (left_side.charAt(i)=='+') ||  (left_side.charAt(i)=='/')) {
					operand = Character.toString(left_side.charAt(i));
//					System.out.println("i =  " + i);
					break; 	}
				else {
					m++;
					temp_sbf.append(left_side.charAt(i)); }
			}
		}
		if ((m == 0) || (temp_sbf.length() == 0) || (i == left_side.length())) isInputCorrect = false; 
		else {first_operator_str = temp_sbf.toString();
			first_operator = Integer.parseInt(first_operator_str); 	}
		System.out.println("first_operator = " + first_operator); 
		System.out.println("operand = " + operand);
	}
	
	int second_operator = 0;
	String second_operator_str = null;
	if (isInputCorrect == true) {
		temp_sbf.delete(0, temp_sbf.length());
		int n = 0;
		int j = i+1;
//		System.out.println(" j = " + j);
		for (i = j; i<left_side.length(); i++)	{
//			System.out.println("i = " + i);
			
			if (i==j) {
				System.out.println("left_side.charAt(i) = " + left_side.charAt(i) );
				if (left_side.charAt(i)=='-') 		{
					temp_sbf.append(left_side.charAt(i));
				}
				else if ((left_side.charAt(i)>='0') && (left_side.charAt(i)<='9'))  {
					temp_sbf.append(left_side.charAt(i));
					n++;
				}
				else break; 	
//			System.out.println("Первый символ " +  temp_sbf.toString());			
			}
			else {  // i > j
				if ((input.charAt(i)>='0') && (input.charAt(i)<='9'))  {
					n++;
					temp_sbf.append(left_side.charAt(i)); }
				else {
					isInputCorrect = false;
					break;}
				}
			}
		second_operator_str = temp_sbf.toString();
		System.out.println(isInputCorrect);
		if ((n == 0) || (temp_sbf.length() == 0)) {isInputCorrect = false;} 
		if ((first_operator_str.length() + second_operator_str.length() + right_side.length()+ 2) != input.length()) 
			isInputCorrect = false;
		if (isInputCorrect == true)  second_operator = Integer.parseInt(second_operator_str);		
		
		System.out.println("second_operator = " + second_operator); 
	}
	
	boolean isItRight = false;
	if (isInputCorrect == true) {
		double dbl_result = 0.0;
		if (operand.equals("+")) {
			if ((first_operator + second_operator) == int_right_side)  isItRight = true; }
		else if (operand.equals("-")) {
			if ((first_operator - second_operator) == int_right_side)  isItRight = true; }
		else if (operand.equals("*")) {
			if ((first_operator * second_operator) == int_right_side)  isItRight = true; }
		else if (operand.equals("/")) {
			dbl_result = ((double)first_operator / (double)second_operator);
			if (dbl_result == int_right_side)  isItRight = true; 
			System.out.println(dbl_result);
			}
		if (isItRight == true ) result = "YES";
		else result = "NO";
	}
	else result = "ERROR";

	System.out.println(result);

	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(result);
	pw.close();
}
}