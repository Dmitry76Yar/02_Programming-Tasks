package f02_ACMP_0_50;

/*	Зайчик		(Время: 1 сек. Память: 16 Мб Сложность: 55%)
В нашем зоопарке появился заяц. Его поместили в клетку, и чтобы ему не было скучно, директор зоопарка распорядился поставить в его 
клетке лесенку. Теперь наш зайчик может прыгать по лесенке вверх, перепрыгивая через ступеньки. Лестница имеет определенное 
количество ступенек N. Заяц может одним прыжком преодолеть не более К ступенек. Для разнообразия зайчик пытается каждый раз найти 
новый путь к вершине лестницы. Директору любопытно, сколько различных способов есть у зайца добраться до вершины лестницы при 
заданных значениях K и N. Помогите директору написать программу, которая поможет вычислить это количество. Например, если K=3 и N=4,
то существуют следующие маршруты: 1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2, 1+3, 3+1. Т.е. при данных значениях у зайца всего 7 различных 
маршрутов добраться до вершины лестницы.
	Входные данные
В единственной строке входного файла INPUT.TXT записаны два натуральных числа K и N (1 ≤ K ≤ N ≤ 300). К - максимальное количество 
ступенек, которое может преодолеть заяц одним прыжком, N – общее число ступенек лестницы.
	Выходные данные
В единственную строку выходного файла OUTPUT.TXT нужно вывести количество возможных вариантов различных маршрутов зайца на верхнюю 
ступеньку лестницы без ведущих нулей.
	Примеры
№	INPUT.TXT		OUTPUT.TXT
1		1 3				1
2		2 7				21
3		3 10			274
 */

import java.io.*;
import java.util.Scanner; 

public class acmp_0011_Dinamic_pr_Int{
	
	static int variants (int n, int k) {
		int Array[] = new int [n+1];	// 10-ступеней, поэтому нужен 11 элемент (0-вой элемент - это исходная позиция (пол))
		Array[0] = 1;
		Array[1] = 1;
		for (int i = 2; i<=n; i++) {
			int sum = 0;
			if ((i-k)<=0) {
				for (int j = 0; j<i; j++) 	{sum = sum + Array[j]; 
				}
				Array[i] = sum; }
			else {
				for (int j = i-k; j<i; j++) 	{sum = sum + Array[j];
				}
				Array[i] = sum; }
		System.out.println("Array[" + i + "] = " + Array[i]);
			}
		return Array[n];
	}
	
	// 1+1+1, 1+2, 2+1, 3
	
	
public static void main(String[] args) throws IOException {
	Scanner sc;
		
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int k = sc.nextInt();
	int n = sc.nextInt();
	
	/* Для прыжка не более 5 ступенек с лестницей из 10 ступенек
	 * 0-ая ступент -  стоять на месте											1 способ
	 * 1-ая ступень  - 1														1 способ
	 * 2-ая ступень - 1+1, 2													2 способа
	 * 3-ая ступень - 1+1+1, 1+2, 2+1, 3										4 способа
	 * 4-ая ступень	- 1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2, 1+3, 3+1, 4			8 способов
	 * 5-ая ступень	-															16 способов
	 * 	  4-ая + 1шаг	 1+1+1+1+1, 1+1+2+1, 1+2+1+1, 2+1+1+1, 2+2+1, 1+3+1, 3+1+1, 4+1
	 * 	  3-ая + 2 шага	 1+1+1+2, 1+2+2, 2+1+2, 3+2
	 * 	  2-ая + 3 шага	 1+1+3, 2+3
	 * 	  1-ая + 4 шага  1+4
	 * 	  0-ая + 5 шаг 	 0+5
	 * 				 	 Итого 16 способов
	 * 	  Итого 
	 *       - пока не перешли число K, Кол-во шагов = сумма всех предыдущих, начиная с исходной точки (0-вая ступень),
	 *       т.ею для примера выше для 5-ой ступени - можно сделать шаг с 0-вой, 1-вой, 2-ой, 3-ей и 4-ой ступени
	 *       - когда перешли число К, Кол-во шагов = сумма всех предыдущих, НАЧИНАЯ С номера текущей ступени минус К, 
	 *       т.е. для примера выше для 5-ой ступени при К=3, шан можно было бы сделать с 4-о1, 3-ей и 2-ой ступеней  */
	
	int result = 0;
	if (n==1) result = 1;
	else result = variants(n, k);
	
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(result);
	pw.close();
	System.out.println(result);
	
	}
}
