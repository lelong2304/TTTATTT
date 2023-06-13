package chuong1;

import java.util.Scanner;

public class test {
	static Scanner scanner = new Scanner(System.in);

	static UAndV toBinary(int decimal) {
		int[] binary = new int[16];
		UAndV stringUAndV = new UAndV();
		int index = 0, temp, i;
		temp = decimal;
		for (i = 0; i < 16; i++) {
			binary[i] = 0;
		}
		while (temp > 0) {
			binary[index++] = temp % 2;
			temp /= 2;
		}
		for (i = 16 - 1; i >= 0; i--) {
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

	public static void main(String[] args) {
		UAndV stringUAndV = new UAndV();
		int a = 15872;
		String U, V;
		int u, v;
		stringUAndV = toBinary(a);
		System.out.print("\n");
		U = stringUAndV.getStringU();
		V = stringUAndV.getStringV();
//		u = stringUAndV.stringToDecimal(U);
//		v = stringUAndV.stringToDecimal(V);
//		System.out.println("u: " + u + ", v: " + v);
	}
}
