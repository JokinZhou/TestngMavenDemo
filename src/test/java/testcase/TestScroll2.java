package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import page.ChromeInit;

/**
 * 1、滑动滚动条到某一个元素可见的位置demo
 * 2、（滑动滚动条也可以直接控制滚动条），然后通过Actions的dragAndDrop()方法，按X.Y轴拖动去控制
 * @author lenovo
 *
 */
public class TestScroll2 {

protected ChromeInit CI;
protected WebDriver wd;
  @BeforeClass
  public void beforeClass() {
	  CI = new ChromeInit();
	  wd =CI.getWebDriver();
	  wd.manage().window().maximize();

	  
	  try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
       
  }

  @AfterClass
  public void afterClass() {
	  wd.close();
  }
  
  @Test
  public void f() throws InterruptedException {
	  wd.get("http://blog.csdn.net/u011541946");
	 
	  JavascriptExecutor je =(JavascriptExecutor)wd;
	  //window.scrollBy(0,250)是JS代码表示 把内容滚动 在Y轴方向 滚动250像素的内容
	  je.executeScript("window.scrollBy(0,250)", "");
	  //je.executeScript("window.scrollBy(250,0)", "");//X轴方向滚动250像素
	  
	  Thread.sleep(5000);
	  
	  

	    
  }
}
