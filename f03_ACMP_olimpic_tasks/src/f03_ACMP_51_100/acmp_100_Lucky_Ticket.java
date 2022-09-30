package f03_ACMP_51_100;
	/*		Счастливые билеты		(Время: 1 сек. Память: 16 Мб Сложность: 68%)
Требуется вычислить количество N - значных счастливых билетов. Напомним, что билет называется счастливым, если сумма первой
половины его цифр равна сумме другой его половины. Например, билет 064109 счастливый, т.к. 0+6+4=1+0+9.
	Входные данные
В единственной строке входного файла INPUT.TXT записано натуральное четное число N (N ≤ 100) – количество цифр в билете.
	Выходные данные
В единственную строку выходного файла OUTPUT.TXT нужно вывести одно целое число – количество N-значных счастливых билетов.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	4			670
2	6			55252
3	12			39581170420
*/	

/* Решение - http://www.ega-math.narod.ru/Quant/Tickets.htm#A2
 *  - N - число цифр в каждой половине билета (для 4-хзначного билета - 2)
 *  - вычисление всех вариантов сумм первой половины числа - 9*N (для N = 1 - 0,1,2,3,4,5,6,7,8,9)
 *  - вычисление кол-ва вариантов для получения каждой из сумм для N-значного числа ((для N = 1, для суммы = 5 - 0-5,1-4,2-3,3-2,4-1,5-0)
 *  Для этого нужно расчет для N -значного числа производить по N-1 -значному числу   
 *     - создаем 2 массива из 450 ячеек (максим. кол-во вараинтов сумм для 50-значного числа (50*9))
 *     - заполняем его нулями
 *     - для 1-значного числа сумма первой цифры всегда ей же и равно. Заполняем 1-ый массив чилами 0,1,2,3,4,5,6,7,8,9
 *     - переходим к 2-му числу. Здесь массив уже должен содержать 18 ненулевых элементов - 18 вариантов сумм первых 2-х числе билета
*      - в двухзначном числе первая цифра может быть от 0 до 9, в этом случае вторая цифра будет равна (сумма 2-х чисел - 1-ое число)
*      - вторая цифра является уже (N-1) значной и мы можем получить кол-во вариантов для нее из 1-ой матрицы
*      - таким образом, для каждой суммы М от 0 до 18 (для 2-х значного числа):
*           -  нужны перебрать 1-ое число от 0 до М  	Например, 
*           - для каждого из них будет соответствововать 2-ая цифра = (сумма М - 1-ое число), кол-во вариантов получения которого
*           взять из матрицы первой
*      - если смотреть на таблицк ниже, то значение варианта каждой сумму равно 10 значениям предыдущей матрицы  (или меньше, если сумма меньше 10)
*    - сложить квадраты всех вариантов сумм - это искомое кол-во счастливых билетов
*      
*       0	1	1	1
		1	1	2	3
		2	1	3	6
		3	1	4	10
		4	1	5	15
		5	1	6	21
		6	1	7	28
		7	1	8	36
		8	1	9	45
		9	1	10	55
		10		9	63
		11		8	69
		12		7	73
		13		6	75
		14		5	75
		15		4	73
		16		3	69
		17		2	63
		18		1	55
		19			45
		20			36
		21			28
		22			21
		23			15
		24			10
		25			6
		26			3
		27			1
					

 *  
 *  
 * Вычисление кол-в
 * 
 * 
 */


import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_100_Lucky_Ticket  {
	
	public static BigInteger calc (BigInteger arr[], int N) {
		BigInteger result = new BigInteger("0");
		if (N<10) {
			for (int i = 0; i<=N; i++)  result = result.add(arr[i]);
		}
		else {
			for (int i = N-9; i<=N; i++)  result = result.add(arr[i]);
		}
		return result;
	}
	
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt(); 
	N = N/2; 
	BigInteger previous[] = new BigInteger[451];
	BigInteger current[] = new BigInteger[451];
	Arrays.fill(previous, new BigInteger("0"));
	Arrays.fill(current, new BigInteger("0"));
	for (int i = 0; i<=9; i++) {
		previous[i] = new BigInteger("1");
		current[i] = new BigInteger("1");
	}
	
	for (int i = 2; i<=N; i++) {
		for (int j = 0; j<=9*i; j++) {
			current[j] = calc(previous, j);
		}
		for (int a = 0; a<451; a++)   previous[a] = current[a];
		System.out.println(Arrays.toString(current));
	}
	
	BigInteger sum = new BigInteger("0");
	BigInteger temp2 = new BigInteger("1");
	for (int i = 0; i<current.length; i++) {
		temp2 = current[i].multiply(current[i]);
		sum = sum.add(temp2);
	}
	
	System.out.println(sum);
	
	
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
    out.println(sum);
    out.flush();
    out.close();
}
}
