package chuong1;

public class ArrayAndNumber {
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
