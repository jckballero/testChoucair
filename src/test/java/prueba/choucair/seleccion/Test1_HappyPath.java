package prueba.choucair.seleccion;

//import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1_HappyPath {
	
	private WebDriver driver;
	By empleosLinkLocator = By.linkText("Empleos");
	By imgEmpleosPageLocator = By.xpath("//img[@src='https://www.choucairtesting.com/wp-content/uploads/2019/07/banner.png']");
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/driver_chrome/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.choucairtesting.com/");
			
	}
	
	
	@Test
	public void ingresoChocairTestingWeb() throws InterruptedException {
		
		driver.findElement(empleosLinkLocator).click();	
		Thread.sleep(2000); //2 SEGUNDOS DE ESPERA
		if(driver.findElement(imgEmpleosPageLocator).isDisplayed()) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			//SCROLL DOWN
			js.executeScript("window.scrollBy(0,500)", ""); 
			Thread.sleep(5000);
			js.executeScript("window.scrollBy(0,510)", ""); 
			Thread.sleep(5000);
			js.executeScript("window.scrollBy(0,610)", ""); 
			Thread.sleep(5000);
			js.executeScript("window.scrollBy(0,920)", ""); 
			Thread.sleep(5000);
			js.executeScript("window.scrollBy(0,980)", ""); 
			Thread.sleep(5000);
			//SCROLL UP
			js.executeScript("window.scrollBy(0,-3540)", ""); 
			Thread.sleep(5000);
		
			System.out.println("Estas en la pagina correcta");
		}else {
			System.out.println("Algo salió mal, no estas la página.");
		}
		
	} 
	
	@After
	public void tearDown() throws InterruptedException {
		//Thread.sleep(5000); //2 SEGUNDOS DE ESPERA, PARA CERRAR
		//driver.quit();
	}

}
