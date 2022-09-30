package f03_ACMP_51_100;
	/*	Судоку		(Время: 1 сек. Память: 16 Мб Сложность: 27%)
Судоку размера n называется квадрат со стороной n2, разделенный на n2 средних квадратов со стороной n, каждый из которых разделен на n2
маленьких квадратов. В каждом маленьком квадрате записано число от 1 до n2.
	Судоку называется правильным, если в каждом столбце, каждой строке и каждом среднем квадрате встречаются все числа от 1 до n2.
	Недавно Вася нарисовал Судоку размера n. Ваша задача – помочь ему определить правильный ли он.
	Входные данные
В первой строке входного файла INPUT.TXT содержится число n (1 ≤ n ≤ 10). В следующих n2 строчках содержится по n2 чисел, задающих
нарисованный Васей Судоку.
	Все числа во входном файле натуральные и не превосходят 100 по модулю.
	Выходные данные
Если Судоку правильный, то выведите в выходной файл OUTPUT.TXT слово «Correct», иначе выведите «Incorrect».
	Примеры
№	INPUT.TXT				OUTPUT.TXT
1	3
1 3 2 5 4 6 9 8 7
4 6 5 8 7 9 3 2 1
7 9 8 2 1 3 6 5 4
9 2 1 4 3 5 8 7 6
3 5 4 7 6 8 2 1 9
6 8 7 1 9 2 5 4 3
5 7 6 9 8 1 4 3 2
2 4 3 6 5 7 1 9 8
8 1 9 3 2 4 7 6 5			Correct
2	1
	10						Incorrect */	

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0088_Sudoku  {
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	sc.nextLine();
	int Array[][] = new int[N*N][N*N];
	for (int i = 0; i<N*N; i++ ) {
		for (int j = 0; j<N*N; j++ ) {
			Array[i][j] = sc.nextInt();
		}
	}
	for (int i = 0; i<N*N; i++ ) System.out.println((Arrays.toString(Array[i])));
	
	int Sorted_Row[] = new int[N*N];
	int Sorted_Column[] = new int[N*N];
	
	boolean isCorrectSudoku = true;
	
	for (int i = 0; i<N*N; i++ ) {
		for (int j = 0; j<N*N; j++ ) {
			Sorted_Row[j] = Array[i][j]; }
//		System.out.print(Arrays.toString(Sorted_Row) + "   ");
		Arrays.sort(Sorted_Row);
		for (int k = 0; k<N*N; k++ ) {
			if (Sorted_Row[k] != (k+1)) isCorrectSudoku = false; 
		}
//		System.out.println(isCorrectSudoku);
	}
	
	System.out.println();
	for (int i = 0; i<N*N; i++ ) {
		for (int j = 0; j<N*N; j++ ) {
			Sorted_Column[j] = Array[j][i]; }
//		System.out.print(Arrays.toString(Sorted_Column) + "   ");
		Arrays.sort(Sorted_Column);
//		System.out.print(Arrays.toString(Sorted_Column) + "   ");
		for (int k = 0; k<N*N; k++ ) {
			if (Sorted_Column[k] != (k+1)) isCorrectSudoku = false; 
		}
//		System.out.println(isCorrectSudoku);
	}
	
	int r = 0;
	int c = 0;
	int k = 0;
	int SmallArrays[] = new int [N*N];
	while (true) {
//		System.out.println("r= " + r + ",   c = " + c);
		k=0;
		for (int i = r; i<r+N; i++ ) {
			for (int j = c; j<c+N; j++ ) {
//				System.out.println("j = " + j);
				SmallArrays[k] = Array[i][j];
				k++;
			}
		}
//	System.out.print(Arrays.toString(SmallArrays) + "   ");
//	System.out.println(isCorrectSudoku);
	Arrays.sort(SmallArrays);
	for (int l = 0; l<N*N; l++ ) { if (SmallArrays[l] != (l+1)) isCorrectSudoku = false;	}
	
	if ((r== N*N-N) && (c== N*N-N)) break;
	if (c == (N*N - N)) {r = r+ N; c = 0;}
	else {c = c+N;}
	}
	
	String result = null;
	if (isCorrectSudoku == true)  result  = "Correct";
	else result = "Incorrect";
	System.out.println(result);
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(result);
	pw.close();
}
}


/*
2
1 2 3 4 
3 4 1 2
2 1 4 3
4 3 2 1



*/
