package chuong1;

import java.util.Scanner;

public class IntegerSquaring {
	static Scanner scanner = new Scanner(System.in);

	static Validate validateInput(long a, int k, long n) {
		Validate input = new Validate(a, k, n);
		while (input.n <= 0) {
			System.out.print("\nXin hay nhap lai n: ");
			input.n = scanner.nextLong();
			if (input.n <= 0) {
				System.out.print("\nPhat hien dau vao khong hop le, xin vui long nhap lai\n");
			}
		}
		while (input.a <= 0 || input.a >= input.n) {
			System.out.print("\nXin hay nhap lai a: ");
			input.a = scanner.nextLong();
			if (input.a <= 0 || input.a >= input.n) {
				System.out.print("\nPhat hien dau vao khong hop le, xin vui long nhap lai\n");
			}
		}
		while (input.k < 0 || input.k >= input.n) {
			System.out.print("\nXin hay nhap lai k: ");
			input.k = scanner.nextInt();
			if (input.k < 0 || input.k >= input.n) {
				System.out.print("\nPhat hien dau vao khong hop le, xin vui long nhap lai\n");
			}
		}
		return input;
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

	static long algorithmIntegerSquaring(long a, int k, long n) {
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
		System.out.print("\n\n");
		for (i = 1; i < result.number; i++) {
			A = (A * A) % n;
			// System.out.println("A: " + A + ", b: " + b);
			if (result.a[i] == 1) {
				b = (A * b) % n;
			}
		}
		return b;
	}

	public static void main(String[] args) {
		long a, n;
		int k;
		System.out.print("Nhap n: ");
		n = scanner.nextLong();
		System.out.print("Nhap a: ");
		a = scanner.nextLong();
		System.out.print("Nhap k: ");
		k = scanner.nextInt();
		Validate input = new Validate(a, k, n);
		input = validateInput(a, k, n);
		ArrayAndNumber result = new ArrayAndNumber();
		result = decimalToBinary(input.k);
		System.out.print("\nChuoi nhi phan: ");
		result.getArray();
		System.out.println("\n" + input.a + "^" + input.k + " mod " + input.n + " = "
				+ algorithmIntegerSquaring(input.a, input.k, input.n));
	}
}

//Nhap m: 170631
//p: 191, q: 191, n: 36481, phiN: 36100
//e: 3, d: 24067, k: 72201
//Ban ma: 24303
//Giai ma: 1214
