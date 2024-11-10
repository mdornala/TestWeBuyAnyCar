package steps;

import com.webuyanycar.test.BasePage;
import com.webuyanycar.test.Utilities;
import constants.ScenarioContextKeys;
import data_models.VehicleDetails;
import io.cucumber.java.en.Then;
import org.assertj.core.api.SoftAssertions;
import pages.HomePage;
import pages.VehicleDetailsPage;

import java.util.ArrayList;

import static constants.FilePaths.TEST_DATA_ROOT;

public class VehicleDetailsSteps {

    @Then("^User gets the car valuation$")
    public void userGetVehicleDetails() {
        VehicleDetails vehicleDetails = new VehicleDetailsPage().getVehicleDetails();
        System.out.println(vehicleDetails.variantReg);
        System.out.println(vehicleDetails.make);
        System.out.println(vehicleDetails.model);
        System.out.println(vehicleDetails.year);

    }

    @Then("^System verify the car valuations with ([^\"]*)$")
    public void userVerifyTheCarValuationsWithOutput_file(String fileOutput) {
        ArrayList<String> carRegNumbers = (ArrayList<String>) BasePage.scenarioContext.get(ScenarioContextKeys.EXTRACTED_CAR_NUMBERS_INPUT_FILE);
        ArrayList<String> expectedOutputs = Utilities.readFileLineByLine(TEST_DATA_ROOT+fileOutput);
        HomePage homePage=new HomePage();
        SoftAssertions softAssertions = new SoftAssertions();
        for (String carRegNumber : carRegNumbers) {
            try {
                BasePage.goToUrl(BasePage.baseUrl);
                homePage.searchCarToGetValuation(carRegNumber, "10000");
                VehicleDetails vehicleDetails = new VehicleDetailsPage().getVehicleDetails();
                String actualValue = vehicleDetails.variantReg + ", " + vehicleDetails.make + ", " + vehicleDetails.model + ", " + vehicleDetails.year;
                softAssertions.assertThat(expectedOutputs.contains(actualValue))
                        .withFailMessage(carRegNumber + " - Actual Value : " + actualValue).isTrue();
            } catch (Exception e) {
                softAssertions.assertThat(false).withFailMessage(carRegNumber + " - Failed to fetch the data on app. \n").isTrue();
            }
        }
        softAssertions.assertAll();
    }
}
