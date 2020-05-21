import java.util.*;
import java.io.*;

public class Task156 {
	public static void main(String[] args) throws IOException {
		File file = new File("INPUT.TXT");
		Scanner scan = new Scanner(file);

		int n = scan.nextInt();
		int k = scan.nextInt();
		// вводим данные

		int ans = 1;
		// создаем переменную для ответа

		for (int i = n, j = 0; j < k && i > 0; i--, j++) {
			ans = ans * i;
		}

		for (int i = 1; i <= n; i++) {
			ans = ans * i;
		}

		for (int i = 1; i <= k; i++) {
			ans = ans / i;
		}

		for (int i = 1; i <= n - k; i++) {
			ans = ans / i;
		}

		File file2 = new File("OUTPUT.TXT");
		PrintWriter writer = new PrintWriter(file2);
		writer.print(ans);
		writer.close();
		// выводим данные 
	}
}
