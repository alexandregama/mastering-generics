package com.mastering.generics.chapter1;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GenericMethodAndVarargsTEst {

	@Test
	public void shouldConvertAnArrayOfTypeIntegersIntoAListOfTypeIntegers() throws Exception {
		Integer[] integers = new Integer[] { 1, 2, 3, 4, 5 };

		List<Integer> listOfIntegers = toList(integers);

		assertThat(listOfIntegers, hasItems(1, 2, 3, 4, 5));
	}

	@Test
	public void shouldConvertAnArrayOfStringsIntoAListOfStrings() throws Exception {
		String[] strings = new String[] { "First", "Second", "Third" };

		List<String> list = toList(strings);

		assertThat(list, hasItems("First", "Second", "Third"));
	}

	@Test
	public void shouldConvertAnArrayOfIntegersInOneLine() throws Exception {
		List<Integer> list = toList(new Integer[] { 1, 2, 3, 4, 5 });
		
		assertThat(list, hasItems(1, 2, 3, 4, 5));
	}
	
	@Test
	public void shouldConvertAnArrayOfStringsInOneLine() throws Exception {
		List<String> list = toList(new String[] { "First", "Second" });
		
		assertThat(list, hasItems("First", "Second"));
	}
	
	@Test
	public void shouldConvertAnArrayOfIntegersInACleanWay() throws Exception {
		List<Integer> list = convertToList(1, 2, 3, 4, 5);
		
		assertThat(list, hasItems(1, 2, 3, 4, 5));
	}
	
	@Test
	public void shouldAddElelementsToTheEndOfTheList() throws Exception {
		List<Integer> integers = new ArrayList<>();
		integers.add(1);
		integers.add(2);
		integers.add(3);
		
		addToTheEnd(integers, 4, 5, 6);
		
		assertThat(integers, hasItems(1, 2, 3, 4, 5, 6));
	}

	private <T> List<T> toList(T[] arrayOfElements) {
		List<T> list = new ArrayList<>();
		for (T value : arrayOfElements) {
			list.add(value);
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	private <T> List<T> convertToList(T ...elements) {
		List<T> list = new ArrayList<>();
		for (T value: elements) {
			list.add(value);
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	private <T> void addToTheEnd(List<T> list, T ...elements) {
		for (T value: elements) {
			list.add(value);
		}
	}
}







