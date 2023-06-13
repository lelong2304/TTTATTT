package chuong1;

import java.util.Scanner;

public class MillerRabinToCheckPrime {
	static Scanner scanner = new Scanner(System.in);

	public static class ArrayAndNumber {
		public int[] a;
		public int number;

		public ArrayAndNumber() {
			this.number = 0;
		}

		public void getArray() {
			int i;
			for (i = 0; i < this.number; i++) {
				System.out.print("" + a[i]);
			}
		}

		public int getNumber() {
			return number;
		}
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

	static long algorithmIntegerSquaring(long a, long k, long n) {
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

	static void millerRabinCheck(long n, long a, int t) {
		long s, r, tempN, y;
		int i, j;
		tempN = n - 1;
		y = 0;
		s = 0;
		while (tempN % 2 == 0) {
			tempN = tempN / 2;
			s++;
		}
		r = tempN;
		for (i = 1; i <= t; i++) {
			y = algorithmIntegerSquaring(a, r, n);
			if (y != 1 && y != n - 1) {
				j = 1;
				while (j <= s - 1 && y != n - 1) {
					y = algorithmIntegerSquaring(y, 2, n);
					if (y == 1) {
						System.out.println("y: " + y);
						System.out.println(n + " la hop so trong vong while");
						return;
					}
					j++;
				}
				if (y != n - 1) {
					System.out.println("y: " + y);
					System.out.println(n + " la hop so ngoai vong while");
					return;
				}
			}
		}
		System.out.println("y: " + y);
		System.out.println(n + " kha nang cao la so nguyen to");
	}

	public static void main(String[] args) {
		long n, a;
		int t;
		System.out.print("Nhap n: ");
		n = scanner.nextLong();
		// System.out.print("Nhap a: ");
		// a = scanner.nextLong();
		a = (int) (Math.random() * (n - 2 - 2 + 1)) + 2;
		System.out.print("Nhap t: ");
		t = scanner.nextInt();
		millerRabinCheck(n, a, t);
	}
}
