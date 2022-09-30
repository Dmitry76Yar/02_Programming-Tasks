package f03_ACMP_51_100;

	import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class acmp_0056_ArrayList {
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int n = sc.nextInt(); 
	sc.nextLine();
	System.out.println("n = " + n);
	ArrayList<String> MyFriends = new ArrayList<String>();
	for (int i = 0; i<n; i++ ) {
		if (sc.hasNextLine() == false) break;
		MyFriends.add(sc.nextLine());
	}
	int m = sc.nextInt();
	System.out.println("m = " + m);
	if (sc.hasNextLine()) sc.nextLine();
	ArrayList<String> Im_in_Friends = new ArrayList<String>();
	System.out.println("ddd");
	for (int i = 0; i<m; i++ ) 	{
		if (sc.hasNextLine() == false) break;
		Im_in_Friends.add(sc.nextLine());
	}
	sc.close();
	
	System.out.println(MyFriends);
	System.out.println(Im_in_Friends);
	
	ArrayList<String> Mutual_Friends = new ArrayList<String>();
	ArrayList<String> Also_Friend_of = new ArrayList<String>();
	for (int i = 0; i<Im_in_Friends.size(); i++ ) 
		if (MyFriends.contains(Im_in_Friends.get(i))) Mutual_Friends.add(Im_in_Friends.get(i));
		else Also_Friend_of.add(Im_in_Friends.get(i));		
	
	Collections.sort(MyFriends);
	Collections.sort(Mutual_Friends);
	Collections.sort(Also_Friend_of);
	
	StringBuffer sbf = new StringBuffer();
	sbf.append("Friends: ");
	sbf.append(MyFriends.toString());
	sbf.append("\nMutual Friends: ");
	sbf.append(Mutual_Friends.toString());
	sbf.append("\nAlso Friend of: ");
	sbf.append(Also_Friend_of.toString());
	System.out.println((sbf.toString()));
	
	for (int i = 0; i<sbf.length(); i++ ) {
		if ((sbf.substring(i, i+1).equals("[")== true) ||  (sbf.substring(i, i+1).equals("]")== true)) {
				sbf.delete(i, i+1); 
				i--;}
	}
	System.out.println();
	String result = sbf.toString();

	System.out.println(result);
	

	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(result);
	pw.close();
}
}
