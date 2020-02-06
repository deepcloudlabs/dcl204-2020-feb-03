package com.example.banking.entity;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.MessageFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public final class Bank {
	private final int id;
	private String name;
	private final Map<String, Customer> customers;

	public Bank(int id, String name) {
		this.id = id;
		this.name = name;
		customers = new HashMap<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public List<Customer> getCustomers() {
		return new ArrayList<>(customers.values());
	}

	public Customer createCustomer(String identityNo, String fullName) {
		if (customers.containsKey(identityNo))
			return customers.get(identityNo);
		Customer cust = new Customer(identityNo, fullName);
		customers.put(identityNo, cust);
		return cust;
	}

	public Optional<Customer> removeCustomer(String identityNo) {
		return Optional.ofNullable(customers.remove(identityNo));
	}

	public Customer getCustomer(String identityNo) {
		return customers.get(identityNo);
	}

	public Optional<Customer> getRichestCustomer() {
		return customers.values().stream().sorted(Comparator.comparing(Customer::getBalance).reversed()).findFirst();
	}

	public void generateReport(Locale locale) {
		ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
		String header = bundle.getString("report.header");
		String numOfCustomers = bundle.getString("report.numofcustomers");
		generateReportHeader(locale, header);
		generateCustomerNumbers(locale, numOfCustomers);
		customers.values().forEach(customer -> reportCustomer(customer, locale));
	}

	private void generateReportHeader(Locale locale, String header) {
		MessageFormat formatter = new MessageFormat(header, locale);
		ZonedDateTime now = ZonedDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).withLocale(locale);
		System.out.println(formatter.format(new Object[] { dtf.format(now) }));
	}

	private void generateCustomerNumbers(Locale locale, String msg) {
		MessageFormat formatter = new MessageFormat(msg, locale);
		System.out.println(formatter.format(new Object[] { customers.size() }));
	}

	public static void reportCustomer(Customer cust, Locale locale) {
		DecimalFormat df = (DecimalFormat) DecimalFormat.getCurrencyInstance(locale);
		if (locale.getCountry().equals("TR")) {
			DecimalFormatSymbols dfs = DecimalFormatSymbols.getInstance(locale);
			dfs.setCurrencySymbol("\u20BA");
			df.setDecimalFormatSymbols(dfs);
		}
		System.out.println(String.format("%11s %-16s %-16s", cust.getIdentityNo(), cust.getFullName(),
				df.format(cust.getBalance())));
	}
}
