package com.comcast.GenericUtils;

import java.util.Random;

/**
 * generic methods related to java
 * @author Aditya
 *
 */

public class JavaUtilities {
	/**
	 * generate random number
	 * @return
	 */
	public int randomNumber()
	{
	 Random random=new Random();
	 int ran = random.nextInt(1000);
	 return ran;
		
	}

}
