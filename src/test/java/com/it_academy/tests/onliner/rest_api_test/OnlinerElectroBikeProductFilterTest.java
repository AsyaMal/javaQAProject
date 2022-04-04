package com.it_academy.tests.onliner.rest_api_test;

import com.it_academy.onliner.rest_api.pojo.ElectroBikeProduct;
import com.it_academy.onliner.rest_api.service.ElectroBikeService;
import com.it_academy.onliner.rest_api.utils.ApiOnlinerEndpointPropertyUtils;
import com.it_academy.tests.onliner.listeners.AllureListener;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@ExtendWith({AllureListener.class})
@Epic("Api Onliner test")
@Feature("Search ElectroBike product")
@Story("Filter ElectroBike product by 'Xiaomi'")
public class OnlinerElectroBikeProductFilterTest extends BaseApiTest {

    ElectroBikeService electroBikeService = new ElectroBikeService();
    List<ElectroBikeProduct> electroBikeProducts;

    @Test
    @DisplayName("ElectroBike products filtered by name")
    @Description("Check that ElectroBike products have been filtered by 'Xiaomi'")
    @Severity(SeverityLevel.NORMAL)
    public void testElectroBikeProductFilteredByName() {
        LOG.info("Test started");
        electroBikeProducts = electroBikeService
                .getElectroBikeProduct(ApiOnlinerEndpointPropertyUtils.getElectroBikeProductFilter());
        assertThat(electroBikeProducts)
                .as("Some ElectroBike product has been filtered by another filter")
                .allMatch(product -> product.getFull_name().contains("Xiaomi"));
        LOG.info("Test passed");
    }
}

