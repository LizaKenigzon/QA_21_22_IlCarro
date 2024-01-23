package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchCarTests extends TestBase {
    @Test
    public void searchCurrentMonthSuccess() {
        app.getHelperCar().searchCurrentMonth("Tel Aviv, Israel", "1/23/2024", "1/25/2024");
        app.getHelperCar().getScreen("src/test/screenshots/currentMonth.png");
        app.getHelperCar().submitCarForm();
        Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());
    }


    @Test
    public void searchCurrentYearSuccess() {
        app.getHelperCar().searchCurrentYear("Tel Aviv, Israel", "2/20/2024", "1/12/2025");
        app.getHelperCar().getScreen("src/test/screenshots/currentYear.png");
        app.getHelperCar().submitCarForm();
        Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());

    }


    @Test
    public void searchAnyPeriodSuccess() {
        app.getHelperCar().searchAnyPeriod("Tel Aviv, Israel", "4/20/2024", "1/14/2025");
        app.getHelperCar().getScreen("src/test/screenshots/any.png");
        app.getHelperCar().submitCarForm();
        Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());

    }

    @BeforeMethod
    public void postCondition(){
        app.getHelperCar().navigateByLogo();
    }
}
