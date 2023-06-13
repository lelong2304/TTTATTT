package chuong1;

import java.util.Scanner;

public class KnuthMorrisPratt {
	static Scanner scanner = new Scanner(System.in);

	public static int[] failureFunction(String P) {
		int F[], i, j, countSuffix, k, max;
		String tempPrefix, tempSuffix;
		String tempSringPx[], tempStringSx[];
		char tempCharPx[], tempCharSx[];
		tempCharPx = new char[P.length() - 1];
		tempCharSx = new char[P.length() - 1];
		F = new int[P.length()];
		F[0] = -1;
		if (P.length() > 1) {
			F[1] = 0;
		}
		for (i = 2; i < P.length(); i++) {
			tempPrefix = P.substring(0, i);
			tempCharPx = tempPrefix.toCharArray();
			tempSringPx = new String[tempPrefix.length()];
			for (j = 0; j < tempPrefix.length(); j++) {
				if (j != 0) {
					tempSringPx[j] = tempSringPx[j - 1] + tempCharPx[j] + "";
					// System.out.println(tempSringPx[j]);
					continue;
				}
				tempSringPx[j] = tempCharPx[j] + "";
				// System.out.println(tempSringPx[j]);
			}
			tempSuffix = P.substring(1, i);
			tempCharSx = tempSuffix.toCharArray();
			tempStringSx = new String[tempSuffix.length()];
			countSuffix = 0;
			for (j = tempSuffix.length() - 1; j >= 0; j--) {
				if (j != tempSuffix.length() - 1) {
					tempStringSx[countSuffix] = tempCharSx[j] + "" + tempStringSx[countSuffix - 1];
					// System.out.println(tempStringSx[countSuffix]);
					countSuffix++;
					continue;
				}
				tempStringSx[countSuffix] = tempCharSx[j] + "";
				// System.out.println(tempStringSx[countSuffix]);
				countSuffix++;
			}
			max = 0;
			for (j = 0; j < tempStringSx.length; j++) {
				for (k = 0; k < tempSringPx.length; k++) {
					if (tempStringSx[j].compareTo(tempSringPx[k]) == 0) {
						if (tempStringSx[j].length() > max) {
							max = tempStringSx[j].length();
						}
					}
				}
			}
			F[i] = max;
		}
		return F;
	}

	public static int calculator(String T, String P) {
		int i, j, F[];
		char tempT[], tempP[];
		tempT = T.toCharArray();
		tempP = P.toCharArray();
		F = failureFunction(P);
		i = 0;
		j = 0;
		while (i < T.length()) {
			if (tempT[i + j] == tempP[j]) {
				if (j == P.length() - 1) {
					return i;
				}
				j = j + 1;
			} else {
				i = i + j - F[j];
				if (F[j] == -1) {
					j = 0;
				} else {
					j = F[j];
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		String T, P;
		System.out.print("Nhap chuoi:");
		T = scanner.nextLine();
		System.out.print("Nhap chuoi con:");
		P = scanner.nextLine();
		System.out.println(calculator(T, P));
		// abacaabaccabacabaabb
		// abacab
	}
}
