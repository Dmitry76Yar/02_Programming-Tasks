package f02_ACMP_0_50;

/*H��	(�����: 1 ���. ������: 16 �� ���������: 19%)
��������� �������� ���������, ������������ ���������� ����� ������� (���) ����� a � b.
	������� ������
� ������������ ������ �������� ����� INPUT.TXT �������� ��� ����������� ����� � � � ����� ������, �� ����������� 46340.
	�������� ������
� ������������ ������ ��������� ����� OUTPUT.TXT ����� ������� ���� ����� ����� � ��� ����� � � �.
	�������
�	INPUT.TXT	OUTPUT.TXT
1	36 27			108
2	39 65			195		 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class acmp_0014 {
public static void main(String[] args) throws IOException {
	Scanner sc; 
	int a = 0;
	ArrayList<Integer> ar_list = new ArrayList<Integer>();
	
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	while (sc.hasNext()) {
		if (sc.hasNextInt())	{
			a = sc.nextInt();
			// ��������� ������ ����������� �����,  �� ����������e 46340
			if ((a <= 46340) & (a>0)) 	ar_list.add(a);}
	}
		
	
	boolean correct_fig = true;
	int result = 0;
	int min= 0;
	int max= 0;
	int temp = 0;
	
		// ���������, ��� ������� 2 �����
	if (ar_list.size() == 2) { 		
		for (int i = 1; i<2; i++)  	
			if (ar_list.get(0) <= ar_list.get(1)) {min = ar_list.get(0); max = ar_list.get(1);}
			else {min = ar_list.get(1); max = ar_list.get(0);}
		System.out.println(min);
		System.out.println(max);
		
		for (int i = 1; i<Integer.MAX_VALUE; i++) {
			temp = min*i;
			if  (temp%max == 0) {
				result = temp;
				break; 	}
		}
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(result);
	pw.close();
	}
	else System.out.println("������������ ����");
	System.out.println(result);
	}

}
