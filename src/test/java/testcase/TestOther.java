package testcase;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author lenovo
 *
 */
public class TestOther {
	// ()里的注释让 testng原本会运行时异常的 捕获掉， 使之变成testng运行通过， 但是异常后面的代码不会继续执行
	@Test(expectedExceptions = ArithmeticException.class)
	public void divisionWithException() {
		int i = 1 / 0;
		System.out.println("After division the value of i is :" + i);
	}
	
	 @Test // default enable=true
	    public void test1() {
	        AssertJUnit.assertEquals(true, true);
	    }

	//使用@Test(enabled = false)注释在测试方法上，则会绕过这个未准备好测试的测试用例
	  @Test(enabled = false)
	  public void test2() {
	    AssertJUnit.assertEquals(true, true);
	  }
	
	  @Test(enabled = true)
	  public void test3() {
	    AssertJUnit.assertEquals(true, true);
	  }

}
