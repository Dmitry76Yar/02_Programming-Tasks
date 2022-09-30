package f04_ACMP_101_200;
/* Один конь	(Время: 1 сек. Память: 16 Мб Сложность: 41%)
На шахматной доске N×N в клетке (x1,y1) стоит голодный шахматный конь. Он хочет попасть в клетку (x2,y2), где растет вкусная шахматная
трава. Какое наименьшее количество ходов он должен для этого сделать?
	Входные данные
Входной файл INPUT.TXT содержит пять чисел: N, x1, y1, x2, y2 (5 ≤ N ≤ 20, 1 ≤ x1, y1, x2, y2 ≤ N). Левая верхняя клетка доски имеет
координаты (1,1), правая нижняя - (N,N).
	Выходные данные
В выходной файл OUTPUT.TXT необходимо вывести наименьшее число ходов коня.
	Пример
№	INPUT.TXT	OUTPUT.TXT
1	5
	1 1
	3 1				2						*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
 
public class acmp_0129 {
public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(new FileReader("input.txt"));
    int N = sc.nextInt();
    int M = sc.nextInt();
    System.out.println(" N = " + N + "  M = " + M);
     
    ArrayList<int[]> queue = new ArrayList<int[]>();
    ArrayList<int[]> spisok_of_ones = new ArrayList<int[]>();
    int Table[][] = new int[N][M];
    for (int i = 0; i<N; i++) {
        for (int j = 0; j<M; j++) {
            int a = sc.nextInt();
            Table[i][j] = a;
            int c[] = {i,j};
            if (a==1) {
                queue.add(c);
                Table[i][j] = -1;
            }
//          if (a==0)   Table[i][j] = -1;
        }
    }
    spisok_of_ones.addAll(queue);
    //for (int i =0; i<N; i++) System.out.println("TABLE = " + Arrays.toString(Table[i]));
     
    ArrayList<int[]> queueThisStep = new ArrayList<int[]>();
    int step = 0;
     
    while (queue.isEmpty() == false) {
        step++;
        while (queue.isEmpty() == false) {
            int d[] = queue.remove(0);
            int x1 = d[0];
            int y1 = d[1];
            //System.out.println("x1 = " + x1 + "   y1 = " + y1);
             
            if (((x1+1) < N) && (Table[x1+1][y1] == 0)) {
                Table[x1+1][y1] = step;
                    queueThisStep.add(new int[] {x1+1, y1}); 
                    }
             
            if (((x1-1) >=0) && (Table[x1-1][y1] == 0)) {
            Table[x1-1][y1] = step;
                queueThisStep.add(new int[] {x1-1, y1}); 
                }
             
            if (((y1+1) < M) && (Table[x1][y1+1] == 0))  {
            Table[x1][y1+1] = step;
                queueThisStep.add(new int[] {x1, y1+1});
                }
             
            if (((y1-1) >=0) && (Table[x1][y1-1] == 0)) {
            Table[x1][y1-1] = step; 
                queueThisStep.add(new int[] {x1, y1-1});
                }
        }   // end of second WHILE
        //for (int i=0; i<N; i++) System.out.println(Arrays.toString(Table[i]));
        queue.addAll(queueThisStep);
        queueThisStep.clear();
         
    }   // end of first WHILE
     
    for (int i =0; i<spisok_of_ones.size(); i++) {
        int c[] = spisok_of_ones.get(i);
        Table[c[0]][c[1]] = 0;
    }
     
    //System.out.println();
    //for (int i=0; i<N; i++) System.out.println(Arrays.toString(Table[i]));
     
    PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
    for (int h = 0; h<N; h++) {
        for (int g = 0; g<M; g++) {
            out.print(Table[h][g] + " ");
        }
        out.println();
    }
    out.flush();
    out.close();
    }
}