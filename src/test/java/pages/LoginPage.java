package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class LoginPage extends BasePage{

    public static final By EMAIL = By.id("login_field");
    public static final By PASSWORD = By.id("password");

    public static final By SIGN_IN_BUTTON = By.xpath("//input[@value='Sign in']");
    public static final By MESSAGE = By.xpath("//div[normalize-space(text()) = 'Incorrect username or password.']");


    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @Step("открыть сайт")
    public LoginPage open(){
        driver.get(BASE_URL);
        log.info("открыть сайт перейдя по URL "+BASE_URL);
        return this;
    }
    @Step("ввести логин {login} и пароль {password}")
    public LoginPage inputLoginAndPassword(String login, String password){
        driver.findElement(EMAIL).sendKeys(login);
        log.info("ввести логин в поле Username "+login);
        driver.findElement(PASSWORD).sendKeys(password);
        log.info("ввести логин в поле Password "+password);
        return this;

    }

    @Step("get Error massage")
    public String getErrorMessage(){
        log.info("получить сообщение об ошибке"+MESSAGE);
        return driver.findElement(MESSAGE).getText();

    }
@Step("click Sign In Button")
    public HomePage clickSignInButton(){
        driver.findElement(SIGN_IN_BUTTON).click();
        log.info("нажать кнопку "+SIGN_IN_BUTTON);
        return new HomePage(driver);
    }



    @Override
    public boolean isPageOpen() {
        return isExist(SIGN_IN_BUTTON);
    }
}
