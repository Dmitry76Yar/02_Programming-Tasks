package f02_ACMP_0_50;
/*  ������� ������		(�����: 1 ���. ������: 16 �� ���������: 35%)
� ������� ����� � ������ �������� ����� ���������� �������� �������. � ����������� ��������� �������� � ���, ���, �������� 
����������, ��������� ������ �������� � ������, a ��������� ������ � b ������. ��������� � �������� ���������� ��� ��� ����� 
��� ����� �� ����� ������ ������, ��������� ����� ����������� ��������� ���� ����. ��� ��������, ��� ������ ����� �� 
���������� ���� ����� ������ ����� � ������������ �������. ������� ��������� ����� ����� ����� ������ ����������� ����� � 
������ a � b, ����� � ���������� �������� a-b (�, ��������������, ���������� �����, ������� �� ������� � ���� � ������), ����
�����������, � � ������ ����� ����� ��������� �� ������ ���������. ��� ���� ������ �������� � ����� ����� � � ���, ��� ����
�� ����� ���� ������ ������ �����, ��������� �� ����. �������� ���������, ������� ������� ����������.
	������� ������
������� ���� INPUT.TXT �������� ��� ����� ����� a � b (-109 < a,b < 109).
	�������� ������
� �������� ���� OUTPUT.TXT �������� ���� ����� ����� � ���������� �������� �����, ������ �� ������� ����� ���� �������� 
������������� ���� a, � ������ � ������������� ���� b.
	�������
�	INPUT.TXT	OUTPUT.TXT
1		18
		10			71
2		1
		-23			33	 */

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class acmp_0032_Array_sort {
	
	static int maximum_a (int a) {
		String a_str;
		a_str = Integer.toString(a);
		String Arr_a[] = a_str.split("");
		System.out.println(Arrays.toString(Arr_a));
		Arrays.sort(Arr_a, Collections.reverseOrder());
//		System.out.println(Arrays.toString(Arr_a));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i<Arr_a.length; i++) sb.append(Arr_a[i]);
		a_str = sb.toString();
		a = Integer.parseInt(a_str);
		System.out.println(a);
		return a;}
	
	static int maximum_b (int a) {   // ���� ����� b �������������, �� ������� ��� �������� � ��������� ���� "-"
		String a_str;
		String temp = Integer.toString(a);
		a_str = temp.substring(1);
		String Arr_a[] = a_str.split("");
//		System.out.println(Arrays.toString(Arr_a));
		Arrays.sort(Arr_a, Collections.reverseOrder());
//		System.out.println(Arrays.toString(Arr_a));
		StringBuilder sb = new StringBuilder();
		sb.append("-");
		for (int i = 0; i<Arr_a.length; i++) sb.append(Arr_a[i]);
		a_str = sb.toString();
		a = Integer.parseInt(a_str);
		System.out.println(a);
		return a;}
	
	static int minimum_a (int a) {
		String a_str;
		String temp = Integer.toString(a);
		a_str = temp.substring(1);
		String Arr_a[] = a_str.split("");
//		System.out.println(Arrays.toString(Arr_a));
		Arrays.sort(Arr_a);
//		System.out.println(Arrays.toString(Arr_a));
		int w = 0;
		if (Arr_a[0].equals("0")) {
			for (int i = 1; i<Arr_a.length; i++) {
				if ((Arr_a[i].equals("1")) || (Arr_a[i].equals("2")) || (Arr_a[i].equals("3")) || (Arr_a[i].equals("4"))  ||
						(Arr_a[i].equals("5")) || (Arr_a[i].equals("6")) || (Arr_a[i].equals("7"))  || (Arr_a[i].equals("8")) || 
						(Arr_a[i].equals("9"))) {
					w = i;
					break;}
			}
			Arr_a[0] = Arr_a[w];
			Arr_a[w] = "0";
			}
		StringBuilder sb = new StringBuilder();
		sb.append("-");
		for (int i = 0; i<Arr_a.length; i++) sb.append(Arr_a[i]);
		a_str = sb.toString();
		a = Integer.parseInt(a_str);
		System.out.println(a);
		return a;
	}
		
	static int minimum_b (int a) {		// ���� ����� b �������������, �� ������� ��� �������
		String a_str;
		a_str = Integer.toString(a);
		String Arr_a[] = a_str.split("");
//		System.out.println(Arrays.toString(Arr_a));
		Arrays.sort(Arr_a);
//		System.out.println(Arrays.toString(Arr_a));
		int w = 0;
		if (Arr_a[0].equals("0")) {
			for (int i = 1; i<Arr_a.length; i++) {
				if ((Arr_a[i].equals("1")) || (Arr_a[i].equals("2")) || (Arr_a[i].equals("3")) || (Arr_a[i].equals("4"))  ||
						(Arr_a[i].equals("5")) || (Arr_a[i].equals("6")) || (Arr_a[i].equals("7"))  || (Arr_a[i].equals("8")) || 
						(Arr_a[i].equals("9"))) {
					w = i;
					break;}
			}
			Arr_a[0] = Arr_a[w];
			Arr_a[w] = "0";
			}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i<Arr_a.length; i++) sb.append(Arr_a[i]);
		a_str = sb.toString();
		a = Integer.parseInt(a_str);
		System.out.println(a);
		return a;
	}
	
public static void main(String[] args) throws IOException {
	int a = 0, b = 0;
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	a = sc.nextInt();
	b = sc.nextInt();
	sc.close();
	System.out.println("a = " + a + "  b= " + b);
	
	if (a>0) a= maximum_a(a);
	else if (a==0) a = 0;
	else a = minimum_a(a);
	
	if (b>0) b = minimum_b(b);
	else if (b==0) b = 0;
	else b = maximum_b(b);
	
	System.out.println(a-b);
	
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(a-b);
	pw.close();
	
	
	}

}
