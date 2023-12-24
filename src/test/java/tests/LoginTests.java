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
            }
        }

    @Test
    public void loginSuccess1(){
        User user = new User().setEmail("elizaveta.murashkina@bk.ru").setPassword("Aa12345$");
        //user.setEmail("elizaveta.murashkina@bk.ru");
        //user.setPassword("Aa12345$");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        //Assert.assertTrue(app.getHelperUser().isLogged());
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");

    }
    @Test
    public void loginSuccess(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("elizaveta.murashkina@bk.ru", "Aa12345$");
        app.getHelperUser().submit();

        //Assert.assertTrue(app.getHelperUser().isLogged());
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");

    }

    @Test
    public void loginSuccessModel(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("elizaveta.murashkina@bk.ru", "Aa12345$");
        app.getHelperUser().submit();

        Assert.assertTrue(app.getHelperUser().isLogged());
        //Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
    }

    @Test
    public void loginWrongEmail() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("elizaveta.murashkinabk.ru", "Aa12345$");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(),"It'snot look like email");
        Assert.assertTrue(app.getHelperUser().IsYallaButtonNotActive());
    }
    @Test
    public void loginWrongPassword() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("elizaveta.murashkina@bk.ru", "Aa12");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(),"\"Login or Password incorrect\"");
    }
    @Test
    public void loginUnregisteredUser() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("luck123@bk.ru", "Aa12345$");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(),"\"Login or Password incorrect\"");
    }

    @AfterMethod
    public void postConditions(){
        if(app.getHelperUser().isLoggedWithOkWindow()){
            app.getHelperUser().clickOkAfterSuccess();
        }
    }
}
