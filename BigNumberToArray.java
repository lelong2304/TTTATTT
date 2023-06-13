package chuong1;

import java.util.Scanner;

public class BigNumberToArray {
	public static Scanner scanner = new Scanner(System.in);

	public static double calculateLogTwo(long a) {
		return Math.log(a) / Math.log(2);
	}

	public static void main(String[] args) {
		int m, W, t, i;
		long p, temp;
		System.out.print("Nhap a: ");
		long a = scanner.nextLong();
		scanner.close();
		W = 8;
		p = 2147483647;
		m = (int) Math.ceil(calculateLogTwo(p));
		t = (int) Math.ceil(((double) m / (double) W));
		System.out.println("\nm: " + m);
		System.out.println("\nt: " + t);
		int[] arr = new int[t];
		temp = a;
		System.out.print("\n");
		for (i = t - 1; i >= 0; i--) {
			arr[i] = ((int) (temp / Math.pow(2, i * W)));
			temp = (long) (temp % Math.pow(2, i * W));
			System.out.println("A[" + i + "]: " + arr[i]);
		}
	}
}
