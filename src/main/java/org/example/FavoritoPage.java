package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FavoritoPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By Titulo= By.xpath("//h2[text()='Account']");


    public FavoritoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    public void ingresarCamara(){
        WebElement Button = this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(  "//a[@href='http://opencart.abstracta.us:80/index.php?route=product/category&path=33']")));
        Button.click();
    }
    public void camaraFavorita(){
        WebElement FButton = this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(  "//button[contains(@onclick, \"wishlist.add('30')\")]")));
        FButton.click();
        WebElement wButton = this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(  "//a[@href='https://opencart.abstracta.us:443/index.php?route=account/wishlist']")));
        wButton.click();
    }
    public boolean validarLogin(){

        WebElement titlePresente = this.wait.until(ExpectedConditions.presenceOfElementLocated(Titulo));

        return titlePresente.isDisplayed();

    }

}
