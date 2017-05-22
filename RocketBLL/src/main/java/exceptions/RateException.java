package exceptions;

import rocketDomain.RateDomainModel;

public class RateException extends Exception {

	//	TODO - RocketBLL RateException - RateDomainModel should be an attribute of RateException
	//	* Add RateRomainModel as an attribute
	//	* Create a constructor, passing in RateDomainModel
	//	* Create a getter (no setter, set value only in Constructor)
	private RateDomainModel samplerate;
	
	public RateException(RateDomainModel e)
	{
		this.samplerate = e;
	}
	
	public RateDomainModel getRate()
	{
		return this.samplerate;
	}
}
