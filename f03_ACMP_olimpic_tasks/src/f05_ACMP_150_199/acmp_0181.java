	package f05_ACMP_150_199;
/* Космический мусорщик		(Время: 1 сек. Память: 16 Мб Сложность: 42%)*/

import java.util.*;
import java.io.*;
	 
public class acmp_0181{
	static String[][] arr = new String[6][2];
	static int sum = 0;
	
	public static int toDefineArr (String curDir) {
		if (curDir.equals(arr[0][1])) return 0;
		else if (curDir.equals(arr[1][1])) return 1;
		else if (curDir.equals(arr[2][1])) return 2;
		else if (curDir.equals(arr[3][1])) return 3;
		else if (curDir.equals(arr[4][1])) return 4;
		else return 5;
	}
	
public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new FileReader("C:\\JavaTXT\\ACMP_0001\\input.txt"));
		// 0 - N	1 - S 	2- W	3 - E	4 - U	5 - D
	arr[0][0] = sc.nextLine();		arr[0][1] = "N";
	arr[1][0] = sc.nextLine();		arr[1][1] = "S";
	arr[2][0] = sc.nextLine();		arr[2][1] = "W";
	arr[3][0] = sc.nextLine();		arr[3][1] = "E";
	arr[4][0] = sc.nextLine();		arr[4][1] = "U";
	arr[5][0] = sc.nextLine();		arr[5][1] = "D";
	String komLov = sc.nextLine();
	int result = 0;
	
	String[] temp = new String[2];
	temp = komLov.split(" ");
	String prav = temp[0];
	int param = Integer.parseInt(temp[1]);
//	System.out.println("prav = " + prav + "   param = " + param);
	
	for (int i = 0; i<6; i++) 
		if (prav.equals(arr[i][1])) prav = arr[i][0]; 
	
	if (param == 1) result = 1;
	else if (param == 2) result = (1+prav.length());
	else {
		int resForPar3[][] = new int[param-2][6];
		for (int i = 0; i<6; i++) {
			int r = 0;
	//		System.out.println("arr[i][0]  = " + arr[i][0]);
			for (int j = 0; j<arr[i][0].length(); j++) {
				int a = toDefineArr(arr[i][0].substring(j,j+1));
				r+=arr[a][0].length()+1;
	//			System.out.println("a = " + a + "   r = " + r);
			}
			resForPar3[0][i] = r+1;
		}
	//	System.out.println(Arrays.toString(resForPar3[0]));
		
		for (int i = 1; i<=param-3; i++) {
			for (int k = 0; k<6; k++) {
				int r = 0;
	//			System.out.println("arr[k][0]  = " + arr[k][0]);
				for (int j = 0; j<arr[k][0].length(); j++) {
					int a = toDefineArr(arr[k][0].substring(j,j+1));
					r = r + resForPar3[i-1][a];
	//				System.out.println("a = " + a + "   r = " + r);
				}
				resForPar3[i][k] = r+1;
			}
		}
		result = resForPar3[param-3][toDefineArr(temp[0])];
	}		
	System.out.println("RESULT = " + result);
	
	PrintWriter o = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	o.print(result);
	o.flush();
	o.close();
	}
}