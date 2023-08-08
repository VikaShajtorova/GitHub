package tests;

import static org.testng.Assert.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class LoginTest extends BaseTest {
    @Test
    public void loginUserValidDate(){
        boolean isHomePageOpen = loginPage.open()
                .inputLoginAndPassword("VikaShajtorova","dbrnjhbz_1105")
                .clickSignInButton()
                .isPageOpen();
        assertTrue(isHomePageOpen);
    }
    @DataProvider
    public Object [][] incorrectLoginTest(){
        return new Object[][]{
                {"","dbrnjhbz_1105","Incorrect username or password."},
                {"VikaShajtorova","","Incorrect username or password."},
                {" ","dbrnjhbz_1105","Incorrect username or password."},
                {"Sdfgg","dbrnjhbz_1105","Incorrect username or password."},
                {"VikaShajtorova","1252599699999999","Incorrect username or password."}

        };
    }
    @Test(dataProvider = "incorrectLoginTest")
        public void loginTestWithWornDate(String login, String password, String massage){
        loginPage.open()
                .inputLoginAndPassword(login,password)
                .clickSignInButton();
        assertEquals(loginPage.getErrorMessage(),massage,"Текст сообщения отсутствует или не совпадает");

    }

}
