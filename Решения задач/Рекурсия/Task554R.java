import java.util.*;
import java.io.*;

public class Task {
	public static void main(String[] args) throws IOException {
		File file = new File("INPUT.TXT");
		Scanner scan = new Scanner(file);

		int n = scan.nextInt();
		// вводим данные

		File file2 = new File("OUTPUT.TXT");
		PrintWriter writer = new PrintWriter(file2);
		writer.println(ans(n));
		writer.close();
		// выводим данные 
	}

	public static int ans(int n) {
		if (n == 0) {
			return 1;
		} else {
			return ans(n - 1) + n;
		}
	}
	// то есть кол-во кусков при n разрезах = кол-во кусков при n-1 разрезах + n
	// кол-во кусков при n-1 разрезах = кол-во кусков при n-2 разрезах + n-1
	// и так далее до нуля
}