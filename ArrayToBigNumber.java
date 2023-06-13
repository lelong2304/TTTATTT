package chuong1;

import java.util.Scanner;

public class ArrayToBigNumber {
	public static Scanner scanner = new Scanner(System.in);

	public static double calculateLogTwo(long a) {
		return Math.log(a) / Math.log(2);
	}

	public static void main(String[] args) {
		int m, W, t, i;
		long p, a;
		a = 0;
		W = 8;
		p = 2147483647;
		m = (int) Math.ceil(calculateLogTwo(p));
		t = (int) Math.ceil(((double) m / (double) W));
		System.out.println("m: " + m);
		System.out.println("\nt: " + t);
		int[] arr = new int[t];
		for (i = 0; i < t; i++) {
			System.out.print("\nGia tri mang[" + i + "]: ");
			arr[i] = scanner.nextInt();
		}
		for (i = t - 1; i >= 0; i--) {
			a = (long) (a + (arr[i] * Math.pow(2, i * W)));
		}
		System.out.println("\nSo a la: " + a);
	}
}
//Gia tri c[0] moi: 250
//Gia tri c[1] moi: 255
//Gia tri c[2] moi: 255
//Gia tri c[3] moi: 127