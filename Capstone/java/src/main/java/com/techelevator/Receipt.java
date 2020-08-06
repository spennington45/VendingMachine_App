package com.techelevator;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Receipt {
	public static void main(String[] args) throws IOException {
		
		String receipt = "Reciept";
		String word = "";
		File receiptFile = new File(receipt);
		if (receiptFile.exists() == false) {
			receiptFile.createNewFile();
		}
		
		try (PrintWriter writer = new PrintWriter(receiptFile)) {
		
	}
	}
}
