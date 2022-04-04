package com.it_academy.onliner.web_ui.navigation;

import com.it_academy.onliner.web_ui.utils.WebOnlinerPropertyUtils;
import com.it_academy.onliner.web_ui.pageobject.OnlinerHomePage;

public class OnlinerNavigation {

    public static OnlinerHomePage navigateToOnlinerHomePage() {
        new OnlinerHomePage().navigate(WebOnlinerPropertyUtils.getOnlinerHomePageURL());
        return new OnlinerHomePage();
    }
}