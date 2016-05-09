package StroeBack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
@Test
public class test001 {
	
	static String Url = "http://adminprodq.700paper.cn/admin/refreshcache";
	static String TestUrl ="http://adminprodq.700paper.cn/admin/refreshcache";
	static WebElement name;
	static WebElement password;
	static WebElement SubMmit;
	static WebElement Page;
//	public static void main(String[] args) {
	public static void checkUrl(){
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		driver.get(Url);
		name = driver.findElement(By.xpath(".//*[@id='txtUserName']"));
		password = driver.findElement(By.xpath(".//*[@id='txtPassword']"));
		SubMmit = driver.findElement(By.xpath(".//*[@id='btnLogin']"));
		
		name.sendKeys("administrator");
		password.sendKeys("111111");
		SubMmit.click();
		
		Page = driver.findElement(By.linkText("刷新缓存"));
		Page.click();
		String CheckUrl = driver.getCurrentUrl();
		System.out.println(CheckUrl);
		System.out.println(TestUrl);
		Assert.assertEquals(CheckUrl,TestUrl,"可以查看缓存了");

		
		
	}

}
