	package f05_ACMP_150_199;
/* Система линейных уравнений		(Время: 1 сек. Память: 16 Мб Сложность: 57%)
Требуется решить невырожденную систему, состоящую из N линейных уравнений с N неизвестными:
	Входные данные
В первой строке входного файла INPUT.TXT задано натуральное число N – ранг системы, далее следуют N строк, каждая из которых
состоит из N+1 целых чисел: коэффициенты i-й строки уравнения – N чисел aij и bi. (N ≤ 100, |aij|<10, |bi|<104). Числа разделены
одним или несколькими пробелами. Перед первым числом строки может быть ноль, один или несколько пробелов.
	Выходные данные
В единственную строку выходного файла OUTPUT.TXT нужно вывести через пробел корни приведенной во входном файле системы линейных
уравнений. Корни следует выводить в порядке возрастания их номеров (x1, x2, ... xn). Гарантируется, что все корни целые и не
превосходят значения 10 по абсолютной величине.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	2
	5 9 62
	9 -3 54
					7 3
2	3
	7 -9 1 2
	0 6 5 -15
	3 -3 2 -9		8 5 -9 */


import java.util.*;
import java.io.*;
	 
public class acmp_0198_5test{
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
    int N = sc.nextInt();
    long ar[][]= new long[N][N+1];
 
    int numOfRawWithoutFirstZero = -1;
    int nullString = -1;
    ArrayList<Integer> listOfRawWithFirstzero = new ArrayList<Integer>();
    for (int i = 0; i<N; i++) {
        for (int j = 0; j<N+1; j++) ar[i][j] = sc.nextInt();
        if (ar[i][0] == 0) listOfRawWithFirstzero.add(i);
        if ((ar[i][0] != 0) && (numOfRawWithoutFirstZero ==-1)) numOfRawWithoutFirstZero = i;
    }
    for (int i = 0; i<N; i++) System.out.println(Arrays.toString(ar[i]));
    System.out.println(listOfRawWithFirstzero);
    System.out.println("numOfRawWithoutFirstZero = " + numOfRawWithoutFirstZero);
     
    // Сложение строк, у которых первый обр.элемент равен нулю, со строкой, где этот элемент не равен нулю
    for (int i = 0; i<listOfRawWithFirstzero.size(); i++) {
        int e = listOfRawWithFirstzero.get(i);          // Строка с нулем в нужном элементе
        for (int j = 0; j<N+1; j++) {
	            ar[e][j] = ar[e][j] + ar[numOfRawWithoutFirstZero][j];
        }
    }
    listOfRawWithFirstzero.clear();
    numOfRawWithoutFirstZero = -1;
    for (int i = 0; i<N; i++) System.out.println(Arrays.toString(ar[i]));
    System.out.println();
     
    int count = 0;
    for (int i = count; i<N-1; i++) {         // Идет приведение к этой строке
        for (int j = count+1; j<N; j++) {       // Строка, которая приводится
            if (ar[j][i] != 0) { 
                long mul = ar[i][i]*ar[j][i];
                long temp1[] = new long [N+1];  // Строка, к которой приводимся, после привидения
                long temp2[] = new long [N+1];  // Строка, которая приводится, после привидения
                 
                for (int k = count; k<N+1; k++) {           // приведение
                        temp1[k] = ar[i][k]*mul/ar[i][i];
                        temp2[k] = ar[j][k]*mul/ar[j][i]*-1;
               }
                    // Сохраняем во 2-ую строку сумму 1-ой и 2-ой для обнуления 1-го коэффицента
                    // и находим нулевые строки и первую ненулевую строку
	                for (int k = count; k<N+1; k++) ar[j][k] = temp1[k] + temp2[k];
                if (ar[j][count+1] == 0) listOfRawWithFirstzero.add(j);
                if (ar[j][count+1] != 0)  numOfRawWithoutFirstZero = j;
           }
        }
        System.out.println("После  "  + count + "   первого прохода до исправления нулевых строк" );
        System.out.println(listOfRawWithFirstzero);
        System.out.println("numOfRawWithoutFirstZero = " + numOfRawWithoutFirstZero);
        for (int h = 0; h<N; h++) System.out.println(Arrays.toString(ar[h]));
        System.out.println();
        
        if (numOfRawWithoutFirstZero == -1) {
        	nullString = count+1;
        	break;
        }
         
            // Сложение строк, у которых первый обр.элемент равен нулю, со строкой, где этот элемент не равен нулю
        for (int h = 0; h<listOfRawWithFirstzero.size(); h++) {
            int e = listOfRawWithFirstzero.get(h);          // Строка с нулем в нужном элементе
            for (int f = 0; f<N+1; f++) {
	                ar[e][f] = ar[e][f] + ar[numOfRawWithoutFirstZero][f];
           }
	        }
        listOfRawWithFirstzero.clear();
       numOfRawWithoutFirstZero = -1;
         
        System.out.println("После  "  + count + "   первого прохода после исправления нулевых строк" );
        for (int h = 0; h<N; h++) System.out.println(Arrays.toString(ar[h]));
        System.out.println();
 
        count++;
    }  // КОНЕЦ 2-го FOR
    
    long answers[] = new long[N];
    System.out.println("nullString = " + nullString);
    if (nullString !=-1) {
    	for (int s = N-1; s>=nullString; s--) {
    	answers[s] = 1;
    			// Подставляем найденный корень в другие строки
	        for (int i = 0; i<N; i++) {
	           ar[i][N] = ar[i][N] - ar[i][s]*answers[s];
	           ar[i][s] = 0;
	        }
	        System.out.println(" s = " + s);
	        for (int h = 0; h<N; h++) System.out.println(Arrays.toString(ar[h]));
	        System.out.println();
    	}
    	
    	int count2 = 0;
    	if (nullString == 1) count2 = N - nullString - 1; 
    	else count2 = N-nullString;
	    while (count2>=0) {
	    	System.out.println("count2 = " + count2);
	        answers[count2] = ar[count2][N] / ar[count2][count2];
	        System.out.println("count2 = " + count2 + "    answers[count2] = " + answers[count2]);
	        System.out.println("answers[count2]  = " + answers[count2]);
	            // Подставляем найденный корень в другие строки
	        for (int i = 0; i<N; i++) {
	            ar[i][N] = ar[i][N] - ar[i][count2]*answers[count2];
	            ar[i][count2] = 0;
	        }
	        count2--;
	        for (int h = 0; h<N; h++) System.out.println(Arrays.toString(ar[h]));
	        System.out.println();
	    }
    }
   
    else { 
    	int count2 = N-1;
	    while (count2>=0) {
	        answers[count2] = ar[count2][N] / ar[count2][count2];
	        System.out.println("answers[count2]  = " + answers[count2]);
	            // Подставляем найденный корень в другие строки
	        for (int i = 0; i<N; i++) {
	            ar[i][N] = ar[i][N] - ar[i][count2]*answers[count2];
	           ar[i][count2] = 0;
	        }
	        count2--;
	        for (int h = 0; h<N; h++) System.out.println(Arrays.toString(ar[h]));
	        System.out.println();
	    }
    }
     
    System.out.println("RESULT = "  + Arrays.toString(answers));
     
    PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
    for (int i = 0; i<N; i++) o.print(answers[i] + " ");
    o.flush();
   o.close();
    }
}