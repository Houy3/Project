import java.util.*;
import java.io.*;

public class Task7 {
	public static void main(String[] args) throws IOException {
		File file = new File("INPUT.TXT");
		Scanner scan = new Scanner(file);

		String s1 = scan.next();
		String s2 = scan.next();
		String s3 = scan.next();
		//вводим данные

		//если длины чисел равны, то придется сравнивать начальные цифры в числах
		int max = 1;
		if (s1.length() == s2.length() && s1.length() == s3.length()) {

			ArrayList<Integer> num1 = new ArrayList<>();
			for (int i = 0; i < s1.length(); i++) {
				num1.add(Integer.parseInt(s1.substring(i, i + 1)));
			}
			ArrayList<Integer> num2 = new ArrayList<>();
			for (int i = 0; i < s2.length(); i++) {
				num2.add(Integer.parseInt(s2.substring(i, i + 1)));
			}
			ArrayList<Integer> num3 = new ArrayList<>();
			for (int i = 0; i < s3.length(); i++) {
				num3.add(Integer.parseInt(s3.substring(i, i + 1)));
			}
			//переведем строки в массивы: "123" -> {1,2,3}

			int i = 0;
			while (num1.get(i) == num2.get(i)) {
				if (i == num1.size() - 1) 
					break;
				i++;
			}
			// найдем первую цифру, которой 1 число отличается от второго (с левого конца числа)

			// Если 1 числа эта цифра больше, значит 1 число больше, значит надо его сравнить с 3
			if (num1.get(i) > num2.get(i)) {
				i = 0;
				while (num1.get(i) == num3.get(i)) {
					if (i == num1.size() - 1 ) 
						break;
					i++;
				}
				if (num1.get(i) > num3.get(i)) 
					max = 1;
				else
					max = 3;
			// иначе надо сравнить 2 число с 3 
			} else {
				i = 0;
				while (num2.get(i) == num3.get(i)) {
					if (i == num2.size() - 1) 
						break;
					i++;
				}
				if (num2.get(i) > num3.get(i)) 
					max = 2;
				else
					max = 3;
			}
		
		// если длины чисел не равны, значит наибольшее = наидлиннейшее 
		} else {
			max = 1;
			if (s2.length() >= s1.length() && s2.length() >= s3.length()) 
				max = 2;
			if (s3.length() >= s2.length() && s3.length() >= s1.length()) 
				max = 3;
		}

		File file2 = new File("OUTPUT.TXT");
		PrintWriter writer = new PrintWriter(file2);

		if (max == 1) 
			writer.println(s1);
		if (max == 2) 
			writer.println(s2);
		if (max == 3) 
			writer.println(s3);
		
		writer.close();
		// ввывод данных
	}
}