package tama.edu.ioprocessor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

import tama.edu.calculator.dateduration.Date;

public class IoProcessor {

	public static void main(String[] args) throws Exception {
		String inputFile = "file_path_to_input_here";
		String outputFile = "file_path_to_output_here";
		createTextFile(outputFile);
		sumOfIntegers(outputFile);
		createBinaryFile(outputFile);
		convertFile(inputFile, outputFile);
		encryptFile(inputFile, outputFile);
		decryptFile(inputFile, outputFile);
		readObject(outputFile);
		writeObject(outputFile);
	}

	private static void encryptFile(String inputFile, String outputFile)
			throws Exception {
		FileInputStream inputStream = new FileInputStream(inputFile);
		FileOutputStream outputStream = new FileOutputStream(outputFile);
		int data;
		while ((data = inputStream.read()) != -1) {
			outputStream.write(data + 5);
		}
		inputStream.close();
		outputStream.close();
	}

	private static void decryptFile(String inputFile, String outputFile)
			throws Exception {
		FileInputStream inputStream = new FileInputStream(inputFile);
		FileOutputStream outputStream = new FileOutputStream(outputFile);
		int data;
		while ((data = inputStream.read()) != -1) {
			outputStream.write(data - 5);
		}
		inputStream.close();
		outputStream.close();
	}

	private static void convertFile(String inputFile, String outputFile)
			throws Exception {
		File file = new File(inputFile);
		Scanner scn = new Scanner(new FileInputStream(file), "UTF-8");
		DataOutputStream outputStream = new DataOutputStream(
				new FileOutputStream(new File(outputFile)));
		while (scn.hasNextLine()) {
			outputStream.writeUTF(scn.next());
		}
		scn.close();
		outputStream.close();
	}

	private static void sumOfIntegers(String outputFile) throws Exception {
		File file = new File(outputFile);
		int sum = 0;
		DataInputStream inputStream = new DataInputStream(new FileInputStream(
				file));
		while (inputStream.read() != -1) {
			sum += inputStream.read();
		}
		System.out.println(sum);
		inputStream.close();
	}

	private static void createBinaryFile(String outputFile) throws Exception {
		File file = new File(outputFile);
		DataOutputStream outputStream = new DataOutputStream(
				new FileOutputStream(file));
		for (int i = 1; i <= 100; i++) {
			Random rand = new Random();
			outputStream.writeByte(rand.nextInt());
		}
		outputStream.close();
	}

	private static void createTextFile(String outputFile) throws Exception {
		File file = new File(outputFile);
		PrintWriter outputStream = new PrintWriter(new FileOutputStream(file),
				false);
		Random rand = new Random();
		for (int i = 1; i <= 100; i++) {
			outputStream.write("" + rand.nextInt() + " ");
		}
		outputStream.close();
	}

	private static void writeObject(String outputFile) throws Exception {
		File file = new File(outputFile);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				file));
		Date date = new Date(1, 7, 1993);
		Date date2 = new Date(1, 7, 2015);
		oos.writeObject(date);
		oos.writeObject(date2);
		oos.close();
	}

	private static void readObject(String outputFile) throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
				new File(outputFile)));
		Date date = new Date(1, 7, 1993);
		Date date2 = new Date(1, 7, 2015);
		System.out.println(date);
		System.out.println(date2);
		ois.close();
	}
}
