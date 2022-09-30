package f03_ACMP_51_100;
	/*	Строки - 2		(Время: 0,4 сек. Память: 16 Мб Сложность: 42%)
Задан набор строк S = {s1, s2, s3, ... , sn}. Необходимо найти количество строк si из S, представимых в виде конкатенации двух строк sj и 
sk из S (si = sjsk, j и k при этом могут совпадать).
	Входные данные
Входной файл INPUT.TXT содержит набор строк S – по одному элементу на строке. i-ая строка входного файла содержит si. Последняя строка 
входного файла содержит строку ENDOFINPUT. Она обозначает конец входных данных и не входит в S.
	Все si состоят только из маленьких букв английского алфавита и имеют длину от 1 до 100 символов. Во входном файле не более 240 строк 
(включая строку, содержащую ENDOFINPUT).
	Выходные данные
В выходной файл OUTPUT.TXT выведите ответ без ведущих нулей.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	aa
	aaaa
	ab
	abaa
	ENDOFINPUT		2
2	abc
	bcd
	def
	ENDOFINPUT		0 */	

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class acmp_0085  {
public static void main(String[] args) throws IOException {
	BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\JavaTXT\\ACMP_0001\\input.txt"), Charset.forName("UTF-8")));
	ArrayList<String> arl = new ArrayList<String>();
	while (true) {
		String temp = reader.readLine();
		if (temp.equals("ENDOFINPUT")) break;
		else arl.add(temp);
	}
	reader.close();
//	System.out.println(arl);
	
	int count = 0;
	ArrayList<String> arl22 = new ArrayList<String>();
	arl22.addAll(arl);
	
//	for (int i = 0; i<arl.size(); i++) {
//		for (int j = 0; j<arl.size(); j++) {
//			StringBuffer sum = new StringBuffer();
//			sum.append(arl.get(i)).append(arl.get(j));
////			System.out.println("sum = " + sum);
//			if (arl22.contains(sum.toString())) {
//					arl22.remove(arl22.indexOf(sum.toString()));
////					System.out.println("hhhhhh" + arl22);
//					count++;
//					j--;}
//		}
//	}
	
	for (int i = 0; i<arl.size(); i++) {
		for (int j = 0; j<arl.size(); j++) {
			String sum = arl.get(i) + arl.get(j);
//			System.out.println("sum = " + sum);
			
			if (arl22.contains(sum)) {
					arl22.remove(arl22.indexOf(sum));
//					System.out.println("hhhhhh" + arl22);
					count++;
					j--;}
		}
	}
	
	System.out.println(count);
	
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(count);
	pw.close();
}
}