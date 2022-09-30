package f03_ACMP_51_100;
/*	Бутылки		(Время: 1 сек. Память: 16 Мб Сложность: 48%)
Группа программистов собралась в понедельник и на все свои деньги купила «Sprite» в бутылках емкостью по 0.25 л., не забыв взять сдачу.
Во вторник они сдали пустую посуду, добавили оставшуюся сдачу и вновь купили столько таких же бутылок «Sprite», сколько могли.
Так они действовали до пятницы. В пятницу, сдав посуду и добавив сдачу с четверга, они смогли купить только одну бутылку напитка. 
При этом денег у них уже не осталось.
Требуется написать программу, определяющую минимальную сумму, которой располагали программисты в понедельник.
	Входные данные
Входной файл INPUT.TXT состоит из единственной строки, содержащей два целых числа F (стоимость одной бутылки «Sprite») и P (стоимость 
одной пустой бутылки из под «Sprite»), разделенных пробелом.
	Ограничения: 1 ≤ P < F ≤ 109, начальная сумма не превосходит 2×109.
	Выходные данные
В единственную строку выходного файла OUTPUT.TXT нужно вывести одно целое число – минимальную сумму, которой располагали программисты в понедельник.

Пример
№	INPUT.TXT	OUTPUT.TXT
1	7 3				83 */

import java.io.*;
import java.util.Scanner;
/*  Разбираем пример
купили 					осталось 		сдали			итого на конец дня		
83/7 = 11 бутылок		  6			11*3 = 33			39				
				
купили					осталось 		сдали			итого на конец дня		
39/7 = 5 бутылок			4		5*3 = 15			19		
				
купили					осталось 		сдали			итого на конец дня		
19/7 = 2 бутылки			5		2*3 = 6				11			
				
купили					осталось 		сдали			итого на конец дня		
11/7 = 1 бутылка			4		1*3 = 3	7				купили 1  

Решение с конца
Купили 1 бутылку в пятницу ->   расход = 7 	-> сдали 1 бутылку  -> приход = 3	-> 	остаток после покупки был = 7-3 = 4    
Значит суммма на начало дня  = 4+7 = 11 руб

Находим минимальное количество бутылок, которое надо было сдать ,чтобы набрать минимуум 
Если бы сдали 1 бутылку, то остаток после покупки в четверг был бы 11-3 = 8 и смогли бы купить еще одну бутылку
Если бы сдали 2 бутылки, то остаток после покупки в четверг был бы 11-2*3 = 5 и НЕ смогли бы купить еще одну бутылку
Значит купили 2 бутылки
	расход = 2*7 = 14
	приход 2*3 = 6
	остаток = финальная сумма - приход = 11 - 6 = 5
	суммма на начало дня = остаток + расход = 5+14 = 19
и так далее

*/
				


public class acmp_0078 {
	
		// Считает максимальное число бутылок, которые надо было сдать, чтобы сумма была меньше стоимости бутылки
	public static int max_numbers_of_bottles (int F, int P, int sum) {
		int num_bottl = 0;
		while (true) {
			sum = sum - P;
			num_bottl++;
//			System.out.println("sum = " + sum);
//			System.out.println("(sum - P) " + (sum - P) );
			if (sum < F) break;
			
		}
	return num_bottl;
	}
	
	
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int F = sc.nextInt();		
	int P = sc.nextInt();	
	F = 7; P = 3;
	
	int bottle_numbers = 1;
	int sum = 0;	int rashod = 0;			int prihod = 0;			int ostatok = 0;
			// После последнего дня
	rashod  = bottle_numbers*F;
	prihod =  bottle_numbers*P;			// rashod = ostatok + prihod
	ostatok = rashod - prihod;
	sum = ostatok + rashod;
	System.out.println("RESULT = " + sum);
	
	for (int i =1; i<4; i++) {
		System.out.print("i = " + i);
		bottle_numbers = max_numbers_of_bottles(F, P, sum);
		System.out.print("\t bottle_numbers = " + bottle_numbers);
		rashod  = bottle_numbers*F;
		prihod =  bottle_numbers*P;
		ostatok = sum - prihod;
		sum = ostatok + rashod;
		System.out.print("\t sum = " + sum);
		System.out.println();}
	
	System.out.println("Исходная суммам= " + sum);
  
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(sum);
	pw.close();
}
}