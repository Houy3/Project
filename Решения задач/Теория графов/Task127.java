import java.util.*;
import java.io.*;

public class Task {
	public static void main(String[] args) throws IOException {
		File file = new File("INPUT.TXT");
		Scanner scan = new Scanner(file);

		int n = scan.nextInt();
		int[][] graf = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				graf[i][j] = scan.nextInt();
			}
		}
		int start = scan.nextInt() - 1;
		int finish = scan.nextInt() - 1;
		// вводим данные (- 1, потому что у вершины 5 в массиве будет индекс 4, так как нумерация начинается с нуля)

		int ans = -1;
		// переменная для ответа

		// будем использовать алгоритм поиска в ширину

		Queue<Integer> que = new LinkedList<>();
		HashSet<Integer> set = new HashSet<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		// очередь вершин, которые мы будем рассматривать; 
		// сет для хранения посещенных вершин
		// карту для хранения длины до определенной вершины (ключ - номер вершины; значение - расстояние от начальной вершины до этой)

		que.add(start);  // добавляем начальную точку в очередь
		map.put(start, 0); // Добавляем расстояние до начальной точки, то есть 0
		set.add(start); // добавляем начальную вершину в сет просматриваемых 

		while (!que.isEmpty()) {
			int pros = que.poll();  // pros - номер просматриваемой вершины

			if (pros == finish) { // если просматриваемая вершина - финиш, то останавливаем цикл
				ans = map.get(pros);
				break;
			} // но если мы не дойдем до этой точки, то ans останется = -1

			for (int i = 0; i < n; i++) {
				if (graf[pros][i] == 1 && !set.contains(i)) { // если из просматриваемой вершины есть ребро 
				// в вершину i и вершина i ранее не была просмотрена, то 
					que.add(i); // добавим ее в очередь
					set.add(i); // добавляем в сет просмотренных
					map.put(i, map.get(pros) + 1); // добавляем расстояние до этой точки
				}
			}
		}

		File file2 = new File("OUTPUT.TXT");
		PrintWriter writer = new PrintWriter(file2);
		writer.print(ans);
		writer.close();
		// выводим данные 
	}
}
