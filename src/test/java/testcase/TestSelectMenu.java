package testcase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
public class TestSelectMenu {
	
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
	  wd.get("http://jqueryui.com/resources/demos/selectmenu/default.html");
	  //点击选择框
	  wd.findElement(By.id("speed-button")).click();
	  try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 //使用CSS选择器 获取到 所有  ID为ui-menu-item的标签下 所有可见(dispaly)的 div标签
	 List<WebElement>  elements =wd.findElements(By.cssSelector("li.ui-menu-item > div"));
	 //List<WebElement>  elements =wd.findElements(By.xpath("//*[@id='speed-menu']/li/div"));
	 for(WebElement e : elements){
		 System.out.println("------" +e.getText() );
		 if(e.getText().equals("Fast")){
			 e.click();
			 break;
		 }
	 }
	 
	 
	 try {
		Thread.sleep(3000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    //AssertJUnit.assertTrue(wd.findElement(By.xpath("//*[@id='droppable']/p[text()='Dropped!']")).isDisplayed() == true);
  }
  
}
