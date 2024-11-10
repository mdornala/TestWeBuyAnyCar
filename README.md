About the Project:
This is an automation test project using WeBuyAnyCar website.

Tech stack:
 
  - Java 11
  - Selenium 
  - Cucumber
  - Maven
  - IntelliJ IDE

How to run the test?
1. Install all software in Tech Stack
2. Download the project
3. Intellij - Import the project as maven
4. Open - src/test/java/RunCucumberTest.java and click Run icon (Note: Run configuration window add -Dconfig=prodEnv argument") .

We can run test from command line then:
  After Step 1 and 2, Open the cmd(windows)/terminal(linux/mac) then navigate to the project folder.
  Execute the command '**mvn clean test -Dconfig=prodEnv**' 

 Report: After execution the html report is present under **target/cucumber-reports.html**

Note: The test file in src/test/resources/features/RetriveCarDetailsTest.feature


Additional Info:
1. The input and output files are passed as parameters in cucumber feature file. So new set of files will be added for testing if needed.

 