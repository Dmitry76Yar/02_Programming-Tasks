/*	����� ���� - �������� ����!				(�����: 1 ���. ������: 16 �� ���������: 8%)
���� � ���� ������ � ����� � ����� ������. ������� ���� ������� ���� � ������ ������� ���������� � ������� ����������� �����,
�������������� �� ����� 5. ������ ���� ����� � ��������� ��������� � ������� ���������� (� ���� ��������� �����������) �����, 
�������������� �� 5. ������ ����������� � ���������: ��� ���������� � ������� �����, ��������������� �� 5 ���������� �������� �����, 
���������� �� ��������� ������������� ��������� ������� �� ��������� �� ������� �����, ����� �������� ���� ��������� �25� � 
������������� ���������� ������. ��������, ��� ����, ����� �������� ����� 125 � ������� ���������� 12 �������� �� 13 � ��������� 25,
 �.�. ���������� � ����� 12*13=156 ����� 25, �������� ��������� 15625, �.�. 1252=15625. �������� ���������, ���������� �����, 
 �������������� �� 5, � ������� ��� ����, ����� ���� ���� ��������� ���� ������.
	������� ������
� ������������ ������ �������� ����� INPUT.TXT �������� ���� ����������� ����� �, �������������� �� ����� 5, �� ����������� 4*10^5.
	�������� ������
� �������� ���� OUTPUT.TXT �������� ���� ����������� ����� - A2 ��� ���������� �����.

�������
�	INPUT.TXT	OUTPUT.TXT
1		5			25
2		75			5625
3		4255	18105025	 */

// ������� ������ 

package f02_ACMP_0_50;

	import java.io.*;
	import java.util.Scanner;
	
	public class acmp_0003 {
	// public class MAIN {
	
		static int calculate (int n) {
			int a = (int)n/10;
			System.out.println(a);
			int result = a*(a+1);
			System.out.println(result);
			return result;
		}
		
		
	public static void main(String[] args) {
		Scanner sc; 
		int a = 0;
		int n = 0;
		String str;
		
		try { 
			sc = new Scanner (new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt")); 
			// sc = new Scanner (new FileReader("input.txt"));							��� ����� �� �����
			if (sc.hasNextInt() == true)	{
				a = sc.nextInt();
//				str = String.valueOf(a);					// ������� ����� � ������
//				boolean endWith = str.endsWith("5");		// ���������� ������������ �� �� "5"
				if ((a >0) & (a<=400000) & (a%10 == 5)) n = a;}
		}				
		catch (FileNotFoundException e) {e.printStackTrace(); 	}
		
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt")); 
			// pw = new PrintWriter(new FileWriter("output.txt"));							��� ����� �� �����
			int result = calculate(n);
			if (result==0)  
				pw.write("25");
			else pw.write(Integer.toString(calculate(n)) + "25");}
		catch (IOException e) { e.printStackTrace();	}
		finally  { pw.close(); }
		
		}
	
	}
