package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopPage extends Utility {


    By desktopText = By.xpath("//h2[contains(text(),'Desktops')]");
    By productsPath = By.xpath("//h4/a");
    By dropDownPath = By.xpath("//body[1]/div[2]/div[1]/div[1]/div[3]/div[3]/div[1]/select[1]");
    String sortAToZ = "Name (A - Z)";
    String sortZToA = "Name (Z - A)";
    By productHPLP3065 = By.xpath("//a[contains(text(),'HP LP3065')]");

    By currencyDropdown = By.xpath("//span[normalize-space()='Currency']");

    By poundSterling = By.name("GBP");

    public String getDesktopText() {
        return getTextFromElement(desktopText);
    }

    public void clickOnSortByPosition() {
        clickOnElement(dropDownPath);
    }

    public void selectSortByAToZ() {
        selectByVisibleTextFromDropDown(dropDownPath, sortAToZ);
    }

    public void selectSortByZToA() {
        selectByVisibleTextFromDropDown(dropDownPath, sortZToA);
    }

    public void clickOnHPLP3065() {
        clickOnElement(productHPLP3065);
    }

    public void sortByCurrencyDropdown(){
        mouseHoverToElementAndClick(currencyDropdown);
    }
public void selectPoundSterling(){
        mouseHoverToElementAndClick(poundSterling);
}

    public ArrayList<String> getSortByAlphabeticalSelection() {
        // Get all the products name and stored into array list
        List<WebElement> products = driver.findElements(productsPath);
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        System.out.println(originalProductsName);
        // Select sort by Name Z - A
        selectByVisibleTextFromDropDown(dropDownPath, "Name (Z - A)");
        // After filter Z -A Get all the products name and stored into array list
        products = driver.findElements(productsPath);
        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductsName.add(e.getText());
        }
        //System.out.println(afterSortByZToAProductsName);
        //Assert.assertEquals(afterSortByZToAProductsName, originalProductsName, "Product not sorted into Z to A order");
        return afterSortByZToAProductsName;
    }

    public ArrayList<String> expectedList() {
        // Get all the products name and stored into array list
        List<WebElement> products = driver.findElements(productsPath);
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        return originalProductsName;
    }


}
