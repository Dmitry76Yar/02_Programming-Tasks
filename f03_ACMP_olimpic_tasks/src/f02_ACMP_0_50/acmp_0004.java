package f02_ACMP_0_50;
/*  ���� �������� ��������� ���� ���������: ������ ���� ����������. ������ ���������� ����� ����������� �����, ����� ��� ������ � 
��������� ����� ���������� ���� �� ����� ����� ��� �� �������. ����� ���������� ����� ����� �������������� ���������� �����, 
����� ������ � ��������� ����� �������, ����� ������� ������� ��� ���� �����. ����� �� ������������� �� ���������� ���� ����� 
���������� �����������. ������ ������� ������ � ������� �� ������ ����� ����������� � ���������� ��������� ����� ���� ��� �����.
 ��������, ���� ���� ������� ����� 487, �� ������������� ������ � ��������� ����� �� ������� ����� 784. ����� ���� ��� �������� 
 ������� �� 784 ����� 487, � ���������� ���� ��������� ����� 297, ������� � ������ �������� ���� �� ��������� ������ ����� �2�, 
 ������ �� ����� �����. ���� �������� ����� ���� �� ����������, ������� ����������� ������ ���������� � ����� ������ ����. 
 �� � ������ ������ ���� ������� � ���������� �������� ����� ����, � ������� �� �� ��������� ���� � ����� ������. ���� � ���, ��� 
 ����������� ����� ���� ����� ���������� ���������, ������� ����������� � ���������: ������� ����� ������ �������� ����������� �
  ������ ��� ����� ������ ����� ������, � ��� ��������� �������� ��������� ���������� ������ �� ������ ������, �.�. � 
  ������������� ���� ������ ��������� ����� ����� 9-2=7. �������� ���� ��� ��������� ������� ����������� ����� �� �������� ��� 
  ������ �����, ������� ��������������� ���������.
		������� ������
� ������������ ������ �������� ����� INPUT.TXT ������ ������������ ����� �, ��������������� ������ ����� ����������� ����� �
���������� ��������� ����������� ����������� ����� �������� �� �����������.
		�������� ������
� �������� ���� OUTPUT.TXT ����� ������� �������� ���������� ����� ��������.
	�������
�	INPUT.TXT	OUTPUT.TXT
1		5			594
2		2			297
3		7			792			 */
// ������� ������

import java.io.*;
import java.util.Scanner;

public class acmp_0004 {
public static void main(String[] args) {
	Scanner sc; 
	int a = 0;
	try { 
		sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt")); 
		if (sc.hasNextInt()) a = sc.nextInt();}  
	catch (FileNotFoundException e) {
		e.printStackTrace(); 	}
	
	PrintWriter pr = null;
	try { 
		pr = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
		pr.write(Integer.toString(a) + "9" + Integer.toString(9-a)); } 
	catch (IOException e) {
		e.printStackTrace(); 	}
	finally { pr.close(); }
	
	}

}
