package f04_ACMP_101_200;
/*		Игра «Пуговицы»		(Время: 0,25 сек. Память: 16 Мб Сложность: 48%)
Правила игры очень просты. Перед двумя играющими находится кучка из K пуговиц. Играющие по очереди берут пуговицы из кучки, причем
за один ход каждый из них может взять от 1 до L пуговиц. Выигрывает тот из спортсменов, которому удастся взять последнюю пуговицу.
	Тот из игроков, которому по жребию выпадает делать первый ход, получает возможность собственноручно назначить число K. Тот из
игроков, который будет ходить вторым, выбирает, в свою очередь, число L.
	Вам необходимо определить наилучшую стратегию для участника, который ходит вторым.
	Входные данные
Во входном файле INPUT.TXT записано одно натуральное число K (1 ≤ K ≤ 108) – общее количество пуговиц.
	Выходные данные
В выходной файл OUTPUT.TXT необходимо вывести целое число L (2 ≤ L < K) — максимальное количество пуговиц, которое можно взять
за один ход, обеспечивающее победу второму игроку. Если таких чисел несколько, то следует вывести наименьшее из них. Если таких
чисел нет, то следует вывести число 0.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1		3			2
2		26			12
3		31			30

 */

import java.io.*;

// Условие выигрыша: K%(L+1) == 0

import java.nio.charset.Charset;

public class acmp_0111 {
public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\JavaTXT\\ACMP_0001\\input.txt"), Charset.forName("UTF-8")));
		int K = Integer.parseInt(reader.readLine());
		reader.close();
		int result = 0;
		int delitel1 = 0;
		int delitel2 = 0;
		
				// Проверка является ли число простым
				boolean isSimpleFigure = true;
				boolean isSimpleFigure1 = true;
				if (K!= 2) {
					for (int i = 2; i*i<=K; i++) {
						if ((K%(i)) == 0) {
							delitel1 = i;
							isSimpleFigure = false;
							break;
						}
					}
					if (isSimpleFigure == true)  result = K-1;						// Число простое
					else if ((isSimpleFigure == false) && (delitel1 == 2 )) {		// Если делитель1 = 2, то нужно искать делитель2 для К/2
						int temp = K/2;
						for (int i = 2; i*i<=temp; i++) {
							if ((temp%(i)) == 0) {
								delitel2 = i;
								isSimpleFigure1 = false;
								break;
							}
						}
						if (isSimpleFigure1 == true) {
							if (temp == 2) result = 3;
							else result = temp - 1;
						}
						else {
							if (delitel2 == 2) { 
								if (K%3 == 0) result = 2;
								else result = 3;
							}
							else result = delitel2-1;
						}
					}
					else result = delitel1-1;											// Есть отличный от 2 делитель
				}
				else result = 0;
//			System.out.println(isSimpleFigure);
//			System.out.println("For K = " + K + "   delitel1 = " + delitel1 + " , delitel2 = " + delitel2 + "  , result = " + result);
			
		
	    BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
		writer.write(Integer.toString(result));
		writer.close();
	}
	}