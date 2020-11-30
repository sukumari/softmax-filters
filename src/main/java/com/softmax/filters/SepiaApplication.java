package com.softmax.filters;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SepiaApplication {

	public static void main(String[] args) {
		System.out.print(new SepiaApplication().applyFilter());
	}

	private final String filterMessage = "The Sepia filter has been applied.";

	private String applyFilter() {
		return filterMessage;
	}

}
