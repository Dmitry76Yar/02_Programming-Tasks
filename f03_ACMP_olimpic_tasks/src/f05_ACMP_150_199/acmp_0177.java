	package f05_ACMP_150_199;

/* Наручные часы		(Время: 1 сек. Память: 16 Мб Сложность: 37%)
Вы приобрели новые электронные наручные часы с жидкокристаллическим дисплеем. Дисплей отображает часы и минуты с помощью четырех
элементов, каждый из которых отображает одну цифру.	 
	Три из них состоят из семи полосок, каждая из которых может быть либо белой (неотличимой от фона), либо черной. Вид такого 
элемента и отображаемые им цифры показаны на рисунке:
	Четвертый элемент предназначен для отображения старшей цифры часа. Если она равна нулю, то элемент полностью неактивен
(все полоски белые), иначе показывается соответствующая цифра. Вот как выглядит этот элемент с цифрами:
	Вам хочется проверить: все ли в порядке с новым приобретением, а именно, нет ли таких полосок в каком-либо из элементов, которые
либо всегда белые, либо всегда черные. Вы хотите начать проверку в некоторое начальное время. Требуется определить, сколько Вам 
потребуется минут для убеждения в исправности часов.
	Входные данные
В первой строке входного файла INPUT.TXT находится время начала проверки в формате HH:MM. Часы и минуты записаны с лидирующими нулями,
если таковые имеются. (00 ≤ HH ≤ 23, 00 ≤ MM ≤ 59).
	Выходные данные
В выходной файл OUTPUT.TXT выведите минимальное число минут, необходимое для проверки Ваших часов, если она началась в заданное время.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	00:00	1200
2	02:39	1041

*/

import java.util.*;
import java.io.*;

public class acmp_0177{
	
	
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	int N_otsek = sc.nextInt();
	int M_cargo = sc.nextInt();
	
	int otsekiVol[][] = new int [N_otsek][103];
	for (int i = 0; i<N_otsek; i++)  otsekiVol[i][2] =sc.nextInt();
	// otsekiVol[i][0] - сумма весов грузов в этой ячейке 
	// otsekiVol[i][1] - количество грузов в ячейке 
	// otsekiVol[i][2] - вместимость ячейки 
	
	int cargos[][] = new int [M_cargo][3];
	for (int i = 0; i<M_cargo; i++) {
		for (int j = 0; j<3; j++) {
		cargos[i][j] =sc.nextInt();
		}
	}
//	System.out.println("N_otsek = " + N_otsek + "   M_cargo = " + M_cargo);
	System.out.println("otsekiVol   ");
	for (int i = 0; i<N_otsek; i++) System.out.println(Arrays.toString(otsekiVol[i]));
	System.out.println("cargos: ");
	for (int i = 0; i<M_cargo; i++) System.out.println(Arrays.toString(cargos[i]));
	System.out.println();
//	
	ArrayList<Integer> queueCargoExit = new ArrayList<Integer>();
	for (int i = 0; i<M_cargo; i++) {
		int min_index_cell = 100;
		int min_rest_space = 2000000001;
		int currentCargo = cargos[i][0];
		for (int j = 0; j<N_otsek; j++) {
			int currentCell = otsekiVol[j][2] - otsekiVol[j][0];		// Вычисляем доступную емкость в ячейке 
			int currentRestSpace = currentCell - currentCargo;
//			System.out.println("j = " + j + "   currentRestSpace = " + currentRestSpace);
			if (currentRestSpace>=0 && (currentRestSpace<min_rest_space)) {
				min_rest_space = currentRestSpace;
				min_index_cell = j;
//				System.out.println("j = " + j + " min_rest_space = " + min_rest_space);
			}
		}
		if (min_rest_space == 2000000001) {
			System.out.println("Нет ячеек с необходимым объемом");
			ArrayList<Integer[]> options = new ArrayList<Integer[]>();
			// [0] - индекс ячейки для изъятия груза		[1] - индекс груза для перемещения
			// [2]- масса груза для перемещения				[3] - емкость ячейки после изятия этого груза
			
			for (int l = 0; l<N_otsek; l++) { 			// Перебираем все ячейки 
				for (int m = 3; m<(3+otsekiVol[l][1]); m++) {		// Перебираем все грузы в этой ячейке
					// otsekiVol[i][0] - сумма весов грузов в этой ячейке 
					// otsekiVol[i][1] - количество грузов в ячейке 
					// otsekiVol[i][2] - вместимость ячейки
					int restSpace = otsekiVol[l][2] - otsekiVol[l][0] + otsekiVol[l][m];
					if (restSpace >=currentCargo) {
//						System.out.println("Найдена ячейка " + l + "  из которой можно изъять груз с массой " + otsekiVol[l][m] + 
//								" и вместимость ячейки станет равной" + restSpace);
						options.add(new Integer[] {l, m-2, otsekiVol[l][m], restSpace});
					}
			}
		}
			System.out.println("Итоговый список найденных вариантов груза для перемещения и ячеек, из которых делать перемещение:");
			for (int l = 0; l<options.size(); l++) System.out.println(Arrays.toString(options.get(l)));

			if (options.size() != 0) { 
					// Оставляем в списке только варианты, где перемещаемый груз минимален 
				int minC = options.get(0)[2];
				ArrayList<Integer> temp = new ArrayList<Integer>();
				for (int l = 0; l<options.size(); l++) {
					if (options.get(l)[2] == minC) temp.add(l); 
					else if (options.get(l)[2] < minC) {
						temp.clear();
						minC = options.get(l)[2];
						temp.add(l); }
				}
//				System.out.println("temp " + temp);
				System.out.println("Итоговый список с грузами равного минимального размера :");
				ArrayList<Integer[]> foundOptions = new ArrayList<Integer[]>();
				for (int l = 0; l<temp.size(); l++) foundOptions.add(options.get(temp.get(l)));
				for (int l = 0; l<foundOptions.size(); l++) System.out.println(Arrays.toString(foundOptions.get(l)));
			
			if (foundOptions.size() > 1) { 
					// Оставляем в списке только варианты, где при котором в отсеке, из которого 
					//перемещается груз, свободное место после перемещения этого груза будет минимально
				minC = foundOptions.get(0)[3];
				temp.clear();
				options.clear();
				for (int l = 0; l<foundOptions.size(); l++) {
					if (foundOptions.get(l)[3] == minC) temp.add(l); 
					else if (foundOptions.get(l)[3] < minC) {
						temp.clear();
						minC = foundOptions.get(l)[3];
						temp.add(l); }
				}
//				System.out.println("temp " + temp);
				System.out.println("Итоговый список с ячейками  с минимальным размером после изъятия груза :");
				for (int l = 0; l<temp.size(); l++) options.add(foundOptions.get(temp.get(l)));
				for (int l = 0; l<options.size(); l++) System.out.println(Arrays.toString(options.get(l)));
			}
			else {
				options.clear();
				options.addAll(foundOptions);
				}
			}
			else if (options.size() == 0) System.out.println("cargo " + i + " cannot be stored");
			
			if (options.size() != 0) {
					// Находим варианты ячеек, куда можно переместить груз данного веса, чтобы 
					// свободное место ячейки, в которую идет перемещение, будет также минимально.
				ArrayList<Integer> tr = new ArrayList<Integer>();
				int movedCargo = options.get(0)[2];
				System.out.println("movedCargo = " + movedCargo);
				int minG = 2000000001;
				for (int k = 0; k<N_otsek; k++) {
					int o = otsekiVol[k][2] - otsekiVol[k][0] - movedCargo;
					System.out.println("o = " + o);
					if ((o>=0) && (o<minG)) minG = 0; 
				}
				System.out.println("minG = " + minG);
				
				ArrayList<Integer[]> optionsFromToMove = new ArrayList<Integer[]>();
				// [0] - индекс ячейки для изъятия груза			[1] - индекс груза для перемещения
				// [2]- масса груза для перемещения					[3] - емкость ячейки после изятия этого груза
				// [4] - индекс ячейки куда перемещаем 				[5] - емкость ячейки после перемещения в нее груза
				
				for (int l = 0; l<options.size(); l++) {
					for (int k = 0; k<N_otsek; k++) {
						if ((options.get(l)[0] !=k) && ((otsekiVol[k][2] - otsekiVol[k][0] - movedCargo) == minG))
							optionsFromToMove.add(new Integer[] {options.get(l)[0], options.get(l)[1], 
									options.get(l)[2], options.get(l)[3], k, (otsekiVol[k][2] - otsekiVol[k][0] - movedCargo)});
					}
				}
				System.out.println("Варианты ячеек, в которые можно переместить груз массой ");
				for (int l = 0; l<optionsFromToMove.size(); l++) System.out.println(Arrays.toString(optionsFromToMove.get(l)));
				
					//  Если и после этого остается более одного варианта, то выбирается тот вариант, при котором номер 
					// перемещаемого груза минимален и номер отсека, в который он перемещается, – также минимален.
				int minF = 200;
				int minD = 200;
				for (int l = 0; l<optionsFromToMove.size(); l++) {
					if (optionsFromToMove.get(l)[0] <minF) minF = optionsFromToMove.get(l)[0];
					if (optionsFromToMove.get(l)[4] <minD) minD = optionsFromToMove.get(l)[4];
				}
				System.out.println("minF = " + minF);
				System.out.println("minD = " + minD);
				
				for (int l = 0; l<optionsFromToMove.size(); l++) {
					if ((optionsFromToMove.get(l)[0] != minF) || (optionsFromToMove.get(l)[4] != minD)) {
						optionsFromToMove.remove(l);
						l--; }
				}
				for (int l = 0; l<optionsFromToMove.size(); l++) System.out.println(Arrays.toString(optionsFromToMove.get(l)));
				
				// [0] - индекс ячейки для изъятия груза			[1] - индекс груза для перемещения
				// [2]- масса груза для перемещения					[3] - емкость ячейки после изятия этого груза
				// [4] - индекс ячейки куда перемещаем 				[5] - емкость ячейки после перемещения в нее груза
				int fromCell = optionsFromToMove.get(0)[0];
				int toCell = optionsFromToMove.get(0)[4];
				int cargoWeight = optionsFromToMove.get(0)[2];
				int cargoIndex = optionsFromToMove.get(0)[1];
				System.out.println("fromCell = " + fromCell + "  toCell=  " + toCell +  "   cargoWeight = " + cargoWeight 
						+ "   cargoIndex =  " + cargoIndex );
				otsekiVol[toCell][0] = otsekiVol[toCell][0] +  cargoWeight;   			// масса груза для перемещения
				otsekiVol[toCell][1]++;										  			// количество грузов
				otsekiVol[toCell][2+otsekiVol[toCell][1]] = cargoWeight;				 //добавление груза
				otsekiVol[fromCell][0] = otsekiVol[fromCell][0] - cargoWeight;
				otsekiVol[fromCell][2+cargoIndex] = otsekiVol[fromCell][2+cargoIndex] - cargoWeight;
				otsekiVol[fromCell][1]--;
				
				
			}	
		}
			// Оставляем в списке только варианты,, при котором в отсеке, куда осуществляется перемещение, свободное место 
						// после этого перемещения будет также минимально.
		else {
			otsekiVol[min_index_cell][1]++;											     // Увеличиваем кол-во грузов на 1 в ячейке
			otsekiVol[min_index_cell][2+otsekiVol[min_index_cell][1]] = cargos[i][0];    // Заносим груз в ячейку
			otsekiVol[min_index_cell][0] = otsekiVol[min_index_cell][0] + cargos[i][0];  // Увеличиваем общую массу в ячейке
		}
		System.out.println("put cargo " + i+ " to cell " + min_index_cell);
		System.out.println("i = " + i + "   otsekiVol   ");
		for (int k = 0; k<N_otsek; k++) System.out.println(Arrays.toString(otsekiVol[k]));
		System.out.println();
	}
	
//	System.out.println("result = " + result);
	
	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
//	o.println(result);
	o.flush();
	o.close();
}
}