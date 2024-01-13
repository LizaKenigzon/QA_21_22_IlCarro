package tests;

import manager.HelperBase;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void preConditions(){
            if(app.getHelperUser().isLogged()){
                app.getHelperUser().logout();
                logger.info("Before method finish logout");
            }
        }

    @Test
    public void loginSuccess1(){
        logger.info("Test data ---> email:'elizaveta.murashkina@bk.ru' & password:'Aa12345$'");
        User user = new User().setEmail("elizaveta.murashkina@bk.ru").setPassword("Aa12345$");
        //user.setEmail("elizaveta.murashkina@bk.ru");
        //user.setPassword("Aa12345$");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        //Assert.assertTrue(app.getHelperUser().isLogged());
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
        logger.info("Assert check is Message Present 'Logged in success'");
    }
    @Test
    public void loginSuccess(){
        logger.info("Test data ---> email:'elizaveta.murashkina@bk.ru' & password:'Aa12345$'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("elizaveta.murashkina@bk.ru", "Aa12345$");
        app.getHelperUser().submit();

        //Assert.assertTrue(app.getHelperUser().isLogged());
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
        logger.info("Assert check is Message Present 'Logged in success'");
    }

    @Test
    public void loginSuccessModel(){
        logger.info("Test data ---> email:'elizaveta.murashkina@bk.ru' & password:'Aa12345$'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("elizaveta.murashkina@bk.ru", "Aa12345$");
        app.getHelperUser().submit();

        Assert.assertTrue(app.getHelperUser().isLogged());
        //Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
        logger.info("Assert check is Element button 'Sign out' present");
    }

    @Test
    public void loginWrongEmail() {
        logger.info("Test data ---> email:'elizaveta.murashkinabk.ru' & password:'Aa12345$'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("elizaveta.murashkinabk.ru", "Aa12345$");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(),"It'snot look like email");
        Assert.assertTrue(app.getHelperUser().IsYallaButtonNotActive());
        logger.info("Assert check is Element button 'Yalla' not active");
        logger.info("Assert check is Error text 'It'snot look like email' present");
    }
    @Test
    public void loginWrongPassword() {
        logger.info("Test data ---> email:'elizaveta.murashkina@bk.ru' & password:'Aa12'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("elizaveta.murashkina@bk.ru", "Aa12");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(),"\"Login or Password incorrect\"");
        logger.info("Assert check is Error text 'Login or Password incorrect' present");
    }
    @Test
    public void loginUnregisteredUser() {
        logger.info("Test data ---> email:'luck123@bk.ru' & password:'Aa12345$'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("luck123@bk.ru", "Aa12345$");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(),"\"Login or Password incorrect\"");
        logger.info("Assert check is Error text 'Login or Password incorrect' present");
    }

    @AfterMethod
    public void postConditions(){
        if(app.getHelperUser().isLoggedWithOkWindow()){
            app.getHelperUser().clickOkAfterSuccess();
        }
    }
}
