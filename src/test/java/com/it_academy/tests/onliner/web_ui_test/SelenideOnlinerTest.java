package com.it_academy.tests.onliner.web_ui_test;

import com.it_academy.tests.onliner.listeners.AllureListener;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@ExtendWith({AllureListener.class})
@Epic("Onliner tests")

public class SelenideOnlinerTest extends BaseTest {

    @Test
    @DisplayName("Check that catalog items aren't empty")
    @Severity(SeverityLevel.NORMAL)
     public void testCatalogItemsIsNotEmpty() {

        assertThat(catalogPage.getItemsInsideCatalog())
                .as("Catalog items are empty")
                .allMatch(element -> !element.isEmpty());
//                .isEmpty();
    }

}
