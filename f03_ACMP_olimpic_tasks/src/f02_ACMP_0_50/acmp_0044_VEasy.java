package f02_ACMP_0_50;
/*	 �������		(�����: 1 ���. ������: 16 �� ���������: 20%)
������ ������������������, ��������� ������ �� �������� �>�, �<� � �-�. ��������� ����� ���������� �����, ������� �������� 
� ���� ������������������. ������ � ��� ��������� ���� �>>-->� � �<--<<�.
	������� ������
� ������ ������ �������� ����� INPUT.TXT �������� ������, ��������� �� �������� �>�, �<� � �-� (��� ��������). ������ �������
�� �����, ��� �� 250 ��������.
	�������� ������
� ������������ ������ ��������� ����� OUTPUT.TXT ����� ������� ������� ���������� �������.
	������
�	INPUT.TXT						OUTPUT.TXT
1	<<<<>>--><--<<--<<>>>--><<<<<		4 */

import java.io.*;
import java.util.Scanner;

public class acmp_0044_VEasy {
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	String str = sc.nextLine();
	System.out.println("str = " + str);		//<<<<>>--><--<<--<<>>>--><<<<<\
	sc.close();
	System.out.println(str.length());
	int count = 0;
	for (int i = 0; i<str.length()-4; i++) {
		if (str.substring(i, i+5).equals(">>-->") || (str.substring(i, i+5).equals("<--<<"))) count++;
		System.out.println(str.substring(i, i+5));
	}
	System.out.println(count);
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(count);
}
}
