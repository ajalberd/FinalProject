package rocketBase;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.formula.functions.*;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	
	public static double getRate(int GivenCreditScore) throws RateException 
	{
		double dInterestRate = 0;
		
		
		ArrayList<RateDomainModel> listrates = RateDAL.getAllRates();
		
		for (RateDomainModel x : listrates)
		{
			if (GivenCreditScore >= x.getiMinCreditScore())
			{
				dInterestRate = x.getdInterestRate();
			}
			
		}
		//TODO: Filter the ArrayList...  look for the correct rate for the given credit score.
		//	Easiest way is to apply a filter using a Lambda function.
		//
		//	Example... how to use Lambda functions:
		//			https://github.com/CISC181/Lambda
		
		return dInterestRate;
		
		
	}
	
	
	
	
	
	
	
	//TODO - RocketBLL RateBLL.getPayment 
	//		how to use:
	//		https://poi.apache.org/apidocs/org/apache/poi/ss/formula/functions/FinanceLib.html
	
	public static double getPayment(double r, double n, double p, double f, boolean t)
	{	
		
		return FinanceLib.pmt((r/12), n, p, f, t); //monthly
	}
}
