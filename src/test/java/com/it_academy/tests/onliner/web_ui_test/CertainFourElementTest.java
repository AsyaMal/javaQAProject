package com.it_academy.tests.onliner.web_ui_test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CertainFourElementTest extends BaseTest{
    @Test
    @DisplayName("Check That 'Computers And Nets' Contains 'Ноутбуки, компьютеры, мониторы', 'Комплектующие',"
            + "'Хранение 'данных', 'Сетевое оборудование'")
        public void testComputerAndNetItemsContainsCertainItems() {
        List<String> itemsOfComputersAndNets = catalogPage
                .clickOnCatalogClassifierComputersAndNets()
                .getItemsInsideComputersAndNetsItem();

        assertThat(itemsOfComputersAndNets)
                .as("ComputersAndNets doesn't contain four certain items")
                .contains("Ноутбуки, компьютеры, мониторы", "Комплектующие", "Хранение данных", "Сетевое оборудование");
    }
}
