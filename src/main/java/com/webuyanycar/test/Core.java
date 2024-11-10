package com.webuyanycar.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Core {
    public static WebDriver driver;
    public static WebDriver getWebDriver(){
        if(driver == null) {
            ChromeOptions chromeOptions = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions);
        }
        return driver;
    }
}
