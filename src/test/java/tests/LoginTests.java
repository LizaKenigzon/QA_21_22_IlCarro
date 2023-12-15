package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginSuccess(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("elizaveta.murashkina@bk.ru", "Aa12345$");
        app.getHelperUser().submitLogin();
        app.getHelperUser().clickOkAfterLoginSuccess();

        Assert.assertTrue(app.getHelperUser().isLogged());
    }
}
