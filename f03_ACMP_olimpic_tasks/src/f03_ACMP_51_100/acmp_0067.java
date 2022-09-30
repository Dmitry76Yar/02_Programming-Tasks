package f03_ACMP_51_100;
/*	Маска подсетей		(Время: 0,4 сек. Память: 16 Мб Сложность: 33%)
Рассмотрим компьютерную сеть с настроенной TCP/IP маршрутизацией. Будем рассматривать некоторую ее модификацию. А именно в этой сети
находить N подсетей. Каждая подсеть характеризуется своей маской. Маска подсети представляет собой 4 однобайтных числа, разделенных точкой.
Причем для масок выполнено следующее свойство: если представить маску в двоичном виде, то сначала она будет содержать k единиц, а потом q
нулей, причем k + q = 32. Например, 255.255.255.0 — маска подсети, а 192.168.0.1 — нет.
	Поясним, как получается двоичное представление IP-адреса. Для этого числа, составляющие IP-адрес, представляются в двоичной системе
счисления (при этом каждое из них дополняется ведущими нулями до длины в 8 цифр), после чего удаляются точки. Получившееся 32-битное число
и есть двоичное представление IP-адреса. Например, для адреса 192.168.0.1 этот процесс выглядит так: 192.168.0.1 → 
11000000.10101000.00000000.00000001 → 11000000101010000000000000000001. Таким образом, двоичным представлением IP-адреса 192.168.0.1
является 11000000101010000000000000000001.
	Будем говорить, что два компьютера с IP1 и IP2 лежат в подсети, если IP1 /\ Mask = IP2 /\ Mask, где Mask — маска этой подсети,
а /\ — операция побитового логического «и». IP компьютера представляет собой так же 4 однобайтных числа, разделенных точкой.
	Вам даны M пар IP адресов компьютеров. Для каждой из них Вам надо определить, в скольких подсетях из заданных они лежат.
	Входные данные
В первой строке входного файла INPUT.TXT записано число N — количество подсетей. В следующих N строках перечислены маски этих подсетей. В N + 2 строке находится число M (0 ≤ M ≤ 10000). В следующих M строках записаны пары IP адресов, разделенных пробелом.
	Выходные данные
Для каждой пары IP адресов в отдельной строке выходного файла OUTPUT.TXT выведите количество подсетей, в которых лежат оба компьютера.
	Пример
№	INPUT.TXT				OUTPUT.TXT
1	2						1
	255.255.255.255			1
	255.255.255.0			0
	3
	192.168.31.1 192.168.31.2
	192.168.31.3 192.168.31.4
	192.168.31.1 192.167.31.2 */

import java.io.*;
import java.nio.charset.Charset;

public class acmp_0067 {
public static void main(String[] args) throws IOException {
	BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\JavaTXT\\ACMP_0001\\input.txt"), Charset.forName("UTF-8")));
	int N = Integer.parseInt(reader.readLine());
	
	String Maski[] = new String[N];
	for (int i =0; i<N; i++)  Maski[i] = reader.readLine();
		
	int M = Integer.parseInt(reader.readLine());
	StringBuffer sbf1 = new StringBuffer();
	
			// Цикл для перебора каждой пары IP
	for (int i =0; i<M; i++)  {
		int count = 0;
		String input_IP = reader.readLine();
		String IP[] = input_IP.split(" ");
		String IP1 = IP[0];		String IP2 = IP[1];		
		
			// Цикл для перебора каждой маски подсети и сравнения ее c i-ой паpой IP
		for (int j =0; j<N; j++) {
			String Maski_decomposed[] = Maski[j].split("\\.");
			String IP1_decomposed[] = IP1.split("\\.");
			String IP2_decomposed[] = IP2.split("\\.");
						
			boolean ifIpAndMaskEqual = true;
			
			// Цикл для перебора и сравнения каждой составляющей IP
			for (int l = 0; l<4; l++)  {
				if (IP1_decomposed[l].equals(IP2_decomposed[l])) ifIpAndMaskEqual = true;
				else {
					if (Maski_decomposed[l].equals("255")) ifIpAndMaskEqual = false;
					else if (Maski_decomposed[l].equals("0")) ifIpAndMaskEqual = true;
					else {
						int maska = Integer.parseInt(Maski_decomposed[l]); 
						int ip1 = Integer.parseInt(IP1_decomposed[l]);
						int ip2 = Integer.parseInt(IP2_decomposed[l]);
						int isEqualForIp1 = (ip1&maska);
						int isEqualForIp2 = (ip2&maska);
						ifIpAndMaskEqual = (isEqualForIp1 == isEqualForIp2);}
				}
			if (ifIpAndMaskEqual == false ) break; 
		}
		if (ifIpAndMaskEqual == true) count++;
		}
	sbf1.append(count + "\n");
	}
	reader.close();
	System.out.println(sbf1.toString());
	
	PrintWriter pw;
	pw = new PrintWriter(new FileWriter("C:\\JavaTXT\\ACMP_0001\\output.txt"));
	pw.print(sbf1.toString());
	pw.close();
}
}