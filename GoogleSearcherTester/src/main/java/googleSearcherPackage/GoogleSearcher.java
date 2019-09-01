package googleSearcherPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearcher
{
  public static void main( String[] args )
  {
    WebDriver driver;
    System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
    driver = new ChromeDriver();	
    driver.get("https://www.google.com/");
    driver.findElement(By.name("q")).sendKeys(args);
	driver.findElement(By.name("q")).submit();			
	String rC = driver.findElement(By.id("resultStats")).getText();
	String[] rCA = rC.split(" ");
	System.out.println();
    System.out.println("Found " + rCA[1] + " " + rCA[2] + " for " + args[0]);
    System.out.println();
    List<WebElement> titles = driver.findElements(By.xpath("//div//h2[text()=\"Web results\"]/following-sibling::div//div[@class='ellip']"));
    List<WebElement> links = driver.findElements(By.xpath("//div//h2[text()=\"Web results\"]/following-sibling::div//cite"));
     
    System.out.println("First 10 results:");
    System.out.println();
        
    for(int i = 0; i < titles.size(); i++) {
      String title = titles.get(i).getText();
      System.out.println(" * " + title);	        
      String link = links.get(i).getText();
      System.out.println(link);
      System.out.println();
    }
        
    driver.findElement(By.xpath("//span[text()='Next']")).click();
        
    List<WebElement> titles1 = driver.findElements(By.xpath("//div//h2[text()=\"Web results\"]/following-sibling::div//div[@class='ellip']"));
    List<WebElement> links1 = driver.findElements(By.xpath("//div//h2[text()=\"Web results\"]/following-sibling::div//cite"));
        
    for(int j = 0; j < 10 - titles.size(); j++) {
      String title = titles1.get(j).getText();
      System.out.println(" * " + title);	        
	  String link = links1.get(j).getText();
	  System.out.println(link);
	  System.out.println(); 	
    }
	driver.quit();			
	}		
		
}