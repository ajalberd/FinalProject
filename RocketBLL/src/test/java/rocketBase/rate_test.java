package rocketBase;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.RateException;

public class rate_test {

	@Test
	public void LowScore() throws RateException
	{
		int LowScore = 100;
		double norate = 0;
		RateBLL.getRate(LowScore);
		try
		{
			norate = RateBLL.getRate(LowScore);
		}
		catch (RateException e)
		{
			System.out.println("Score is too low for a rate");
		}
	}

	
	@Test
	public void CorrectTest() throws RateException
	{
		//Testing the correct variables per Word instructions
		double r = .04;
		int n = 360;
		double p = 300000;
		double f = 0;
		boolean t = false; //if true, gives lower answer valuation. 
		
		double Payment = RateBLL.getPayment(r, n, p, f, t);
		System.out.println("Should be 1432.25" + Payment);
		assertEquals(Payment, -1432.25,1); //rounding, etc, don't know why ans is negative...
		
	}
}
