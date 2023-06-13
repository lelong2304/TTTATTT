package chuong1;

import java.util.Scanner;

public class IsPrime {
	static Scanner scanner = new Scanner(System.in);

	static boolean isPrimeAlgorithms(long n) {
		long i;
		for (i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		long n;
		System.out.print("Nhap n: ");
		n = scanner.nextLong();
		if (isPrimeAlgorithms(n) == true) {
			System.out.println("Nguyen to");
		} else {
			System.out.println("Hop so");
		}
	}
}
