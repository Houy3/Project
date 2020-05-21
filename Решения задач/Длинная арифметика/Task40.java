import java.util.*;
import java.io.*;

public class Task40 {
	public static void main(String[] args) throws IOException {
		File file = new File("INPUT.TXT");
		Scanner scan = new Scanner(file);

		int n = scan.nextInt();
		// вводим данные

		//если n = 62 или меньше, то long его выдержит
		if (n < 63) {
			long num = 1;
			for (int i = 0; i < n; i++) {
				num = num * 2;
			}
			// домножаем на 2, пока не дойдем до нужной степени

			File file2 = new File("OUTPUT.TXT");
			PrintWriter writer = new PrintWriter(file2);
			writer.print(num);
			writer.close();
			// выводим данные

		// иначе работаем с массивом	
		} else {
			String s = "9223372036854775808";
			// это 2 в 63 степени

			ArrayList<Integer> num = new ArrayList<>();
				for (int i = 0; i < s.length(); i++) {
					num.add(Integer.parseInt(s.substring(i, i + 1)));
			}
			// переводим в массив,

			for (int i = 63; i < n; i++) {
				for (int j = 0; j < num.size() - 1; j++) {
					if (num.get(j + 1) > 4) {
						num.set(j, num.get(j) * 2 + 1);
						num.set(j + 1, num.get(j + 1) - 5);
					} else {
						num.set(j, num.get(j) * 2);
					}
				}
				num.set(num.size() - 1, num.get(num.size() - 1) * 2);
				if (num.get(0) > 9) {
					num.add(0,1);
					num.set(1, num.get(1) - 10);
				}
			}
			//умножаем на два, пока не дойдем до нужной степени

			File file2 = new File("OUTPUT.TXT");
			PrintWriter writer = new PrintWriter(file2);

			for (int i = 0; i < num.size(); i++) {
				writer.print(num.get(i));
			}
			writer.close();
			// выводим данные 
		}
	}
}
