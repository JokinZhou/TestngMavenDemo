package testcase;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import page.ChromeInit;

public class TestTakesScreenshotAs {
  @Test
  public void f() {
	  ChromeInit CI = new ChromeInit();
	  WebDriver wd =CI.getWebDriver();
	  wd.get("https://www.baidu.com");
	  wd.getTitle();//获取当前页面的名字
/*	  wd.manage() 返回的是一个Options 接口 的实现对象， 该接口中包含对浏览器cookies设置的一些操作，
	  超时，window窗口的操作*/
	  wd.manage().window().maximize();
	  //强制转换成跨级的父接口， 调用getScreenShontAS 方法 截屏
	  File file=((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
	// 拷贝截图文件到我们项目./Screenshots 
	  try {
		FileUtils.copyFile(file, new File(".\\Screenshots\\screen.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 wd.quit(); 
  }
}
