package f03_ACMP_51_100;
	/*	Быстрый поезд		(Время: 1 сек. Память: 16 Мб Сложность: 30%)
Между двумя крупнейшими городами нашей страны Санкт-Петербургом и Москвой ежедневно совершают рейсы n поездов. Для каждого поезда известно
его время отправления из Санкт-Петербурга и время прибытия в Москву.
	Найдите самый быстрый поезд и его скорость в предположении, что длина железной дороги между Санкт-Петербургом и Москвой равна 650 км.
	Входные данные
Первая строка входного файла INPUT.TXT содержит целое число n (1 ≤ n ≤ 100). Каждая из последующих n строк описывает ровно один поезд.
Описание поезда состоит из его названия, времени отправления и времени прибытия. Название поезда – строка длиной от 1 до 50 символов,
заключенная в кавычки. Она может содержать буквы английского алфавита, пробелы, цифры, символы тире («–») и подчеркивания («_»). 
Время отправления и прибытия заданы в формате ЧЧ:ММ. Строчные и заглавные буквы в названиях поездов различаются.
	Время в пути для каждого из поездов составляет хотя бы одну минуту и не превышает 24 часов.
	Гарантируется, что самый быстрый поезд определяется единственным образом.
	Выходные данные
В выходной файл OUTPUT.TXT выведите название самого быстрого поезда и его скорость. Скорость выводите в километрах в час и округляйте к ближайшему целому по математическим правилам. Следуйте формату вывода, приведенному в примерах.
	Примеры
№	INPUT.TXT						OUTPUT.TXT
1	3
	"ER-200" 06:43 10:40
	"Red Arrow" 23:55 07:55
	"Express" 23:59 08:00		The fastest train is "ER-200".
								Its speed is 165 km/h, approximately.
2	3
	"Train1" 00:00 00:00
	"Train2" 00:00 00:01
	"Train3" 00:01 00:01		The fastest train is "Train2".
								Its speed is 39000 km/h, approximately.
3	2
	"Slow Train 1" 10:00 09:59
	"Slow Train 2" 10:00 10:00	The fastest train is "Slow Train 1".
								Its speed is 27 km/h, approximately. */	

import java.io.*;
import java.util.Scanner;

class Train {
	String name;
	String time_arrival;
	String time_departure;
	int speed;
	int time_jour;
	
	public Train(String income) {
		int first_bracket = income.indexOf('"');
		int last_bracket = income.lastIndexOf('"');
		this.name = income.substring(first_bracket, last_bracket+1);
		this.time_arrival = income.substring(last_bracket+2, last_bracket+7);
		this.time_departure = income.substring(last_bracket+8, last_bracket+13);
	
		int hour_arrival = Integer.parseInt(time_arrival.substring(0, 2));
		int min_arrival = Integer.parseInt(time_arrival.substring(3, 5));
		int hour_departure = Integer.parseInt(time_departure.substring(0, 2));
		int min_departure = Integer.parseInt(time_departure.substring(3, 5));
		
		int journey_time = (hour_departure- hour_arrival)*60 + (min_departure - min_arrival);
			// Если время = 0, то значит поезд ехал ровно сутки
		if (journey_time == 0) journey_time = 24*60;
			// Если время меньше нуля, то поезд приехал на следующие сутки
		else if (journey_time < 0) journey_time = 24*60 + journey_time;
		System.out.println("journey_time = " + journey_time);
		this.time_jour = journey_time;
		int distance = 650; 
		float speed_in_double = (float)distance/((float)journey_time/60);
		System.out.println("speed_in_min_per_hour=  " + speed_in_double);
		this.speed = (int)Math.round(speed_in_double);
//		System.out.println(this.speed );
	}
}

public class acmp_0089_Time  {
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	sc.nextLine();
	Train trains[] = new Train[N];
	for (int i = 0; i<N; i++) {
		trains[i] = new Train(sc.nextLine());
	}
	
	int time = Integer.MAX_VALUE;
	int temp = 0;
	int number_of_train = 0;
	for (int i = 0; i<N; i++) {
		temp = trains[i].time_jour;
		System.out.print(temp + "   ");
		System.out.println(trains[i].speed);
		if (time > temp) {
			time = temp;
			number_of_train = i;}
	}
	StringBuffer sbf = new StringBuffer();
	sbf.append("The fastest train is ").append(trains[number_of_train].name).append(".\n" + "Its speed is ").append(trains[number_of_train].speed).append(" km/h, approximately.");
	String result = sbf.toString();
	System.out.println(result);
			
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
    out.println("The fastest train is " + trains[number_of_train].name + ".");
    out.println("Its speed is " + trains[number_of_train].speed + " km/h, approximately.");
    out.flush();
    out.close();
}
}
