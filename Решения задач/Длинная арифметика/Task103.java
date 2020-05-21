import java.util.*;
import java.io.*;

public class Task103 {
	public static void main(String[] args) throws IOException {
		File file = new File("INPUT.TXT");
		Scanner scan = new Scanner(file);

		String s1 = scan.next();
		String s2 = scan.next();
		// вводим данные

		while (s1.length() > s2.length()) {
			s2 = "0" + s2;
		}
		while (s1.length() < s2.length()) {
			s1 = "0" + s1;
		}
		//доводим строки до одинаковой длины

		ArrayList<Integer> num1 = new ArrayList<>();
		for (int i = 0; i < s1.length(); i++) {
			num1.add(Integer.parseInt(s1.substring(i, i + 1)));
		}
		ArrayList<Integer> num2 = new ArrayList<>();
		for (int i = 0; i < s2.length(); i++) {
			num2.add(Integer.parseInt(s2.substring(i, i + 1)));
		}
		//переведем строки в массивы: "123" -> {1,2,3}

		ArrayList<Integer> num3 = new ArrayList<>();
		for (int i = 0; i < s1.length(); i++) {
			num3.add(num1.get(i) + num2.get(i));
		}
		// сложим

		for (int i = s1.length() - 1; i > 0; i--) {
			if (num3.get(i) > 9) {
				num3.set(i, num3.get(i) - 10);
				num3.set(i - 1, num3.get(i - 1) + 1);
			}
		}
		// если мы сложим 7 и 5, то получим 12. 2 оставим, а 1 перенесем. здесь мы как раз переносим


		File file2 = new File("OUTPUT.TXT");
		PrintWriter writer = new PrintWriter(file2);
		for (int i = 0; i < s1.length(); i++) {
			writer.print(num3.get(i));
		}
		writer.close();
		// выводим данные 
	}
}
