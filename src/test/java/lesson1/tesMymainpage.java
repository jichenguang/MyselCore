package lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class tesMymainpage {
	
	static String url = "https://www.zhihu.com/#signin";

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver mydriver = new FirefoxDriver();
		mydriver.get(url);
		
		WebElement name = mydriver.findElement(By.name("account"));
		name.sendKeys("18611360619");
		
		WebElement password = mydriver.findElement(By.name("password"));
		password.sendKeys("mljicj00");
		
		WebElement button = mydriver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/form/div[3]/button"));
		button.click();
		
		

//		WebElement e = mydriver.findElement(By.xpath(".//*[@id=':0']/span[1]"));
		
		

		Thread.sleep(3000);		
		Actions action = new Actions(mydriver);
		WebElement e = (new WebDriverWait( mydriver, 10)).until(
			    new ExpectedCondition< WebElement>(){
			        public WebElement apply( WebDriver d) {
			            return d.findElement(By.xpath("//div[@class='top-nav-profile']//img[@class='Avatar']"));
			        }
			    }
			    );
//				这个方法无法取得弹出层
			    action.clickAndHold(e).perform();
//				这个方法可以解决弹出层无法定位的问题
//				action.moveToElement(e).click().perform();
			    System.out.println("找到头像");
			   
			    
			    Thread.sleep(3000);
			    
			    System.out.println("查找我的主页元素");			    
			    WebElement g = (new WebDriverWait( mydriver, 10)).until(
					    new ExpectedCondition< WebElement>(){
					        public WebElement apply( WebDriver d) {
					            return d.findElement(By.xpath(".//*[@id=':1']"));
					        }
					    }
					    );
//				WebElement g = mydriver.findElement(By.xpath(".//*[@id=':4']"));
				System.out.println(g.getText());	
				Thread.sleep(3000);
//				这是一句很重要的代码:
//				1、--action.moveToElement(e).click().perform();专门用于悬浮移动鼠标定位
//				2、这一句专门用于JS点击弹出层元素
		        ((JavascriptExecutor)mydriver).executeScript("arguments[0].click();", g);

	
	}

}
