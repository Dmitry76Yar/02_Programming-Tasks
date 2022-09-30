package f04_ACMP_101_200;
	/*		Магараджа		(Время: 1 сек. Память: 16 Мб Сложность: 60%)
	Магараджа — это шахматная фигура, сочетающая возможности ферзя и коня. Таким образом, магараджа может ходить и бить на любое
количество клеток по диагонали, горизонтали и вертикали (т.е. как ферзь), а также либо на две клетки по горизонтали и на одну по
вертикали, либо на одну по горизонтали и на две по вертикали (как конь).
	Ваша задача — найти число способов расставить на доске N на N ровно K магараджей так, чтобы они не били друг друга.
	Входные данные
Входной файл INPUT.TXT содержит два целых числа: N и K (1 ≤ K ≤ N ≤ 10).
	Выходные данные
В выходной файл OUTPUT.TXT выведите ответ на задачу.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	3 1				9
2	4 2				20
3	5 3				48		*/	

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0101  {
	
	public static ArrayList<int[]> steps (int arr[][], int i, int j, int c, int K) {
		c++;
		for (int a = 0; a<arr.length; a++)  arr[a][j] = c;
		for (int b = 0; b<arr.length; b++)  arr[i][b] = c;
		int a = i; int b = j;
		while ((a>=0) && (b>=0))  {
			arr[a][b] = c;
			a--;	b--;}
		a = i; b = j;
		while ((a>=0) && (b<arr.length))  {
			arr[a][b] = c;
			a--;	b++;}
		a = i; b = j;
		while ((a<arr.length) && (b<arr.length))  {
			arr[a][b] = c;
			a++;	b++;}
		a = i; b = j;
		while ((a<arr.length) && (b>=0))  {
			arr[a][b] = c;
			a++;	b--;}
		if (((i-2) >=0) && ((j+1) <arr.length)) arr[i-2][j+1] = c;		// 1
		if (((i-1) >=0) && ((j+2) <arr.length)) arr[i-1][j+2] = c;		// 2
		if (((i+1) <arr.length) && ((j+2) <arr.length)) arr[i+1][j+2] = c;		//3
		if (((i+2) <arr.length) && ((j+1) <arr.length)) arr[i+2][j+1] = c;		//4
		if (((i+2) <arr.length) && ((j-1) >=0)) arr[i+2][j-1] = c;				//5
		if (((i+1) <arr.length) && ((j-2) >=0)) arr[i+1][j-2] = c;				//6
		if (((i-1) >=0) && ((j-2) >=0)) arr[i-1][j-2] = c;						//7
		if (((i-2) >=0) && ((j-1) >=0)) arr[i-2][j-1] = c;						//8
		arr[i][j] = c;
		for (int g = 0; g<arr.length; g++)  System.out.println(Arrays.toString(arr[g]));
		System.out.println();
		
		ArrayList<int[]> arlist = new ArrayList<int[]>();
		for (int k = 0; k<arr.length; k++) {
			for (int l = 0; l<arr.length; l++) {
				if (arr[k][l] == 0) {
					System.out.println("Найден k = " + k + " ,   l = " + l);
					if (c== K) break;
					steps(arr, k, l, c, K);
					arlist.add(new int[]  {k,l});
					}
			}
		}
		
		/*
		 *  [1, 1, 1, 1]
			[1, 1, 1, 0]
			[1, 1, 1, 0]
			[1, 0, 0, 1]

		 */
		return arlist;
	}
	
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt(); 
	int K = sc.nextInt();
	int Desk[][] = new int[N][N];
	ArrayList<int[]> arlist = new ArrayList<int[]>();
	
	for (int i = 0; i<N; i++) {
		for (int j = 0; j<N; j++) arlist.add(new int[] {i,j});	}
//	for (int i = 0; i<arlist.size(); i++) System.out.println(Arrays.toString(arlist.get(i)));
	
	for (int i1 = 0; i1<arlist.size(); i1++) {
		int a = 0;
		steps(Desk, arlist.get(i1)[0], arlist.get(i1)[1], a, K);
//		for (int j = 0; j<arlist.size(); j++)  System.out.println(Arrays.toString(Desk[j]));
		
		
	}
	
			
	
//	int result = 0;
//	
//	if (K == 1) result = N*N;
//	else {
//			for (int i = 0; i<N; i++) {
//				for (int j = 0; j<N; j++) {
//					int  p = 1;
//					ArrayList<int[]> arlist = steps(Desk, i, j);
//	//				System.out.println("result = " + arlist);
//					for (int k = 0; k<N; k++) System.out.println(Arrays.toString(Desk[k]));
//					for (int k = 0; k<N; k++) Arrays.fill(Desk[k], 0);
//					System.out.println();
//					while (p<=K) {
//						ArrayList<int[]> temp = new ArrayList<int[]>();
//						int y = 0;
//						while ((arlist.size() !=0)) {
//							temp = steps(Desk, arlist.get(y)[0], arlist.get(y)[1]); 
//							y++;
//						}
//					p++;
//					}
//				}
//		}
//	}
	
//	int sum = 0;
//	for (int i = 0; i<N; i++) {
//		for (int j = 0; j<N; j++) {
//			sum = sum + steps(Desk, i, j);
//			for (int k = 0; k<N; k++) System.out.println(Arrays.toString(Desk[k]));
//		}
//	}
	
	
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
//    out.println(sum1 + ":" + sum2);
    out.flush();
    out.close();
}
}
