package pages;

import com.webuyanycar.test.BasePage;
import data_models.VehicleDetails;
import org.openqa.selenium.By;

public class VehicleDetailsPage extends BasePage {

    private By variantRegNumber = By.xpath("//section[contains(@class,'primary-section')]//div[@id='vehicleImage']/div[contains(@class,'details-vrm')]");
    //Make
    private By manufacturer = By.xpath("//section[contains(@class,'primary-section')]//div[contains(@class,'details-vehicle-row')]/div[contains(text(),'Manufacturer')]/../div[contains(@class,'value')]");
    private By model = By.xpath("//section[contains(@class,'primary-section')]//div[contains(@class,'details-vehicle-row')]/div[contains(text(),'Model')]/../div[contains(@class,'value')]");
    private By year = By.xpath("//section[contains(@class,'primary-section')]//div[contains(@class,'details-vehicle-row')]/div[contains(text(),'Year')]/../div[contains(@class,'value')]");

    public VehicleDetails getVehicleDetails(){
        VehicleDetails vehicleDetails = new VehicleDetails();
        waitToVisible(variantRegNumber,5);
        vehicleDetails.variantReg = getText(variantRegNumber).trim();
        vehicleDetails.make = getText(manufacturer).trim();
        vehicleDetails.model = getText(model).trim();
        vehicleDetails.year = getText(year).trim();
        return  vehicleDetails;
    }

}
