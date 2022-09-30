	package f05_ACMP_150_199;

/* Наручные часы		(Время: 1 сек. Память: 16 Мб Сложность: 37%)
Вы приобрели новые электронные наручные часы с жидкокристаллическим дисплеем. Дисплей отображает часы и минуты с помощью четырех
элементов, каждый из которых отображает одну цифру.	 
	Три из них состоят из семи полосок, каждая из которых может быть либо белой (неотличимой от фона), либо черной. Вид такого 
элемента и отображаемые им цифры показаны на рисунке:
	Четвертый элемент предназначен для отображения старшей цифры часа. Если она равна нулю, то элемент полностью неактивен
(все полоски белые), иначе показывается соответствующая цифра. Вот как выглядит этот элемент с цифрами:
	Вам хочется проверить: все ли в порядке с новым приобретением, а именно, нет ли таких полосок в каком-либо из элементов, которые
либо всегда белые, либо всегда черные. Вы хотите начать проверку в некоторое начальное время. Требуется определить, сколько Вам 
потребуется минут для убеждения в исправности часов.
	Входные данные
В первой строке входного файла INPUT.TXT находится время начала проверки в формате HH:MM. Часы и минуты записаны с лидирующими нулями,
если таковые имеются. (00 ≤ HH ≤ 23, 00 ≤ MM ≤ 59).
	Выходные данные
В выходной файл OUTPUT.TXT выведите минимальное число минут, необходимое для проверки Ваших часов, если она началась в заданное время.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	00:00	1200
2	02:39	1041

*/

import java.util.*;
import java.io.*;

public class acmp_0175_Clock{
	static ArrayList<Integer> hour0_2 = new ArrayList<Integer>();
	static ArrayList<Integer> hour0_9 = new ArrayList<Integer>();
	
	static void toMakeBlack(ArrayList<Integer> arl, int t, int action) {
		if (action == 1) arl.set(t, 1);
		else 
			if (arl.get(t) == 0) arl.set(t, 2);
	}
	
	static void toMakeWhite(ArrayList<Integer> arl, int t, int action) {
		if (arl.get(t) == 1) arl.set(t, 2);
	}
	
	static void time0 (ArrayList<Integer> arl, int action, int h) {
		if (h==1) {
			toMakeWhite(arl, 0, action);	toMakeWhite(arl, 1, action);	toMakeWhite(arl, 2, action);	
			toMakeWhite(arl, 3, action);	toMakeWhite(arl, 4, action);	toMakeWhite(arl, 5, action);
			toMakeWhite(arl, 6, action);}
		else {
			toMakeBlack(arl, 0, action);	toMakeBlack(arl, 1, action);	toMakeBlack(arl, 2, action);	
			toMakeBlack(arl, 3, action); 	toMakeBlack(arl, 4, action);	toMakeBlack(arl, 5, action);	
			toMakeWhite(arl, 6, action);}
	}
	
	static void time1 (ArrayList<Integer> arl, int action) {
		toMakeBlack(arl, 3, action);	toMakeBlack(arl, 4, action);	toMakeWhite(arl, 0, action);    toMakeWhite(arl, 1, action);
		toMakeWhite(arl, 2, action);	toMakeWhite(arl, 5, action);	toMakeWhite(arl, 6, action);}
	
	static void time2 (ArrayList<Integer> arl, int action) {
		toMakeBlack(arl, 2, action);	toMakeBlack(arl, 3, action);	toMakeBlack(arl, 6, action);	toMakeBlack(arl, 1, action);
		toMakeBlack(arl, 5, action);	toMakeWhite(arl, 0, action);	toMakeWhite(arl, 4, action);	}

	static void time3 (ArrayList<Integer> arl, int action) {
		toMakeBlack(arl, 2, action);	toMakeBlack(arl, 3, action);	toMakeBlack(arl, 6, action);	toMakeBlack(arl, 4, action);
		toMakeBlack(arl, 5, action);	toMakeWhite(arl, 0, action);	toMakeWhite(arl, 1, action);	}
	
	static void time4 (ArrayList<Integer> arl, int action) {
		toMakeBlack(arl, 0, action);	toMakeBlack(arl, 6, action);	toMakeBlack(arl, 3, action);	toMakeBlack(arl, 4, action);
		toMakeWhite(arl, 2, action);	toMakeWhite(arl, 1, action);	toMakeWhite(arl, 5, action);	}
	
	static void time5 (ArrayList<Integer> arl, int action) {
		toMakeBlack(arl, 2, action);	toMakeBlack(arl, 0, action);	toMakeBlack(arl, 6, action);	toMakeBlack(arl, 4, action);
		toMakeBlack(arl, 5, action);	toMakeWhite(arl, 1, action);	toMakeWhite(arl, 3, action);	}
	
	static void time6 (ArrayList<Integer> arl, int action) {
		toMakeBlack(arl, 0, action);	toMakeBlack(arl, 1, action);	toMakeBlack(arl, 2, action);	toMakeBlack(arl, 4, action);
		toMakeBlack(arl, 5, action);	toMakeBlack(arl, 6, action);	toMakeWhite(arl, 3, action);	}
	
	static void time7 (ArrayList<Integer> arl, int action) {
		toMakeBlack(arl, 2, action);	toMakeBlack(arl, 3, action);	toMakeBlack(arl, 4, action);	toMakeWhite(arl, 0, action);
		toMakeWhite(arl, 6, action);	toMakeWhite(arl, 1, action);	toMakeWhite(arl, 5, action);	}
	
	static void time8 (ArrayList<Integer> arl, int action) {
		toMakeBlack(arl, 0, action);	toMakeBlack(arl, 1, action);	toMakeBlack(arl, 2, action);	toMakeBlack(arl, 3, action);
		toMakeBlack(arl, 4, action);	toMakeBlack(arl, 5, action);	toMakeBlack(arl, 6, action);	}
	
	static void time9 (ArrayList<Integer> arl, int action) {
		toMakeBlack(arl, 0, action);	toMakeBlack(arl, 2, action);	toMakeBlack(arl, 3, action);
		toMakeBlack(arl, 4, action);	toMakeBlack(arl, 5, action);	toMakeBlack(arl, 6, action);	toMakeWhite(arl, 1, action);}
	
	static void changeTime (ArrayList<Integer> arl, int t, int action, int hour) {
		if (t==0) time0(arl, action, hour);
		else if  (t==1) time1(arl, action);
		else if  (t==2) time2(arl, action);
		else if  (t==3) time3(arl, action);
		else if  (t==4) time4(arl, action);
		else if  (t==5) time5(arl, action);
		else if  (t==6) time6(arl, action);
		else if  (t==7) time7(arl, action);
		else if  (t==8) time8(arl, action);
		else if  (t==9) time9(arl, action);
	}
	
	
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	String [] y = sc.nextLine().split(":");
	int [] time = new int [3];
	time[2] = Integer.parseInt(y[1]);
	int a = Integer.parseInt(y[0]);
	if (a>9) {
		time[1] = a%10;
		time[0] = a/10;
	}
	else {
		time[1] = a;
		time[0] = 0;
	}
//	System.out.println(Arrays.toString(time));
	
	for (int i=0; i<=6; i++) hour0_2.add(0);
	for (int i=0; i<=6; i++) hour0_9.add(0);
	changeTime(hour0_2, time[0], 1, 1);
	changeTime(hour0_9, time[1], 1, 2);
	hour0_2.set(0, 2);
	
//	System.out.println(hour0_2);
//	System.out.println(hour0_9);
	
	ArrayList<Integer> hour0_2_goal = new ArrayList<Integer>();
	ArrayList<Integer> hour0_9_goal = new ArrayList<Integer>();
	for (int i=0; i<=6; i++) hour0_2_goal.add(2);
	for (int i=0; i<=6; i++) hour0_9_goal.add(2);
	
	int result = 60-time[2];
	
	while (true) {
		if (time[0] == 0) {
			if (time[1] == 9) {time[0] = 1; 	time[1] =0;	}
			else time[1]++;}
		else if (time[0] == 1) {
			if (time[1] == 9) {	time[0] = 2; 	time[1] =0;	}
			else time[1]++;}
		else if (time[0] == 2) {
			if (time[1] == 3) {time[0] = 0;		time[1] = 0;}
			else time[1]++;}
//		System.out.println("time[0]  = " + time[0] + "    time[1] = " + time[1]);
		changeTime(hour0_2, time[0], 2, 1);
		changeTime(hour0_9, time[1], 2, 2);
//		System.out.println("hour0_2 = " + hour0_2);
//		System.out.println("hour0_9 = " + hour0_9);
		if ((hour0_2.equals(hour0_2_goal)) && (hour0_9.equals(hour0_9_goal))) break;
		result +=60;
	}

	System.out.println("result = " + result);
	
	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	o.println(result);
	o.flush();
	o.close();
}
}