package f06_ACMP_200_201;

	/* Поиск подстроки		(Время: 0,2 сек. Память: 16 Мб Сложность: 38%)
Найти все вхождения строки T в строке S.
	Входные данные
В первой строке входного файла INPUT.TXT записана строка S, во второй строке записана строка T. Обе строки состоят только из
английских букв. Длины строк могут быть в диапазоне от 1 до 50 000 включительно.
	Выходные данные
В выходной файл OUTPUT.TXT нужно вывести все вхождения строки T в строку S в порядке возрастания. Нумерация позиций строк
начинается с нуля.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1	ababbababa
aba	0 5 7
 */

import java.io.*;
import java.nio.charset.Charset;

public class acmp_0202_SubStringFind{

	static StringBuilder sb = new StringBuilder();
	
		//Алгоритм Кнута — Морриса — Пратта
	public static void indexesOf(char[] pattern, char[] text) 	{
	    int[] pfl = pfl(pattern);
	    int k = 0;
	    for (int i = 0; i < text.length; ++i)   {
	        while (pattern[k] != text[i] && k  > 0)   
	            k = pfl[k - 1];
	        if (pattern[k] == text[i])  {
	            k = k + 1;
	            if (k == pattern.length)  {
//	                System.out.println("k = " + (i + 1 - k));
	                sb.append((i + 1 - k) + " ");
	                k = pfl[k - 1];
	            }
	        }
	        else  k = 0;
	    }
	}

	public static int[] pfl(char[] text) {
	    int[] pfl = new int[text.length];
	    pfl[0] = 0;

	    for (int i = 1; i < text.length; ++i)  {
	        int k = pfl[i - 1];
	        while (text[k] != text[i] && k > 0) 
	            k = pfl[k - 1];
	        if (text[k] == text[i])   
	            pfl[i] = k + 1;
	        else
	            pfl[i] = 0;
	    }
	    return pfl;
	}
	
public static void main(String[] args) throws IOException {
	BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\JavaTXT\\ACMP_0001\\input.txt"), Charset.forName("UTF-8")));
	String str = reader.readLine();
	String subStr = reader.readLine();
	reader.close();
	
	indexesOf(subStr.toCharArray(), str.toCharArray());
	System.out.println(sb);
	
	BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	writer.write(sb.toString());
	writer.close();
}
}




