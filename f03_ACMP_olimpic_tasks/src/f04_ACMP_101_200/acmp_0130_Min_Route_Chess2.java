package f04_ACMP_101_200;
/* Два коня	(Время: 1 сек. Память: 16 Мб Сложность: 55%)
На стандартной шахматной доске (8х8) живут 2 шахматных коня: красный и зеленый. Обычно они беззаботно скачут по просторам доски,
пощипывая шахматную травку, но сегодня особенный день: у зеленого коня день рождения. зеленый конь решил отпраздновать это событие
вместе с красным. Но для осуществления этого прекрасного плана им нужно оказаться на одной клетке. Заметим, что красный и зеленый
шахматные кони сильно отличаются от черного с белым: они ходят не по очереди, а одновременно, и если оказываются на одной клетке,
 никто никого не съедает. Сколько ходов им потребуется, чтобы насладиться праздником?
	Входные данные
Во входном файле INPUT.TXT содержатся координаты коней, записанные по стандартным шахматным правилам (т.е. двумя символами - маленькая
английская буква (от a до h) и цифра (от 1 до 8), задающие столбец и строку соответственно).
	Выходные данные
Выходной файл OUTPUT.TXT должен содержать наименьшее необходимое количество ходов, либо -1, если кони не могут встретиться.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1	a1 a3			1
						*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0130_Min_Route_Chess2
{
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	String str = sc.nextLine();
	String[] str_ar = str.split(" ");
	int x1 = 0;
	int x2 = 0;
	System.out.println(str_ar[0]);
	System.out.println(str_ar[1]);
	int y1 = Integer.parseInt(str_ar[0].substring(1,2)) -1;
	int y2 = Integer.parseInt(str_ar[1].substring(1,2)) -1;
	if (str_ar[0].substring(0,1).equals("a")) x1 = 0; 		if (str_ar[1].substring(0,1).equals("a")) x2 = 0;
	if (str_ar[0].substring(0,1).equals("b")) x1 = 1; 		if (str_ar[1].substring(0,1).equals("b")) x2 = 1;
	if (str_ar[0].substring(0,1).equals("c")) x1 = 2; 		if (str_ar[1].substring(0,1).equals("c")) x2 = 2;
	if (str_ar[0].substring(0,1).equals("d")) x1 = 3; 		if (str_ar[1].substring(0,1).equals("d")) x2 = 3;
	if (str_ar[0].substring(0,1).equals("e")) x1 = 4; 		if (str_ar[1].substring(0,1).equals("e")) x2 = 4;
	if (str_ar[0].substring(0,1).equals("f")) x1 = 5; 		if (str_ar[1].substring(0,1).equals("f")) x2 = 5;
	if (str_ar[0].substring(0,1).equals("g")) x1 = 6; 		if (str_ar[1].substring(0,1).equals("g")) x2 = 6;
	if (str_ar[0].substring(0,1).equals("h")) x1 = 7; 		if (str_ar[1].substring(0,1).equals("h")) x2 = 7;
	
	System.out.println(" x1  = " + x1 + "   y1= " + y1 + "  x2 =  " + x2 +  "   y2 = " + y2);
	
	int Table[][] = new int[8][8];
	int t = x1;
	x1 = y1;
	y1 = t;
	t = x2;
	x2 = y2;
	y2 = t;
	
//	for (int i =0; i<8; i++) System.out.println("TABLE = " + Arrays.toString(Table[i]));
	
	ArrayList<int[]> queue = new ArrayList<int[]>();
	queue.add(new int[] {x1,y1});
	
	ArrayList<int[]> queueThisStep = new ArrayList<int[]>();
	int step = 0;
//	
	while (queue.isEmpty() == false) {
		step++;
		while (queue.isEmpty() == false) {
			int d[] = queue.remove(0);
			int xst = d[0];
			int yst = d[1];
//			System.out.println("xst = " + xst + "   yst = " + yst);
			
			if (((xst-2) >=0) && ((yst+1) <8) && (Table[xst-2][yst+1] == 0)) {
				Table[xst-2][yst+1] = step;
				queueThisStep.add(new int[] {xst-2, yst+1});	}
			
			if (((xst-1) >=0) && ((yst+2) <8)  && (Table[xst-1][yst+2] == 0)) {
				Table[xst-1][yst+2] = step;
				queueThisStep.add(new int[] {xst-1, yst+2});	}
			
			if (((xst+1) <8) && ((yst+2) <8) && (Table[xst+1][yst+2] == 0)){
				Table[xst+1][yst+2] = step;
				queueThisStep.add(new int[] {xst+1, yst+2});	}
			
			if (((xst+2) <8) && ((yst+1) <8) && (Table[xst+2][yst+1] == 0)) {
				Table[xst+2][yst+1] = step;
				queueThisStep.add(new int[] {xst+2, yst+1});	}
			
			if (((xst+2) <8) && ((yst-1)>=0) && (Table[xst+2][yst-1] == 0)) {
				Table[xst+2][yst-1] = step;
				queueThisStep.add(new int[] {xst+2, yst-1});	}
			
			if (((xst+1) <8) && ((yst-2) >=0) && (Table[xst+1][yst-2] == 0)) {
				Table[xst+1][yst-2] = step;
				queueThisStep.add(new int[] {xst+1, yst-2});	}
			
			if (((xst-1) >=0) && ((yst-2) >=0) && (Table[xst-1][yst-2] == 0)) {
				Table[xst-1][yst-2] = step;
				queueThisStep.add(new int[] {xst-1, yst-2});	}
			
			if (((xst-2) >=0) && ((yst-1) >=0) && (Table[xst-2][yst-1] == 0)){
				Table[xst-2][yst-1] = step;
				queueThisStep.add(new int[] {xst-2, yst-1});	}
		}	// end of second WHILE
//		for (int i=0; i<8; i++) System.out.println(Arrays.toString(Table[i]));
//		System.out.println();
		queue.addAll(queueThisStep);
		queueThisStep.clear();
	}	// end of first WHILE
	Table[x1][y1] = 0;
	for (int i=0; i<8; i++) System.out.println(Arrays.toString(Table[i]));
	
	int Table3[][] = new int[8][8];
	step = 0;
//	
	queue.add(new int[] {x2,y2});
	while (queue.isEmpty() == false) {
		step++;
		while (queue.isEmpty() == false) {
			int d[] = queue.remove(0);
			int xst = d[0];
			int yst = d[1];
//			System.out.println("xst = " + xst + "   yst = " + yst);
			
			if (((xst-2) >=0) && ((yst+1) <8) && (Table3[xst-2][yst+1] == 0)) {
				Table3[xst-2][yst+1] = step;
				queueThisStep.add(new int[] {xst-2, yst+1});	}
			
			if (((xst-1) >=0) && ((yst+2) <8)  && (Table3[xst-1][yst+2] == 0)) {
				Table3[xst-1][yst+2] = step;
				queueThisStep.add(new int[] {xst-1, yst+2});	}
			
			if (((xst+1) <8) && ((yst+2) <8) && (Table3[xst+1][yst+2] == 0)){
				Table3[xst+1][yst+2] = step;
				queueThisStep.add(new int[] {xst+1, yst+2});	}
			
			if (((xst+2) <8) && ((yst+1) <8) && (Table3[xst+2][yst+1] == 0)) {
				Table3[xst+2][yst+1] = step;
				queueThisStep.add(new int[] {xst+2, yst+1});	}
			
			if (((xst+2) <8) && ((yst-1)>=0) && (Table3[xst+2][yst-1] == 0)) {
				Table3[xst+2][yst-1] = step;
				queueThisStep.add(new int[] {xst+2, yst-1});	}
			
			if (((xst+1) <8) && ((yst-2) >=0) && (Table3[xst+1][yst-2] == 0)) {
				Table3[xst+1][yst-2] = step;
				queueThisStep.add(new int[] {xst+1, yst-2});	}
			
			if (((xst-1) >=0) && ((yst-2) >=0) && (Table3[xst-1][yst-2] == 0)) {
				Table3[xst-1][yst-2] = step;
				queueThisStep.add(new int[] {xst-1, yst-2});	}
			
			if (((xst-2) >=0) && ((yst-1) >=0) && (Table3[xst-2][yst-1] == 0)){
				Table3[xst-2][yst-1] = step;
				queueThisStep.add(new int[] {xst-2, yst-1});	}
		}	// end of second WHILE
//		for (int i=0; i<8; i++) System.out.println(Arrays.toString(Table3[i]));
		queue.addAll(queueThisStep);
		queueThisStep.clear();
	}	// end of first WHILE
	Table3[x2][y2] = 0;
	System.out.println();
	for (int i=0; i<8; i++) System.out.println(Arrays.toString(Table3[i]));
	
//	Table[x1][y1] = 2;
//	Table3[x2][y2] = 2;
	int min = 100;
	int temp = 0;
	int a1 = 0;
	int b1 = 0;
	for (int i=0; i<8; i++) {
		for (int j=0; j<8; j++) {
			if ((Table[i][j]%2 == 0) && (Table3[i][j]%2 == 0)) {
				if (Table[i][j] > Table3[i][j]) temp = Table3[i][j] + (Table[i][j] - Table3[i][j]);
				else if (Table[i][j] < Table3[i][j]) temp = Table[i][j] + (Table3[i][j] - Table[i][j]);
				else if (Table[i][j] == Table3[i][j]) temp = Table[i][j] ;
				if (temp<min) {
					min = temp;
					a1 = i;	
					b1= j;
//					System.out.println(" temp = "  + temp +  "  min = " + min +  " a1 = " + a1  + "   b1 = " + b1);
				}
//				System.out.println("Table[" + i + " ][" + j+ "] = " + Table[i][j] + "    Table3[" + i + "][" + j + "] = " + Table3[i][j] + "  temp = " + temp);
				}
			if ((Table[i][j]%2 == 1) && (Table3[i][j]%2 == 1)) {
				if (Table[i][j] > Table3[i][j]) temp = Table3[i][j] + (Table[i][j] - Table3[i][j]);
				else if (Table[i][j] < Table3[i][j]) temp = Table[i][j] + (Table3[i][j] - Table[i][j]);
				else if (Table[i][j] == Table3[i][j]) temp = Table[i][j] ;
				if (temp<min) {
					min = temp;
					a1 = i;	
					b1= j;
//					System.out.println(" temp = "  + temp +  "  min = " + min +  " a1 = " + a1  + "   b1 = " + b1);
				}
//				System.out.println("Table[" + i + " ][" + j+ "] = " + Table[i][j] + "    Table3[" + i + "][" + j + "] = " + Table3[i][j] + "  temp = " + temp);
				}
		}
	}
	System.out.println(" a1 = " + a1  + "   b1 = " + b1);
	if ((x1==x2)&&(y1==y2)) min = 0;
	if (min == 100) min = -1;
	System.out.println();
	System.out.println("RESULT = " + min + "  i = " + a1 + "   j = " + b1);
	
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	out.print(min);
    out.flush();
    out.close();
	}
}
