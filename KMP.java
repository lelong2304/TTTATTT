package chuong1;

import java.util.Scanner;

public class KMP {
	static Scanner scanner = new Scanner(System.in);

	static int KMPSearch(String pat, String txt) {
		int M = pat.length();
		int N = txt.length();

		int lps[] = new int[M];
		int j = 0;
		int temp;
		computeLPSArray(pat, M, lps);

		int i = 0;
		while ((N - i) >= (M - j)) {
			if (pat.charAt(j) == txt.charAt(i)) {
				j++;
				i++;
			}
			if (j == M) {
				temp = i - j;
				j = lps[j - 1];
				return temp;
			}

			else if (i < N && pat.charAt(j) != txt.charAt(i)) {

				if (j != 0)
					j = lps[j - 1];
				else
					i = i + 1;
			}
		}
		return -1;
	}

	public static void computeLPSArray(String pat, int M, int lps[]) {

		int j = 0;
		int i = 1;
		lps[0] = 0;

		while (i < M) {
			if (pat.charAt(i) == pat.charAt(j)) {
				j++;
				lps[i] = j;
				i++;
			} else if (j != 0) {
				j = lps[j - 1];

			} else {
				lps[i] = j;
				i++;
			}
		}
	}

	public static void main(String[] args) {
		String T, P;
		System.out.print("Nhap chuoi:");
		T = scanner.nextLine();
		System.out.print("Nhap chuoi con:");
		P = scanner.nextLine();
		System.out.println(KMPSearch(P, T));
		// abacaabaccabacabaabb
		// abacab
	}
}
