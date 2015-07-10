package tama.edu.calculator.polynomial;

import java.util.ArrayList;

public class Polynomial {
	ArrayList<Element> polynomial;

	public Polynomial() {
		polynomial = new ArrayList<Element>();
	}

	// 3x^4 + 2x^3 +- 2x^2
	public Polynomial(String s) {
		this();
		s = s.toLowerCase();
		s = s.replace("-", "+-");
		String[] sList = s.split("\\+");
		float heso;
		int somu;
		for (int i = 0; i < sList.length; i++) {
			if (!sList[i].contains("x^")) {
				heso = Float.parseFloat(sList[i].substring(0));
				somu = 1;
			} else {
				heso = Float.parseFloat(sList[i].substring(0,
						sList[i].indexOf("x")));
				somu = Integer.parseInt(sList[i].substring(sList[i]
						.indexOf("^") + 1));
			}
			this.polynomial.add(new Element(heso, somu));
		}
	}

	public void addElement(Element e) {
		boolean flag = false;
		for (Element i : this.polynomial) {
			if (e.getSomu() == i.getSomu()) {
				i.setHeso(i.getHeso() + e.getHeso());
				flag = true;
			}
		}
		if (!flag)
			this.polynomial.add(e);
	}

	public Polynomial tinhDaoHam() {
		Polynomial newPoly = new Polynomial();
		for (Element i : this.polynomial) {
			newPoly.addElement(new Element(i.getHeso() * i.getSomu(), i
					.getSomu() - 1));
		}
		return newPoly;
	}

	public String toString() {
		String s = "";
		for (Element i : polynomial) {
			if (this.polynomial.indexOf(i) == this.polynomial.size() - 1)
				s += i;
			else
				s += i + "+";
		}
		return s;
	}
}
