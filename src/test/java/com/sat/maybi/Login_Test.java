package com.sat.maybi;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.sat.utils.BasicTest;
import com.sat.utils.Utils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class Login_Test extends BasicTest {
    
    @Test
    public void LG01() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        // Dang nhap tai khoan 
        
        System.out.println("i. Launch Browser :'https://maybi.com/'");
        driver.get("https://maybi.com/");
        Utils.hardWait();
        driver.get("https://maybi.com/account/login");
        Utils.hardWait();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Tài khoản";
        Assert.assertEquals(actualTitle, expectedTitle);



        WebElement emailTextbox = driver.findElement(By.xpath("//input[@id='customer_email']"));
        Assert.assertTrue(emailTextbox.isDisplayed());
        WebElement textboxMatKhau = driver.findElement(By.xpath("//input[@id='customer_password']"));
        Assert.assertTrue(textboxMatKhau.isDisplayed());
        WebElement DangNhap = driver.findElement(By.xpath("//input[@id='customer_password']"));
        jse.executeScript("arguments[0].scrollIntoView(true);", DangNhap);
        WebElement buttonDangNhap = driver.findElement(By.xpath("//button[contains(text(),'Đăng nhập')]"));
        Assert.assertTrue(buttonDangNhap.isDisplayed());
    }
    @Test
    public void LG02(){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        // Dang nhap hop le 
        System.out.println("i. Launch Browser :'https://maybi.com/'");
        driver.get("https://maybi.com/");
        Utils.hardWait();
        driver.get("https://maybi.com/account/login");
        Utils.hardWait();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Tài khoản";
        Assert.assertEquals(actualTitle, expectedTitle);


        driver.findElement(By.xpath("//input[@id='customer_email']")).sendKeys("dieulinhthieuthi@gmail.com"); 
        driver.findElement(By.xpath("//input[@id='customer_password']")).sendKeys("Maybi00.vn");
        WebElement DangNhapv = driver.findElement(By.xpath("//input[@id='customer_password']"));
        jse.executeScript("arguments[0].scrollIntoView(true);", DangNhapv); 
        driver.findElement(By.xpath("//button[@value='Đăng nhập']")).click(); 
        Utils.hardWait();


        String Title = driver.findElement(By.xpath("//h5[@class='title-account']")).getText();
        String expected = "TRANG TÀI KHOẢN";
        Assert.assertEquals(Title, expected);
    }
    @Test
    public void LG03(){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        // Dang Nhap khong hop le
        System.out.println("i. Launch Browser :'https://maybi.com/'");
        driver.get("https://maybi.com/");
        Utils.hardWait();
        driver.get("https://maybi.com/account/login");
        Utils.hardWait();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Tài khoản";
        Assert.assertEquals(actualTitle, expectedTitle);
        // Thông tin đăng nhập không hợp lệ.
        driver.findElement(By.xpath("//input[@id='customer_email']")).sendKeys("dieulinhthieuthitest@gmail.com"); 
        driver.findElement(By.xpath("//input[@id='customer_password']")).sendKeys("Maybi00.vn"); 
        driver.findElement(By.xpath("//button[@value='Đăng nhập']")).click(); 
        Utils.hardWait();
        
        
        String errorMessage = driver.findElement(By.xpath("//div[@class='form-signup margin-bottom-15']")).getText();
        String expectedMessage = "Thông tin đăng nhập không hợp lệ.";
        Assert.assertEquals(errorMessage, expectedMessage);
        
        System.out.println("ii. Dang nhap tai khoan hop le");

    }
    @Test
    public void LG04(){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        // Nhap mat khau khong hop le
        System.out.println("i. Launch Browser :'https://maybi.com/'");
        driver.get("https://maybi.com/");
        Utils.hardWait();
        driver.get("https://maybi.com/account/login");
        Utils.hardWait();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Tài khoản";
        Assert.assertEquals(actualTitle, expectedTitle);
        // Thông tin đăng nhập không hợp lệ.
        driver.findElement(By.xpath("//input[@id='customer_email']")).sendKeys("dieulinhthieuthi@gmail.com"); 
        driver.findElement(By.xpath("//input[@id='customer_password']")).sendKeys("Maybi01.vn"); 
        driver.findElement(By.xpath("//button[@value='Đăng nhập']")).click(); 
        Utils.hardWait();
        
        
        String errorMessage = driver.findElement(By.xpath("//div[@class='form-signup margin-bottom-15']")).getText();
        String expectedMessage = "Thông tin đăng nhập không hợp lệ.";
        Assert.assertEquals(errorMessage, expectedMessage);
        
        System.out.println("ii. Dang nhap tai khoan hop le");
    }


    @Test
    public void LG05(){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        // Nhap mat khau khong hop le
        System.out.println("i. Launch Browser :'https://maybi.com/'");
        driver.get("https://maybi.com/");
        Utils.hardWait();
        driver.get("https://maybi.com/account/login");
        Utils.hardWait();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Tài khoản";
        Assert.assertEquals(actualTitle, expectedTitle);
        // Thông tin đăng nhập không hợp lệ.
        driver.findElement(By.xpath("//button[@value='Đăng nhập']")).click(); 
        Utils.hardWait();
        
        // String validationMessage = username.getAttribute("validationMessage");
        String errorMessage = driver.findElement(By.xpath("//input[@id='customer_email']")).getAttribute("validationMessage");
        String expectedMessage = "Please fill out this field.";
        Assert.assertEquals(errorMessage, expectedMessage);
        
        System.out.println("ii. Dang nhap tai khoan hop le");
    }
}    
   
