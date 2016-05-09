package lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Qinghua {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		WebDriver driver=new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
        driver.get("http://www.tsinghua.edu.cn/");
        
        
        WebElement gaikuang=driver.findElement(By.xpath("//*[@id='nav']/li[2]/a"));
        
        Actions action =new Actions(driver); 
        action.moveToElement(gaikuang).click().perform();
       /*  List <WebElement> elements=driver.findElements(By.tagName("a"));
         
        for(int i=0;i<elements.size();i++){
            System.out.println(i+"------>"+elements.get(i).getText());
            }
         action.moveToElement(elements.get(6)).click().perform();*/
        WebElement xiaozhang=driver.findElement(By.linkText("现任领导"));
        System.out.println(xiaozhang.getText());
        xiaozhang.click();
         
         System.out.println(driver.getCurrentUrl());

        driver.quit();
	}

}
