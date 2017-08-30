package com.mastering.generics.chapter2;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SubtypingAndWildcardsTest {

	/**
	 * In this example we have both 2 and 3.14 being a Number, or in other words, the are subtypes of Number
	 */
	@Test
	public void shouldAddNumbers() throws Exception {
		List<Number> numbers = new ArrayList<>();
		numbers.add(2);
		numbers.add(3.14);
		
		assertThat(numbers.get(0), equalTo(2));
		assertThat(numbers.get(1), equalTo(3.14));
	}
	
	@Test
	public void shouldAddAllNumbers() throws Exception {
		List<Number> numbers = new ArrayList<>();
		List<Integer> ints = Arrays.asList(1, 4);
		List<Double> doubles = Arrays.asList(2.3, 8.9);
		
		numbers.addAll(ints);
		numbers.addAll(doubles);
		
		assertThat(numbers.get(0), equalTo(1));
		assertThat(numbers.get(1), equalTo(4));
		assertThat(numbers.get(2), equalTo(2.3));
		assertThat(numbers.get(3), equalTo(8.9));
	}
	
	@Test
	public void shouldUseIntegerListInTheListOfNumbers() throws Exception {
		List<Integer> integers = new ArrayList<>();
		integers.add(1);
		integers.add(2);
		@SuppressWarnings("unused")
		List<? extends Number> numbers = integers;
//		numbers.add(3); This will not compile
	}
}
