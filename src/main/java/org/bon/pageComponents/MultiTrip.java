package org.bon.pageComponents;

import org.bon.abstractComponents.AbstractComponent;
import org.bon.abstractComponents.SearchFlightAvail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.function.Consumer;

public class MultiTrip extends AbstractComponent implements SearchFlightAvail {

    private By rdo = By.id("ctl00_mainContent_rbtnl_Trip_2");
    private By modelPopUp = By.id("MultiCityModelAlert");
    private By multiRdo = By.id("ctl00_mainContent_rbtnl_Trip_1");
    private By from = By.id("ctl00_mainContent_ddl_originStation1_CTXTaction");
    private By from2 = By.id("ctl00_mainContent_ddl_originStation2_CTXTaction");
    private By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXTaction");
    private By to2 = By.id("ctl00_mainContent_ddl_destinationStation2_CTXTaction");

    public MultiTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    @Override
    public void checkAvailability(HashMap<String, String> reservationDetails) {
        makeStateReady(s -> selectOriginCity(reservationDetails.get("origin")));
        selectDestinationCity(reservationDetails.get("destination"));
        selectOriginCity2(reservationDetails.get("origin2"));
        selectDestinationCity2(reservationDetails.get("destination2"));
    }

    public void selectOriginCity(String origin) {
        System.out.println("Execute step");
        if (findElement(from).isDisplayed()) {
            findElement(from).click();
        }
        System.out.println("Displayed1: " + findElement(By.xpath("//a[@value='"+origin+"']")).getLocation());
        findElement(By.xpath("//a[@value='"+origin+"']")).click();
    }

    public void selectOriginCity2(String origin) {
        if (findElement(from2).isDisplayed()) {
            findElement(from2).click();
        }
        //System.out.println("Displayed2: " + findElement(By.xpath("//a[@value='"+origin+"']")).isDisplayed());
        //waitForElementToAppear(By.xpath("//a[@value='"+origin+"']"));
        findElement(By.xpath("(//a[@value='"+origin+"'])[3]")).click();
    }

    public void selectDestinationCity(String destination) {
        findElement(to).click();
        findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
    }

    public void selectDestinationCity2(String destination) {
        if (findElement(to2).isDisplayed()) {
            findElement(to2).click();
        }
        findElement(By.xpath("(//a[@value='"+destination+"'])[3]")).click();
    }

    public void makeStateReady(Consumer<SearchFlightAvail> consumer) {
        System.out.println("Multi  trip");
        findElement(rdo).click();
        findElement(modelPopUp).click();
        waitForElementToDisappear(modelPopUp);
        System.out.println("Before accept");
        consumer.accept(this);
        System.out.println("Done with state ready");
    }
}
