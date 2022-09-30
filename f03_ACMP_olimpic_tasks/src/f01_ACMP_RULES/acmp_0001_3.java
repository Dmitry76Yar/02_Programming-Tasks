/* БЕЗ ВЫЗОВА new MAIN().run() в основном коде программы, как в примере acmp_0001_2
 
  ПРОХОДИТ ПРОВЕРКУ НА САЙТЕ
Время исполнения - 0,118 с, Память - 254 Кб		-	 Нет замедления
*/

package f01_ACMP_RULES;				// УБРАТЬ ДЛЯ САЙТА

import java.io.*;
import java.util.Scanner;

public class acmp_0001_3 {
//public class MAIN {											ЗАМЕНА ДЛЯ САЙТА
	
public static void main(String[] args) throws IOException {
	PrintWriter pw;
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	// sc = new Scanner(new FileReader("input.txt"));			ЗАМЕНА ДЛЯ САЙТА//public class MAIN {											ЗАМЕНА ДЛЯ САЙТА//public class MAIN {											ЗАМЕНА ДЛЯ САЙТА
	int a=sc.nextInt();
	int b=sc.nextInt(); 	
	
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	// pw = new PrintWriter(new FileWriter("output.txt"));		ЗАМЕНА ДЛЯ САЙТА
	pw.print(a+b);
	pw.close();}
}

