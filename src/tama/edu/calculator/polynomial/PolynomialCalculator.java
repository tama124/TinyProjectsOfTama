package tama.edu.calculator.polynomial;

public class PolynomialCalculator {
	public static void main(String[] args) {
		Polynomial p = new Polynomial("3x^4+2x^3-2x^2+5");
		System.out.println(p);
		System.out.println(p.tinhDaoHam());
	}
}
