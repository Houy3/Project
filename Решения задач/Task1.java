import java.util.*;
import java.io.*;

public class Task1 {
	public static void main(String[] args) throws IOException {
		// не забываем про последние 2 слова

		File file = new File("INPUT.TXT");
		Scanner scan = new Scanner(file);

		long A = scan.nextInt();
		long B = scan.nextInt();
		// ввод данных

		Long C = A + B;
		// делаем то, что требуется

		File file2 = new File("OUTPUT.TXT");
		PrintWriter writer = new PrintWriter(file2);

		writer.print(A + B);
		writer.close();
		// выводим данные 
	}
}