package f03_ACMP_51_100;
	/*	Пересечение множеств		(Время: 1 сек. Память: 64 Мб Сложность: 34%)
Даны два неупорядоченных набора целых чисел (может быть, с повторениями). Выдать без повторений в порядке возрастания все те числа, которые
встречаются в обоих наборах.
	Входные данные
В первой строке входного файла INPUT.TXT записано через пробел два целых числа N и М (1 ≤ N, М ≤ 300 000) — количество элементов первого и
второго наборов, соответственно. В следующих строках записано сначала N чисел первого набора, а затем M чисел второго набора. Числа
разделены пробелами или символами конца строки. Каждое из этих чисел попадает в промежуток от 0 до 105.
	Выходные данные
В выходной файл OUTPUT.TXT нужно записать в возрастающем порядке без повторений все числа, которые входят как в первый, так и во второй
набор. Числа разделять одним пробелом. Если таких чисел нет, то выходной файл должен оставаться пустым.
	Пример
№	INPUT.TXT					OUTPUT.TXT
1	11 6
	2 4 6 8 10 12 10 8 6 4 2
	3 6 9 12 15 18					6 12 */	

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

// Принял все тесты за 0,5 с память всего 2,75 мб

public class acmp_0082_2_Buffer_Array  {
public static void main(String[] args) throws IOException {
	int Count[] = new int [201];
	BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\JavaTXT\\ACMP_0001\\input.txt"), Charset.forName("UTF-8")));
	reader.readLine();
	int k;
	char c;
	StringBuilder numberString = new StringBuilder();
	int input1[] = new int [100001];
//	int input1[] = new int [20];
//	TreeSet<Integer> input1 = new TreeSet<Integer>();
	do {
		k = reader.read();
		if (k != 13 &&  k != 32 && k!=-1) {
			c = (char)k;
			numberString.append(Character.toString(c));	}
		else  {
			if ((numberString.length() !=0)&&(k!= 45)) {		// Если строка не пустая (защита от двойного пробела) 
				input1[Integer.parseInt(numberString.toString())] = 1;
				numberString.delete(0, numberString.length());	}
		}
	}
	while ((k!=-1) && (k!=10));		// При переносе строки и окончании символов - выход из цикла 
	System.out.println(Arrays.toString(input1));
	
	numberString = new StringBuilder();
//	TreeSet<Integer> input2 = new TreeSet<Integer>();
	ArrayList<Integer> arl = new ArrayList<Integer>();
	int temp = 0;
	do {
		k = reader.read();
		if (k != 13 &&  k != 32 && k!=-1) {
			c = (char)k;
			numberString.append(Character.toString(c));	}
		else  {
			if ((numberString.length() !=0)&&(k!= 45)) {		// Если строка не пустая (защита от двойного пробела) 
				temp = Integer.parseInt(numberString.toString());
				if (input1[temp] == 1) {
					arl.add(temp);
					input1[temp] = 0;
				}
				numberString.delete(0, numberString.length());	}
		}
	}
	while ((k!=-1) && (k!=10));		// При переносе строки и окончании символов - выход из цикла 
	reader.close();
	Collections.sort(arl);
	System.out.println(arl);
	
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	for (int j = 0; j<arl.size(); j++) pw.print(arl.get(j) + " ");
	pw.close();
}
}