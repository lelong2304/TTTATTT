package chuong1;

public class ResultOfExpression {
	public int c[];
	public int e;

	public ResultOfExpression(int t) {
		c = new int[t];
	}

	public void getArray(int t) {
		int i;
		System.out.print("\n");
		for (i = 0; i < t; i++) {
			System.out.print("Gia tri c[" + i + "] moi: " + c[i]);
			System.out.print("\n");
		}
	}

	public int getE() {
		System.out.print("\n");
		return e;
	}
}
