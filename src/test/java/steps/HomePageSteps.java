package steps;

import com.webuyanycar.test.BasePage;
import com.webuyanycar.test.Core;
import com.webuyanycar.test.Utilities;
import constants.ScenarioContextKeys;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.HomePage;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static constants.FilePaths.TEST_DATA_ROOT;

public class HomePageSteps {

    @Given("Load the base url")
    public void loadBaseURL() throws Exception {
        Core.getWebDriver();
        BasePage.goToUrl(BasePage.baseUrl);
        Core.getWebDriver().manage().window().maximize();
        new HomePage().clickAcceptAllCookies();
    }

    @When("^User enters vehicle details ([^\"]*)$")
    public void userEntersVehicleDetails(String vehicleReg) {
        new HomePage().searchCarToGetValuation(vehicleReg,"10000");

    }

    @When("^User provides ([^\"]*) as car details for search$")
    public void userProvidesInputfileAsCarDetailsForSearch(String input_file) {
        String carInputData= Utilities.readFile(TEST_DATA_ROOT+input_file);
        System.out.println(carInputData);
        Pattern p = Pattern.compile("[A-Z]{2}\\d{2}(?:\\s?[A-Z]{3})");
        Matcher m = p.matcher(carInputData);
        ArrayList<String> car_reg_numbers = new ArrayList<>();
        while (m.find()) {
            System.out.println(m.group().trim().replace(" ",""));
            car_reg_numbers.add(m.group().trim().replace(" ",""));
        }
        BasePage.scenarioContext.put(ScenarioContextKeys.EXTRACTED_CAR_NUMBERS_INPUT_FILE,car_reg_numbers);
    }
}
