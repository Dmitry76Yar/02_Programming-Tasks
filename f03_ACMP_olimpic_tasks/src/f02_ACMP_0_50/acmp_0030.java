package f02_ACMP_0_50;
/*  	Часы		(Время: 1 сек. Память: 16 Мб Сложность: 30%)
Петя очень любит наблюдать за электронными часами. Он целыми днями смотрел на часы и считал, сколько раз встречается каждая цифра. 
Через несколько месяцев он научился по любому промежутку времени говорить, сколько раз на часах за это время встретится каждая 
цифра, и очень гордился этим.
	Вася решил проверить Петю, но он не знает, как это сделать. Вася попросил Вас помочь ему. Напишите программу, решающую эту задачу.
	Входные данные
Первая и вторая строки входного файла INPUT.TXT содержат начало и конец промежутка времени соответственно. Начальное время не
превосходит конечное. Время задается в формате hh:mm:ss (0 ≤ hh < 24, 0 ≤ mm < 60, 0 ≤ ss < 60). hh, mm, ss дополнены ведущими
нулями до двух символов. Эти нули также учитываются при подсчете числа цифр.
	Выходные данные
Выходной файл OUTPUT.TXT должен содержать 10 строк. В i-ой строке должно быть написано, сколько раз встречается цифра i-1.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1	23:59:58
	23:59:59		0
					0
					2
					2
					0
					4
					0
					0
					1
					3
2	13:24:09
	13:24:40		5
					45
					45
					45
					36
					3
					3
					3
					3
					4				*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0030 {
public static void main(String[] args) throws IOException {
	String str = null;
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	
	str = sc.nextLine();
	String Temp_Time_initial[] = str.split(":");
	int Time_initial[] = new int[Temp_Time_initial.length];
	for (int i = 0; i < Temp_Time_initial.length; i++)	 
		Time_initial[i] = Integer.parseInt(Temp_Time_initial[i]);
	
	str = sc.nextLine();
	String Temp_Time_final[] = str.split(":");
	int Time_final[] = new int[Temp_Time_final.length];
	for (int i = 0; i < Temp_Time_final.length; i++)	 
		Time_final[i] = Integer.parseInt(Temp_Time_final[i]);
	
	System.out.println(Arrays.toString(Time_initial));
	System.out.println(Arrays.toString(Time_final));
	
	int a = Time_initial[0];
	int b = Time_initial[1];
	int c = Time_initial[2];
	String hour = null;
	String min = null;
	String sec = null;
	
	StringBuilder stb = new StringBuilder();
	while (true) {
	if (a/10 == 0) hour = "0" + Integer.toString(a);
	else hour = Integer.toString(a);
	
		while (true) {
			if (b/10== 0) min = "0" + Integer.toString(b);
			else min = Integer.toString(b);
			
				while (true) {
					if (c/10 == 0) sec = "0" + Integer.toString(c);
					else sec = Integer.toString(c);
					System.out.println(hour + min + sec);
					stb.append(hour).append(min).append(sec);
					c++;
				if (c > Time_final[2]) {c = 0; break;}
				}
			b++;
			if (b > Time_final[1]) {b = 0; break;}
		}
	a++;
	if (a > Time_final[0]) {a = 0; break;}
	}
	String result = stb.toString();
	System.out.println("len = " + result.length() );
	int Result[] = new int[10];
	for (int i = 0; i<result.length(); i++) {
		if (result.charAt(i) == '0') 	 Result[0]++;
		else if (result.charAt(i) == '1') Result[1]++;
		else if (result.charAt(i) == '2') Result[2]++;
		else if (result.charAt(i) == '3') Result[3]++;
		else if (result.charAt(i) == '4') Result[4]++;
		else if (result.charAt(i) == '5') Result[5]++;
		else if (result.charAt(i) == '6') Result[6]++;
		else if (result.charAt(i) == '7') Result[7]++;
		else if (result.charAt(i) == '8') Result[8]++;
		else if (result.charAt(i) == '9') Result[9]++;
	}
	
	
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	for (int i = 0; i<10; i++) {
//		System.out.println(Result[i]);
		pw.print(Result[i] + "\n");
	}
	pw.close();
}
}
