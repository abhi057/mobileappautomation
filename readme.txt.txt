This is a Maven project with page Obect Model BDD Framework with Rest Assured and Test NG and Extent Reports

Note: Pages for Page Object Model are ready and BDD framework Skeleton is ready. But needs to be modified and refined a bit to use POM and BDD. But running the runner file runs the skeleton Step Definition file

I am using ResAssured to read the response and parsing it to form the Note Title and Note Description.

Steps to run:

Start Appium
Go to testng.xml and Right Click and select Run as TestNG suite
This runs the two test cases: Firstone which adds a note and verifies whether the note is added. Second is a dummy test case.

Refresh the project and see a Extent report generated in reports folder
Framework Design: Settings for starting emulator etc are added in AndroidBaseTest in org.fw.testUtils getTestData() method is added in AppiumUtils for reading test data from api provided. It uses RestAssured and JsonPath for parsing. Pages for Page Object Model are added in org.fw.pageObjects.android Properties are added in org.fw.pageObjects.properties Reuseable methods are added in org.fw.resuableMethods

There are Features, StepDefs and Runner folders added for BDD implementation. Currently we can run the Runner class but stepDefs implementation is dummy for now