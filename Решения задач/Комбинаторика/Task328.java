import java.util.*;
import java.io.*;

public class Task328 {
	public static void main(String[] args) throws IOException {
		File file = new File("INPUT.TXT");
		Scanner scan = new Scanner(file);
		int n = scan.nextInt();
		// вводим данные

		/* посчитаем точки: если на одной половине 0 точек, то всего точек на всех таких
		домино = 0 + (0 + 1 + 2 + ... + N); если 1 точка, то = 1*N + (1 + 2 + ... + N) и тд
		то есть = (1 + 2 + ... + N) + ((N)*1 + (N-1)*2 + ... + N) + N^N + (N-1)^2 + ... + 1^2 
		*/

		long sum = 0;
		for (int i = 1; i < n + 1; i++) {
			sum = sum + i;
		}
		for (int i = 1; i < n + 1; i++) {
			sum = sum + (n + 1 - i) * i;
		}
		for (int i = 1; i < n + 1; i++) {
			sum = sum + i * i;
		}
		//считаем


		File file2 = new File("OUTPUT.TXT");
		PrintWriter writer = new PrintWriter(file2);
		writer.print(sum);
		writer.close();
		// выводим данные 
	}
}
