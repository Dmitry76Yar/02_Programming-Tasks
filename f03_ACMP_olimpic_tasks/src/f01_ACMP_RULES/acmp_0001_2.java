/* опнундхр опнбепйс мю яюире
бПЕЛЪ ХЯОНКМЕМХЪ - 0,118 Я, оЮЛЪРЭ - 270 йА
*/

package f01_ACMP_RULES;				// сапюрэ дкъ яюирю

import java.io.*;
import java.util.Scanner;

public class acmp_0001_2 {
//public class MAIN {     					гюлемю дкъ яюирю
	
public void run() throws IOException{
	PrintWriter pw;
	Scanner sc;
 	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
 	// sc = new Scanner(new FileReader("input.txt"));			гюлемю дкъ яюирю
 	int a=sc.nextInt();
 	int b=sc.nextInt(); 	
 	
 	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
 	// pw = new PrintWriter(new FileWriter("output.txt"));		гюлемю дкъ яюирю
 	pw.print(a+b);
 	pw.close();}
		  
public static void main(String[] args) throws IOException {
	new acmp_0001_2().run();	}
	// new MAIN().run();	}									гюлемю дкъ яюирю
	
}

