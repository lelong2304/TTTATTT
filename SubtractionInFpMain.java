package chuong1;

import java.util.Scanner;

public class SubtractionInFpMain {
	static Scanner scanner = new Scanner(System.in);

	public static double calculateLogTwo(long a) {
		return Math.log(a) / Math.log(2);
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

	static int[] numberToArray(long a, long p) {
		long temp;
		int i, W, t, m;
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

	static long arrayToNumber(int a[], long p) {
		long b = 0;
		int i, W, t, m;
		W = 8;
		m = (int) Math.ceil(calculateLogTwo(p));
		t = (int) Math.ceil(((double) m / (double) W));
		for (i = t - 1; i >= 0; i--) {
			b = (long) (b + (a[i] * Math.pow(2, i * W)));
		}
		return b;
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

	static ResultOfExpression SubtractionInFp(long p, long a, long b) {
		int W, t, m;
		W = 8;
		m = (int) Math.ceil(calculateLogTwo(p));
		t = (int) Math.ceil(((double) m / (double) W));
		ResultOfExpression eAndC = new ResultOfExpression(t);
		ResultOfExpression eAndCMoi = new ResultOfExpression(t);
		eAndC = MultiprecisionSubtraction(numberToArray(a, p), numberToArray(b, p), p);
		if (eAndC.e == 1) {
			eAndCMoi = MultiprecisionAddition(eAndC.c, numberToArray(p, p), p);
			return eAndCMoi;
		}
		return eAndC;
	}

	public static void main(String[] args) {
		long p, a, b;
		int W, t, m;
		W = 8;
		System.out.print("Nhap so p: ");
		p = scanner.nextLong();
		System.out.print("Nhap so a: ");
		a = scanner.nextLong();
		System.out.print("Nhap so b: ");
		b = scanner.nextLong();
		m = (int) Math.ceil(calculateLogTwo(p));
		t = (int) Math.ceil(((double) m / (double) W));
		ResultOfExpression eAndC = new ResultOfExpression(t);
		eAndC = MultiprecisionSubtraction(numberToArray(a, p), numberToArray(b, p), p);
		eAndC.getArray(t);
		System.out.println("Gia tri cua e la: " + eAndC.getE());
		ResultOfExpression eAndCInSubstraction = new ResultOfExpression(t);
		eAndCInSubstraction = SubtractionInFp(p, a, b);
		eAndCInSubstraction.getArray(t);
		System.out.println("E la: " + eAndCInSubstraction.getE());
		System.out.println("\nKet qua tren truong P: " + arrayToNumber(eAndCInSubstraction.c, p));
	}
}
