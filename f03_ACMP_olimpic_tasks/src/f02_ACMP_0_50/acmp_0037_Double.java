package f02_ACMP_0_50;
/* Сжимающий оператор		(Время: 1 сек. Память: 16 Мб Сложность: 34%)
Оператором А, действующим из множества Х в множество Y (или просто оператором из X в Y) называется правило, согласно которому
каждому элементу x множества X сопоставляется элемент y=Ax из множества Y. Пусть X и Y – множества точек на плоскости. 
Оператор A из X в Y называется сжимающим с коэффициентом q, где q – вещественное число из полуинтервала [0, 1), если для
любого x из X выполнено ||Ax|| ≤ q*||x|| (здесь ||x|| - норма точки x – расстояние от x до начала координат). Проще говоря,
оператор называется сжимающим с коэффициентом q если он сопоставляет каждой точке точку, которая не менее, чем в q раз ближе
к началу координат.
	Для заданного оператора А требуется проверить является ли он сжимающим с коэффициентом q.
	Входные данные
Первая строка входного файла INPUT.TXT содержит количество точек n (1 ≤ n ≤ 100) и число q (0 ≤ q < 1), заданное не более чем с 3 знаками после десятичной точки. Следующие n строк содержат по 4 целых числа, по модулю не превосходящих 1000, разделенные пробелами – координаты точки множества X и сопоставленной ей точки из множества Y.
	Выходные данные
В выходной файл OUTPUT.TXT выведите одно слово: “Yes” если оператор является сжимающим с коэффициентом q и “No” в противном случае.
	Примеры
№	INPUT.TXT			OUTPUT.TXT
1		2 0.5
		0 10 5 0
		10 0 0 1			Yes
2		2 0.1
		0 10 5 0
		10 0 0 1			No
3		2 0.9
		0 0 0 0
		10 0 0 1			Yes 	 */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0037_Double {
public static void main(String[] args) throws IOException {

	// На входе   2 0.5     Т.к. 0.5 с точкой, то Scanner не может его распознать, как Double (д.б.запятая) 
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	
	int n = sc.nextInt();
	double q = 0;
	if (sc.hasNextDouble()) {
		q = sc.nextDouble();} 
	else {
		String str1 = sc.next();
		str1 = str1.replace(',', '.');
	q = Double.valueOf(str1); 	}
	
		// ЧТОБЫ НЕ БЫЛО ОШИБКИ С DOUBLE НУЖНО ПЕРЕВЕСТИ ЧИСЛО В INTEGER, отбросив все лишнее
		// Здесь для трех знаков после запятой умножаем на 1000 и далее при расчетах делим на 1000
	
	int q_int = (int)Math.round(q*1000);
	System.out.println("n = " + n + ",  q = " + q  + ",  q_int = " + q_int);
	
	sc.nextLine();
	ArrayList<int []> arl = new ArrayList<int []>();
	while (sc.hasNextLine()) {
		String str = sc.nextLine();
		String ArStr [] = str.split(" ");
		int ArFif[] = new int[4];
		for (int i=0; i<4; i++) ArFif[i] = Integer.parseInt(ArStr[i]);
		arl.add(ArFif);}
	sc.close();
	for (int i=0; i<arl.size(); i++) System.out.println(Arrays.toString(arl.get(i)));

	/* AB = √(xb - xa)2 + (yb - ya)2 + (zb - za)2 		Расстояние между точками
	 В каждой из n строк записаны координаты точек x1, y1, x2, y2 и если расстояние от первой точки до начала координат 
	 умноженное на q больше или равно расстоянию от второй точки до начала координат, то оператор мона назвать сжимающим с 
	 коэффициентом q */
	
	double dist_A = 0;
	double dist_B = 0;
	
	String result = "No";
	for (int i=0; i<arl.size(); i++) {
			dist_A = Math.sqrt(Math.pow(arl.get(i)[0], 2.0) + Math.pow(arl.get(i)[1], 2.0));
			dist_B = Math.sqrt(Math.pow(arl.get(i)[2], 2.0) + Math.pow(arl.get(i)[3], 2.0));
			System.out.println("dist_A = " + dist_A + ",   dist_B = " + dist_B);
			if ((dist_A*q_int/1000) >= dist_B) result = "Yes";
			else {
				result = "No";
				break;	}
	}
	System.out.println(result);	
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(result);
	pw.close();
	
	}
}
