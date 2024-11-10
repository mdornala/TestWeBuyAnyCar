package com.webuyanycar.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BasePage {

    public static WebDriver driver = Core.getWebDriver();
    public static String baseUrl;
    public static Map<String,Object> scenarioContext = new HashMap<>();

    public void  waitToVisible(By elementLocator, int timeInSec){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSec));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }

    public void clickElement(By elementLocator){
        waitToVisible(elementLocator, 5);
        driver.findElement(elementLocator).click();
    }

    public void enterText(By elementLocator, String text){
        waitToVisible(elementLocator, 5);
        driver.findElement(elementLocator).sendKeys(text);
    }

    public String getText(By elementLocator){
        return driver.findElement(elementLocator).getText();
    }

    public static void goToUrl(String url){
        driver.get(url);
    }
}
