package f02_ACMP_0_50;
/*	 �������		(�����: 1 ���. ������: 16 �� ���������: 23%)
 ������ ������� ���� ������� ����������������� � ����� ����������� ����������� ��������� ��� ���� � �������. �� � ���� �������� 
 �������� ����������� ������������ ���� �����, ������� ������ ������������. �.�. ���� ������������ ������ �������� �C7-D5�, ��
 ��������� ������ ���������� ��� ��� ���������� ���, ���� �� ������� �E2-E4�, �� ��� ��������. ��� �� ����� ��������� ������������
 ������ �����: ���� ��������, ������� �D9-N5�, �� ��������� ������ ���������� ������ ������ ��� ���������. �������� ��� �����������
 ��� ��������!   
		������� ������
� ������������ ������ �������� ����� INPUT.TXT ������� ����� ���� (�������� ������), ������� ������ ������������. ������������ �� 
����� ������ ������, ������� 5 ��������.
		�������� ������
� �������� ���� OUTPUT.TXT ����� ������� �YES�, ���� ��������� ��� ����� ������, ���� �� ������ ��������� (� ������ ������������ 
������ ���������), �� ��� ����������, �� ����� ������� �NO�. ���� �� ���������� �� ���������� ��� ������ �����������, �� ������� 
��������� �ERROR�.
		�������
�		INPUT.TXT		OUTPUT.TXT
1		C7-D5				YES
2		E2-E4				NO
3		BSN			       ERROR		*/

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0006 {
	
	static String correct_move (int Array[]) {
		int a =0, b=0;
		String result = "NO";
		a = Array[0] -1;	b = Array[1] - 2; if ((Array[2] == a) && (Array[3] == b))  result = "YES"; System.out.println("a= " + a + "  b = " + b + "  Array[2] = " + Array[2] + "  Array[3 = " + Array[3] + " result = " + result);
		a = Array[0] -2;	b = Array[1] - 1; if ((Array[2] == a) && (Array[3] == b))  result = "YES"; System.out.println("a= " + a + "  b = " + b + "  Array[2] = " + Array[2] + "  Array[3 = " + Array[3] + " result = " + result);
		a = Array[0] -2;	b = Array[1] + 1; if ((Array[2] == a) && (Array[3] == b))  result = "YES"; System.out.println("a= " + a + "  b = " + b + "  Array[2] = " + Array[2] + "  Array[3 = " + Array[3] + " result = " + result);
		a = Array[0] -1;	b = Array[1] + 2; if ((Array[2] == a) && (Array[3] == b))  result = "YES"; System.out.println("a= " + a + "  b = " + b + "  Array[2] = " + Array[2] + "  Array[3 = " + Array[3] + " result = " + result);
		a = Array[0] +1;	b = Array[1] + 2; if ((Array[2] == a) && (Array[3] == b))  result = "YES"; System.out.println("a= " + a + "  b = " + b + "  Array[2] = " + Array[2] + "  Array[3 = " + Array[3] + " result = " + result);
		a = Array[0] +2;	b = Array[1] + 1; if ((Array[2] == a) && (Array[3] == b))  result = "YES"; System.out.println("a= " + a + "  b = " + b + "  Array[2] = " + Array[2] + "  Array[3 = " + Array[3] + " result = " + result);
		a = Array[0] +2;	b = Array[1] - 1; if ((Array[2] == a) && (Array[3] == b))  result = "YES"; System.out.println("a= " + a + "  b = " + b + "  Array[2] = " + Array[2] + "  Array[3 = " + Array[3] + " result = " + result);
		a = Array[0] +1;	b = Array[1] - 2; if ((Array[2] == a) && (Array[3] == b))  result = "YES"; System.out.println("a= " + a + "  b = " + b + "  Array[2] = " + Array[2] + "  Array[3 = " + Array[3] + " result = " + result);
	return result;
	}
	
public static void main(String[] args) throws IOException {
	Scanner sc; 
	String str;
	String result = null;
	int Array[] = new int[5];
		// C7-D5
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt")); 
	if (sc.hasNextLine() == true)	str = sc.nextLine();
	else str = " ";
	System.out.println(str);
			// �������� ������� ������������ ����� ���������� ����
	if ((str.length() == 5) && (str.charAt(2) == '-') && ((str.charAt(0))>='A') && ((str.charAt(0))<='H') && ((str.charAt(1))>='1')
			&& ((str.charAt(1))<='8') && ((str.charAt(3))>='A') && ((str.charAt(3))<='H') && ((str.charAt(4))>='1') 
			&& ((str.charAt(4))<='8')) {
		
		for (int i = 0; i<5; i++)	 {				// �������������� ������� �������� � Int
			Array[i] = (int)str.charAt(i);}
		System.out.println(Arrays.toString(Array));
	
				// �������� ��������� ��������
		for (int i= (int)('A'); i<=(int)('H'); i++)  {
			System.out.print(i); System.out.print((char)(i));	System.out.print("  ");} System.out.println();
	
		int Array1[] = new int[4];			// ������ �� 4-� �����
		Array1[0] = Array[0] - 64;			// �� ���� ������� �������� 65 ����� �������� � ����,  ������ � = 0
		Array1[1] = Array[1] - 48;			// �� ���� ������� �������� 48 ����� �������� � ����,  ������ 7 = 7
		Array1[2] = Array[3] - 64;			// A1-B2 -> 1122	C3-D4 -> 3344	E5-F6 -> 5566	G7-H8 -> 7788
		Array1[3] = Array[4] - 48;
		System.out.println(Arrays.toString(Array1));
	
			result = correct_move(Array1);	
	}
	else result = "ERROR";
	
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(result);
	pw.close();
		}
}
