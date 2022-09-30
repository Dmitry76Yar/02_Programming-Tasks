package f03_ACMP_51_100;
/*	Загадка		(Время: 1 сек. Память: 16 Мб Сложность: 18%)
Петя и Катя – брат и сестра. Петя – студент, а Катя – школьница. Петя помогает Кате по математике. Он задумывает два натуральных числа X и Y
(X,Y≤1000), а Катя должна их отгадать. Для этого Петя делает две подсказки. Он называет сумму этих чисел S и их произведение P. 
Помогите Кате отгадать задуманные Петей числа.
	Входные данные
Входной файл INPUT.TXT содержит два натуральных числа S и P, разделенных пробелом.
	Выходные данные
В выходной файл OUTPUT.TXT выведите два числа Х и Y, загаданные Петей. Числа следует вывести в порядке неубывания своих значений, разделенные
пробелом.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	4 4				2 2
2	5 6				2 3 */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0063 {
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int S = sc.nextInt();
	int P = sc.nextInt();
	System.out.println("S = " + S + ",   P = " + P);
	
	ArrayList<String> proizv_list = new ArrayList<String>();
	ArrayList<String> summa_list = new ArrayList<String>();
	
	for (int i = 1; i<S; i++)  summa_list.add(Integer.toString(i) + " " + Integer.toString(S-i));

	for (int i = 1; i<P; i++) 
		if ((P%i) == 0) proizv_list.add(Integer.toString(i) + " " + Integer.toString(P/i));

	System.out.println(proizv_list);
	System.out.println(summa_list);
	
	String answer = null;
	for (int i = 1; i<proizv_list.size(); i++) 
		if (summa_list.contains(proizv_list.get(i))) {
			answer = proizv_list.get(i);
			break;
		}
	System.out.println(answer);

	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(answer);
	pw.close();
}
}
