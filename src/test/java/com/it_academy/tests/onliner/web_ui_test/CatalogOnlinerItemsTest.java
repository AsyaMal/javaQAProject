package com.it_academy.tests.onliner.web_ui_test;

import com.it_academy.onliner.web_ui.pageobject.CatalogPage;
import com.it_academy.onliner.web_ui.pageobject.OnlinerHeader;
import com.it_academy.tests.onliner.listeners.AllureListener;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@Epic("Web Onliner test")
@Feature("Onliner Catalog test")
@Story("Getting items in Catalog")
public class CatalogOnlinerItemsTest extends BaseWebTest {

    protected OnlinerHeader onlinerHeader = new OnlinerHeader();
    protected CatalogPage catalogPage = new CatalogPage();

    @BeforeEach
    public void navigateToOnlinerCatalog() {
        onlinerHeader.clickOnMainNavigationLink("Каталог");
        LOG.info("Catalog is opened");
    }

    @Test
    @DisplayName("Catalog items aren't empty")
    @Description("Check that Catalog items aren't empty")
    @Severity(SeverityLevel.NORMAL)
    public void testCatalogItemsAreNotEmpty() {
        LOG.info("Test started");
        assertThat(catalogPage.getItemsInsideCatalog())
                .as("Catalog items are empty")
                .allMatch(element -> element.isEmpty());
        LOG.info("Test passed");

    }
}
