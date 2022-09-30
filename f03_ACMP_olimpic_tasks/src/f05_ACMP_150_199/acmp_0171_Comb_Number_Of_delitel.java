	package f05_ACMP_150_199;

/*  Количество делителей	(Время: 1 сек. Память: 16 Мб Сложность: 50%)
Пусть х — натуральное число. Назовем у его делителем, если 1 ≤ у ≤ х и остаток от деления х на у равен нулю.
Задано число х. Найдите количество его делителей.
	Входные данные
Входной файл INPUT.TXT содержит заданное число x (1 ≤ x ≤ 1018). Все простые делители числа x не превосходят 1000.
	Выходные данные
В выходной файл OUTPUT.TXT выведите ответ на задачу.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1				12	6
2				239	2		 */

import java.util.*;
import java.io.*;
import java.math.BigInteger;

/* РЕШЕНИЕ
Для решения данной задачи мы воспользуемся одной из теорем комбинаторики.
Теорема. Если существует K классов, содержащих соответственно n1 , n2 , . . . nK элементов, то число различных способов выбора
элементов равно (n1 + 1)(n2 + 1)...(nK + 1)
	Для определенности рассмотрим на примере. В коробке лежат 10 шаров синего, 8 красного и 5 желтого цветов. Сколькими способами
можно достать данные шары из коробки? Разумеется, что все шары доставать необязательно, например, можно достать 2 синих, 4 желтых и
3 красных шара, или 1 синий и 5 желтых. А ведь можно и вообще их не доставать, этот случай тоже является случаем выбора шаров,
в результате которого получается пустое множество выбранных элементов.
	Для ответа на этот вопрос следует воспользоваться вышеприведенной теоремой. Мы имеем три класса:
Шары синего
Желтого
Красного цветов
	Число элементов первого класса равно 10, второго - 8, третьего, соответственно, 5. Тогда общее количество возможных вариантов
выбора будет равно S = (10 + 1)(8 + 1)(5 + 1) = 594. То есть число различных способов выбора шаров из коробки равно 594.
	Эту задачу можно было бы решать и методом полного перебора, что значительно увеличит время выполнения программы.
	Теперь проведем аналогию между нашей задачей и задачей про шары. Основная теорема арифметики гласит, что любое натуральное число 
можно представить в виде произведения простых чисел, входящих в разложение данного числа в различных степенях. Классом в нашем случае
является простое число. Количеством элементов - степень, в которой это число входит в разложение.
	Тогда для решения задачи необходимо разложить число x на простые множители, посчитать сколько раз встречается каждое простое число
в разложении и перемножить соотвествующие результаты в соответствии с вышеприведенной формулой.
 */

public class acmp_0171_Comb_Number_Of_delitel{
	
static ArrayList<Integer> arl = new ArrayList<Integer>();
	
	public static void recursion(BigInteger n) {
		if (n.compareTo(new BigInteger("1"))==0) return;
		for (int i = 2; i<=1000; i++) {
			if (n.mod(new BigInteger(Integer.toString(i))).compareTo(new BigInteger("0")) == 0) {
				arl.add(i);
				recursion(n.divide(new BigInteger(Integer.toString(i))));
				break;
			}
		}
	}
	
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	BigInteger N = new BigInteger(sc.nextLine());
//	BigInteger N = new BigInteger("12");
	
	int result = 1;
	if (N.compareTo(new BigInteger("1")) == 0) result = 1;
	else {
		recursion(N);
		if (arl.size() == 0) arl.add(1);
	//	System.out.println(arl);
		
		ArrayList<Integer> numberOfEachFigure = new ArrayList<Integer>();
		int a = arl.get(0);
		numberOfEachFigure.add(1);
		int j = 0;
		for (int i=1; i<arl.size(); i++) {
			if (arl.get(i) == a) numberOfEachFigure.set(j, numberOfEachFigure.get(j) + 1);
			else {
				a = arl.get(i);
				j++;
				numberOfEachFigure.add(1);
			}
		}
	//	System.out.println(numberOfEachFigure);
		for (int i=0; i<numberOfEachFigure.size(); i++) result = result*(numberOfEachFigure.get(i) +1);
	}
	System.out.println("result = " + result);
	
	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	o.print(result);
	o.flush();
	o.close();
}
}