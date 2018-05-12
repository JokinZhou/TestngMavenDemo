package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import page.ChromeInit;

/**
 * 鼠标拖拽物体(元素)demo
 * @author lenovo
 *
 */
/**
 * @author lenovo
 *
 */
public class TestDrag {
	
	protected ChromeInit CI;
	protected WebDriver wd;
  @BeforeClass
  public void beforeClass() {
	  CI = new ChromeInit();
	  wd =CI.getWebDriver();
	  wd.manage().window().maximize();
	  wd.get("http://jqueryui.com/resources/demos/droppable/default.html");
	  
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
	  
      // 定位能拖拽的元素  
      WebElement move_ele = wd.findElement(By.id("draggable"));  
      // 定位拖拽目标位置元素  
      WebElement target_ele = wd.findElement(By.id("droppable"));
      
      Actions actions = new Actions(wd);
      //Actions dragAndDrop(WebElement source, WebElement target) 把可移动元素拖拽到 目标元素处
      actions.dragAndDrop(move_ele, target_ele).build().perform();
      
      AssertJUnit.assertTrue(wd.findElement(By.xpath("//*[@id='droppable']/p[text()='Dropped!']")).isDisplayed() == true);
  }
  
}
