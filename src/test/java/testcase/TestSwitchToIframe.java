package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import page.ChromeInit;

/**
 * 鼠标悬浮demo
 * @author lenovo
 *
 */
public class TestSwitchToIframe {

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
  public void f() throws Exception {
	  wd.get("http://data.pharmacodia.com/web/homePage/index?ns=1&ts=1&str=YWSJ");
	  Thread.sleep(2000);
	  //WebDriver frameDriver =wd.switchTo().frame("rightMain");//用iframe的ID/name来定位
	  WebDriver frameDriver =wd.switchTo().frame(0);//用iframe的index来定位，第一个是0
	  frameDriver.findElement(By.cssSelector("div.clinical_statuslist:nth-child(1) > div:nth-child(2) > div:nth-child(1) > span:nth-child(2)"))
	  .click();
	  Thread.sleep(5000);
	  //切换到Top Windows，点击权限提示上面的去登录按钮
	  wd = frameDriver.switchTo().defaultContent();
	  wd.findElement(By.cssSelector("#noLoginAlert > div:nth-child(3) > button:nth-child(1)")).click();
	  Thread.sleep(5000);
  }
}
