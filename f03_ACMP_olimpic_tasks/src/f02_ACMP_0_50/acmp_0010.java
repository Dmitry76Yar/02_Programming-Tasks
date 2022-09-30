package f02_ACMP_0_50;
/*	Уравнение 	(Время: 1 сек. Память: 16 Мб Сложность: 17%)
Вася в школе изучил квадратные уравнения и понял, как они легко решаются путем вычисления дискриминанта. Но Петя поведал ему о
методе решения кубических уравнений вида A*X3 + B*X2 + C*X + D = 0. На факультативе по математике Васе задали решить около ста 
уравнений как раз такого вида. Но, к сожалению, Вася забыл формулы, о которых рассказывал ему Петя. Но Васе было известно, что все 
корни уравнений – целые числа и находятся на отрезке [-100, 100]. Поэтому у Васи есть шанс найти их методом перебора, но для этого
ему придется затратить уйму времени, т.к. возможно необходимо будет осуществить перебор нескольких тысяч значений. Помогите Васе
написать программу, которая поможет ему найти корни кубических уравнений!
	Входные данные
В единственной строке входного файла INPUT.TXT записаны 4 числа: A, B, C и D – целые коэффициенты кубического уравнения. Каждый
коэффициент по модулю меньше 32768, A ≠ 0.
	Выходные данные
В единственную строку выходного файла OUTPUT.TXT нужно вывести через пробел в порядке возрастания все корни заданного кубического 
уравнения. Кратные корни следует выводить только один раз.

Примеры
№		INPUT.TXT		OUTPUT.TXT
1		1 -3 0 0			0 3
2		3 -15 18 0			0 2 3
3		1 -7 -33 135		-5 3 9		  */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner; 

public class acmp_0010 {
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	String str = sc.nextLine();
	String str2[] = str.split(" ");
	System.out.println(Arrays.toString(str2));
	String str1[] = new String[4];
	int j = 0;
	for (int i= 0; i<str2.length; i++) {
		if (str2[i].equals("") == true) System.out.println("probel");
		else {
			str1[j] = str2[i];
			  j++;		}
	}
	System.out.println(Arrays.toString(str1));
	
	long Arr_fig[] = new long [str1.length];
	for (int i= 0; i<str1.length; i++) {
		Arr_fig[i] = Long.parseLong(str1[i]);
		}
	System.out.println(Arrays.toString(Arr_fig));
	
	ArrayList<Integer> arl = new ArrayList<Integer>();
	long calc = 0;
	for (int i = -100; i<=100; i++) {
		calc = Arr_fig[0]*i*i*i + Arr_fig[1]*i*i + Arr_fig[2]*i + Arr_fig[3];
		System.out.println(calc);
		if (calc == 0) arl.add(i);
	}
	System.out.println(arl);
	
		PrintWriter pw;
		pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
		for (int i = 0; i<arl.size(); i++) pw.print(arl.get(i) + " ");
		pw.close();
}
}
