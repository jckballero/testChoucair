package prueba.choucair.seleccion;

import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test2_SeccionEmpleados {
	private WebDriver driver;
	By empleosLinkLocator = By.linkText("Empleos");
	By imgEmpleosPageLocator = By.xpath("//img[@src='https://www.choucairtesting.com/wp-content/uploads/2019/07/banner.png']");
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/driver_chrome/chromedriver.exe");

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Escoge una opción");
		System.out.println("1. Prueba exploratoria");
		System.out.println("2. Prueba de stress en multiples navegadores navegador");
		System.out.println("3. Prueba de stress en el mismo navegador");
		
		int eleccion;
		eleccion = sc.nextInt();
		switch (eleccion) {
		  case 1:
			  System.out.println("Iniciando prueba exploratoria");
			  	driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://www.choucairtesting.com/empleos-2/");
		    break;
		  case 2:
			  System.out.println("Prueba de stress abriendo multiples navegadores");
			  for(int i = 1; i <= 51; i++) {
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://www.choucairtesting.com/empleos-2/");
				System.out.println("visita "+i);
			}
		    break;
		  case 3:
		    System.out.println("Prueba de stress en un navegador");
		    driver = new ChromeDriver();
		    for(int i = 1; i <= 51; i++) {
				driver.manage().window().maximize();
				driver.get("https://www.choucairtesting.com/empleos-2/");
				System.out.println("visita "+i);
			}
		    break;
		  default:
			  System.out.println("No escogio una opción valida");
		}
	}
	
	
	@Test
	public void ingresoChocairTestingWeb() throws InterruptedException {
		
		if(driver.findElement(imgEmpleosPageLocator).isDisplayed()) {

			JavascriptExecutor js = (JavascriptExecutor)driver;
			//SCROLL DOWN
			js.executeScript("window.scrollBy(0,2500)", ""); 
			Thread.sleep(5000);
			//SCROLL UP
			js.executeScript("window.scrollBy(0,-2800)", ""); 
			Thread.sleep(5000);
			
			System.out.println("Estas en la pagina correcta");
			
		}else {
			System.out.println("Algo salió mal, no estas la página.");
		}
		
	} 
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000); //2 SEGUNDOS DE ESPERA, PARA CERRAR
		driver.quit(); //CERRAR EL NAVEGAR (recomendación: comentar para hacer las pruebas)
	}
}
