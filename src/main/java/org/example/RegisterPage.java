package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By nombreReg =By.id("input-firstname");
    private By apellidoReg = By.id("input-lastname");
    private By emailReg = By.id("input-email");
    private By phoneReg = By.id("input-telephone");
    private By passReg = By.id("input-password");
    private By passconfReg = By.id("input-confirm");

    private By checkbox = By.xpath(" //input[@name='agree']");

    private By Loginbtn = By.xpath("//input[@value='Continue']");

    private  By Titulo = By.xpath("  //h1[text()='Account']");


    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    public void ingresarRegister(){
        WebElement Button = this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='My Account']")));
        Button.click();
        WebElement registerButton = this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='https://opencart.abstracta.us:443/index.php?route=account/register']")));
        registerButton.click();
    }

    public void register(String nombre, String apellido, String email, String phone, String password, String confirmpss){
        WebElement nameElement = wait.until(ExpectedConditions.presenceOfElementLocated(this.nombreReg));
        nameElement.sendKeys(nombre);

        WebElement lastnameElement = wait.until(ExpectedConditions.presenceOfElementLocated(this.apellidoReg));
        lastnameElement.sendKeys(apellido);

        WebElement emailElement = wait.until(ExpectedConditions.presenceOfElementLocated(this.emailReg));
        emailElement.sendKeys(email);
        WebElement phoneElement = wait.until(ExpectedConditions.presenceOfElementLocated(this.phoneReg));
        phoneElement.sendKeys(phone);

        WebElement passwElement = wait.until(ExpectedConditions.presenceOfElementLocated(this.passReg));
        passwElement.sendKeys(password);
        WebElement confirmElement = wait.until(ExpectedConditions.presenceOfElementLocated(this.passconfReg));
        confirmElement.sendKeys(confirmpss);

        WebElement checkElement = wait.until(ExpectedConditions.elementToBeClickable(checkbox));
        checkElement.click();
        WebElement buttonElement = wait.until(ExpectedConditions.elementToBeClickable(Loginbtn));
        buttonElement.click();
    }
    public boolean validarLogin(){

        WebElement titlePresente = this.wait.until(ExpectedConditions.presenceOfElementLocated(Titulo));
        return titlePresente.isDisplayed();
    }
}
