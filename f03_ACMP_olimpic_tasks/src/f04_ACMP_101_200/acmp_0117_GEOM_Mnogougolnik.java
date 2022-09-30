package f04_ACMP_101_200;
/* Опасная зона	(Время: 1 сек. Память: 16 Мб Сложность: 57%)
Группа экспертов обнаружила на территории нежилого массива множество опасных участков, соприкосновение с которыми небезопасно для
жизни человека.
	В целях безопасности требуется создать защитный периметр в форме выпуклого многоугольника, который бы смог обезопасить проникновение
человека в эту зону.
	По заданным координатам опасных участков требуется вычислить минимально возможную площадь опасной зоны, которая попадет в защитный
периметр.
	Входные данные
В первой строке входного файла INPUT.TXT записано натуральное число N – количество опасных участков. В каждой из N последующих строк
находятся два числа Xi и Yi - координаты участков, размерами которых можно пренебречь. При этом участки могут повторяться.
	Все числа целые, не превосходящие 1000 по абсолютной величине.
	Выходные данные
В выходной файл OUTPUT.TXT необходимо вывести одно число — площадь опасной зоны, округленной до целого значения.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1	10
	4 6
	2 5
	6 4
	7 7
	4 4
	1 5
	3 8
	3 2
	5 7
	7 3			26
*/
import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;

public class acmp_0117_GEOM_Mnogougolnik {
public static void main(String[] args) throws IOException {
	BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\JavaTXT\\ACMP_0001\\input.txt"), Charset.forName("UTF-8")));
	String N_str = reader.readLine();
	int N = Integer.parseInt(N_str);
		
		int Array1[][] = new int[N][2];
			
		int k;
		char c;
		int a;
		int i = 0;
		int j = 0;
		StringBuilder numberString = new StringBuilder();
		while(true) {
			k = reader.read();
			if (k != 13 &&  k != 32 && k!=-1) {
				c = (char)k;
				numberString.append(Character.toString(c));
			}
			else  {
				if ((numberString.length() !=0)&&(k!= 45)) {		 
					a = Integer.parseInt(numberString.toString());
					Array1[i][j++] = a;
					if (j == 2) {
					reader.readLine();
					i++; 
					j = 0;
					}
					numberString.delete(0, numberString.length());
				}
			}
			if (i == N) break;
		}
		reader.close();
		
			// Перенос из  исходного массива в другой массив Array2 только неповторяющихся точек
		int Array2[][] = new int[N][2];
		int count2 = 0;
		int count3 = 0;
		for (i= 0; i <N; i++) {
			boolean check2 = true;
			for (j= 0; j <i; j++) {
				if ((j!=i) && (Array1[i][0] == Array1[j][0]) && (Array1[i][1] == Array1[j][1]))  {
					check2 = false;
					break;
				}
			}
				if (check2 == true) {
					count2++;
					Array2[count3][0] = Array1[i][0];
					Array2[count3][1] = Array1[i][1];
					count3++;
			}
		}
		
			// Перенос из массива Array2 длиной N и некоторыми пустыми ячейками в финальный массив Array3 нужной длины count2
			// И поиск точки с минимальной ординатой (у), которая будет первой вершиной многоугольника
		int y_min =  1001;	
		int y_min_i = 0;
		int Array[][] = new int[count2][2];
		for (i= 0; i <count2; i++) {
			Array[i][0] = Array2[i][0];
			Array[i][1] = Array2[i][1];
			if (y_min > Array[i][1]) {
				y_min = Array[i][1];
				y_min_i = i;
			}
		}
		
		int result = 0; 
			// Если длина массива без повторяющихся точек меньше трех, то это прямая или точка, т.е. площадь равна нулю
		if (Array.length < 3) 	result = 0;
		else {
			ArrayList<Integer> arl_result= new ArrayList<Integer>();		// Лист для сохранения вершин многоугольника
			arl_result.add(y_min_i);
					// Алгоритм Джарвиса		https://ru.wikipedia.org/wiki/%D0%90%D0%BB%D0%B3%D0%BE%D1%80%D0%B8%D1%82%D0%BC_%D0%94%D0%B6%D0%B0%D1%80%D0%B2%D0%B8%D1%81%D0%B0
			int indexA = -1;
			int indexB = arl_result.get(0);
			while (true) {
				double cosMin = 1;
				int indexNextPoint = 0;
				if (indexA == -1) {
					for (i = 0; i<Array.length; i++) {
						if ((i!= indexA)) {
							int indexC = i;
								// Длина отрезка от точки с наименьшим y (ординатой) и точкой справа любой по той же оси
							int PointA_X = Array[indexB][0] + 10;
							int PointA_Y = Array[indexB][1];
							double SquareOfDistanceAB = Math.pow((Array[indexB][0] - PointA_X), 2.0) + Math.pow((Array[indexB][1] - PointA_Y), 2.0);
								// Длина второй стороны
							double SquareOfDistanceBC = Math.pow((Array[indexB][0] - Array[indexC][0]), 2.0) + Math.pow((Array[indexB][1] - Array[indexC][1]), 2.0);
								// Длина основания треугольника
							double SquareOfDistanceAC = Math.pow((PointA_X - Array[indexC][0]), 2.0) + Math.pow((PointA_Y - Array[indexC][1]), 2.0);
								// Косинус угла между 1-ой и 2-ой сторонами треугольника
							double cos = (SquareOfDistanceAB + SquareOfDistanceBC - SquareOfDistanceAC) / (2*Math.sqrt(SquareOfDistanceAB)*Math.sqrt(SquareOfDistanceBC));
							if (cos < cosMin) {		// ищем наилучший (минимальный косинус, косинус с отрицательным числом для тупого угла)
								cosMin = cos;
								indexNextPoint = i;
							}
							System.out.println("indexA = " + indexA + "   indexB = " + indexB + "   indexC = " + indexC + "  cos = " + cos + " , AB = " + SquareOfDistanceAB + "   , BC = " + SquareOfDistanceBC + "  , AC = " + SquareOfDistanceAC);
						}
					}
				}
				else {
					for (i = 0; i<Array.length; i++) {
						if ((i!= indexA) && (i!= indexB)) {
							int indexC = i;
								// Длина уже найденной грани многоугольника  (одна сторона треугольника)
							double SquareOfDistanceAB = Math.pow((Array[indexA][0] - Array[indexB][0]), 2.0) + Math.pow((Array[indexA][1] - Array[indexB][1]), 2.0);
								// Длина второй стороны
							double SquareOfDistanceBC = Math.pow((Array[indexB][0] - Array[indexC][0]), 2.0) + Math.pow((Array[indexB][1] - Array[indexC][1]), 2.0);
								// Длина основания треугольника
							double SquareOfDistanceAC = Math.pow((Array[indexA][0] - Array[indexC][0]), 2.0) + Math.pow((Array[indexA][1] - Array[indexC][1]), 2.0);
								// Косинус угла между 1-ой и 2-ой сторонами треугольника
							double cos = (SquareOfDistanceAB + SquareOfDistanceBC - SquareOfDistanceAC) / (2*Math.sqrt(SquareOfDistanceAB)*Math.sqrt(SquareOfDistanceBC));
							if (cos < cosMin) {		// ищем наилучший (минимальный косинус, косинус с отрицательным числом для тупого угла)
								cosMin = cos;
								indexNextPoint = i;
							}
							System.out.println("indexA = " + indexA + "   indexB = " + indexB + "   indexC = " + indexC + "  cos = " + cos + " , AB = " + SquareOfDistanceAB + "   , BC = " + SquareOfDistanceBC + "  , AC = " + SquareOfDistanceAC);
						}
					}
				}
				System.out.println("Следующая точка имеет индекс в массиве  " + indexNextPoint );
				indexA = indexB;
				indexB = indexNextPoint;
				if (indexNextPoint == arl_result.get(0)) break;
				arl_result.add(indexNextPoint);
				System.out.println(arl_result);
				System.out.println();
			}
			
			// находим площадь многоугольника      https://ru.wikipedia.org/wiki/%D0%A4%D0%BE%D1%80%D0%BC%D1%83%D0%BB%D0%B0_%D0%BF%D0%BB%D0%BE%D1%89%D0%B0%D0%B4%D0%B8_%D0%93%D0%B0%D1%83%D1%81%D1%81%D0%B0
	        int area2 = 0;
	        arl_result.add(arl_result.get(0));
	        for (int i3 = 0; i3<arl_result.size()-1; i3++) {
	        	int index1 = arl_result.get(i3);
	        	int index2 = arl_result.get(i3+1);
	        	System.out.println("index1 = " + index1 + "   index2= " + index2);
	        	area2 = area2 + Array[index1][0]*Array[index2][1] -  Array[index2][0]* Array[index1][1];
	        }
	        System.out.println("area2 = " + area2);
	        double r1 = (double)(Math.abs(area2)/2.0);
	        System.out.println(r1);
	        result = (int)Math.round(r1);
			
		}
	System.out.println("result = " + result);
	
	PrintWriter out = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	out.println(result);
    out.flush();
    out.close();
	}
}
