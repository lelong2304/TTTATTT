package chuong1;

import java.util.Scanner;

public class SimpleFindPrime {
	static Scanner scanner = new Scanner(System.in);

	static int findPrime(long n) {
		int i;
		if (n < 2) {
			return 0;
		}
		double sqrtN = Math.sqrt(n);
		for (i = 2; i <= sqrtN; i++) {
			if (n % i == 0) {
				return 0;
			}
		}
		return 1;
	}

	public static void main(String[] args) {
		long n;
		System.out.print("Nhap n: ");
		n = scanner.nextLong();
		int i;
		if (n >= 2) {
			System.out.print(2 + " ");
		}
		for (i = 3; i <= n; i += 2) {
			if (findPrime(i) == 1) {
				System.out.println(i + " ");
			}
		}
	}
}
