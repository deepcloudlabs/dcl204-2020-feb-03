package com.example;

import java.text.DecimalFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class StudyDateAndCurrencyFormatter {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ZonedDateTime now = ZonedDateTime.now();
		Locale tr = new Locale("tr");
		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)
				.withLocale(Locale.SIMPLIFIED_CHINESE);
		System.out.println(dtf.format(now));

		double money = 12_345.67;
		DecimalFormat df = (DecimalFormat) DecimalFormat.getCurrencyInstance(Locale.ITALY);
//		DecimalFormatSymbols dfs = DecimalFormatSymbols.getInstance(tr);
//		dfs.setCurrencySymbol("\u20BA");
//		df.setDecimalFormatSymbols(dfs);
		System.out.println(df.format(money));
	}

}
