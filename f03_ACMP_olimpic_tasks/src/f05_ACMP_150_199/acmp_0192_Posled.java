	package f05_ACMP_150_199;
/*Следующая перестановка ...	(Время: 1 сек. Память: 16 Мб Сложность: 46%)
	Перестановкой из N элементов называется упорядоченный набор из N различных чисел от 1 до N.
	Найдите по заданной перестановке следующую в лексикографическом порядке (будем считать, что за перестановкой 
(N, N-1, ... , 3, 2, 1) следует тождественная перестановка, то есть (1, 2, 3, ... , N)).
	Входные данные
В первой строке входного файла INPUT.TXT содержится число N (1 ≤ N ≤ 104). Во второй строке содержится перестановка
(последовательность натуральных чисел от 1 до N, разделенных пробелами).
	Выходные данные
Выходной файл OUTPUT.TXT должен содержать искомую перестановку.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1				1
	1	1
2	5
	2 4 5 3 1	2 5 1 3 4
*/

import java.util.*;
import java.io.*;

public class acmp_0192_Posled{
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	int array[] = new int[N];
	for (int i=0; i<N; i++) array[i] = sc.nextInt();
	System.out.println(Arrays.toString(array));
	
		// Пример  : 2 4 5 3 1  ->  2 5 1 3 4 
	    //  2 1 3 4 5   ->  2 1 3 5 4        2 1 5 3 4  -> 2 1 5 4 3   
	    //  4 5 2 3 1   ->  4 5 3 1 2        4 5 1 3 2  -> 4 5 2 1 3
		// Массив для хранения вышедших цифр
	
	// Находим какие цифры можно обменять на цифры, идущие в последовательности за ним
	// Берем крайние цифрв. Например, для 2 1 3 4 5  - 4 можно обменять на 5  - сохраняем индексы именно этих элементов
	int indexToBeChanged = 0;
	int indexDonor = 0;
	for (int i=0; i<N; i++) {
		for (int j=i+1; j<N; j++) {
			if (array[i] <array[j]) {
				indexToBeChanged = i;
				indexDonor = j;
			}
		}
	}
	System.out.println("indexToBeChanged = " + indexToBeChanged + "  indexDonor = " + indexDonor);
	
	// Меняем найденные элементы местам
	int temp = array[indexToBeChanged];
	array[indexToBeChanged] = array[indexDonor];
	array[indexDonor] = temp;
	System.out.println(Arrays.toString(array));
	
	// Элементы, идущие за элементом с (indexToBeChanged+1) упорядочиваем по возрастанию
	// Например,  для 4 5 1 3 2 сначала меняем местами 1 2, получаем 4 5 2 3 1  и затем упорядачиваем 3 1 по возрастанию - 4 5 2 1 3
	int tempArray[] = new int[N-indexToBeChanged-1];
	for (int i=indexToBeChanged+1; i<N; i++) {
		tempArray[i-indexToBeChanged-1] = array[i];
		System.out.println("i = "  + i);
	}
	Arrays.sort(tempArray);
	System.out.println(Arrays.toString(tempArray));	
	
	StringBuilder sb = new StringBuilder();
	for (int i=0; i<=indexToBeChanged; i++) sb.append(array[i] + " ");
	for (int i=0; i<tempArray.length; i++) sb.append(tempArray[i] + " ");
	System.out.println("RESULT = "  + sb);
	

	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
//    o.print(sb);
    o.flush();
    o.close();
    }
}