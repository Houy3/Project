import java.util.*;
import java.io.*;

public class Task370 {
	public static void main(String[] args) throws IOException {
		File file = new File("INPUT.TXT");
		Scanner scan = new Scanner(file);

		int n = scan.nextInt();
		int[][] xy = new int[n + 1][2];
		for (int i = 0; i < n; i++) {
			xy[i][0] = scan.nextInt();
			xy[i][1] = scan.nextInt();
		}
		// вводим данные

		xy[n][0] = xy[0][0];
		xy[n][1] = xy[0][1];
		// добавляем для использования формулы шнурков

		long sum1 = 0;
		for (int i = 0; i < n; i++) {
			sum1 = sum1 + xy[i][0] * xy[i + 1][1];
		}

		long sum2 = 0;
		for (int i = 0; i < n; i++) {
			sum2 = sum2 + xy[i + 1][0] * xy[i][1];
		}

		double s = Math.abs(sum1 - sum2);
		s = s / 2;
		//находим площадь, используя формулу шнурков

		String stri = String.format("%.1f",s);
		stri = stri.replace(',','.');
		// надо же вывести с 1 знаком после запятой, но лучше использовать форматируемый выход
		// на сайте acmp, откуда я брал задачу, принимаются действительные числа с точкой, а не
		// с запятой, поэтому аккуратнее

		File file2 = new File("OUTPUT.TXT");
		PrintWriter writer = new PrintWriter(file2);
		writer.printf(stri);
		writer.close();
		// выводим данные 
	}
}
