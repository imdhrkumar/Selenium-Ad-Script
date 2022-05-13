package PracticePaper;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AddPushUpQuestion {

    public static <Screenshot> void main(String[] args) throws InterruptedException, IOException {

        System.setProperty("webdriver.chrome.driver", "/Users/dhruv-kumar/Documents/Selenium/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        Thread.sleep(2000);

        //launch the URL
        driver.get("https://cdn.adpushup.com/qaTakeHomeTask/");
        Thread.sleep(2000);

        //Get the Current URL
        String currentURL = driver.getCurrentUrl();

        //Current URL Validation
        if(currentURL.contains("https://cdn.adpushup.com/qaTakeHomeTask/"))
        {
            System.out.println("Valid URL is present: Pass");
        }
        else
        {
            System.out.println("Not a valid URL: Fail");
        }

        //Find the first image of the webpage
        WebElement firstImage = driver.findElement(By.xpath("//div[@class='page-body']/div[1]"));

        //Validation, if the image is Displayed or not
        if(firstImage.isDisplayed())
        {
            System.out.println("First Image is successfully Print in the webSite: Pass");
        }
        else
        {
            System.out.println("Throw an error, not present in the webSite: Fail");
        }
        Thread.sleep(2000);

        //If the image is enabled or not
        boolean imageEnabled = firstImage.isEnabled();
       // System.out.println(imageEnabled);

        if(imageEnabled == true)
        {
            System.out.println("Image is enabled: Pass");
        }
        else
        {
            System.out.println("Image is not enabled: Fail");
        }

        //Find out the image size (Dimension)
        Dimension imageSize = firstImage.getSize();
        System.out.println("Size: "+imageSize);

        //Find out the image tax and compare with the expected one
        String givenText = "Box-1";
        String getText = firstImage.getText();
        //System.out.println(getText);

        if(getText.equals(givenText))
        {
            System.out.println("Text has been matched successfully: Pass");
        }
        else
        {
            System.out.println("Text not matched successfully: Fail");
        }

        Thread.sleep(2000);

        //Take Screen Shot
        File topscreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(topscreenshot, new File("/Users/dhruv-kumar/Documents/Selenium/ElementImage.PNG"));
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

        System.out.println("----------------------------------End----------------------------");

        //Scroll Down
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);


        //Find the Second image of the webpage
        WebElement secondImage = driver.findElement(By.xpath("//div[@class='box-unit']/div[1]"));

        //Validation, if the image is Displayed or not
        if(secondImage.isDisplayed())
        {
            System.out.println("Second Image is successfully Print in the webSite: Pass");
        }
        else
        {
            System.out.println("Throw an error, not present in the webSite: Fail");
        }
        Thread.sleep(2000);

        //If the image is enabled or not
        boolean image2Enabled = secondImage.isEnabled();
        // System.out.println(imageEnabled);

        if(image2Enabled == true)
        {
            System.out.println("Image is enabled: Pass");
        }
        else
        {
            System.out.println("Image is not enabled: Fail");
        }

        //Find out the image size (Dimension)
        Dimension image2Size = secondImage.getSize();
        System.out.println("Size: "+image2Size);

        //Find out the image tax and compare with the expected one
        String expectedBottomBox = "Box-2";
        String actualBottomBox = secondImage.getText();
        //System.out.println(expectedBottomBox);

        if(actualBottomBox.equals(expectedBottomBox))
        {
            System.out.println("Text has been matched successfully: Pass");
        }
        else
        {
            System.out.println("Text not matched successfully: Fail");
        }

        Thread.sleep(2000);


        //Take Screen Shot
        File bottomscreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(bottomscreenshot, new File("/Users/dhruv-kumar/Documents/Selenium/ElementImage2.PNG"));
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

        Thread.sleep(2000);

        //Scroll Up
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");

        Thread.sleep(3000);


        driver.close();



    }
}
