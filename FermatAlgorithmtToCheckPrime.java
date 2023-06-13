package chuong1;

import java.util.Scanner;

public class FermatAlgorithmtToCheckPrime {
	static Scanner scanner = new Scanner(System.in);

	static class validateFermat {
		long a, t, n;

		public validateFermat(long n, long t) {
			this.t = t;
			this.n = n;
		}

	}

	static validateFermat validate(long n, long t) {
		validateFermat result = new validateFermat(n, t);
		while (result.n < 3) {
			System.out.print("Vui long nhap lai n: ");
			result.n = scanner.nextLong();
		}
		while (result.t < 1) {
			System.out.print("Vui long nhap lai t: ");
			result.t = scanner.nextLong();
		}
		return result;
	}

	static ArrayAndNumber decimalToBinary(long k) {
		long tempK;
		int count;
		tempK = k;
		count = 0;
		while (tempK > 0) {
			tempK = tempK / 2;
			count++;
		}
		ArrayAndNumber result = new ArrayAndNumber();
		result.a = new int[count];
		while (k > 0) {
			result.a[result.number] = (int) (k % 2);
			k = k / 2;
			result.number++;
		}
		return result;
	}

	static long algorithm(long a, int k, long n) {
		ArrayAndNumber result = new ArrayAndNumber();
		result = decimalToBinary(k);
		int k0, i;
		k0 = result.a[0];
		long b, A;
		A = a;
		if (k0 == 0) {
			b = 1;
		} else {
			b = a;
		}
		// System.out.print("\n\n");
		for (i = 1; i < result.number; i++) {
			A = (A * A) % n;
			// System.out.println("A: " + A + ", b: " + b);
			if (result.a[i] == 1) {
				b = (A * b) % n;
			}
		}
		return b;
	}

	static void fermatCheck(long n, long t, long a) {
		int i, flagCheck;
		flagCheck = 1;
		long r;
		for (i = 1; i <= t; i++) {
			r = algorithm(a, (int) (n - 1), n);
			if (r != 1) {
				flagCheck = 0;
			}
		}
		System.out.print("\n");
		if (flagCheck == 0) {
			System.out.println("So a: " + a);
			System.out.println(n + " la hop so");
		} else {
			System.out.println("So a: " + a);
			System.out.println(n + " kha nang cao la so nguyen to");
		}
	}

	public static void main(String[] args) {
		long n, t, a;
		System.out.print("Nhap n: ");
		n = scanner.nextLong();
		System.out.print("Nhap t: ");
		t = scanner.nextLong();
		System.out.print("Nhap a: ");
		a = scanner.nextLong();
		validateFermat result = new validateFermat(n, t);
		// a = (int) (Math.random() * (result.n - 2 - 2 + 1)) + 2;
		validate(result.n, result.t);
		fermatCheck(result.n, result.t, a);
	}
}
