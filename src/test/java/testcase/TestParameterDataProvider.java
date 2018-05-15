package testcase;


import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParameterDataProvider {
	
	String[][] testData=null;
	HashMap<String,String> hashMap = new HashMap<String,String>();

    @Test(dataProvider = "provideNumbers")
    public void test(int number, int expected,int n) {
    	System.out.println(number+" : "+expected+" : "+ n);
        Assert.assertEquals(number + 10, expected);
    }

    @DataProvider(name = "provideNumbers")
    public Object[][] provideData() {

        return new Object[][] { { 10, 20,30}, { 100, 110,111 }, { 200, 210,220 } };
        //return testData;
        //return new Object[] []{{hashMap}};//二维
    }

}