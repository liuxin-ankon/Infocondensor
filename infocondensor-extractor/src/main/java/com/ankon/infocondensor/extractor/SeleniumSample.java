
package com.ankon.infocondensor.extractor;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Liu Xin <xin.liu@ankoninc.com.cn>
 */
public class SeleniumSample {

    public static void main(String[] args) {
        //download and install chrome browser
        //download "chromedriver" from https://chromedriver.storage.googleapis.com/index.html?path=2.30/
        //replace D:\\softs\\dev\\chromedriver.exe with the path where chromedriver in your PC
        System.setProperty("webdriver.chrome.driver", "D:\\softs\\dev\\chromedriver.exe");

        // Create a new instance of the Chrome driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
        WebDriver driver = new ChromeDriver();
        
        //Document http://www.seleniumhq.org/docs/
        //Chapter: Selenium WebDriver
        driver.get("https://www.kidsbestjobs.com/kids-best-job-web/pages/job_search.html");

        WebElement jobTable = driver.findElement(By.id("jobTable"));
        List<WebElement> elements = jobTable.findElements(By.className("media-body"));
        for (WebElement e : elements) {
            System.out.println(e.findElement(By.tagName("h4")).getText());
        }

        driver.close();
    }
}
