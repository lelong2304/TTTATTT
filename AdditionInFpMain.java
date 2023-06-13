package chuong1;

import java.util.Scanner;

public class AdditionInFpMain {
	static Scanner scanner = new Scanner(System.in);

	public static double calculateLogTwo(long a) {
		return Math.log(a) / Math.log(2);
	}

	static long arrayToNumber(int a[], long p) {
		long b = 0;
		int i, t, W, m;
		W = 8;
		m = (int) Math.ceil(calculateLogTwo(p));
		t = (int) Math.ceil(((double) m / (double) W));
		for (i = t - 1; i >= 0; i--) {
			b = (long) (b + (a[i] * Math.pow(2, i * W)));
		}
		return b;
	}

	static int[] numberToArray(long a, long p) {
		int i, t, W, m;
		long temp;
		W = 8;
		m = (int) Math.ceil(calculateLogTwo(p));
		t = (int) Math.ceil(((double) m / (double) W));
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

	static int[] printMatrix(long bigNumber) {
		int m, W, t, i;
		W = 8;
		m = (int) Math.ceil(calculateLogTwo(bigNumber));
		t = (int) Math.ceil(((double) m / (double) W));
		int[] arr = new int[t];
		System.out.print("\n");
		for (i = t - 1; i >= 0; i--) {
			arr[i] = ((int) (bigNumber / Math.pow(2, i * W)));
			bigNumber = (long) (bigNumber % Math.pow(2, i * W));
			System.out.println("A[" + i + "]: " + arr[i]);
		}
		return arr;
	}

	static ResultOfExpression MultiprecisionAddition(int a[], int b[], long p) {
		int i, W, t, m;
		W = 8;
		m = (int) Math.ceil(calculateLogTwo(p));
		t = (int) Math.ceil(((double) m / (double) W));
		ResultOfExpression eAndC = new ResultOfExpression(t);
		eAndC.e = 0;
		for (i = 0; i < t; i++) {
			eAndC.c[i] = a[i] + b[i];
		}
		for (i = 0; i < t; i++) {
			if (eAndC.c[i] >= Math.pow(2, W)) {
				eAndC.e = 1;
				eAndC.c[i] = (int) (eAndC.c[i] % Math.pow(2, W));
				if (i == t - 1) {
					break;
				}
				eAndC.c[i + 1] += eAndC.e;
			} else {
				eAndC.e = 0;
			}
		}
		return eAndC;
	}

	static ResultOfExpression MultiprecisionSubtraction(int a[], int b[], long p) {
		int i, W, t, m;
		W = 8;
		m = (int) Math.ceil(calculateLogTwo(p));
		t = (int) Math.ceil(((double) m / (double) W));
		ResultOfExpression eAndC = new ResultOfExpression(t);
		eAndC.e = 0;
		for (i = 0; i < t; i++) {
			eAndC.c[i] = a[i] - b[i];
		}
		for (i = 0; i < t; i++) {
			if (eAndC.c[i] < 0) {
				eAndC.e = 1;
				eAndC.c[i] += Math.pow(2, W);
				if (i == t - 1) {
					break;
				}
				eAndC.c[i + 1] -= eAndC.e;
			} else {
				eAndC.e = 0;
			}
		}
		return eAndC;
	}

	static ResultOfExpression AdditionInFp(long p, long a, long b) {
		int W, t, m;
		W = 8;
		m = (int) Math.ceil(calculateLogTwo(p));
		t = (int) Math.ceil(((double) m / (double) W));
		ResultOfExpression eAndC = new ResultOfExpression(t);
		ResultOfExpression eAndCSubtraction = new ResultOfExpression(t);
		eAndC = MultiprecisionAddition(numberToArray(a, p), numberToArray(b, p), p);
		if (eAndC.e == 1) {
			eAndCSubtraction = MultiprecisionSubtraction(eAndC.c, numberToArray(p, p), p);
		} else {
			if (arrayToNumber(eAndC.c, p) >= p) {
				eAndCSubtraction = MultiprecisionSubtraction(eAndC.c, numberToArray(p, p), p);
			} else {
				return eAndC;
			}
		}
		return eAndCSubtraction;
	}

	public static void main(String[] args) {
		long p, a, b;
		int t = 4;
		int[] A = new int[t];
		int[] B = new int[t];
		ResultOfExpression eAndC = new ResultOfExpression(t);
		ResultOfExpression eAndCSubtraction = new ResultOfExpression(t);
		System.out.print("Nhap p: ");
		p = scanner.nextLong();
		System.out.print("Nhap a: ");
		a = scanner.nextLong();
		System.out.print("Nhap b: ");
		b = scanner.nextLong();
		printMatrix(p);
		A = numberToArray(a, p);
		B = numberToArray(b, p);
		eAndC = MultiprecisionAddition(A, B, p);
		System.out.println("\nKet qua cong chinh xac boi: ");
		eAndC.getArray(t);
		System.out.println("E la: " + eAndC.getE());
		eAndCSubtraction = AdditionInFp(p, a, b);
		System.out.println("\nKet qua sau khi cong tren truong Fp: ");
		eAndCSubtraction.getArray(t);
		System.out.println("E la: " + eAndCSubtraction.getE());
		System.out.println("\nKet qua tren truong P: " + arrayToNumber(eAndCSubtraction.c, p));
	}

}
