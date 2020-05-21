import java.util.*;
import java.io.*;

public class Task121 {
	public static void main(String[] args) throws IOException {
		File file = new File("INPUT.TXT");
		Scanner scan = new Scanner(file);

		int n = scan.nextInt();
		ArrayList<Integer> dots = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			dots.add(scan.nextInt());
		}
		// вводим данные

		Collections.sort(dots);
		// сортируем в порядке увеличения

		for (int i = 0; i < n - 1; i++) {
			dots.set(i, dots.get(i + 1) - dots.get(i));
		} 
		dots.remove(dots.size() - 1);
		// теперь у нас список расстояний между точкам
		

		// получается, что нам нужно пройти от левого конца списка в правый, суммирая каждое число,
		// которое захватим
		// притом мы можем перешагивать через одно число
		// (как в лесенки-2, но путь показывать не нужно)

		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(dots.get(0));
		if (n != 2)
			arr.add(dots.get(0) + dots.get(1));
		// добавляем первые два расстояния

		for (int i = 2; i < dots.size(); i++) {
			arr.add( Math.min(arr.get(i - 2), arr.get(i - 1)) + dots.get(i) );
		}
		// находим наименьшую возможную сумму для каждой точки

		File file2 = new File("OUTPUT.TXT");
		PrintWriter writer = new PrintWriter(file2);
		writer.print(arr.get(n - 2));
		writer.close();
		// выводим данные 
	}
}