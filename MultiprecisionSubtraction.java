package chuong1;

import java.util.Scanner;

public class MultiprecisionSubtraction {
	public static Scanner scanner = new Scanner(System.in);

	public static double calculateLogTwo(long a) {
		return Math.log(a) / Math.log(2);
	}

	static int[] numberToArray(long a) {
		int i, t, W;
		long temp;
		W = 8;
		t = 4;
		int[] arr = new int[t];
		temp = a;
		System.out.print("\n");
		for (i = t - 1; i >= 0; i--) {
			arr[i] = ((int) (temp / Math.pow(2, i * W)));
			temp = (long) (temp % Math.pow(2, i * W));
			System.out.println("A[" + i + "]: " + arr[i]);
		}
		return arr;
	}

	static long arrayToNumber(int a[]) {
		long b = 0;
		int i, t, W;
		W = 8;
		t = 4;
		for (i = t - 1; i >= 0; i--) {
			b = (long) (b + (a[i] * Math.pow(2, i * W)));
		}
		return b;
	}

	public static void main(String[] args) {
		int m, W, t, i, e;
		long p, a, b;
		W = 8;
		p = 2147483647;
		m = (int) Math.ceil(calculateLogTwo(p));
		t = (int) Math.ceil(((double) m / (double) W));
		e = 0;
		System.out.print("Nhap so a: ");
		a = scanner.nextLong();
		System.out.print("Nhap so b: ");
		b = scanner.nextLong();
		int[] A = new int[t];
		int[] B = new int[t];
		int[] c = new int[t];
		A = numberToArray(a);
		B = numberToArray(b);
		System.out.print("\n");
		for (i = 0; i < t; i++) {
			c[i] = A[i] - B[i];
			System.out.print("Gia tri c[" + i + "]: " + c[i]);
			System.out.print("\n");
		}
		System.out.print("\n");
		for (i = 0; i < t; i++) {
			if (c[i] < 0) {
				e = 1;
				c[i] += Math.pow(2, W);
				if (i == t - 1) {
					break;
				}
				c[i + 1] -= e;
			} else {
				e = 0;
			}
		}
		for (i = 0; i < t; i++) {
			System.out.print("Gia tri c[" + i + "] moi: " + c[i]);
			System.out.print("\n");
		}
		System.out.println("Gia tri cua e: " + e);
		System.out.println("\nArray to big number A: " + arrayToNumber(A));
		System.out.println("\nArray to big number B: " + arrayToNumber(B));
		System.out.println("\nArray to big number C: " + arrayToNumber(c));

	}
}
