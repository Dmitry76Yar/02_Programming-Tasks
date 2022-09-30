package f04_ACMP_101_200;
/*		Армия	(Время: 0,5 сек. Память: 16 Мб Сложность: 58%)
Всем известно, что в армии без строевой подготовки и порядка дело не обходится и за этим там строго следят. Однажды утром сержант
построил всех своих подчиненных в K рядов по N человек в каждом, но оказалось, что солдаты выстроились не по росту, и поэтому сержант
решил их наказать. Солдаты должны были выстроиться по росту в каждом отдельном ряде так, что слева должны были стоять самые низкие, а
справа самые высокие. Ну а поскольку в армии виноваты всегда слабые (низкие), то наказание было следующим: каждый солдат должен был
отжаться столько раз, сколько солдат стоит от него слева выше его ростом.
	Оказалось, что все солдаты были разного роста, и многим пришлось отжиматься достаточно много раз. Сержанту стало интересно:
сколько же раз в общей сложности пришлось отжаться солдатам?
	Помогите ему решить эту задачу!
Входные данные
В первой строке входного файла INPUT.TXT записаны два натуральных числа N и K (2 ≤ N ≤ 104, 1≤ K ≤20) – число солдат в каждом ряде
и число рядов. Следующие K строк файла содержат ровно N разных натуральных чисел от 1 до N – рост солдат. Первое число ряда – рост
первого солдата (самого левого в ряду), второе – рост второго, и т.д.
	Выходные данные
В выходной файл OUTPUT.TXT необходимо вывести общее количество отжиманий, которые должны были выполнить солдаты.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	3 3
	1 2 3
	2 1 3
	3 2 1			4
2	5 2
	1 5 2 4 3
	2 3 1 5 4		7
 */

import java.io.*;

// Условие выигрыша: K%(L+1) == 0

import java.nio.charset.Charset;
import java.util.Arrays;

public class acmp_0112_Time_exceed_test10 {
	static int countChangePlaces = 0;
	
	public static void  bubbleSort(int[] array) {
	       for(int i = array.length -1; i > 0; i--) {
	         for (int j = 0; j < i; j++) { 
	             if (array[j] > array[j+1]) {
	                 int temp = array[j];
	                 array[j] = array[j+1];
	                 array[j+1] = temp;	   
	                 countChangePlaces++;}
	         }
//	         System.out.println(Arrays.toString(array));
	       }
	}
		
	
public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\JavaTXT\\ACMP_0001\\input.txt"), Charset.forName("UTF-8")));
		String arr[] = reader.readLine().split(" ");
		int N = Integer.parseInt(arr[0]);
		int K = Integer.parseInt(arr[1]);
		System.out.println("N= " + N + "  , K = " + K);
		int sum = 0;
		int count = 0;
		for (int i= 0; i <K; i++) {
			count = 0;
			String arr1[] = reader.readLine().split(" ");
			int[] arr2 = new int[N];
			for (int j= 0; j <N; j++) arr2[j] = Integer.parseInt(arr1[j]);
			System.out.println(Arrays.toString(arr2));
			bubbleSort(arr2);
			System.out.println(countChangePlaces);
		}
			
		System.out.println("countChangePlaces = " + countChangePlaces);
		
		PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
		out.println(countChangePlaces);
	    out.flush();
	    out.close();
	}
	}