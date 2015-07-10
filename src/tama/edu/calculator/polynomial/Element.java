package tama.edu.calculator.polynomial;

public class Element {
	private float heso;

	public void setHeso(float heso) {
		this.heso = heso;
	}

	public float getHeso() {
		return this.heso;
	}

	private int somu;

	public void setSomu(int somu) {
		this.somu = somu;
	}

	public int getSomu() {
		return this.somu;
	}

	public Element(float heso, int somu) {
		setHeso(heso);
		setSomu(somu);
	}

	public String toString() {
		return this.getHeso() + "x^" + this.getSomu();
	}
}
