package java8.exercises;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

public class InMemoryExecises {

	private static List<String> wordList = Arrays.asList("every", "problem",
			"in", "computer", "science", "can", "be", "solved", "by", "adding",
			"another", "level", "of", "indirection");
	// Butler Lampson
	private ByteArrayOutputStream out = new ByteArrayOutputStream();
	private PrintStream s = new PrintStream(out);

	@Before
	public void setUp() {
		out = new ByteArrayOutputStream();
		s = new PrintStream(out);
	}

	// Exercise 1: Print out all the words in wordList, which is
	// a static List<String> defined at the top of this file.
	@Test
	public void printAllWordsV1() {
		wordList.forEach(word -> s.println(word));

		assertEquals("every\nproblem\nin\ncomputer\nscience\n"
				+ "can\nbe\nsolved\nby\nadding\nanother\n"
				+ "level\nof\nindirection\n", out.toString());
	}

	@Test
	public void printAllWordsV2() {
		wordList.forEach(s::println);

		assertEquals("every\nproblem\nin\ncomputer\nscience\n"
				+ "can\nbe\nsolved\nby\nadding\nanother\n"
				+ "level\nof\nindirection\n", out.toString());
	}

	// Exercise 2: Convert all words in wordList to upper case,
	// and gather the result into an output list.

	@Test
	public void upperCaseWords() {
		List<String> output = wordList.stream().map(String::toUpperCase)
				.collect(Collectors.toList());

		assertEquals(Arrays.asList("EVERY", "PROBLEM", "IN", "COMPUTER",
				"SCIENCE", "CAN", "BE", "SOLVED", "BY", "ADDING", "ANOTHER",
				"LEVEL", "OF", "INDIRECTION"), output);
	}

	// Exercise 3: Find all the words in wordList that have even length
	// and put them into an output list.

	@Test
	public void findEvenLengthWords() {
		List<String> output = wordList.stream()
				.filter(w -> (w.length() % 2) == 0)
				.collect(Collectors.toList());

		assertEquals(Arrays.asList("in", "computer", "be", "solved", "by",
				"adding", "of"), output);
	}
}
