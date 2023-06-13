package chuong1;

import java.util.Random;
import java.util.Scanner;

public class GeneratePrimeNumbersUsingMillerRabinCheck {

	static class ArrayAndNumber {
		public int[] a;
		public int number;

		public ArrayAndNumber() {
			this.number = 0;
		}

		public void getArray() {
			int i;
			for (i = 0; i < this.number; i++) {
				System.out.print("" + a[i]);
			}
		}

		public int getNumber() {
			return number;
		}
	}

	static Scanner scanner = new Scanner(System.in);

	static class kAndT {
		int k, t;

		public kAndT(int k, int t) {
			this.k = k;
			this.t = t;
		}
	}

	static kAndT validateKAndT(int k, int t) {
		kAndT result = new kAndT(k, t);
		while (result.k <= 0) {
			System.out.print("Xin hay nhap lai k: ");
			result.k = scanner.nextInt();
		}
		while (result.t <= 0) {
			System.out.print("Xin hay nhap lai t: ");
			result.t = scanner.nextInt();
		}
		return result;
	}

	static long[] assginNumbers(long a[], long n) {
		int i;
		for (i = 0; i <= n; i++) {
			a[i] = i;
		}
		return a;
	}

	static long[] realSieve(long a[], long n) {
		int i, j;
		long p;
		p = 2;
		for (i = 0; i <= n; i++) {
			for (j = 0; j <= n; j++) {
				if (a[j] <= p) {
					continue;
				}
				if (a[j] % p == 0) {
					a[j] = 0;
				}
			}
			for (j = 0; j <= n; j++) {
				if (a[j] <= p) {
					continue;
				}
				if (a[j] != 0 && a[j] > p) {
					p = a[j];
					break;
				}
			}
		}
		return a;
	}

	static long checkIfNIsNotAPrime(int k, int t, long B) {
		int flag, i;
		long a[], A;
		flag = 1;
		A = 0;
		while (flag == 1) {
			A = generateKBitNumbers(k);
			a = new long[(int) B + 1];
			assginNumbers(a, B);
			realSieve(a, B);
			for (i = 0; i <= B; i++) {
				if (i == 0 || i == 1 || a[i] == 0) {
					continue;
				}
				if (A % a[i] == 0) {
					break;
				}
				flag = 0;
			}
			if (flag == 0) {
				break;
			}
		}
		return A;
	}

	static long millerRabinCheck(long n, int t) {
		long s, r, tempN, y, a;
		int i, j;
		Random generator = new Random();
		tempN = n - 1;
		y = 0;
		s = 0;
		while (tempN % 2 == 0) {
			tempN = tempN / 2;
			s++;
		}
		r = tempN;
		a = generator.nextLong((n - 2 - 2) + 1) + 2;
		for (i = 1; i <= t; i++) {
			y = algorithmIntegerSquaring(a, r, n);
			if (y != 1 && y != n - 1) {
				j = 1;
				while (j <= s - 1 && y != n - 1) {
					y = algorithmIntegerSquaring(y, 2, n);
					if (y == 1) {
						return y;
					}
					j++;
				}
				if (y != n - 1) {
					return y;
				}
			}
		}
		return y;
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

	static long algorithmIntegerSquaring(long a, long k, long n) {
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
		// System.out.print("\n\n");
		for (i = 1; i < result.number; i++) {
			A = (A * A) % n;
			// System.out.println("A: " + A + ", b: " + b);
			if (result.a[i] == 1) {
				b = (A * b) % n;
			}
		}
		return b;
	}

	static long generateKBitNumbers(int k) {
		long a;
		int i, b[];
		Random generator = new Random();
		a = 0;
		b = new int[k];
		for (i = k - 1; i >= 0; i--) {
			b[i] = generator.nextInt(2);
		}
		for (i = k - 1; i >= 0; i--) {
			a += Math.pow(2, i) * b[i];
		}
		return a;
	}

	public static void main(String[] args) {
		int k, t;
		long resultOfPrime, finalResult, B;
		resultOfPrime = 0;
		System.out.print("Nhap k: ");
		k = scanner.nextInt();
		System.out.print("Nhap t: ");
		t = scanner.nextInt();
		System.out.print("Nhap B: ");
		B = scanner.nextLong();
		kAndT result = new kAndT(k, t);
		result = validateKAndT(k, t);
		while (true) {
			resultOfPrime = checkIfNIsNotAPrime(result.k, result.t, B);
			finalResult = millerRabinCheck(resultOfPrime, result.t);
			if (finalResult == 1 || finalResult == resultOfPrime - 1) {
				break;
			}
		}
		System.out.println("So nguyen to la: " + resultOfPrime);
	}
}
