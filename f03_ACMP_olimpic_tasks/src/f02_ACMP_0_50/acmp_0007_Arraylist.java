package f02_ACMP_0_50;
/* 		Золото племени АББА 		(Время: 1 сек. Память: 16 Мб Сложность: 30%)
Главный вождь племени Абба не умеет считать. В обмен на одну из его земель вождь другого племени предложил ему выбрать одну из трех
куч с золотыми монетами. Но вождю племени Абба хочется получить наибольшее количество золотых монет. Помогите вождю сделать
правильный выбор!
	Входные данные
В первой строке входного файла INPUT.TXT записаны три натуральных числа через пробел. Каждое из чисел не превышает 10100.
Числа записаны без ведущих нулей.
	Выходные данные
В выходной файл OUTPUT.TXT нужно вывести одно целое число — максимальное количество монет, которые может взять вождь.   
Примеры
№				INPUT.TXT					OUTPUT.TXT
1				5 7 3							7
2			987531 234 86364				987531
3	189285 283 4958439238923098349024	4958439238923098349024*/

// ПРИНЯТО САЙТОМ

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner; 

public class acmp_0007_Arraylist{
public static void main(String[] args) throws IOException {
	Scanner sc;
	String str;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	str = sc.nextLine();
	String Array[] = str.split(" ");
	System.out.println(Arrays.toString(Array));
	
	int max_length = Array[0].length();
	String max_long_element = Array[0];
	for (int i = 0; i<3; i++) {
		if (max_length < Array[i].length()) {
			max_length = Array[i].length(); 	
			max_long_element = Array[i];}
		}
	System.out.println(max_length);
	System.out.println(max_long_element);
		
	ArrayList<String> array_list = new ArrayList<String>();
	for (int i = 0; i<3; i++) { 
		if (Array[i].length() == max_length)  array_list.add(Array[i]);}
	System.out.println(array_list.toString());  		
	
	char ch;
	for (int i= 0; i<max_length; i++) {					// Перебор символов числа-строки с 0 до последнего
//		y = array_list.get(0).charAt(i);
//		System.out.println(" i = " + i + "  y = " + y);
		ch = ' ';
		for (int k= 0; k<array_list.size(); k++) {		// Перебор чисел-строк в массиве для определения максимальной цифры
			if (ch<array_list.get(k).charAt(i)) 
				ch = array_list.get(k).charAt(i); 
				System.out.println(ch);}
		for (int k= 0; k<array_list.size(); k++) {		// Перебор чисел-строк в массиве для отсеивания малых чисел
			if (ch>array_list.get(k).charAt(i)) 
				{System.out.println("Меньше");
				array_list.remove(k);
				}
		}
		System.out.println(array_list.toString());	
	}
		String str1 = array_list.get(0);
		PrintWriter pw;
		pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
		pw.print(str1);
		pw.close();
	}
}