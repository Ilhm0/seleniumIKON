package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().clearDriverCache()
                .setup();

        ChromeDriver driver = new ChromeDriver();

        driver.get("http://demoaut.katalon.com");
        driver.findElement(By.id("btn-make-appointment")).click();
        driver.findElement(By.cssSelector("h2")).isDisplayed();
        WebElement usernameSource = driver.findElement(By.xpath("//input[@value='John Doe']"));
        WebElement passwordSource = driver.findElement(By.xpath("//input[@value='ThisIsNotAPassword']"));
        String username = usernameSource.getAttribute("value");
        String password = passwordSource.getAttribute("value");
        driver.findElement(By.id("txt-username")).sendKeys(username);
        driver.findElement(By.id("txt-password")).sendKeys(password);
        driver.findElement(By.id("btn-login")).click();
        driver.findElement(By.id("btn-book-appointment")).isDisplayed();
        driver.quit();
    }
}