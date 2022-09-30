package f02_ACMP_0_50;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner; 

// œ–»Õﬂ“Œ —¿…“ŒÃ

public class acmp_0008 {
public static void main(String[] args) throws IOException {
	Scanner sc;
	String result = null;
	ArrayList<Integer> arList = new ArrayList<Integer>();
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	while (sc.hasNext() == true) {
		if (sc.hasNextInt() == true) arList.add(sc.nextInt());
		else sc.next();}
	System.out.println(arList.toString());
	
	if ( ((arList.size()) == 3) && (arList.get(0) > 0)  && (arList.get(0) <= 100)  && (arList.get(1) > 0) 
			&& (arList.get(1) <= 100)  && (arList.get(2) > 0)  && (arList.get(2) <=1000000))  {
		if (arList.get(2) == (arList.get(0) * arList.get(1)))		result = "YES"; 
		else result = "NO";
	}
	
	System.out.println(result);
	
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(result);
	pw.close();			
		
	}
}
