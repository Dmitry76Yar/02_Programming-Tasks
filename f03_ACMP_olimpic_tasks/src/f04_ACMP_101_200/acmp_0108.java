package f04_ACMP_101_200;

import java.io.*;
import java.util.Scanner;

public class acmp_0108  {
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int a = sc.nextInt();
	
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	out.println(a);
    out.flush();
    out.close();
}
}