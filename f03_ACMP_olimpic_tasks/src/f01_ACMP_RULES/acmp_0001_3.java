/* ��� ������ new MAIN().run() � �������� ���� ���������, ��� � ������� acmp_0001_2
 
  �������� �������� �� �����
����� ���������� - 0,118 �, ������ - 254 ��		-	 ��� ����������
*/

package f01_ACMP_RULES;				// ������ ��� �����

import java.io.*;
import java.util.Scanner;

public class acmp_0001_3 {
//public class MAIN {											������ ��� �����
	
public static void main(String[] args) throws IOException {
	PrintWriter pw;
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	// sc = new Scanner(new FileReader("input.txt"));			������ ��� �����//public class MAIN {											������ ��� �����//public class MAIN {											������ ��� �����
	int a=sc.nextInt();
	int b=sc.nextInt(); 	
	
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	// pw = new PrintWriter(new FileWriter("output.txt"));		������ ��� �����
	pw.print(a+b);
	pw.close();}
}

