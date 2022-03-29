package com.it_academy.tests.onliner;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.it_academy.onliner.navigation.OnlinerNavigation;
import com.it_academy.onliner.pageobject.CatalogPage;
import com.it_academy.onliner.pageobject.OnlinerHeader;

import com.it_academy.tests.onliner.listeners.AllureListener;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;

@ExtendWith(AllureListener.class)
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
