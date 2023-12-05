package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.DesktopPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.ProductPage;
import com.tutorialsninja.pages.ShoppingCartPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DesktopsTest extends BaseTest {
    HomePage homePage = new HomePage();
    DesktopPage desktopPage = new DesktopPage();
    ProductPage productPage = new ProductPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    //1. Create class “DesktopsTest”
    //Write the following Test:
    //1.Test name verifyProductArrangeInAlphabeticalOrder()
    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        //1.1 Mouse hover on Desktops Tab.and click
        homePage.mouseHoverAndClickOnDesktop();
        //1.2 Click on “Show All Desktops”
        homePage.selectMenu("Show All Desktops");
        //1.3 Select Sort By position "Name: Z to A"
        desktopPage.clickOnSortByPosition();
        //1.4 Verify the Product will arrange in Descending order.
        List<String> expectedOrder = desktopPage.expectedList();
        List<String> actualOrder = desktopPage.getSortByAlphabeticalSelection();
        System.out.println("expected: " + expectedOrder);
        System.out.println("actual: " + actualOrder);
        Assert.assertEquals(actualOrder, expectedOrder, "Product not sorted into Z to A order");

    }

    //2. Test name verifyProductAddedToShoppingCartSuccessFully()
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Mouse hover on Currency Dropdown and click
        desktopPage.sortByCurrencyDropdown();
        Thread.sleep(2000);
        //2.2 Mouse hover on £Pound Sterling and click
        desktopPage.selectPoundSterling();
        //2.3 Mouse hover on Desktops Tab.
        homePage.mouseHoverAndClickOnDesktop();
        //2.4 Click on “Show All Desktops”
        homePage.selectMenu("Show All Desktops");
        //2.5 Select Sort By position "Name: A to Z"
        desktopPage.clickOnSortByPosition();
        //2.6 Select product “HP LP3065”
        desktopPage.clickOnHPLP3065();
        //2.7 Verify the Text "HP LP3065"
        String expectedProduct = "HP LP3065";
        String actualProduct = productPage.getHPLP3065text();
        Assert.assertEquals(actualProduct, expectedProduct, "HP LP3065 not displayed");
        //2.8 Select Delivery Date "2023-11-27"
        productPage.selectDate("30", "November", "2022");
        //2.9.Enter Qty "1” using Select class.
        Thread.sleep(2000);
        productPage.clearAndAddQuantity("1");
        //2.10 Click on “Add to Cart” button
        productPage.clickAddToCart();
        //2.11 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        Thread.sleep(2000);
        Assert.assertEquals(productPage.isSuccessMessageAppearing(), "Success: You have added HP LP3065 to your shopping cart!" + "\n×");
        //2.12 Click on link “shopping cart” display into success message
        productPage.clickOnShoppingCart();
        //2.13 Verify the text "Shopping Cart"
        Assert.assertTrue(shoppingCartPage.isShoppingCartAppearing(), "Shopping Cart Doesn't Appear");
        //2.14 Verify the Product name "HP LP3065"
        Assert.assertEquals(shoppingCartPage.getProductName(), "HP LP3065", "Product Name Doesn't appear");
        //2.15 Verify the Delivery Date "2023-11-27"
        Assert.assertTrue(shoppingCartPage.isDeliveryDateAppearing(), "Delivery Date Doesn't Appear");
        //2.16 Verify the Model "Product21"
        Assert.assertEquals(shoppingCartPage.getModelText(), "Product 21", "Model Name Doesn't appear");
        //2.17 Verify the Today "£74.73"
        Thread.sleep(2000);
        Assert.assertEquals(shoppingCartPage.getTotalText(), "£74.73", "Total Doesn't appear");
    }
}
