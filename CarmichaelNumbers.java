package chuong1;

import java.util.Scanner;

public class CarmichaelNumbers {
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

	static int CarmichaelCheck(long n) {
		int i, flag1, flag2, count;
		long a[];
		flag1 = 1;
		flag2 = 1;
		count = 0;
		for (i = 3; i < n; i += 2) {
			if (n % i == 0) {
				return 0;
			}
		}
		a = new long[(int) (n + 1)];
		assginNumbers(a, n);
		realSieve(a, n);
		for (i = 0; i <= n; i++) {
			if (i == 0 || i == 1 || a[i] == 0) {
				continue;
			}
			if (n % (a[i] * a[i]) == 0) {
				flag1 = 0;
			}
		}
		for (i = 0; i <= n; i++) {
			if (i == 0 || i == 1 || a[i] == 0) {
				continue;
			}
			if (n % a[i] == 0) {
				if ((n - 1) % (a[i] - 1) == 0) {
					flag2 = 1;
					count++;
				} else {
					flag2 = 0;
				}
			} else {
				continue;
			}
		}
		if (flag1 == 1 && flag2 == 1 && count >= 3) {
			return 1;
		} else {
			return 0;
		}
	}

// n - 1 chia hết cho p - 1 với mọi ước p của n
	// 560 chia

	public static void main(String[] args) {
		long n, i;
		System.out.print("Nhap n: ");
		n = scanner.nextLong();
//		if (CarmichaelCheck(n) == 1) {
//			System.out.println("Dung");
//		} else {
//			System.out.println("Sai");
//		}
		for (i = 2; i <= n; i++) {
			if (i % 2 == 0) {
				continue;
			}
			if (CarmichaelCheck(i) == 1) {
				System.out.println("Dung " + i);
			}
		}
	}
}
