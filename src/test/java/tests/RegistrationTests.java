package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase{

    @BeforeMethod
    public void preConditions(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
            logger.info("Before method finish logout");
        }
    }

    @Test
    public void registrationSuccess(){
        logger.info("Test data ---> Liza,Snow,email:'snow+i+@mail.ru' & password:'Snow12345!'");
        Random random = new Random();
        int i = random.nextInt(1000);
        User user = new User()
                .setFirstName("Liza")
                .setLastName("Snow")
                .setEmail("snow"+i+"@mail.ru")
                 .setPassword("Snow12345!");
                app.getHelperUser().openRegistrationForm();
                app.getHelperUser().fillRegistrationForm(user);
                app.getHelperUser().checkPolicy();
                app.getHelperUser().submit();
                Assert.assertEquals(app.getHelperUser().getMessage(),"You are logged in success");
        logger.info("Assert check is Message Present 'You are logged in success'");
        app.getHelperUser().clickOkAfterSuccess();
    }


    @Test
    public void registrationWrongEmail(){
        logger.info("Test data ---> Liza,Kenigzon,email:'kenigmail.ru' & password:'Snow12345!'");
        User user = new User()
                .setFirstName("Liza")
                .setLastName("Kenigzon")
                .setEmail("kenigmail.ru")
                .setPassword("Snow12345!");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        Assert.assertTrue(app.getHelperUser().errorTextWrongPasswordEmailEmptyFields());
        Assert.assertTrue(app.getHelperUser().IsYallaButtonNotActive());
        logger.info("Assert check is Error Text Present");
        logger.info("Assert check is Element button 'Yalla' not active");
    }
    @Test
    public void registrationWrongPassword(){
        logger.info("Test data ---> Liza,Kenigzon,email:'kenig+i+@mail.ru' & password:'Sn12!'");
        Random random = new Random();
        int i = random.nextInt(1000);
        User user = new User()
                .setFirstName("Liza")
                .setLastName("Kenigzon")
                .setEmail("kenig"+i+"@mail.ru")
                .setPassword("Sn12!");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().clickOnFreeSpace();
        Assert.assertTrue(app.getHelperUser().errorTextWrongPasswordEmailEmptyFields());
        Assert.assertTrue(app.getHelperUser().IsYallaButtonNotActive());
        logger.info("Assert check is Error Text Present");
        logger.info("Assert check is Element button 'Yalla' not active");
    }

    @Test
    public void registrationUserExist(){
        logger.info("Test data ---> Liza,Kenigzon,email:'elizaveta.murashkina@bk.ru' & password:'Aa12345$'");
        User user = new User()
                .setFirstName("Liza")
                .setLastName("Kenigzon")
                .setEmail("elizaveta.murashkina@bk.ru")
                .setPassword("Aa12345$");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getRegistrationFailedText(),"\"User already exists\"");
        logger.info("Assert check is Error Text Present 'User already exists'");
        app.getHelperUser().submitUserExist();
    }

    @Test
    public void registrationWithoutName(){
        logger.info("Test data ---> Snow,email:'snow+i+@mail.ru' & password:'Snow12345!'");
        app.getHelperUser().refresh();
        Random random = new Random();
        int i = random.nextInt(1000);
        User user = new User()
                .setLastName("Snow")
                .setEmail("snow"+i+"@mail.ru")
                .setPassword("Snow12345!");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();
        app.getHelperUser().clickOnFreeSpace();
        Assert.assertTrue(app.getHelperUser().IsYallaButtonNotActive());
        Assert.assertTrue(app.getHelperUser().errorTextWrongPasswordEmailEmptyFields());
        logger.info("Assert check is Error Text Present");
        logger.info("Assert check is Element button 'Yalla' not active");
    }

    @Test
    public void registrationWithoutLastName(){
        logger.info("Test data ---> Snow,email:'snow+i+@mail.ru' & password:'Snow12345!'");
        app.getHelperUser().refresh();
        Random random = new Random();
        int i = random.nextInt(1000);
        User user = new User()
                .setFirstName("Snow")
                .setEmail("snow"+i+"@mail.ru")
                .setPassword("Snow12345!");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();
        app.getHelperUser().clickOnFreeSpace();
        app.getHelperUser().clickOnFreeSpace();
        Assert.assertTrue(app.getHelperUser().IsYallaButtonNotActive());
        Assert.assertTrue(app.getHelperUser().errorTextWrongPasswordEmailEmptyFields());
        logger.info("Assert check is Error Text Present");
        logger.info("Assert check is Element button 'Yalla' not active");
    }

    @Test
    public void registrationWithoutEmail(){
        logger.info("Test data ---> Snow,Mama,password:'Snow12345!'");
        app.getHelperUser().refresh();
        User user = new User()
                .setFirstName("Snow")
                .setLastName("Mama")
                .setPassword("Snow12345!");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();
        app.getHelperUser().clickOnFreeSpace();
        Assert.assertTrue(app.getHelperUser().IsYallaButtonNotActive());
        Assert.assertTrue(app.getHelperUser().errorTextWrongPasswordEmailEmptyFields());
        logger.info("Assert check is Error Text Present");
        logger.info("Assert check is Element button 'Yalla' not active");
    }

    @Test
    public void registrationWithoutPassword(){
        logger.info("Test data ---> Snow,Mama,snow+i+@mail.ru'");
        app.getHelperUser().refresh();
        Random random = new Random();
        int i = random.nextInt(1000);
        User user = new User()
                .setFirstName("Snow")
                .setLastName("Mama")
                .setEmail("snow"+i+"@mail.ru");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();
        app.getHelperUser().clickOnFreeSpace();
        Assert.assertTrue(app.getHelperUser().IsYallaButtonNotActive());
        Assert.assertTrue(app.getHelperUser().errorTextWrongPasswordEmailEmptyFields());
        logger.info("Assert check is Error Text Present");
        logger.info("Assert check is Element button 'Yalla' not active");
    }

}
