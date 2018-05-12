package testcase;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import page.ChromeInit;

/**
 * 鼠标悬浮demo
 * @author lenovo
 *
 */
public class TestFileUpload {

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
  public void f() throws AWTException {
	  wd.get("https://www.baidu.com/");
	  // 点击照相机这个按钮
	  wd.findElement(By.xpath("//*/span[@class='soutu-btn']")).click();  
	  // 点击本地上传图片
	  wd.findElement(By.xpath("//*/input[@class='upload-pic']")).click();  
      
	  // 指定图片的路径，这里我放桌面上  
	  StringSelection sel = new StringSelection("D:\\chufang.jpg");          
	  // 把图片文件路径复制到剪贴板  
/*	  Clipboard cp = Toolkit.getDefaultToolkit().getSystemClipboard();//获取到系统的粘贴,
	  然后通过setContents,赋值内容*/
	  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);  
	  System.out.println("selection" +sel);  
	  try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}         
	  // 新建一个Robot类的对象  
	  Robot robot = new Robot();
	  
	  try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
	  
	 //按下 CTRL+V ，把之前存在黏贴里的文件地址拷贝到 widow的文件选择框口
	  robot.keyPress(KeyEvent.VK_CONTROL);
	  robot.keyPress(KeyEvent.VK_V);
	          
	 // 释放 CTRL+V  
	  robot.keyRelease(KeyEvent.VK_CONTROL); 
	  robot.keyRelease(KeyEvent.VK_V);
	  
	  try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
	                 
	 // 点击回车 Enter, 确认window的文件选择框
	  robot.keyPress(KeyEvent.VK_ENTER);
	 // 释放回车  
	  robot.keyRelease(KeyEvent.VK_ENTER);
	  
	  try {
		Thread.sleep(15000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
  }
}
