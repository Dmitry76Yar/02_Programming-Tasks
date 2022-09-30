package f03_ACMP_51_100;
/*	Анаграмма		(Время: 1 сек. Память: 16 Мб Сложность: 45%)
Пусть задано некоторое слово, состоящее из букв английского алфавита длиной не более 80 символов (например, “WORD”). Рассмотрим набор 
возможных перестановок, состоящих из букв данного слова (например, “RDOW”, “WODR” и т.д.). Требуется выбрать из этого множества слово, 
следующее по алфавиту за исходным.
	Входные данные
В единственной строке входного файла INPUT.TXT записано слово, не последнее по алфавиту среди возможных его перестановок.
	Выходные данные
В единственную строку выходного файла OUTPUT.TXT нужно вывести следующее слово по алфавиту.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	abdc			acbd
2	word			wrdo	 */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class acmp_0072_Memory_exceed {
	
	static int count = 0;
	static ArrayList<String> arrlist = new ArrayList<String>();
	
	static ArrayList<String> printPermutn(String str, String ans) {
		 if (str.length() == 0) {
           count++;
           arrlist.add(ans);
		 }
        for (int i = 0; i < str.length(); i++) {
       char ch = str.charAt(i);
       String ros = str.substring(0, i) + str.substring(i + 1);
       printPermutn(ros, ans + ch);
       }
       return arrlist;
	}
	
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	String str = sc.nextLine();
	
	ArrayList<String> result = new ArrayList<String>();
	result.add(str);
	result.addAll(printPermutn(str, ""));
	Collections.sort(result);
//	System.out.println(result);
	int index_input = result.indexOf(str);
	System.out.println(index_input);
	String finish = null;
	for (int i = index_input + 1; i<result.size(); i++) {
		System.out.print("str = " + str);
		System.out.println("    result.get(i) = " + result.get(i));
		if (!result.get(i).equals(str)) {
			finish = result.get(i);
			break;}
		}
	
//	finish = result.get(index_input+1);
	System.out.println(result);
	System.out.println(finish);
	System.out.println("result.length = " + result.size());
	
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(result);
	pw.close();
}
}
