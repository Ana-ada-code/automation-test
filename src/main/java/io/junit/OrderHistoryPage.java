package io.junit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderHistoryPage {
    private WebDriver driver;

    public OrderHistoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkTheOrder(OrderConfirmationPage orderConfirmationPage) {
        WebElement orderReference = driver.findElement(By.cssSelector("#content > table > tbody > tr:nth-child(1) > th"));
        String orderReferenceText = orderReference.getText();

        Assert.assertTrue(orderReferenceText.contains(orderConfirmationPage.getOrderReference()));

        WebElement totalPrice = driver.findElement(By.cssSelector("#content > table > tbody > tr:nth-child(1) > td.text-xs-right"));
        String totalPriceText = totalPrice.getText();

        Assert.assertTrue(totalPriceText.contains(orderConfirmationPage.getTotalCost()));

        WebElement status = driver.findElement(By.cssSelector("#content > table > tbody > tr:nth-child(1) > td:nth-child(5) > span"));
        String statusText = status.getText();

        Assert.assertTrue(statusText.contains("Awaiting check payment"));
    }

    public void quitBrowser() {
        driver.quit();
    }
}
