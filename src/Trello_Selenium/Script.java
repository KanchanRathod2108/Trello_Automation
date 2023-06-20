package Trello_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Script {

	    public static void main(String[] args) {
	        // Set the path to the ChromeDriver executable
	        System.setProperty("webdriver.chrome.driver", "C:/Users/Aakash/Downloads/chromedriver_win32 (10)/chromedriver.exe");
          
	        // Launch the Chrome browser
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        // Step 1: Login to Trello
	        driver.get("https://trello.com/login");
	        driver.findElement(By.xpath("//input[@id='user']")).sendKeys("kanchanrathod2023@gmail.com");
	        driver.findElement(By.xpath("//input[@id='login']")).click();
	        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("ABCDEF@12");
	        driver.findElement(By.xpath("//span[text()='Log in']")).click();
	        
	        // Step 2: Create a new board
	        WebElement createBoardButton = driver.findElement(By.xpath("//button[contains(text(), 'Create new board')]"));
	        createBoardButton.click();
	        // Perform steps to create a new board (Enter board name, privacy settings, etc.)

	        // Step 3: Create List A and List B
	        WebElement addListButton = driver.findElement(By.xpath("//span[contains(text(), 'Add a list')]"));
	        addListButton.click();
	        WebElement listA = driver.findElement(By.xpath("//input[@class='list-name-input']"));
	        listA.sendKeys("List A");
	        WebElement addListAButton = driver.findElement(By.xpath("//input[@class='primary mod-list-add-button js-save-edit']"));
	        addListAButton.click();

	        addListButton.click();
	        WebElement listB = driver.findElement(By.xpath("//input[@class='list-name-input']"));
	        listB.sendKeys("List B");
	        WebElement addListBButton = driver.findElement(By.xpath("//input[@class='primary mod-list-add-button js-save-edit']"));
	        addListBButton.click();

	        // Step 4: Add a card to List A and drag it to List B
	        WebElement listAContainer = driver.findElement(By.xpath("//div[@class='list js-list-content']"));
	        WebElement addCardButton = listAContainer.findElement(By.xpath(".//span[contains(text(), 'Add a card')]"));
	        addCardButton.click();
	        WebElement cardTitle = driver.findElement(By.xpath("//textarea[@class='list-card-composer-textarea js-card-title']"));
	        cardTitle.sendKeys("My Card");

	        WebElement addCardToListButton = driver.findElement(By.xpath("//input[@class='primary confirm mod-compact js-add-card']"));
	        addCardToListButton.click();

	        WebElement createdCard = driver.findElement(By.xpath("//a[@class='list-card-title js-card-name']"));

	        Actions builder = new Actions(driver);
	        Action dragAndDrop = builder.clickAndHold(createdCard)
	                .moveToElement(listB)
	                .release()
	                .build();
	        dragAndDrop.perform();

	        // Step 5: Get the x and y coordinates of the moved card
	        int cardXCoordinate = createdCard.getLocation().getX();
	        int cardYCoordinate = createdCard.getLocation().getY();
	        System.out.println("Card's X Coordinate: " + cardXCoordinate);
	        System.out.println("Card's Y Coordinate: " + cardYCoordinate);

	        // Step 6: Logout
	        WebElement profileIcon = driver.findElement(By.xpath("//span[@class='member-initials']"));
	        profileIcon.click();
	        WebElement logoutButton = driver.findElement(By.xpath("//a[contains(text(), 'Log Out')]"));
	        logoutButton.click();

	        // Close the browser
	        driver.quit();
	    }
	}



