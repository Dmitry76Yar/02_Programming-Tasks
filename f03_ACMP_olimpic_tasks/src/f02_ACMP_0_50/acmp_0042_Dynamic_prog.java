package f02_ACMP_0_50;
/* 	�������			(�����: 1 ���. ������: 16 �� ���������: 40%)
��������, ��� � ������� ����� ���� ��������� ����� � ��� ���� ������������ ������ �����. �� ��� ���������� ���� ���������
����, � ������� ��������� �������� � � ������� �� ��� ������������ ����� �����? ��������, �� ��������, ��� ��� ��������
 ����������� ��� ����� ���� �����? ��� ������ �� ���, ����� ���� �� ������� ������ ��������� ���� ��������� ����. �����������,
 ��� ������� �������� ����� ������������ �������� ����� ����� ������� �� ��������. ��������, ���� � ���� 3 �������, � �������
 3, 4 � 5 ����� ��������������, �� ���� ����� 3*4*5 = 60. �����������, ��� ��� �������� ��������� ���������� ����� ��������� 
 ����, ��� ��� ��������� ����������� ��������� �������� ���� ����� ������ ��������? ������ ��� ������ ��� � ��������� ������.
 	������� ������
� ������������ ������ �������� ����� INPUT.TXT �������� ����������� ����� N (0 < N < 100) � ���������� ����� ��������� ����.
	�������� ������
� ������������ ������ ��������� ����� OUTPUT.TXT ����� ������� ����������� ��������� �������� ����, ������� ����� ���� � ����
�������� �� N �����.
	�������
�	INPUT.TXT	OUTPUT.TXT
1		6			9
2		8			18
3		13			108		 */

import java.io.*;
import java.util.Scanner;

public class acmp_0042_Dynamic_prog {
/*0		1	->	2		->		3		->		4		->		5		->		6
  [1]   [1]		[1+1]		[1+1+1]			[4]
	   			[2]			[1+2]			[1+1+1+1]
	   						[3]				[1+2+1]
	   										[3+1]
	   										[1+1+2]
	   										[2+2]
	   										[1+3]	
	   													
R [1]	[1]		[2]			[3]				 [4]  				[6]

�������� ��������
 - ��������, ��� 5-�� �������� ����������� ������������
 		- 0-�� �������� 1*(5-0) = 5
 		- 1-�� �������� 1*(5-1) = 4			����� 4+1 = 5
 		- 0-�� �������� 2*(5-3) = 6			����� 2+3 = 5
 		- 0-�� �������� 3*(5-3) = 2			����� 3+2 = 5
 		- 0-�� �������� 4*(5-1) = 4			����� 4+1 = 5 		
	   										*/
	
	static long discrete (int n) {
		long Array[] = new long[n+1];
		Array[0] = 1;
		Array[1] = 1;
		Array[2] = 2;
		long mult = 1;
		for (int i = 3; i<=n; i++ ) {
				long result = 0;
			for (int j = 0; j<i; j++) {
				mult = Array[j]*(i - j);
				if (mult >= result) result  = mult;
//				System.out.println(mult);
			}
			Array[i] = result;
			System.out.println("Array[" + i + "] =" + Array[i]);
		}
		return Array[n];
	}
		
	
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int n = sc.nextInt();
	System.out.println("n = " + n);
	long result = 0;
	if (n==1)		result = 1;
	else if (n==2)	result = 2;
	else result = discrete(n);
	System.out.println(result);
	
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(result);
	pw.close();
	
	}
}
 