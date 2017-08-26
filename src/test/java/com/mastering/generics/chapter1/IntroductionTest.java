package com.mastering.generics.chapter1;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class IntroductionTest {

	@Test
	public void shouldSumValuesFromAListOfIntegers() throws Exception {
		List<Integer> integers = Arrays.asList(1, 2, 3);
		
		Integer sum = 0;
		for (Integer value: integers) {
			sum += value;
		}
		assertThat(sum, equalTo(6));
	}
	
	@Test
	public void shouldSumValuesFromAListUsingJava8() throws Exception {
		List<Integer> integers = Arrays.asList(1, 2, 3);
	
		Integer sum = integers
			.stream()
			.collect(Collectors.summingInt(Integer::intValue));
		
		assertThat(sum, equalTo(6));
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void shouldSumValuesWithoutGenerics() throws Exception {
		List integers = Arrays.asList(new Integer[] { 1, 2, 3 });
		
		Integer sum = 0;
		for (Iterator it = integers.iterator(); it.hasNext();) {
			Integer value = (Integer) it.next();
			sum += value;
		}
		
		assertThat(sum, equalTo(6));
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void shouldSumValuesWithoutGenercisInAClearWay() throws Exception {
		List integers = Arrays.asList(new Integer[] { 1, 2, 3 });
		
		Iterator iterator = integers.iterator();
		Integer sum = 0;
		while (iterator.hasNext()) {
			Integer value = (Integer) iterator.next();
			sum += value;
		}
		
		assertThat(sum, equalTo(6));
	}
	
	@Test
	public void shouldSumValuesUsingJustArray() throws Exception {
		Integer[] integers = new Integer[] {1, 2, 3};
	
		Integer sum = 0;
		for (int i = 0; i < integers.length; i++) {
			sum += integers[i];
		}
		
		assertThat(sum, equalTo(6));
	}
}










