package chuong1;

import java.util.Scanner;

public class GCDExtendedEuclidean {
	static Scanner scanner = new Scanner(System.in);

	static ValidateTwoBigLongNumber validateInput(long a, long b) {
		ValidateTwoBigLongNumber result = new ValidateTwoBigLongNumber(a, b);
		while (result.a <= 0) {
			System.out.print("\nXin hay nhap lai a: ");
			result.a = scanner.nextLong();
			if (result.a <= 0) {
				System.out.print("\nPhat hien dau vao khong hop le, xin vui long nhap lai\n");
			}
		}
		while (result.b <= 0) {
			System.out.print("\nXin hay nhap lai b: ");
			result.b = scanner.nextLong();
			if (result.b <= 0) {
				System.out.print("\nPhat hien dau vao khong hop le, xin vui long nhap lai\n");
			}
		}
		return result;
	}

	static long inversion(long a, long p) {
		long u, v, x1, x2, q, r, x, flagCheck;
		flagCheck = 0;
		x = 0;
		u = a;
		v = p;
		x1 = 1;
		x2 = 0;
		while (u != 1) {
			q = (int) Math.ceil(v / u);
			r = v - q * u;
			x = x2 - q * x1;
			v = u;
			u = r;
			x2 = x1;
			x1 = x;
			flagCheck = 1;
		}
		if (flagCheck == 1) {
			while (x < 0) {
				x += p;
			}
		} else {
			while (x < 0) {
				x += a;
			}
		}
		return x;
	}

	static long gcdee(long a, long b) {
		long d, x, y, x1, x2, y1, y2, q, r;
		if (b == 0) {
			d = a;
			x = 1;
			y = 0;
			return d;
		} else {
			x2 = 1;
			x1 = 0;
			y2 = 0;
			y1 = 1;
			while (b > 0) {
				q = (long) Math.ceil(a / b);
				r = a - q * b;
				x = x2 - q * x1;
				y = y2 - q * y1;
				a = b;
				b = r;
				x2 = x1;
				x1 = x;
				y2 = y1;
				y1 = y;
			}
			d = a;
			x = x2;
			y = y2;
		}
		return d;
	}

	public static void main(String[] args) {
		long d, a, b;
		System.out.print("Nhap a: ");
		a = scanner.nextLong();
		System.out.print("Nhap b: ");
		b = scanner.nextLong();
		ValidateTwoBigLongNumber result = new ValidateTwoBigLongNumber(a, b);
		result = validateInput(a, b);
		d = gcdee(result.a, result.b);
		if (d == 1) {
			System.out.println("\n" + result.a + "^-1 mod " + result.b + " = " + inversion(result.a, result.b));
			System.out.println("\n" + result.b + "^-1 mod " + result.a + " = " + inversion(result.b, result.a));
		} else {
			System.out.println("Uoc chung lon nhat cua " + result.a + " va " + result.b + " la: " + d);
		}
	}
}
