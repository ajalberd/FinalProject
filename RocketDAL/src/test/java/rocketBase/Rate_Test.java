package rocketBase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import rocketDomain.RateDomainModel;

public class Rate_Test {

	@Test
	public void RocketDALTest()
	{
		ArrayList<RateDomainModel> rate = RateDAL.getAllRates();
		int ratesize = rate.size();
		assert(ratesize > 0);
		
		System.out.println ("If this returns 600, start at 0 " + rate.get(0).getiMinCreditScore());
		//starts at 0,
		assertEquals(rate.get(0).getiMinCreditScore(), 600);
		assertEquals(rate.get(1).getiMinCreditScore(), 650);
		assertEquals(rate.get(2).getiMinCreditScore(), 700);
		assertEquals(rate.get(3).getiMinCreditScore(), 750);
		assertEquals(rate.get(4).getiMinCreditScore(), 800);
		
		assertEquals(rate.get(0).getdInterestRate(), 7,  0.1);
		assertEquals(rate.get(1).getdInterestRate(), 6.5, 0.1);
		assertEquals(rate.get(2).getdInterestRate(), 6,  0.1);
		assertEquals(rate.get(3).getdInterestRate(), 5.75,  0.1);
		assertEquals(rate.get(4).getdInterestRate(), 5.5, 0.1);
		
	}


}
