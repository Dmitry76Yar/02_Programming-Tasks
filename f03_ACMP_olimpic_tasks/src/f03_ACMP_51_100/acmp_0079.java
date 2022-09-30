package f03_ACMP_51_100;
/*	Последняя цифра A^B		(Время: 1 сек. Память: 16 Мб Сложность: 21%)
Требуется написать программу, которая находит цифру, на которую оканчивается число AB.
	Входные данные
Входной файл INPUT.TXT состоит из единственной строки, содержащей два целых числа A и B, разделенных пробелом (1 ≤ A,B ≤ 10000).
	Выходные данные
В единственную строку выходного файла OUTPUT.TXT нужно вывести цифру, на которую оканчивается AB.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	2 2				4
2	3 7				7
3	24 9			4 */
import java.io.*;
import java.util.Scanner;

public class acmp_0079 {
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int A = sc.nextInt();		
	int B = sc.nextInt();	
	A = 2; 	B = 0;
	String c = null;
	
	if (B==0 ) c = "1";
	else { 
			String A_str = Integer.toString(A);
			String A_str_last_number = A_str.substring(A_str.length()-1, A_str.length());
			System.out.println(A_str_last_number);
			int temp2 = Integer.parseInt(A_str_last_number);
			
			int temp = Integer.parseInt(A_str_last_number);
			for (int i = 1; i<B; i++) {
				A_str = Integer.toString(temp);
				A_str_last_number = A_str.substring(A_str.length()-1, A_str.length());
				int A_temp = Integer.parseInt(A_str_last_number);
				System.out.print("A_temp = " + A_temp);
				temp = A_temp*temp2;
				System.out.println("\ttemp = " +temp);
			}
			String a = Integer.toString(temp);
			c =  a.substring(a.length()-1, a.length());}
	
	System.out.println(c);
  
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(c);
	pw.close();
}
}