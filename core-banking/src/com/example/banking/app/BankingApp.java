package com.example.banking.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Locale;

import com.example.banking.entity.Account;
import com.example.banking.entity.Bank;
import com.example.banking.entity.Customer;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class BankingApp {
	public static void main(String[] args) throws IOException {
		Bank garanti = new Bank(1, "Garanti");
		Customer jack = garanti.createCustomer("12345678910", "Jack Shephard");
		jack.addAccount(new Account("TR2", 2_000));
		jack.addAccount(new Account("TR3", 3_000));
		jack.addAccount(new Account("TR4", 4_000));
		Customer kate = garanti.createCustomer("10987654321", "Kate Austen");
		kate.addAccount(new Account("TR5", 5_000));
		kate.addAccount(new Account("TR6", 6_000));
		kate.addAccount(new Account("TR7", 7_000));
		Locale tr = new Locale("TR", "tr");
		File file = new File("c:/tmp","garanti.backup");
		try(FileOutputStream fos = 
				new FileOutputStream(file);
		ObjectOutputStream oos = 
				new ObjectOutputStream(fos);){
			oos.writeObject(garanti);			
		}
		System.out.println("Bank is saved to disk!");
		
	}
}
