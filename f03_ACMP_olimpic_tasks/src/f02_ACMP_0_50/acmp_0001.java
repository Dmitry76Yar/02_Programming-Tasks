/* C ������� try - catch
 
  �������� �������� �� �����
����� ���������� - 0,103 �, ������ - 246 ��		-	 ��� ����������, ���� ��������� ���������   */

package f02_ACMP_0_50;				// ������ ��� �����

import java.io.*;
import java.util.Scanner;

public class acmp_0001 {
//public class MAIN {																������ ��� �����
	
public static void main(String[] args) {
	Scanner sc;
	int a = 0;
	int b = 0;
	
	// 244 1000
	try {
		sc = new  Scanner (new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
		// sc = new Scanner(new FileReader("input.txt"));							������ ��� �����											
		if (sc.hasNextInt() == true) a = sc.nextInt();
		if (sc.hasNextInt() == true) b = sc.nextInt();
		}
	catch (IOException e) { 
		e.printStackTrace(); }
	
	//1224
	PrintWriter pw = null;
	try { 
		pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt")); 
		// pw = new PrintWriter(new FileWriter("output.txt"));						������ ��� �����
		pw.print(a+b);}
	catch (IOException e1) { 	e1.printStackTrace(); 	}
    finally { pw.close();}
	
}
}