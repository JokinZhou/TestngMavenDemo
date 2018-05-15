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
 * 滑动滚动条到某一个元素可见的位置demo
 * （滑动滚动条也可以直接控制滚动条），然后通过Actions的dragAndDrop()方法，按X.Y轴拖动去控制
 * @author lenovo
 *
 */
public class TestScroll {

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
	  //定位一个页面上的元素
	  //WebElement element = wd.findElement(By.cssSelector("div.article-item-box:nth-child(3) > h4:nth-child(1) > a:nth-child(1)"));
	  WebElement element = wd.findElement(By.cssSelector("div.article-item-box:nth-child(17) > h4:nth-child(1) > a:nth-child(1)"));
	//创建一个javascript 执行实例 
	  JavascriptExecutor je =(JavascriptExecutor)wd;
	  //调用执行JS 代码element.scrollIntoView(true);移动到元素element对象的“顶端”与当前窗口的“顶部”对齐
	  //arguments[0]的意思是 获取第一个参数
	  je.executeScript("arguments[0].scrollIntoView(true);", element);
	  
	  Thread.sleep(5000);
	  
	  
/*	//移动到元素element对象的“顶端”与当前窗口的“顶部”对齐  
	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);  
	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);  
	    
	  //移动到元素element对象的“底端”与当前窗口的“底部”对齐  
	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);  
	    
	  //移动到页面最底部  
	  ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");  
	    
	  //移动到指定的坐标(相对当前的坐标移动)  
	  ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 700)");  
	  Thread.sleep(3000);  
	  //结合上面的scrollBy语句，相当于移动到700+800=1600像素位置  
	  ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 800)");  
	    
	  //移动到窗口绝对位置坐标，如下移动到纵坐标1600像素位置  
	  ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 1600)");  
	  Thread.sleep(3000);  
	  //结合上面的scrollTo语句，仍然移动到纵坐标1200像素位置  
	  ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 1200)"); 
	  */
	  
	    
  }
}
