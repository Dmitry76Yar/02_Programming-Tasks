package f02_ACMP_0_50;

 /*  	�������� �������		(�����: 1 ���. ������: 16 �� ���������: 27%)
���� �������� �� ���������� ����� ���� � ������, ������� ������� ����� ��� ������� �������� �������, � ������� ����� � ��������
������ ����� ����� ����� ����� ���� ������������� ���������, ����� ����� ��� � �������� ������������������ ��������� ������������ �
����������� ������� � ��������� ������������ �����, ������������� � ���� ������������������ ����� ����. ��� �� ��������, ��� 
����������� � ������������ ������� ����������� � �������� ��������� ����� ������ ���� ��� � �� �������� ���������. ��������� �����
������ ���� ������� ��� ���� ����� ���, �� ���� ��� ������� ����������� ���� �������� ���������, ������� �� ��������� ������ 
����� �������������� ������� �������. � ��� �����?
		������� ������
� ������ ������ �������� ����� INPUT.TXT �������� ������������ ����� N � ���������� ��������� �������. ������ ������ �������� N 
����� �����, �������������� �������� ������. ��� �������� ������� ��������� ��������. ������ �� ����� �� ������� �����, � ��� �����
� N, �� ��������� 102 �� ���������� ��������.
		�������� ������
� ������������ ������ ��������� ����� OUTPUT.TXT ����� ������� ��� �����, ����������� ��������: ����� ������������� ��������� � 
������������ �����, ������������� ����� ����������� � ������������ ����������. �������� ����� � ������������ �� ��������� �� ������ 
3*104.

�������
�		INPUT.TXT			OUTPUT.TXT
1			5
		-7 5 -1 3 9			17 -15
2			8
	3 14 -9 4 -5 1 -12 4	26 180
3			10
	-5 1 2 3 4 5 6 7 8 -3	36 5040			 */

import java.io.*;

// ��� ���������� �������� �������� � ��������� ������� ��������� �� ��������� �������� 9999 � -9999 �������������� 
// (��� ����� ����� 3 ����, ������, ���� � ������ ������� ������� ��������� ������������ � ����������� �������� �������). 

import java.util.ArrayList;
import java.util.Scanner; 

public class acmp_0009 {
public static void main(String[] args) throws IOException {
	Scanner sc; 
	int n;
	ArrayList<Integer> array_list = new ArrayList<Integer>();
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	while (sc.hasNext() == true) {
		if (sc.hasNextInt() == true) array_list.add(sc.nextInt()); 	}
	System.out.println(array_list.toString());
	
	boolean correct_input = true;
	for (int i = 0; i<array_list.size(); i++ ) {
		if (Math.abs(array_list.get(i)) > 100) correct_input = false;	}
	
	if ((correct_input == true) && ((array_list.size() -1) ==array_list.get(0))) {
		int max = -9999, min = 9999, sum = 0, max_index = 0, min_index = 0;
		for (int i = 1; i <array_list.size(); i++) {
			if (array_list.get(i) > max) {max = array_list.get(i); max_index = i;}
			if (array_list.get(i) < min) {min = array_list.get(i); min_index = i;}
			if (array_list.get(i) > 0 )  sum = sum + array_list.get(i);  }
		System.out.println(sum);
		System.out.println(max);
		System.out.println(min);
		
		int start_index; 
		int end_index;
		if (max_index > min_index) {start_index = min_index;  end_index = max_index;}
		else {start_index = max_index;  end_index = min_index;}
	
		int mult = array_list.get(start_index+1);
		for (int i = start_index +2; i <end_index; i++) {
			mult = mult*array_list.get(i); 
			System.out.println(mult);
			if (mult >30000) mult = 30000;
			if (mult < -30000) mult = -30000;			}
		System.out.println(mult);	
	
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(sum +" ");
	pw.print(mult);
	pw.close();}
	else System.out.println("������������ ����");

	}
}
