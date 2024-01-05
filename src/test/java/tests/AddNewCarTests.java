package tests;

import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewCarTests extends TestBase{

    @BeforeClass
    public void preConditions(){
        if(!app.getHelperUser().isLogged()){
            app.getHelperUser().login(new User().setEmail("elizaveta.murashkina@bk.ru").setPassword("Aa12345$"));
        }

    }
    @Test
    public void addNewContactSuccess(){
        Random random = new Random();
        int i = random.nextInt(10000)+1000;
       Car car = Car.builder()
               .location("Tel Aviv, Israel")
               .manufacture("Mazda")
               .model("M3")
               .year("2022")
               .fuel("Petrol")
               .seats(4)
               .carClass("C")
               .carRegNumber("678-900-"+i)
               .price(50)
               .about("Very nice car")
               .build();
       app.getHelperCar().openCarForm();
       app.getHelperCar().fillCarForm(car);
       app.getHelperCar().attachPhoto("D:\\GitHubProjects\\QA_21_22_IlCarro\\02-bugatti-cd-nardo-testing.jpg");
       app.getHelperCar().submitCarForm();
       Assert.assertTrue(app.getHelperUser().getMessage().contains("added successful"));
       Assert.assertEquals(app.getHelperUser().getMessage(),
                car.getManufacture()+" "+car.getModel()+(" added successful"));
    }

    @Test
    public void addNewContactSuccessRequiredFields(){
        Random random = new Random();
        int i = random.nextInt(10000)+1000;
        Car car = Car.builder()
                .location("Tel Aviv, Israel")
                .manufacture("Mazda")
                .model("M3")
                .year("2022")
                .fuel("Petrol")
                .seats(4)
                .carClass("C")
                .carRegNumber("678-900-"+i)
                .price(50)
                .build();
        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().submitCarForm();
        Assert.assertTrue(app.getHelperUser().getMessage().contains("added successful"));
        Assert.assertEquals(app.getHelperUser().getMessage(),
                car.getManufacture()+" "+car.getModel()+(" added successful"));
    }

    @AfterMethod
    public void postConditions(){
        app.getHelperCar().returnToHome();
    }
}
