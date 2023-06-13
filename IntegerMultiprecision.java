package chuong1;

import java.util.Scanner;

public class IntegerMultiprecision {
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

	static UAndV toBinary(int decimal) {
		int W;
		W = 8;
		int[] binary = new int[2 * W];
		UAndV stringUAndV = new UAndV();
		int index = 0, temp, i;
		temp = decimal;
		for (i = 0; i < 2 * W; i++) {
			binary[i] = 0;
		}
		while (temp > 0) {
			binary[index++] = temp % 2;
			temp /= 2;
		}
		for (i = 2 * W - 1; i >= 0; i--) {
			System.out.print(binary[i]);
			if (i >= 8) {
				stringUAndV.U += binary[i];
			} else {
				stringUAndV.V += binary[i];
			}
			if (i % 8 == 0) {
				System.out.print(" ");
			}
		}
		return stringUAndV;
	}

	static int[] IntergerMultiprecisionImplement(long a, long b) {
		long p;
		int W, m, t, i, U, UV, j, V;
		String tempU, tempV;
		UAndV stringUAndV = new UAndV();
		p = 2147483647;
		W = 8;
		m = (int) Math.ceil(calculateLogTwo(p));
		t = (int) Math.ceil(((double) m / (double) W));
		int[] C = new int[t * 2];
		int A[] = numberToArray(a, p);
		int B[] = numberToArray(b, p);
		System.out.print("\n");
		for (i = 0; i < t; i++) {
			C[i] = 0;
		}
		for (i = 0; i < t; i++) {
			U = 0;
			for (j = 0; j < t; j++) {
				UV = C[i + j] + A[i] * B[j] + U;
				stringUAndV = toBinary(UV);
				tempU = stringUAndV.getStringU();
				tempV = stringUAndV.getStringV();
				U = stringUAndV.stringToDecimal(tempU);
				V = stringUAndV.stringToDecimal(tempV);
				C[i + j] = V;
			}
			System.out.print("\n");
			C[i + t] = U;
		}
		return C;
	}

	static void printC(int a[]) {
		int i;
		System.out.print("\n");
		for (i = 0; i < 8; i++) {
			System.out.println("C[" + i + "]:" + a[i]);
		}
	}

	public static void main(String[] args) {
		long a, b, p;
		int W, m, t;
		W = 8;
		p = 2147483647;
		m = (int) Math.ceil(calculateLogTwo(p));
		t = (int) Math.ceil(((double) m / (double) W));
		int[] C = new int[t * 2];
		System.out.print("Nhap a: ");
		a = scanner.nextLong();
		System.out.print("Nhap b: ");
		b = scanner.nextLong();
		C = IntergerMultiprecisionImplement(a, b);
		printC(C);
		System.out.println(arrayToNumber(C, p));
	}
}
