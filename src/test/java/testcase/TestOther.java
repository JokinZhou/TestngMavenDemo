package testcase;

import org.testng.annotations.Test;

public class TestOther {
	@Test(expectedExceptions = ArithmeticException.class)
	public void divisionWithException() {
	  int i = 1 / 0;
	  System.out.println("After division the value of i is :"+ i);
	}
}
