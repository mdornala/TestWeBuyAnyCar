package steps;

import com.webuyanycar.test.BasePage;
import com.webuyanycar.test.Core;
import com.webuyanycar.test.Utilities;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.util.Properties;

import static constants.FilePaths.CONFIG_ROOT;

public class Hooks {

    @Before
    public void BeforeSteps() {
        Core.getWebDriver();
        String envConfig = System.getProperty("config");
        Properties envDetails = Utilities.readProperties(CONFIG_ROOT+envConfig+".properties");
        BasePage.baseUrl= envDetails.getProperty("base_url");
    }

    @After
    public void AfterSteps() {
        Core.getWebDriver().quit();
    }
}


