	package f05_ACMP_150_199;
/* Римские числа	(Время: 1 сек. Память: 16 Мб Сложность: 50%)
Необходимо сократить дробь, записанную в римской системе счисления. Напомним, что в римской записи используются символы
M, D, C, L, X, V и I. Приведем таблицу с примерами перевода римских чисел в арабскую систему:

I - 1	VII - 7	XLVI - 46	CCCII - 302
II - 2	VIII - 8	L - 50	CDXLI - 441
III - 3	IX - 9	LXXV - 75	ID - 499
IV - 4	X - 10	XCII - 92	D - 500
V - 5	XVIII - 18	IC - 99	DCXCV - 695
VI - 6	XXXI - 31	C - 100	CM - 900
	Входные данные
Во входном файле INPUT.TXT записана дробь в римской системе счисления. Формат записи считается корректным, если запись
представляет собой: римское число, деление, римское число (без пробелов), и каждое из чисел находится в диапазоне от 1 до 999.
Строка заданной дроби состоит не более, чем из 100 символов.
	Выходные данные
В выходной файл OUTPUT.TXT выведите сокращенную дробь в римской системе счисления. В тех случаях, когда первое число делится
на второе, следует выводить результат в виде только одного римского числа. В том случае, когда во входных данных содержится
ошибка, следует вывести ERROR.
	Примеры
№	INPUT.TXT	OUTPUT.TXT
1	II/IV		I/II
2	XXIV/VIII	III
3	12/16		ERROR */


import java.util.*;
import java.io.*;
	 
public class acmp_0199_rimskie_number{
	
	static int rimsk (char a) {
		if (a == 'I') return 1;
		else if (a == 'V') return 5;
		else if (a == 'X') return 10;
		else if (a == 'L') return 50;
		else if (a == 'C') return 100;
		else if (a == 'D') return 500;
		else if (a == 'M') return 1000;
		else return -1;
	}
		
	static int trans (String a) {
		int sum = 0;
		int i = 0;
		while (i<a.length()-1) {
			int curFig = rimsk(a.charAt(i));
			int nextFig = rimsk(a.charAt(i+1));
			if ((curFig == -1) || (nextFig == -1)) {
				sum = -1;
				break;
			}
			if (curFig >= nextFig) {
				sum = sum + curFig;
				i++;
			}
			else {
				sum = sum + (nextFig - curFig);
				i = i+2;
			}
		}
		if (i == a.length()-1) sum = sum + rimsk(a.charAt(a.length()-1));
		return sum;		
	}
	
	static String reverseTrans (int a) {
		String res = "";
		if (a/500 >=1) {
			if (a>=900) {
				res = res + "CM";
				a = a-900;
			}
			else {
				res = res + "D";
				a = a-500;
			}
		}
		if (a/100 >=1) {
			if (a>=400) {
				res = res + "CD";
				a = a - 400;				
			}
			else {
				while (a>=100) {
					res = res + "C";
					a = a - 100;
				}			
			}
		}
		if (a/50 >=1) {
			if (a>=90) {
				res = res + "XC";
				a = a - 90;				
			}
			else {
				res = res + "L";
				a = a - 50;				
				}
		}
		if (a/10 >=1) {
			if (a>=40) {
				res = res + "XL";
				a = a - 40;				
			}
			else {
				while (a>=10) {
					res = res + "X";
					a = a - 10;	
				}	
			}
		}
		if (a/5 >=1) {
			if (a>=9) {
				res = res + "IX";
				a = a - 9;				
			}
			else {
				res = res + "V";
					a = a - 5;				
			}
		}
		if (a>=1) {
			if (a>=4) {
				res = res + "IV";
				a = a - 4;				
		}
			else {
				while (a>=1) {
					res = res + "I";
					a = a - 1;	
				}	
			}
		}
		return res;		
	}
	
	static String reduc(int r, int l) {
		int maxObshDel = 1;
		for (int i = 2; i<=999; i++) 
			if ((r%i == 0) && (l%i == 0)) maxObshDel = i;
		r = r/maxObshDel;
		l = l/maxObshDel;
		return reverseTrans(r) + "/" + reverseTrans(l);
	}
	
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
	String input = sc.nextLine();
	String result = "";
	String ar[] = input.split("/");
	String right = "";
	String left = "";
	
	if (ar.length!=2) result = "ERROR";
	else {
		right = ar[0];
		left = ar[1];
		System.out.println("right = " + right + "   left = " + left);
		int r = trans(right);
		int l = trans(left);
		System.out.println("r = " + r + "   l = " + l);
		if ((r== -1) || (l == -1) || (r>999) || (l>999)) {
			result = "ERROR";
			System.out.println("ERROR");
		}
		else {
			if (r%l == 0) result = reverseTrans(r/l);
			else {
				result = reduc(r, l);
				System.out.println(reduc(r, l));
			}
		}
	}
	System.out.println("RESULT =  " + result);
	
    PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
    o.print(result);
    o.flush();
    o.close();
    }
}