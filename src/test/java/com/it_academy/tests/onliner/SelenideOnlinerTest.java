package com.it_academy.tests.onliner;

import com.it_academy.tests.onliner.listeners.AllureListener;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SelenideOnlinerTest extends BaseTest {

    @DisplayName("Check That Catalog Items Is Not Empty")
    @Test
    public void testCatalogItemsIsNotEmpty() {

        assertThat(catalogPage.getItemsInsideCatalog())
                .as("Catalog items are empty")
                .isEmpty();
    }

    @DisplayName("Check That 'Computers And Nets' Contains 'Ноутбуки, компьютеры, мониторы', 'Комплектующие',"
            + "'Хранение 'данных', 'Сетевое оборудование'")
    @Test
    public void testComputerAndNetItemsContainsCertainItems() {
        List<String> itemsOfComputersAndNets = catalogPage
                .clickOnCatalogClassifierComputersAndNets()
                .getItemsInsideComputersAndNetsItem();
        assertThat(itemsOfComputersAndNets)
                .as("ComputersAndNets doesn't contain four certain items")
                .contains("Ноутбуки, компьютеры, мониторы", "Комплектующие", "Хранение данных", "Сетевое оборудование");
    }

    @DisplayName("Check That 'Accessories' Contains Information About Min Price")
    @Test
    public void testProductsAndDescriptionInAccessoriesAreNotEmpty() {
        List<String> itemsOfAccessories = catalogPage
                .clickOnCatalogClassifierComputersAndNets()
                .selectCategory()
                .getItemsInsideAccessoriesItem();
        assertThat(itemsOfAccessories)
                .as("Accessories doesn't contain min price")
                .allMatch(i -> i != null)
                .allMatch(i -> i.contains("jjjj"))
                .allMatch(i -> i.contains("р."));
    }
}
