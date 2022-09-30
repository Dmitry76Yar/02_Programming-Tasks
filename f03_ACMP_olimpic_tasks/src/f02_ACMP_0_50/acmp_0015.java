package f02_ACMP_0_50;
/* 	 Дороги			(Время: 1 сек. Память: 16 Мб Сложность: 18%)
В галактике «Milky Way» на планете «Snowflake» есть N городов, некоторые из которых соединены дорогами. Император галактики
 «Milky Way» решил провести инвентаризацию дорог на планете «Snowflake». Но, как оказалось, он не силен в математике, поэтому он 
 просит вас сосчитать количество дорог. Требуется написать программу, помогающую императору сосчитать количество дорог на планете 
 «Snowflake».
		Входные данные
В первой строке входного файла INPUT.TXT записано число N (0 ≤ N ≤ 100). В следующих N строках записано по N чисел, каждое из 
которых является единичкой или ноликом. Причем, если в позиции (i, j) квадратной матрицы стоит единичка, то i-ый и j-ый города 
соединены дорогами, а если нолик, то не соединены.
		Выходные данные
В выходной файл OUTPUT.TXT необходимо вывести число, определяющее количество дорог на планете «Snowflake».
		Пример
№		INPUT.TXT		OUTPUT.TXT
1			5
		0 1 0 0 0
		1 0 1 1 0			3
		0 1 0 0 0
		0 1 0 0 0
		0 0 0 0 0		 */

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0015 {
public static void main(String[] args) throws IOException {
	Scanner sc; 
	int n = 0;
	String Array[][];
	String str = null;
	
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	n = Integer.parseInt(sc.nextLine());
//	System.out.println(n);
	
	if ((n>=0) & (n<=100)) {
		int j = 0;
		Array 	= new String[n][n];
		String temp[] = new String[n];
			while (sc.hasNextLine()) {
				str = sc.nextLine();
				temp = str.split(" ");
				if(temp.length == n) 
					for (int i = 0; i <n; i++) Array[j][i] = temp[i];
			j++;
			}
//			System.out.println(Arrays.deepToString(Array));
			
				// Проверка, что только 0 и 1
			boolean correct_input = true;
			for (int i = 0; i<n; i++) 
				for (int h = 0; h<n; h++) 
					if ((Array[i][h].equals("0") == false) & (Array[i][h].equals("1") == false ))  
						correct_input = false;
		// System.out.println(correct_input);
			
		if (correct_input == true) {
			int count = 0;
			for (int i = 0; i<n; i++) {
//				System.out.println(Arrays.deepToString(Array));
				for (int h = 0; h<n; h++) 
					if (Array[i][h].equals("1"))  {
						Array[h][i] = "0";
						count++;
					}
			}
			System.out.println(count);
			PrintWriter pw;
			pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
			pw.print(count);
			pw.close();
			}
		else System.out.println("Неправильный ввод");
	}
	else System.out.println("Неправильный ввод");
	
	}

}
