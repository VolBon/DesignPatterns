package org.bon.pageComponents;

import org.bon.abstractComponents.AbstractComponent;
import org.bon.abstractComponents.SearchFlightAvail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;

public class OneWayTrip extends AbstractComponent implements SearchFlightAvail {

    private By rdo = By.id("ctl00_mainContent_rbtnl_Trip_0");
    private By from = By.xpath("//*[@id=\"ctl00_mainContent_ddl_originStation1_CTXTaction\"]");
    private By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXTaction");

    private By cb = By.id("ctl00_mainContent_chk_IndArm");
    private By search =By.id("ctl00_mainContent_btn_FindFlights");
    WebDriverWait w;

    public OneWayTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
        this.w = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Override
    public void checkAvailability(HashMap<String, String> reservationDetails) {
        System.out.println("Round trip");
        findElement(rdo).click();
        selectOriginCity(reservationDetails.get("origin"));
        selectDestinationCity(reservationDetails.get("destination"));
        findElement(cb).click();
    }

    public void selectOriginCity(String origin) {
        findElement(from).click();
        findElement(By.xpath("//a[@value='"+origin+"']")).click();
    }
    public void selectDestinationCity(String destination) {
        findElement(to).click();
        findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
    }

}
