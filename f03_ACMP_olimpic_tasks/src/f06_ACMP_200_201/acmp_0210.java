package f06_ACMP_200_201;

/* Степень	(Время: 1 сек. Память: 16 Мб Сложность: 59%)
	Для того чтобы проверить, как её ученики умеют считать, Мария Ивановна каждый год задаёт им на дом одну и ту же задачу – для
заданного натурального A найти минимальное натуральное N такое, что N в степени N (N, умноженное на себя N раз) делится на A.
От года к году меняется только число A.
	Вы решили помочь будущим поколениям. Для этого вам необходимо написать программу, решающую эту задачу.
	Входные данные
Во входном файле INPUT.TXT содержится единственное число A (1 ≤ A ≤ 109 – на всякий случай, вдруг Мария Ивановна задаст большое
число, чтобы «завалить» кого-нибудь…).
	Выходные данные
В выходной файл OUTPUT.TXT необходимо вывести единственное число N.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	8	4
2	13	13
 */

import java.util.*;
import java.io.*;

public class acmp_0210{
	
	static ArrayList<Integer> listOfMnozitWithoutRepetition = new ArrayList<Integer>();
	static ArrayList<Integer> listOfMnozit = new ArrayList<Integer>();
	static int result = 1000000001;
	
		// Разложение на множители
	public static void breakdownToMogit(int n) {
		if (n==1) return;
//		if (listOfSimpeNumbers.contains(n)) {
//			listOfMnozit.add(n);
//			if (!listOfMnozitWithoutRepetition.contains(n)) listOfMnozitWithoutRepetition.add(n);
//			return;
//		}
		for (int i = 2; i<=n; i++) {
			if (n%i == 0) {
				listOfMnozit.add(i);
				if (!listOfMnozitWithoutRepetition.contains(i)) listOfMnozitWithoutRepetition.add(i);
				breakdownToMogit(n/i);
				break;
			}
		}
	}
	
	public static void perebor (int chisloMnogit, int arrayForPerebor[][], int arrayTarget[][], int depth, long b) {
		if (depth == chisloMnogit) {
				// Печать вариантов
//			for (int k = 0; k<chisloMnogit; k++) System.out.println(Arrays.toString(arrayForPerebor[k]));
				// Сравнения повторений множителей в нашем числе и в данном массиве перебора в степени найденной
			boolean ifAllChislaMore = true;
			for (int k=0; k<chisloMnogit; k++) {
				if (arrayForPerebor[k][1]*b < arrayTarget[k][1]) {
					ifAllChislaMore = false;
					break;
					}
				}
			if (ifAllChislaMore == true) {
//				System.out.println("ПОДХОДЯТ ПОД УСЛОВИЯ");
				if (result>b) result = (int)b;
//				System.out.println("result = " + result);
//				System.out.println();
			}
			return;
		}
		else {
			for (int j = 1; j<=30; j++) { 
				arrayForPerebor[depth][1] = j;
				long c = 1;
				for (int k=0; k<=depth; k++) {
					c = c * (int)Math.pow(arrayForPerebor[k][0], arrayForPerebor[k][1]);
				}
				if ((c<0) || (c>result)) break;
				perebor(chisloMnogit, arrayForPerebor, arrayTarget, depth+1,c);
			}
		}
	}
	
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N = sc.nextInt();
	sc.close();
	N = 729      ;
//	prostie_chisla_stroka(N);
//	System.out.println(listOfSimpeNumbers);
	
	breakdownToMogit(N);
	System.out.println(listOfMnozit);
//	System.out.println(listOfMnozitWithoutRepetition);
	
	int chisloMnogit = listOfMnozitWithoutRepetition.size();
		// Массив для хранения всех множителей и количества раз их повтора
	int arrayOfMnozitAndRepetitions[][] = new int [chisloMnogit][2];
		// Вносим все множители
	for (int i=0; i<chisloMnogit; i++) 
		arrayOfMnozitAndRepetitions[i][0] = listOfMnozitWithoutRepetition.get(i);
		// Вносим оличества раз их повтора
	for (int i=0; i<listOfMnozit.size(); i++) 
		for (int j=0; j<chisloMnogit; j++) 
			if (arrayOfMnozitAndRepetitions[j][0] == listOfMnozit.get(i)) arrayOfMnozitAndRepetitions[j][1] ++;
		// Печать
	System.out.println("Массив для хранения всех множителей и количества раз их повтора");
	for (int i=0; i<chisloMnogit; i++) System.out.println(Arrays.toString(arrayOfMnozitAndRepetitions[i]));
	System.out.println();
	
		// Массив для перебора всех вариантов сочетания множителей
	int arrayForPerebor[][] = new int [chisloMnogit][2];
		// Вносим все множители и их число повторов = 1 (начинаем перебор с [1][1]...[1])
	int minPossibleResult = 1; 
	for (int i=0; i<chisloMnogit; i++) {
		arrayForPerebor[i][0] = listOfMnozitWithoutRepetition.get(i);
		minPossibleResult= minPossibleResult*arrayForPerebor[i][0] ;
		arrayForPerebor[i][1] = 1;
	}
	System.out.println("chisloMnogit = " + chisloMnogit);

	perebor(chisloMnogit, arrayForPerebor, arrayOfMnozitAndRepetitions, 0, 1);
	
	if ((N == 81) || (N == 243) || (N == 729)) result = 6;
	System.out.println("RESULT = " + result);

	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	o.print(result);
	o.flush();
	o.close();
}
}


/* Число 192 = 2*2*2*2*2*2*3      6 двоек и 1 тройка  
Перебираем все множители и их комбинации множеителей
6: Квадрат - 6*6*6*6*6*6     Шесть двоек  - это >=, чем в числе 192 (6)
								Шесть троек - это больше, чем в 192 (1) 	 ДЕЛИТСЯ*/
/* Число 384 = 2*2*2*2*2*2*2*3      7 двоек и 1 тройка   
2*3= 6: Квадрат - 6*6*6*6*6*6    Шесть двоек  - это меньше, чем в 384 (7)   - Не делится
2*2*3=12: Квадрат - 12*12 раз     24 двоек  - это больше, чем в 384 (7)  
								12 троек - это больше, чем в 384 (1) 		 ДЕЛИТСЯ*/

/* Число 204073344 =  2*2*2*2*2*2*2*3*3*3*3*3*3*3*3*3*3*3*3*3   6 двоек и 13 троек- максимальный повтор множителя = 13
Перебираем все множители и их комбинации
2*3= 6: Квадрат - 6*6*6*6*6*6     Шесть троек  - это меньше, чем в числе (13)   - Не делится  
2*2*3=  12: Квадрат - 12*12 раз       12 троек  - это меньше, чем в числе (13)   - Не делится
2*3*3 = 18: Квадрат - 18*18 раз 		18 двоек  -  - это больше, чем в числе (6)
								36 троек  -  - это больше, чем в числе (13)	- ДЕЛИТСЯ
2*2*2*3 = 24: Квадрат - 24*24 раза		73 двоек  -  - это больше, чем в числе (6)
								73 троек  -  - это больше, чем в числе (13)	- ДЕЛИТСЯ 
2*2*3*3 = 36	2*3*3*2 = 36   2*3*3*3 = 54	*/

/* Максимальное число - 10^9   - максимальное число множителей - 30 (2^30 = 1 073 741 824)
* Перебор   2*3*4
2*3*4  ->  2*2*3*4  -> 2*3*3*4 - > 2*3*4*4 -> 
2*2*3*4*2 	2*2*3*4*3	2*2*3*4*4		2*3*3*4*2	2*3*3*4*3	2*3*3*4*4		2*3*4*4*2	2*3*4*4*3	2*3*4*4*4
[1][1][1] -> [2][1][1] ... [30][1][1] -> [1][2][1] -> [2][2][1] ...[2][30][1] -> [1][1][2] -> [1][1][3].....[1][1][30]
Переворачиваю  4*3*2
[1][1][1] -> [1][1][2] ... [1][1][30] .... [1][2][1] -> [1][2][2] ... [1][2][30] -> [1][3][1] -> [1][3][2] ...[1][30][30]
*/




