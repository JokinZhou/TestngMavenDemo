package testcase;

import org.testng.annotations.Test;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class TestngGroup {

    @BeforeGroups("database")
    public void setupDB() {
        System.out.println("这个是BeforeGroups(database) ：setupDB()");
    }

    @AfterGroups("database")
    public void cleanDB() {
        System.out.println("这个是AfterGroups(database) ：cleanDB()");
    }

    @Test(groups = "selenium-test")
    public void runSelenium() {
        System.out.println("runSelenium()");
    }

    @Test(groups = "selenium-test")
    public void runSelenium1() {
        System.out.println("runSelenium()1");
    }

    @Test(groups = "database")
    public void testConnectOracle() {
        System.out.println("这个是Test(groups = database)即属于分组database ：testConnectOracle()");
    }

    @Test(groups = "database")
    public void testConnectMsSQL() {
        System.out.println("这个是Test(groups = database)即属于分组database ：testConnectMsSQL");
    }

    @Test(dependsOnGroups = { "database", "selenium-test" })
    public void runFinal() {
        System.out.println("runFinal");
    }

}
