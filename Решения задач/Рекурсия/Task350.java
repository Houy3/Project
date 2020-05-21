import java.util.*;
import java.io.*;

public class Task350 {
	public static void main(String[] args) throws IOException {
		File file = new File("INPUT.TXT");
		Scanner scan = new Scanner(file);

		String s = scan.next();
		// вводим данные

		ArrayList<String> ans = new ArrayList<>();
		ans.addAll(rec(s));
		// вызываем рекурсивную функцию

		File file2 = new File("OUTPUT.TXT");
		PrintWriter writer = new PrintWriter(file2);
		for (int i = 0; i < ans.size(); i++) {
			writer.println(ans.get(i));
		}
		writer.close();
		// выводим данные 
	}

	// рекурсия возвращает список строк - наш ответ
	// алгоритм следующий: перестановки для ABC - это расстановка A * перестановки BC (1ур)
	// перестановки BC - это расстановка B * перестановки C (2ур)
	// перестановки C = С (3ур). Возвращаем список, содержащий лишь C 
	// теперь расставляем B. Либо BC, либо CB. (2ур) Возвращаем список с этими элементами
	// теперь расславяем А. BC -> ABC, BAC, BCA; CB -> ACB, CAB, CBA (1ур). Возвращаем список с этими элементами



	public static ArrayList<String> rec(String s) {
		if (s.length() == 1) {
			ArrayList<String> answer = new ArrayList<>();
			answer.add(s);
			return answer;
			// самый нижний уровень, когда у строки осталась одна буква
		} else {
			ArrayList<String> answer = new ArrayList<>();
			answer.addAll(rec(s.substring(1, s.length())));
			// получаем перестановки всех букв, не включая первую

			char c = s.charAt(0);
			int l = answer.size();
			for (int i = 0; i < l; i++) {
				for (int j = 0; j < answer.get(0).length() + 1; j++) {
					answer.add(answer.get(0).substring(0,j) + c + answer.get(0).substring(j,answer.get(0).length()));
				}
				answer.remove(0);
			}
			// расставляем первую букву в эти перестановки.

			return answer;
		}
	}
}