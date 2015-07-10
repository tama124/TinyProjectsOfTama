package tama.edu.calculator.rational;

public class RationalCalculator {
	public static void main(String args[]) {
		Rational r1 = new Rational(4, 16);
		Rational r2 = new Rational(5, 6);
		System.out.println(r1);
		System.out.println(r2);
		Rational tong = r1.cong(r2);
		Rational tru = r1.tru(r2);
		Rational nhan = r1.nhan(r2);
		Rational chia = r1.chia(r2);
		System.out.println("Tong: " + tong);
		System.out.println("Hieu: " + tru);
		System.out.println("Tich: " + nhan);
		System.out.println("Thuong: " + chia);
	}
}