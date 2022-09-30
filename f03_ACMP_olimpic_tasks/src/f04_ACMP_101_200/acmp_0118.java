package f04_ACMP_101_200;
/*Задача Иосифа Флавия	(Время: 1 сек. Память: 16 Мб Сложность: 29%)
Существует легенда, что Иосиф Флавий - известный историк первого века - выжил и стал известным благодаря математической одаренности. 
В ходе иудейской войны он в составе отряда из 41 иудейского воина был загнан римлянами в пещеру. Предпочитая самоубийство плену, 
воины решили выстроиться в круг и последовательно убивать каждого третьего из живых до тех пор, пока не останется ни одного человека. 
Однако Иосиф наряду с одним из своих единомышленников счел подобный конец бессмысленным - он быстро вычислил спасительные места в
порочном круге, на которые поставил себя и своего товарища. И лишь поэтому мы знаем его историю…
	В нашем варианте мы начнем с того, что выстроим в круг N человек, пронумерованных числами от 1 до N, и будем исключать каждого 
k-ого до тех пор, пока не уцелеет только один человек.
	Например, если N=10, K=3, то сначала умрет 3-й, потом 6-й, затем 9-й, затем 2-й, затем 7-й, потом 1-й, потом 8-й, за ним - 5-й,
и потом 10-й. Таким образом, уцелеет 4-й.
	Требуется написать программу, которая по заданным N и K будет определять номер уцелевшего человека.
	Входные данные
Входной файл INPUT.TXT содержит два натуральных числа N и K. Ограничения: N ≤ 500, K ≤ 100.
	Выходные данные
В выходной файл OUTPUT.TXT нужно вывести номер уцелевшего человека.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1	10 3			4
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class acmp_0118 {
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	int K = sc.nextInt();
	System.out.println(" N = " + N + " K = " + K);
	
	ArrayList<Integer> spisok = new ArrayList<Integer>();
	for (int i = 0; i<=N; i++) spisok.add(i);
//	System.out.println(spisok);
	ArrayList<Integer> List_excluded_for_one_cycle = new ArrayList<Integer>();
	
//	if (K/N >=2) {
//		System.out.println("ff= " + (int)K/N);
//		System.out.println(N*(K/(int)N -1));
//		K = (K - (N*(K/(int)N -1)));
//		System.out.println(" K = " + K);
//	}
	
	int startNextRound = 0;	
	int result = 0;
	while (spisok.size() !=2) {
		if (K/(spisok.size()-1) >=2) {
			K = (K - (N*(K/(int)N -1)));
		}
		for (int i = startNextRound; i<spisok.size(); i=i+K) {
			System.out.println("i = " + i);
			if (i!=0) {
				List_excluded_for_one_cycle.add(spisok.get(i));
				startNextRound = K - (spisok.size() - i -1);
				if (startNextRound/(spisok.size()-1) >=1)  	startNextRound = startNextRound%(spisok.size()-1);
			}
			else {
				startNextRound = K - (spisok.size() - i -1);
				if (startNextRound/(spisok.size()-1) >=1)  	startNextRound = startNextRound%(spisok.size()-1);
			}
		}
		if (List_excluded_for_one_cycle.size() == spisok.size() -1) {
			result = List_excluded_for_one_cycle.get(List_excluded_for_one_cycle.size() - 1); 
		}
		else {
			for (int i = 0; i<List_excluded_for_one_cycle.size(); i++) spisok.remove(List_excluded_for_one_cycle.get(i));
			System.out.println("List_excluded_for_one_cycle " + List_excluded_for_one_cycle);
			System.out.println("spisok " + spisok);
			System.out.println("startNextRound = " + startNextRound);
			System.out.println();
			List_excluded_for_one_cycle.clear();
		}
		if (result != 0) break;
	}
	
	if (result == 0) result = spisok.get(1);
	System.out.println("result = " + result);
	
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	out.println(result);
    out.flush();
    out.close();
	}
}
