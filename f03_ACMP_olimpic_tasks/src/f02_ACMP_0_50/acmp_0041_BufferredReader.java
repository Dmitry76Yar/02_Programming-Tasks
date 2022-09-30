package f02_ACMP_0_50;
/*   Сортировка подсчетом  	(Время: 2 сек. Память: 128 Мб Сложность: 29%)
На планете «Аурон» атмосфера практически отсутствует, поэтому она известна своими перепадами температур в различных точках. 
Известно, что эти перепады колеблются от -100 до 100 градусов. Нашим специалистам удалось выяснить значения температур в N 
точках этой планеты. К сожалению, эти значения вычислены с большими погрешностями, поэтому их решили округлить до целых чисел.
Хотелось бы наглядно видеть участки с повышенной и пониженной температурой. Вам требуется помочь. Вы должны упорядочить 
температуры участков по неубыванию.
	Входные данные
В первой строке входного файла INPUT.TXT задано натуральное число N - количество участков (N ≤ 106). Во второй строке через 
пробел записаны целые значения температур этих участков, не превосходящие 100 по абсолютной величине.
	Выходные данные
В единственную строку выходного файла OUTPUT.TXT нужно вывести разделенные пробелом значения температур всех известных 
участков, которые должны следовать друг за другом в порядке неубывания.
	Примеры
№		INPUT.TXT								OUTPUT.TXT
1		3
	9 -20 14									-20 9 14
2		10
	12 7 92 5 18 4 32 48 11 74		4 5 7 11 12 18 32 48 74 92		*/

import java.io.*;
import java.nio.charset.Charset;

public class acmp_0041_BufferredReader  {
public static void main(String[] args) throws IOException {
	int Count[] = new int [201];
	BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\JavaTXT\\ACMP_0001\\input.txt"), Charset.forName("UTF-8")));
	
	reader.readLine();
	int k;
	char c;
	int a;
	int i = 0;
	StringBuilder numberString = new StringBuilder();
	do {
		k = reader.read();
		if (k != 13 &&  k != 32 && k!=-1) {
//			System.out.print("k = " + k);	System.out.println("c = " + (char)k);
			c = (char)k;
			numberString.append(Character.toString(c));
			
		}
		else  {
			if ((numberString.length() !=0)&&(k!= 45)) {		// Если строка не пустая (защита от двойного пробела) 
				a = Integer.parseInt(numberString.toString());
				System.out.println(a);
				Count[i++] = a;
//				numberString = new StringBuilder();
				numberString.delete(0, numberString.length());
				}
		}
	}
	while ((k!=-1) && (k!=10));		// При переносе строки и окончании символов - выход из цикла 
	reader.close();
	
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	for (int i = 0; i<= 200; i++) {
		for (int j = 0; j< Count[i]; j++) {
			pw.print((i-100) + " ");
		}
	}
	pw.close();

//	BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
//	for (int i = 0; i<= 200; i++) {
//		for (int j = 0; j< Count[i]; j++) {
//			writer.write((i-100) + " ");
//		}
//	}
//	writer.close();
	
	
	
	}
}
