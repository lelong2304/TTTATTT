package chuong1;

import java.util.Scanner;

public class PollardsRho {

	static Scanner scanner = new Scanner(System.in);

	static long gcd(long aSubtractB, long n) {
		long r = 0;
		while (n > 0) {
			r = aSubtractB % n;
			if (r < 0) {
				r += n;
			}
			aSubtractB = n;
			n = r;
		}
		return aSubtractB;
	}

	public static long algorithmPollardsRho(long n, long c) {
		long a, b, i, d;
		a = 2;
		b = 2;
		for (i = 1;; i++) {
			a = (a * a + c) % n;
			b = (b * b + c) % n;
			b = (b * b + c) % n;
			d = gcd(a - b, n);
			System.out.println("Lan thu i: " + i);
			if (d > 1 && d < n) {
				System.out.print("Successed d: " + d);
				break;
			}
			if (d == n) {
				System.out.print("Failed d: " + d);
				break;
			}
		}
		return d;
	}

	public static void main(String[] args) {
		long n, c;
		System.out.print("Nhap n: ");
		n = scanner.nextLong();
		System.out.print("Nhap c: ");
		c = scanner.nextLong();
		algorithmPollardsRho(n, c);
	}
}
