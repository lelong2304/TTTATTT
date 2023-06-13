package chuong1;

import java.util.Scanner;

public class BoyerMoore {
	public static Scanner scanner = new Scanner(System.in);

	static int numberOfChars = 127;

	static int[] counterArray(String str) {
		int a[] = new int[numberOfChars];
		for (int i = 0; i < numberOfChars; i++) {
			a[i] = -1;
		}
		for (int i = 0; i < str.length(); i++) {
			a[(int) str.charAt(i)] = i;
		}
		return a;
	}

	public static int algorithmsBoyerMoore(String str, String subStr) {
		int i, j, m, l;
		char T[] = str.toCharArray();
		char P[] = subStr.toCharArray();
		int a[];
		a = counterArray(subStr);
		m = subStr.length();
		i = m - 1;
		j = m - 1;
		while (i <= str.length() - 1) {
			if (T[i] == P[j]) {
				if (j == 0) {
					return i;
				} else {
					i = i - 1;
					j = j - 1;
				}
			} else {
				l = a[(int) T[i]];
				i = i + m - Math.min(j, 1 + l);
				j = m - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		String str, subStr;
		System.out.print("Nhap chuoi:");
		str = scanner.nextLine();
		System.out.print("Nhap chuoi con:");
		subStr = scanner.nextLine();
		System.out.println(algorithmsBoyerMoore(str, subStr));
	}
}
