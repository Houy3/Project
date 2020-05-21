import java.util.*;
import java.io.*;

public class Task1356 {
	public static void main(String[] args) throws IOException {
		File file = new File("INPUT.TXT");
		Scanner scan = new Scanner(file);

		int n = scan.nextInt();
		int[][] graf = new int[n][n + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				graf[i][j] = scan.nextByte();
			}	
		}
		// вводим данные

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				graf[i][n] = graf[i][n] + graf[i][j];
			}	
		}
		// степень вершины - кол-во ребер, которое идет из этой точки, значит нам надо посчитать лишь кол-во путей

		File file2 = new File("OUTPUT.TXT");
		PrintWriter writer = new PrintWriter(file2);
		for (int i = 0; i < n; i++) {
			writer.print(graf[i][n] + " ");
		}

		writer.close();
		// выводим данные 
	}
}
