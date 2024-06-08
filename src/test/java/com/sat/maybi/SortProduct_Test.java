package com.sat.maybi;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.sat.utils.BasicTest;
import com.sat.utils.Utils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class SortProduct_Test extends BasicTest {
    @Test
    public void SP01() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //Kiem tra hien thi Dropdown menu xap xep
        System.out.println("i. Launch Browser :'https://maybi.com/'");
        driver.get("https://maybi.com/");
        Utils.hardWait();
        driver.get("https://maybi.com/collections/all");
        Utils.hardWait();
        driver.findElement(By.xpath("//select[@class='content_ul']")).click();
        Utils.hardWait(); 
        WebElement tuychon = driver.findElement(By.xpath("//option[@value='alpha-asc']"));
        Assert.assertTrue(tuychon.isDisplayed());
        WebElement TentuAdenZ = driver.findElement(By.xpath("//option[@value='alpha-asc']"));
        Assert.assertTrue(TentuAdenZ.isDisplayed());
        WebElement TentuZdenA = driver.findElement(By.xpath("//option[@value='alpha-desc']"));
        Assert.assertTrue(TentuZdenA.isDisplayed());
        WebElement Giatangdan = driver.findElement(By.xpath("//option[@value='price-asc']"));
        Assert.assertTrue(Giatangdan.isDisplayed());
        WebElement Giagiamdan = driver.findElement(By.xpath("//option[@value='price-desc']"));
        Assert.assertTrue(Giagiamdan.isDisplayed());
        WebElement Hangmoi = driver.findElement(By.xpath("//option[@value='created-desc']"));
        Assert.assertTrue(Hangmoi.isDisplayed());
        Utils.hardWait(); 
    }
    @Test
    public void SP02() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        System.out.println("i. Launch Browser :'https://maybi.com/'");
        driver.get("https://maybi.com/");
        Utils.hardWait();
        //Sap xep san pham theo ten(tu A-->Z)
        driver.get("https://maybi.com/collections/all");
        Utils.hardWait();
        driver.findElement(By.xpath("//select[@class='content_ul']")).click();
        Utils.hardWait(); 
        driver.findElement(By.xpath("//option[@value='alpha-asc']")).click();
        Utils.hardWait(); 
        String curentUrl = driver.getCurrentUrl();
        Assert.assertTrue(curentUrl.contains("https://maybi.com/collections/all?q=filter=(!(collectionid:product=0))&page=1&sortby=title:product=asc&view=grid"));
        Utils.hardWait();
    }
    @Test
    public void SP03() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        System.out.println("i. Launch Browser :'https://maybi.com/'");
        driver.get("https://maybi.com/");
        Utils.hardWait();
        //Sap xep san pham theo ten(tu Z-->A)
        driver.get("https://maybi.com/collections/all");
        Utils.hardWait();
        driver.findElement(By.xpath("//select[@class='content_ul']")).click();
        Utils.hardWait(); 
        driver.findElement(By.xpath("//option[@value='alpha-desc']")).click();
        Utils.hardWait(); 
        String curentUrl = driver.getCurrentUrl();
        Assert.assertTrue(curentUrl.contains("https://maybi.com/collections/all?q=filter=(!(collectionid:product=0))&page=1&sortby=title:product=desc&view=grid"));
        Utils.hardWait();
    }
    @Test
    public void SP04() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        System.out.println("i. Launch Browser :'https://maybi.com/'");
        driver.get("https://maybi.com/");
        Utils.hardWait();
        //Sap xep san pham theo gia tang dan
        driver.get("https://maybi.com/collections/all");
        Utils.hardWait();
        driver.findElement(By.xpath("//select[@class='content_ul']")).click();
        Utils.hardWait(); 
        driver.findElement(By.xpath("//option[@value='price-asc']")).click();
        Utils.hardWait(); 
        String curentUrl = driver.getCurrentUrl();
        Assert.assertTrue(curentUrl.contains("https://maybi.com/collections/all?q=filter=(!(collectionid:product=0))&page=1&sortby=price:product=asc&view=grid"));
        Utils.hardWait();
    }
    @Test
    public void SP05() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        System.out.println("i. Launch Browser :'https://maybi.com/'");
        driver.get("https://maybi.com/");
        Utils.hardWait();
        //Sap xep san pham theo gia giam dan
        driver.get("https://maybi.com/collections/all");
        Utils.hardWait();
        driver.findElement(By.xpath("//select[@class='content_ul']")).click();
        Utils.hardWait(); 
        driver.findElement(By.xpath("//option[@value='price-desc']")).click();
        Utils.hardWait(); 
        String curentUrl = driver.getCurrentUrl();
        Assert.assertTrue(curentUrl.contains("https://maybi.com/collections/all?q=filter=(!(collectionid:product=0))&page=1&sortby=price:product=desc&view=grid"));
        Utils.hardWait();
       
    }
    @Test
    public void SP06() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        System.out.println("i. Launch Browser :'https://maybi.com/'");
        driver.get("https://maybi.com/");
        Utils.hardWait();
        //Sap xep san pham theo hang moi
        driver.get("https://maybi.com/collections/all");
        Utils.hardWait();
        driver.findElement(By.xpath("//select[@class='content_ul']")).click();
        Utils.hardWait(); 
        driver.findElement(By.xpath("//option[@value='created-desc']")).click();
        Utils.hardWait(); 
        String curentUrl = driver.getCurrentUrl();
        Assert.assertTrue(curentUrl.contains("https://maybi.com/collections/all?q=filter=(!(collectionid:product=0))&page=1&sortby=created_at:product=desc&view=grid"));
        Utils.hardWait();
    }
}
       
