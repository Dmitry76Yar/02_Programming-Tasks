package f06_ACMP_200_201;

	/* Таймер	(Время: 1 сек. Память: 16 Мб Сложность: 31%)
Таймер - это часы, которые умеют подавать звуковой сигнал по прошествии некоторого периода времени. Напишите программу, которая
определяет, когда должен быть подан звуковой сигнал.
	Входные данные
В первой строке входного файла INPUT.TXT записано текущее время в формате ЧЧ:ММ:СС (с ведущими нулями). При этом оно
удовлетворяет ограничениям: ЧЧ - от 00 до 23, ММ и СС - от 00 до 59.
	Во второй строке записан интервал времени, который должен быть измерен. Интервал записывается в формате Ч:М:С (где Ч, М и С
- от 0 до 109, без ведущих нулей). Дополнительно если Ч=0 (или Ч=0 и М=0), то они могут быть опущены. Например, 100:60 на самом
деле означает 100 минут 60 секунд, что то же самое, что 101:0 или 1:41:0. А 42 обозначает 42 секунды. 100:100:100 - 100 часов,
100 минут, 100 секунд, что то же самое, что 101:41:40.
	Выходные данные
В выходной файл OUTPUT.TXT выведите в формате ЧЧ:ММ:СС время, во сколько прозвучит звуковой сигнал. При этом если сигнал
прозвучит не в текущие сутки, то дальше должна следовать запись +<кол во> days. Например, если сигнал прозвучит на следующий
день – то +1 days.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	01:01:01
	48:0:0			01:01:01+2 days
2	01:01:01
	58:119			02:01:00
3	23:59:59
	1			00:00:00+1 days */

import java.util.*;
import java.io.*;

public class acmp_0205{
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	String start, duration; 
	start = sc.nextLine();
	duration = sc.nextLine();
	
	String a[] = start.split(":");
	int st = Integer.parseInt(a[0])*60*60 + Integer.parseInt(a[1])*60 + Integer.parseInt(a[2]);
	System.out.println("st = " + st);
	String b[] = duration.split(":");
	System.out.println("b= " + Arrays.toString(b)); 
	
	long dur = 0;
	if (b.length == 1) dur = Long.parseLong(b[0]);
	else if (b.length == 2) dur = Long.parseLong(b[0])*60 + Long.parseLong(b[1]);
	else dur = Long.parseLong(b[0])*60*60 + Long.parseLong(b[1])*60 + Long.parseLong(b[2]);
	System.out.println("dur = " + dur);
	
	long fin = dur + st;
	System.out.println("fin1 = " + fin);
	System.out.println("fin2 = " + fin/(24*60*60));
	
	long days = 0;
	if (fin/(24*60*60) >0)  {
		days = fin/(24*60*60);
		fin = fin - days*24*60*60;
	}
	System.out.println("fin = " + fin);
	System.out.println("days = " + days);
	
	int h = (int)fin/(60*60);
	fin = fin - h*60*60;
	System.out.println("h = " + h);
	System.out.println("days = " + days);
	
	int m = (int)fin/60;
	fin = fin-m*60;
	StringBuilder sb = new StringBuilder();
	
	if (h<10) sb.append("0").append(h);
	else sb.append(h);
	sb.append(":");
	System.out.println(sb);
	
	if (m<10) sb.append("0").append(m);
	else sb.append(m);
	sb.append(":");
	
	if (fin<10) sb.append("0").append(fin);
	else sb.append(fin);

	if (days>0) sb.append("+").append(days).append(" days");

	System.out.println(sb);
	
	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	o.print(sb);
	o.flush();
	o.close();
}
}




