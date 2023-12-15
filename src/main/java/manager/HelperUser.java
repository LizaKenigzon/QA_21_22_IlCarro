package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }
    public void openLoginRegistrationForm(){
        click(By.cssSelector("a[ng-reflect-router-link='login']"));
    }
    public void fillLoginRegistrationForm(String email, String password){
        type(By.xpath("//input[@id='email']"),email);
        type(By.xpath("//input[@id='password']"),password);
    }
    public void submitLogin(){
        click(By.xpath("//button[@type='submit']"));
    }
    public void clickOkAfterLoginSuccess(){
        click(By.xpath("//button[@class='positive-button ng-star-inserted']"));
    }
    public boolean isLogged(){
        return
                isElementPresent(By.xpath("//a[@href='logout']"));
    }

}
