package f02_ACMP_0_50;
/*�������
(�����: 1 ���. ������: 16 �� ���������: 35%)
�������� ������� n ������� ������ ����� n, ������ �� �������� ������� ������ � ��������� {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, a, b,
c, d, e, f, g, ?}. ������� ������������� � ������ �� ���� �� ��������� ��������:
	� ������� �� 0 �� 9 ����� ���� ������������� ������ ���� � ����;
	� ������ a ����� ������������ � ����� �� �������� 0,1, 2, 3;
	� ������ b ����� ������������ � ����� �� �������� 1,2,3,4;
	� ������ c ����� ������������ � ����� �� �������� 2,3,4,5;
	� ������ d ����� ������������ � ����� �� �������� 3,4,5,6;
	� ������ e ����� ������������ � ����� �� �������� 4,5,6,7;
	� ������ f ����� ������������ � ����� �� �������� 5,6,7,8;
	� ������ g ����� ������������ � ����� �� �������� 6,7,8,9;
	� ������ ? ����� ������������ � ����� �� �������� �� 0 �� 9;
���� ��� �������: p1 � p2. ���������� ��������� S1 �����, ������� ����� ���� �������� �� p1 �� ��������� ��������, �
��������� S2 �����, ������� ����� ���� �������� �� p2. ���������� ����� ���������� �����, �������� � ��� ���� ���������.
	������� ������
������ ������ �������� ����� INPUT.TXT �������� ������ p1, ������ � ������ p2. ������� ����� ���������� ������������� ������,
�� ������ 9.
	�������� ������
� �������� ���� OUTPUT.TXT �������� ����� �� ������.
	�������
�	INPUT.TXT	OUTPUT.TXT
1		???
		abc			64
2		???
		000			1
3		abc
		999			0		*/

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0049_Combinator {
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	String str1 = sc.nextLine();
	String str2 = sc.nextLine();
	sc.close();
	String str1_array[] = str1.split("");
	String str2_array[] = str2.split("");
	System.out.println(Arrays.toString(str1_array));
	System.out.println(Arrays.toString(str2_array));
	
	for (int i = 0; i<str1.length(); i++) {
		if (str1_array[i].equals("a")) str1_array[i] = "0123";	if (str2_array[i].equals("a")) str2_array[i] = "0123";
		if (str1_array[i].equals("b")) str1_array[i] = "1234";	if (str2_array[i].equals("b")) str2_array[i] = "1234";
		if (str1_array[i].equals("c")) str1_array[i] = "2345";	if (str2_array[i].equals("c")) str2_array[i] = "2345";
		if (str1_array[i].equals("d")) str1_array[i] = "3456";	if (str2_array[i].equals("d")) str2_array[i] = "3456";
		if (str1_array[i].equals("e")) str1_array[i] = "4567";	if (str2_array[i].equals("e")) str2_array[i] = "4567";
		if (str1_array[i].equals("f")) str1_array[i] = "5678";	if (str2_array[i].equals("f")) str2_array[i] = "5678";
		if (str1_array[i].equals("g")) str1_array[i] = "6789";	if (str2_array[i].equals("g")) str2_array[i] = "6789";
		if (str1_array[i].equals("?")) str1_array[i] = "0123456789";
		if (str2_array[i].equals("?")) str2_array[i] = "0123456789";
	}
	
	System.out.println(Arrays.toString(str1_array));
	System.out.println(Arrays.toString(str2_array));
	
	long result = 1;
	int count = 0;
	for (int i = 0; i<str1.length(); i++) {
		if (str1_array[i].length() >= str2_array[i].length()) {
//			System.out.println("1 ������");
			for (int j = 0; j<str2_array[i].length(); j++) {
				if (str1_array[i].contains(str2_array[i].substring(j, j+1))) count++;
				}
		}
		else 	{
//			System.out.println("2 ������");
			for (int j = 0; j<str1_array[i].length(); j++) {
				if (str2_array[i].contains(str1_array[i].substring(j, j+1))) count++; 
				}
		}
//		System.out.println(count);
		result = result*count;
		count = 0;
	}
	System.out.println(result);
	
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(result);
	pw.close();
	
	
	}
}
