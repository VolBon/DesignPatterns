package org.bon.pageComponents;

import org.bon.abstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterBar extends AbstractComponent {
    static By section = By.id("traveller-home");
    By flights = By.cssSelector("[title='Flights']");
    By links = By.cssSelector("a");

    public FooterBar(WebDriver driver) {
        super(driver, section);
    }

    public String selectFlight(){
        return findElement(flights).getAttribute("class");
//        driver.findElement(flights).click();
    }

    public int getLinksCount() {
        return findElements(links).size();
    }
}
