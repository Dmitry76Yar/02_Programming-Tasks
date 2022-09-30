package f04_ACMP_101_200;
/* Перепись	(Время: 1 сек. Память: 16 Мб Сложность: 15%)
В доме живет N жильцов. Однажды решили провести перепись всех жильцов данного дома и составили список, в котором указали возраст и
пол каждого жильца. Требуется найти номер самого старшего жителя мужского пола.
	Входные данные
Во входном файле INPUT.TXT в первой строке задано натуральное число N – количество жильцов (N ≤ 100). В последующих N строках
располагается информация о всех жильцах: каждая строка содержит два целых числа: V и S – возраст и пол человека (1 ≤ V ≤ 100, S – 0
или 1). Мужскому полу соответствует значение S=1, а женскому – S=0.
	Выходные данные
Выходной файл OUTPUT.TXT должен содержать номер самого старшего мужчины в списке. Если таких жильцов несколько, то следует вывести наименьший номер. Если жильцов мужского пола нет, то выведите -1.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	4
	25 1
	70 1
	100 0
	3 1				2
2	2
	25 0
	25 1			2		*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0131
{
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	sc.nextLine();
	int maxV = 0;
	int result = 0;
	for (int i=0; i<N; i++) {
		String str = sc.nextLine();
		String[] str_ar = str.split(" ");
		int V = Integer.parseInt(str_ar[0]);
		int S = Integer.parseInt(str_ar[1]);		// Пол  1 - мужской
		System.out.println(" V = " + V + "   S = " + S);
		if ((S==1) && (maxV < V)) {
			maxV = V;
			result = i;
		}
	}
	
	if (maxV==0) result = -1;
	else result++;
	System.out.println(" result = " + result + "   maxV = "  + maxV);
	
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	out.print(result);
    out.flush();
    out.close();
	}
}
