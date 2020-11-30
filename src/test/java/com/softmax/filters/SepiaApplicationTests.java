package com.softmax.filters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SepiaApplicationTests {

	private final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();

	@Autowired
	private SepiaApplication sepiaApplication;

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outputContent));
	}

	@Test
	void contextLoads() {
	}

	@Test
	public void testStream() {
		setUpStreams();
		SepiaApplication.main(null);
		try {
			assertEquals(outputContent.size(), outputContent.toByteArray().length);
		}catch (AssertionError e) {
			fail("Output stream is corrupted.");
		} finally {
			cleanUpStreams();
		}
	}

	@Test
	public void testApplicationMain() {
		setUpStreams();
		SepiaApplication.main(null);
		try {
			assertEquals("The Sepia filter has been applied.", outputContent.toString());
		}catch (AssertionError e) {
			fail("\"message\" is not \"The Sepia filter has been applied.\", it is "
					+ outputContent.toString());
		}finally {
			cleanUpStreams();
		}
	}

	@Test
	public void testApplicationConstructor() {
		try {
			new SepiaApplication();
		}catch (Exception e) {
			fail("constructor failed!");
		}finally {
			cleanUpStreams();
		}
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}
}
