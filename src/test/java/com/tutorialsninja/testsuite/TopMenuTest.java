package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.ComponentsPage;
import com.tutorialsninja.pages.DesktopPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LaptopAndNotebookPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TopMenuTest extends BaseTest {

    HomePage homePage = new HomePage();
    DesktopPage desktopPage = new DesktopPage();
    LaptopAndNotebookPage laptopAndNotebookPage = new LaptopAndNotebookPage();
    ComponentsPage componentsPage = new ComponentsPage();


    //1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
    //1.2 This method should click on the menu whatever name is passed as parameter.
    //Write the following Test:
    //1. verifyUserShouldNavigateToDesktopsPageSuccessfully()
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        //1.1 Mouse hover on “Desktops” Tab and click
        homePage.mouseHoverAndClickOnDesktop();
        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        homePage.selectMenu("Show All Desktops");
        String expectedDesktop = "Desktops";
        String actualDesktop = desktopPage.getDesktopText();
        //1.3 Verify the text ‘Desktops’
        Assert.assertEquals(actualDesktop, expectedDesktop, "Desktop not displayed");
    }

    //2. verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        homePage.mouseHoverAndClickOnLaptopsAndNotebooks();
        //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        homePage.selectMenu("Show All Laptops & Notebooks");
        String expectedLaptopsAndNotebooks = "Laptops & Notebooks";
        String actualLaptopsAndNotebooks = laptopAndNotebookPage.getLaptopAndNoteBookText();
        //2.3 Verify the text ‘Laptops & Notebooks’
        Assert.assertEquals(actualLaptopsAndNotebooks, expectedLaptopsAndNotebooks, "Laptops And Notebooks not displayed");
    }

    //3. verifyUserShouldNavigateToComponentsPageSuccessfully()
    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() throws InterruptedException {
        //3.1 Mouse hover on “Components” Tab and click
        Thread.sleep(2000);
        homePage.mouseHoverAndClickOnComponents();
        //3.2 call selectMenu method and pass the menu = “Show All Components”
        homePage.selectMenu("Show All Components");
        String expectedComponents = "Components";
        String actualComponents = componentsPage.getComponentsText();
        //3.3 Verify the text ‘Components’
        Assert.assertEquals(actualComponents,expectedComponents,"Components Page Not displayed");
    }
}
