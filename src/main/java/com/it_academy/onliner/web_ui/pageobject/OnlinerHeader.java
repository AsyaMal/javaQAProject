package com.it_academy.onliner.web_ui.pageobject;

import com.codeborne.selenide.Condition;
import com.it_academy.onliner.web_ui.framework.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static java.time.Duration.ofSeconds;

public class OnlinerHeader extends BasePage {
    private static final String MAIN_NAVIGATION_LINK_XPATH_PATTERN =
            "//*[contains(@class, 'main-navigation__text') and contains(text(), 'Каталог')]";
    @Step("Navigate to Catalog")
    public void clickOnMainNavigationLink() {
        $x(MAIN_NAVIGATION_LINK_XPATH_PATTERN)
                .shouldBe(Condition.visible, ofSeconds(60))
                .click();
    }
}