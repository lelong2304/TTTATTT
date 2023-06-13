package chuong1;

import java.util.Scanner;

public class InversionInFpUsingTheExtendedEuclidean {
	static Scanner scanner = new Scanner(System.in);

	static long validateInput(long a, long p) {
		while (a <= 0 || a >= p) {
			System.out.print("\nXin hay nhap lai a: ");
			a = scanner.nextLong();
			if (a <= 0 || a >= p) {
				System.out.print("\nPhat hien dau vao khong hop le, xin vui long nhap lai\n");
			}
		}
		return a;
	}

	public static void main(String[] args) {
		long a, p, v, x1, x2, q, x, r, result, u;
		System.out.print("Nhap p: ");
		p = scanner.nextInt();
		System.out.print("Nhap a: ");
		a = scanner.nextInt();
		result = validateInput(a, p);
		u = result;
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
		}
		System.out.print("\n" + result + "^-1 mod " + p + " = " + x1);
	}
}
