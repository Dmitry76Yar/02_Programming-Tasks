package f06_ACMP_200_201;

	/* Пакетная обработка процессов	(Время: 1 сек. Память: 16 Мб Сложность: 53%)
Для ускорения прохождения «коротких» заданий на ЭВМ выбран пакетный режим работы с квантованием времени процессора. Это значит,
что всем заданиям пакета по очереди представляется процессор на одинаковое время 10 с (круговой циклический алгоритм разделения 
времени). Если в течение этого времени заканчивается выполнение задания, оно покидает систему и освобождает процессор. Если же
очередного кванта времени не хватает для завершения задания, оно помещается в конец очереди — пакета. Последнее задание пакета
 выполняется без прерываний. Пакет считается готовым к вводу в ЭВМ, если в нем содержится K заданий. Новый пакет вводится в ЭВМ 
 после окончания обработки предыдущего. Задания поступают в систему с интервалом времени 60 ± 30 с и характеризуются временем
 работы процессора 50 ± 45 с.
	Требуется смоделировать процесс обработки N заданий и определить время начала и окончания каждого процесса.
	Входные данные
На первой строке входного файла INPUT.TXT находятся числа N и K - число процессов и количество процессов в пакете (1 ≤ N ≤ 1000,
1 ≤ K ≤ 100). Гарантируется, что N делится на K. Далее следуют N строк с информацией о времени формирования и необходимое время
на выполнение для каждого процесса. Все процессы стартуют в один день и следуют в порядке возрастания времени ввода их в систему.
	Выходные данные
Выведите в выходной файл OUTPUT.TXT для каждого процесса в отдельной строке время его старта и время окончания через пробел
в формате ЧЧ:ММ:СС.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1	6 2
00:01:02 63
00:02:14 76
00:03:16 14
00:04:02 19
00:04:36 17
00:05:45 75	00:02:14 00:04:17
00:02:24 00:04:33
00:04:33 00:04:57
00:04:43 00:05:06
00:05:45 00:06:12
00:05:55 00:07:17 */

import java.util.*;
import java.io.*;

public class acmp_0201{
	
	static int timeToSec (String str) {
		String ar[] = str.split(":"); 
		int sec = Integer.parseInt(ar[0])*3600 + Integer.parseInt(ar[1])*60  + Integer.parseInt(ar[2]);
//		if (sec >= 60*60*24)  sec = 86400-1;
		return sec;
	}
	
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	int K = sc.nextInt(); 
	sc.nextLine();
	int time[][] = new int[N][2];		// 1- время входа в сек		2- длительность для обработки в сек
	for (int i = 0; i<N; i++) {
		String str = sc.nextLine();
		String ar[] = str.split(" "); 
		time[i][0] = timeToSec(ar[0]);
		time[i][1] = Integer.parseInt(ar[1]);
		System.out.println(str + "  время входа = " + time[i][0] + "    длительность =  " + time[i][1]);
	}
	System.out.println();
	
	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	
	int curTime = 0;
	int numProcess = 0;
	for (int i = 0; i<N; i = i+K) {
			// Формируем пакет
		int packet[][] = new int[K][3];			// 0-  длительность	 1 - время начала	2- время окончания
		for (int j=i; j<i+K; j++)	packet[j-i][0] = time[j][1];
//		System.out.println("Enter");
//		for (int j=0; j<K; j++) System.out.println(Arrays.toString(packet[j]));
		
		if (time[i+K-1][0]>curTime) curTime = time[i+K-1][0];
//		System.out.println("curTime = " + curTime);
//		System.out.println();
		
			//Запускаем процессы внутри пакета
		int step = 1;
			// Пока все процессы в пакете не завершены
		while (true) {
			int exit = curTime;
			for (int j=0; j<K; j++) {
				if (step == 1) packet[j][1] = curTime;
				if(packet[j][0] !=0) {
					if (packet[j][0]>10)	{
						curTime = curTime + 10;
						packet[j][0] = packet[j][0] - 10;
					}
					else {
						curTime = curTime + packet[j][0];
						packet[j][0] = 0;
						packet[j][2] = curTime;
					}
				}
			}
			step++;
			if (exit == curTime) break;	// Время вообще не увеличилось -> все процессы завершены
		}	// End While
		
//		System.out.println("Exit");
//		for (int j=0; j<K; j++) System.out.println(Arrays.toString(packet[j]));
			// Если старт был позже 1 суток, то нужно их все обрезать
//		for (int j=0; j<K; j++) {
//			if (packet[j][1] >= 86400) {
//				packet[j][2] = 86399 + (packet[j][2] - packet[j][1]);
//				packet[j][1] = 86399;
//			}
//		}
		
			// Перевод обратно в минуты
//		System.out.println("");
		for (int j=0; j<K; j++) {
			String res = "";
			for (int k=1; k<3; k++) {
//				if ((packet[j][1] >= 86400) || (packet[j][2] >= 86400))  break;
				if (packet[j][1] >= 86400) break;
				int hour = packet[j][k]/3600;
				if (hour > 0) packet[j][k] =  packet[j][k] -  hour*3600;
				if (hour>=24) hour = hour - 24;
				int min = packet[j][k]/60;
				if (min > 0) packet[j][k] =  packet[j][k] -  min*60;
				int sec = packet[j][k];
				if (hour<10) res = res + "0" + hour + ":";
				else res = res + hour + ":";
				if (min<10) res = res + "0" + min  + ":";
				else res = res  + min  + ":";
				if (sec<10) res = res + "0" + sec;
				else res = res + sec;
				if (k==1) res = res + " ";
			}
				System.out.println(res);
				o.print(res + "\n");
		}	
//		System.out.println();
	}
	o.flush();
	o.close();
}
}




