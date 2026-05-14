package com.lacorte.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class URL {

	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	public static LocalDate convertDate(String textDate, LocalDate defaultValue) {
		
		try {
			if (textDate == null || textDate.isBlank()) {
				return defaultValue;
			}
			DateTimeFormatter dtf = DateTimeFormatter
					.ofPattern("yyyy-MM-dd")
					.withZone(ZoneId.of("GMT"));
			return LocalDate.parse(textDate, dtf);	
		
		} catch (Exception e) {
			return defaultValue;
		}
	}
}
