package manager;

import models.User;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        click(By.cssSelector("a[ng-reflect-router-link='login']"));
    }

    public void fillLoginForm(String email, String password) {
        type(By.xpath("//input[@id='email']"), email);
        type(By.xpath("//input[@id='password']"), password);
    }

    //overloading
    public void fillLoginForm(User user) {
        type(By.xpath("//input[@id='email']"), user.getEmail());
        type(By.xpath("//input[@id='password']"), user.getPassword());
    }

    public void submit() {
        click(By.xpath("//button[@type='submit']"));
    }

    public void clickOkAfterSuccess() {
        click(By.xpath("//button[@class='positive-button ng-star-inserted']"));
    }

    public boolean isLogged() {
        return
                isElementPresent(By.xpath("//a[text()=' Logout ']"));
    }

    public void logout() {
        click(By.xpath("//a[text()=' Logout ']"));
    }

    public boolean isLoggedWithOkWindow() {
        return
                isElementPresent(By.xpath("//button[@class='positive-button ng-star-inserted']"));
    }

    public String getErrorText() {
        return wd.findElement(By.cssSelector("div.error")).getText();
    }

    //***************************** R E G I S T R A T I O N **************************
    public void openRegistrationForm() {
        click(By.xpath("//a[text()=' Sign up ']"));
    }

    public void fillRegistrationForm(User user) {
        type(By.id("name"), user.getFirstName());
        type(By.id("lastName"), user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    public void checkPolicy() {
        click(By.xpath("//label[contains(text(),'I agree to the')]"));

        //option 2
        //JavascriptExecutor js = (JavascriptExecutor) wd;
        //js.executeScript("document.querySelector('#terms-of-use').click();");

        //option 3
        //WebElement label = wd.findElement(By.cssSelector("label[for='terms-of-use']"));
        //Rectangle rect = label.getRect();
        //int w = rect.getWidth();
        //int xOffSet = w/2;
        //Actions actions = new Actions(wd);
        //actions.moveToElement(label,xOffSet,0);
    }

    public String getRegistrationFailedText() {
    return wd.findElement(By.cssSelector("h2.message")).getText();
    }

    public void submitUserExist() {
        click(By.xpath("//button[@type='button']"));
    }

    public boolean errorTextWrongPasswordEmailEmptyFields() {
        return
                isElementPresent(By.cssSelector("div.error"));
    }

    public void clickOnFreeSpace() {
        click(By.cssSelector("div.login-registration-container"));
    }

    public void refresh() {
        wd.navigate().refresh();
    }

    public void login(User user){
        openLoginForm();
        fillLoginForm(user);
        submit();
        clickOkAfterSuccess();
    }
}