package com.example;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class StudyI18N {

	public static void main(String[] args) {
		String lang = System.getProperty("user.language");
		String fullname = "Jack Bauer";
		Locale locale = new Locale(lang);
		ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
		String msg = bundle.getString("greeting");
		MessageFormat formatter = new MessageFormat(msg, locale);
		System.out.println(formatter.format(new Object[] { fullname }));

	}

}
