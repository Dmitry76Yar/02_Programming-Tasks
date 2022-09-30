package f03_ACMP_51_100;
	/*	Нумеролог		(Время: 1 сек. Память: 16 Мб Сложность: 24%)
Чтобы предсказать судьбу человека, нумеролог берет время жизни человека в секундах, затем складывает все цифры этого числа. Если полученное
число состоит более чем из одной цифры, операция повторяется, пока в числе не останется одна цифра. Затем по полученной цифре и числу операций,
необходимых для преобразования числа в цифру нумеролог предсказывает судьбу человека. Нумеролог плохо умеет считать, а числа, с которыми он
работает, могут быть очень большими. Напишите программу, которая бы делала все расчеты за него.
	Входные данные
Входной файл INPUT.TXT содержит число N – время жизни человека в секундах (1 ≤ N ≤ 101000).
	Выходные данные
В выходной файл OUTPUT.TXT выведите два числа через пробел: полученную цифру из числа N и число преобразований.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	1	1 0
2	10	1 1
3	99	9 2
*/	

import java.io.*;
import java.util.Scanner;

public class acmp_0095  {
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	String lifeTime = sc.nextLine();
	System.out.println(lifeTime);
	
	int count = 0;
	int sum = 0;
	
	if (lifeTime.length() ==1) {
		count  = 0;
		sum = Integer.parseInt(lifeTime); }
	else {
		count = 1;
		for (int i = 0; i<lifeTime.length(); i++) sum = sum + Integer.parseInt(lifeTime.substring(i, i + 1));

		while ((sum/10.0)>=1.0) {
			System.out.println("На входе sum = " + sum);
			count++;
			String temp = Integer.toString(sum);
			System.out.println("temp = " + temp);
			sum = 0;
			for (int i = 0; i<temp.length(); i++) sum = sum + Integer.parseInt(temp.substring(i, i + 1));
		}
	}
	
	System.out.println("count = "  + count);
	System.out.println("sum = " + sum);
	
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
    out.println(sum + " " + count);
    out.flush();
    out.close();
}
}
