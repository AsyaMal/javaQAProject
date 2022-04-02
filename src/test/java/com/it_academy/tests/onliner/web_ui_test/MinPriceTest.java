package com.it_academy.tests.onliner.web_ui_test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class MinPriceTest extends BaseTest {

    @Test
    @DisplayName("Check That 'Accessories' Contains Information About Min Price")
    public void testProductsAndDescriptionInAccessoriesAreNotEmpty() {
        List<String> itemsOfAccessories = catalogPage
                .clickOnCatalogClassifierComputersAndNets()
                .selectCategory()
                .getItemsInsideAccessoriesItem();
        assertThat(itemsOfAccessories)
                .as("Accessories doesn't contain min price")
                .allMatch(i -> i != null)
                .allMatch(i -> i.contains("от"))
                .allMatch(i -> i.contains("р."));
    }

}
