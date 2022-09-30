package f04_ACMP_101_200;
/*		Красивые числа	(Время: 1 сек. Память: 16 Мб Сложность: 78%)
	Саша считает красивыми числа, десятичная запись которых не содержит других цифр, кроме 0 и k (1 ≤ k ≤ 9). Например, если k = 2, то
такими числами будут 2, 20, 22, 2002 и т.п. Остальные числа Саше не нравятся, поэтому он представляет их в виде суммы красивых чисел.
Например, если k = 3, то число 69 можно представить так: 69 = 33 + 30 + 3 + 3.
	Однако, не любое натуральное число можно разложить в сумму красивых целых чисел. Например, при k = 5 число 6 нельзя представить
в таком виде. Но если использовать красивые десятичные дроби, то это можно сделать: 6 = 5.5 + 0.5.
	Недавно Саша изучил периодические десятичные дроби и начал использовать и их в качестве слагаемых. Например, если k = 3, то
число 43 можно разложить так: 43 = 33.(3) + 3.(3) + 3 + 3.(3).
	Оказывается, любое натуральное число можно представить в виде суммы положительных красивых чисел. Но такое разложение не
 единственно — например, число 69 можно также представить и как 69 = 33 + 33 + 3. Сашу заинтересовало, какое минимальное количество
слагаемых требуется для представления числа n в виде суммы красивых чисел.
	Требуется написать программу, которая для заданных чисел n и k находит разложение числа n в сумму положительных красивых чисел
с минимальным количеством слагаемых.
	Входные данные
Во входном файле INPUT.TXT записаны два натуральных числа n и k (1 ≤ n ≤ 109; 1 ≤ k ≤ 9).
	Выходные данные
В выходной файл OUTPUT.TXT выведите разложение числа n в сумму положительных чисел, содержащих только цифры 0 и k, количество
слагаемых в котором минимально. Разложение должно быть представлено в виде: n=a1+a2+...+am. Слагаемые a1, a2, ..., am должны быть выведены без ведущих нулей, без лишних нулей в конце дробной части. Запись каждого слагаемого должна быть такой, что длины периода и предпериода дробной части имеют минимально возможную длину. Если решений несколько, то следует вывести то, где меньше слагаемых и по возможности с наименьшим количеством чисел с периодической дробью.
	Например, неправильно выведены числа: 07.7; 2.20; 55.5(5); 0.(66); 7.(0); 7. ; .5; 0.33(03). 
Их следует выводить так: 7.7; 2.2; 55.(5); 0.(6); 7; 7; 0.5; 0.3(30). Предпериод и период каждого из выведенных чисел должны
состоять не более чем из 100 цифр. Гарантируется, что хотя бы одно такое решение существует. Если искомых решений несколько,
выведите любое. Порядок слагаемых может быть произвольным.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	69 3		69=3+33+33
2	6 5			6=0.5+5.5
3	10 9		10=9.(9)
 */

import java.io.*;
import java.util.Scanner;

public class acmp_0110  {
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int a = sc.nextInt();
	
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	out.println(a);
    out.flush();
    out.close();
}
}