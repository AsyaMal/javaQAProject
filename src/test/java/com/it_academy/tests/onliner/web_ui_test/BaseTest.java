package com.it_academy.tests.onliner.web_ui_test;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.google.common.collect.ImmutableMap;
import com.it_academy.onliner.web_ui.navigation.OnlinerNavigation;
import com.it_academy.onliner.web_ui.pageobject.CatalogPage;
import com.it_academy.onliner.web_ui.pageobject.OnlinerHeader;
import com.it_academy.tests.onliner.listeners.AllureListener;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

public class BaseTest {
    protected OnlinerHeader onlinerHeader = new OnlinerHeader();
    protected CatalogPage catalogPage = new CatalogPage();

    @BeforeAll
    public static void setUp() {
        SelenideLogger
                .addListener("AllureSelenide",
                        new AllureSelenide().screenshots(true).savePageSource(true));
    }
    @BeforeAll
    public static void navigateToOnliner() {
        OnlinerNavigation.navigateToOnlinerHomePage();
    }

    @BeforeEach
        public void navigateToOnlinerCatalog() {
        onlinerHeader.clickOnMainNavigationLink();
    }
}
