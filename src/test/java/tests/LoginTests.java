package tests;

import manager.HelperBase;
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
    public void loginSuccess(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("elizaveta.murashkina@bk.ru", "Aa12345$");
        app.getHelperUser().submitLogin();

        //Assert.assertTrue(app.getHelperUser().isLogged());
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");

    }

    @Test
    public void loginSuccessModel(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("elizaveta.murashkina@bk.ru", "Aa12345$");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());
        //Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
    }

    @AfterMethod
    public void postConditions(){
        if(app.getHelperUser().isLoggedWithOkWindow()){
            app.getHelperUser().clickOkAfterLoginSuccess();
        }
    }
}
