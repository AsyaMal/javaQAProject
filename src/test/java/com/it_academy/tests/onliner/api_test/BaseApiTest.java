package com.it_academy.tests.onliner.api_test;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.it_academy.onliner.rest_api.model.ElectroBikeProduct;
import com.it_academy.onliner.rest_api.service.ElectroBikeService;
import com.it_academy.tests.onliner.listeners.AllureListener;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;


public class BaseApiTest {
    ElectroBikeService electroBikeService = new ElectroBikeService();
    List<ElectroBikeProduct> electroBikeProducts;

    @BeforeAll
    public static void setUp() {
        SelenideLogger
                .addListener("AllureSelenide",
                        new AllureSelenide().screenshots(true).savePageSource(true));
    }

}
