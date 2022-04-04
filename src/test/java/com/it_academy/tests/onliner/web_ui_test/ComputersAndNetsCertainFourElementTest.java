package com.it_academy.tests.onliner.web_ui_test;

import com.it_academy.onliner.web_ui.pageobject.CatalogPage;
import com.it_academy.onliner.web_ui.pageobject.OnlinerHeader;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@Epic("Web Onliner test")
@Feature("Onliner ComputersAndNets test")
@Story("Getting items in ComputersAndNets category")
public class ComputersAndNetsCertainFourElementTest extends BaseWebTest {

    protected OnlinerHeader onlinerHeader = new OnlinerHeader();
    protected CatalogPage catalogPage = new CatalogPage();

    @BeforeEach
    public void navigateToOnlinerCatalog() {
        onlinerHeader.clickOnMainNavigationLink("Каталог");
    }

    @Test
    @DisplayName("Check that 'Computers And Nets' contains 'Ноутбуки, компьютеры, мониторы', 'Комплектующие',"
            + "'Хранение 'данных', 'Сетевое оборудование'")
    @Description("ComputersAndNets category contains four certain items")
    @Severity(SeverityLevel.NORMAL)
    public void testComputersAndNetsItemsContainsCertainItems() {
        List<String> list = new ArrayList<>(Arrays.asList("Ноутбуки, компьютеры, мониторы", "Комплектующие",
                "Хранение данных", "Сетевое оборудование"));
        LOG.info("Test started");
        List<String> itemsOfComputersAndNets = catalogPage
                .clickOnCatalogClassifierComputersAndNets()
                .getItemsInsideComputersAndNetsCategory();
        assertThat(itemsOfComputersAndNets)
                .as("ComputersAndNets doesn't contain four certain items")
                .containsAll(list);
        LOG.info("Test passed");
    }
}