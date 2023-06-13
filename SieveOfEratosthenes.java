package chuong1;

import java.util.Scanner;

public class SieveOfEratosthenes {
	static Scanner scanner = new Scanner(System.in);

	static long[] assginNumbers(long a[], long n) {
		int i;
		for (i = 0; i <= n; i++) {
			a[i] = i;
		}
		return a;
	}

	static long[] realSieve(long a[], long n) {
		int i, j;
		long p;
		p = 2;
		for (i = 0; i <= n; i++) {
			for (j = 0; j <= n; j++) {
				if (a[j] <= p) {
					continue;
				}
				if (a[j] % p == 0) {
					a[j] = 0;
				}
			}
			for (j = 0; j <= n; j++) {
				if (a[j] <= p) {
					continue;
				}
				if (a[j] != 0 && a[j] > p) {
					p = a[j];
					break;
				}
			}
		}
		return a;
	}

	static void getArray(long a[], long n) {
		int i;
		for (i = 0; i <= n; i++) {
			if (a[i] == 0 || i <= 1) {
				continue;
			}
			System.out.println(a[i] + " ");
		}
	}

	public static void main(String[] args) {
		long n, a[];
		System.out.print("Nhap n: ");
		n = scanner.nextLong();
		a = new long[(int) n + 1];
		assginNumbers(a, n);
		realSieve(a, n);
		getArray(a, n);
	}
}
