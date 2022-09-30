package f05_ACMP_150_199;

/* 	Карточки	(Время: 1 сек. Память: 16 Мб Сложность: 38%)
На день рождения Пете подарили набор карточек с буквами. Теперь Петя с большим интересом составляет из них разные слова. И вот,
однажды, составив очередное слово, Петя заинтересовался вопросом: "А сколько различных слов можно составить из тех же карточек,
что и данное?".
	Помогите ему ответить на этот вопрос.
	Входные данные
Во входном файле INPUT.TXT задано слово, составленное Петей - строка из маленьких английских букв не длиннее 15 символов.
	Выходные данные
В выходной файл OUTPUT.TXT выведите одно целое число - ответ на поставленную задачу.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1	solo			12		*/

import java.util.*;
import java.io.*;
import java.math.BigInteger;

// ЗАДАЧА - ПОСЧИТАТЬ КОЛИЧЕСТВО РАЗНЫХ СЛОВ ИЗ НАБОРА БУКВ (Для слово solo необходимо учитесь повторение буквы о)

public class acmp_0157_Combin	{
	
	static BigInteger factorial (int N) {
		BigInteger result = new BigInteger("1");
		if (N>12) {
			for (int i=1; i<=N; i++) result = result.multiply(new BigInteger(Integer.toString(i)));}
		else {
			int res = 1;
			for (int i=1; i<=N; i++) res = res*i;
			result = new BigInteger(Integer.toString(res));
		}
		return result;
	}

public static void main(String[] args) throws IOException {

	/* ПЕРЕСТАНОВКИ С ПОВТОРЕНИЯМИ  (имеется в виду повторяющие цифры в числе или буквы в слове)
Пусть исходное множество может, кроме уникальных, неповторяющихся, содержать какие-то одинаковые элементы, например:
{1, 1, 2, 2, 2, 3, 3, 3, 3}.
Тогда при всех возможных перестановках будут возникать одинаковые варианты, в которых местами меняются только одинаковые элементы. 
Такие повторы необходимо исключить при подсчете количества неповторяющихся комбинаций.
	Формула количества возможных перестановок с повторениями:
		P(n1,n2....nk) = n!/ (n1!*n2!*n3!*...nk!)
			где n1+n2+n3+...nk = n
	Здесь n – общее количество элементов в исходном множестве (для нашего примера – 9), а n1, n2, n3  … – количества элементов
в каждой группе из одинаковых элементов (в нашем примере имеется n1  = 2 элемента «1», n2  = 3 элемента «2», n3  = 4 элемента «3»).
	*/
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	String s = sc.nextLine(); 
	s = "soorrtt";
	
		// Для хранения числа повторений каждой буквы в слове
	ArrayList<Integer> arr = new ArrayList<Integer>();
		// Считаем число повторений каждой буквы
	char word[] = s.toCharArray();
	for (int i = 0; i<word.length;i++) {
		int a = 1; 
		if (word[i] != '1') {
			for (int j = i+1; j<word.length;j++) {
//				System.out.println("word[i] = " + word[i] + "   word[j] = " + word[j]);
				if (word[j] == word[i]) {
					a++;
					word[j] = '1';
				}
			}
		arr.add(a);
		}
	}
//	System.out.println(arr);
		
	BigInteger div = new BigInteger("1");
	for (int i = 0; i<arr.size();i++) div = div.multiply(factorial(arr.get(i)));
//	System.out.println("div = " + div);
	
	BigInteger res = factorial(s.length()).divide(div);
	
	System.out.println("res = " + res);
	
	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	o.print(res);
	o.flush();
	o.close();
}
}




