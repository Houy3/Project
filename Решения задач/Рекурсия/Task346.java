import java.util.*;
import java.io.*;

public class Task {
	public static void main(String[] args) throws IOException {
		File file = new File("INPUT.TXT");
		Scanner scan = new Scanner(file);

		Long a = scan.nextLong();
		long b = scan.nextLong();
		long c = scan.nextLong();
		// вводим данные

		TreeSet<String> setA = new TreeSet<>();
		setA.addAll(rec(String.valueOf(a)));
		// находим все перестановки для числа А

		Collections.sort(setA);

		byte[] arrb = new byte[10];
		while (b > 0) {
			arrb[(int)b % 10]++;
			b = b / 10;
		}
		// найдем все цифры числа b

		Boolean ans = false;
		long ansa = 0;
		long ansb = 0;
		// будем сверять цифры числа b и числа Y = с - перестановка а
		for (String i : setA) {

			Boolean pod = true;
			long prov = c - Long.parseLong(i);
			if (prov <= 0) {
				break;
			}
			byte[] arr = new byte[10];
			while (prov > 0) {
				arr[(int)prov % 10]++;
				prov = prov / 10;
			}
			for (int j = 0; j < 10; j++){
				if (arr[j] != arrb[j]) {
					pod = false;
					break;
				}
			}
			// если совпадут, то выведем
			if (pod) {
				ans = true;
				ansa = Long.parseLong(i);
				ansb = c - Long.parseLong(i);
				break;
			}
		}

		File file2 = new File("OUTPUT.TXT");
		PrintWriter writer = new PrintWriter(file2);

		if (ans) {
			writer.println("YES");
			writer.println(ansa + " " + ansb);
		} else {
			writer.println("NO");
		}

		writer.close();
		// выводим данные 
	}

	// перестановки числа аналогично №350 
	public static ArrayList<String> rec(String s) {
		if (s.length() == 1) {
			ArrayList<String> answer = new ArrayList<>();
			answer.add(s);
			return answer;
		} else {
			HashSet<String> set = new HashSet<>();
			set.addAll(rec(s.substring(1, s.length())));

			ArrayList<String> answer = new ArrayList<>();
			answer.addAll(set);
			char c = s.charAt(0);
			int l = answer.size();
			for (int i = 0; i < l; i++) {
				for (int j = 0; j < answer.get(0).length() + 1; j++) {
					answer.add(answer.get(0).substring(0,j) + c + answer.get(0).substring(j,answer.get(0).length()));
				}
				answer.remove(0);
			}

			return answer;
		}
	}
}