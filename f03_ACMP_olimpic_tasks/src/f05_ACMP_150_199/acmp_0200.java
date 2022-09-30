	package f05_ACMP_150_199;
/* Марсианские факториалы	(Время: 1 сек. Память: 16 Мб Сложность: 60%)
В 3141 году очередная экспедиция на Марс обнаружила в одной из пещер таинственные знаки. Они однозначно доказывали существование
на Марсе разумных существ. Однако смысл этих таинственных знаков долгое время оставался неизвестным. Недавно один из ученых,
профессор Очень-Умный, заметил один интересный факт: всего в надписях, составленных из этих знаков, встречается ровно K
различных символов. Более того, все надписи заканчиваются на длинную последовательность одних и тех же символов.
	Вывод, который сделал из своих наблюдений профессор, потряс всех ученых Земли. Он предположил, что эти надписи являются
записями факториалов различных натуральных чисел в системе счисления с основанием K. А символы в конце – это конечно же нули
– ведь, как известно, факториалы больших чисел заканчиваются большим количеством нулей. Например, в нашей десятичной системе
счисления факториалы заканчиваются на нули начиная с 5! = 1·2·3·4·5 = 120. А у числа 100! в конце следует 24 нуля в десятичной
 системе счисления и 48 нулей в системе счисления с основанием 6 – так что у предположения профессора есть разумные основания!
 	Теперь ученым срочно нужна программа, которая по заданным числам N и K найдет количество нулей в конце записи в системе
 счисления с основанием K числа N! = 1·2·3·…·(N-1)·N, чтобы они могли проверить свою гипотезу. Вам придется написать им такую
программу!
	Входные данные
Входной файл INPUT.TXT содержит числа N и K, разделенные пробелом. (1 ≤ N ≤ 109, 2 ≤ K ≤ 1000).
	Выходные данные
Выведите в выходной файл OUTPUT.TXT число X - количество нулей в конце записи числа N! в системе счисления с основанием K.

Примеры
№	INPUT.TXT	OUTPUT.TXT
1	5 10		1
2	100 10		24
3	100 6		48
4	3 10		0 */

import java.util.*;
import java.io.*;
	 
public class acmp_0200{
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	int K = sc.nextInt();
	N = 100;
	K = 10;
	
	/* Для n = 100 в десятичной системе	 	 Result = 100/5 + 100/25 + 100/125 = 20 + 4 = 24
	 * Для n = 100 в шестеричной системе	 Result = 100/3 + 100/9 + 100/27  + 100/81 = 33 + 11 + 3 + 1 = 48
	 * Для нечетного n = 5 					 Result = 100/5 = 20		 */
	
	int res = 0;
	if (K%2 == 1) res = N/K;
	else {
		if (K == 2) {
			while (true) {
				res = res + N/K;
				K = K*2;
				if (K==0) break;
			}
		}
		else if (K == 4) res = res + N/2 - 1;
		else {
			int del = K/2;
			while (true) {
				int t = N/del;
				res = res + t;
				del = del*K/2;
				if (t==0) break;
			}
		}
	}
	
	System.out.println("RESULT =  " + res);
	
    PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
    o.print(res);
    o.flush();
    o.close();
    }
}