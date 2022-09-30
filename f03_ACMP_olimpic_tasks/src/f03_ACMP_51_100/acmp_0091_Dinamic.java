package f03_ACMP_51_100;
	/*	Две последовательности		(Время: 1 сек. Память: 16 Мб Сложность: 29%)
Определим последовательности an и bn следующим образом: a1 = 2, a2 = 3, a3 = 4, a4 = 7, a5 = 13, an = bn−1 + bn−3, n > 5, 
bn — последовательность чисел, не входящих в an, записанных в возрастающем порядке.
	Таким образом, последовательность an будет выглядеть следующим образом: 2, 3, 4, 7, 13, 15,..., а последовательность 
bn – 1, 5, 6, 8, 9, 10,....
	Ваша задача состоит в том, чтобы найти an и bn.
	Входные данные
Входной файл содержит целое число n (1 ≤ n ≤ 10000).
	Выходные данные
В первой строке выходного файла выведите an, во второй – bn.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	4				7
					8
2	10				25
					16
3	6578			19731
					9868		*/	

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class acmp_0091_Dinamic  {
	
	static String step (int n) {
		ArrayList<Integer> arlB = new ArrayList<Integer>();
		arlB.add(0);
		arlB.add(1);
		arlB.add(5);
		arlB.add(6);
		arlB.add(8);
		arlB.add(9); arlB.add(10); arlB.add(11); arlB.add(12);
		int ArrA[] = new int[n+6];	
		ArrA[0] = 0;
		ArrA[1] = 2;
		ArrA[2] = 3;
		ArrA[3] = 4;
		ArrA[4] = 7;
		ArrA[5] = 13;
		StringBuffer sbf = new StringBuffer();
			for (int j = 6; j<n+1; j++)  {
	//			System.out.print("На входе n = " + j + "    ");
	//			System.out.println();
				ArrA[j] = arlB.get(j-1) + arlB.get(j-3);
				for (int i = (ArrA[j-1] +1); i<ArrA[j]; i++) 	arlB.add(i);
	//			System.out.print("ArlB" + arlB + "  ");
	//			System.out.print("ArrA" + Arrays.toString(ArrA));
	//			System.out.println("   " + ArrA[n]);
			}
			sbf.append(ArrA[n]).append("\n").append(arlB.get(n));

		System.out.println(sbf.toString());
		System.out.println("arlB.size() = " + arlB.size());
		return sbf.toString();
	}
	
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
//	N = 10;
//	System.out.println("N = " + N);
			
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
    out.println(step(N));
    out.flush();
    out.close();
}
}
