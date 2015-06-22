package tama.edu.calculator.dateduration;

import java.util.Scanner;

public class DateDurationCalculator {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your first date:");
		Date date1 = new Date();
		do {
			System.out.println("Day:");
			date1.setDay(scan.nextInt());
			System.out.println("Month:");
			date1.setMonth(scan.nextInt());
			System.out.println("Year:");
			date1.setYear(scan.nextInt());
			if (date1.checkDate() == false) {
				System.out
						.println("You must enter the valid date (01/01/1900 - 31/12/9999)!");
				System.out.println("Please enter your date again!");
			}
		} while (date1.checkDate() == false);
		System.out.println("Enter your second date:");
		Date date2 = new Date();
		do {
			System.out.println("Day:");
			date2.setDay(scan.nextInt());
			System.out.println("Month:");
			date2.setMonth(scan.nextInt());
			System.out.println("Year:");
			date2.setYear(scan.nextInt());
			System.out.println();
			if (date2.checkDate() == false) {
				System.out
						.println("You must enter the valid date (01/01/1900 - 31/12/9999)!");
				System.out.println("Please enter your date again!");
			}
		} while (date2.checkDate() == false);
		System.out.println("Duration between your two date: "
				+ Math.abs(date1.getDatetoCompare() - date2.getDatetoCompare())
				+ " days.");
		scan.close();

	}

}
