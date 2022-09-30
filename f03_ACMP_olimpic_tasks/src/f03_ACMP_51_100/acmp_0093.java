package f03_ACMP_51_100;
	/*	Боги		(Время: 1 сек. Память: 16 Мб Сложность: 26%)
Археологами найден набор древних копий старинных манускриптов с мифами – различными историями о древних богах. К несчастью, переписчики этих
манускриптов не отличались особой грамотностью и умудрились в каждом имени сделать ровно по одной орфографической ошибке – т.е ровно одну из
букв божественного имени заменили какой-то другой буквой. Археологи смогли составить список правильных написаний имен богов, так же им
удалось выписать из манускриптов все имена собственные. Однако сопоставлять два списка – свыше их сил. Помогите им в этом!
	Входные данные
Первая строка входного файла INPUT.TXT содержит число N – количество имен богов в списке. Следующие N строк – имена богов. Далее идет строка, 
содержащая число M – количество «подозрительных» слов, выписанных из манускриптов. Следующие M строк – «подозрительные» слова. Каждое из имен
богов и «подозрительных» слов – последовательность из K заглавных букв английского алфавита (1 ≤ N, M, K ≤ 30).
	Выходные данные
В выходной файл OUTPUT.TXT выводится N чисел – для каждого божьего имени выводится число “подозрительных” слов, которые являются именем данного
бога с одной ошибкой.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1	3
	ZEUS
	POSEIDON
	AFINA
	4
	ZEVS
	POSEYDON
	AVYNA
	ZERS		2 1	0*/	

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class acmp_0093  {
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
//	System.out.println("N = " + N);
	sc.nextLine();
	ArrayList<String> name_correct_arl = new ArrayList<String>();
	for (int i = 0; i<N; i++) {
		name_correct_arl.add(sc.nextLine());
	}
//	System.out.println(name_correct_arl);
	
	int M = sc.nextInt();
	sc.nextLine();
//	System.out.println("M = " + M);
	int count = 0;
	StringBuffer sbf = new StringBuffer();
	
	// Считывание неправильно написанного имени из файла
	ArrayList<String> name_incorrect_arl = new ArrayList<String>();
	for (int i = 0; i<M; i++) {
		name_incorrect_arl.add(sc.nextLine());
	}
//	System.out.println(name_incorrect_arl);
		
		int count2 = 0;							// Cчетчик числа имен с одной ошибкой
			// Проход по списку правильных имен и сравнение их с данным именем на предмет числа ошибок
		for (int i = 0; i<name_correct_arl.size(); i++) {
			count2 = 0;
			// Проход по списку неправильных имен и сравнение их с данным именем на предмет числа ошибок
			for (int j = 0; j<name_incorrect_arl.size(); j++) {
				count = 0;							// Cчетчик числа ошибочных букв в имени
					// Сначала сверка длины имен и затем посимвольная пробежка по словам
				if (name_correct_arl.get(i).length() == name_incorrect_arl.get(j).length()) {
					for (int k = 0; k<name_correct_arl.get(i).length(); k++) {
						if (name_correct_arl.get(i).charAt(k) != name_incorrect_arl.get(j).charAt(k)) {
							count++;
//							System.out.println(name_correct_arl.get(i) + "   " + name_incorrect_arl.get(j) + "   " + name_correct_arl.get(i).charAt(k) + "   " + name_incorrect_arl.get(j).charAt(k) );
					}
				}
			}
			if (count == 1)  count2++;
//			System.out.println("Name = "  + name_correct_arl.get(i) + " ,   count2 = " +  count2);
		}
		sbf.append(count2 + " ");
	}
	System.out.println(sbf.toString());
	
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
    out.println(sbf.toString());
    out.flush();
    out.close();
}
}
