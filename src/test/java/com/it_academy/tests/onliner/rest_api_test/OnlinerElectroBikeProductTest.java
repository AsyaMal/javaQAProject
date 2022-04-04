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
@Story("Search ElectroBike product names aren't empty")
public class OnlinerElectroBikeProductTest extends BaseApiTest {

    protected ElectroBikeService electroBikeService = new ElectroBikeService();
    protected List<ElectroBikeProduct> electroBikeProducts;

    @Test
    @DisplayName("ElectroBike products have name")
    @Description("Check that ElectroBike product names aren't empty")
    @Severity(SeverityLevel.NORMAL)
    public void testEachElectroBikeProductHasName() {
        LOG.info("Test started");
        electroBikeProducts = electroBikeService.getElectroBikeProduct(ApiOnlinerEndpointPropertyUtils
                .getElectroBikeProduct());
        assertThat(electroBikeProducts)
                .as("Some ElectroBike product has no name")
                .allMatch(product -> !product.getFull_name().isEmpty());
        LOG.info("Test passed");
    }
}
