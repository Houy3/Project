import java.util.*;
import java.io.*;

public class Task28 {
	public static void main(String[] args) throws IOException {
		File file = new File("INPUT.TXT");
		Scanner scan = new Scanner(file);

		long x1 = scan.nextLong();
		long y1 = scan.nextLong();
		long x2 = scan.nextLong();
		long y2 = scan.nextLong();
		long xA = scan.nextLong();
		long yA = scan.nextLong();
		long xB = 0;
		long yB = 0;
		// вводим данные

		//рассмотрим случай, когда прямая параллльная Ох
		if (y1 == y2) {
			xB = xA;
			yB = 2 * y1 - yA;
		} 

		//рассмотрим случай, когда прямая параллльная Оy
		if (x1 == x2) {
			yB = yA;
			xB = 2 * x1 - xA;
		}

		File file2 = new File("OUTPUT.TXT");
		PrintWriter writer = new PrintWriter(file2);
		writer.print(xB + " " + yB);
		writer.close();
		// выводим данные 
	}
}