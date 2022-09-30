package f02_ACMP_0_50;
/*  * Конечные автоматы			(Время: 1 сек. Память: 16 Мб Сложность: 11%)
Однажды известный профессор обнаружил описания k конечных автоматов. По его мнению, нетривиальность конечного автомата, 
имеющего n состояний и m переходов, можно описать целым числом d = 19m + (n + 239)*(n + 366) / 2 . Чем больше d, тем больший 
интерес для науки представляет изучение его свойств.
	Помогите профессору вычислить нетривиальность имеющихся у него автоматов.
	Входные данные
Первая строка входного файла INPUT.TXT содержит целое число k (1 ≤ k ≤ 10000) – количество конечных автоматов. Следующие k 
строк содержат по два целых числа ni (0 ≤ ni ≤ 1000) и mi (0 ≤ mi ≤ 26ni2) – число состояний и переходов i-го автомата.
	Выходные данные
Выходной файл OUTPUT.TXT должен состоять из k строк. На i-й строке выходного файла выведите одно число – нетривиальность i-го
автомата.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1		4			44344
		2 0			48134
		13 20		45699
		5 23		49458
		18 6	
2		2
		15 20		48767
		1000 26000	134023  */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0035_Arr_in_Arlist {
public static void main(String[] args) throws IOException {
	
	Scanner reader = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int k = reader.nextInt();
	reader.nextLine();
	System.out.println("k = " + k);
	
	ArrayList<int []> arrl = new ArrayList<int [] >();
	String str = null;
	while (reader.hasNextLine() == true) { 
		str = reader.nextLine();
//		System.out.println(str);
		String Arr[] =  str.split(" ");
		int ArrFigures[] = {Integer.parseInt(Arr[0]), Integer.parseInt(Arr[1]) };
		arrl.add(ArrFigures);
	}
    reader.close();
    for (int i = 0; i <arrl.size(); i++)  System.out.print(Arrays.toString(arrl.get(i)) + "  ");
    System.out.println();
    
    PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
    
    int d = 0;
    for (int i = 0; i <arrl.size(); i++) {
    d = 19*arrl.get(i)[1] + (arrl.get(i)[0] + 239)*(arrl.get(i)[0] + 366) / 2;
    pw.print(d + "\n");
    System.out.println(d);}
    pw.close();
    	
	}
}
