package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CarritoPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By Titulo= By.xpath("//html/body/div[2]/div/div/form/div/table/tbody/tr/td[1]/a/img");
    private By Titulo2 = By.xpath("//h2[text()='What would you like to do next?']");
    public CarritoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    public void agregarCarrito() {
        WebElement cButton = this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(  "//button[contains(@onclick, \"cart.add('30', '1')\")]")));
        cButton.click();
        WebElement lButton = this.wait.until(ExpectedConditions.elementToBeClickable(By.id("input-option226")));
        lButton.click();
        WebElement rButton = this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[@value='15']")));
        rButton.click();
        WebElement Button = this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='button-cart']")));
        Button.click();
        WebElement dButton = this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='cart']")));
        dButton.click();
        WebElement aButton = this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://opencart.abstracta.us:80/index.php?route=checkout/cart']")));
        aButton.click();
    }
    public boolean validarLogin(){

        WebElement titlePresente = this.wait.until(ExpectedConditions.presenceOfElementLocated(Titulo));
        WebElement titlePresente2 = this.wait.until(ExpectedConditions.presenceOfElementLocated(Titulo2));
        return titlePresente.isDisplayed() & titlePresente2.isDisplayed();

    }


}
