import java.util.*;
import java.io.*;

public class Task {
	public static void main(String[] args) throws IOException {
		File file = new File("INPUT.TXT");
		Scanner scan = new Scanner(file);

		int n = scan.nextInt();
		ArrayList<Integer> stairs = new ArrayList<>();
		stairs.add(0);
		for (int i = 0; i < n; i++) {
			stairs.add(scan.nextInt());
		}
		// вводим данные

		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
		// создадим список списков, в которых нулевое значение - наибольшая возможная сумма в этой точке,
		// а остальные - маршрут до него.

		if (0 == 0) {
			ArrayList<Integer> inside = new ArrayList<>();

			inside.add(stairs.get(0));
			arr.add(inside);
			// добавляем 0 точку старта
		}
		if (0 == 0) {
			ArrayList<Integer> inside = new ArrayList<>();
			
			inside.add(stairs.get(1));
			inside.add(1);
			arr.add(inside);
			// добавляем 1 точку
		}
		// список inside создаем внутри if, потому что иначе в arr будет добавлены не значения
		// а ссылка на inside, а его мы собираемся менять

		for (int i = 2; i <= n; i++) {
			ArrayList<Integer> inside = new ArrayList<>();

			if ( arr.get(i - 1).get(0) > arr.get(i - 2).get(0) ) {
				inside.add(arr.get(i - 1).get(0) + stairs.get(i));
				inside.addAll(arr.get(i - 1));
				inside.remove(1);
			// если наибольшая возможная сумма (G) на прошлой ступени больше, чем на позапрошлой, то
			// значит на этой ступени наибольшая возможная сумма - это сумма G + число на ступеньке
			} else {
				inside.add(arr.get(i - 2).get(0) + stairs.get(i));
				inside.addAll(arr.get(i - 2));
				inside.remove(1);
			}
			// аналогично

			inside.add(i);
			// добавляем эту точку, как пройденный маршрут на случай, если потом мы будем использовать эту точку

			arr.add(inside);
		}


		File file2 = new File("OUTPUT.TXT");
		PrintWriter writer = new PrintWriter(file2);
		writer.println(arr.get(n).get(0));
		for (int i = 1; i < arr.get(n).size(); i++) {
			writer.print(arr.get(n).get(i) + " ");
		}

		writer.close();
		// выводим данные 
	}
}