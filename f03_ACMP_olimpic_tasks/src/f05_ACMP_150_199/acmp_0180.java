	package f05_ACMP_150_199;

/* Счастливая страница	(Время: 1 сек. Память: 16 Мб Сложность: 46%)
В новом выпуске Большой Галактической Энциклопедии N страниц. Петя считает страницу счастливой, если произведение цифр, входящих
в ее номер, равно K. Например, если N=100, то для K=42 есть счастливая страница (например, с номером 76), а для K=128 счастливой
страницы нет.
	Требуется написать программу, которая поможет Пете определить, есть ли счастливые страницы в новом выпуске энциклопедии.
	Входные данные
Входной текстовый файл INPUT.TXT содержит числа N (1 ≤ N ≤ 109) и K (1 ≤ K ≤ 109), записанные через пробел.
	Выходные данные
Выходной текстовый файл OUTPUT.TXT должен содержать «YES», если счастливые страницы есть, и «NO» иначе.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	100 42		YES
2	100 128		NO		*/

import java.util.*;
import java.io.*;
	 
public class acmp_0180{
	static boolean answer = false;
	static ArrayList<Integer> arr = new ArrayList<Integer>();
		
	static void calc (int a, int step, int mul, int Nrazr, int[] store, int K, int N) {
		if ((a>=2) && (step<=Nrazr)) {
			for (int i =2; i<=9; i++) {
				if (answer == true) break;
				if (a%i == 0) {
					store[step - 1] = i;
//					System.out.println(i + " -->  ");
					calc(a/i, step+1, mul*i, Nrazr, store, K, N);
				}
			}
		}
		else {
			if (arr.contains((Integer)(mul))) {
				int fitsrFoundNumb = K/mul;
//				fitsrFoundNumb = 7;
				System.out.println("fitsrFoundNumb = " + fitsrFoundNumb);
				System.out.println("mul = " + mul);
//				System.out.println(Arrays.toString(store));
				StringBuilder sbr = new StringBuilder();
				for (int i=0; i<store.length; i++) 	
					if (store[i]!=0) sbr.append(store[i]);
				if (fitsrFoundNumb != 1) sbr.append(fitsrFoundNumb);
				sbr.reverse();
				System.out.println("sbr = " + sbr);
				if (Integer.parseInt(sbr.toString()) <=N) {
//					System.out.println("Found page " + sbr);
					answer = true;
				}
			}
//			else System.out.println();
		}
	}
		
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
		int N = sc.nextInt();
		int K = sc.nextInt();
//		N = 100;
//		K = 128;
//		N = 568	;
//		K = 225;
				
		int Ninit = N;
		String Nstr = Integer.toString(N);
		System.out.println("Nstr = " + Nstr);
		int firstNumber = Integer.parseInt(Nstr.substring(0,1));
//		System.out.println("firstNumber = " + firstNumber);

		int Nrazr = 0;
		while (N >0) {
			Nrazr++;
			N = N/10;
		}
//		System.out.println("Nrazr = " + Nrazr);
		
		if (firstNumber == 1) arr.add(K);
		else {
			for (int i = 1; i<=(firstNumber); i++) {
			if ((K%i == 0) & (K/i >0)) arr.add(K/i);
			}
		}
		System.out.println("arr = " + arr);
		
		int[] store = new int[Nrazr+1];
		calc(K, 1, 1, Nrazr-1, store, K, Ninit);
		System.out.println(answer);

		PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
		if (answer) o.print("YES");
		else o.print("NO");
		o.flush();
		o.close();
	}
	}