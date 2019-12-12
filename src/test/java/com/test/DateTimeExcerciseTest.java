package com.test;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.time.Duration;
//import org.hamcrest.collection.IsMapContaining;
import java.time.Period;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DateTimeExcerciseTest {
    
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//bankexcer = new BankDepositExercise();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("start of new testcase");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("End of new testcase");
	}

	@Test
	public void getMaturityDateTest() {
		assertEquals("2037-09-09", BankDepositExercise.getMaturityDate("08/08/2017" ,Period.of(20, 1, 1)));
	}
	@Test
	public void getInvestmentPeriod() {
		assertEquals("20 years 1 months 1 days", BankDepositExercise.getInvestmentPeriod("08-08-2017" , "09-09-2037"));
	}
	@Test
	public void getExpiringTabletsTest() {
		assertThat(DateTimeExercise.getExpiringTablets(6),hasItems("paracimal", 
				"Dolo", 
				"Chrosin"));
	}
	@Test
	public void getExpiringTabletsSorted() {
		assertThat(DateTimeExercise.getExpiringTabletsSorted(),is(Arrays.asList("Dolo" , 
				"Chrosin" , 
				"paracimal",
				"Citrizen")
				));
	}
	@Test
	public void getTabletExpiryPeriod() {
		Map<String,String> expected = new HashMap<>();
		expected.put("paracimal","1 year/s 2 month/s 19 day/s "); 
		expected.put("Chrosin","0 year/s 9 month/s 0 day/s "); 
		expected.put("Citrizen","0 year/s 11 month/s 28 day/s ");
		expected.put("Dolo","1 year/s 0 month/s 13 day/s ");
		assertThat(DateTimeExercise.getTabletExpiryPeriod(),is(expected));
				
	}
	
	@Test
	public void getNextMonthsWorkingDays() {
	
		List<String> workdays = Arrays.asList("01-01-2020","02-01-2020","03-01-2020","06-01-2020","07-01-2020","08-01-2020","09-01-2020",
				"10-01-2020","13-01-2020","14-01-2020","15-01-2020","16-01-2020","17-01-2020","20-01-2020","21-01-2020","22-01-2020",
				"23-01-2020","24-01-2020","27-01-2020","28-01-2020","29-01-2020","30-01-2020","31-01-2020");	
	
    assertThat(WorkingDaysExercise.getNextMonthsWorkingDays(),is(workdays));
}
	@Test
	public void getBusSchdule() {
		assertThat(Utility.getBusSchdule("05:00" , Duration.ofHours(3)),is(Arrays.asList("05:00","08:00","11:00","14:00","17:00", "20:00")));
	}
	
}
