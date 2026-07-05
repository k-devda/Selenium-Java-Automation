package tests;

//import com.sun.tools.javac.launcher.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class PrimeNestTestCases {
	
	public static void main(String[] args)throws InterruptedException 
	{
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-logging");
		options.addArguments("--log-level=3");
		
		WebDriver driver = new ChromeDriver(options);
		
		String str = "file:///C:/Users/dell/Desktop/RealEsate Project/index.html";
		
		driver.manage().window().maximize();

        driver.get(str);

        Thread.sleep(3000);
        String title = driver.getTitle();

        System.out.println("Website Title is : " + title);
////
        if(title.contains("PrimeNest"))
        {
           System.out.println("TC01 PASS - Homepage Opened");
        }
       else
        {
            System.out.println("TC01 FAIL");
        }
        
        boolean result = title.contains("PrimeNest");

        System.out.println(result);
////        
        // TC03 Home
        driver.findElement(By.linkText("Home")).click();
        Thread.sleep(2000);
        boolean tc03 = driver.findElement(By.id("home")).isDisplayed();
        System.out.println("TC03 Home Click = " + tc03);
////
////        // TC04 About
/// 
        driver.findElement(By.linkText("About")).click();
       Thread.sleep(2000);
        boolean tc04 = driver.findElement(By.id("about")).isDisplayed();
        System.out.println("TC04 About Click = " + tc04);
////
////        // TC05 Contact
       driver.findElement(By.linkText("Contact")).click();
        Thread.sleep(2000);
        boolean tc05 = driver.findElement(By.id("contact")).isDisplayed();
        System.out.println("TC05 Contact Click = " + tc05);
////        
////     // TC06 Theme Toggle
////
        String oldTheme = driver.findElement(By.tagName("html"))
                                .getAttribute("data-theme");
////
       driver.findElement(By.id("themeToggle")).click();
////
        Thread.sleep(2000);
////
       String newTheme = driver.findElement(By.tagName("html"))
                                .getAttribute("data-theme");
////
       boolean tc06 = !oldTheme.equals(newTheme);
////
       System.out.println("TC06 Theme Toggle = " + tc06);
////
//
//     // TC07 Search Mumbai Properties
//
//     // Select Mumbai city
        Select city = new Select(driver.findElement(By.id("heroCity")));
        city.selectByVisibleText("Mumbai");
////
       Thread.sleep(2000);
////
////        // Confirm selected city
       System.out.println("Selected City = " + city.getFirstSelectedOption().getText());
////
////        // Click Search button
        driver.findElement(By.className("search-btn")).click();
////
       Thread.sleep(3000);
////
////        // Check result
       String pageSource = driver.getPageSource();
////
        boolean tc07 = pageSource.contains("Mumbai");
////
        System.out.println("TC07 Search Mumbai = " + tc07);
////        
        driver.navigate().refresh();
        Thread.sleep(5000);
////
        JavascriptExecutor js = (JavascriptExecutor) driver;
////
        js.executeScript("arguments[0].click();",
        driver.findElement(By.className("search-btn")));
////
        Thread.sleep(3000);
////
      String pageSource2 = driver.getPageSource();
////
       boolean tc08 = pageSource2.contains("Featured") || pageSource2.contains("Properties");

       System.out.println("TC08 Empty Search = " + tc08);
////        
        driver.navigate().refresh();
        Thread.sleep(5000);
////
////        // Select Ahmedabad city
        Select city2 = new Select(driver.findElement(By.id("heroCity")));
        city2.selectByVisibleText("Ahmedabad");
////
        Thread.sleep(2000);
////
        System.out.println("Selected City = " + city2.getFirstSelectedOption().getText());
////
////        // Click Search
        driver.findElement(By.className("search-btn")).click();
////
        Thread.sleep(3000);
////
////        // Validate result
        String pageSource3 = driver.getPageSource();
////
        boolean tc09 = pageSource3.contains("Ahmedabad");
////
        System.out.println("TC09 Ahmedabad Filter = " + tc09);
////        
        driver.navigate().refresh();
        Thread.sleep(5000);
////
////        // Select Villa type
        Select type = new Select(driver.findElement(By.id("heroType")));
        type.selectByVisibleText("Villa");
////
       Thread.sleep(2000);
////
        System.out.println("Selected Type = " + type.getFirstSelectedOption().getText());
////
////        // Click Search
        driver.findElement(By.className("search-btn")).click();
////
        Thread.sleep(3000);
////
////        // Validate result
        String pageSource4 = driver.getPageSource();
////
        boolean tc10 = pageSource4.contains("Villa");
////
        System.out.println("TC10 Villa Filter = " + tc10);
//        
        driver.navigate().refresh();
        Thread.sleep(10000);
////
////        // Apply filters first
        Select city3 = new Select(driver.findElement(By.id("heroCity")));
        city3.selectByVisibleText("Mumbai");
////
        Select type2 = new Select(driver.findElement(By.id("heroType")));
        type2.selectByVisibleText("Villa");
////
        Thread.sleep(2000);
////
////        // Click Reset button
        driver.findElement(By.xpath("//button[contains(text(),'Reset')]")).click();
        Thread.sleep(3000);
////
////        // Validate filters reset
////     // Validate filters reset
////
        Select cityReset = new Select(driver.findElement(By.id("heroCity")));
        Select typeReset = new Select(driver.findElement(By.id("heroType")));
////
        String selectedCity = cityReset.getFirstSelectedOption().getText();
        String selectedType = typeReset.getFirstSelectedOption().getText();
        String pageSource5 = driver.getPageSource();
////
       boolean tc11 =
       selectedCity.equals("All Cities") &&
        selectedType.equals("All Types") &&
        (pageSource5.contains("Featured") || pageSource5.contains("Properties"));
////
        System.out.println("TC11 Reset Filters = " + tc11);
////        
        driver.navigate().refresh();
        Thread.sleep(5000);
////
//        JavascriptExecutor js = (JavascriptExecutor) driver;
////
        WebElement heart =
        driver.findElement(By.className("wishlist-btn"));
////
        js.executeScript("arguments[0].scrollIntoView(true);", heart);
        Thread.sleep(2000);
////
        js.executeScript("arguments[0].click();", heart);
////
        Thread.sleep(2000);
////
       String pageSource6 = driver.getPageSource();
////
       boolean tc12 = pageSource6.contains("active") || pageSource6.contains("saved");
        System.out.println("TC12 Wishlist Save = " + tc12);
////        
        driver.navigate().refresh();
        Thread.sleep(5000);
////
////        // Click first View Details button
////        // TC13 Open Property Details
        js.executeScript("document.getElementById('properties').scrollIntoView(true);");
        Thread.sleep(2000);
////
        WebElement details = driver.findElement(
            By.xpath("//div[@id='propertiesGrid']//button[contains(., 'View Details')]")
        );
////
        js.executeScript("arguments[0].click();", details);
        Thread.sleep(3000);
////
        System.out.println("TC13 View Details Opened");
////        
////     // TC14 Close Property Details
////
        WebElement closeBtn = driver.findElement(
            By.xpath("//div[contains(@class,'modal')]//button | //div[contains(@class,'modal')]//span[contains(text(),'×')]")
        );
////
        js.executeScript("arguments[0].click();", closeBtn);
////
        Thread.sleep(2000);
////
////        // Verify modal closed
        boolean tc14 = driver.findElements(
            By.xpath("//div[contains(@class,'modal') and contains(@style,'display: block')]")
        ).size() == 0;
////
        System.out.println("TC14 Property Details Closed = " + tc14);
////        
////        
////     // TC15 EMI Calculator with Valid Data
////
        driver.navigate().refresh();
        Thread.sleep(4000);
////
////        // Scroll to EMI Calculator/ 
        WebElement emiHeading = driver.findElement(
        By.xpath("//h3[contains(text(),'EMI Calculator')]"));
////
        js.executeScript("arguments[0].scrollIntoView(true);",emiHeading);
        Thread.sleep(3000);
////
////        // Enter Values
        driver.findElement(By.id("emiPrice")).sendKeys("50000000");
        driver.findElement(By.id("emiDown")).sendKeys("6500000");
        driver.findElement(By.id("emiRate")).sendKeys("8.5");
        driver.findElement(By.id("emiYears")).sendKeys("6");
////
        Thread.sleep(2000);
////
////        // Click Calculate EMI
        WebElement emiBtn = driver.findElement(
        By.xpath("//button[contains(text(),'Calculate EMI')]"));
////
        js.executeScript("arguments[0].click();", emiBtn);
        
        Thread.sleep(3000);
////
////        // Result Check
        String emiText = driver.findElement(By.id("emiResult")).getText();
////
        boolean tc15 = emiText.length() > 0;
////
        System.out.println("TC15 EMI Valid Data = " + tc15);
        System.out.println("EMI Result = " + emiText);
////        
////     // TC16 EMI Calculator with Blank Data
////
        driver.navigate().refresh();
        Thread.sleep(4000);
////
////        // Scroll to EMI Calculator
        WebElement emiHeading2 = driver.findElement(
        By.xpath("//h3[contains(text(),'EMI Calculator')]"));
////
        js.executeScript("arguments[0].scrollIntoView(true);", emiHeading2);
        Thread.sleep(3000);
////
////        // Clear all EMI fields
        driver.findElement(By.id("emiPrice")).clear();
        driver.findElement(By.id("emiDown")).clear();
        driver.findElement(By.id("emiRate")).clear();
        driver.findElement(By.id("emiYears")).clear();
////
        Thread.sleep(1000);
////
////        // Click Calculate EMI
        WebElement emiBtn2 = driver.findElement(
       By.xpath("//button[contains(text(),'Calculate EMI')]"));
////
       js.executeScript("arguments[0].click();", emiBtn2);
////
       Thread.sleep(3000);
////
////        // Check result
       String emiResult =
       driver.findElement(By.id("emiResult")).getText();
////
        boolean tc16 =
        driver.findElement(By.id("emiResult")).isDisplayed()
        || emiResult.length() == 0;
////
        System.out.println("TC16 EMI Blank Data = " + tc16);
      System.out.println("EMI Result = " + emiResult);
////
////        
////     // TC17 ROI Calculator with Valid Data
////
        driver.navigate().refresh();
        Thread.sleep(4000);
////
////        // Scroll to ROI Calculator
        WebElement roiHeading = driver.findElement(
       By.xpath("//h3[contains(text(),'ROI Calculator')]"));
////
        js.executeScript("arguments[0].scrollIntoView(true);", roiHeading);
        Thread.sleep(3000);
////
////        // Clear old values first
        driver.findElement(By.id("roiPrice")).clear();
        driver.findElement(By.id("roiRent")).clear();
        driver.findElement(By.id("roiExpenses")).clear();
////
////        // Enter Valid ROI Values
        driver.findElement(By.id("roiPrice")).sendKeys("5000000");
        driver.findElement(By.id("roiRent")).sendKeys("25000");
      driver.findElement(By.id("roiExpenses")).sendKeys("50000");
////
        Thread.sleep(2000);
////
////        // Click Calculate ROI
       WebElement roiBtn = driver.findElement(By.xpath("//button[contains(text(),'Calculate ROI')]"));
////
        js.executeScript("arguments[0].click();", roiBtn);
////
       Thread.sleep(3000);
////
////        // Get ROI Result
        String roiText =
       driver.findElement(By.id("roiResult")).getText();
////
////        // Validate Result Properly
        boolean tc17 =
        roiText.length() > 0 &&
        (roiText.contains("%") || roiText.contains("ROI"));
////
        System.out.println("TC17 ROI Valid Data = " + tc17);
        System.out.println("ROI Result = " + roiText);
///         
     // TC18 Login - Open Login Popup

        driver.navigate().refresh();
        Thread.sleep(4000);

        // Scroll to top because Login button is in navbar
        js.executeScript("window.scrollTo(0,0)");
        Thread.sleep(2000);

////        // Click Login Button
        WebElement loginBtn = driver.findElement(
        By.id("openLogin"));

        js.executeScript("arguments[0].click();", loginBtn);
        Thread.sleep(3000);
        // Check Login Popup/Page Opens
        WebElement loginPopup = driver.findElement(
        By.id("loginModal"));

        boolean tc18 = loginPopup.isDisplayed();

        System.out.println("TC18 Login Open Popup = " + tc18);
        
////     // TC19 Signup - Open Signup Popup
        driver.navigate().refresh();
        Thread.sleep(4000);
        // Scroll to top because Signup button is in navbar
        js.executeScript("window.scrollTo(0,0)");
        Thread.sleep(2000);

        // Click Signup Button
        WebElement signupBtn = driver.findElement(
        By.id("openSignup"));

        js.executeScript("arguments[0].click();", signupBtn);

        Thread.sleep(3000);
////        // Check Signup Popup/Page Opens
        WebElement signupPopup = driver.findElement(
        By.id("signupModal"));

       boolean tc19 = signupPopup.isDisplayed();

        System.out.println("TC19 Signup Open Popup = " + tc19);
        
////     // TC20 UI - Scroll Top Button

        driver.navigate().refresh();
        Thread.sleep(4000);

        // Scroll page down
        js.executeScript("window.scrollBy(0,2500)");
        Thread.sleep(3000);

////        // Click Scroll Top Button
       WebElement topBtn = driver.findElement(By.id("scrollTop"));

        js.executeScript("arguments[0].click();", topBtn);

        Thread.sleep(3000);

////        // Check page reached top
        Long topPosition = (Long) js.executeScript("return window.pageYOffset;");
       boolean tc20 = topPosition == 0;

        System.out.println("TC20 Scroll Top Button = " + tc20);
    
     // TC21 Login Without Signup Should Fail

        driver.navigate().refresh();
        Thread.sleep(4000);

      //  JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scroll top
        js.executeScript("window.scrollTo(0,0)");
        Thread.sleep(2000);

        // Open Login Popup
        WebElement loginBtn21 = driver.findElement(By.id("openLogin"));
        js.executeScript("arguments[0].click();", loginBtn21);
        Thread.sleep(2000);

        // Enter Fake User Details (not registered)
        driver.findElement(By.id("loginEmail")).clear();
        driver.findElement(By.id("loginEmail")).sendKeys("testuser@gmail.com");

        driver.findElement(By.id("loginPassword")).clear();
        driver.findElement(By.id("loginPassword")).sendKeys("123456");

        Thread.sleep(1000);

        // Click Login
        WebElement loginSubmit = driver.findElement(
        By.xpath("//div[@id='loginModal']//button[contains(text(),'Login')]"));

        js.executeScript("arguments[0].click();", loginSubmit);

        Thread.sleep(3000);

        // Check login failed properly
        boolean loginStillOpen =
        driver.findElement(By.id("loginModal")).isDisplayed();

        String pageData = driver.getPageSource();

        boolean errorShown =
        pageData.contains("Invalid") ||
        pageData.contains("Register") ||
        pageData.contains("Sign Up") ||
        pageData.contains("Signup First");

        boolean tc21 = loginStillOpen || errorShown;

        System.out.println("TC21 Login Without Signup Blocked = " + tc21);
        
     // TC22 Login Blank Username

        driver.navigate().refresh();
        Thread.sleep(4000);

        // Create JS object
       

        // Scroll top
        js.executeScript("window.scrollTo(0,0)");
        Thread.sleep(2000);

        // Open Login Popup
        WebElement loginBtn22 = driver.findElement(By.id("openLogin"));
        js.executeScript("arguments[0].click();", loginBtn22);
        Thread.sleep(2000);

        // Leave Username Blank
        driver.findElement(By.id("loginEmail")).clear();

        // Enter Password Only
        driver.findElement(By.id("loginPassword")).clear();
        driver.findElement(By.id("loginPassword")).sendKeys("123456");

        Thread.sleep(1000);

        // Click Login
        WebElement loginSubmit22 = driver.findElement(
        By.xpath("//div[@id='loginModal']//button[contains(text(),'Login')]"));

        js.executeScript("arguments[0].click();", loginSubmit22);

        Thread.sleep(3000);

     // Validate Login Blocked
        boolean loginStillOpen22 =
        driver.findElement(By.id("loginModal")).isDisplayed();

        String pageData22 = driver.getPageSource();

        boolean errorShown22 =
        pageData22.contains("required") ||
        pageData22.contains("Invalid") ||
        pageData22.contains("Enter Email") ||
        pageData22.contains("Please fill");

        boolean tc22 = loginStillOpen22 || errorShown22;

        System.out.println("TC22 Login Blank Username = " + tc22);
        
        
     // TC23 Signup then Login with same credentials

        driver.navigate().refresh();
        Thread.sleep(4000);

        // scroll top
        js.executeScript("window.scrollTo(0,0)");
        Thread.sleep(2000);

        // open signup
        WebElement signupBtn23 = driver.findElement(By.id("openSignup"));
        js.executeScript("arguments[0].click();", signupBtn23);
        Thread.sleep(2000);

        // fill signup form with correct ids
        driver.findElement(By.id("suName")).clear();
        driver.findElement(By.id("suName")).sendKeys("Khushi Devda");

        driver.findElement(By.id("suEmail")).clear();
        driver.findElement(By.id("suEmail")).sendKeys("khushi123@gmail.com");

        driver.findElement(By.id("suPhone")).clear();
        driver.findElement(By.id("suPhone")).sendKeys("9876543210");

        driver.findElement(By.id("suPassword")).clear();
        driver.findElement(By.id("suPassword")).sendKeys("Khushi@123");

        driver.findElement(By.id("suConfirm")).clear();
        driver.findElement(By.id("suConfirm")).sendKeys("Khushi@123");

        Select role = new Select(driver.findElement(By.id("suRole")));
        role.selectByVisibleText("Buyer");

        Thread.sleep(1000);

        // click create account
        WebElement createAccountBtn = driver.findElement(
                By.xpath("//form[@id='signupForm']//button[contains(text(),'Create Account')]")
        );
        js.executeScript("arguments[0].click();", createAccountBtn);
        Thread.sleep(4000);

        // accept alert if it appears
        try {
            org.openqa.selenium.Alert alert = driver.switchTo().alert();
            System.out.println("Signup Alert = " + alert.getText());
            alert.accept();
        } catch (Exception ignored) {
        }

        // verify user saved in localStorage
        String usersData = (String) js.executeScript("return localStorage.getItem('primenest_users');");
        boolean signupSaved = usersData != null && usersData.contains("khushi123@gmail.com");

        System.out.println("Signup Saved = " + signupSaved);

        // signup auto logs in, so logout first to test login properly
        try {
            WebElement logoutBtn = driver.findElement(By.xpath("//button[contains(.,'Logout')]"));
            js.executeScript("arguments[0].click();", logoutBtn);
            Thread.sleep(2000);
        } catch (Exception e) {
            js.executeScript("logout();");
            Thread.sleep(2000);
        }

     // open login
        WebElement loginBtn23 = driver.findElement(By.id("openLogin"));
        js.executeScript("arguments[0].click();", loginBtn23);
        Thread.sleep(2500);

        // fill login
        driver.findElement(By.id("loginEmail")).clear();
        driver.findElement(By.id("loginEmail")).sendKeys("khushi123@gmail.com");

        driver.findElement(By.id("loginPassword")).clear();
        driver.findElement(By.id("loginPassword")).sendKeys("Khushi@123");

        Thread.sleep(1000);

        // click login
        WebElement loginSubmit23 = driver.findElement(
            By.xpath("//div[@id='loginModal']//button[contains(text(),'Login')]")
        );

        js.executeScript("arguments[0].click();", loginSubmit23);
        Thread.sleep(4000);

        // verify
        String sessionData =
        (String) js.executeScript("return localStorage.getItem('primenest_session');");

        boolean loginSuccess =
        sessionData != null &&
        sessionData.contains("khushi123@gmail.com");

        System.out.println("TC23 Signup + Login Success = " + (signupSaved && loginSuccess));
        
        driver.quit();
	}
	
	public static double calculateEMI(double principal, double annualRate, int years)
	{
	    double monthlyRate = annualRate / 12 / 100;
	    int months = years * 12;

	    double emi =
	    (principal * monthlyRate * Math.pow(1 + monthlyRate, months)) /
	    (Math.pow(1 + monthlyRate, months) - 1);

	    return emi;
	}

	public static String formatIndianCurrency(double amount)
	{
	    if(amount >= 10000000)
	    {
	        return "₹" + String.format("%.2f", amount / 10000000) + " Cr";
	    }
	    else if(amount >= 100000)
	    {
	        return "₹" + String.format("%.2f", amount / 100000) + " L";
	    }
	    else
	    {
	        return "₹" + String.format("%.2f", amount);
	    }
	}

	}
	

