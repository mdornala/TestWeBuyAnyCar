package pages;

import com.webuyanycar.test.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private By acceptAllCookies = By.id("onetrust-accept-btn-handler");
    private By vehicleRegTxtBox = By.id("vehicleReg");
    private By mileageTxtBox = By.id("Mileage");
    private By getMyCarValuationButton = By.id("btn-go");

    public void clickAcceptAllCookies(){
        waitToVisible(acceptAllCookies,5);
        BasePage.driver.findElement(acceptAllCookies).click();
    }

    public void searchCarToGetValuation(String vehicleReg, String millage){
        waitToVisible(vehicleRegTxtBox,60);
        enterText(vehicleRegTxtBox,vehicleReg);
        enterText(mileageTxtBox,millage);
        clickElement(getMyCarValuationButton);
    }


}
