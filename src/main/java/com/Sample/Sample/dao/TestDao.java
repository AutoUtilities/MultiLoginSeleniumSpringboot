package com.Sample.Sample.dao;

import com.Sample.Sample.dto.Account;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Repository;

@Repository
public class TestDao {

    public void runFacebookTest(Account account) {
    	WebDriverManager.chromedriver().setup();
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--headless");          // run without GUI
    	options.addArguments("--no-sandbox");        // required in Linux container
    	options.addArguments("--disable-dev-shm-usage"); // fix limited /dev/shm size
    	options.setBinary("/usr/bin/chromium");
    	WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        try {
            driver.get("https://www.facebook.com/");
            Thread.sleep(4000);
            String username = account.getUsername();
            String password = account.getPassword();
            driver.findElement(By.id("email")).sendKeys(username);
            driver.findElement(By.id("pass")).sendKeys(password);
            driver.findElement(By.name("login")).click();
            System.out.println("Facebook test executed with: " + account.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    public void runInstagramTest(Account account) {
    	WebDriverManager.chromedriver().setup();
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--headless");          // run without GUI
    	options.addArguments("--no-sandbox");        // required in Linux container
    	options.addArguments("--disable-dev-shm-usage"); // fix limited /dev/shm size
    	options.setBinary("/usr/bin/chromium");
    	WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        try {
            driver.get("https://www.instagram.com/");
            Thread.sleep(2000);
            driver.findElement(By.name("username")).sendKeys(account.getUsername());
            driver.findElement(By.name("password")).sendKeys(account.getPassword());
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            System.out.println("Instagram test executed with: " + account.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
