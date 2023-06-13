package chuong1;

import java.util.Scanner;

public class GreatestCommonDivisor {
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

	public static void main(String[] args) {
		long a, b, tempA, tempB;
		System.out.print("Nhap a: ");
		a = scanner.nextInt();
		System.out.print("Nhap b: ");
		b = scanner.nextInt();
		ValidateTwoBigLongNumber result = new ValidateTwoBigLongNumber(a, b);
		result = validateInput(a, b);
		tempA = result.a;
		tempB = result.b;
		while (tempA != tempB) {
			if (tempA > tempB) {
				tempA -= tempB;
			} else {
				tempB -= tempA;
			}
		}
		System.out.println("\nUoc chung lon nhat cua " + result.a + " va " + result.b + " la: " + tempA);
	}
}
