package testcase;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.internal.WrapsDriver;
import org.testng.annotations.Test;

/**
 * 测试截取单个元素
 * @author lenovo
 *
 */
public class TestCapture {  
	  
    /**
     * 获取页面某个元素的截图file对象（先获取整个页面图片，然后在获取到元素坐标，之后对页面图片截取）
     * @param element  需要被截图的元素
     * @return
     * @throws Exception
     */
    public static File captureElement(WebElement element) throws Exception {  
        WrapsDriver wrapsDriver = (WrapsDriver) element;
        WebDriver wd  = wrapsDriver.getWrappedDriver();
        // 截图浏览器 整个页面    ；     后面会被ImageIO.write覆盖了原来的整个页面的图片
        File screen = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
        
        BufferedImage img = ImageIO.read(screen);  
        // 获得元素的高度和宽度  
        int width = element.getSize().getWidth();  
        int height = element.getSize().getHeight();  
        // 创建一个矩形使用上面的高度，和宽度  
        Rectangle rect = new Rectangle(width, height);  
        // 得到元素的坐标 ， 这样
        Point p = element.getLocation();
        //getSubimage 为截取图对象方法
        BufferedImage dest = img.getSubimage(p.getX(), p.getY(), rect.width,rect.height);  
        //存为png格式,存在内存File对象里， 重新赋值 覆盖了最开始获取的整个浏览器的截图图片  
        ImageIO.write(dest, "png", screen);
        
        return screen;  
    }  
      
    @Test  
    public void testCaptureElement(){  
    	String driverPath = null;
  		try {
  			driverPath = new File("./").getCanonicalPath() + "/src/main/resources/chromedriver.exe";
  		} catch (IOException e) {
  			// TODO Auto-generated catch block
  			System.out.println("获取浏览器驱动失败！！！");
  			e.printStackTrace();
  		}
  	      System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver=new ChromeDriver();  
        driver.manage().window().maximize();  
        driver.get("https://www.baidu.com");  
        WebElement wb = driver.findElement(By.id("su"));  
        try {
        	File f = captureElement(wb);//直接调用同类的  静态方法 获得截取的单个元素的file对象
            FileUtils.copyFile( f , new File("d:\\a.png"));//输出对象成本地文件  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        driver.quit();  
    }  
}  

