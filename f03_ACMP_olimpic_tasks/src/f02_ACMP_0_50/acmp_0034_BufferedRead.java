package f02_ACMP_0_50;
/*  Секретное сообщение  (Время: 0,2 сек. Память: 16 Мб Сложность: 36%)
На секретную базу в Арктике поступила шифровка – последовательность из n десятичных цифр. Она содержит номер секретной базы 
в Антарктиде, который является последовательностью из k десятичных цифр. При этом для того, чтобы отличить его от ненужной 
Вам информации, он повторен в шифровке хотя бы два раза (возможно, эти два вхождения перекрываются).
	Напишите программу, которая по шифровке и длине номера секретной базы определяет, содержит ли шифровка номер базы. 
Учтите, что у базы может быть несколько номеров, и все они могут быть переданы в шифровке.
	Входные данные
Первая строка входного файла INPUT.TXT содержит два целых числа: n (1 ≤ n ≤ 105) и k (1 ≤ k ≤ 5) – длину шифровки и длину 
номера секретной базы соответственно. Вторая строка содержит n цифр – шифровку. Помните, что цифры в шифровке не разделяются
пробелами.
	Выходные данные
В выходной файл OUTPUT.TXT выведите «YES», если шифровка содержит номер секретной базы, и «NO» в противном случае.
	Примеры
№	INPUT.TXT		OUTPUT.TXT
1		10 5
	0123456789			NO
2		13 2
	0123400056789		YES		 */


// Только после перехода на BufferedReader удалось выйти из Time exceed

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;

public class acmp_0034_BufferedRead {
public static void main(String[] args) throws IOException {
	int n = 0, k = 0;
	
	BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\JavaTXT\\ACMP_0001\\input.txt"), Charset.forName("UTF-8")));
	String str = reader.readLine();
	String Array1[] = str.split(" ");
	n = Integer.parseInt(Array1[0]);
	k = Integer.parseInt(Array1[1]);
	System.out.println("n = " + n + "  k= " + k);
	
	str = reader.readLine();
	reader.close();
	System.out.println(str);
	
	String Array[] = new String [n-k+1];
	for (int i=0; i<n-k+1; i++) {
		Array[i] = str.substring(i,i+k);}
	
	System.out.println(Arrays.toString(Array));		
	Arrays.parallelSort(Array);
	System.out.println(Arrays.toString(Array));
	
	String result = "NO";
	
	for (int i=0; i<Array.length-1; i++) {
			if ((Array[i].hashCode() == Array[i+1].hashCode()) && (Array[i].equals(Array[i+1]))) {
				result = "YES";
				break;
			}
	}
	
	System.out.println(result);
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(result);
	pw.close();
	
	}
}
