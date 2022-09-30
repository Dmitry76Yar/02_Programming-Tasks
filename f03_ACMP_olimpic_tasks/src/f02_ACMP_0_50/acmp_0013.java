package f02_ACMP_0_50;

/*	 ���� � ������		(�����: 1 ���. ������: 16 �� ���������: 26%)
���� � ���� ����� ������ � ��������� ���������� ����. ������� ���� ������� ���� � ����� ���� ����� � ������� � ������ ��� ������ � 
��� ���� �������. ���� ���� ����� ������: ���� ���������� �������������� �����, ��������� �� ��������� ����. ���� ���������� 
���������� ����� �����, ��������� ��������� ��������. ������ ��� ���� ���������� ������� ������ �����, � ���� ������ ���� ���������:
�������� ���������� ����� � �����, ����� ���� ���� � ������ ��������� ���������� ����������� ����� �� ��� ���, ���� �� ��������.
���� � ��� ���������� ���� � ������������ ����� �����, ����������� �� �������� � ������� � ���������� ������� � ���������� ����� 
�����. ������ � ���������� ����, ����������� �� ��������, �� ����������� � �������� �������. ��������, ���� ���� ������� ����� 5671,
� ���� ��������� ������� 7251, �� ����� ����� ����� 1 (������ ����� 1 �� ����� �����), � ����� ����� ����� 2 (������ ����� 7 � 5 �� 
�� ����� ������). ���� ����� � ����������, �� ���� �� ����� ���������. �������� ���� �������� ���������, ������� �� �� ����������� 
����� � ������������� ����� ������ �������� ���������� ����� � �����.
	������� ������
� ������������ ������ �������� ����� INPUT.TXT �������� ��� �������������� ����������� ����� A � B ����� ������, ��� � � ���������� 
����� �����, � � � ������������ ����� �������.
	�������� ������
� �������� ���� OUTPUT.TXT ����� ������� ��� ����� ����� ����� ������ � ���������� ����� � �����.
	�������
�	INPUT.TXT	OUTPUT.TXT
1	5671 7251		1 2
2	1234 1234		4 0
3	2034 6234		2 1		 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class acmp_0013 {
public static void main(String[] args) throws IOException {
	Scanner sc; 
	int a = 0;
	ArrayList<Integer> ar_list = new ArrayList<Integer>();
	
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	while (sc.hasNext()) {
		if (sc.hasNextInt())	{
			a = sc.nextInt();
			// ��������� ������ �������������� �����
			if (Integer.toString(a).length() == 4) 	ar_list.add(a);}
		}
	
		// ���������, ��� ������� 2 �����
	boolean correct_fig = true;
	if (ar_list.size() == 2) {
			// �������� ���, ��� ������������� ���� � �����
		for(int i=0; i<ar_list.size(); i++) {			// ������� ����� � input
			String str = ar_list.get(i).toString();
			// System.out.println(str);
			for(int j=0; j<str.length()-1; j++) 			// ������� �������� � �����, ��������������� �� ������
				for(int k=j+1; k<str.length(); k++) {
					if (str.charAt(j) == str.charAt(k)) correct_fig = false;
					// 	System.out.println("j = " +str.charAt(j) + "  k= " + str.charAt(k)  + " corr = " + correct_fig);
					}
			}
	}
	else System.out.println("������������ ����");
	
	if (correct_fig != false) {
		// �������������� � ArrayList<String>
		ArrayList<String> ar_list_string = new ArrayList<String>();
		for (int i =0; i<ar_list.size(); i++) {
			ar_list_string.add(ar_list.get(i).toString());
		}
//		System.out.println(ar_list.toString());
		
			// ������� ���������� ���� � ���������� ��������� ��� ���� �����
		int count_first = 0; 				
		for (int i=0; i<4; i++) {
			if (ar_list_string.get(0).charAt(i) == ar_list_string.get(1).charAt(i)) count_first++;}
			
			// ������� ���������� ���� � ������ ���������� ��� ���� �����
		int b = 0;			
		for (int l=0; l<4; l++) {
			String str1 = Character.toString(ar_list_string.get(0).charAt(l));
//			System.out.println(str1);
			if (ar_list_string.get(1).contains(str1) == true) b++;
		}
		int count_second = b - count_first;	
//		System.out.println("count_first = " + count_first + " b= " + b + " count_second = " + count_second);
		
		PrintWriter pw;
		pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
		pw.print(count_first);
		pw.print(" ");
		pw.print(count_second);
		pw.close();
	}
	else System.out.println("������������ ����");
//	System.out.println(correct_fig);
	
			
	
	}

}
