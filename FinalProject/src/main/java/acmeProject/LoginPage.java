package acmeProject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginPage {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe"); // giving full path
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://acme-test.uipath.com/account/login");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.findElementById("email").sendKeys("kumar.testleaf@gmail.com",Keys.TAB);
		driver.findElementById("password").sendKeys("leaf@12");
		driver.findElementById("buttonLogin").click();
		Thread.sleep(2000);
		
		Actions action=new Actions(driver);
		WebElement vendorhover=driver.findElementByXPath("(//button[@class='btn btn-default btn-lg'])[4]");
		action.moveToElement(vendorhover).perform();
		driver.findElementByLinkText("Search for Vendor").click();
		driver.findElementById("vendorName").sendKeys("Blue Lagoon");
		driver.findElementById("buttonSearch").click();
		
		
		String countryName=driver.findElementByXPath("//table[@class='table']//td[5]").getText();
		System.out.println(countryName);
		
				
		
		//List<WebElement> rows = driver.findElementsByXPath("//table[@class='table']//td[5]");
		/*for (int i = 1; i <=rows.size(); i++) {
		String vendorName = driver.findElementByXPath("//table[@class='table']//tr["+i+"]/td[1]").getText();
		System.out.println(vendorName);
		if(vendorName.contains("Blue Lagoon")) {
			System.out.println(driver.findElementByXPath("//table[@class='table']//tr["+i+"]/td[5]").getText());
		}
	}*/
		
	}

}
