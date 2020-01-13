package prueba.choucair.seleccion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test3_OpcConvocatorias {
	private WebDriver driver;
	
	By imgEmpleosPageLocator = By.xpath("//img[@src='https://www.choucairtesting.com/wp-content/uploads/2019/07/banner.png']");
	By palabraClaveLocator = By.id("search_keywords");
	By busquedaLocator = By.id("search_location");
	By imgAnalistaLocator = By.xpath("//img[@src='https://www.choucairtesting.com/wp-content/uploads/2019/07/analista_pruebas.jpg']");
	
	By nombreLocator = By.name("your-name");
	By mailLocator = By.name("your-email");
	By telefonoLocator = By.name("tel");
	By estudiosLocator = By.name("estudios");
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/driver_chrome/chromedriver.exe");
	  	driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.choucairtesting.com/empleos-2/");
	}
	
	
	@Test
	public void ingresoChocairTestingWeb() throws InterruptedException {
		
		if(driver.findElement(imgEmpleosPageLocator).isDisplayed()) {
			driver.findElement(palabraClaveLocator).sendKeys("Analista de Pruebas Panamá");
			driver.findElement(busquedaLocator).sendKeys("Panama");
			Thread.sleep(5000);
			driver.findElement(By.partialLinkText("Analista de Pruebas")).click();
			System.out.println("Estas en la página correcta.");
			
			Thread.sleep(5000);
			
			if(driver.findElement(imgAnalistaLocator).isDisplayed()) {
				//driver.findElement(inscribirseLocator).click();
				System.out.println("Ingresaste a la sección, Analista de pruebas Panamá.");
				
				JavascriptExecutor js = (JavascriptExecutor)driver;
				//SCROLL DOWN
				js.executeScript("window.scrollBy(0,2500)", ""); 
				Thread.sleep(2000);
				//SCROLL UP
				js.executeScript("window.scrollBy(0,-550)", ""); 
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//*[@id=\"post-7569\"]/div/div[2]/div[3]/input")).click();
				driver.findElement(nombreLocator).sendKeys("Jean Carlos Caballero");
				driver.findElement(mailLocator).sendKeys("jean.caballero29@hotmail.com");
				driver.findElement(telefonoLocator).sendKeys("+507 62062136");
				driver.findElement(estudiosLocator).sendKeys("Solo se llenara el formulario hasta casilla, una vez mostrado regresará a la sección Choucair Empleos.");
				Thread.sleep(5000);
				driver.navigate().back();
				js.executeScript("window.scrollBy(0,-2800)", ""); 
				Thread.sleep(5000);
				
			}else {
				System.out.println("Algo salió mal, no estas la página Analista de pruebas Panamá.");
			}
			
		}else {
			System.out.println("Algo salió mal, no estas la página.");
		}
		
	} 
	
	@After
	public void tearDown() throws InterruptedException {
		//Thread.sleep(5000); //2 SEGUNDOS DE ESPERA, PARA CERRAR
		//driver.quit(); //CERRAR EL NAVEGAR (recomendación: comentar para hacer las pruebas)
	}
}
