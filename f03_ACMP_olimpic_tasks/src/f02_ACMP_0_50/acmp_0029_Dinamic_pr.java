package f02_ACMP_0_50;
/*  Компьютерная игра		(Время: 1 сек. Память: 16 Мб Сложность: 38%)
	Во многих старых играх с двумерной графикой можно столкнуться с подобной ситуацией. Какой-нибудь герой прыгает по платформам
(или островкам), которые висят в воздухе. Он должен перебраться от одного края экрана до другого. При этом при прыжке с одной 
платформы на соседнюю, у героя уходит |y2-y1| единиц энергии, где y1 и y2 – высоты, на которых расположены эти платформы. Кроме 
того, у героя есть суперприем, который позволяет перескочить через платформу, но на это затрачивается 3*|y3-y1| единиц энергии. 
Конечно же, энергию следует расходовать максимально экономно.
	Предположим, что вам известны координаты всех платформ в порядке от левого края до правого. Сможете ли вы найти, какое 
минимальное количество энергии потребуется герою, чтобы добраться с первой платформы до последней?
	Входные данные
В первой строке входного файла INPUT.TXT записано количество платформ n (1 ≤ n ≤ 30000). Вторая строка содержит n натуральных чисел,
не превосходящих 30000 – высоты, на которых располагаются платформы.
	Выходные данные
В выходной файл OUTPUT.TXT запишите единственное число – минимальное количество энергии, которую должен потратить игрок на 
преодоление платформ (конечно же в предположении, что cheat-коды использовать нельзя).

Пример
№	INPUT.TXT	OUTPUT.TXTs
1	3
	1 5 10			9
2	3
	1 5 2		3					*/

// Не проходит на сайте из-за превышения памяти

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0029_Dinamic_pr {
	
		// Метод подсчета кол-ва вариантов ходов для числа n
	static int quant_meth (int n) {				
		int Array[]	= new int [n+1];		// 1 3 4 5 6   f(0) = 0  f(1) = 1; f(2) = 1  ;  f(3) = 2
		Array[0] = 0;									// f(n) = f(n-1) + f(n-2)
		Array[1] = 1;
		Array[2] = 1;					 // 1 ----  2 ---- 3 ----  4 ---- 5 ---- 6 ---- 7  (n=7) 
										//  1cп     1сп    2сп    3 сп    5 сп   8сп    13сп
		for (int i = 3; i<=n; i++) {
			Array[i] = Array[i-1] + Array[i-2];
//			System.out.println("i = " + i + "   Array[i] = " + Array[i]);
			}
		return Array[n];
	}
	
	// Метод подсчета минимальных шагов до числа n
	static int minim_step (int c, int n, int City[]) {				
		/* 10 ----  3 ----  4 ----  8 ----------- 10 ----  1 ----  7 ----  1 ----  10 ----  12 ----  15
		   [0]     [7]     [8]     [8+4 =12]      [12+2=14]
		                   [18]    [18+4=22]      [22+2=24]
		                   		   [7+5*3=22]     [22+2=24]
		                   		                  [8+6*3=26]
		                   		                  [18+6*3=36]             
		ИТОГО нужно для получения всех вариантов затрат энергии до клетки 10
				- ко всем вариантам затрат энергии до клетки (n-2) = 4 прибавить 6*5 (суперход)
				- ко всем вариантам затрат энергии до клетки (n-1) = 8 прибавить 2 (обычный ход) 		*/
// 10
// 3 4 8 10 1 7 1 10 12 15
		ArrayList<Integer> prev_arr = new ArrayList<Integer>();			//  хранит все варинты энергии для пред. клетки	
		ArrayList<Integer> pred_prev_arr = new ArrayList<Integer>();	// хранит все варинты энергии для предпред. клетки
		pred_prev_arr.add(0);			
		prev_arr.add(Math.abs(City[1] - City[0]));
		int ordin_step;						
		int super_step;						
		
		for (int i = 2; i< n; i++) {		// Цикл для движения по массиву с городами
			System.out.print("City[" + i + "] = " + City[i] + "\t");
			ordin_step = Math.abs(City[i] - City[i-1]); 		System.out.print("ordin_step = " + ordin_step  + "\t" );
			super_step = Math.abs(3*(City[i] - City[i-2]));	System.out.print("super_step = " + super_step  + "\t"); System.out.println();
			
			System.out.println(" До изменений");
			System.out.println("pred_prev_arr = " + pred_prev_arr.toString());
			System.out.println("pred_prev_arr = " + prev_arr.toString());
			
			ArrayList<Integer> Temp = new ArrayList<Integer>();		// Массив для записи результата для текущей клетки
			for (int j = 0; j<pred_prev_arr.size(); j++) Temp.add(pred_prev_arr.get(j) + super_step);
			for (int j = 0; j<prev_arr.size(); j++) Temp.add(prev_arr.get(j) + ordin_step);
			
			pred_prev_arr.clear(); 						// Зачищаем и записываем в предпред массив предудущий массив
			for (int j = 0; j<prev_arr.size(); j++)
				pred_prev_arr.add(prev_arr.get(j));
					
			prev_arr.clear();							// Зачищаем и записываем в пред массив результат вычислений
			for (int j = 0; j<Temp.size(); j++)
				prev_arr.add(Temp.get(j));
			System.out.println("Temp = " + Temp.toString());
			Temp.clear();
			
			System.out.println(" После изменений");
			System.out.println("pred_prev_arr = " + pred_prev_arr.toString());
			System.out.println("prev_arr = " + prev_arr.toString());
		}
		int min = Integer.MAX_VALUE;
		for (int j = 0; j<prev_arr.size(); j++)
			 if (prev_arr.get(j) < min) min = prev_arr.get(j);
		System.out.println(min);
		return min;
	}
			
public static void main(String[] args) throws IOException {
	String str = null;
	boolean correct_input = true;
	int n = 0;
	
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	if (sc.hasNextLine()) {
		str = sc.nextLine();
		n = Integer.parseInt(str);}
	
	if ((n>=2) & (n<=30000)) {
		System.out.println("n = " + n);
	
		int Array[] = new int[n];
		if (correct_input = true) {
			if (sc.hasNextLine()) {
				str = sc.nextLine();
				String Temp1[] = str.split(" ");
				if (Temp1.length == n) {
					correct_input = true;
					for (int i = 0; i < n; i++)	 Array[i] = Integer.parseInt(Temp1[i]);
				}
				else correct_input = false;
			}
			System.out.println(Arrays.toString(Array));
		}
		else System.out.println("Wrong input");
		
		if (correct_input = true) {
			int result = 0;
			int b = quant_meth(n);
			System.out.println("Количество способов дойти до города n = " + b);
			result = minim_step(b, n, Array);
			PrintWriter pw;
			pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
			pw.print(result);
			pw.close();
	 		}
		else System.out.println("Wrong input");
		}
	else if (n==1) {
		System.out.println("Результат = " + 0);
		PrintWriter pw;
		pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
		pw.print(0);
		pw.close();
		
	}
	else System.out.println("Wrong input");
			
}
}
