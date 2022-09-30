package f04_ACMP_101_200;
/*		A / B		(Время: 1 сек. Память: 16 Мб Сложность: 43%)
	Требуется получить точное значение частного А/В для двух натуральных чисел A и B.
	Входные данные
В единственной строке входного файла INPUT.TXT записано частное двух натуральных чисел, не превышающих 1000. Числа разделены
символом «/» без лишних пробелов.
	Выходные данные
В выходной файл OUTPUT.TXT нужно вывести точное значение A/B без лишних точек, нулей и пробелов. В случае присутствия бесконечной
записи числа следует вывести период в скобках.
	Например, неправильно выведены числа: 08.92, 3.20, 120.6(6), 0.(33), 5.(0), 2. , .3, 0.33(03) . Их следует выводить как
8.92, 3.2, 120.(6), 0.(3), 5, 2, 0.3, 0.3(30) .

Примеры
№	INPUT.TXT	OUTPUT.TXT
1	10/7		1.(428571)
2	1/3			0.(3)
3	100/25		4
 */

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Scanner;


public class acmp_0109_Chisla_cycles  {
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	String input = sc.nextLine();
	String outcome = null;
	String input_arr [] = input.split("/");
	
	input_arr[1] = "983";		//113
	
	
	BigDecimal a = new BigDecimal(input_arr[0]);
	BigDecimal b = new BigDecimal(input_arr[1]);
	
	boolean isCyclic = false;
	BigDecimal result = new BigDecimal("0");
	try {
		result = a.divide(b);}
	catch (ArithmeticException exc) {
		result = a.divide(b, 2000, RoundingMode.FLOOR);
		isCyclic = true;	}
	
	if (isCyclic == true) {
		String temp = String.valueOf(result);
		System.out.println(temp);
		String Arr[] = temp.split("\\.");
		String drobnay_part = Arr[1];
//		System.out.println(drobnay_part);
		
		int count_fig = 0;
		String cyclic = null;
		boolean findCycle = false;
		int startCyclic = 0;
		int countRepetition = 0;
				
		for (int k = 0; k<drobnay_part.length(); k++) {
			int add = 0;
				countRepetition = 0;
			for (int i = k+1; i<drobnay_part.length(); i++) {
				countRepetition = 0;
				add++;
	//			System.out.println();
				String isCycleTemp = drobnay_part.substring(k, i);
//				System.out.println("isCycleTemp = " + isCycleTemp);
				for (int j = i; j<=drobnay_part.length()- add; j = j+add) {
					String abb = drobnay_part.substring(j,j+add);
//					System.out.println("abb = " + abb);
					if (abb.equals(isCycleTemp)) {
						if (i!= drobnay_part.length()-1) {
							startCyclic = k;
							cyclic = drobnay_part.substring(j,j+add);
							findCycle = true;}
					}
					else {
						findCycle = false;		//	1/31 	0.03225806451612903225		- (2) не д.б.		100
												// 	1/17 	0.05882352941176470588		- (8) не д.б.		100
												//  1/17 	0.0588235294117647 0588235294117647 0			1000
												// 	1/7     0.14285714285714285714		0.(142857)			100
												//  1/15  	0.06666666666666666666		0.0(6)				100
												//  1/983   0.0010172939979654120040691759918616480162767    - - (9) не д.б. 
						break;
					}
					if (findCycle == true) countRepetition++;
					else countRepetition = 0;
//					System.out.println("findCycle = " + findCycle + " ,  countRepetition = " + countRepetition + " abb= " + abb);
					if ((findCycle == true) && (countRepetition >=5)) break;
				}
				if (findCycle == true) break;
			}
			if (findCycle == true) break;
		}
		if (findCycle == true)  {outcome =  Arr[0] + "." + drobnay_part.substring(0, startCyclic) + "(" + cyclic + ")";}
		else outcome = Arr[0] + ".(" + drobnay_part + ")";
	}
	else outcome = String.valueOf(result);
	
	System.out.println(outcome);
	
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	out.println(outcome);
    out.flush();
    out.close();
}
}