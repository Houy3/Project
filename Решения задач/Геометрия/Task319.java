import java.util.*;
import java.io.*;

public class Task319 {
	public static void main(String[] args) throws IOException {
		File file = new File("INPUT.TXT");
		Scanner scan = new Scanner(file);

		long x1 = scan.nextLong();
		long y1 = scan.nextLong();
		long x2 = scan.nextLong();
		long y2 = scan.nextLong();
		long ans = 0;
		// вводим данные

		// рассмотрим случаи, когда отрезок параллелен 
		if (x1 == x2) {
			ans = Math.abs(y2 - y1) + 1;
		} else if (y1 == y2) {
			ans = Math.abs(x2 - x1) + 1;

		// иначе мысленно представим треугольник, у которого гипотенуза - данный отрезок
		} else {
			long length1 = Math.abs(y2 - y1);
			long length2 = Math.abs(x2 - x1);

			// главный отрезок делится на *НОД этих 2 чисел* подотрезков, края которых - точки с 
			// целочисленными координатами. Тут нам пригодится алгоритм евклида для нахождения НОД

			while (length1 != length2) {
				if (length2 > length1) {
					length2 = length2 - (length2 / length1) * length1;
					// чтобы не вычитать из девятки 2 несколько раз, вычтем сразу (9 div 2) * 2 = 8
				} else {
					length1 = length1 - (length1 / length2) * length2;
					// а если обнулится(например при 8 и 2), то проверим потом этот случай
				}
				if (length2 == 0) {
					length2 = length1;
					break;
				}
				if (length1 == 0) {
					length1 = length2;
					break;
				}

			}
			//значение в любой из этих переменных - НОД

			ans = length2 + 1;
			//если есть n подряд идущих отрезков, значит у них n+1 точек
		}

		File file2 = new File("OUTPUT.TXT");
		PrintWriter writer = new PrintWriter(file2);
		writer.print(ans);
		writer.close();
		// выводим данные 
	}
}
