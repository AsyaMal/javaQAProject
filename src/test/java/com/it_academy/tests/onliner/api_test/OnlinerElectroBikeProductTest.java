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
public class OnlinerElectroBikeProductTest extends BaseApiTest {

    @Test
    @DisplayName("Check that name of products is not empty")
    @Severity(SeverityLevel.NORMAL)
    public void testEachElectroBikeProductHasName() {
        electroBikeProducts = electroBikeService.getElectroBikeProduct(EndpointPropertyUtils.getElectroBikeProduct());
        assertThat(electroBikeProducts)
                .as("Some ElectroBike product has no name")
                .allMatch(product -> product.getFull_name() != null);
    }
}
