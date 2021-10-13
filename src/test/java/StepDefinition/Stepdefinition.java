package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import hooks.hookclass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefinition {
	
	WebDriver driver=hookclass.driver;
	
@Given("User is on Elearning site")
public void user_is_on_elearning_site() {
   try
   {
	   System.setProperty("webdriver.chrome.driver", "F:\\driverchrome\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://elearningm1.upskills.in/");		
		driver.manage().window().maximize();
		System.out.println("PASSED: Browser is triggered!!!");
   }
   catch(Exception e)
   {
	   System.out.println("EXCEPTION FOUND: Cannot open the browser!!!");
	   Assert.fail();
   }
}

@When("User enters username and password")
public void user_enters_username_and_password() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		 
		 driver.findElement(By.xpath("//input[@id='login']")).sendKeys("vaish123");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("vaish@123");
			Thread.sleep(2000);
			System.out.println("PASSED:User can enter username and password to login!!!");  
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot enter Username and Password!!!");
		   Assert.fail();
	   }
   
}

@And("click on Login button")
public void click_on_login_button() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    Thread.sleep(2000);
		    driver.findElement(By.id("form-login_submitAuth")).click();
			System.out.println("User can click the Login button!!!");
	   }
	   catch(Exception e)
	   {
		   System.out.println("PASSED:EXCEPTION FOUND: Cannot click the login button!!!");
		   Assert.fail();
	   }
    
}

@Then("User is redirected to the homepage")
public void user_is_redirected_to_the_homepage() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    String expectedtitle="My Organization - My education - My courses";
			String actualtitle=driver.getTitle();
			Assert.assertEquals(expectedtitle,actualtitle);
			Thread.sleep(2000);
			System.out.println("PASSED:User navigated to the Homepage!!!");
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot redirect to the Homepage!!!");
		   Assert.fail();
	   }
  
}
//compose1
@When("User clicks on the compose link")
public void user_clicks__on_the_compose_link() {
    // Write code here that turns the phrase above into concrete actions
	try
	{
		driver.findElement(By.xpath("//a[@href='http://elearningm1.upskills.in/main/messages/new_message.php']")).click();
		Thread.sleep(2000);
		System.out.println("PASSED: User can click the composemessage!!!");
	}
	catch(Exception ex)
	{
		System.out.println("EXCEPTION FOUND:Cannot click on compose link"+ex);
		Assert.fail();
	}
  
}

@When("User enters {string} in sendto box")
public void user_enters_in_sendto_box(String string) {
    // Write code here that turns the phrase above into concrete actions
	try
	{
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(string);
		Thread.sleep(2000);
		System.out.println("PASSED: User can enter toname!!!");
		
	}
	catch(Exception ex)
	{
		System.out.println("EXCEPTION FOUND:Cannot enter receiver name"+ex);
		Assert.fail();
	}
    
}

@And("User selects the receiver name")
public void User_selects_the_receiver_name_li_text() {
    // Write code here that turns the phrase above into concrete actions
	try
	{
		driver.findElement(By.xpath("//li[@class='select2-results__option select2-results__option--highlighted']")).click();
		Thread.sleep(2000);
		System.out.println("PASSED: User can select the receiver name!!!");
		
	}
	catch(Exception ex)
	{
		System.out.println("EXCEPTION FOUND: Cannot select the receiver name"+ex);
		Assert.fail();
	}
    
}

@And("User enters subjectline {string} in subject field")
public void user_enters_subjectline_in_subject_field_input_id(String string) {
    // Write code here that turns the phrase above into concrete actions
	try
	{
		driver.findElement(By.xpath("//input[@id='compose_message_title']")).sendKeys(string);
		Thread.sleep(2000);
		System.out.println("PASSED: User can enter the subject!!!");
	}
	catch(Exception ex)
	{
		System.out.println("EXCEPTION FOUND: Cannot enter subject line"+ex);
		Assert.fail();
	}
    
}
@And("User enter texts {string} in the message box")
public void user_enters_texts_in_the_message_box(String msg) {
	try
	{
		//WebElement iFrame =driver.findElement(By.xpath("//div[@id='cke_1_contents']/iframe"));
		//driver.switchTo().frame(iframe);
		WebElement obj=driver.findElement(By.xpath("//div[@id='cke_1_contents']/iframe"));
		//driver.switchTo().frame(0);		
		obj.sendKeys(msg);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		System.out.println("PASSED: User can enter text in message box!!!");
	}
	catch(Exception ex)
	{
		System.out.println("EXCEPTION FOUND: Cannot enter text in message box"+ex);
		Assert.fail();
	}
}
@And("User enter data in the {string} Description box")
public void user_enters_data_in_the_Description_box(String desc) {
	try
	{
		driver.findElement(By.id("file-descrtiption")).sendKeys(desc);
		Thread.sleep(2000);
		System.out.println("PASSED: User can enter the subject!!!");
	}
	catch(Exception ex)
	{
		System.out.println("EXCEPTION FOUND: Cannot enter subject line"+ex);
		Assert.fail();
	}
}
@And("User clicks send message button")
public void user_clicks_send_message_button_button_id() {
    // Write code here that turns the phrase above into concrete actions
	try
	{
		driver.findElement(By.xpath("//button[@id='compose_message_compose']")).click();
		Thread.sleep(2000);
		System.out.println("PASSED: User can click the send button!!!");
	}
	catch(Exception ex)
	{
		System.out.println("EXCEPTION FOUND: Cannot click send message button"+ex);
		Assert.fail();
	}
   
}
@Then("User gets confirmation message")
public void user_gets_confirmation_message() {
    // Write code here that turns the phrase above into concrete actions
	try
	{
		String expectedtitle="My Organization - My education";
		String actualtitle=driver.getTitle();
		Assert.assertEquals(expectedtitle,actualtitle);
		Thread.sleep(3000);
		System.out.println("PASSED: Message has successfully sent!!!");
		
	}
	catch(Exception ex)
	{
		System.out.println("EXCEPTION FOUND: User unable to navigate to Inbox page"+ex);
		Assert.fail();
	}
       driver.quit();
}
//Inbox_searchbutton
@When("User click on Inbox link")
public void user_click_on_inbox_link() {
	try
	{
		driver.findElement(By.xpath("//a[text()='Inbox ']")).click();
		Thread.sleep(2000);
		System.out.println("PASSED: User can see the Received messages!!!");
	}
	catch(Exception ex)
	{
		System.out.println("EXCEPTION FOUND: User cannot see the Received messages"+ex);
		Assert.fail();
	}
}
@Then("User can able to see the messages received")
public void user_can_able_to_see_the_messages_received() {
    // Write code here that turns the phrase above into concrete actions
	try
	{
		boolean obj=driver.findElement(By.xpath("//th[text()='Messages']")).isDisplayed();
		Thread.sleep(2000);
		System.out.println("PASSED: User can see the Received messages!!!"+obj);
	}
	catch(Exception ex)
	{
		System.out.println("EXCEPTION FOUND: User cannot see the Received messages"+ex);
		Assert.fail();
	}
}

@When("User enters text {string} in search box")
public void user_enters_text_in_search_box(String string) {
    // Write code here that turns the phrase above into concrete actions
	try
	{
		driver.findElement(By.xpath("//input[@id='search_keyword']")).sendKeys(string);
		Thread.sleep(2000);
		System.out.println("PASSED: User can enter text in Search box!!!");
	}
	catch(Exception ex)
	{
		System.out.println("EXCEPTION FOUND: User cannot enter text in Search box"+ex);
		Assert.fail();
	}
}

@When("clicks the Search button")
public void clicks_the_search_button() {
    // Write code here that turns the phrase above into concrete actions
	try
	{
		driver.findElement(By.xpath("//button[@id='search_submit']")).click();
		Thread.sleep(2000);
		System.out.println("PASSED: User can click the Search button!!!");
	}
	catch(Exception ex)
	{
		System.out.println("EXCEPTION FOUND: User cannot click the Search button"+ex);
		Assert.fail();
	}
}

@Then("User is displayed with respective message")
public void user_is_displayed_with_respective_message() {
    // Write code here that turns the phrase above into concrete actions
	try
	{
		boolean obj=driver.findElement(By.xpath("//a[@class='unread']")).isDisplayed();
		Thread.sleep(2000);
		System.out.println("PASSED: User is able to get respective message!!!"+obj);
	}
	catch(Exception ex)
	{
		System.out.println("EXCEPTION FOUND: User is not able to get respective message"+ex);
		Assert.fail();
	}

}
@When("User click on the select all button")
public void user_click_on_the_select_all_button() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    driver.findElement(By.xpath("//a[text()='Select all']")).click();
			Thread.sleep(2000);
			System.out.println("PASSED:User can click the Selectall button!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot click the Selectall button!!!");
		   Assert.fail();
	   }
}
@And("User click on the unselect all button")
public void user_click_on_the_unselect_all_button() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		 driver.findElement(By.xpath("//a[text()='Unselect all']")).click();
			Thread.sleep(2000);
			System.out.println("PASSED:User can click the Unselectall button!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot click the Unselectall button!!!");
		   Assert.fail();
	   }
	 driver.quit();
};
//Inbox_read
@When("User clicks the Inbox link")
public void user_clicks_the_inbox_link() {
	try
	{
		driver.findElement(By.xpath("//a[text()='Inbox ']")).click();
		Thread.sleep(2000);
		System.out.println("PASSED: User can see the Received messages!!!");
	}
	catch(Exception ex)
	{
		System.out.println("EXCEPTION FOUND: User cannot see the Received messages"+ex);
		Assert.fail();
	}
}
@When("User click on select all button")
public void user_click_on_select_all_button() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		 driver.findElement(By.xpath("//a[text()='Select all']")).click();
			Thread.sleep(2000);
			System.out.println("PASSED:User can click the Selectall button!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot click the Selectall button!!!");
		   Assert.fail();
	   }
}
@And("User clicks Detail dropdown")
public void user_clicks_Detail_dropdown() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    driver.findElement(By.xpath("//button[@data-toggle='dropdown']")).click();
			Thread.sleep(2000);
			System.out.println("PASSED:User can click the Detail dropown!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot click Detail dropown!!!");
		   Assert.fail();
	   }
}
@When("User clicks the Mark as Read option")
public void user_clicks_the_mark_as_read_option() {
    // Write code here that turns the phrase above into concrete actions
	try
	{
		driver.findElement(By.xpath("//a[text()='Mark as read']")).click();
		Thread.sleep(2000);
		System.out.println("PASSED: User can click the Mark as Read option!!!");
	}
	catch(Exception ex)
	{
		System.out.println("EXCEPTION FOUND: User cannot click the Mark as Read option"+ex);
		Assert.fail();
	}
}
@And("User accepts alert message from alert box")
public void user_accepts_alert_message_from_alert_box() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    driver.switchTo().alert().accept();
			Thread.sleep(2000);
			System.out.println("PASSED:User can click OK from alert box!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot click OK from alert box!!!");
		   Assert.fail();
	   }
}
@Then("User gets confirmation text")
public void user_gets_confirmation_text() {
    // Write code here that turns the phrase above into concrete actions
	try
	{
		boolean obj=driver.findElement(By.xpath("//div[@class='alert alert-info']")).isDisplayed();
		Thread.sleep(2000);
		System.out.println("PASSED: User can get a confirmation message!!!"+obj);
	}
	catch(Exception ex)
	{
		System.out.println("EXCEPTION FOUND: User cannot get a confirmation message"+ex);
		Assert.fail();
	}
}
@When("User click Detail dropdown")
public void user_click_Detail_dropdown() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    driver.findElement(By.xpath("//button[@data-toggle='dropdown']")).click();
			Thread.sleep(2000);
			System.out.println("PASSED:User can click the Detail dropown!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot click Detail dropown!!!");
		   Assert.fail();
	   }
}
@And("User clicks the Mark as Unread option")
public void user_clicks_the_mark_as_unread_option() {
    // Write code here that turns the phrase above into concrete actions
	try
	{
		driver.findElement(By.xpath("//a[text()='Mark as unread']")).click();
		Thread.sleep(2000);
		System.out.println("PASSED: User is able to click Mark as Unread option!!!");
	}
	catch(Exception ex)
	{
		System.out.println("EXCEPTION FOUND: User is not able to click Mark as Unread option"+ex);
		Assert.fail();
	}
}
@When("User accept the alert message from alert box")
public void user_accept_the_alert_message_from_alert_box() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    driver.switchTo().alert().accept();
			Thread.sleep(2000);
			System.out.println("PASSED:User can click OK from alert box!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot click OK from alert box!!!");
		   Assert.fail();
	   }
}
@Then("User gets a confirmation message")
public void user_gets_a_confirmation_message() {
    // Write code here that turns the phrase above into concrete actions
	try
	{
		boolean obj=driver.findElement(By.xpath("//div[@class='alert alert-info']")).isDisplayed();
		Thread.sleep(2000);
		System.out.println("PASSED: User can get a confirmation message!!!"+obj);
	}
	catch(Exception ex)
	{
		System.out.println("EXCEPTION FOUND: User cannot get a confirmation message"+ex);
		Assert.fail();
	}
	driver.quit();
}
//Inbox_reply
@When("User clicks on the Inbox link")
public void user_clicks_on_the_inbox_link() {
	try
	{
		driver.findElement(By.xpath("//a[text()='Inbox ']")).click();
		Thread.sleep(2000);
		System.out.println("PASSED: User can click the Inbox link!!!");
	}
	catch(Exception ex)
	{
		System.out.println("EXCEPTION FOUND: User cannot click the Inbox link"+ex);
		Assert.fail();
	}
}
@When("User clicks on Reply option of particular message")
public void user_clicks_on_reply_option_of_particular_message() {
    // Write code here that turns the phrase above into concrete actions
	try
	{
		driver.findElement(By.xpath("//em[@class='fa fa-reply fa-2x']")).click();
		Thread.sleep(2000);
		System.out.println("PASSED: User can click the Reply option!!!");
	}
	catch(Exception ex)
	{
		System.out.println("EXCEPTION FOUND: User cannot click the Reply option"+ex);
		Assert.fail();
	}
}

@When("User enter {string} in Description box")
public void user_enter_in_description_box(String string) {
    // Write code here that turns the phrase above into concrete actions
	try
	{
		driver.findElement(By.xpath("//input[@id='file-descrtiption']")).sendKeys(string);
		Thread.sleep(2000);
		System.out.println("PASSED: User can enter texts in Description box!!!");
	}
	catch(Exception ex)
	{
		System.out.println("EXCEPTION FOUND: User cannot enter texts in Description box"+ex);
		Assert.fail();
	}
}

@When("User clicks Send message")
public void user_clicks_send_message() {
    // Write code here that turns the phrase above into concrete actions
	try
	{
		driver.findElement(By.xpath("//button[@id='compose_message_compose']")).click();
		Thread.sleep(2000);
		System.out.println("PASSED: User can click the Send message button!!!");
	}
	catch(Exception ex)
	{
		System.out.println("EXCEPTION FOUND: User cannot click the Send message button"+ex);
		Assert.fail();
	}
}

@Then("User gets success message")
public void user_gets_success_message() {
    // Write code here that turns the phrase above into concrete actions
	try
	{
		boolean obj=driver.findElement(By.xpath("//div[@class='alert alert-success']")).isDisplayed();
		Thread.sleep(2000);
		System.out.println("PASSED: User can able to get a success message!!!"+obj);
	}
	catch(Exception ex)
	{
		System.out.println("EXCEPTION FOUND: User cannot able to get a success message"+ex);
		Assert.fail();
	}
	driver.quit();
}
//Inbox_forward
@When("User clck Inbox link")
public void user_clck_inbox_link() {
	try
	{
		driver.findElement(By.xpath("//a[text()='Inbox ']")).click();
		Thread.sleep(2000);
		System.out.println("PASSED: User can click the Inbox link!!!");
	}
	catch(Exception ex)
	{
		System.out.println("EXCEPTION FOUND: User cannot click the Inbox link"+ex);
		Assert.fail();
	}
}
@When("User clicks on Forward option from Edit")
public void user_clicks_on_forward_option_from_edit() {
    // Write code here that turns the phrase above into concrete actions
	try
	{
		driver.findElement(By.xpath("//em[@class='fa fa-share fa-2x']")).click();
		Thread.sleep(2000);
		System.out.println("PASSED: User can click the forward option!!!");
	}
	catch(Exception ex)
	{
		System.out.println("EXCEPTION FOUND: User cannot click the forward option"+ex);
		Assert.fail();
	} 
}

@When("User enters {string} toname in Message box")
public void user_enters_toname_in_message_box(String string) {
    // Write code here that turns the phrase above into concrete actions
	try
	{
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys("virat");
		Thread.sleep(2000);
		System.out.println("PASSED: User can enter name in Sendto field!!!");
		
	}
	catch(Exception ex)
	{
		System.out.println("EXCEPTION FOUND: User cannot enter name in Sendto field"+ex);
		Assert.fail();
	} 
}
@Then("User select the receiver name")
public void user_select_the_receiver_name() {
	try
	{
		driver.findElement(By.xpath("//li[@class='select2-results__option select2-results__option--highlighted']")).click();
		Thread.sleep(2000);
		System.out.println("PASSED: User can select name from Sendto field!!!");
	}
	catch(Exception ex)
	{
		System.out.println("EXCEPTION FOUND: User cannot select name from Sendto field"+ex);
		Assert.fail();
	} 
}
@Then("User enters {string} in Description box")
public void user_enters_in_description_box(String string) {
    // Write code here that turns the phrase above into concrete actions
	try
	{
		driver.findElement(By.xpath("//input[@name='legend[]']")).sendKeys(string);
		Thread.sleep(2000);
		System.out.println("PASSED: User can enter text in Description box!!!");
	}
	catch(Exception ex)
	{
		System.out.println("EXCEPTION FOUND: User cannot enter text in Description box"+ex);
		Assert.fail();
	}
}

@Then("User click Send message button")
public void user_click_send_message_button() {
    // Write code here that turns the phrase above into concrete actions
	try
	{
		driver.findElement(By.xpath("//button[@name='compose']")).click();
		Thread.sleep(2000);
		System.out.println("PASSED: User can click the send message button!!!");
	}
	catch(Exception ex)
	{
		System.out.println("EXCEPTION FOUND: User cannotclick the send message button"+ex);
		Assert.fail();
	}
}

@Then("User gets validation message.")
public void user_gets_validation_message() {
    
	try
	{
		boolean obj=driver.findElement(By.xpath("//div[@class='alert alert-success']")).isDisplayed();
		Thread.sleep(2000);
		System.out.println("PASSED: User gets a success message!!!"+obj);
	}
	catch(Exception ex)
	{
		System.out.println("EXCEPTION FOUND: User cannot get a success message"+ex);
		Assert.fail();
	}
	driver.quit();
}

//Inbox_Composebutton
@When("User clicks on Inbox link")
public void user_clicks_on_inbox_link() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    driver.findElement(By.xpath("//a[text()='Inbox ']")).click();
			Thread.sleep(2000);
			System.out.println("PASSED:User can click the Inbox link!!!");
			  
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot click the Inbox link!!!");
		   Assert.fail();
	   }
}

@When("User clicks on Composemessage link")
public void user_clicks_on_composemessage_link() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    driver.findElement(By.xpath("//img[@title='Compose message']")).click();
			Thread.sleep(2000);
			System.out.println("PASSED:User can click the composemessage!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot click the Compose message link!!!");
		   Assert.fail();
	   }
}

@And("User clicks the back button")
public void user_clicks_the_back_button() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    driver.findElement(By.xpath("//img[@alt='Back']")).click();
			Thread.sleep(2000);
			System.out.println("PASSED:User can click the back button!!!");  
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot click the back button!!!");
		   Assert.fail();
	   }
}

@Then("User navigates to the inbox section")
public void user_navigates_to_the_inbox_section() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    String expectedtitle="My Organization - My education";
			String actualtitle=driver.getTitle();
			Assert.assertEquals(expectedtitle,actualtitle);
			Thread.sleep(2000);
			System.out.println("PASSED:User navigated to the Inbox page!!!");
			
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot redirect to inbox section!!!");
		   Assert.fail();
	   }
	 driver.quit();
}
//Inbox_Outboxbutton
@When("User clicks Inbox link")
public void user_clicks_inbox_link() {
	try
	{
		driver.findElement(By.xpath("//a[text()='Inbox ']")).click();
		Thread.sleep(2000);
		System.out.println("PASSED: User can click the Inbox link!!!");
	}
	catch(Exception ex)
	{
		System.out.println("EXCEPTION FOUND: User cannot click the Inbox link"+ex);
		Assert.fail();
	}
}
@When("User clicks on Outbox link")
public void user_clicks_on_outbox_link() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    driver.findElement(By.xpath("//img[@alt='Outbox']")).click();
			Thread.sleep(2000);
			System.out.println("PASSED:User can click the Outbox!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot click the Outbox link!!!");
		   Assert.fail();
	   }
}

@Then("User can able to see the {string} messages sent")
public void user_can_able_to_see_the_messages_sent(String string) {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
			String actualtext=string;
			String expectedtext=driver.findElement(By.xpath("//th[@class='th-header']")).getText();
			Assert.assertEquals(expectedtext,actualtext);
			Thread.sleep(2000);
			System.out.println("PASSED:User can see the Messages listed!!!"+actualtext);  
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot see the Messages listed!!!");
		   Assert.fail();
	   }
}

@When("User clicks on select all button")
public void user_clicks_on_select_all_button() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    driver.findElement(By.xpath("//a[text()='Select all']")).click();
			Thread.sleep(2000);
			System.out.println("PASSED:User can click the Selectall button!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot click the Selectall button!!!");
		   Assert.fail();
	   }
}

@When("User clicks the unselect all button")
public void user_clicks_the_unselect_all_button() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    driver.findElement(By.xpath("//a[text()='Unselect all']")).click();
			Thread.sleep(2000);
			System.out.println("PASSED:User can click the UnSelectall button!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot click the UnSelectall button!!!");
		   Assert.fail();
	   }
}
@Then("User clicks back button")
public void user_clicks_back_button()
{
	 try
	   {
		    driver.findElement(By.xpath("//img[@alt='Back']")).click();
			Thread.sleep(2000);
			System.out.println("PASSED:User can click the back button!!!");  
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot click the back button!!!");
		   Assert.fail();
	   }
	 driver.quit();
}
//OutboxDel
@When("User clicks on Inbox tab")
public void user_clicks_on_inbox_tab() {
	try
	{
		driver.findElement(By.xpath("//a[text()='Inbox ']")).click();
		Thread.sleep(2000);
		System.out.println("PASSED: User can click the Inbox link!!!");
	}
	catch(Exception ex)
	{
		System.out.println("EXCEPTION FOUND: User cannot click the Inbox link"+ex);
		Assert.fail();
	}
}
@When("User clicks on the select all button")
public void user_clicks_on_the_select_all_button() {
    // Write code here that turns the phrase above into concrete actions
	try
	   {
		    driver.findElement(By.xpath("//a[text()='Select all']")).click();
			Thread.sleep(2000);
			System.out.println("PASSED:User can click the Selectall button!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot click the Selectall button!!!");
		   Assert.fail();
	   }
}

@When("User clicks the Detail dropdown")
public void user_clicks_the_Detail_dropdown() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    driver.findElement(By.xpath("//button[@data-toggle='dropdown']")).click();
			Thread.sleep(2000);
			System.out.println("PASSED:User can click the Detail dropdown!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot click the Detail dropdown!!!");
		   Assert.fail();
	   }
}

@When("User clicks the Delete Selected messages option")
public void user_clicks_the_Delete_Selected_messages_option() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
			driver.findElement(By.xpath("//a[@data-action='delete']")).click();
			Thread.sleep(2000);
			System.out.println("PASSED:User can click the Delete Selected messages option!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot click the Delete Selected messages option!!!");
		   Assert.fail();
	   }
}

@When("User accepts the alert message from alert box")
public void user_accepts_the_alert_message_from_alert_box() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    driver.switchTo().alert().accept();
			Thread.sleep(2000);
			System.out.println("PASSED:User can click OK from alert box!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot click OK from alert box!!!");
		   Assert.fail();
	   }
}

@Then("User gets a confirmation {string}")
public void user_gets_a_confirmation(String string) {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    String actualtext=string;
			String expectedtext=driver.findElement(By.xpath("//a[text()='Back to outbox']")).getText();
			Assert.assertEquals(expectedtext,actualtext);
			Thread.sleep(2000);
			System.out.println("PASSED:User gets a confirmation message!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot get a confirmation message!!!");
		   Assert.fail();
	   }
	 driver.quit();
}
//InvitationSentPI
@When("User clicks on Pending Invitation link")
public void user_clicks_on_pending_invitation_link() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    driver.findElement(By.xpath("//a[text()='Pending invitations']")).click();
			Thread.sleep(2000);
			System.out.println("PASSED:User can click Pending Invitation Link!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot click Pending Invitation Link!!!");
		   Assert.fail();
	   }
}

@Then("User is displayed with the Invitations sent")
public void user_is_displayed_with_the_invitations_sent() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		 boolean obj=driver.findElement(By.xpath("//h3[text()='Invitation sent']")).isDisplayed();
		 Thread.sleep(2000);
		 System.out.println("PASSED:User can see the Send Invitations!!!"+obj);   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot see the Send Invitations!!!");
		   Assert.fail();
	   }
	 driver.quit();
}
//PendingInvitation
@When("User clicks on Pending Invitation")
public void user_clicks_on_pending_invitation() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    driver.findElement(By.xpath("//a[text()='Pending invitations']")).click();
			Thread.sleep(2000);
			System.out.println("PASSED:User can click Pending Invitation Link!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot click Pending Invitation Link!!!");
		   Assert.fail();
	   }
}
@When("User clicks Try and Find Some Friends button")
public void user_clicks_try_and_find_some_friends_button() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    driver.findElement(By.xpath("//a[@class='btn btn-success']")).click();
			Thread.sleep(2000);
			System.out.println("PASSED:User can Try and Find Some Friends button!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot clickTry and Find Some Friends button!!!");
		   Assert.fail();
	   }
    }

@When("User enter name in {string} User,Group box")
public void user_enter_name_in_user_group_box(String string) {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    driver.findElement(By.xpath("//input[@id='q']")).sendKeys(string);
			Thread.sleep(2000);
			System.out.println("PASSED:User can enter name in User,Group box!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot enter name in User,Group box!!!");
		   Assert.fail();
	   }
}

@When("User choose an option from Type dropdown")
public void user_choose_an_option_from_type_dropdown() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    driver.findElement(By.xpath("//div[@class='filter-option-inner-inner']")).click();
			Thread.sleep(2000);
			System.out.println("PASSED:User can click the Type dropdown!!!"); 
			driver.findElement(By.xpath("//span[text()='User']")).click();
			Thread.sleep(2000);
			System.out.println("PASSED:User can choose an option from Type dropdown!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot choose an option from Type dropdown!!!");
		   Assert.fail();
	   } 
}

@When("User clicks on search button")
public void user_clicks_on_search_button() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    driver.findElement(By.xpath("//button[@id='search_user_submit']")).click();
			Thread.sleep(2000);
			System.out.println("PASSED:User can click search button!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot click search button!!!");
		   Assert.fail();
	   }
}

@Then("User is displayed with the result")
public void user_is_displayed_with_the_result() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    boolean obj=driver.findElement(By.xpath("//a[text()='Users']")).isDisplayed();
		    Thread.sleep(2000);
			System.out.println("PASSED:User can see the respective Usernames!!!"+obj);   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot see the respective Usernames!!!");
		   Assert.fail();
	   }
}

@When("User clicks the Send Invitation button")
public void user_clicks_the_send_invitation_button() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    driver.findElement(By.xpath("//a[@class='btn btn-default btn-sm btn-to-send-invitation']")).click();
			Thread.sleep(2000);
			System.out.println("PASSED:User can click the Send Invitation button!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot click the Send Invitation button!!!");
		   Assert.fail();
	   }
}

@When("User enters message {string} in the textbox")
public void user_enters_message_in_the_textbox(String string) {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    driver.findElement(By.xpath("//textarea[@id='content_invitation_id']")).sendKeys(string);
			Thread.sleep(2000);
			System.out.println("PASSED:User can enter message in the textbox!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot enter message in the textbox!!!");
		   Assert.fail();
	   }
}

@When("User clicks the Send message button")
public void user_clicks_the_send_message_button() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
			Thread.sleep(2000);
			System.out.println("PASSED:User can click the Send message button!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot click the Send message button!!!");
		   Assert.fail();
	   }
}

@Then("User gets the confirmation message")
public void user_gets_the_confirmation_message() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    boolean obj=driver.findElement(By.xpath("//div[text()='You already sent an invitation']")).isDisplayed();
		    Thread.sleep(2000);
			System.out.println("PASSED:User can get a confirmation message!!!"+obj);   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot get a confirmation message!!!");
		   Assert.fail();
	   }
	 driver.quit();
}
//SendmsgPending
@When("User clicks Pending Invitation link")
public void user_clicks_pending_invitation_link() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    driver.findElement(By.xpath("//a[text()='Pending invitations']")).click();
			Thread.sleep(2000);
			System.out.println("PASSED:User can click Pending Invitation link!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot click Pending Invitation link!!!");
		   Assert.fail();
	   }
}
@When("User click Try and Find Some Friends button")
public void user_click_try_and_find_some_friends_button() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    driver.findElement(By.xpath("//a[@class='btn btn-success']")).click();
			Thread.sleep(2000);
			System.out.println("PASSED:User can Try and Find Some Friends button!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot clickTry and Find Some Friends button!!!");
		   Assert.fail();
	   }
    }
@When("User enters name in {string} User,Group box")
public void user_enters_name_in_user_group_box(String string) {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    driver.findElement(By.xpath("//input[@id='q']")).sendKeys(string);
			Thread.sleep(2000);
			System.out.println("PASSED:User can enter name in User,Group box!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot enter name in User,Group box!!!");
		   Assert.fail();
	   }
}

@When("User choose an option from Type dropDown")
public void user_choose_an_option_from_type_drop_down() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		 driver.findElement(By.xpath("//div[@class='filter-option-inner-inner']")).click();
			Thread.sleep(2000);
			System.out.println("PASSED:User can click the Type dropdown!!!"); 
			driver.findElement(By.xpath("//span[text()='User']")).click();
			Thread.sleep(2000);
			System.out.println("PASSED:User can choose an option from Type dropdown!!!");  
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot choose an option from Type dropDown!!!");
		   Assert.fail();
	   }
}

@When("User clicks search button")
public void user_clicks_search_button() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    driver.findElement(By.xpath("//button[@id='search_user_submit']")).click();
			Thread.sleep(2000);
			System.out.println("PASSED:User can click search button!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot click search button!!!");
		   Assert.fail();
	   }
}

@Then("User displayed with the result")
public void user_displayed_with_the_result() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    boolean obj=driver.findElement(By.xpath("//a[text()='Users']")).isDisplayed();
		    Thread.sleep(2000);
			System.out.println("PASSED:User is displayed with respective Usernames!!!"+obj);   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot display Username for the name entered!!!");
		   Assert.fail();
	   }
}

@When("User clicks Send Message button")
public void user_clicks_send_message_button() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    driver.findElement(By.xpath("//a[@data-title='Send message']")).click();
			Thread.sleep(2000);
			System.out.println("PASSED:User can click Send Message button!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot click Send Message button!!!");
		   Assert.fail();
	   }
}

@When("User enters subject {string} in the subjectbox")
public void user_enters_subject_in_the_subjectbox(String string) {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    driver.findElement(By.xpath("//input[@id='subject_id']")).sendKeys(string);
			Thread.sleep(2000);
			System.out.println("PASSED:User can enter subject in the subjectbox!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot enter subject in the subjectbox!!!");
		   Assert.fail();
	   }
}

@When("User enter message {string} in the textbox")
public void user_enter_message_in_the_textbox(String string) {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    driver.findElement(By.xpath("//textarea[@id='content_id']")).sendKeys(string);
			Thread.sleep(2000);
			System.out.println("PASSED:User can enter message in the textbox!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot enter message in the textbox!!!");
		   Assert.fail();
	   }
}
@And("User click the Send message button")
public void user_click_the_send_message_button() {
    // Write code here that turns the phrase above into concrete actions
	try
	   {
		    driver.findElement(By.xpath("//a[@id='send_message_link']")).click();
			Thread.sleep(2000);
			System.out.println("PASSED:User can click the send message button!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot click the send message button!!!");
		   Assert.fail();
	   }
    
}
@Then("User is displayed with confirmation message")
public void user_is_displayed_with_confirmation_message() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    boolean obj=driver.findElement(By.xpath("//div[text()='Your message has been sent.']")).isDisplayed();
		    Thread.sleep(2000);
			System.out.println("PASSED:User is displayed with confirmation message!!!"+obj);   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot get a confirmation message!!!");
		   Assert.fail();
	   }
	 driver.quit();
}
//PersonalData
@When("User clicks on Personal Data link")
public void user_clicks_on_personal_data_link() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    driver.findElement(By.xpath("//a[text()='Personal data']")).click();
			Thread.sleep(2000);
			System.out.println("PASSED:User can click Personal Data link!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot click Personal Data link!!!");
		   Assert.fail();
	   }
}

@Then("User can find the PersonalData Introduction")
public void user_can_find_the_personal_data_introduction() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    
			boolean obj= driver.findElement(By.xpath("//div[text()=' Personal data: introduction']")).isDisplayed();
			Thread.sleep(2000);
			System.out.println("PASSED:User can find the PersonalData Introduction!!!"+obj);   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot find the PersonalData Introduction!!!");
		   Assert.fail();
	   }
}

@When("User clicks on PersonalData we keep about you link")
public void user_clicks_on_personal_data_we_keep_about_you_link() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    driver.findElement(By.xpath("//a[@data-parent='#']")).click();
			Thread.sleep(2000);
			System.out.println("PASSED:User can click PersonalData we keep about you link!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot click PersonalData we keep about you link!!!");
		   Assert.fail();
	   }
}

@When("User expands some of the data")
public void user_expands_some_of_the_data() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    driver.findElement(By.xpath("//u[text()='Friends']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//u[text()='GradebookCertificate']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//u[text()='TrackECourseAccess']")).click();
			Thread.sleep(2000);
			System.out.println("PASSED:User can expand the data!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot expand the data!!!");
		   Assert.fail();
	   }
}

@Then("User is displayed with Terms and Conditions if available")
public void user_is_displayed_with_terms_and_conditions_if_available() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		   
			boolean obj=driver.findElement(By.xpath("//div[text()=' Permissions you gave us']")).isDisplayed();
			Thread.sleep(2000);
			System.out.println("PASSED:User is displayed with Terms and Conditions tab!!!"+obj);   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot find Terms and Conditions tab!!!");
		   Assert.fail();
	   }
	 driver.quit();
}
//EditprofileinPD
@When("User clicks on Edit profile link")
public void user_clicks_on_edit_profile_link() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    driver.findElement(By.xpath("//a[@class='btn btn-default btn-sm btn-block']")).click();
			Thread.sleep(2000);
			System.out.println("PASSED:User can click Edit profile link from PD!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot click Edit profile link from PD!!!");
		   Assert.fail();
	   }
}

@Then("User verifies the Edit option is accessible from Personaldata page")
public void user_verifies_the_edit_option_is_accessible_from_personaldata_page() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		String actualtext="Profile";
		String expectedtext=driver.findElement(By.xpath("//li[@class='active']")).getText();
		Assert.assertEquals(expectedtext,actualtext);
		Thread.sleep(2000);
		System.out.println("PASSED:Edit option is accessible from Personaldata page!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Edit option is not accessible from Personaldata page!!!");
		   Assert.fail();
	   }
	 driver.quit();
}
	 
//EditProfile
@When("User clicks Edit profile link")
public void user_clicks_edit_profile_link() {
	try
	   {
		    driver.findElement(By.xpath("//a[text()='Edit profile']")).click();
			Thread.sleep(2000);
			System.out.println("PASSED:User can click Edit profile link!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot click Edit profile link!!!");
		   Assert.fail();
	   }
}
@When("User verifies Firstname, Lastname, Username, code and email is filled by default")
public void user_verifies_firstname_lastname_username_code_and_email_is_filled_by_default() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    
			boolean fname=driver.findElement(By.xpath("//span[text()='vaish']")).isDisplayed();
			System.out.println("PASSED:User can see the firstname filled by default: "+fname);
			boolean lname=driver.findElement(By.xpath("//span[text()='123']")).isDisplayed();
			System.out.println("PASSED:User can see the lastname filled by default: "+lname);
			boolean uname=driver.findElement(By.xpath("//span[text()='vaish123']")).isDisplayed();
			System.out.println("PASSED:User can see the username filled by default: "+uname);
			boolean code=driver.findElement(By.xpath("//span[text()='VAISH123']")).isDisplayed();
			System.out.println("PASSED:User can see the code filled by default: "+code); 
			boolean email=driver.findElement(By.xpath("//span[text()='vaish123@gmail.com']")).isDisplayed();
			System.out.println("PASSED:User can see the email filled by default: "+email); 
			   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: The fields are not filled by default!!!");
		   Assert.fail();
	   }
	 driver.quit();
}
//passwordchange
@When("User clicks on the Edit profile link")
public void user_clicks_on_the_edit_profile_link() {
	try
	   {
		    driver.findElement(By.xpath("//a[text()='Edit profile']")).click();
			Thread.sleep(2000);
			System.out.println("PASSED:User can click Edit profile link!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot click Edit profile link!!!");
		   Assert.fail();
	   }
}
@When("User enters old password {string} in Pass textbox")
public void user_enters_old_password_in_pass_textbox(String string) {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    driver.findElement(By.xpath("//input[@name='password0']")).sendKeys(string);
			Thread.sleep(2000);
			System.out.println("PASSED:User can enter old password in Pass textbox!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot enter old password in Pass textbox!!!");
		   Assert.fail();
	   }
}

@When("User enters new password {string} in NewPassword field")
public void user_enters_new_password_in_new_password_field(String string) {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    driver.findElement(By.xpath("//input[@name='password1']")).sendKeys(string);
			Thread.sleep(2000);
			System.out.println("PASSED:User can enter new password in NewPassword field!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot enter new password in NewPassword field!!!");
		   Assert.fail();
	   }
}

@When("User enters new password {string} in ConfirmPassword field")
public void user_enters_new_password_in_confirm_password_field(String string) {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    driver.findElement(By.xpath("//input[@name='password2']")).sendKeys(string);
			Thread.sleep(2000);
			System.out.println("PASSED:User can enter new password in ConfirmPassword field!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot enter new password in ConfirmPassword field!!!");
		   Assert.fail();
	   }
}

@When("User clicks on Save Settings button")
public void user_clicks_on_save_settings_button() {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		    driver.findElement(By.xpath("//button[@name='apply_change']")).click();
			Thread.sleep(2000);
			System.out.println("PASSED:User can click Save Settings button!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot click Save Settings button!!!");
		   Assert.fail();
	   }
}

@Then("User is displayed with success {string} message")
public void user_is_displayed_with_success_message(String string) {
    // Write code here that turns the phrase above into concrete actions
	 try
	   {
		   
		    String actualtext=string;
			String expectedtext=driver.findElement(By.xpath("//div[text()='Your new profile has been saved']")).getText();
			Assert.assertEquals(expectedtext,actualtext);
			Thread.sleep(2000);
			System.out.println("PASSED:User is displayed with success message!!!");   
	   }
	   catch(Exception e)
	   {
		   System.out.println("EXCEPTION FOUND: Cannot find Success message!!!");
		   Assert.fail();
	   }
	 driver.quit();
}

}
