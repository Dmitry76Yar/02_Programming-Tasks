package f02_ACMP_0_50;
/*  	Неподвижные точки		(Время: 1 сек. Память: 16 Мб Сложность: 47%)
Перестановкой P[1..n] размера n называется набор чисел от 1 до n, расположенных в определенном порядке. При этом в нем
должно присутствовать ровно один раз каждое из этих чисел. Примером перестановок являются 1,3,4,5,2 (для n=5) и 3,2,1 
(для n=3), а, например, 1,2,3,4,5,1 перестановкой не является, так как число 1 встречается два раза.
	Число i называется неподвижной точкой для перестановки P, если P[i] = i. Например, в перестановке 1,3,4,2,5 ровно две 
неподвижных точки: 1 и 5, а перестановка 4,3,2,1 не имеет неподвижных точек.
	Даны два числа: n и k. Найдите количество перестановок размера n с ровно k неподвижными точками.
	Входные данные
Входной файл INPUT.TXT содержит два целых числа n (1 ≤ n ≤ 9) и k (0 ≤ k ≤ n).
	Выходные данные
В выходной файл OUTPUT.TXT выведите ответ на задачу.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	5 2				20
2	9 6				168
3	2 1				0
4	9 0				133496	*/

import java.io.*;
import java.util.Scanner;

public class acmp_0031_Perestanovka {
	
	static int count = 0;
	static int count2 = 0;
	
	static int printPermutn(String str, String ans, int n, int k) {
	   if (str.length() == 0) {
//	      System.out.println(ans); 
//	   	  arl.add(ans);
		  count2 = 0;
	      for (int i = 0; i<n; i++) {
	    		if (ans.substring(i,i+1).equals(Integer.toString(i+1))) {
	    			count2++;
	    		}
	    	}
	    	if (count2 == k) {
	    		count++;}
	   }
	   
	   for (int i = 0; i < str.length(); i++) {
	   char ch = str.charAt(i);
	   String ros = str.substring(0, i) + str.substring(i + 1);
	   printPermutn(ros, ans + ch, n, k);
	  }
	   return count;
	}
	
	
public static void main(String[] args) throws IOException {
	int n = 0, k = 0;
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	n = sc.nextInt();
	k = sc.nextInt();
	sc.close();
	
	StringBuilder sb = new StringBuilder();
	for (int i = 1; i<=n; i++) sb.append(i);
	String str = sb.toString();
//	System.out.println(str);
	
	int result = printPermutn(str, "", n, k);
	System.out.println(result);
	
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(result);
	pw.close();
	
}
}
