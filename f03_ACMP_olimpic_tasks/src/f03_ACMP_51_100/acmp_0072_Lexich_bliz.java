package f03_ACMP_51_100;
// Java-программа для реализации 
// метод next_permutation

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class acmp_0072_Lexich_bliz {
    // Функция для обмена данными присутствует в левом и правом индексах
    public static int[] swap(int data[], int left, int right)  {
        	// Поменять местами данные	
        int temp = data[left];
        data[left] = data[right];
        data[right] = temp;
        	// Возвращаем обновленный массив
        return data;     }
    
    	// Функция для обратного подмассива начиная слева направо оба включительно
    public static int[] reverse(int data[], int left, int right) {
    		// Обратный обратный массив	
        while (left < right) {
            int temp = data[left];
            data[left++] = data[right];
            data[right--] = temp; 
        }
        	// Возвращаем обновленный массив
        return data;     }

    // Функция для поиска следующей перестановки данного целочисленного массива
    public static boolean findNextPermutation(int data[])   {
        	// Если данный набор данных пуст или содержит только один элемент следующая_пермутация невозможна
        if (data.length <= 1) return false;
        int last = data.length - 2;
        	// найти самый длинный не увеличивающийся суффикс и найти пивот
        while (last >= 0) {
            if (data[last] < data[last + 1]) break; 
            last--;
        }
        	// Если нет увеличивающейся пары	нет перестановки высшего порядка
        if (last < 0) return false;
        int nextGreater = data.length - 1;
        	// Найти крайний правый преемник поворота
        for (int i = data.length - 1; i > last; i--) {
            if (data[i] > data[last]) {
                nextGreater = i;
                break;
            }
        }
        	// Меняем местами преемника и стержень
        data = swap(data, nextGreater, last);
        	// Обратный суффикс
        data = reverse(data, last + 1, data.length - 1);
        	// Возвращаем истину, как только следующая_перестановка завершена
        return true;
    }

    public static void main(String args[]) throws IOException    {
    	Scanner sc;
    	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
    	String str = sc.nextLine();
    	char char_input[] = str.toCharArray();
    	System.out.println(Arrays.toString(char_input));
    	int data[] = new int[char_input.length];
    	for (int i = 0; i<char_input.length; i++)  data[i] = (int)char_input[i];
    	System.out.println(Arrays.toString(data));
    	char char_output[] = new char[char_input.length];
    	
        if (!findNextPermutation(data))
            System.out.println("There is no higher order permutation for the given data.");
        else {
        	System.out.println(Arrays.toString(data));
        	for (int i = 0; i<char_output.length; i++)  char_output[i] = (char)data[i];
        	System.out.println(Arrays.toString(char_output));
        }
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i<char_output.length; i++)  sbf.append(char_output[i]);
        String result = sbf.toString();
        System.out.println("result = " + result);
        PrintWriter pw;
    	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
    	pw.print(result);
    	pw.close();
    }
}