package org.bon.pageComponents;

import org.bon.abstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar extends AbstractComponent {
    static By section = By.id("buttons");
    By flights = By.cssSelector("[title='Flights']");
    By links = By.cssSelector("a");

    public NavigationBar(WebDriver driver) {
        super(driver, section);
    }

    public void selectFlight(){
        System.out.println("Selected: " + findElement(flights).getAttribute("class"));
//        driver.findElement(flights).click();
    }

    public int getLinksCount() {
        return findElements(links).size();
    }

    public void clickHamburger() {
        findElement(By.cssSelector("[class='hamburger']")).click();
    }
}
