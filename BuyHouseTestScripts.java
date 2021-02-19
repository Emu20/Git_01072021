package com.mortgage.calculator.tests;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.mortgage.calculator.libraries.Base;
import com.mortgage.calculator.pages.HomePage;
import com.mortgage.calculator.pages.ResultPage;

public class BuyHouseTestScripts extends Base {
	final static Logger logger = Logger.getLogger(BuyHouseTestScripts.class);
	
	@Test(enabled = true)
	public void buySingleHomeTest() {
		// Goto the web-site
		HomePage calHomePage = new HomePage();
		calHomePage.gotoMortgageCalculatorWebsite();
		
		// Enter data
		calHomePage.selectCurrencyType("€");
		calHomePage.selectCurrencyType("$");
		calHomePage.enterAmount("400000");
		calHomePage.enterAmortizationYear("29");
		calHomePage.enterAmortizationYear("30");
		calHomePage.enterAmortizationMonth("");
		calHomePage.enterInterestTermYear("30");
		calHomePage.enterInterestTermMonth("");
		calHomePage.selectInterestType("Fixed");
		calHomePage.enterInterestRate("2.5");
		calHomePage.selectStartMonth("11");
		calHomePage.selectStartYear("2021");
		calHomePage.selectPaymentPeriod("Semi-Monthly");
		calHomePage.selectPaymentPeriod("Monthly");
		calHomePage.clickCalculateButton();
		
		ResultPage calResultPage = new ResultPage();
		String monthlyPayment = calResultPage.getMonthlyPayment();
		assertEquals(monthlyPayment, "$1,580.48");
		
		String totalPayment = calResultPage.getTotalPayment();
		assertEquals(totalPayment, "$568,974.08");		
	}
	
	@Test(enabled = false)
	public void buyATownHouse() {
		HomePage calHomePage = new HomePage();
		calHomePage.gotoMortgageCalculatorWebsite()
		.selectCurrencyType("€")
		.selectCurrencyType("$")
		.enterAmount("200000")
		.enterAmortizationYear("29")
		.enterAmortizationYear("30")
		.enterAmortizationMonth("")
		.enterInterestTermYear("30")
		.enterInterestTermMonth("")
		.selectInterestType("Fixed")
		.enterInterestRate("2.5")
		.selectStartMonth("11")
		.selectStartYear("2021")
		.selectPaymentPeriod("Semi-Monthly")
		.selectPaymentPeriod("Monthly")
		.clickCalculateButton();
		
		ResultPage calResultPage = new ResultPage(); //Syncing happened here
		String monthlyPayment = calResultPage.getMonthlyPayment();
		assertEquals(monthlyPayment, "$1,580.48");
		
		String weeklyPayment = calResultPage.getTotalPayment();
		assertEquals(weeklyPayment, "$400.48");		
	}
}
