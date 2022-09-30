	package f05_ACMP_150_199;
/* Энты	(Время: 1 сек. Память: 16 Мб Сложность: 39%)
Энты были созданы в Первоначальную эпоху вместе с другими обитателями Средиземья. Эльфийские легенды гласят, что когда Варда зажгла
звёзды и пробудились Эльфы, вместе с ними пробудились и Энты в Великих Лесах Арды.
	Когда Энты пришли в Арду, они ещё не умели говорить — этому искусству их обучали Эльфы, и Энтам это ужасно нравилось. Им доставляло
удовольствие изучать разные языки, даже щебетание Людей.
	Эльфы выработали хорошую технику обучения энтов своему языку. Первый энт, которого обучили эльфы, выучил всего два слова
— «tancave» (да) и «la» (нет). Обученный энт выбрал одного старого и одного молодого энта, не умеющих говорить, и обучил их всем
словам, которые знал сам. Затем обучение этих двух энтов продолжили сами эльфы. Каждый обучившийся у эльфов энт снова выбирал из
неговорящих сородичей одного старого и одного молодого, обучал их всем словам, которые знал, передавал эльфам и так далее.
	Выяснилось, что более молодые энты выучивали у эльфов ещё ровно столько же слов, сколько они узнали от обучавшего их энта. 
А вот более старые, уже склонные к одеревенению энты, пополняли свой запас всего лишь одним словом. После обучения у эльфов энты до
конца света уже не могли выучить ни одного нового слова.
	Общее число энтов в Средиземье больше, чем вы думаете. Интересно, а сколько из них знают ровно 150 квенийских слов? Похожую задачу
вам предстоит решить.
	Входные данные
Входной файл INPUT.TXT содержит натуральные числа K и P (K ≤ 106; 1 ≤ P ≤ 109), записанные через пробел.
	Выходные данные
Мы понимаем, что число энтов, знающих в точности K слов, может быть слишком велико, поэтому просим вывести в выходной файл OUTPUT.TXT лишь количество энтов, знающих ровно K слов, по модулю P.

Примеры
№	INPUT.TXT	OUTPUT.TXT
1	4 10			2
2	8 10			5
3	360 1000		179*/

import java.util.*;
import java.io.*;
	 
public class acmp_0184_Time{
    static int monDuration[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
     
    static int timeToMin (String str) {
        String regex = "[:.\s]";
        String ar[]= str.split(regex);
        int day = Integer.parseInt(ar[0]);
        int mon = Integer.parseInt(ar[1]);
        int hour = Integer.parseInt(ar[3]);
        int min = Integer.parseInt(ar[4]);
        int result = 0;
        for (int i =0; i<mon-1; i++) result = result + monDuration[i];
        result = (result + day)*8*60;
        result = result + (hour-10)*60 + min;
        return result;
    }
     
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
    int K = sc.nextInt();
    sc.nextLine();
    int array[] = new int[K];
    
    for (int i = 0; i<K; i++)   array[i] = timeToMin(sc.nextLine());
    System.out.println(Arrays.toString(array));
    Arrays.sort(array);
    System.out.println(Arrays.toString(array));
    
    int time = 0;
    for (int i = 0; i<K; i = i+2) 
    	time = time + array[i+1] - array[i] + 1;

    int hour = time/60;
	int min = time%60;
    System.out.println("hour = " + hour + "   min = " + min);
    
    StringBuilder sbr = new StringBuilder();
    sbr.append(hour + ":");
    if (min<10) sbr.append("0" + min);
    else sbr.append(min);
     
    System.out.println(sbr);
     
    
    PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
    o.print(sbr.toString());
    o.flush();
    o.close();
    }
}