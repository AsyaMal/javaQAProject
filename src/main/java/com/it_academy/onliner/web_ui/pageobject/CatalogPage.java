package com.it_academy.onliner.web_ui.pageobject;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.it_academy.onliner.web_ui.framework.BasePage;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.time.Duration.ofSeconds;

public class CatalogPage extends BasePage {

    private final ElementsCollection catalogNavigationClassifiertItems =
            $$x("//li[@class = 'catalog-navigation-classifier__item ']");
    private static final String CATALOG_NAVIGATION_CLASSIFIER_ITEM_COMPUTERS_AND_NETS =
            "//span[contains(text(),'Компьютеры и')]";
    private final ElementsCollection catalogNavigation =
            $$x("//li[@id = 'catalog-navigation-classifier__item ']");

    @Step("Get items inside Catalog")
    public List<String> getItemsInsideCatalog() {
        return catalogNavigationClassifiertItems
                .shouldBe(CollectionCondition.sizeGreaterThan(COLLECTION_SIZE_MIN), ofSeconds(TIME_WAIT))
                .texts();
    }

    @Step("Click on ComputersAndNets")
    public ComputersAndNetsItem clickOnCatalogClassifierComputersAndNets() {
        $x(CATALOG_NAVIGATION_CLASSIFIER_ITEM_COMPUTERS_AND_NETS)
                .shouldBe(Condition.visible, ofSeconds(TIME_WAIT))
                .click();
        return new ComputersAndNetsItem();
    }
}