package com.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WorkingDaysExercise {
	
	
	static List<String> getNextMonthsWorkingDays() {
		List<String> workingDays =new ArrayList<>();		
		
		LocalDate current = LocalDate.now();
		LocalDate nextMonth = current.with(TemporalAdjusters.firstDayOfNextMonth());
		LocalDate lastDay = nextMonth.with(TemporalAdjusters.lastDayOfMonth());
		long count = lastDay.getDayOfMonth();
		workingDays = Stream.iterate(nextMonth,n->n.plusDays(1)).limit(count).filter(l->!(l.getDayOfWeek().toString().equals("SATURDAY")) && !(l.getDayOfWeek().toString().equals("SUNDAY")))
		      .map(l-> l.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))).collect(Collectors.toList());
		return workingDays;	
		}
		
	public static void main(String[] args) {
		List<String> workingDays = getNextMonthsWorkingDays();
System.out.println("***nextMonth working days are ****");
		
		workingDays.forEach(System.out::println);
	}
	}

	

