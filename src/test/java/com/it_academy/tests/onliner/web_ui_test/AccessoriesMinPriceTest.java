package com.it_academy.tests.onliner.web_ui_test;

import com.it_academy.onliner.web_ui.pageobject.CatalogPage;
import com.it_academy.onliner.web_ui.pageobject.OnlinerHeader;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@Epic("Web Onliner test")
@Feature("Onliner Accessories test")
@Story("Getting items in Accessories category")
public class AccessoriesMinPriceTest extends BaseWebTest {

    protected OnlinerHeader onlinerHeader = new OnlinerHeader();
    protected CatalogPage catalogPage = new CatalogPage();

    @BeforeEach
    public void navigateToOnlinerCatalog() {
        onlinerHeader.clickOnMainNavigationLink("Каталог");
    }

    @Test
    @DisplayName("Accessories contains information about min price")
    @Description("Check that Accessories items contain min price")
    @Severity(SeverityLevel.NORMAL)
    public void testProductsAndDescriptionInAccessoriesAreNotEmpty() {
        LOG.info("Test started");
        List<String> itemsOfAccessories = catalogPage
                .clickOnCatalogClassifierComputersAndNets()
                .selectItemInComputersAndNetsCategory("Комплектующие")
                .getItemsInsideAccessoriesCategory();
        assertThat(itemsOfAccessories)
                .as("Accessories doesn't contain min price")
                .allMatch(AccessoriesMinPriceTest::isElementContainsNeededText);
        LOG.info("Test passed");
    }

    private static boolean isElementContainsNeededText(String element) {
        return element.contains("от") && element.contains("р.");
    }
}
