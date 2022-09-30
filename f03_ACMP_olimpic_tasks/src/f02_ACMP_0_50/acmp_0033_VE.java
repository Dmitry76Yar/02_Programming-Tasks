package f02_ACMP_0_50;

import java.io.*;
import java.util.Scanner;

public class acmp_0033_VE{
public static void main(String[] args) throws IOException {
	int a = 0, b = 0;
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	a = sc.nextInt();
	b = sc.nextInt();
	sc.close();
	System.out.println("a = " + a + "  b= " + b);
	
	int sum_ban = (a-1) + (b-1) +1;
		
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(sum_ban - a);
	pw.print(" ");
	pw.print(sum_ban - b);
	pw.close();
	
	}

}
