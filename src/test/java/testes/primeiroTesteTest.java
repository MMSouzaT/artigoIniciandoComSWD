package testes;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;

public class primeiroTesteTest {


    @Test
    public void entrarnoFacebook(){

        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        System.setProperty("webdriver.chrome.driver", "C:\\projetinho\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        navegador.get("https://facebook.com");


        //Encontrando o campo email/telefone pelo id e preenchendo
        navegador.findElement(By.id("email")).sendKeys("marcinho_boladão@test.com");
        //Pelo name
//      navegador.findElement(By.name("email")).sendKeys("marcinho_boladão@test.com");
//      Pelo xpath
//      navegador.findElement(By.xpath("//input[@type='text']")).sendKeys("marcinho_boladão@test.com");

        //Encontrando o campo senha e preenchendo pelo id
        navegador.findElement(By.id("pass")).sendKeys("123456");
        //Pelo name
//        navegador.findElement(By.name("pass")).sendKeys("123456");
          //Pelo xpath
//        navegador.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");

          //Encontrando o botão Entrar pelo name
          //Pelo id
//        navegador.findElement(By.id("u_0_h")).click();
          //Pelo xpath
//        navegador.findElement(By.xpath("//button[@type='submit']")).click();
         //Pelo texto que ele possui
        navegador.findElement(By.linkText("Entrar")).click();

        //Aqui você encontra um erro que é exibido pela página do facebook quando você tenta entrar
        //sem preencher os campos
        navegador.findElement(By.name("login")).click();
        String erro = navegador.findElement(By.xpath("//div[@role='alert']")).getText();
        assertEquals("O email ou o número de telefone inserido não " +
                "corresponde a nenhuma conta. Cadastre-se para abrir uma conta.", erro);


    }
}
