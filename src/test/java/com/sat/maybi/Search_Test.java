package com.sat.maybi;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.sat.utils.BasicTest;
import com.sat.utils.Utils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


public class Search_Test extends BasicTest {
    
    @Test
    public void SP01() {

        // hien thi o tim kiem
        
        System.out.println("i. Launch Browser'");
        driver.get("https://maybi.com/");
        Utils.hardWait();

        driver.findElement(By.xpath("//span[contains(text(),'Tìm kiếm')]")).click();

        WebElement textboxTimKiem = driver.findElement(By.xpath("//input[@class='input-group-field auto-search form-control ']"));
        Assert.assertTrue(textboxTimKiem.isDisplayed());
        WebElement buttonTimKiem = driver.findElement(By.xpath("//button[@aria-label='search']"));
        Assert.assertTrue(buttonTimKiem.isDisplayed());
        Utils.hardWait();
    }
    @Test
    public void SP02(){
        // nhap cum tu hop le
        System.out.println("i. Launch Browser'");
        driver.get("https://maybi.com/");
        Utils.hardWait();

        driver.findElement(By.xpath("//span[contains(text(),'Tìm kiếm')]")).click();
        driver.findElement(By.xpath("//input[@class='input-group-field auto-search form-control ']")).sendKeys("Chân váy");
        Utils.hardWait();

        WebElement hienthiketqua = driver.findElement(By.xpath("//strong[contains(text(),'Kết quả tìm kiếm cho ')]"));
        Assert.assertTrue(hienthiketqua.isDisplayed());
    }
    @Test
    public void SP03(){
        // nhap cum tu khong hop le
        System.out.println("i. Launch Browser'");
        driver.get("https://maybi.com/");
        Utils.hardWait();

        driver.findElement(By.xpath("//span[contains(text(),'Tìm kiếm')]")).click();
        driver.findElement(By.xpath("//input[@class='input-group-field auto-search form-control ']")).sendKeys("Text");
        Utils.hardWait();

        WebElement hienthiketqua = driver.findElement(By.xpath("//div[contains(text(),'Không tìm thấy kết quả ')]"));
        Assert.assertTrue(hienthiketqua.isDisplayed());

    }
    @Test
    public void SP04(){
        // Nhap cum tu hop le va cho ket qua duy nhat
        System.out.println("i. Launch Browser'");
        driver.get("https://maybi.com/");
        Utils.hardWait();

        driver.findElement(By.xpath("//span[contains(text(),'Tìm kiếm')]")).click();
        driver.findElement(By.xpath("//input[@class='input-group-field auto-search form-control ']")).sendKeys("Chân váy ôm nhung xẻ tà");
        Utils.hardWait();

        WebElement hienthiketqua = driver.findElement(By.xpath("//h4[contains(text(),'Chân váy ôm nhung xẻ tà')]"));
        Assert.assertTrue(hienthiketqua.isDisplayed());

    }
    @Test
    public void SP05(){
        // De trong textbox tim kiem
        System.out.println("i. Launch Browser'");
        driver.get("https://maybi.com/");
        Utils.hardWait();

        driver.findElement(By.xpath("//span[contains(text(),'Tìm kiếm')]")).click();
        driver.findElement(By.xpath("//button[@aria-label='search']")).click();
        Utils.hardWait();

        String errorMessage = driver.findElement(By.xpath("//input[@class='input-group-field auto-search form-control ']")).getAttribute("validationMessage");
        String expectedMessage = "Please fill out this field.";
        Assert.assertEquals(errorMessage, expectedMessage);
    }

}
