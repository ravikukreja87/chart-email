package chart.email;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateChart {

	public void createChart(String scripName) throws Exception {
		WebDriver driver = null;
		try {
			System.setProperty("webdriver.chrome.driver", "res/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://in.tradingview.com/login");
			Thread.sleep(5000);
			driver.findElement(By.xpath("(//a[text()='Sign In'])[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[text()='Username or Email']")).clear();
			driver.findElement(By.xpath("//span[text()='Username or Email']")).click();
			driver.findElement(By.xpath("//span[text()='Username or Email']")).sendKeys("ravikukreja");
			driver.findElement(By.xpath("(//span[text()='Password'])[1]")).sendKeys("Under87Taker");
			driver.findElement(By.xpath("//span[text()='Log In']")).click();
			Thread.sleep(5000);
			driver.get("https://in.tradingview.com/chart/");
			Thread.sleep(5000);			
			driver.findElement(By.cssSelector("div[data-symbol-short='PIDILITIND']")).click();
			
			driver.findElement(By.cssSelector("div[id='header-toolbar-intervals'] > div")).click();
			Thread.sleep(5000);
			driver.findElement(By.cssSelector("div[data-value='1W']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@id='header-toolbar-symbol-search']//input")).clear();
			driver.findElement(By.xpath("//div[@id='header-toolbar-symbol-search']//input")).click();
			driver.findElement(By.xpath("//div[@id='header-toolbar-symbol-search']//input")).sendKeys(scripName);
			driver.findElement(By.xpath("//div[@id='header-toolbar-symbol-search']//input")).sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			driver.findElement(By.cssSelector("#header-toolbar-indicators > div")).click();
			Thread.sleep(5000);
			driver.findElement(By.cssSelector("input[data-role='search']")).clear();
			driver.findElement(By.cssSelector("input[data-role='search']")).click();
			driver.findElement(By.cssSelector("input[data-role='search']")).sendKeys("MACD");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@data-role='list-item']//span[@title='MACD']")).click();
			Thread.sleep(5000);
			driver.findElement(By.cssSelector("input[data-role='search']")).clear();
			driver.findElement(By.cssSelector("input[data-role='search']")).click();
			driver.findElement(By.cssSelector("input[data-role='search']")).sendKeys("RSI");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@data-role='list-item']//span[@title='Relative Strength Index']"))
					.click();
			Thread.sleep(5000);
			driver.findElement(By.cssSelector("span[data-name='close']")).click();
			Thread.sleep(5000);
			driver.manage().window().maximize();
			driver.findElement(By.xpath("//div[contains(text(),'1Y')]")).click();
			String ssName = "resources/" + scripName.replace(":", "") + "-"
					+ new SimpleDateFormat("dd.MM.yyyy").format(new Date()) + ".PNG";
			Thread.sleep(5000);
			driver.findElement(By.cssSelector("div[id='header-toolbar-intervals'] > div")).click();
			Thread.sleep(5000);
			driver.findElement(By.cssSelector("div[data-value='1W']")).click();
			Thread.sleep(5000);
			TakeSS.takeSnapShot(driver, ssName);
			Thread.sleep(5000);
			Email.triggerEMail(ssName, scripName);
		} catch (Exception e) {
			System.out.println("Exception Caught!!! ::- " + e.getMessage());
		} finally {
			driver.close();
			driver.quit();
		}
	}
}