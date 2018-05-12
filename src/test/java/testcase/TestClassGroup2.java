package testcase;

import org.testng.annotations.Test;

//全局的分组类注释@test， eclipse不能知道识别convert成xml，需要手动去testng.xml文件添加配置suite
@Test(groups = "selenium-test")
public class TestClassGroup2 {

    public void runSelenium4() {
        System.out.println("runSelenium()4");
    }

    public void runSelenium5() {
        System.out.println("runSelenium()5");
    }

}