import java.util.*;
import java.io.*;

public class Task144 {
	public static void main(String[] args) throws IOException {
		File file = new File("INPUT.TXT");
		Scanner scan = new Scanner(file);

		String s = scan.next();
		int b = scan.nextInt();
		// вводим данные

		ArrayList<Integer> num = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			num.add(Integer.parseInt(s.substring(i, i + 1)) * b);
		}
		// переводим строку числа в массив, сразу умножая каждую цифру на B

		for (int i = s.length() - 1; i > 0; i--) {
			num.set(i - 1, num.get(i - 1) + num.get(i) / 10);
			num.set(i, num.get(i) % 10);
		}
		//у нас получился массив из кучи чисел, например {55,66,77} от умножения 567 на 11,
		//и нам нужно перевести десятки вперед 

		File file2 = new File("OUTPUT.TXT");
		PrintWriter writer = new PrintWriter(file2);

		if (b == 0) {
			num.clear();
			num.add(0);	
		}
		// не будем выводить кучу нулей, если одно из числе равно 
		for (int i = 0; i < num.size(); i++) {
			writer.print(num.get(i));
		}

		writer.close();
		// выводим данные 
	}
}