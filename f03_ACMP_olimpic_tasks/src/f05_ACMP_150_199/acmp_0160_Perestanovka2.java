package f05_ACMP_150_199;

/* 	Степень перестановки	(Время: 1 сек. Память: 16 Мб Сложность: 46%)
	Требуется вычислить степень заданной перестановки.
	Перестановкой из N элементов называется упорядоченный набор из N различных чисел от 1 до N. Количество различных перестановок
порядка N равно PN = N!
	Пусть у нас есть упорядоченное множество из N элементов. Перестановка задает преобразование этого множества. А именно, она
говорит, что на i место нужно поставить ai элемент множества, где ai - i-тый элемент перестановки.
	Тождественной перестановкой ε называется такая перестановка, которая не меняет порядок элементов множества.
	Степенью перестановки π называется минимальное натуральное число k такое, что πk = ε, то есть перестановка π, применённая k
раз, эквивалентна тождественной перестановке.
	Входные данные
В первой строке входного файла INPUT.TXT записано число 0 < N ≤ 100 - порядок перестановки. Во второй строке записана сама
перестановка.
	Выходные данные
В выходной файл OUTPUT.TXT выведите степень данной перестановки. Гарантируется, что ответ не превышает 109.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1	3
	2 3 1			3		*/

import java.util.*;
import java.io.*;

class Vert1 {
	boolean isVisted;
	int name;
	public Vert1(int name, boolean isVisted) {
		this.name = name;
		this.isVisted = isVisted;
	}
}

public class acmp_0160_Perestanovka2	{
	
	/* Здесь перестановку проще рассматирвать как некоторое действо, которое в массиве переставляет элементы с места на место. 
	 * Например, перестановка (2 3 1) превращает массив (14 11 18) в массив (18 14 11), а перестановка (3 1 2) вернет полученный массив
	 * в исходный, поэтому она и является обратной, ну на пи пи-1 - это последовательность перестановок, которая должна приводить к
	 *  исходному массиву. 	 */

public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	
	/*
	 		Порядок перестановки 2 4 1 3 5 9 10 6 8 7 для 
	   (1 2 3 4 5 6 7 8 9 10      - Исходное множество
		3 1 4 2 5 8 10 9 6 7 )︂    - После 1-ой перестановки
			разбиваем на связанные циклы и получаем (1342)(689)(7, 10)
			При чем циклы не перескаются (то есть ни одно число не входит в два цикла сразу).
		Порядок финальный равен НОК(4, 3, 2) = 12.
	 */
		
		// Массив, который изменяется наложением перестановки
	int arr[] = new int[N+1];
	for (int i = 1; i<=N;i++) arr[i] = i;
	
		// Массив, хранящий перестановку
	int perest[] = new int[N+1];
	for (int i = 1; i<=N;i++) perest[i] = sc.nextInt();
	
		// Массив = исходный массив arr[] после 1-го наложения перестановки
	int arr_changed[] = new int[N+1];
	for (int i = 1; i<=N;i++) arr_changed[perest[i]] = arr[i];
		
	System.out.println(Arrays.toString(arr));
	System.out.println(Arrays.toString(arr_changed));
	
	int matrizaSmegn[][] =  new int[N+1][N+1];
	for (int i = 1; i<=N;i++) {
		matrizaSmegn[arr[i]][arr_changed[i]] = 1;
		matrizaSmegn[arr_changed[i]][arr[i]] = 1;
	}
	System.out.println();
	for (int i = 0; i<=N;i++) System.out.println(Arrays.toString(matrizaSmegn[i]));
	
	ArrayList<Vert1> vertList = new ArrayList<Vert1>();
	for (int i = 0; i<=N;i++) vertList.add(new Vert1(i, false));
	vertList.get(0).isVisted = true;
	int numberVisitedVert = 1;
	
	ArrayList<Vert1> queue = new ArrayList<Vert1>();
	
	ArrayList<Integer> result = new ArrayList<Integer>();
	
	for (int a = 1; a<=N; a++) {
		if (vertList.get(a).isVisted == false) {
			System.out.println("New cycle = ");
			queue.add(vertList.get(a));
			int numberOfElementInCycle = 0;
			while(queue.size() != 0) {
				System.out.print("Queue =    "); 
				for (int j = 0; j<queue.size(); j++) System.out.print(queue.get(j).name + "  -->  "); 
				System.out.println();
				Vert1 currentVert = queue.get(0);
				numberOfElementInCycle++;
				queue.get(0).isVisted = true;
				for (int i = 1; i<=N;i++) {
					if ((matrizaSmegn[i][currentVert.name] == 1) && (vertList.get(i).isVisted == false)) {
						queue.add(vertList.get(i));
						vertList.get(i).isVisted = true;
					}
				}
				queue.remove(0);
				numberVisitedVert++;
			}
			System.out.println("Number of elemens in this cycle = " + numberOfElementInCycle);
			if (numberOfElementInCycle !=1) result.add(numberOfElementInCycle);
		}
	}
	
	result.clear();
	result.add(5); result.add(4); result.add(3);
	System.out.println("result = " + result);
//	
	int proizv = 1;
	for (int i = 0; i<result.size();i++) proizv = proizv*result.get(i);
	System.out.println("proizv = " + proizv);
	
	int proizv1 = 1;
	boolean breaks = true;
	while (true) {
//		System.out.println("Enter  proizv = " + proizv);
		if (proizv1 == proizv) break;
		proizv1 = proizv;
		for (int i = 0; i<result.size();i++) {
			int temp = proizv/result.get(i);
			boolean del = true;
			for (int j = 0; j<result.size();j++) {
				if (temp%result.get(j) != 0) {
					del = false;
//					System.out.println("del = false");
				}
			}
			if (del == true) {
				proizv = temp;
				break;
			}
		}
	}
	System.out.println("proizv = " + proizv);
	
	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	o.print(proizv);
	o.flush();
	o.close();
}
}




