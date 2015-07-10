package tama.edu.calculator.rational;

public class Rational {
	private int tuso;

	public void setTuso(int tuso) {
		this.tuso = tuso;
	}

	public int getTuso() {
		return this.tuso;
	}

	private int mauso;

	public void setMauso(int mauso) {
		if (mauso == 0)
			throw new RuntimeException("Mau so khong duoc bang 0!!!");
		this.mauso = mauso;
	}

	public int getMauso() {
		return this.mauso;
	}

	public Rational(int tuso, int mauso) {
		setTuso(tuso);
		setMauso(mauso);
	}

	public Rational cong(Rational rational_2) {
		int newMauso = this.mauso * rational_2.mauso;
		int newTuso = this.tuso * rational_2.mauso + rational_2.tuso
				* this.mauso;
		return new Rational(newTuso, newMauso);
	}

	public Rational tru(Rational rational_2) {
		int newMauso = this.mauso * rational_2.mauso;
		int newTuso = this.tuso * rational_2.mauso - rational_2.tuso
				* this.mauso;
		return new Rational(newTuso, newMauso);
	}

	public Rational nhan(Rational rational_2) {
		int newMauso = this.mauso * rational_2.mauso;
		int newTuso = this.tuso * rational_2.tuso;
		return new Rational(newTuso, newMauso);
	}

	public Rational chia(Rational rational_2) {
		int newMauso = this.mauso * rational_2.tuso;
		int newTuso = this.tuso * rational_2.mauso;
		return new Rational(newTuso, newMauso);
	}

	public Rational rutGon(Rational rational) {
		int UCLN = UCLN(rational.tuso, rational.mauso);
		int newMauso = rational.mauso / UCLN;
		int newTuso = rational.tuso / UCLN;
		return new Rational(newTuso, newMauso);
	}

	private int UCLN(int a, int b) {
		if (a >= b)
			return Euclid(a, b);
		else
			return Euclid(b, a);
	}

	private int Euclid(int a, int b) {
		int c;
		c = a;
		a = b;
		b = c;
		while (b != 0) {
			c = b;
			b = a % b;
			a = c;
		}
		return c;
	}

	public String toString() {
		Rational r = this.rutGon(this);
		if (r.tuso == r.mauso) {
			return String.format("%d", r.getTuso());
		} else {
			if (r.mauso < 0) {
				return String.format("%d / %d", 0 - r.getTuso(),
						0 - r.getMauso());
			} else {
				return String.format("%d / %d", r.getTuso(), r.getMauso());
			}
		}
	}
}
