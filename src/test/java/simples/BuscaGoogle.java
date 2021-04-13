package simples;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BuscaGoogle {

    private WebDriver driver;
    String url;

    @Before
    public void Setup(){
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/89/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        url = "https:google.com";
    }

    @After
    public void Teardown(){
        driver.quit();
    }

    @Test
    public void pesquisaGoogle(){

        driver.get(url);

        WebElement campoPesquisa = driver.findElement(By.name("q"));
        campoPesquisa.sendKeys("Ovos de Páscoa", Keys.ENTER);

        WebElement linkResultadoKopenhagen = driver.findElement(By.xpath("//a/div/cite[contains (., 'https://www.kopenhagen.com.br')]"));
        linkResultadoKopenhagen.click();

        String tituloLista = driver.findElement(By.className("main-title")).getText();
        WebElement ovoLinguaDeGato300G = driver.findElement(By.linkText("Ovo Língua De Gato 300G"));

        assertEquals("OVOS DE PÁSCOA", tituloLista);
        assertEquals("Ovos de Páscoa Kopenhagen, Sabor Que Vem de Dentro", driver.getTitle());
        assertTrue(ovoLinguaDeGato300G.isDisplayed());
    }



}
