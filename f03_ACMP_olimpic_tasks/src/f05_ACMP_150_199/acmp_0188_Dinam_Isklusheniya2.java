	package f05_ACMP_150_199;
/*День рождения	(Время: 1 сек. Память: 16 Мб Сложность: 65%)
Иван Иванович пригласил на свой день рождения много гостей. Он написал на карточках фамилии всех гостей и разложил эти карточки
на столе, полагая, что каждый гость сядет там, где обнаружит карточку со своей фамилией (фамилии у всех гостей различны). Однако
гости не обратили внимания на карточки и сели за стол в произвольном порядке. При этом Иван Иванович с удивлением обнаружил, что
ни один гость не сел на предназначенное ему место.
	Требуется написать программу, которая найдет сколькими способами можно рассадить гостей так, чтобы ни один из них не сидел
там, где лежала карточка с его фамилией.
	Входные данные
Во входном файле INPUT.TXT задано целое число N – количество гостей (1 ≤ N ≤ 100).
	Выходные данные
Выходной файл OUTPUT.TXT должен содержать одно целое число – количество способов рассадить гостей.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	1			0
2	2			1
3	5			44	
4	20			895014631192902121*/

import java.util.*;
import java.io.*;
import java.math.*;

// Решается через субфакториал    
// https://ru.wikipedia.org/wiki/%D0%91%D0%B5%D1%81%D0%BF%D0%BE%D1%80%D1%8F%D0%B4%D0%BE%D0%BA_(%D0%BF%D0%B5%D1%80%D0%B5%D1%81%D1%82%D0%B0%D0%BD%D0%BE%D0%B2%D0%BA%D0%B0)

public class acmp_0188_Dinam_Isklusheniya2{
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	N = 20;
	BigInteger a[] = new BigInteger[N+1];
	a[1] = BigInteger.ZERO;
	if (N>1) a[2] = BigInteger.ONE;
	
	for (int i=3; i<=N; i++) 
		a[i] = new BigInteger(Integer.toString(i-1)).multiply(a[i-1].add(a[i-2]));
	System.out.println(a[N]);
	
	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
    o.print(a[N]);
    o.close();
    }
}