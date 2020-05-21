import java.util.*;
import java.io.*;

public class Task893 {
	public static void main(String[] args) throws IOException {
		File file = new File("INPUT.TXT");
		Scanner scan = new Scanner(file);

		long n = scan.nextLong();
		// вводим данные

		File file2 = new File("OUTPUT.TXT");
		PrintWriter writer = new PrintWriter(file2);

		if (n == 1 || n == 2) {
			writer.print(n);
		} else {
			writer.print((n - 2) * (n - 1) * n);
		}
		// используем формулу перестановок; так как n <= 10000, значит внутри число может достигать 10^13,
		// поэтому используем long

		writer.close();
		// выводим данные 
	}
}