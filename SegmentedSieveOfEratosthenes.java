package chuong1;

import java.util.Scanner;

public class SegmentedSieveOfEratosthenes {
	static Scanner scanner = new Scanner(System.in);

	static long[] assginNumbers(long a[], long n) {
		int i;
		for (i = 0; i <= n; i++) {
			a[i] = i;
		}
		return a;
	}

	static long[] advancedSieve(long a[], long n) {
		int count, i, cong;
		long b[], maxInDelta, anotherP, delta, c[], d[];
		b = new long[(int) n + 1];
		c = new long[(int) n + 1];
		d = new long[(int) n + 1];
		assginNumbers(c, n);
		count = 2;
		cong = 0;
		delta = (long) Math.sqrt(n);
		assginNumbers(b, n);
		realSieve(c, delta + 1);
		for (i = 2; i <= delta + 1; i++) {
			maxInDelta = delta * i + 1;
			if (maxInDelta > n) {
				maxInDelta = n;
			}
			anotherP = (long) Math.sqrt(maxInDelta);
			while (count <= anotherP) {
				d[cong] = b[count];
				cong++;
				count++;
			}
			for (int j = (int) (maxInDelta - delta + 1); j <= maxInDelta; j++) {
				for (int k = 0; k < cong; k++) {
					if (c[j] == 0 || d[k] == 0) {
						continue;
					}
					if (c[j] % d[k] == 0) {
						c[j] = 0;
					}
				}
			}
			count = 2;
			cong = 0;
		}
		return c;
	}

	static void getArray(long a[], long n) {
		int i;
		for (i = 0; i <= n; i++) {
			if (a[i] == 0 || i <= 1) {
				continue;
			}
			System.out.print(a[i] + " ");
		}
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

	public static void main(String[] args) {
		long n, a[], c[];
		System.out.print("Nhap n: ");
		n = scanner.nextLong();
		a = new long[(int) n + 1];
		c = new long[(int) n + 1];
		c = advancedSieve(a, n);
		getArray(c, n);
	}
}
