package com.it_academy.onliner.web_ui.pageobject;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.it_academy.onliner.web_ui.framework.BasePage;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;


public class ComputersAndNetsItem extends BasePage {

    private static final ElementsCollection computersAndSetsItems =
            $$x("//*[@class='catalog-navigation-list__category' and @data-id='2']"
                    + "//*[@class='catalog-navigation-list__aside-item']");
    private static final String CATALOG_CLASSIFIER_CATEGORY_XPATH_PATTERN =
            "//*[@class='catalog-navigation-list__aside-title' and contains(text(), '%s')]";
    private static final ElementsCollection accessoriesItems =
            $$x("//div[@class='catalog-navigation-list__aside-title' and contains(text(), 'Комплектующие')"
                    + " and not (contains(text(), 'Комплектующие для'))]"
                    + "//following-sibling::div[@class='catalog-navigation-list__dropdown']"
                    + "//a//*[contains(@class, 'description') and contains(text(), 'товар')]");

    @Step("Select {navigationLink} in ComputersAndNets category")
    public ComputersAndNetsItem selectItemInComputersAndNetsCategory(String navigationLink) {
        $x(format(CATALOG_CLASSIFIER_CATEGORY_XPATH_PATTERN, navigationLink))
                .shouldBe(Condition.visible, ofSeconds(TIME_WAIT))
                .click();
        return new ComputersAndNetsItem();
    }

    @Step("Get items inside Accessories category")
    public List<String> getItemsInsideAccessoriesCategory() {
        return accessoriesItems
                .shouldBe(CollectionCondition.sizeGreaterThan(COLLECTION_SIZE_MIN), ofSeconds(TIME_WAIT))
                .texts();
    }

    @Step("Get items inside ComputersAndNets category")
    public List<String> getItemsInsideComputersAndNetsCategory() {
        return computersAndSetsItems
                .shouldBe(CollectionCondition.sizeGreaterThan(COLLECTION_SIZE_MIN), ofSeconds(TIME_WAIT))
                .texts();
    }
}
