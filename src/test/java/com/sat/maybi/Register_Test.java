package com.sat.maybi;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.sat.utils.BasicTest;
import com.sat.utils.Utils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;


public class Register_Test extends BasicTest {
    
 @Test
  public void RG01() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        // Dang ky tai khoan 
        
        System.out.println("i. Launch Browser :'https://maybi.com/'");
        driver.get("https://maybi.com/");
        Utils.hardWait();
        driver.get("https://maybi.com/account/register");
        Utils.hardWait();
        WebElement DangNhap = driver.findElement(By.xpath("(//a[contains(@href,'/account/login')])[2]"));
        Assert.assertTrue(DangNhap.isDisplayed());
        WebElement dangky = driver.findElement(By.xpath("//h1[@class='title_page mb-0']"));
        jse.executeScript("arguments[0].scrollIntoView(true);", dangky );
        Utils.hardWait();
        // kiem tra co hien thi textbox ho, ten, sdt, email, mat khau
        WebElement Ho = driver.findElement(By.xpath("//input[@id='lastName']"));
        Assert.assertTrue(Ho.isDisplayed());
        WebElement Ten = driver.findElement(By.xpath("//input[@id='firstName']"));
        Assert.assertTrue(Ten.isDisplayed());
        WebElement SDT = driver.findElement(By.xpath("//input[@id='Phone']"));
        Assert.assertTrue(SDT.isDisplayed());
        WebElement Email = driver.findElement(By.xpath("//input[@id='email']"));
        Assert.assertTrue(Email.isDisplayed());
        WebElement Matkhau = driver.findElement(By.xpath("//input[@id='password']"));
        Assert.assertTrue(Matkhau.isDisplayed());
        WebElement Dangky = driver.findElement(By.xpath("//button[@value='Đăng ký']"));
        Assert.assertTrue(Dangky.isDisplayed());     
    }
  @Test
    public void RG02() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        
        System.out.println("i. Launch Browser :'https://maybi.com/'");
        driver.get("https://maybi.com/");
        Utils.hardWait();
        driver.get("https://maybi.com/account/register");
        Utils.hardWait();
        WebElement dangky = driver.findElement(By.xpath("//h1[@class='title_page mb-0']"));
        jse.executeScript("arguments[0].scrollIntoView(true);", dangky );
        Utils.hardWait();
        //nhap thong tin
        driver.findElement(By.xpath("//button[@value='Đăng ký']")).click(); 
        Utils.hardWait();
        String errorMessage = driver.findElement(By.xpath("//input[@id='lastName']")).getAttribute("validationMessage");
        String expectedMessage = "Please fill out this field.";
        Assert.assertEquals(errorMessage, expectedMessage);
      }  
 @Test
    public void RG03() {
      //Nhập sai định dạng email
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        
        System.out.println("i. Launch Browser :'https://maybi.com/'");
        driver.get("https://maybi.com/");
        Utils.hardWait();
        driver.get("https://maybi.com/account/register");
        Utils.hardWait();
        WebElement dangky = driver.findElement(By.xpath("//h1[@class='title_page mb-0']"));
        jse.executeScript("arguments[0].scrollIntoView(true);", dangky );
        Utils.hardWait();
        //nhap thong tin
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("TEST");
        Utils.hardWait(100); 
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("01");
        Utils.hardWait(100); 
        driver.findElement(By.xpath("//input[@id='Phone']")).sendKeys("0374404395");
        Utils.hardWait(100); 
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("TEST");
        Utils.hardWait(100); 
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Maybi00.vn");
        Utils.hardWait(100); 
        driver.findElement(By.xpath("//button[@value='Đăng ký']")).click();
        Utils.hardWait();
        String errorMessage = driver.findElement(By.xpath("//input[@id='email']")).getAttribute("validationMessage");
        String expectedMessage = "Please include an '@' in the email address. 'TEST' is missing an '@'.";
        Assert.assertEquals(errorMessage, expectedMessage);
    }
@Test
    public void RG04() {
      //Nhập sai định dạng SDT
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        
        System.out.println("i. Launch Browser :'https://maybi.com/'");
        driver.get("https://maybi.com/");
        Utils.hardWait();
        //Nhap lan 1
        driver.get("https://maybi.com/account/register");
        Utils.hardWait();
        WebElement dangky = driver.findElement(By.xpath("//h1[@class='title_page mb-0']"));
        jse.executeScript("arguments[0].scrollIntoView(true);", dangky );
        Utils.hardWait();
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("TEST");
        Utils.hardWait(1000); 
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("01");
        Utils.hardWait(1009); 
        driver.findElement(By.xpath("//input[@id='Phone']")).sendKeys("037");
        Utils.hardWait(1000); 
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("6151071066@st.utc2.edu.vn");
        Utils.hardWait(1000); 
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Maybi00.vn");
        Utils.hardWait(1000); 
        driver.findElement(By.xpath("//button[@value='Đăng ký']")).click();
        WebElement Dangky = driver.findElement(By.xpath("//li[contains(text(),'Số điện thoại không hợp lệ')]"));
        Assert.assertTrue(Dangky.isDisplayed());  
    }
  @Test
    public void RG05() {
      //Nhập sai định dạng SDT
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        
        System.out.println("i. Launch Browser :'https://maybi.com/'");
        driver.get("https://maybi.com/");
        Utils.hardWait();
        // Nhap lan 2
        driver.get("https://maybi.com/account/register");
        Utils.hardWait();
        WebElement dangky2 = driver.findElement(By.xpath("//h1[@class='title_page mb-0']"));
        jse.executeScript("arguments[0].scrollIntoView(true);", dangky2 );
        Utils.hardWait();
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("TEST");
        Utils.hardWait(1000); 
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("01");
        Utils.hardWait(1009); 
        driver.findElement(By.xpath("//input[@id='Phone']")).sendKeys("TEST");
        Utils.hardWait(1000); 
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("6151071066@st.utc2.edu.vn");
        Utils.hardWait(1000); 
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Maybi00.vn");
        Utils.hardWait(1000); 
        driver.findElement(By.xpath("//button[@value='Đăng ký']")).click();
        String errorMessage = driver.findElement(By.xpath("//input[@id='Phone']")).getAttribute("validationMessage");
        String expectedMessage = "Please match the requested format.";
        Assert.assertEquals(errorMessage, expectedMessage);
        Utils.hardWait();
    }
@Test
    public void RG06() {
      //Nhập sai định dạng mật khẩu
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        
        System.out.println("i. Launch Browser :'https://maybi.com/'");
        driver.get("https://maybi.com/");
        Utils.hardWait();
        driver.get("https://maybi.com/account/register");
        Utils.hardWait();
        WebElement dangky = driver.findElement(By.xpath("//h1[@class='title_page mb-0']"));
        jse.executeScript("arguments[0].scrollIntoView(true);", dangky );
        Utils.hardWait();
        //nhap thong tin
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("TEST");
        Utils.hardWait(1000); 
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("01");
        Utils.hardWait(1009); 
        driver.findElement(By.xpath("//input[@id='Phone']")).sendKeys("0374404395");
        Utils.hardWait(1000); 
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("6151071066@st.utc2.edu.vn");
        Utils.hardWait(1000); 
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("TEST");
        Utils.hardWait(1000); 
        driver.findElement(By.xpath("//button[@value='Đăng ký']")).click();
        WebElement Dangky = driver.findElement(By.xpath("//li[contains(text(),'Mật khẩu quá ngắn (tối thiểu 5 ký tự).')]"));
        Assert.assertTrue(Dangky.isDisplayed());  
        Utils.hardWait();
} 
@Test
    public void RG07() {
      //Báo lỗi khi nhập email đã được sử dụng
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        
        System.out.println("i. Launch Browser :'https://maybi.com/'");
        driver.get("https://maybi.com/");
        Utils.hardWait();
        driver.get("https://maybi.com/account/register");
        Utils.hardWait();
        WebElement dangky = driver.findElement(By.xpath("//h1[@class='title_page mb-0']"));
        jse.executeScript("arguments[0].scrollIntoView(true);", dangky );
        Utils.hardWait();
        //nhap thong tin
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("TEST");
        Utils.hardWait(1000); 
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("01");
        Utils.hardWait(1009); 
        driver.findElement(By.xpath("//input[@id='Phone']")).sendKeys("0374404395");
        Utils.hardWait(1000); 
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("dieulinhthieuthi@gmail.com");
        Utils.hardWait(1000); 
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("TEST");
        Utils.hardWait(1000); 
        driver.findElement(By.xpath("//button[@value='Đăng ký']")).click();
        Utils.hardWait();
        WebElement Dangky = driver.findElement(By.xpath("//a[@href='/account/login#recover']"));
        Assert.assertTrue(Dangky.isDisplayed()); 
        Utils.hardWait();
    }
@Test
    public void RG08() {
      //Điều hướng đến trang đặt lại mật khẩu
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        
        System.out.println("i. Launch Browser :'https://maybi.com/'");
        driver.get("https://maybi.com/");
        Utils.hardWait();
        driver.get("https://maybi.com/account/register");
        Utils.hardWait();
        WebElement dangky = driver.findElement(By.xpath("//h1[@class='title_page mb-0']"));
        jse.executeScript("arguments[0].scrollIntoView(true);", dangky );
        Utils.hardWait();
        //nhap thong tin
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("TEST");
        Utils.hardWait(1000); 
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("01");
        Utils.hardWait(1009); 
        driver.findElement(By.xpath("//input[@id='Phone']")).sendKeys("0374404395");
        Utils.hardWait(1000); 
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("dieulinhthieuthi@gmail.com");
        Utils.hardWait(1000); 
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("TEST");
        Utils.hardWait(1000); 
        driver.findElement(By.xpath("//button[@value='Đăng ký']")).click(); 
        Utils.hardWait();
        driver.findElement(By.xpath("//a[@href='/account/login#recover']")).click(); 
        Utils.hardWait();
        String curentUrl = driver.getCurrentUrl();
        Assert.assertTrue(curentUrl.contains("https://maybi.com/account/login#recover"));
        Utils.hardWait();
} 
@Test
    public void RG09() {
      //Điều hướng đến trang đăng nhập
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        
        System.out.println("i. Launch Browser :'https://maybi.com/'");
        driver.get("https://maybi.com/");
        Utils.hardWait();
        driver.get("https://maybi.com/account/register");
        Utils.hardWait();
        driver.findElement(By.xpath("(//a[contains(@href,'/account/login')])[2]")).click(); 
        Utils.hardWait();
        String curentUrl = driver.getCurrentUrl();
        Assert.assertTrue(curentUrl.contains("https://maybi.com/account/login"));
        Utils.hardWait();
       
 } 
}
