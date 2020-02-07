package com.example.banking.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Locale;

import com.example.banking.entity.Bank;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class ReadBankFromFile {

	public static void main(String[] args) throws Exception, IOException {
		File file = new File("c:/tmp","garanti.backup");
		try(FileInputStream fis = 
				new FileInputStream(file);
		ObjectInputStream ois = 
				new ObjectInputStream(fis);){
			Bank bank = (Bank) ois.readObject();
			bank.generateReport(Locale.US);
		}
	}

}
