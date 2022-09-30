package f04_ACMP_101_200;

	/*		Шаблон	(Время: 1 сек. Память: 16 Мб Сложность: 65%)
Будем рассматривать слова из больших английских букв и шаблоны, состоящие из больших английских букв и символов «?» и «*». 
Говорят, что слово подходит под шаблон, если в шаблоне можно заменить каждый символ «?» на большую английскую букву, а каждый
символ «*» - на последовательность (возможно, пустую) больших английских букв, так, чтобы получилось требуемое слово. Требуется
написать программу, определяющую, подходит ли слово под шаблон.
	Входные данные
В первых двух строках входного файла INPUT.TXT записаны шаблон и слово: в одной строке записан шаблон - последовательность больших
английских букв, «?» и «*», в другой - слово, состоящее только из больших английских букв. Обе строки входного файла содержат от 1
до 255 символов.
	Выходные данные
В выходной файл OUTPUT.TXT необходимо вывести слово «YES», если слово подходит под шаблон и «NO» в противном случае.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1	ABBCDA
	A*CDA			YES	*/	

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0104  {
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	String string =  sc.nextLine();
	String shabl =  sc.nextLine();
	if (shabl.substring(0,1).equals("*")) shabl = string.substring(0,1) + shabl;
	if (shabl.substring(shabl.length() -1, shabl.length()).equals("*")) shabl = shabl + string.substring(string.length()-1,string.length());
	System.out.println(shabl);
	
//	string.substring(0,1)
//	String [] a = sc.nextLine().split("");
//	String [] b = sc.nextLine().split("");		// Шаблон
//	String [] b_corr;
//	if ((b[0].equals("*")) && (b[b.length-1].equals("*"))   {
//		b_corr = new String[a.length+2];
//	}
//	String [] b_corr = new String[a.length];
//	
//	for (int i = 0; i<b.length; i++) {
//		if (b[i].equals("*")) break;
//		b_corr[i] = a[i];}
//	System.out.println(Arrays.toString(b_corr));

//	int k = a.length-1;
//	for (int i = b.length-1; i>=0; i--) {
//		if (b[i].equals("*")) break;
//		b_corr[k] = a[k];
//		k--;}
//
//	System.out.println(Arrays.toString(b_corr));
		
	
//	for (int i = 0; i<sbf_b.length(); i++) {
//		if (sbf_b.substring(i, i+1).equals("*")) sbf_b.insert(0, a.substring(i, i+1));
//		System.out.println(sbf_b.toString());
			
			
	
	
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
//	out.println(a.add(b));
    out.flush();
    out.close();
}
}