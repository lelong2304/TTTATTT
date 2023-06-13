package chuong1;

public class UAndV {
	public String U;
	public String V;

	public UAndV() {
		this.U = "";
		this.V = "";
	}

	public String getStringU() {
		return this.U;
	}

	public String getStringV() {
		return this.V;
	}

	public int stringToDecimal(String UOrV) {
		int decimal;
		decimal = Integer.parseInt(UOrV, 2);
		return decimal;
	}
}
