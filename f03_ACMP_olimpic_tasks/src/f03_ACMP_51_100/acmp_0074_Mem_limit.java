package f03_ACMP_51_100;
/*	Прыжки с шестом		(Время: 1 сек. Память: 16 Мб Сложность: 38%)
В соревнованиях по прыжкам с шестом было замечено одно интересное явление: на очередном этапе соревнований успешные и неуспешные попытки
прыжков чередовались: успешный, неуспешный, успешный, неуспешный и т.д. (первый был успешным). Спортсменам разрешалась только одна попытка.
Тот, кто преодолевал планку, переходил в следующий тур (этап), а тот, кто делал неудачную попытку – выбывал из соревнований. Таким образом,
первым выбывал всегда спортсмен с номером 2, а последним – победитель с номером 1.
	Требуется написать программу, которая по количеству участников и номеру спортсмена вычислит, каким по счету данный спортсмен выбыл
из соревнований.
	Входные данные
В единственной строке входного файла INPUT.TXT содержатся два натуральных числа: общее число спортсменов N и порядковый номер спортсмена
в стартовом списке M. Числа разделены пробелом (1 ≤ M,N ≤ 109).
	Выходные данные
В единственную строку выходного файла OUTPUT.TXT нужно вывести каким по счету спортсмен M выбыл из соревнований. Если это победитель
состязания, то выводится число N.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	4 2				1
2	4 1				4
3	9 5				7	 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

// 8 тест 0.353 с

public class acmp_0074_Mem_limit {
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	int M = sc.nextInt();
//	boolean members[] = new boolean[N];
	ArrayList<Boolean> members = new ArrayList<Boolean>();
	for (int i = 0; i<N; i++) members.add(true);
	System.out.println(members);
//	Arrays.fill(members, true);
	
	int count = 0;
	int result = 0;
	if (M == 1) result = N; 
	else {
		boolean exit = false;
		while (members.size() != 1) {
			int count2 = 0;
			for (int i = 0; i<members.size(); i++) {
				if (i%2 != 0) {
					members.set(i, false);
					count++;
					if (i < M) count2++;
					System.out.println(" i = " + i + ",  count = " + count  + ",  count2 = " + count2 + " M = " + M);
					if (i == M-1) {
						result = count;
						exit = true;
						break;
					}
				}
			}
			M = M - count2;
			if (exit == true) break;
			System.out.println(members);
			for (int j = 0; j<members.size(); j++) 
				if (members.get(j) == false) members.remove(j);
			System.out.println(members);
		}
		System.out.println(members);
	}
	System.out.println(result);
	
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(result);
	pw.close();
}
}
