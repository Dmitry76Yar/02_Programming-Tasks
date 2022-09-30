	package f05_ACMP_150_199;

/* Преобразование последовательности	(Время: 2 сек. Память: 32 Мб Сложность: 35%)
Задана последовательность, содержащая n целых чисел. Необходимо найти число, которое встречается в этой последовательности
наибольшее количество раз, а если таких чисел несколько, то найти минимальное из них, и после этого переместить все такие числа
в конец заданной последовательности. Порядок расположения остальных чисел должен остаться без изменения.
	Например, последовательность 1, 2, 3, 2, 3, 1, 2 после преобразования должна превратиться в последовательность 1, 3, 3, 1, 2, 2, 2.
	Требуется написать программу, которая решает данную задачу.
	Входные данные
Первая строка входного файла INPUT.TXT содержит число n — количество чисел во входной последовательности (3 ≤ n ≤ 200000). Следующая
строка содержит входную последовательность, состоящую из n целых чисел, не превышающих по модулю 106. Все числа в строке разделены
пробелом.
	Выходные данные
В выходной файл OUTPUT.TXT выводится последовательность чисел, которая получается в результате названного преобразования. Все числа
в последовательности должны быть разделены пробелом.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1	7
1 2 3 2 3 1 2	1 3 3 1 2 2 2		*/

	import java.util.*;
	import java.io.*;
	import java.nio.charset.Charset;
	 
	public class acmp_0178{
	public static void main(String[] args) throws IOException {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\JavaTXT\\ACMP_0001\\input.txt"), Charset.forName("UTF-8")));
	    String str = reader.readLine();
	    String str1 = reader.readLine();
	    reader.close();
	    int N = Integer.parseInt(str);
	    int a[] = new int [N];
	    int b[] = new int [N];
	    String b1[] = str1.split(" ");
	    for (int i = 0; i<N; i++)         a[i] = b[i] = Integer.parseInt(b1[i]);
	     
	    Arrays.sort(b);
	    int maxT = 1;
	    int foundNum = b[0];
	    int max = 1;
	    int temp = b[0];
	    for (int i = 1; i<N; i++) {
	        if (b[i] == temp) {
	            maxT++;
	            if (maxT>max) {
	                foundNum = temp;
	                max = maxT;
	            }
	            else if (maxT == max) {
	                if (foundNum > temp)    foundNum  = temp;
	            }
	        }
	        else {
	            temp = b[i];
	            maxT = 1;
	        }
	    }
		
		PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
		for (int i = 0; i<N; i++) 
			if (a[i] != foundNum) o.print(a[i] + " ");
		for (int i = 0; i<max; i++) o.print(foundNum + " ");
		o.flush();
		o.close();
	}
	}