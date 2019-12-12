package com.test;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utility {

	
	
	static List<String> getBusSchdule(String start,Duration frequency) {
		
		long hrs = frequency.toHours();
		
		long endLimit = (Duration.between(LocalTime.parse(start), LocalTime.MAX).toHours()+1)/hrs;
		
		List<String> busTimings = Stream.iterate(LocalTime.parse(start), t->t.plusHours(hrs)).limit(endLimit)
		      .map(t->t.toString()).collect(Collectors.toList());
		return busTimings;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> busAvail = new ArrayList<>();
		busAvail = getBusSchdule("05:00" , Duration.ofHours(3));
		
		System.out.println("***Bus timings in a day are ***");
		busAvail.forEach(System.out::println);
	}

}
