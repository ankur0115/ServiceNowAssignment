#### **Project Technologies**

This solution uses following technologies/plugins to accomplish the goal
1) JDK 11
2) Maven Version 3.6.3
3) Cucumber (various plugins, please refer to parent pom.xml)
4) Selenium-java plugin version 3.141.59
5) Chrome version 86.0.4240.111

#### **Project Description**

We will be executing this as a maven project. This project follows Page Object Model design pattern to accomplish the use case

Following are the components:

1) **Features** : This package contains all the feature files written in Gherkin. As of now this only contains
one feature file which describes the product purchase flow from automationpractice website as specified in the assignment.

2) **Pages**: This package contains two page classes viz.,HomePage and CheckoutPages. Each class contains page objects
and methods which will be used under step definitions to execute a particular step.

3) **StepDefinitions**: This package contains a class file with the name purchaseStepDef. This class contains
the implementation of all the steps listed under feature file.

4) **Utils**: This package contains a class file called TestBase. This class will be extended by all page classes and step definition classes.
This class will be used to perform functions like instantiating your webdriver, managing browser window properties and clearing cookies.
The intent of this class is to contain all the operations that are common, repetitive and will be required
by all your step definition classes frequently. This will avoid code duplication like instantiating webdriver 
over and over again, maximizing window everytime a browser instance is launched etc.
Similarly, had our project required making database connections, loading properties from an external file, we would
have used the same class to instantiate the connections and properties. 

5) **Runner**: This package contains a simple Junit class which is used to execute the tests as a cucumber project. To keep it very simple,
 I have not used any test annotations to call test methods inside this class . I've just instructed the runner to execute this 
 class as a cucumber project and provided the location of feature files and their corresponding step definitions.


#### **Instructions for Running the project**
 
1) Open the project in IDE.

2) Ensure that your system has correct setup for JDK and Maven.

3) Download chromedriver from here: https://chromedriver.storage.googleapis.com/index.html?path=86.0.4240.22/

4) Open ServiceNowProjectAssignment as a maven project.

5) Once you open the project in IDE (just a side not that i'm using IntelliJ), navigate to src\test\java\Utils\TestBase.java.

6) Update driver location in System.setProperty method to the path where you have stored chrome.exe downloaded in Step 3.  

7) Go to the terminal and run `mvn test`

8) You can also just right click on TestRunner class and run it. It will start test execution.

##### **Design Improvements**
1) We can use webdrivermanager dependency from github to get rid of storing the browser driver
at a specific location and then providing its path for setting up system property. It does the following:
    - It checks the version of the browser installed in your machine (e.g. Chrome, Firefox).
    - It matches the version of the driver (e.g. chromedriver, geckodriver). If unknown, it uses the latest version of the driver.
    - It downloads the driver if it is not present on the WebDriverManager cache (~/.cache/selenium by default).
    - It exports the proper WebDriver Java environment variables required by Selenium (not done when using WebDriverManager from the CLI or as a Server).`

2) Instead of providing the url in the TestBase class' instantiation method, we can save url 
in an external properties file and pick it from there everytime we instantiate our driver. Same thing
can be done for providing username and password.

3) We can also parameterize the step in feature file where username and password is getting provided.
This can be accomplished by using data tables. This way, the same scenario can be run for a different
user.

4) Instead of using a plain JUnit class, we can use TestNG classes to execute the tests.
TestNG has a lot of advantages in terms of support for parallel execution, reporting capabilities, 
grouping & prioritizing tests and so on.
