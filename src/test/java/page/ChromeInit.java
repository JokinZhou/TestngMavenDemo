/**
 * 
 */
package page;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * @author jokin
 *初始化ChromeDriver，窗口及网站链接
 */
public class ChromeInit {
	
	protected WebDriver webDriver;
	//初始化驱动和网站链接
	/**
	 * 构造函数 
	 */
	public ChromeInit() {
		// TODO Auto-generated constructor stub    
		// 通过查找当前路径返回一个规范化路径，这样可以把工程放到不同地方执行了
	    String driverPath = null;
		try {
			driverPath = new File("./").getCanonicalPath() + "/src/main/resources/chromedriver.exe";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("获取浏览器驱动失败！！！");
			e.printStackTrace();
		}
	      System.setProperty("webdriver.chrome.driver", driverPath);
	      ChromeOptions Options = new ChromeOptions();
	      webDriver = new ChromeDriver(Options);//加上Options可以设置浏览器的启动参数； 不加的话就是默认参数
	      webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	      //webDriver.get("http://longguojz.uat1.rs.com/");
	     //webDriver.manage().window().maximize();
	
	}
	public WebDriver getWebDriver() {
		return webDriver;
	}
	public void setWebDriver(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	
	
}
