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
public class TestActionMouse {

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
  public void f() {
	  wd.get("https://www.baidu.com/");
	  WebElement settings = wd.findElement(By.cssSelector("a.pf:nth-child(8)"));
	  Actions actions = new Actions(wd);
	  actions.moveToElement(settings).perform();//悬浮到设置处
	  //要鼠标先滑动到悬浮处， 出现选项悬浮框后通过find定位并点击
	  wd.findElement(By.linkText("高级搜索")).click();
	  try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  wd.close();
  }
}
