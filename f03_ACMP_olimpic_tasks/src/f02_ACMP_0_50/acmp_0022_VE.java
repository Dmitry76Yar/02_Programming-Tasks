package f02_ACMP_0_50;

/*	Память: 16 Мб Сложность: 16%)
На уроках информатики вас, наверное, учили переводить числа из одних систем счисления в другие и выполнять другие подобные операции.
Пришло время продемонстрировать эти знания. Найдите количество единиц в двоичной записи заданного числа.
	Входные данные
Во входном файле INPUT.TXT записано целое число n (0 ≤ n ≤ 2×109).
	Выходные данные
В единственную строку выходного файла OUTPUT.TXT нужно вывести одно целое число — количество двоичных единиц в записи числа n.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	5			2
2	7			3	 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class acmp_0022_VE {
public static void main(String[] args) throws IOException {
	int a = 0;
	int f = 0;
	double c= 0;
	ArrayList<Integer> arrl = new ArrayList<Integer>();
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	while (sc.hasNext()) 
		if (sc.hasNextInt()) a = sc.nextInt();
	
	if ((a>=0) & (a<=2000000000)) { 
		while (true) {
			f = a;
			c = a/2;
			a = (int)a/2; 
			System.out.println(a);
			arrl.add(f%2);
			if (c <1 ) break;
		}
		System.out.println(arrl);
	
	int count = 0;
	for (int i = 0; i<arrl.size(); i++) 
		if (arrl.get(i) == 1) count++;
	System.out.println(count);
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(count);
	pw.close();
	}
	}
}
