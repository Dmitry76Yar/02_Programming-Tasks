package f01_ACMP_RULES;

import java.util.*;
import java.io.*;

public class acmp_0001_1_Site_solution{ 				//��� ������ ������ ���� Main
//public class MAIN {											������ ��� �����	
	
	 PrintWriter pw;
	 Scanner sc;
	 public void run() throws IOException{
	    sc = new Scanner(new File("input.txt"));
	    int a=sc.nextInt(), b=sc.nextInt();
	    pw = new PrintWriter(new File("output.txt"));
	    pw.print(a+b);
	    pw.close();
	  }
	
public static void main(String[] argv) throws IOException{
  new acmp_0001_1_Site_solution().run();
  // new MAIN().run();											������ ��� �����
  }
}
