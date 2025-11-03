package com.HRM.Generic.fileUtility;

import java.util.Random;

public class JVUtility 
{
	public int getRandomNumber()
	{
		Random random = new Random();
		int RN =random.nextInt(500);
		return RN	;	
	}

}
