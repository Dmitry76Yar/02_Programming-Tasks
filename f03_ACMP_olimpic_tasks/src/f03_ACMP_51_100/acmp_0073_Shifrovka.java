package f03_ACMP_51_100;
/*	Расшифровка		(Время: 1 сек. Память: 16 Мб Сложность: 28%)
Рассмотрим работу простейшего шифра. Шифруемое сообщение состоит из английских букв, записанных в нижнем регистре и символа пробела.
Шифрование происходит посимвольно. Каждой букве ставим в соответствие число: a – 1, b – 2, … , z – 26, ‘ ‘ – 27. Далее индекс символа
складывается с номером в сообщении по модулю 27, а результат сложения представляется в системе счисления с основанием 27 (0, 1, …, Q в
верхнем регистре).
	Необходимо написать дешифратор.
	Входные данные
В единственной строке входного файла INPUT.TXT содержится закодированная строка, длиной от 1 до 255 символов. Строка записана в верхнем
регистре.
	Выходные данные
В единственную строку выходного файла OUTPUT.TXT нужно вывести расшифровку заданной строки, при этом символы английского алфавита следует
выводить в нижнем регистре.
	Примеры
№	INPUT.TXT		OUTPUT.TXT
1	L7MO			test
2	576J9FLF		decoding	 */

import java.io.*;
import java.util.Scanner;

public class acmp_0073_Shifrovka {
public static void main(String[] args) throws IOException {
	Scanner sc;
	sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	String str = sc.nextLine();
	StringBuffer sbf = new StringBuffer();
//	str = "2468ACEGIKMOQ13579BDFHJLNP02468ACEGIKMOQ13579BDFHJLNP02468ACEGIKMOQ13579BDFHJLNP02468ACEGIKMOQ13579BDFHJLNP02468ACEGIKMOQ13579BDFHJLNP02468ACEGIKMOQ13579BDFHJLNP02468ACEGIKMOQ13579BDFHJLNP02468ACEGIKMOQ13579BDFHJLNP02468ACEGIKMOQ13579BDFHJLNP02468ACEGIKM";
//	System.out.println(str);
	
	// Символы-цифры - от 48(0) до 57(9), Заглавные английские - от 65(A) до 90 (Z),   Q - 81
//	for (int i = 0; i<123; i++) {
//		System.out.println("i = " + i + ",  ch = " + (char)(i));}
	//0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F,G,H, I, J, K,L,M,N,O,P,Q

	// Прописные буквы - от 97 до 122 (z)
	System.out.println();
	int char_index = 0;
	char result_char;
	for (int i = 0; i<str.length(); i++) {
		char_index = 0;
		if ((str.charAt(i)>='0') & (str.charAt(i)<='9')) char_index = (int)str.charAt(i) - 48;
		if ((str.charAt(i)>='A') & (str.charAt(i)<='Q')) char_index = (int)str.charAt(i) - 65 + 10;
//		System.out.print("Буква = " + str.charAt(i) + " после перевода в число = " + char_index);
		
		if (((char_index  - i - 1)<=0) & ((char_index  - i - 1)>=-27)) char_index = char_index - i - 1 + 27;
		else if (((char_index  - i - 1)<-27) & ((char_index  - i - 1)>=-54)) char_index = char_index - i - 1 + 54;
		else if (((char_index  - i - 1)<-54) & ((char_index  - i - 1)>=-81)) char_index = char_index - i - 1 + 81;
		else if (((char_index  - i - 1)<-54) & ((char_index  - i - 1)>=-81)) char_index = char_index - i - 1 + 81;
		else if (((char_index  - i - 1)<-81) & ((char_index  - i - 1)>=-108)) char_index = char_index - i - 1 + 108;
		else if (((char_index  - i - 1)<-108) & ((char_index  - i - 1)>=-135)) char_index = char_index - i - 1 + 135;
		else if (((char_index  - i - 1)<-135) & ((char_index  - i - 1)>=-162)) char_index = char_index - i - 1 + 162;
		else if (((char_index  - i - 1)<-162) & ((char_index  - i - 1)>=-189)) char_index = char_index - i - 1 + 189;
		else if (((char_index  - i - 1)<-189) & ((char_index  - i - 1)>=-216)) char_index = char_index - i - 1 + 216;
		else if (((char_index  - i - 1)<-216) & ((char_index  - i - 1)>=-243)) char_index = char_index - i - 1 + 243;
		else if (((char_index  - i - 1)<-243) & ((char_index  - i - 1)>=-270)) char_index = char_index - i - 1 + 270;
		else if ((char_index  - i - 1)>0) char_index = char_index - i - 1;
		
//		System.out.print(", после вычитания номера позиции индекс = " + i + " стало " + char_index);
		if (char_index%27 == 0) result_char = ' ';
		else result_char = (char)(char_index + 96);
		
//		System.out.println(", что равно символу " + result_char);
		System.out.print(result_char);
		sbf.append(result_char);
}
	
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(sbf.toString());
	pw.close();
}
}
