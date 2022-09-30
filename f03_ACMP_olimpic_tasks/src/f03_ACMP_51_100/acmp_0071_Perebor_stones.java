package f03_ACMP_51_100;
/*	Две кучки камней		(Время: 1 сек. Память: 16 Мб Сложность: 43%)
У Вас есть N камней с массами W1, W2 , … WN. Требуется разложить камни на 2 кучки так, чтобы разница масс этих кучек была минимальной.
	Входные данные
В первой строке входного файла INPUT.TXT записано число N – количество камней (1 ≤ N ≤ 18). Во второй строке через пробел перечислены
массы камней W1, W2 , … WN (1 ≤ Wi ≤ 105).
	Выходные данные
В единственную строку выходного файла OUTPUT.TXT нужно вывести одно неотрицательное целое число – минимально возможную разницу между массами
двух кучек.
Пример
№	INPUT.TXT		OUTPUT.TXT
1	5
	5 8 13 27 14		3	 */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0071_Perebor_stones {
		// Метод для получения всех вариантов сочетаний без повторений (например, все наборы по 2 камня без повторений)
	static ArrayList<int[]> getSet (int[] input, int k) {	
		ArrayList<int[]> subsets = new ArrayList<>();	
		int[] s = new int[k];                 		
		if (k <= input.length) {
			for (int i = 0; (s[i] = i) < k - 1; i++);  	
			int[] result = new int[s.length]; 
			for (int i = 0; i < s.length; i++) 	result[i] = input[s[i]];
			subsets.add(result);	}	
	    for(;;) {
	        int i =0 ;
	        for (i = k - 1; i >= 0 && s[i] == input.length - k + i; i--);  { 
	        	if (i < 0)   break; }
	        s[i]++;                   
	        for (++i; i < k; i++)   s[i] = s[i - 1] + 1;  
	        int[] result = new int[s.length]; 
			for (int j = 0; j < s.length; j++) 	result[j] = input[s[j]];
			subsets.add(result);
	   }
		return subsets;
	}
			// Метод определения минимальной разницы в листе
	static int minimal (ArrayList<int[]> arrl, int sum) {
		int minimum_difference = Integer.MAX_VALUE;
		for (int i =0; i < arrl.size(); i++) {
			int sum1 = 0;
			for (int j =0; j < arrl.get(i).length; j++) 	sum1 = sum1 + arrl.get(i)[j];
			int temp_min = Math.abs(sum-sum1-sum1);
			if (temp_min < minimum_difference) minimum_difference = temp_min;}
//			System.out.println("Массив = " + Arrays.toString(perebor_result.get(i)) + " ,  sum1 = " + sum1 + ",    temp_min = " + temp_min + ",   differ = " + minimum_difference );
			return minimum_difference;
		}
	
	
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int n = sc.nextInt();		
	sc.nextLine();
	String Temp[] =  sc.nextLine().split(" ");
	int StonesSet[] = new int[Temp.length];
	for (int i =0; i <Temp.length; i++) StonesSet[i] = Integer.parseInt(Temp[i]);
//	System.out.println("n = " + n);
//	System.out.println(Arrays.toString(StonesSet));
	
	int sum = 0;
	for (int i = 0; i <StonesSet.length; i++) sum = sum + StonesSet[i];
	 
		//Перебор всех вариантов взятия камней - по 1 камню, по 2 камня....по (n-1) камней
	ArrayList<int[]> temp = new ArrayList<int[]>();				// - лист для сохранения вариантов перебора (отдельно с 1, 2 ... камнями)
	int minimum_difference = Integer.MAX_VALUE;
	int temp_min = Integer.MAX_VALUE;
	for (int i =1; i <=n-1; i++)  {
		temp = getSet(StonesSet, i);
		temp_min = minimal(temp, sum);
		if (temp_min < minimum_difference) minimum_difference = temp_min;
//		System.out.println("Массив = " + Arrays.toString(perebor_result.get(i)) + " ,  sum1 = " + sum1 + ",    temp_min = " + temp_min + ",   differ = " + minimum_difference );
	}

	System.out.println(minimum_difference);
	
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(minimum_difference);
	pw.close();
}
}
