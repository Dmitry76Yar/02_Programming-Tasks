package f04_ACMP_101_200;
/*		Прямоугольник		(Время: 1 сек. Память: 16 Мб Сложность: 42%)
Задан целочисленный прямоугольный массив M×N. Необходимо определить прямоугольную область данного массива, сумма элементов
которого максимальна.
	Входные данные
В первой строке входного файла INPUT.TXT записаны два натуральных числа N и M (1 ≤ N, M ≤ 100) – количество строк и столбцов
прямоугольной матрицы. Далее идут N строк по M чисел, записанных через пробел – элементы массива, целые числа, не превосходящие
100 по абсолютной величине.
	Выходные данные
В выходной файл OUTPUT.TXT необходимо вывести целое число – сумму элементов найденного прямоугольного подмассива. Подмассив
должен содержать хотя бы один элемент.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	2 3
	5 0 9
	1 2 7			24
2	4 5
	-7 8 -1 0 -2	20
	2 -9 2 4 -6
	-7 0 6 8 1
	4 -8 -1 0 -6
 */

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;

public class acmp_0115_BufferArray  {
public static void main(String[] args) throws IOException {
	int Count[][] = new int [4][5];
	BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\JavaTXT\\ACMP_0001\\input.txt"), Charset.forName("UTF-8")));
	
	reader.readLine();
	int k;
	char c;
	int a;
	int i = 0;
	int j = 0;
	StringBuilder numberString = new StringBuilder();
	while(true) {
		k = reader.read();
		if (k != 13 &&  k != 32 && k!=-1) {
			c = (char)k;
			numberString.append(Character.toString(c));
		}
		else  {
			if ((numberString.length() !=0)&&(k!= 45)) {		// Если строка не пустая (защита от двойного пробела) 
				a = Integer.parseInt(numberString.toString());
				Count[i][j++] = a;
				if (j%5 == 0) {
					reader.readLine();
					i++; 
					j = 0;
				}
				numberString.delete(0, numberString.length());
			}
		}
		if (i == 4) break;
	}
	reader.close();
	
	for (int x= 0; x <4; x++) System.out.println(Arrays.toString(Count[x]));
	
	
	
	}
}
