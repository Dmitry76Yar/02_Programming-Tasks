package f06_ACMP_200_201;

	/* Сдвиг текста		(Время: 0,5 сек. Память: 16 Мб Сложность: 31%)
Мальчик Кирилл написал однажды на листе бумаги строчку, состоящую из больших и маленьких английских букв, а после этого ушел
играть в футбол. Когда он вернулся, то обнаружил, что его друг Дима написал под его строкой еще одну строчку такой же длины.
Дима утверждает, что свою строчку он получил циклическим сдвигом строки Кирилла направо на несколько шагов (циклический сдвиг
строки abcde на 2 позиции направо даст строку deabc). Однако Дима известен тем, что может случайно ошибиться в большом количестве
вычислений, поэтому Кирилл в растерянности - верить ли Диме? Помогите ему!
	По данным строкам выведите минимально возможный размер сдвига вправо или -1, если Дима ошибся.
	Входные данные
Первые две строки входного файла INPUT.TXT содержат строки Кирилла и Димы соответственно. Строки состоят только из английских
символов. Длины строк одинаковы, не превышают 10000 и не равны 0.
	Выходные данные
В выходной файл OUTPUT.TXT выведите единственное число - ответ на поставленную задачу.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1	abcde
	deabc				2		 */

import java.io.*;
import java.nio.charset.Charset;

public class acmp_0203{
public static void main(String[] args) throws IOException {
	BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\JavaTXT\\ACMP_0001\\input.txt"), Charset.forName("UTF-8")));
	String str = reader.readLine();
	String changedStr = reader.readLine();
	reader.close();
	
	int result = -1;
	int l = str.length();
//	for (int i=0; i<l; i++) {
//		String temp = str.substring(i, l) + str.substring(0, i);
////		System.out.println(temp);
//		if (temp.hashCode() == changedStr.hashCode()) {
////			System.out.println(" i = " + i);
//			result = i;
//			break;
//		}
//	}
	
	for (int i=0; i<l; i++) {
		String temp = str.substring(l-i, l) + str.substring(0, l-i);
//		System.out.println(temp);
		if (temp.hashCode() == changedStr.hashCode()) {
//			System.out.println(" i = " + i);
			result = i;
			break;
		}
	}
	
	System.out.println("result = " +  result);
	
	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	o.print(result);
	o.flush();
	o.close();
	}
}




