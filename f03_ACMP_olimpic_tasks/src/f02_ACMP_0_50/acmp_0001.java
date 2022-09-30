/* C блоками try - catch
 
  ПРОХОДИТ ПРОВЕРКУ НА САЙТЕ
Время исполнения - 0,103 с, Память - 246 Кб		-	 Нет замедления, даже небольшое ускорение   */

package f02_ACMP_0_50;				// УБРАТЬ ДЛЯ САЙТА

import java.io.*;
import java.util.Scanner;

public class acmp_0001 {
//public class MAIN {																ЗАМЕНА ДЛЯ САЙТА
	
public static void main(String[] args) {
	Scanner sc;
	int a = 0;
	int b = 0;
	
	// 244 1000
	try {
		sc = new  Scanner (new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
		// sc = new Scanner(new FileReader("input.txt"));							ЗАМЕНА ДЛЯ САЙТА											
		if (sc.hasNextInt() == true) a = sc.nextInt();
		if (sc.hasNextInt() == true) b = sc.nextInt();
		}
	catch (IOException e) { 
		e.printStackTrace(); }
	
	//1224
	PrintWriter pw = null;
	try { 
		pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt")); 
		// pw = new PrintWriter(new FileWriter("output.txt"));						ЗАМЕНА ДЛЯ САЙТА
		pw.print(a+b);}
	catch (IOException e1) { 	e1.printStackTrace(); 	}
    finally { pw.close();}
	
}
}