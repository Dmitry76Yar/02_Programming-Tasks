package f04_ACMP_101_200;
/*		Без двух нулей подряд		(Время: 1 сек. Память: 16 Мб Сложность: 37%)
Требуется вычислить количество N-значных чисел в системе счисления с основанием K, таких что их запись не содержит двух подряд
идущих нулей.
	Входные данные
Во входном файле INPUT.TXT записаны два натуральных числа N и K в десятичной системе счисления (2 ≤ K ≤ 10; 2 ≤ N; 4 ≤ N+K ≤ 18).
	Выходные данные
В выходной файл OUTPUT.TXT необходимо вывести целое число в десятичной записи – ответ на задачу.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	2 10			90
2	4 2				5
3	6 3				328
 */

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class acmp_0114_Zeros_in_Dvoichn_figures {
		
				// Расчет через динамическое программирование
		// Ниже кол-во чисел, которые не СОДЕРЖАТ двух нурей подряд (первая цифра - N, вторая - К)
		// Существует закономерность result(i) = (K-1)*result(i-2) + (K-1)*result(i-1) 
		// Двоичная  2-2   3-3  	4-5      5-8     6-13    7-21  8-34		1*2 + 1*3 = 5
		// Третичная 2-6   3-16     4-44     5-120   6-328   7-896			2*6+2*16 = 44
		// Четвертич 2-12  3-45     4-171    5-648 							3*12 + 3*45 = 171
		// Пятиричн  2-20  3-96     4-464    5-2240							4*20+4*96 = 464
		// 6-чная    2-30  3-175
		// 7-чная    2-42  3-288
		// 8-чная    2-56  3-441
		// 9-чная	 2-72  3-640
		// 10-чная   2-90  3-891    4-8829   5-87480  						9*90+9*891 = 8829
	 	
	public static int raschet (int K, int N) {
		int Array[] = new int [N+2];
		Array[0] = 0;
		Array[1] = 0;
		if 		(K==2) {Array[2] = 2; Array[3] = 3;}
		else if (K==3) {Array[2] = 6; Array[3] = 16;}
		else if (K==4) {Array[2] = 12; Array[3] = 45;}
		else if (K==5) {Array[2] = 20; Array[3] = 96;}
		else if (K==6) {Array[2] = 30; Array[3] = 175;}
		else if (K==7) {Array[2] = 42; Array[3] = 288;}
		else if (K==8) {Array[2] = 56; Array[3] = 441;}
		else if (K==9) {Array[2] = 72; Array[3] = 640;}
		else if (K==10) {Array[2] = 90; Array[3] = 891;}
		for (int i = 4; i<=N; i++) {
			Array[i] = (K-1)*(Array[i-2] + Array[i-1]);
		}
		return Array[N];
		
		
	}
	
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();					// Число цифр в числе
	int K = sc.nextInt();					// Система счисления
	int result = 0;
//	System.out.println("N  = " + N +  "  , K = " + K);
	result = raschet(K, N);
	System.out.println("result = "  + result);
	
			// Двоичная  2-2   3-3  	4-5      5-8     6-13    7-21  8-34		1*2 + 1*3 = 5
			// Третичная 2-6   3-16     4-44     5-120   6-328   7-896			2*6+2*16 = 44
			// Четвертич 2-12  3-45     4-171    5-648 							3*12 + 3*45 = 171
			// Пятиричн  2-20  3-96     4-464    5-2240							4*20+4*96 = 464
			// 6-чная    2-30  3-175
			// 7-чная    2-42  3-288
			// 8-чная    2-56  3-441
			// 9-чная	 2-72  3-640
			// 10-чная   2-90  3-891    4-8829   5-87480  						9*90+9*891 = 8829
	
	
		//  Расчет числа цифр с 2-мя нулями через перебор
//	int allFigures = (int)((K-1)*Math.pow(K, N-1));
////	System.out.println("allFigures  =  " + allFigures);
//		
//	int chislo_start = (int)Math.pow(K, N-1);
//	int chislo_end = (int)(Math.pow(K, N) - 1);
//	System.out.println("chislo_start = " + chislo_start +  "   , chislo_end = " + chislo_end);
//		  
//	      int count = 0;
//	      int count2 = 0;
//	      int val = 0;
//	      for (int chislo = chislo_start; chislo<=chislo_end; chislo++) {
//	    	  System.out.println(chislo);
//	    	  val = chislo;
//	    	  count = 0;
//	    	  
//	    	  while (val != 0) {
//	    		  if ((val%K) == 0)  count++;
//			      else count = 0;
//			      if (count == 2) {
////			    	 System.out.println("Число = " + val + "  содержит два нуля   ");
//			    	 count2++;
//			    	 break;
//			     }
//			     val = (int)val/K;
//	    	  }
//	      }
//	      
//	      result = allFigures - count2;
//	      
//	      System.out.println("allFigures = " + allFigures);
//	      System.out.println("count2 =  " + count2);    
//	      System.out.println("result = " + result);
	      
	      PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
			out.println(result);
		    out.flush();
		    out.close();

     }
 }
