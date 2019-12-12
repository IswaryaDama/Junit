package com.test;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class BankDepositExercise {

	static String getMaturityDate(String investmentDate, Period duration) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("[dd/MM/yyyy][dd-mm-yyyy]");
		//DateTimeFormatter format1 = DateTimeFormatter.ofPattern("[dd-MM-yyyy][dd-mm-yyyy]");
		
		LocalDate localDate = LocalDate.parse(investmentDate, format);
		
		LocalDate maturityDate =localDate.plus(duration);
		
		return maturityDate.toString();
	}
	
	static String getInvestmentPeriod(String investmentDate,String maturityDate) {
		DateTimeFormatter format1 = DateTimeFormatter.ofPattern("[dd-MM-yyyy][dd-mm-yyyy]");
		
		Period investPeriod = Period.between(LocalDate.parse(investmentDate, format1), LocalDate.parse(maturityDate,format1));
		
		String investmentPeriod = investPeriod.getYears() + " years " + investPeriod.getMonths() + " months " + investPeriod.getDays() + " days";
		return investmentPeriod;
	}
	
	public static void main(String[] args) {
		Period duration = Period.of(20, 1, 1);
		System.out.println("Maturity Date is: " + getMaturityDate("08/08/2017" ,duration));
		System.out.println("Investment period is: " + getInvestmentPeriod("08-08-2017" , "09-09-2037"));
	}
	
}
