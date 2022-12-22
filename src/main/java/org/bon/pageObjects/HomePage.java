package org.bon.pageObjects;

import org.bon.abstractComponents.SearchFlightAvail;
import org.bon.abstractComponents.StrategyFactory;
import org.bon.pageComponents.FooterBar;
import org.bon.pageComponents.NavigationBar;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class HomePage {
    WebDriver driver;
    SearchFlightAvail searchFlightAvail;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToPage() {
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    } //

    public NavigationBar getNavigationBar() {
        return new NavigationBar(driver);
    }

    public FooterBar getFooter() {
        return new FooterBar(driver);
    }

    public void getLinksCount(String algo) {}

    public void setBookingStrategy(TripType strategyType) {
        StrategyFactory sf = new StrategyFactory(driver);
        searchFlightAvail = sf.setStrategy(strategyType);
        this.searchFlightAvail = searchFlightAvail;
    }

    public void checkAvailability(HashMap<String, String> reservationDetails) {
        try {
            searchFlightAvail.checkAvailability(reservationDetails);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
