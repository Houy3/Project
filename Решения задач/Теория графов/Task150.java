import java.util.*;
import java.io.*;

public class Task {
	public static void main(String[] args) throws IOException {
		File file = new File("INPUT.TXT");
		Scanner scan = new Scanner(file);

		int n = scan.nextInt();
		int s = scan.nextInt() - 1;
		Boolean[][] graf = new Boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int a = scan.nextInt();
				if (a > 0) 
					graf[i][j] = true;
				else
					graf[i][j] = false; 
			}	
		}
		// вводим данные

		HashSet<Integer> friends = new HashSet<>();
		int ans = rec(graf, n, s, friends).size();
		// вызываем рекурсию для поиска в глубину

		ans--;
		// так как мы добавили в друзья и начального чела, то надо минусовать 1 друга 

		File file2 = new File("OUTPUT.TXT");
		PrintWriter writer = new PrintWriter(file2);
		writer.print(ans);
		writer.close();
		// выводим данные 
	}


	// друг друга - наш друг, друг друга друга - тоже наш друг, поэтому мы будем добавлять всех друзей наших друзей, 
	// но, чтобы не повторяться, будем записывать наши друзей в сете
	public static HashSet<Integer> rec(Boolean[][] graf, int n, int prosChel, HashSet<Integer> friends) {

		friends.add(prosChel);
		// добавляем просмтриваемого человека в круг друзей
		for (int i = 0; i < n; i++) {
			if (graf[prosChel][i]) {
				if (!friends.contains(i)) {
					friends.addAll(rec(graf, n, i, friends));
					// если его друг нам не знаком, то добавляем всех его друзей
				}
			} 
		}
		return friends;
	}

}
