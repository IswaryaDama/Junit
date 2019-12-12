package com.test;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DateTimeExercise {
	static DateTimeFormatter format = DateTimeFormatter.ofPattern("[dd/MM/yyyy]");
	static List<Tablet> tablets = Arrays.asList(new Tablet[] {
			new Tablet("paracimal" , "India" , "12/10/2018" , LocalDate.parse("31/12/2019",format)),
			new Tablet("Dolo" , "India" , "06/12/2017" ,LocalDate.parse("19/12/2018",format)),
			new Tablet("Citrizen" , "USA" , "12/10/2019" , LocalDate.parse("10/10/2020",format)),
			new Tablet("Chrosin","USA","10/01/2019",LocalDate.parse("10/10/2019",format))
	});
	
	
	static List<String> getExpiringTablets(int months) {
		
		LocalDate  today = LocalDate.now();
		LocalDate current = today.plusMonths(months);
		System.out.println("current date aterdding" + current);
		List<String> expiryTab = tablets.stream().filter((t-> (t.getExDate().isBefore(current)) ||(t.getExDate().isEqual(current))))
				                        .map(t->t.getName()).collect(Collectors.toList());       
		return expiryTab;
	}
	
	static List<String> getExpiringTabletsSorted() {
		
	List<String> tabOrder=	tablets.stream().sorted((t1,t2)-> t1.getExDate().compareTo(t2.getExDate())).map(Tablet :: getName).collect(Collectors.toList());
	return tabOrder;
	}
	
	static Map<String, String> getTabletExpiryPeriod() {
	
		
	Map<String, String> result = tablets.stream().collect(Collectors.toMap(Tablet :: getName, t->{
			Period p = Period.between(LocalDate.parse(t.getManDate(), format),t.getExDate());
			
			String period= p.getYears() + " year/s " + p.getMonths()+ " month/s " + p.getDays() + " day/s ";
			return period;}));
		return result;
		
	}
	
	static void getSameYearExpiry() {
		
		System.out.println("**Tablets Manifactured in same year and expired already**");
		
	Map<String,List<String>>resultMap=	tablets.stream().filter(t->
			LocalDate.parse(t.getManDate(), format).getYear() ==LocalDate.now().getYear()
		).filter(t->t.getExDate().isBefore(LocalDate.now())).collect(Collectors.groupingBy(Tablet::getManifacturer,Collectors.mapping(Tablet::getName, Collectors.toList())));
		
	System.out.println(resultMap);
	}
	public static void main(String[] args) {
		List<String> expiringTab = getExpiringTablets(6);
		System.out.println("**Tablets which are expiring within the months from today are **");
		expiringTab.forEach(System.out::println);
		System.out.println("**Tablets in the order of Expiry dte **");
		List<String> ordertab=getExpiringTabletsSorted();
		ordertab.forEach(System.out::println);
		
		Map<String,String> expirydate=getTabletExpiryPeriod();
		System.out.println(" ** Tablet Expiry period is **" + expirydate);
		getSameYearExpiry();
	}
	
}
