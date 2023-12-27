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
        }
    }

    @Test
    public void registrationSuccess(){
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
        app.getHelperUser().clickOkAfterSuccess();
    }


    @Test
    public void registrationWrongEmail(){
        User user = new User()
                .setFirstName("Liza")
                .setLastName("Kenigzon")
                .setEmail("kenigmail.ru")
                .setPassword("Snow12345!");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        Assert.assertTrue(app.getHelperUser().errorTextWrongPasswordEmailEmptyFields());
        Assert.assertTrue(app.getHelperUser().IsYallaButtonNotActive());
    }
    @Test
    public void registrationWrongPassword(){
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
    }

    @Test
    public void registrationUserExist(){
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
        app.getHelperUser().submitUserExist();
    }

    @Test
    public void registrationWithoutName(){
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
    }

    @Test
    public void registrationWithoutLastName(){
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
    }

    @Test
    public void registrationWithoutEmail(){
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
    }

    @Test
    public void registrationWithoutPassword(){
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
    }

}
