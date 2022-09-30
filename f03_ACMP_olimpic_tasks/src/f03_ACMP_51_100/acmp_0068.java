package f03_ACMP_51_100;
/*	Дом - Школа - Дом		(Время: 1 сек. Память: 16 Мб Сложность: 21%)
Мальчик Вася каждый день ездит на метро. Утром он едет в школу, а вечером того же дня, обратно из школы, домой. Для того, чтобы немного
сэкономить, он покупает электронную смарт-карту на X поездок. Когда он хочет зайти в метро, он прикладывает карту к турникету. Если на карте
осталось ненулевое количество поездок, то турникет пропускает Васю и списывает с карты одну поездку. Если же на карте не осталось поездок,
то турникет не пропускает Васю, и он (Вася) вынужден купить на этой же станции новую карту на X поездок и вновь пройти через турникет.
	Вася заметил, что в связи с тем, что утром метро переполнено, покупать новую карту утром накладно по времени, и он может опоздать в
школу. В связи с этим он хочет понять: будет ли такой день, что с утра, поехав в школу, Вася обнаружит у себя на карточке ноль поездок.
	Вася больше никуда на метро не ездит и поэтому заходит в метро только на станции около дома и на станции около школы.
	Входные данные
Во входном файле INPUT.TXT содержится ровно 2 строки. В первой содержится слово «School» или «Home» в зависимости от того, где первый раз
Вася купил карточку на X поездок. Во второй строке содержится натуральное число X, 1 ≤ X ≤ 1000.
	Выходные данные
В выходной файл OUTPUT.TXT следует вывести «Yes», если будет такой день, что дома утром у Васи на карточке окажется ноль поездок и «No» в
противном случае.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	Home
	1				Yes
2	School
	2				No */

import java.io.*;
import java.util.Scanner;

public class acmp_0068 {
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	String school_or_home = sc.nextLine();
	int N = sc.nextInt();
	
	String result = null;
	
	if (N ==1) result = "Yes";
	else {
		if ((school_or_home.equals("Home")) || (school_or_home.equals("home"))) result = "Yes";
		else if ((school_or_home.equals("School")) || (school_or_home.equals("school"))){
			if (N%2 == 1) result = "Yes";
			else result ="No";
		}
	}
	System.out.println(result);
	
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(result);
	pw.close();
}
}