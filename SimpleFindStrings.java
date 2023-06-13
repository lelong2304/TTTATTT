package chuong1;

import java.util.Scanner;

public class SimpleFindStrings {
	static Scanner scanner = new Scanner(System.in);

	public static boolean findString(String str, String subStr) {
		char[] tempStr;
		char[] tempSubStr;
		int i, count, j;
		count = 0;
		j = 0;
		tempStr = str.toCharArray();
		tempSubStr = subStr.toCharArray();
		for (i = 0; i < tempStr.length; i++) {
			if (tempStr[i] == tempSubStr[j]) {
				count++;
				j++;
				if (j == tempSubStr.length) {
					break;
				}
			} else {
				count = 0;
				j = 0;
			}
		}
		if (count == tempSubStr.length) {
			System.out.println(i - count + 1);
			return true;
		}
		return false;
	}

// abacaabadcabacabaabb
// abacab

// a pattern matching algorithm
// rithm
	public static void main(String[] args) {
		String str, subStr;
		System.out.print("Nhap chuoi:");
		str = scanner.nextLine();
		System.out.print("Nhap chuoi con:");
		subStr = scanner.nextLine();
		if (findString(str, subStr) == false) {
			System.out.println("-1");
		}
		System.out.println("Ket qua dung ham he thong");
		System.out.println(str.indexOf(subStr));
	}
}
