import java.util.*;
import java.io.*;

public class Task554 {
	public static void main(String[] args) throws IOException {
		File file = new File("INPUT.TXT");
		Scanner scan = new Scanner(file);

		int n = scan.nextInt();
		// вводим данные

		long ans = 2;

		for (int i = 2; i <= n; i++) {
			ans = ans + i;
		}
		// при n = 1 ans = 2; 
		// при n = 2 ans = 4;
		// при n = 3 ans = 7;
		// замечаете закономерность?
 
		File file2 = new File("OUTPUT.TXT");
		PrintWriter writer = new PrintWriter(file2);
		writer.print(ans);
		writer.close();
		// выводим данные 
	}
}
