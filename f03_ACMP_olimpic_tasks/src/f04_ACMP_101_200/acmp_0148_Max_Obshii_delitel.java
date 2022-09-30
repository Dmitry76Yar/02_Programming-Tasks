package f04_ACMP_101_200;

/* 	НОД	(Время: 1 сек. Память: 16 Мб Сложность: 15%)
Даны два натуральных числа A и B. Требуется найти их наибольший общий делитель (НОД).
	Входные данные
Во входном файле INPUT.TXT в единственной строке записаны натуральные числа A и B через пробел (A, B ≤ 109).
	Выходные данные
В выходной файл OUTPUT.TXT выведите НОД чисел А и В.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1		12 42		6	*/

import java.util.*;
import java.io.*;

// Мое решение через простые числа
public class acmp_0148_Max_Obshii_delitel	{
public static void main(String[] args) throws IOException {
	Scanner s = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int a = s.nextInt();
	int b = s.nextInt();
	int a1 = a;
	int b1 = b;

	ArrayList<Integer> arr = new ArrayList<Integer>();
	int result = 1;
	int y = 0;
	if (a>b) {
		while(b>1) {
			int c = (int)Math.sqrt(a);
			boolean Array[] = new boolean [c+1];	
			Arrays.fill(Array, true);	
			for (int i = 2; i<=c; i++) {
				if (Array[i] == true)  {
					for (int k = i+i; k<c; k = k + i) {
						Array[k] = false; }
				}
			}
			for (int i = 1; i<=c; i++) 
				if (Array[i]==true) arr.add(i);
			for (int i = arr.size()-1; i>=0; i--) {
				if ((a%arr.get(i) == 0) && (b%arr.get(i) == 0)) {
					y = arr.get(i);
					break;
				}
			}
			if (y ==1) break;
			a = a/y;
			b = b/y;
			result = result*y;
			System.out.println("y = " + y + "  a = " + a + "   result = " + result +   "   b = " + b);
		}
	}
	else {
		while (a>1) {
			int c = (int)Math.sqrt(b);
			boolean Array[] = new boolean [c+1];	
			Arrays.fill(Array, true);
			for (int i = 2; i<=c; i++) {
				if (Array[i] == true)  {
					for (int k = i+i; k<c; k = k + i) {
						Array[k] = false; }
				}
			}
			for (int i = 1; i<=c; i++) 
				if (Array[i]==true) 	arr.add(i);
			for (int i = arr.size()-1; i>=0; i--) {
				if ((a%arr.get(i) == 0) && (b%arr.get(i) == 0)) {
					y = arr.get(i);
					break;
				}
			}
		if (y ==1) break;
		a = a/y;
		b = b/y;
		result = result*y;
		System.out.println("y = " + y + "  b = " + b + "   result = " + result);
		}
	}
	if ((a1%b1 == 0)) result = b1;
	if ((b1%a1 == 0)) result = a1;
	System.out.println("result = " + result);
	
	
	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	o.print(result);
	o.close();
}
}

