package f05_ACMP_150_199;

/* 	/* 	Монетки - 2		(Время: 1 сек. Память: 16 Мб Сложность: 51%)
В волшебной стране используются монетки достоинством A1, A2,..., AM. волшебный человечек пришел в магазин и обнаружил, что у него
есть ровно по две монетки каждого достоинства. Ему нужно заплатить сумму N. Напишите программу, определяющую, сможет ли он
расплатиться без сдачи.
	Входные данные
Во входном файле INPUT.TXT записано сначала число N (1 ≤ N ≤ 109), затем - число M (1 ≤ M ≤ 15) и далее M попарно различных чисел
A1, A2,..., AM (1 ≤ Ai ≤ 109).
	Выходные данные
В выходной файл OUTPUT.TXT выведите количество монет, которое придется отдать волшебному человечку, если он сможет заплатить
указанную сумму без сдачи. Если решений несколько, выведите вариант, в котором волшебный человек отдаст наименьшее возможное
количество монет. Если без сдачи не обойтись, то выведите одно число 0. Если же у волшебного человечка не хватит денег, чтобы
заплатить указанную сумму, выведите одно число -1 (минус один).
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	5 2
	1 2			3
2	7 2
	1 2			-1
3	5 2
	3 4			0		*/

import java.util.*;
import java.io.*;
 
public class acmp_0153_25_____3  {
     
    static int result = 16;
    static Map <Integer, Integer> map1 = new HashMap<>();
     
    static int recurs (int i_min, int arr[], int sum, int N, int number_cones) {
    	Integer t = map1.get(sum);
    	if (t==null) map1.put(sum, number_cones);
    	else {
    		if((int)t>number_cones) map1.put(sum, number_cones);
    	}
    	System.out.println("sum " + sum);
        if (sum == N ) {
            if (number_cones<=result) result = number_cones;
//          System.out.println(" num" + number_cones);
            return sum;
        }
        if (sum>N) return sum;
        if (number_cones == arr.length) return sum;
        else  {
            for (int i=i_min; i<arr.length; i++) {
                System.out.print(arr[i] + " ->");
                recurs(i+1, arr, sum+arr[i], N, number_cones+1);
            }
            return 1;
        }
    }
    
    static int recurs2 (int i_min, int arr[][], int sum, int N, int number_cones) {
    	System.out.println("sum2 " + sum);
        if (sum == N ) {
            if (number_cones<=result) result = number_cones;
//          System.out.println(" num" + number_cones);
            return sum;
        }
        if (sum>N) return sum;
        if (number_cones == arr.length) return sum;
        else  {
            for (int i=i_min; i<arr.length; i++) {
                System.out.print(arr[i][0] + " ->");
                recurs2(i+1, arr, sum+arr[i][0], N, number_cones+arr[i][1]);
            }
            return 1;
        }
    }
     
     
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
    int N = sc.nextInt();
    int M = sc.nextInt();
    System.out.println("N = " + N + "  M = " + M);
      
    int arr[] = new int[M];
    for (int i = 0; i<M; i++) arr[i] = sc.nextInt();
    int sum = 0;
    for (int i = 0; i<arr.length; i++) {
        sum = sum + arr[i]; 
        if (sum >N) break;
    }
 
    //  arr[0] = 1; arr[1] = 1; arr[2] = 2; arr[3] = 3;
    System.out.println(Arrays.toString(arr) + " sum = " + sum);
     
    String outcome = "";
    if (sum<N) outcome = "-1";
    else {
        recurs(0, arr, 0, N, 0);
        if (result == 31) outcome = "0";
        else outcome = Integer.toString(result);

    int arrayFromTemp[][] = new int[map1.size()][2];
	    int i=0;
	    for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
			// Получить ключи  и значения
	//	System.out.print(" \t" + entry.getKey()); 
	//	System.out.print(" \t" + entry.getValue());
		arrayFromTemp[i][0] = entry.getKey();
		arrayFromTemp[i++][1] = entry.getValue();	
	//	System.out.println();
		} 
	    for (int j=0; j<arrayFromTemp.length; j++) System.out.println(Arrays.toString(arrayFromTemp[j]));
	    System.out.println("Длина = " +  arrayFromTemp.length);
//	    recurs2(0, arrayFromTemp, 0, N, 0);
    }
	 
    System.out.println();
    System.out.println("result = " + outcome);
    
     
    PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
    out.print(outcome);
    out.flush();
    out.close();
}
}