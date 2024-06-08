package com.sat.maybi;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.sat.utils.BasicTest;
import com.sat.utils.Utils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Alert;

public class Addtocart_Test extends BasicTest {
   @Test
    public void ATC01() {

        System.out.println("i. Launch Browser + ii. Navigate to https://maybi.com/");
        driver.get("https://maybi.com/");
        Utils.hardWait();
        WebElement giohang = driver.findElement(By.xpath("//a[@class='icon_hd header-icon cart-count ega-color--inherit']"));
        Assert.assertTrue(giohang.isDisplayed());  
    }
    @Test
    public void ATC02() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        System.out.println("i. Launch Browser + ii. Navigate to https://maybi.com/");
        driver.get("https://maybi.com/");
        Utils.hardWait();
        WebElement maybi = driver.findElement(By.xpath("(//a[@title='Đầm midi xòe pho xéo nhún hai bên tùng'])[1]"));
        jse.executeScript("arguments[0].scrollIntoView(true);", maybi );
        Utils.hardWait();
        driver.findElement(By.xpath("(//a[@title='Đầm midi xòe pho xéo nhún hai bên tùng'])[1]")).click(); 
        WebElement themgiohang = driver.findElement(By.xpath("//strong[contains(text(),'Các mã giảm có thể áp dụng ở bước thanh toán')]"));
        jse.executeScript("arguments[0].scrollIntoView(true);", themgiohang );
        driver.findElement(By.xpath("(//button[@class='btn btn_num num_2 button button_qty'])[1]")).click();
        Utils.hardWait();
        driver.findElement(By.xpath("(//button[@class='btn btn_num num_2 button button_qty'])[1]")).click();
        Utils.hardWait();        
        driver.findElement(By.xpath("(//button[contains(text(),'THÊM VÀO GIỎ')])[1]")).click(); 
        Utils.hardWait();
        WebElement emailTextbox = driver.findElement(By.xpath("//h3[@class='modal-title']"));
        Assert.assertTrue(emailTextbox.isDisplayed());
        Utils.hardWait();
        driver.findElement(By.xpath("//a[contains(text(),'Xem giỏ hàng')]")).click(); 
        Utils.hardWait();
        String curentUrl = driver.getCurrentUrl();
        Assert.assertTrue(curentUrl.contains("https://maybi.com/cart"));
        Utils.hardWait();
    }
    @Test
    public void ATC03() {
           JavascriptExecutor jse = (JavascriptExecutor) driver;
           System.out.println("i. Launch Browser + ii. Navigate to https://maybi.com/");
           driver.get("https://maybi.com/");
           Utils.hardWait();
           WebElement maybi = driver.findElement(By.xpath("(//a[@title='Đầm midi xòe pho xéo nhún hai bên tùng'])[1]"));
           jse.executeScript("arguments[0].scrollIntoView(true);", maybi );
           Utils.hardWait();
           driver.findElement(By.xpath("(//a[@title='Đầm midi xòe pho xéo nhún hai bên tùng'])[1]")).click(); 
           WebElement themgiohang = driver.findElement(By.xpath("//strong[contains(text(),'Các mã giảm có thể áp dụng ở bước thanh toán')]"));
           jse.executeScript("arguments[0].scrollIntoView(true);", themgiohang );
           Utils.hardWait();
           driver.findElement(By.xpath("(//button[@class='btn btn_num num_2 button button_qty'])[1]")).click();
           Utils.hardWait();
           driver.findElement(By.xpath("(//button[@class='btn btn_num num_2 button button_qty'])[1]")).click();
           Utils.hardWait();        
           driver.findElement(By.xpath("(//button[contains(text(),'THÊM VÀO GIỎ')])[1]")).click(); 
           Utils.hardWait();
           WebElement emailTextbox = driver.findElement(By.xpath("//h3[@class='modal-title']"));
           Assert.assertTrue(emailTextbox.isDisplayed());
           Utils.hardWait();
           driver.findElement(By.xpath("//a[contains(text(),'Xem giỏ hàng')]")).click(); 
           Utils.hardWait();
           String curentUrl = driver.getCurrentUrl();
           Assert.assertTrue(curentUrl.contains("https://maybi.com/cart"));
           Utils.hardWait();
    }
     @Test
    public void ATC04() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        System.out.println("i. Launch Browser + ii. Navigate to https://maybi.com/");
        driver.get("https://maybi.com/");
        Utils.hardWait();
        WebElement maybi = driver.findElement(By.xpath("(//a[@title='Đầm midi xòe pho xéo nhún hai bên tùng'])[1]"));
        jse.executeScript("arguments[0].scrollIntoView(true);", maybi );
        Utils.hardWait();
        driver.findElement(By.xpath("(//a[@title='Đầm midi xòe pho xéo nhún hai bên tùng'])[1]")).click(); 
        WebElement themgiohang = driver.findElement(By.xpath("//strong[contains(text(),'Các mã giảm có thể áp dụng ở bước thanh toán')]"));
        jse.executeScript("arguments[0].scrollIntoView(true);", themgiohang );
        Utils.hardWait();
        driver.findElement(By.xpath("(//button[contains(text(),'THÊM VÀO GIỎ')])[1]")).click(); 
        Utils.hardWait();
        driver.findElement(By.xpath("//a[contains(text(),'Xem giỏ hàng')]")).click(); 
        Utils.hardWait();
         //tro ve trang chu
        driver.findElement(By.xpath("(//img[@class='img-fluid'])[1]")).click(); 
        Utils.hardWait();
         //them san pham thu 2
        WebElement maybi2 = driver.findElement(By.xpath("(//a[@title='Đầm midi xòe pho xéo nhún hai bên tùng'])[1]"));
        jse.executeScript("arguments[0].scrollIntoView(true);", maybi2 );
        Utils.hardWait();
        driver.findElement(By.xpath("(//a[@title='Áo kiểu tơ xốp xếp ly vai'])[2]")).click(); 
        WebElement themgiohang2 = driver.findElement(By.xpath("//strong[contains(text(),'Các mã giảm có thể áp dụng ở bước thanh toán')]"));
        jse.executeScript("arguments[0].scrollIntoView(true);", themgiohang2 );
        Utils.hardWait();
        driver.findElement(By.xpath("(//button[contains(text(),'THÊM VÀO GIỎ')])[1]")).click(); 
        Utils.hardWait();
        WebElement emailTextbox = driver.findElement(By.xpath("//h3[@class='modal-title']"));
        Assert.assertTrue(emailTextbox.isDisplayed());
        Utils.hardWait();
        driver.findElement(By.xpath("//a[contains(text(),'Xem giỏ hàng')]")).click(); 
        Utils.hardWait();
        String curentUrl = driver.getCurrentUrl();
        Assert.assertTrue(curentUrl.contains("https://maybi.com/cart"));
        Utils.hardWait();
    }
     @Test
    public void ATC05() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        System.out.println("i. Launch Browser + ii. Navigate to https://maybi.com/");
        driver.get("https://maybi.com/");
        Utils.hardWait();
        WebElement maybi = driver.findElement(By.xpath("(//a[@title='Đầm midi xòe pho xéo nhún hai bên tùng'])[1]"));
        jse.executeScript("arguments[0].scrollIntoView(true);", maybi );
        Utils.hardWait();
        driver.findElement(By.xpath("(//a[@title='Đầm midi xòe pho xéo nhún hai bên tùng'])[1]")).click(); 
        WebElement themgiohang = driver.findElement(By.xpath("//strong[contains(text(),'Các mã giảm có thể áp dụng ở bước thanh toán')]"));
        jse.executeScript("arguments[0].scrollIntoView(true);", themgiohang );
        Utils.hardWait();
        driver.findElement(By.xpath("(//button[contains(text(),'THÊM VÀO GIỎ')])[1]")).click(); 
        Utils.hardWait();
        WebElement emailTextbox = driver.findElement(By.xpath("//h3[@class='modal-title']"));
        Assert.assertTrue(emailTextbox.isDisplayed());
        Utils.hardWait();
        driver.findElement(By.xpath("//a[contains(text(),'Xem giỏ hàng')]")).click(); 
        Utils.hardWait();
           //tro ve trang chu
        driver.findElement(By.xpath("(//img[@class='img-fluid'])[1]")).click(); 
        Utils.hardWait();
           //them san pham thu mau khac
        WebElement maybi5 = driver.findElement(By.xpath("(//a[@title='Đầm midi xòe pho xéo nhún hai bên tùng'])[1]"));
        jse.executeScript("arguments[0].scrollIntoView(true);", maybi5 );
        Utils.hardWait();
        driver.findElement(By.xpath("(//img[@class='img-fetured'])[1]")).click(); 
        WebElement themgiohang5 = driver.findElement(By.xpath("//strong[contains(text(),'Các mã giảm có thể áp dụng ở bước thanh toán')]"));
        jse.executeScript("arguments[0].scrollIntoView(true);", themgiohang5 );
        Utils.hardWait();
           //chon mau
        driver.findElement(By.xpath("//input[@id='swatch-0-den']")).click(); 
        Utils.hardWait();
        driver.findElement(By.xpath("(//button[contains(text(),'THÊM VÀO GIỎ')])[1]")).click(); 
        Utils.hardWait();
        WebElement emailTextbox2 = driver.findElement(By.xpath("//h3[@class='modal-title']"));
        Assert.assertTrue(emailTextbox2.isDisplayed());
        Utils.hardWait();
        driver.findElement(By.xpath("//a[contains(text(),'Xem giỏ hàng')]")).click(); 
        Utils.hardWait();
        String curentUrl = driver.getCurrentUrl();
        Assert.assertTrue(curentUrl.contains("https://maybi.com/cart"));
        Utils.hardWait();
    }
     @Test
    public void ATC06() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        System.out.println("i. Launch Browser + ii. Navigate to https://maybi.com/");
        driver.get("https://maybi.com/");
        Utils.hardWait();
        WebElement maybi = driver.findElement(By.xpath("(//a[@title='Đầm midi xòe pho xéo nhún hai bên tùng'])[1]"));
        jse.executeScript("arguments[0].scrollIntoView(true);", maybi );
        Utils.hardWait();
        driver.findElement(By.xpath("(//a[@title='Áo kiểu tơ xốp xếp ly vai'])[2]")).click(); 
        Utils.hardWait();
        WebElement themgiohang = driver.findElement(By.xpath("//strong[contains(text(),'Các mã giảm có thể áp dụng ở bước thanh toán')]"));
        jse.executeScript("arguments[0].scrollIntoView(true);", themgiohang );
        Utils.hardWait();
        driver.findElement(By.xpath("(//button[contains(text(),'THÊM VÀO GIỎ')])[1]")).click(); 
        Utils.hardWait();
        driver.findElement(By.xpath("//a[contains(text(),'Xem giỏ hàng')]")).click(); 
        Utils.hardWait();
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("00"); 
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(Keys.ENTER);
        Utils.hardWait();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alert.getText());
        alert.accept();
        Assert.assertEquals(alertText, "Sản phẩm đã vượt quá tồn kho");
      }  
} 
