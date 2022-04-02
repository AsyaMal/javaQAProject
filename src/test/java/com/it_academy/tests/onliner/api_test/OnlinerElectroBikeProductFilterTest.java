package com.it_academy.tests.onliner.api_test;

import com.it_academy.onliner.rest_api.utils.EndpointPropertyUtils;
import com.it_academy.tests.onliner.listeners.AllureListener;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
@ExtendWith({AllureListener.class})
@Epic("Api test")
public class OnlinerElectroBikeProductFilterTest extends BaseApiTest {
    @Test
    @DisplayName("Check that products have been filtered correctly")
//    @Description("Check that ElectroBike products have been filtered by 'Xiaomi'")
    @Severity(SeverityLevel.NORMAL)
    public void testElectroBikeProductFilteredByName() {
        electroBikeProducts = electroBikeService.getElectroBikeProductFilter(EndpointPropertyUtils.getElectroBikeProductFilter());
        assertThat(electroBikeProducts)
                .as("Some ElectroBike product has been filtered by another filter")
                .allMatch(product -> product.getFull_name().contains("Xiaomi"));
    }
}
