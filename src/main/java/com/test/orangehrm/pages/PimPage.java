package com.test.orangehrm.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import sun.awt.windows.ThemeReader;
import sun.awt.windows.WBufferStrategy;

import java.nio.charset.StandardCharsets;

public class PimPage {                        // == In "PAGE" CLASS WE STORE:
    /*  Click PIM on the mainpage
        click add button under PIM
        fill the boxes
        click save button
        */
    public PimPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "btnAdd")
    WebElement addButton;

    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "employeeId")
    WebElement employeeId;

    @FindBy(id = "photofile")
    WebElement chooseFile;

    @FindBy(id = "btnSave")
    WebElement saveButton;

    @FindBy(name = "personal[txtEmpFirstName]")
    WebElement validationName;

    @FindBy(name ="personal[txtEmpLastName]")
    WebElement validationLastName;

    @FindBy(name = "personal[txtEmployeeId]")
    WebElement validateEmployeeId;

    @FindBy(xpath = "//input[@id='btnSave']")
    WebElement editButton;

    @FindBy(xpath = "//input[@id='personal_optGender_2']")
    WebElement femaleButton;

    @FindBy(id="personal_cmbNation")
    WebElement nationality;

    @FindBy(id = "personal_cmbMarital")
    WebElement maritualStatus;

    @FindBy(name = "personal[DOB]")
    WebElement dob;


    public void addEmployeeForPIM(String name, String lastName, String employeeId, String uploadFile) throws InterruptedException {
        addButton.click();
        this.firstName.sendKeys(name);
        this.lastName.sendKeys(lastName);
        this.employeeId.sendKeys(employeeId);
        this.chooseFile.sendKeys(uploadFile);
        Thread.sleep(1000);
        saveButton.click();
        Thread.sleep(1000);
    }
    public String validateFirstName(){
        return validationName.getAttribute("value");
    }
    public String validateLastName(){
        return validationLastName.getAttribute("value");
    }
    public boolean validateEmployeeId(String employeeId){
        return validateEmployeeId.getAttribute("value").endsWith(employeeId);
    }
    public void editPersonalDetails(String nation, String dateOfBirth, String maritualStatus){
        editButton.click();
        femaleButton.click();
        BrowserUtils.selectBy(nationality,nation,"text");
        dob.clear();
        this.dob.sendKeys(dateOfBirth);
        BrowserUtils.selectBy(this.maritualStatus, maritualStatus,"text");
        saveButton.click();
    }
    public String validateTheNationality(){
        Select select=new Select(nationality);
        return select.getFirstSelectedOption().getText().trim();


    }
}
