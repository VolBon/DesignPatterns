package org.bon.abstractComponents;

import org.bon.pageComponents.MultiTrip;
import org.bon.pageComponents.OneWayTrip;
import org.bon.pageComponents.RoundTrip;
import org.bon.pageObjects.TripType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StrategyFactory {

    By section = By.id("flightSearchContainer");
    WebDriver driver;

    public StrategyFactory(WebDriver driver) {
        this.driver = driver;

    }
    public SearchFlightAvail setStrategy(TripType strategyType) {
        if (strategyType.equals(TripType.ONEWAY)) {
            return new OneWayTrip(driver, section);
        } else if (strategyType.equals(TripType.ROUND)) {
            return new RoundTrip(driver, section);
        }
        else if (strategyType.equals(TripType.MULTI)) {
            return new MultiTrip(driver, section);}
        return null;
    }
}
