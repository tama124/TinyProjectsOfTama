package tama.edu.calculator.dateduration;

public class Date {
	private int day;
	private int month;
	private int year;

	public Date() {

	}

	public void setDay(int d) {
		this.day = d;
	}

	public int getDay() {
		return this.day;
	}

	public void setMonth(int m) {
		this.month = m;
	}

	public int getMonth() {
		return this.month;
	}

	public void setYear(int y) {
		this.year = y;
	}

	public int getYear() {
		return this.year;
	}

	public String toString() {
		return String.format("%02d/%02d/%02d", getDay(), getMonth(), getYear());
	}

	public boolean checkDate() {
		int check;
		switch (this.month) {
		case 1:
			check = 31;
			break;
		case 2:
			if ((this.year % 4) == 0) {
				check = 29;
			} else {
				check = 28;
			}
			break;
		case 3:
			check = 31;
			break;
		case 4:
			check = 30;
			break;
		case 5:
			check = 31;
			break;
		case 6:
			check = 30;
			break;
		case 7:
			check = 31;
			break;
		case 8:
			check = 31;
			break;
		case 9:
			check = 30;
			break;
		case 10:
			check = 31;
			break;
		case 11:
			check = 30;
			break;
		case 12:
			check = 31;
			break;
		default:
			check = 0;
			break;
		}
		if ((this.year > 9999) || (this.year < 1) || (this.month < 1)
				|| (this.month > 12) || (this.day < 1) || (this.day > check)) {
			return false;
		} else {
			return true;
		}
	}

	public int getDatetoCompare() {
		int totalDate = 0;
		// year
		for (int i = 1900; i <= this.year; i++) {
			if ((i % 4) == 0) {
				totalDate += 366;
			} else {
				totalDate += 365;
			}
		}
		// month
		for (int i = 1; i <= this.month; i++) {
			switch (i) {
			case 1:
				totalDate += 31;
				break;
			case 2:
				if ((this.year % 4) == 0) {
					totalDate += 29;
				} else {
					totalDate += 28;
				}
				break;
			case 3:
				totalDate += 31;
				break;
			case 4:
				totalDate += 30;
				break;
			case 5:
				totalDate += 31;
				break;
			case 6:
				totalDate += 30;
				break;
			case 7:
				totalDate += 31;
				break;
			case 8:
				totalDate += 31;
				break;
			case 9:
				totalDate += 30;
				break;
			case 10:
				totalDate += 31;
				break;
			case 11:
				totalDate += 30;
				break;
			case 12:
				totalDate += 31;
				break;
			}
		}
		// day
		totalDate += this.day;
		return totalDate;
	}
}
