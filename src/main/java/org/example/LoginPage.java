package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {

    private By emailInput = By.id("input-email");
    private By passInput = By.id("input-password");

    private By Loginbtn = By.xpath("//input[@value='Login']");

    private By Titulo = By.xpath("//h2[text()='My Account']");

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver ) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    public void ingresarLogin(){
        WebElement Button = this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='My Account']")));
        Button.click();

        WebElement loginButton = this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='https://opencart.abstracta.us:443/index.php?route=account/login']")));
        loginButton.click();
    }
    public void login(String email, String password){
        WebElement emailElement = wait.until(ExpectedConditions.presenceOfElementLocated(this.emailInput));
        emailElement.sendKeys(email);

        WebElement passwElement = wait.until(ExpectedConditions.presenceOfElementLocated(this.passInput));
        passwElement.sendKeys(password);

        WebElement buttonElement = wait.until(ExpectedConditions.elementToBeClickable(Loginbtn));
        buttonElement.click();
    }
public void abrirPagina(String url){
    this.driver.get(url);
}
public boolean validarLogin(){

        WebElement titlePresente = this.wait.until(ExpectedConditions.presenceOfElementLocated(Titulo));
        return titlePresente.isDisplayed();
}


}
