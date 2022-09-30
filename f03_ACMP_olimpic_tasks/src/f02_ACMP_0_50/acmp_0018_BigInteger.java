package f02_ACMP_0_50;

/*  ���������		(�����: 1 ���. ������: 16 �� ���������: 42%)
��������� ��������� ��������� ������ ����� N. ��������� ���������� ��� N! � ��������� �� �������:
N! = 1 * 2 * 3 * � * (N-1) * N, ������ 0! = 1.
��� �� ��������� ������������ �����������: N! = (N-1)! * N
	������� ������
� ������������ ������ �������� ����� INPUT.TXT �������� ���� ����� ��������������� ����� N (N < 1000).
	�������� ������
� �������� ���� OUTPUT.TXT ����� ������� ���� ����� ����� � �������� N!.
	�������
�	INPUT.TXT	OUTPUT.TXT
1		1			1
2		3			6
3		5			12  	 */

import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

public class acmp_0018_BigInteger{
public static void main(String[] args) throws IOException {
	Scanner sc; 
	int n = 0;
	boolean correct_input = true;			
	
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	if (sc.hasNextInt() == true) n = sc.nextInt();
	if ((n<0) & (n>=1000)) correct_input = false;
	System.out.println(n);
	
	if (correct_input == true) {
		BigInteger result = new BigInteger("1");
		int i_temp;
		BigInteger i = new BigInteger("1");
		if (n == 0) result = new BigInteger("1");
		else {
			while (true) {
				result = i.multiply(result);
				i = i.add(new BigInteger("1"));
				i_temp = i.intValue();
				if (i_temp>n) 	break;
			}
		}
//			System.out.println(result);
				
		PrintWriter pw;
		pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
		pw.print(result);
		pw.close();
		System.out.println(result);
	}
	else System.out.println("������������ ����");
}
}	
